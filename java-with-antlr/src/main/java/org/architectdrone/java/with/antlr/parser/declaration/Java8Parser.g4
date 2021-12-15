/*
 * [The "BSD license"]
 *  Copyright (c) 2014 Terence Parr
 *  Copyright (c) 2014 Sam Harwell
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions
 *  are met:
 *
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. The name of the author may not be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 *  IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 *  IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 *  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 *  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 *  THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * A Java 8 grammar for ANTLR 4 derived from the Java Language Specification
 * chapter 19.
 *
 * NOTE: This grammar results in a generated parser that is much slower
 *       than the Java 7 grammar in the grammars-v4/java directory. This
 *     one is, however, extremely close to the spec.
 *
 * You can test with
 *
 *  $ antlr4 Java8.g4
 *  $ javac *.java
 *  $ grun Java8 compilationUnit *.java
 *
 * Or,
~/antlr/code/grammars-v4/java8 $ java Test .
/Users/parrt/antlr/code/grammars-v4/java8/./Java8BaseListener.java
/Users/parrt/antlr/code/grammars-v4/java8/./Java8Lexer.java
/Users/parrt/antlr/code/grammars-v4/java8/./Java8Listener.java
/Users/parrt/antlr/code/grammars-v4/java8/./Java8Parser.java
/Users/parrt/antlr/code/grammars-v4/java8/./Test.java
Total lexer+parser time 30844ms.
 */
parser grammar Java8Parser;

options {
    tokenVocab=Java8Lexer;
}

@header {
package org.architectdrone.java.with.antlr.parser.implementation;
}
/*
 * Productions from §3 (Lexical Structure)
 */

//LITERAL
literal
	:	IntegerLiteral
	|	FloatingPointLiteral
	|	BooleanLiteral
	|	CharacterLiteral
	|	StringLiteral
	|	NullLiteral
	;

/*
 * Productions from §4 (Types, Values, and Variables)
 */

//TYPE
primitiveType
	:	annotation* numericType
	|	annotation* 'boolean'
	;

//TYPE
numericType
	:	integralType
	|	floatingPointType
	;

//TYPE
integralType
	:	'byte'
	|	'short'
	|	'int'
	|	'long'
	|	'char'
	;

//TYPE
floatingPointType
	:	'float'
	|	'double'
	;

//TYPE
referenceType
	:	classOrInterfaceType
	|	typeVariable
	|	arrayType
	;

//TYPE
classOrInterfaceType
	:	(	classType_lfno_classOrInterfaceType
		|	interfaceType_lfno_classOrInterfaceType
		)
		(	continuedClassOrInterfaceType
		)*
	;

continuedClassOrInterfaceType
    : classType_lf_classOrInterfaceType
    | interfaceType_lf_classOrInterfaceType
    ;

//TYPE_QUALIFIER_ELEMENT (or TYPE)
classType
	:	annotation* Identifier typeArguments?
	|	classOrInterfaceType '.' annotation* Identifier typeArguments?
	;

//TYPE_QUALIFIER_ELEMENT
classType_lf_classOrInterfaceType
	:	'.' annotation* Identifier typeArguments?
	;

//TYPE_QUALIFIER_ELEMENT
classType_lfno_classOrInterfaceType
	:	annotation* Identifier typeArguments?
	;

//TYPE
interfaceType
	:	classType
	;

//TYPE_QUALIFIER_ELEMENT
interfaceType_lf_classOrInterfaceType
	:	classType_lf_classOrInterfaceType
	;

//TYPE_QUALIFIER_ELEMENT
interfaceType_lfno_classOrInterfaceType
	:	classType_lfno_classOrInterfaceType
	;

//TYPE_QUALIFIER_ELEMENT
typeVariable
	:	annotation* Identifier
	;

//TYPE
arrayType
	:	primitiveType dims
	|	classOrInterfaceType dims
	|	typeVariable dims
	;

//DIMS
dims
	:	annotatedDim (annotatedDim)*
	;

annotatedDim
    : annotation* dim
    ;

dim
    :   '[' ']'
    ;

//TYPE_PARAMETER
typeParameter
	:	typeParameterModifier* Identifier typeBound?
	;

//TYPE_PARAMETER
typeParameterModifier
	:	annotation
	;

//TYPE_PARAMETER
typeBound
	:	'extends' typeVariable
	|	'extends' classOrInterfaceType additionalBound*
	;

//TYPE_PARAMETER
additionalBound
	:	'&' interfaceType
	;

//TYPE_ARGUMENT_LIST
typeArguments
	:	'<' typeArgumentList '>'
	;

//TYPE_ARGUMENT_LIST
typeArgumentList
	:	typeArgument (',' typeArgument)*
	;

//TYPE_ARGUMENT_LIST
typeArgument
	:	referenceType
	|	wildcard
	;

//WILDCARD
wildcard
	:	annotation* '?' wildcardBounds?
	;

//WILDCARD_SUPER, WILDCARD_EXTENDS
wildcardBounds
	:	wildcardExtends
	|	'super' referenceType
	;

wildcardExtends
    : 'extends' referenceType
    ;

/*
 * Productions from §6 (Names)
 */

//QUALIFIER
packageName
	:	Identifier
	|	packageName '.' Identifier
	;

//QUALIFIER
typeName
	:	Identifier
	|	packageOrTypeName '.' Identifier
	;

//QUALIFIER
packageOrTypeName
	:	Identifier
	|	packageOrTypeName '.' Identifier
	;

//QUALIFIER
expressionName
	:	Identifier
	|	ambiguousName '.' Identifier
	;

//METHOD_DECLARATION
methodName
	:	Identifier
	;

//QUALIFIER
ambiguousName
	:	Identifier
	|	ambiguousName '.' Identifier
	;

/*
 * Productions from §7 (Packages)
 */

//COMPILATION_UNIT
compilationUnit
	:	packageDeclaration? importDeclaration* typeDeclaration* EOF
	;

//PACKAGE_DECLARATION
packageDeclaration
	:	packageModifier* 'package' packageName ';'
	;

//PACKAGE_DECLARATION
packageModifier
	:	annotation
	;

//NORMAL_IMPORT_DECLARATION and STATIC_IMPORT_DECLARATION
importDeclaration
	:	singleTypeImportDeclaration
	|	typeImportOnDemandDeclaration
	|	singleStaticImportDeclaration
	|	staticImportOnDemandDeclaration
	;

//NORMAL_IMPORT_DECLARATION
singleTypeImportDeclaration
	:	'import' typeName ';'
	;

//NORMAL_IMPORT_DECLARATION
typeImportOnDemandDeclaration
	:	'import' packageOrTypeName '.' '*' ';'
	;

//STATIC_IMPORT_DECLARATION
singleStaticImportDeclaration
	:	'import' 'static' typeName '.' Identifier ';'
	;

//STATIC_IMPORT_DECLARATION
staticImportOnDemandDeclaration
	:	'import' 'static' typeName '.' '*' ';'
	;

//Various
typeDeclaration
	:	classDeclaration
	|	interfaceDeclaration
	|	';'
	;

/*
 * Productions from §8 (Classes)
 */

//CLASS_DECLARATION, ENUM_DECLARATION
classDeclaration
	:	normalClassDeclaration
	|	enumDeclaration
	;

//CLASS_DECLARATION
normalClassDeclaration
	:	classModifier* 'class' Identifier typeParameters? superclass? superinterfaces? classBody
	;

//PUBLIC_MODIFIER_KEYWORD , PROTECTED_MODIFIER_KEYWORD , PRIVATE_MODIFIER_KEYWORD , ABSTRACT_MODIFIER_KEYWORD , STATIC_MODIFIER_KEYWORD , FINAL_MODIFIER_KEYWORD , STRICTFP_MODIFIER_KEYWORD
classModifier
	:	annotation
	|	'public'
	|	'protected'
	|	'private'
	|	'abstract'
	|	'static'
	|	'final'
	|	'strictfp'
	;

//TYPE_PARAMETER_LIST
typeParameters
	:	'<' typeParameterList '>'
	;

//TYPE_PARAMETER_LIST
typeParameterList
	:	typeParameter (',' typeParameter)*
	;

//EXTENDS_CLASS
superclass
	:	'extends' classType
	;

//IMPLEMENTS_INTERFACE
superinterfaces
	:	'implements' interfaceTypeList
	;

//IMPLEMENTS_INTERFACE
interfaceTypeList
	:	interfaceType (',' interfaceType)*
	;

//TYPE_BODY
classBody
	:	'{' classBodyDeclaration* '}'
	;

//TYPE_BODY
classBodyDeclaration
	:	classMemberDeclaration
	|	instanceInitializer
	|	staticInitializer
	|	constructorDeclaration
	;

//TYPE_BODY
classMemberDeclaration
	:	fieldDeclaration
	|	methodDeclaration
	|	classDeclaration
	|	interfaceDeclaration
	|	';'
	;

//VARIABLE_DECLARATION
fieldDeclaration
	:	fieldModifier* unannType variableDeclaratorList ';'
	;

//VARIABLE_DECLARATION
fieldModifier
	:	annotation
	|	'public'
	|	'protected'
	|	'private'
	|	'static'
	|	'final'
	|	'transient'
	|	'volatile'
	;

//VARIABLE_DECLARATOR
variableDeclaratorList
	:	variableDeclarator (',' variableDeclarator)*
	;

//VARIABLE_DECLARATOR
variableDeclarator
	:	variableDeclaratorId ('=' variableInitializer)?
	;

//VARIABLE_DECLARATOR
variableDeclaratorId
	:	Identifier dims?
	;

//VARIABLE_DECLARATOR
variableInitializer
	:	expression
	|	arrayInitializer
	;

//TYPE
unannType
	:	unannPrimitiveType
	|	unannReferenceType
	;

//TYPE
unannPrimitiveType
	:	numericType
	|	'boolean'
	;

//TYPE
unannReferenceType
	:	unannClassOrInterfaceType
	|	unannTypeVariable
	|	unannArrayType
	;

//TYPE
unannClassOrInterfaceType
	:	(	unannClassType_lfno_unannClassOrInterfaceType
		|	unannInterfaceType_lfno_unannClassOrInterfaceType
		)
		unannContinuedClassOrInterfaceType*
	;

unannContinuedClassOrInterfaceType
    : unannClassType_lf_unannClassOrInterfaceType
    |	unannInterfaceType_lf_unannClassOrInterfaceType
    ;

//TYPE
unannClassType
	:	Identifier typeArguments?
	|	unannClassOrInterfaceType '.' annotation* Identifier typeArguments?
	;

//TYPE
unannClassType_lf_unannClassOrInterfaceType
	:	'.' annotation* Identifier typeArguments?
	;

//TYPE
unannClassType_lfno_unannClassOrInterfaceType
	:	Identifier typeArguments?
	;

//TYPE
unannInterfaceType
	:	unannClassType
	;

//TYPE
unannInterfaceType_lf_unannClassOrInterfaceType
	:	unannClassType_lf_unannClassOrInterfaceType
	;

//TYPE
unannInterfaceType_lfno_unannClassOrInterfaceType
	:	unannClassType_lfno_unannClassOrInterfaceType
	;

//TYPE
unannTypeVariable
	:	Identifier
	;

//TYPE
unannArrayType
	:	unannPrimitiveType dims
	|	unannClassOrInterfaceType dims
	|	unannTypeVariable dims
	;

//METHOD_DECLARATION
methodDeclaration
	:	methodModifier* methodHeader methodBody
	;

//METHOD_DECLARATION
methodModifier
	:	annotation
	|	'public'
	|	'protected'
	|	'private'
	|	'abstract'
	|	'static'
	|	'final'
	|	'synchronized'
	|	'native'
	|	'strictfp'
	;

//METHOD_DECLARATION
methodHeader
	:	result methodDeclarator throws_?
	|	typeParameters annotation* result methodDeclarator throws_?
	;

//METHOD_DECLARATION
result
	:	unannType
	|	'void'
	;

//METHOD_DECLARATION
methodDeclarator
	:	Identifier '(' formalParameterList? ')' dims?
	;

//METHOD_DECLARATION
formalParameterList
	:	receiverParameter
	|	formalParameters ',' lastFormalParameter
	|	lastFormalParameter
	;

//METHOD_DECLARATION
formalParameters
	:	formalParameter (',' formalParameter)*
	|	receiverParameter (',' formalParameter)*
	;

//METHOD_PARAMETER
formalParameter
	:	variableModifier* unannType variableDeclaratorId
	;

//METHOD_PARAMETER
variableModifier
	:	annotation
	|	'final'
	;

//METHOD_ELLIPSIS_PARAMETER
lastFormalParameter
	:	variableModifier* unannType annotation* '...' variableDeclaratorId
	|	formalParameter
	;

//METHOD_RECEIVER_PARAMETER
receiverParameter
	:	annotation* unannType (Identifier '.')? 'this'
	;

//THROWS
throws_
	:	'throws' exceptionTypeList
	;

//THROWS
exceptionTypeList
	:	exceptionType (',' exceptionType)*
	;

//TYPE
exceptionType
	:	classType
	|	typeVariable
	;

//METHOD_DECLARATION
methodBody
	:	block
	|	';'
	;

//INITIALIZER
instanceInitializer
	:	block
	;

//INITIALIZER
staticInitializer
	:	'static' block
	;

//METHOD_DECLARATION
constructorDeclaration
	:	constructorModifier* constructorDeclarator throws_? constructorBody
	;

//METHOD_DECLARATION
constructorModifier
	:	annotation
	|	'public'
	|	'protected'
	|	'private'
	;

//METHOD_DECLARATION
constructorDeclarator
	:	typeParameters? simpleTypeName '(' formalParameterList? ')'
	;

//METHOD_DECLARATION
simpleTypeName
	:	Identifier
	;

//METHOD_DECLARATION
constructorBody
	:	'{' explicitConstructorInvocation? blockStatements? '}'
	;

//SUPER_EXPLICIT_CONSTRUCTOR_INVOCATION, THIS_EXPLICIT_CONSTRUCTOR_INVOCATION
explicitConstructorInvocation
	:	typeArguments? 'this' '(' argumentList? ')' ';'
	|	typeArguments? superKeyword '(' argumentList? ')' ';'
	|	expressionName '.' typeArguments? superKeyword '(' argumentList? ')' ';'
	|	primary '.' typeArguments? superKeyword '(' argumentList? ')' ';'
	;

//ENUM_DECLARATION
enumDeclaration
	:	classModifier* 'enum' Identifier superinterfaces? enumBody
	;

//ENUM_BODY
enumBody
	:	'{' enumConstantList? ','? enumBodyDeclarations? '}'
	;

//ENUM_BODY
enumConstantList
	:	enumConstant (',' enumConstant)*
	;

//ENUM_CONSTANT
enumConstant
	:	enumConstantModifier* Identifier ('(' argumentList? ')')? classBody?
	;

//ENUM_CONSTANT
enumConstantModifier
	:	annotation
	;

//ENUM_BODY
enumBodyDeclarations
	:	';' classBodyDeclaration*
	;

/*
 * Productions from §9 (Interfaces)
 */

//interface_declaration, annotation_declaration
interfaceDeclaration
	:	normalInterfaceDeclaration
	|	annotationTypeDeclaration
	;

//INTERFACE_DELCARATION
normalInterfaceDeclaration
	:	interfaceModifier* 'interface' Identifier typeParameters? extendsInterfaces? interfaceBody
	;

//INTERFACE_DELCARATION
interfaceModifier
	:	annotation
	|	'public'
	|	'protected'
	|	'private'
	|	'abstract'
	|	'static'
	|	'strictfp'
	;

//EXTENDS_INTERFACE
extendsInterfaces
	:	'extends' interfaceTypeList
	;

//TYPE_BODY
interfaceBody
	:	'{' interfaceMemberDeclaration* '}'
	;

//TYPE_BODY
interfaceMemberDeclaration
	:	constantDeclaration
	|	interfaceMethodDeclaration
	|	classDeclaration
	|	interfaceDeclaration
	|	';'
	;

//VARIABLE_DECLARATION
constantDeclaration
	:	constantModifier* unannType variableDeclaratorList ';'
	;

//VARIABLE_DECLARATION
constantModifier
	:	annotation
	|	'public'
	|	'static'
	|	'final'
	;

//METHOD_DECLARATION
interfaceMethodDeclaration
	:	interfaceMethodModifier* methodHeader methodBody
	;

//METHOD_DECLARATION
interfaceMethodModifier
	:	annotation
	|	'public'
	|	'abstract'
	|	'default'
	|	'static'
	|	'strictfp'
	;

//ANNOTATION_DECLARATION
annotationTypeDeclaration
	:	interfaceModifier* '@' 'interface' Identifier annotationTypeBody
	;

//TYPE_BODY
annotationTypeBody
	:	'{' annotationTypeMemberDeclaration* '}'
	;

//TYPE_BODY
annotationTypeMemberDeclaration
	:	annotationTypeElementDeclaration
	|	constantDeclaration
	|	classDeclaration
	|	interfaceDeclaration
	|	';'
	;

//ANNOTATION_TYPE_ELEMENT_DECLARATION
annotationTypeElementDeclaration
	:	annotationTypeElementModifier* unannType Identifier '(' ')' dims? defaultValue? ';'
	;

//ANNOTATION_TYPE_ELEMENT_DECLARATION
annotationTypeElementModifier
	:	annotation
	|	'public'
	|	'abstract'
	;

//ANNOTATION_TYPE_ELEMENT_DECLARATION
defaultValue
	:	'default' elementValue
	;

//ANNOTATION
annotation
	:	normalAnnotation
	|	markerAnnotation
	|	singleElementAnnotation
	;

//ANNOTATION
normalAnnotation
	:	'@' typeName '(' elementValuePairList? ')'
	;

//ANNOTATION
elementValuePairList
	:	elementValuePair (',' elementValuePair)*
	;

//ELEMENT_PAIR
elementValuePair
	:	Identifier '=' elementValue
	;

//misc
elementValue
	:	conditionalExpression
	|	elementValueArrayInitializer
	|	annotation
	;

//ELEMENT_ARRAY
elementValueArrayInitializer
	:	'{' elementValueList? ','? '}'
	;

//ELEMENT_ARRAY
elementValueList
	:	elementValue (',' elementValue)*
	;

//ANNOTATION
markerAnnotation
	:	'@' typeName
	;

//ANNOTATION
singleElementAnnotation
	:	'@' typeName '(' elementValue ')'
	;

/*
 * Productions from §10 (Arrays)
 */

//ARRAY_INITIALIZER
arrayInitializer
	:	'{' variableInitializerList? ','? '}'
	;

//ARRAY_INITIALIZER
variableInitializerList
	:	variableInitializer (',' variableInitializer)*
	;

/*
 * Productions from §14 (Blocks and Statements)
 */

//BLOCK
block
	:	'{' blockStatements? '}'
	;

//BLOCK
blockStatements
	:	blockStatement+
	;

//misc
blockStatement
	:	localVariableDeclarationStatement
	|	classDeclaration
	|	statement
	;

//VARIABLE_DECLARATION
localVariableDeclarationStatement
	:	localVariableDeclaration ';'
	;

//VARIABLE_DECLARATION
localVariableDeclaration
	:	variableModifier* unannType variableDeclaratorList
	;

//misc
statement
	:	statementWithoutTrailingSubstatement
	|	labeledStatement
	|	ifThenStatement
	|	ifThenElseStatement
	|	whileStatement
	|	forStatement
	;

//misc
statementNoShortIf
	:	statementWithoutTrailingSubstatement
	|	labeledStatementNoShortIf
	|	ifThenElseStatementNoShortIf
	|	whileStatementNoShortIf
	|	forStatementNoShortIf
	;

//misc
statementWithoutTrailingSubstatement
	:	block
	|	emptyStatement
	|	expressionStatement
	|	assertStatement
	|	switchStatement
	|	doStatement
	|	breakStatement
	|	continueStatement
	|	returnStatement
	|	synchronizedStatement
	|	throwStatement
	|	tryStatement
	;

//EMPTY_STATEMENT
emptyStatement
	:	';'
	;

//LABELED_STATEMENT
labeledStatement
	:	Identifier ':' statement
	;

//LABELED_STATEMENT
labeledStatementNoShortIf
	:	Identifier ':' statementNoShortIf
	;

//misc
expressionStatement
	:	statementExpression ';'
	;

//misc
statementExpression
	:	assignment
	|	preIncrementExpression
	|	preDecrementExpression
	|	postIncrementExpression
	|	postDecrementExpression
	|	methodInvocation
	|	classInstanceCreationExpression
	;

//IF_STATEMENT
ifThenStatement
	:	'if' '(' expression ')' statement
	;

//IF_STATEMENT
ifThenElseStatement
	:	'if' '(' expression ')' statementNoShortIf 'else' statement
	;

//IF_STATEMENT
ifThenElseStatementNoShortIf
	:	'if' '(' expression ')' statementNoShortIf 'else' statementNoShortIf
	;

//ASSERT_STATEMENT
assertStatement
	:	'assert' expression ';'
	|	'assert' expression ':' expression ';'
	;

//SWITCH_STATEMENT
switchStatement
	:	'switch' '(' expression ')' switchBlock
	;

//SWITCH_STATEMENT
switchBlock
	:	'{' switchBlockStatementGroup* switchLabel* '}'
	;

//SWITCH_GROUP
switchBlockStatementGroup
	:	switchLabels blockStatements
	;

//misc
switchLabels
	:	switchLabel switchLabel*
	;

//misc
switchLabel
	:	'case' constantExpression ':'
	|	'case' enumConstantName ':'
	|	'default' ':'
	;

//QUALIFIER
enumConstantName
	:	Identifier
	;

//WHILE_STATEMENT
whileStatement
	:	'while' '(' expression ')' statement
	;

//WHILE_STATEMENT
whileStatementNoShortIf
	:	'while' '(' expression ')' statementNoShortIf
	;

//DO_STATEMENT
doStatement
	:	'do' statement 'while' '(' expression ')' ';'
	;

//BASIC_FOR_STATEMENT, ENHANCED_FOR_STATEMENT
forStatement
	:	basicForStatement
	|	enhancedForStatement
	;

//BASIC_FOR_STATEMENT, ENHANCED_FOR_STATEMENT
forStatementNoShortIf
	:	basicForStatementNoShortIf
	|	enhancedForStatementNoShortIf
	;

//BASIC_FOR_STATEMENT
basicForStatement
	:	'for' '(' forInit? ';' expression? ';' forUpdate? ')' statement
	;

//BASIC_FOR_STATEMENT
basicForStatementNoShortIf
	:	'for' '(' forInit? ';' expression? ';' forUpdate? ')' statementNoShortIf
	;

//FOR_INIT
forInit
	:	statementExpressionList
	|	localVariableDeclaration
	;

//FOR_UPDATE
forUpdate
	:	statementExpressionList
	;

//misc
statementExpressionList
	:	statementExpression (',' statementExpression)*
	;

//ENHANCED_FOR_STATEMENT
enhancedForStatement
	:	'for' '(' variableModifier* unannType variableDeclaratorId ':' expression ')' statement
	;

//ENHANCED_FOR_STATEMENT
enhancedForStatementNoShortIf
	:	'for' '(' variableModifier* unannType variableDeclaratorId ':' expression ')' statementNoShortIf
	;

//BREAK_STATEMENT
breakStatement
	:	'break' Identifier? ';'
	;

//CONTINUE_STATEMENT
continueStatement
	:	'continue' Identifier? ';'
	;

//RETURN_STATEMENT
returnStatement
	:	'return' expression? ';'
	;

//THROW_STATEMENT
throwStatement
	:	'throw' expression ';'
	;

//SYNCHRONIZED_STATEMENT
synchronizedStatement
	:	'synchronized' '(' expression ')' block
	;

//TRY_STATEMENT
tryStatement
	:	'try' block catches
	|	'try' block catches? finally_
	|	tryWithResourcesStatement
	;

//TRY_STATEMENT_CATCH
catches
	:	catchClause catchClause*
	;

//TRY_STATEMENT_CATCH
catchClause
	:	'catch' '(' catchFormalParameter ')' block
	;

//TRY_STATEMENT_CATCH
catchFormalParameter
	:	variableModifier* catchType variableDeclaratorId
	;

//TRY_STATEMENT_CATCH
catchType
	:	unannClassType ('|' classType)*
	;

//TRY_STATEMENT_FINALLY
finally_
	:	'finally' block
	;

//TRY_STATEMENT
tryWithResourcesStatement
	:	'try' resourceSpecification block catches? finally_?
	;

//TRY_STATEMENT
resourceSpecification
	:	'(' resourceList ';'? ')'
	;

//TRY_STATEMENT
resourceList
	:	resource (';' resource)*
	;

//TRY_STATEMENT_RESOURCE
resource
	:	variableModifier* unannType variableDeclaratorId '=' expression
	;

/*
 * Productions from §15 (Expressions)
 */

//PRIMARY
primary
	:	(	primaryNoNewArray_lfno_primary
		|	arrayCreationExpression
		)
		(	primaryNoNewArray_lf_primary
		)*
	;

//misc
primaryNoNewArray
	:	literal //TYPE
	|	typeName (dim)* '.' classKeyword //PRIMARY_TYPE_DOT_CLASS
	|	'void' '.' classKeyword //PRIMARY_TYPE_DOT_CLASS
	|	'this' //PRIMARY_TYPE_DOT_THIS
	|	typeName '.' 'this' //PRIMARY_TYPE_DOT_THIS
	|	'(' expression ')' //EXPRESSION
	|	classInstanceCreationExpression //CLASS_INSTANCE_CREATION_EXPRESSION
	|	fieldAccess //FIELD_ACCESS
	|	arrayAccess //ARRAY_ACCESS
	|	methodInvocation //METHOD_INVOCATION
	|	methodReference //NORMAL_METHOD_REFERENCE, SUPER_METHOD_REFERENCE, NEW_METHOD_REFERENCE
	;

classKeyword
    : 'class'
    ;

//misc
primaryNoNewArray_lf_arrayAccess
	:
	;

//misc
primaryNoNewArray_lfno_arrayAccess
	:	literal
	|	typeName (dim)* '.' classKeyword
	|	'void' '.' classKeyword
	|	'this'
	|	typeName '.' classKeyword
	|	'(' expression ')'
	|	classInstanceCreationExpression
	|	fieldAccess
	|	methodInvocation
	|	methodReference
	;

//misc
primaryNoNewArray_lf_primary
	:	classInstanceCreationExpression_lf_primary
	|	fieldAccess_lf_primary
	|	arrayAccess_lf_primary
	|	methodInvocation_lf_primary
	|	methodReference_lf_primary
	;

//misc
primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary
	:
	;

//misc
primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary
	:	classInstanceCreationExpression_lf_primary
	|	fieldAccess_lf_primary
	|	methodInvocation_lf_primary
	|	methodReference_lf_primary
	;

//misc
primaryNoNewArray_lfno_primary
	:	literal
	|	typeName (dim)* '.' classKeyword
	|	unannPrimitiveType (dim)* '.' classKeyword
	|	'void' '.' classKeyword
	|	'this'
	|	typeName '.' 'this'
	|	'(' expression ')'
	|	classInstanceCreationExpression_lfno_primary
	|	fieldAccess_lfno_primary
	|	arrayAccess_lfno_primary
	|	methodInvocation_lfno_primary
	|	methodReference_lfno_primary
	;

//misc
primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary
	:
	;

//misc
primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary
	:	literal
	|	typeName (dim)* '.' classKeyword
	|	unannPrimitiveType (dim)* '.' classKeyword
	|	'void' '.' classKeyword
	|	'this'
	|	typeName '.' 'this'
	|	'(' expression ')'
	|	classInstanceCreationExpression_lfno_primary
	|	fieldAccess_lfno_primary
	|	methodInvocation_lfno_primary
	|	methodReference_lfno_primary
	;

//CLASS_INSTANCE_CREATION_EXPRESSION
classInstanceCreationExpression
	:	'new' typeArguments? annotatedQualifierElement ('.' annotatedQualifierElement)* typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	|	expressionName '.' 'new' typeArguments? annotatedQualifierElement typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	|	primary '.' 'new' typeArguments? annotatedQualifierElement typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	;

//CLASS_INSTANCE_CREATION_EXPRESSION
classInstanceCreationExpression_lf_primary
	:	'.' 'new' typeArguments? annotatedQualifierElement typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	;

//CLASS_INSTANCE_CREATION_EXPRESSION
classInstanceCreationExpression_lfno_primary
	:	'new' typeArguments? annotatedQualifierElement ('.' annotatedQualifierElement)* typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	|	expressionName '.' 'new' typeArguments? annotatedQualifierElement typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	;

annotatedQualifierElement
    : annotation* Identifier
    ;

//TYPE_ARGUMENT_LIST
typeArgumentsOrDiamond
	:	typeArguments
	|	'<' '>'
	;

//FIELD_ACCESS
fieldAccess
	:	primary '.' Identifier
	|	superKeyword '.' Identifier
	|	typeName '.' superKeyword '.' Identifier
	;

//FIELD_ACCESS
fieldAccess_lf_primary
	:	'.' Identifier
	;

//FIELD_ACCESS
fieldAccess_lfno_primary
	:	superKeyword '.' Identifier
	|	typeName '.' superKeyword '.' Identifier
	;

//ARRAY_ACCESS
arrayAccess
	:	(	expressionName '[' expression ']'
		|	primaryNoNewArray_lfno_arrayAccess '[' expression ']'
		)
		(	primaryNoNewArray_lf_arrayAccess '[' expression ']'
		)*
	;

//ARRAY_ACCESS
arrayAccess_lf_primary
	:	(	primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary '[' expression ']'
		)
		(	primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary '[' expression ']'
		)*
	;

//ARRAY_ACCESS
arrayAccess_lfno_primary
	:	(	expressionName '[' expression ']'
		|	primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary '[' expression ']'
		)
		(	primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary '[' expression ']'
		)*
	;

//METHOD_INVOCATION
methodInvocation
	:	methodName '(' argumentList? ')'
	|	typeName '.' typeArguments? Identifier '(' argumentList? ')'
	|	expressionName '.' typeArguments? Identifier '(' argumentList? ')'
	|	primary '.' typeArguments? Identifier '(' argumentList? ')'
	|	superKeyword '.' typeArguments? Identifier '(' argumentList? ')'
	|	typeName '.' superKeyword '.' typeArguments? Identifier '(' argumentList? ')'
	;

superKeyword
    : 'super'
    ;

//METHOD_INVOCATION
methodInvocation_lf_primary
	:	'.' typeArguments? Identifier '(' argumentList? ')'
	;

//METHOD_INVOCATION
methodInvocation_lfno_primary
	:	methodName '(' argumentList? ')'
	|	typeName '.' typeArguments? Identifier '(' argumentList? ')'
	|	expressionName '.' typeArguments? Identifier '(' argumentList? ')'
	|	'super' '.' typeArguments? Identifier '(' argumentList? ')'
	|	typeName '.' 'super' '.' typeArguments? Identifier '(' argumentList? ')'
	;

//ARGUMENT_LIST
argumentList
	:	expression (',' expression)*
	;

//Misc
methodReference
	:	expressionName '::' typeArguments? Identifier //NORMAL_METHOD_REFERENCE
	|	referenceType '::' typeArguments? Identifier //NORMAL_METHOD_REFERENCE
	|	primary '::' typeArguments? Identifier //NORMAL_METHOD_REFERENCE
	|	'super' '::' typeArguments? Identifier //SUPER_METHOD_REFERENCE
	|	typeName '.' 'super' '::' typeArguments? Identifier //SUPER_METHOD_REFERENCE
	|	classType '::' typeArguments? 'new' //NEW_METHOD_REFERENCE
	|	arrayType '::' 'new' //NEW_METHOD_REFERENCE
	;

//See method reference
methodReference_lf_primary
	:	'::' typeArguments? Identifier
	;

//See method reference
methodReference_lfno_primary
	:	expressionName '::' typeArguments? Identifier
	|	referenceType '::' typeArguments? Identifier
	|	'super' '::' typeArguments? Identifier
	|	typeName '.' 'super' '::' typeArguments? Identifier
	|	classType '::' typeArguments? 'new'
	|	arrayType '::' 'new'
	;

//ARRAY_CREATION_EXPRESSION
arrayCreationExpression
	:	'new' primitiveType dimExprs dims?
	|	'new' classOrInterfaceType dimExprs dims?
	|	'new' primitiveType dims arrayInitializer
	|	'new' classOrInterfaceType dims arrayInitializer
	;

//DIM_EXPRESSION
dimExprs
	:	dimExpr dimExpr*
	;

//DIM_EXPRESSION
dimExpr
	:	annotation* '[' expression ']'
	;

//misc
constantExpression
	:	expression
	;

//misc
expression
	:	lambdaExpression
	|	assignmentExpression
	;

//LAMBDA_EXPRESSION
lambdaExpression
	:	lambdaParameters '->' lambdaBody
	;

//misc
lambdaParameters
	:	Identifier
	|	'(' formalParameterList? ')'
	|	'(' inferredFormalParameterList ')'
	;

//LAMBDA_EXPRESSION_INFERRED_FORMAL_PARAMETER_LIST
inferredFormalParameterList
	:	Identifier (',' Identifier)*
	;

//misc
lambdaBody
	:	expression
	|	block
	;

//misc
assignmentExpression
	:	conditionalExpression
	|	assignment
	;

//ASSIGNMENT
assignment
	:	leftHandSide assignmentOperator expression
	;

//ASSIGNMENT
leftHandSide
	:	expressionName
	|	fieldAccess
	|	arrayAccess
	;

//misc
assignmentOperator
	:	'='
	|	'*='
	|	'/='
	|	'%='
	|	'+='
	|	'-='
	|	'<<='
	|	'>>='
	|	'>>>='
	|	'&='
	|	'^='
	|	'|='
	;

//TERNARY_EXPRESSION
conditionalExpression
	:	conditionalOrExpression
	|	conditionalOrExpression '?' expression ':' conditionalExpression
	;

//BINARY_EXPRESSION
conditionalOrExpression
	:	conditionalAndExpression
	|	conditionalOrExpression '||' conditionalAndExpression
	;

//BINARY_EXPRESSION
conditionalAndExpression
	:	inclusiveOrExpression
	|	conditionalAndExpression '&&' inclusiveOrExpression
	;

//BINARY_EXPRESSION
inclusiveOrExpression
	:	exclusiveOrExpression
	|	inclusiveOrExpression '|' exclusiveOrExpression
	;

//BINARY_EXPRESSION
exclusiveOrExpression
	:	andExpression
	|	exclusiveOrExpression '^' andExpression
	;

//BINARY_EXPRESSION
andExpression
	:	equalityExpression
	|	andExpression '&' equalityExpression
	;

//BINARY_EXPRESSION
equalityExpression
	:	relationalExpression
	|	equalityExpression equalityExpressionEqualToSymbol relationalExpression
	|	equalityExpression equalityExpressionNotEqualToSymbol relationalExpression
	;

//Added by me
equalityExpressionEqualToSymbol
    : '=='
    ;

//Added by me
equalityExpressionNotEqualToSymbol
    : '!='
    ;

//BINARY_EXPRESSION
relationalExpression
	:	shiftExpression
	|	relationalExpression relationalExpressionLT shiftExpression
	|	relationalExpression relationalExpressionGT shiftExpression
	|	relationalExpression relationalExpressionLTE shiftExpression
	|	relationalExpression relationalExpressionGTE shiftExpression
	|	relationalExpression relationalExpressionIO referenceType
	;

//Added by me
relationalExpressionLT
    : '<'
    ;

//Added by me
relationalExpressionGT
    : '>'
    ;

//Added by me
relationalExpressionLTE
    : '<='
    ;

//Added by me
relationalExpressionGTE
    : '>='
    ;

//Added by me
relationalExpressionIO
    : '>='
    ;

//BINARY_EXPRESSION
shiftExpression
	:	additiveExpression
	|	shiftExpression shiftExpressionSLL additiveExpression
	|	shiftExpression shiftExpressionSRL additiveExpression
	|	shiftExpression shiftExpressionSRA additiveExpression
	;

//Added by me
shiftExpressionSLL
    : '<' '<'
    ;

//Added by me
shiftExpressionSRL
    : '>' '>'
    ;
    
//Added by me
shiftExpressionSRA
    : '>' '>' '>'
    ;

//BINARY_EXPRESSION
additiveExpression
	:	multiplicativeExpression
	|	additiveExpression additiveExpressionP multiplicativeExpression
	|	additiveExpression additiveExpressionM multiplicativeExpression
	;

//Added by me
additiveExpressionP
    : '+'
    ;

//Added by me
additiveExpressionM
    : '-'
    ;

//BINARY_EXPRESSION
multiplicativeExpression
	:	unaryExpression
	|	multiplicativeExpression multiplicativeExpressionM unaryExpression
	|	multiplicativeExpression multiplicativeExpressionD unaryExpression
	|	multiplicativeExpression multiplicativeExpressionMod unaryExpression
	;

//Added by me
multiplicativeExpressionM
    : '*'
    ;

//Added by me
multiplicativeExpressionD
    : '/'
    ;

//Added by me
multiplicativeExpressionMod
    : '/'
    ;

//misc
unaryExpression
	:	preIncrementExpression
	|	preDecrementExpression
	|	unaryExpressionP unaryExpression
	|	unaryExpressionM unaryExpression
	|	unaryExpressionNotPlusMinus
	;

//Added by me
unaryExpressionP
    : '+'
    ;

//Added by me
unaryExpressionM
    : '-'
    ;

//INCREMENT_DECREMENT_STATEMENT
preIncrementExpression
	:	'++' unaryExpression
	;

//INCREMENT_DECREMENT_STATEMENT
preDecrementExpression
	:	'--' unaryExpression
	;

//UNARY_EXPRESSION
unaryExpressionNotPlusMinus
	:	postfixExpression
	|	unaryExpressionNotPlusMinusBN unaryExpression
	|	unaryExpressionNotPlusMinusCN unaryExpression
	|	castExpression
	;

//Added by me
unaryExpressionNotPlusMinusBN
    : '~'
    ;

//Added by me
unaryExpressionNotPlusMinusCN
    : '!'
    ;

//UNARY_EXPRESSION
postfixExpression
	:	(	primary
		|	expressionName
		)
		(postfixExpressionSymbol)*
	;

//I added this
postfixExpressionSymbol
    :   postIncrementExpression_lf_postfixExpression
    |	postDecrementExpression_lf_postfixExpression
    ;

//UNARY_EXPRESSION
postIncrementExpression
	:	postfixExpression '++'
	;

//INCREMENT_SYMBOL
postIncrementExpression_lf_postfixExpression
	:	'++'
	;

//UNARY_EXPRESSION
postDecrementExpression
	:	postfixExpression '--'
	;

//DECREMENT_SYMBOL
postDecrementExpression_lf_postfixExpression
	:	'--'
	;

//CAST_EXPRESSION
castExpression
	:	'(' primitiveType ')' unaryExpression
	|	'(' referenceType additionalBound* ')' unaryExpressionNotPlusMinus
	|	'(' referenceType additionalBound* ')' lambdaExpression
	;