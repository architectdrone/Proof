import re
import sys
from antlr4 import *
import requests
from XMLLexer import XMLLexer
from XMLParser import XMLParser

def main(argv):
    with open("my_xml.xml") as f:
        input_stream = InputStream(f.read())
        lexer = XMLLexer(input_stream)
        stream = CommonTokenStream(lexer)
        parser = XMLParser(stream)
        tree = parser.document()
        #print(tree)
        print_tree(tree)
        print_simplified_tree(simplify_tree(tree))

def get_simple_tree(input):
    input_stream = InputStream(input)
    lexer = XMLLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = XMLParser(stream)
    tree = parser.document()
    return simplify_tree(tree)

def compare_documents(a, b):
    print("=====ORIGINAL=====")
    original = get_simple_tree(a)
    print_simplified_tree(original)
    print("=====MODIFIED=====")
    modified = get_simple_tree(b)
    print_simplified_tree(modified)
    to_send = {
        'original': original,
        'modified': modified
    }
    response = requests.get("http://localhost:8080/diff", json=to_send)
    result = response.json()
    
    header = '\t<head>\n\t\t<link rel="stylesheet" href="proof_html_stylesheet.css">\n\t\t<script type="text/javascript" src="domarrow.js"></script>\n\t\t<link rel="stylesheet" href="domarrow.css">\n\t</head>'
    return f"<html>\n{header}\n\t<body>\n{display_unparsed_difftree(unparse_difftree(result, 'NONE'))}\n\t</body></html>"
    return display_unparsed_difftree(unparse_difftree(result))

def unparse_difftrees(trees, parent_ref_type):
    return [unparse_difftree(tree, parent_ref_type) for tree in trees]

def unparse_difftree(tree, parent_ref_type):
    string = ""
    if tree['label'] == "DOCUMENT":
        string += "!!NEWLINE!!".join(unparse_difftrees(tree['children'], tree['referenceType']))
    elif tree['label'] == "PROLOG":
        string += "<?xml"
        unparsed_children = unparse_difftrees(tree['children'], tree['referenceType'])
        if len(unparsed_children) > 0:
            string+= ' '
            string+= ' '.join(unparsed_children)
        string+="?>"
    elif tree['label'] == "ATTRIBUTE":
        string+=tree['value']
        string+="="
        string+=unparse_difftree(tree['children'][0], tree['referenceType'])
    elif tree['label'] == "ATTRIBUTE_VALUE":
        string = tree['value']
    elif tree['label'] == 'ELEMENT':
        tag = tree['value']
        string += "<"
        string += tag
        
        requires_tabdown = False
        attributes = [i for i in tree['children'] if i['label'] == 'ATTRIBUTE']
        if len(attributes) > 0:
            all_difftrees_string = " ".join(unparse_difftrees(attributes, tree['referenceType']))
            if len(all_difftrees_string) < 40:
                string += " "
                string += all_difftrees_string
            else:
                string += "!!NEWLINE!!"
                string += "!!TABUP!!"
                string += "!!TABUP!!"
                string += "!!NEWLINE!!".join(unparse_difftrees(attributes, tree['referenceType']))
                string += "!!TABDOWNAFTER!!"
                string += "!!TABDOWNAFTER!!"
        
        content = [i for i in tree['children'] if i['label'] != 'ATTRIBUTE']
        if len(content) > 0:
            string += ">"
            if len(content) > 1:
                string += "!!NEWLINE!!"
                string += "!!TABUP!!"
                string += "!!NEWLINE!!".join(unparse_difftrees(content, tree['referenceType']))
                string += "!!NEWLINE!!"
                string += "!!TABDOWN!!"
            else:
                string += "!!NEWLINE!!".join(unparse_difftrees(content, tree['referenceType']))
            string += "<"
            string += "/"
            string += tag
            string += ">"
        else:
            string += "/>"
    elif tree['label'] == 'CHARDATA':
        string = tree['value']
    elif tree['label'] == 'COMMENT':
        string += "<!--"
        string += tree['value']
        string += "-->"
    else:
        raise RuntimeError
    
    if tree['referenceType'] == parent_ref_type:
        return wrap_string(string, "NONE", tree['oldValue'], tree['moveId'])
    else:
        return wrap_string(string, tree['referenceType'], tree['oldValue'], tree['moveId'])

CREATE_STYLE_START = '<span class="create">'
DELETE_STYLE_START = '<span class="delete">'
MOVE_TO_STYLE_START = '<span class="move_to">'
MOVE_FROM_STYLE_START = '<span class="move_from">'

def create_move_from_arrow_anchor(move_id):
    return f'<span id="move_from_{move_id}"/>'
def create_move_to_arrow_anchor(move_id):
    return f'<span id="move_to_{move_id}"/>'

def arrow_start_command_to_tag(match : re.Match):
    return create_move_from_arrow_anchor(match.group(1))
def arrow_end_command_to_tag(match : re.Match):
    return create_move_to_arrow_anchor(match.group(1))
def display_unparsed_difftree(unparsed_difftree):
    lines = unparsed_difftree.split("!!NEWLINE!!")
    lines_to_return = []
    tab_level = 0
    moves = max([int(i) for i in re.findall("!!ARROWORIGIN(.*?)!!", unparsed_difftree)])
    create_level = 0
    delete_level = 0
    move_to_level = 0
    move_from_level = 0
    style_list = []
    for line in lines:
        style_starter = ''.join(style_list)
        tab_level+=line.count("!!TABUP!!")
        tab_level-=line.count("!!TABDOWN!!")
        tabdown_after = line.count("!!TABDOWNAFTER!!")
        line = line.replace("&", "&amp;")
        line = line.replace("<", "&lt;")
        line = line.replace(">", "&gt;")
        
        line = line.replace("!!TABUP!!", "")
        line = line.replace("!!TABDOWN!!", "")
        line = line.replace("!!TABDOWNAFTER!!", "")
        line = re.sub("!!ARROWORIGIN(.*?)!!", arrow_start_command_to_tag, line)
        line = re.sub("!!ARROWEND(.*?)!!", arrow_end_command_to_tag, line)
        for i in re.finditer(r'!!(.*?)!!', line):
            if "END" in i.group():
                style_list = style_list[:-1]
            elif i.group() == BEGIN_CREATE:
                style_list.append(CREATE_STYLE_START)
            elif i.group() == BEGIN_DELETE:
                style_list.append(DELETE_STYLE_START)
            elif i.group() == BEGIN_MOVE_TO:
                style_list.append(MOVE_TO_STYLE_START)
            elif i.group() == BEGIN_MOVE_FROM:
                style_list.append(MOVE_FROM_STYLE_START)
        line = line.replace(BEGIN_CREATE,    CREATE_STYLE_START)
        line = line.replace(BEGIN_DELETE,    DELETE_STYLE_START)
        line = line.replace(BEGIN_MOVE_TO,   MOVE_TO_STYLE_START)
        line = line.replace(BEGIN_MOVE_FROM, MOVE_FROM_STYLE_START)
        line = line.replace(END_CREATE, '</span>')
        line = line.replace(END_DELETE, '</span>')
        line = line.replace(END_MOVE_TO, '</span>')
        line = line.replace(END_MOVE_FROM, '</span>')
        style_ender = "</span>"*len(style_list)
        tabs = "    "*tab_level
        
        lines_to_return .append(f'\t\t<p style="text-indent:{50*tab_level}px">{style_starter}{line}{style_ender}</p>') 
        tab_level-=tabdown_after
    document = "\n".join(lines_to_return)
    for i in range(moves+1):
        document += f'\n\t\t<connection to="#move_to_{i}" from="#move_from_{i}" fromX="0" toX="0" fromY="0.5" toY="0.5" tail></connection>'
    return document

BEGIN_CREATE = "!!BEGINCREATE!!"
BEGIN_DELETE = "!!BEGINDELETE!!"
BEGIN_MOVE_TO = "!!BEGINMOVETO!!"
BEGIN_MOVE_FROM = "!!BEGINMOVEFROM!!"
BEGIN_MODIFY = "!!BEGINMODIFY!!"
BEGIN_STRIKE = "!!BEGINSTRIKE!!"
END_CREATE = "!!ENDCREATE!!"
END_DELETE = "!!ENDDELETE!!"
END_MOVE_TO = "!!ENDMOVETO!!"
END_MOVE_FROM = "!!ENDMOVEFROM!!"
END_MODIFY = "!!ENDMODIFY!!"
END_STRIKE = "!!ENDSTRIKE!!"
ARROW_ORIGIN = "!!ARROWORIGINXXX!!"
ARROW_END = "!!ARROWENDXXX!!"

def wrap_string(string, modifier, oldValue, move_id):
    if modifier == "NONE":
        return string
    elif modifier == "CREATE":
        return f'{BEGIN_CREATE}{string}{END_CREATE}'
    elif modifier == "DELETE":
        return f'{BEGIN_DELETE}{string}{END_DELETE}'
    elif modifier == "MOVE_TO":
        return f'{ARROW_ORIGIN.replace("XXX", str(move_id))}{BEGIN_MOVE_TO}{string}{END_MOVE_TO}'
    elif modifier == "MOVE_FROM":
        return f'{ARROW_END.replace("XXX", str(move_id))}{BEGIN_MOVE_FROM}{string}{END_MOVE_FROM}'
    elif modifier == "MODIFY":
        return f"{BEGIN_MODIFY}{BEGIN_STRIKE}{oldValue}{END_STRIKE}{string}{END_MODIFY}"
    raise RuntimeError

def print_tree(tree, t = 0):
    tabs = '\t'*t
    if hasattr(tree, "symbol"):
        print(f"{tabs}{type(tree)} {tree.symbol.text}")
    else:
        print(f"{tabs}{type(tree)}")
    if hasattr(tree, "children"):
        for i in interesting_nodes(tree.children):
            print_tree(i, t+1)

def print_difftree(tree, t = 0):
    tabs = '\t'*t
    to_print = f"{tabs}[{tree['referenceType']}] {tree['label']}"
    if tree['oldValue'] != None:
        to_print += f": {tree['oldValue']} => {tree['value']}"
    elif tree['value'] != '':
        to_print += f": {tree['value']}"
    print(to_print)
    for i in tree['children']:
        print_difftree(i, t+1)

def extract_text_from_node(tree):
    return tree.symbol.text

def simplify_list_of_trees(trees):
    return [simplify_tree(i) for i in trees if is_interesting_node(i)]

def simplify_tree(tree):
    label = "foo"
    value = ""
    check_children = True
    children = []
    if isinstance(tree, XMLParser.DocumentContext):
        label = "DOCUMENT"
    elif isinstance(tree, XMLParser.PrologContext):
        label = "PROLOG"
    elif isinstance(tree, XMLParser.AttributeContext):
        label = "ATTRIBUTE"
        interesting_children = [i for i in tree.children if is_interesting_node(i)]
        value = extract_text_from_node(interesting_children[0])
        children = [{
            'label': "ATTRIBUTE_VALUE",
            'value': extract_text_from_node(interesting_children[1]),
            'children': []
        }]
    elif isinstance(tree, XMLParser.ElementContext):
        label = "ELEMENT"
        interesting_children = [i for i in tree.children if is_interesting_node(i)]
        value = extract_text_from_node(interesting_children[0])
        i = 0
        while i != len(interesting_children):
            if isinstance(interesting_children[i],XMLParser.ContentContext):
                interesting_children = interesting_children[:i] + interesting_children[i].children + interesting_children[i+1:]
            i+=1
        children = simplify_list_of_trees(interesting_children[1:-1])
        check_children = False
    elif isinstance(tree, XMLParser.ContentContext):
        label = "CONTENT"
    elif isinstance(tree, XMLParser.ChardataContext):
        label = "CHARDATA"
        value = extract_text_from_node(tree.children[0])
        check_children = False
    elif isinstance(tree, TerminalNode) and extract_text_from_node(tree).strip()[:4]:
        label = "COMMENT"
        value = extract_text_from_node(tree)[4:-3]
    else:
        raise Exception
    if children == [] and check_children:
        children = simplify_list_of_trees(tree.children) if hasattr(tree, "children") else []
    return {
        'label': label,
        'value': value,
        'children' : children
    }

def print_simplified_tree(simple_tree, t = 0):
    tabs = '\t'*t
    print(f"{tabs}{simple_tree['label']}:{simple_tree['value']}")
    for i in simple_tree['children']:
        print_simplified_tree(i, t+1)

def is_interesting_node(tree):
    boring_values = ['=', '<', '>', '/>', '<?xml', '<?', '?>', '<EOF>', '/', '']
    if hasattr(tree, 'symbol'):
        if tree.symbol.text.strip() in boring_values:
            return False
    elif hasattr(tree, 'children') and len(tree.children) == 1:
        return is_interesting_node(tree.children[0])
    return True

def interesting_nodes(trees):
    boring_values = ['=', '<', '>', '/>', '<?xml', '<?', '?>', '<EOF>', '/']
    to_return = []
    for tree in trees:
        if not is_interesting_node(tree):
            continue
        to_return.append(tree)
    return to_return

if __name__ == '__main__':
    with open("my_xml.xml", "r") as f1:
        with open("my_xml2.xml", "r") as f2:
            with open("my_html_output.html", "w+") as o:
                original = f1.read()
                modified = f2.read()
                o.write(compare_documents(original, modified))