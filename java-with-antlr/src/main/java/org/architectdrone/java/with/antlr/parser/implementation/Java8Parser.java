// Generated from Java8Parser.g4 by ANTLR 4.3

package org.architectdrone.java.with.antlr.parser.implementation;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Java8Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		THROW=44, STATIC=38, INTERFACE=28, AND_ASSIGN=95, BREAK=4, BYTE=5, ELSE=15, 
		IF=22, ENUM=16, SUB=82, BANG=69, LPAREN=57, DOT=65, CASE=6, AT=103, LINE_COMMENT=107, 
		StringLiteral=55, ELLIPSIS=104, LBRACK=61, PUBLIC=35, THROWS=45, NullLiteral=56, 
		RSHIFT_ASSIGN=100, LBRACE=59, GOTO=23, SUB_ASSIGN=92, SEMI=63, CHAR=8, 
		COLONCOLON=90, ASSIGN=66, COMMENT=106, IMPORT=25, ARROW=89, BITOR=86, 
		CATCH=7, MUL_ASSIGN=93, DOUBLE=14, PROTECTED=34, LONG=29, COMMA=64, BITAND=85, 
		PRIVATE=33, CONTINUE=11, DIV=84, FloatingPointLiteral=52, LE=74, CharacterLiteral=54, 
		VOLATILE=49, EXTENDS=17, INSTANCEOF=26, NEW=31, ADD=81, LT=68, CLASS=9, 
		DO=13, FINALLY=19, Identifier=102, CONST=10, PACKAGE=32, OR_ASSIGN=96, 
		TRY=47, IntegerLiteral=51, SYNCHRONIZED=42, MUL=83, FOR=21, FINAL=18, 
		RPAREN=58, CARET=87, URSHIFT_ASSIGN=101, BOOLEAN=3, NOTEQUAL=76, RBRACK=62, 
		RBRACE=60, AND=77, THIS=43, SWITCH=41, VOID=48, TRANSIENT=46, INC=79, 
		FLOAT=20, NATIVE=30, DIV_ASSIGN=94, BooleanLiteral=53, ABSTRACT=1, STRICTFP=39, 
		INT=27, QUESTION=71, RETURN=36, LSHIFT_ASSIGN=99, ADD_ASSIGN=91, WS=105, 
		GE=75, SUPER=40, OR=78, DEC=80, MOD=88, XOR_ASSIGN=97, ASSERT=2, EQUAL=73, 
		IMPLEMENTS=24, COLON=72, GT=67, SHORT=37, MOD_ASSIGN=98, WHILE=50, TILDE=70, 
		DEFAULT=12;
	public static final String[] tokenNames = {
		"<INVALID>", "'abstract'", "'assert'", "'boolean'", "'break'", "'byte'", 
		"'case'", "'catch'", "'char'", "'class'", "'const'", "'continue'", "'default'", 
		"'do'", "'double'", "'else'", "'enum'", "'extends'", "'final'", "'finally'", 
		"'float'", "'for'", "'if'", "'goto'", "'implements'", "'import'", "'instanceof'", 
		"'int'", "'interface'", "'long'", "'native'", "'new'", "'package'", "'private'", 
		"'protected'", "'public'", "'return'", "'short'", "'static'", "'strictfp'", 
		"'super'", "'switch'", "'synchronized'", "'this'", "'throw'", "'throws'", 
		"'transient'", "'try'", "'void'", "'volatile'", "'while'", "IntegerLiteral", 
		"FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", "StringLiteral", 
		"'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", 
		"'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'=='", "'<='", "'>='", 
		"'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", 
		"'|'", "'^'", "'%'", "'->'", "'::'", "'+='", "'-='", "'*='", "'/='", "'&='", 
		"'|='", "'^='", "'%='", "'<<='", "'>>='", "'>>>='", "Identifier", "'@'", 
		"'...'", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_literal = 0, RULE_primitiveType = 1, RULE_numericType = 2, RULE_integralType = 3, 
		RULE_floatingPointType = 4, RULE_referenceType = 5, RULE_classOrInterfaceType = 6, 
		RULE_continuedClassOrInterfaceType = 7, RULE_classType = 8, RULE_classType_lf_classOrInterfaceType = 9, 
		RULE_classType_lfno_classOrInterfaceType = 10, RULE_interfaceType = 11, 
		RULE_interfaceType_lf_classOrInterfaceType = 12, RULE_interfaceType_lfno_classOrInterfaceType = 13, 
		RULE_typeVariable = 14, RULE_arrayType = 15, RULE_dims = 16, RULE_annotatedDim = 17, 
		RULE_dim = 18, RULE_typeParameter = 19, RULE_typeParameterModifier = 20, 
		RULE_typeBound = 21, RULE_additionalBound = 22, RULE_typeArguments = 23, 
		RULE_typeArgumentList = 24, RULE_typeArgument = 25, RULE_wildcard = 26, 
		RULE_wildcardBounds = 27, RULE_wildcardExtends = 28, RULE_packageName = 29, 
		RULE_typeName = 30, RULE_packageOrTypeName = 31, RULE_expressionName = 32, 
		RULE_methodName = 33, RULE_ambiguousName = 34, RULE_compilationUnit = 35, 
		RULE_packageDeclaration = 36, RULE_packageModifier = 37, RULE_importDeclaration = 38, 
		RULE_singleTypeImportDeclaration = 39, RULE_typeImportOnDemandDeclaration = 40, 
		RULE_singleStaticImportDeclaration = 41, RULE_staticImportOnDemandDeclaration = 42, 
		RULE_typeDeclaration = 43, RULE_classDeclaration = 44, RULE_normalClassDeclaration = 45, 
		RULE_classModifier = 46, RULE_typeParameters = 47, RULE_typeParameterList = 48, 
		RULE_superclass = 49, RULE_superinterfaces = 50, RULE_interfaceTypeList = 51, 
		RULE_classBody = 52, RULE_classBodyDeclaration = 53, RULE_classMemberDeclaration = 54, 
		RULE_fieldDeclaration = 55, RULE_fieldModifier = 56, RULE_variableDeclaratorList = 57, 
		RULE_variableDeclarator = 58, RULE_variableDeclaratorId = 59, RULE_variableInitializer = 60, 
		RULE_unannType = 61, RULE_unannPrimitiveType = 62, RULE_unannReferenceType = 63, 
		RULE_unannClassOrInterfaceType = 64, RULE_unannContinuedClassOrInterfaceType = 65, 
		RULE_unannClassType = 66, RULE_unannClassType_lf_unannClassOrInterfaceType = 67, 
		RULE_unannClassType_lfno_unannClassOrInterfaceType = 68, RULE_unannInterfaceType = 69, 
		RULE_unannInterfaceType_lf_unannClassOrInterfaceType = 70, RULE_unannInterfaceType_lfno_unannClassOrInterfaceType = 71, 
		RULE_unannTypeVariable = 72, RULE_unannArrayType = 73, RULE_methodDeclaration = 74, 
		RULE_methodModifier = 75, RULE_methodHeader = 76, RULE_result = 77, RULE_methodDeclarator = 78, 
		RULE_formalParameterList = 79, RULE_formalParameters = 80, RULE_formalParameter = 81, 
		RULE_variableModifier = 82, RULE_lastFormalParameter = 83, RULE_receiverParameter = 84, 
		RULE_throws_ = 85, RULE_exceptionTypeList = 86, RULE_exceptionType = 87, 
		RULE_methodBody = 88, RULE_instanceInitializer = 89, RULE_staticInitializer = 90, 
		RULE_constructorDeclaration = 91, RULE_constructorModifier = 92, RULE_constructorDeclarator = 93, 
		RULE_simpleTypeName = 94, RULE_constructorBody = 95, RULE_explicitConstructorInvocation = 96, 
		RULE_enumDeclaration = 97, RULE_enumBody = 98, RULE_enumConstantList = 99, 
		RULE_enumConstant = 100, RULE_enumConstantModifier = 101, RULE_enumBodyDeclarations = 102, 
		RULE_interfaceDeclaration = 103, RULE_normalInterfaceDeclaration = 104, 
		RULE_interfaceModifier = 105, RULE_extendsInterfaces = 106, RULE_interfaceBody = 107, 
		RULE_interfaceMemberDeclaration = 108, RULE_constantDeclaration = 109, 
		RULE_constantModifier = 110, RULE_interfaceMethodDeclaration = 111, RULE_interfaceMethodModifier = 112, 
		RULE_annotationTypeDeclaration = 113, RULE_annotationTypeBody = 114, RULE_annotationTypeMemberDeclaration = 115, 
		RULE_annotationTypeElementDeclaration = 116, RULE_annotationTypeElementModifier = 117, 
		RULE_defaultValue = 118, RULE_annotation = 119, RULE_normalAnnotation = 120, 
		RULE_elementValuePairList = 121, RULE_elementValuePair = 122, RULE_elementValue = 123, 
		RULE_elementValueArrayInitializer = 124, RULE_elementValueList = 125, 
		RULE_markerAnnotation = 126, RULE_singleElementAnnotation = 127, RULE_arrayInitializer = 128, 
		RULE_variableInitializerList = 129, RULE_block = 130, RULE_blockStatements = 131, 
		RULE_blockStatement = 132, RULE_localVariableDeclarationStatement = 133, 
		RULE_localVariableDeclaration = 134, RULE_statement = 135, RULE_statementNoShortIf = 136, 
		RULE_statementWithoutTrailingSubstatement = 137, RULE_emptyStatement = 138, 
		RULE_labeledStatement = 139, RULE_labeledStatementNoShortIf = 140, RULE_expressionStatement = 141, 
		RULE_statementExpression = 142, RULE_ifThenStatement = 143, RULE_ifThenElseStatement = 144, 
		RULE_ifThenElseStatementNoShortIf = 145, RULE_assertStatement = 146, RULE_switchStatement = 147, 
		RULE_switchBlock = 148, RULE_switchBlockStatementGroup = 149, RULE_switchLabels = 150, 
		RULE_switchLabel = 151, RULE_enumConstantName = 152, RULE_whileStatement = 153, 
		RULE_whileStatementNoShortIf = 154, RULE_doStatement = 155, RULE_forStatement = 156, 
		RULE_forStatementNoShortIf = 157, RULE_basicForStatement = 158, RULE_basicForStatementNoShortIf = 159, 
		RULE_forInit = 160, RULE_forUpdate = 161, RULE_statementExpressionList = 162, 
		RULE_enhancedForStatement = 163, RULE_enhancedForStatementNoShortIf = 164, 
		RULE_breakStatement = 165, RULE_continueStatement = 166, RULE_returnStatement = 167, 
		RULE_throwStatement = 168, RULE_synchronizedStatement = 169, RULE_tryStatement = 170, 
		RULE_catches = 171, RULE_catchClause = 172, RULE_catchFormalParameter = 173, 
		RULE_catchType = 174, RULE_finally_ = 175, RULE_tryWithResourcesStatement = 176, 
		RULE_resourceSpecification = 177, RULE_resourceList = 178, RULE_resource = 179, 
		RULE_primary = 180, RULE_primaryNoNewArray = 181, RULE_classKeyword = 182, 
		RULE_primaryNoNewArray_lf_arrayAccess = 183, RULE_primaryNoNewArray_lfno_arrayAccess = 184, 
		RULE_primaryNoNewArray_lf_primary = 185, RULE_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary = 186, 
		RULE_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary = 187, RULE_primaryNoNewArray_lfno_primary = 188, 
		RULE_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary = 189, 
		RULE_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary = 190, 
		RULE_classInstanceCreationExpression = 191, RULE_classInstanceCreationExpression_lf_primary = 192, 
		RULE_classInstanceCreationExpression_lfno_primary = 193, RULE_annotatedQualifierElement = 194, 
		RULE_typeArgumentsOrDiamond = 195, RULE_fieldAccess = 196, RULE_fieldAccess_lf_primary = 197, 
		RULE_fieldAccess_lfno_primary = 198, RULE_arrayAccess = 199, RULE_arrayAccess_lf_primary = 200, 
		RULE_arrayAccess_lfno_primary = 201, RULE_methodInvocation = 202, RULE_superKeyword = 203, 
		RULE_methodInvocation_lf_primary = 204, RULE_methodInvocation_lfno_primary = 205, 
		RULE_argumentList = 206, RULE_methodReference = 207, RULE_methodReference_lf_primary = 208, 
		RULE_methodReference_lfno_primary = 209, RULE_arrayCreationExpression = 210, 
		RULE_dimExprs = 211, RULE_dimExpr = 212, RULE_constantExpression = 213, 
		RULE_expression = 214, RULE_lambdaExpression = 215, RULE_lambdaParameters = 216, 
		RULE_inferredFormalParameterList = 217, RULE_lambdaBody = 218, RULE_assignmentExpression = 219, 
		RULE_assignment = 220, RULE_leftHandSide = 221, RULE_assignmentOperator = 222, 
		RULE_conditionalExpression = 223, RULE_conditionalOrExpression = 224, 
		RULE_conditionalAndExpression = 225, RULE_inclusiveOrExpression = 226, 
		RULE_exclusiveOrExpression = 227, RULE_andExpression = 228, RULE_equalityExpression = 229, 
		RULE_equalityExpressionEqualToSymbol = 230, RULE_equalityExpressionNotEqualToSymbol = 231, 
		RULE_relationalExpression = 232, RULE_relationalExpressionLT = 233, RULE_relationalExpressionGT = 234, 
		RULE_relationalExpressionLTE = 235, RULE_relationalExpressionGTE = 236, 
		RULE_relationalExpressionIO = 237, RULE_shiftExpression = 238, RULE_shiftExpressionSLL = 239, 
		RULE_shiftExpressionSRL = 240, RULE_shiftExpressionSRA = 241, RULE_additiveExpression = 242, 
		RULE_additiveExpressionP = 243, RULE_additiveExpressionM = 244, RULE_multiplicativeExpression = 245, 
		RULE_multiplicativeExpressionM = 246, RULE_multiplicativeExpressionD = 247, 
		RULE_multiplicativeExpressionMod = 248, RULE_unaryExpression = 249, RULE_unaryExpressionP = 250, 
		RULE_unaryExpressionM = 251, RULE_preIncrementExpression = 252, RULE_preDecrementExpression = 253, 
		RULE_unaryExpressionNotPlusMinus = 254, RULE_unaryExpressionNotPlusMinusBN = 255, 
		RULE_unaryExpressionNotPlusMinusCN = 256, RULE_postfixExpression = 257, 
		RULE_postfixExpressionSymbol = 258, RULE_postIncrementExpression = 259, 
		RULE_postIncrementExpression_lf_postfixExpression = 260, RULE_postDecrementExpression = 261, 
		RULE_postDecrementExpression_lf_postfixExpression = 262, RULE_castExpression = 263;
	public static final String[] ruleNames = {
		"literal", "primitiveType", "numericType", "integralType", "floatingPointType", 
		"referenceType", "classOrInterfaceType", "continuedClassOrInterfaceType", 
		"classType", "classType_lf_classOrInterfaceType", "classType_lfno_classOrInterfaceType", 
		"interfaceType", "interfaceType_lf_classOrInterfaceType", "interfaceType_lfno_classOrInterfaceType", 
		"typeVariable", "arrayType", "dims", "annotatedDim", "dim", "typeParameter", 
		"typeParameterModifier", "typeBound", "additionalBound", "typeArguments", 
		"typeArgumentList", "typeArgument", "wildcard", "wildcardBounds", "wildcardExtends", 
		"packageName", "typeName", "packageOrTypeName", "expressionName", "methodName", 
		"ambiguousName", "compilationUnit", "packageDeclaration", "packageModifier", 
		"importDeclaration", "singleTypeImportDeclaration", "typeImportOnDemandDeclaration", 
		"singleStaticImportDeclaration", "staticImportOnDemandDeclaration", "typeDeclaration", 
		"classDeclaration", "normalClassDeclaration", "classModifier", "typeParameters", 
		"typeParameterList", "superclass", "superinterfaces", "interfaceTypeList", 
		"classBody", "classBodyDeclaration", "classMemberDeclaration", "fieldDeclaration", 
		"fieldModifier", "variableDeclaratorList", "variableDeclarator", "variableDeclaratorId", 
		"variableInitializer", "unannType", "unannPrimitiveType", "unannReferenceType", 
		"unannClassOrInterfaceType", "unannContinuedClassOrInterfaceType", "unannClassType", 
		"unannClassType_lf_unannClassOrInterfaceType", "unannClassType_lfno_unannClassOrInterfaceType", 
		"unannInterfaceType", "unannInterfaceType_lf_unannClassOrInterfaceType", 
		"unannInterfaceType_lfno_unannClassOrInterfaceType", "unannTypeVariable", 
		"unannArrayType", "methodDeclaration", "methodModifier", "methodHeader", 
		"result", "methodDeclarator", "formalParameterList", "formalParameters", 
		"formalParameter", "variableModifier", "lastFormalParameter", "receiverParameter", 
		"throws_", "exceptionTypeList", "exceptionType", "methodBody", "instanceInitializer", 
		"staticInitializer", "constructorDeclaration", "constructorModifier", 
		"constructorDeclarator", "simpleTypeName", "constructorBody", "explicitConstructorInvocation", 
		"enumDeclaration", "enumBody", "enumConstantList", "enumConstant", "enumConstantModifier", 
		"enumBodyDeclarations", "interfaceDeclaration", "normalInterfaceDeclaration", 
		"interfaceModifier", "extendsInterfaces", "interfaceBody", "interfaceMemberDeclaration", 
		"constantDeclaration", "constantModifier", "interfaceMethodDeclaration", 
		"interfaceMethodModifier", "annotationTypeDeclaration", "annotationTypeBody", 
		"annotationTypeMemberDeclaration", "annotationTypeElementDeclaration", 
		"annotationTypeElementModifier", "defaultValue", "annotation", "normalAnnotation", 
		"elementValuePairList", "elementValuePair", "elementValue", "elementValueArrayInitializer", 
		"elementValueList", "markerAnnotation", "singleElementAnnotation", "arrayInitializer", 
		"variableInitializerList", "block", "blockStatements", "blockStatement", 
		"localVariableDeclarationStatement", "localVariableDeclaration", "statement", 
		"statementNoShortIf", "statementWithoutTrailingSubstatement", "emptyStatement", 
		"labeledStatement", "labeledStatementNoShortIf", "expressionStatement", 
		"statementExpression", "ifThenStatement", "ifThenElseStatement", "ifThenElseStatementNoShortIf", 
		"assertStatement", "switchStatement", "switchBlock", "switchBlockStatementGroup", 
		"switchLabels", "switchLabel", "enumConstantName", "whileStatement", "whileStatementNoShortIf", 
		"doStatement", "forStatement", "forStatementNoShortIf", "basicForStatement", 
		"basicForStatementNoShortIf", "forInit", "forUpdate", "statementExpressionList", 
		"enhancedForStatement", "enhancedForStatementNoShortIf", "breakStatement", 
		"continueStatement", "returnStatement", "throwStatement", "synchronizedStatement", 
		"tryStatement", "catches", "catchClause", "catchFormalParameter", "catchType", 
		"finally_", "tryWithResourcesStatement", "resourceSpecification", "resourceList", 
		"resource", "primary", "primaryNoNewArray", "classKeyword", "primaryNoNewArray_lf_arrayAccess", 
		"primaryNoNewArray_lfno_arrayAccess", "primaryNoNewArray_lf_primary", 
		"primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary", "primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary", 
		"primaryNoNewArray_lfno_primary", "primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary", 
		"primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary", "classInstanceCreationExpression", 
		"classInstanceCreationExpression_lf_primary", "classInstanceCreationExpression_lfno_primary", 
		"annotatedQualifierElement", "typeArgumentsOrDiamond", "fieldAccess", 
		"fieldAccess_lf_primary", "fieldAccess_lfno_primary", "arrayAccess", "arrayAccess_lf_primary", 
		"arrayAccess_lfno_primary", "methodInvocation", "superKeyword", "methodInvocation_lf_primary", 
		"methodInvocation_lfno_primary", "argumentList", "methodReference", "methodReference_lf_primary", 
		"methodReference_lfno_primary", "arrayCreationExpression", "dimExprs", 
		"dimExpr", "constantExpression", "expression", "lambdaExpression", "lambdaParameters", 
		"inferredFormalParameterList", "lambdaBody", "assignmentExpression", "assignment", 
		"leftHandSide", "assignmentOperator", "conditionalExpression", "conditionalOrExpression", 
		"conditionalAndExpression", "inclusiveOrExpression", "exclusiveOrExpression", 
		"andExpression", "equalityExpression", "equalityExpressionEqualToSymbol", 
		"equalityExpressionNotEqualToSymbol", "relationalExpression", "relationalExpressionLT", 
		"relationalExpressionGT", "relationalExpressionLTE", "relationalExpressionGTE", 
		"relationalExpressionIO", "shiftExpression", "shiftExpressionSLL", "shiftExpressionSRL", 
		"shiftExpressionSRA", "additiveExpression", "additiveExpressionP", "additiveExpressionM", 
		"multiplicativeExpression", "multiplicativeExpressionM", "multiplicativeExpressionD", 
		"multiplicativeExpressionMod", "unaryExpression", "unaryExpressionP", 
		"unaryExpressionM", "preIncrementExpression", "preDecrementExpression", 
		"unaryExpressionNotPlusMinus", "unaryExpressionNotPlusMinusBN", "unaryExpressionNotPlusMinusCN", 
		"postfixExpression", "postfixExpressionSymbol", "postIncrementExpression", 
		"postIncrementExpression_lf_postfixExpression", "postDecrementExpression", 
		"postDecrementExpression_lf_postfixExpression", "castExpression"
	};

	@Override
	public String getGrammarFileName() { return "Java8Parser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Java8Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(Java8Parser.StringLiteral, 0); }
		public TerminalNode NullLiteral() { return getToken(Java8Parser.NullLiteral, 0); }
		public TerminalNode IntegerLiteral() { return getToken(Java8Parser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(Java8Parser.FloatingPointLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(Java8Parser.BooleanLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(Java8Parser.CharacterLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public NumericTypeContext numericType() {
			return getRuleContext(NumericTypeContext.class,0);
		}
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPrimitiveType(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_primitiveType);
		int _la;
		try {
			setState(544);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(533);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(530); annotation();
					}
					}
					setState(535);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(536); numericType();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(540);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(537); annotation();
					}
					}
					setState(542);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(543); match(BOOLEAN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericTypeContext extends ParserRuleContext {
		public IntegralTypeContext integralType() {
			return getRuleContext(IntegralTypeContext.class,0);
		}
		public FloatingPointTypeContext floatingPointType() {
			return getRuleContext(FloatingPointTypeContext.class,0);
		}
		public NumericTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterNumericType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitNumericType(this);
		}
	}

	public final NumericTypeContext numericType() throws RecognitionException {
		NumericTypeContext _localctx = new NumericTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_numericType);
		try {
			setState(548);
			switch (_input.LA(1)) {
			case BYTE:
			case CHAR:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(546); integralType();
				}
				break;
			case DOUBLE:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(547); floatingPointType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegralTypeContext extends ParserRuleContext {
		public IntegralTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integralType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterIntegralType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitIntegralType(this);
		}
	}

	public final IntegralTypeContext integralType() throws RecognitionException {
		IntegralTypeContext _localctx = new IntegralTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_integralType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BYTE) | (1L << CHAR) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FloatingPointTypeContext extends ParserRuleContext {
		public FloatingPointTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatingPointType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterFloatingPointType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitFloatingPointType(this);
		}
	}

	public final FloatingPointTypeContext floatingPointType() throws RecognitionException {
		FloatingPointTypeContext _localctx = new FloatingPointTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_floatingPointType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			_la = _input.LA(1);
			if ( !(_la==DOUBLE || _la==FLOAT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceTypeContext extends ParserRuleContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public ReferenceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterReferenceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitReferenceType(this);
		}
	}

	public final ReferenceTypeContext referenceType() throws RecognitionException {
		ReferenceTypeContext _localctx = new ReferenceTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_referenceType);
		try {
			setState(557);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(554); classOrInterfaceType();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(555); typeVariable();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(556); arrayType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public ContinuedClassOrInterfaceTypeContext continuedClassOrInterfaceType(int i) {
			return getRuleContext(ContinuedClassOrInterfaceTypeContext.class,i);
		}
		public ClassType_lfno_classOrInterfaceTypeContext classType_lfno_classOrInterfaceType() {
			return getRuleContext(ClassType_lfno_classOrInterfaceTypeContext.class,0);
		}
		public InterfaceType_lfno_classOrInterfaceTypeContext interfaceType_lfno_classOrInterfaceType() {
			return getRuleContext(InterfaceType_lfno_classOrInterfaceTypeContext.class,0);
		}
		public List<ContinuedClassOrInterfaceTypeContext> continuedClassOrInterfaceType() {
			return getRuleContexts(ContinuedClassOrInterfaceTypeContext.class);
		}
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitClassOrInterfaceType(this);
		}
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(559); classType_lfno_classOrInterfaceType();
				}
				break;

			case 2:
				{
				setState(560); interfaceType_lfno_classOrInterfaceType();
				}
				break;
			}
			setState(566);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(563); continuedClassOrInterfaceType();
					}
					} 
				}
				setState(568);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContinuedClassOrInterfaceTypeContext extends ParserRuleContext {
		public InterfaceType_lf_classOrInterfaceTypeContext interfaceType_lf_classOrInterfaceType() {
			return getRuleContext(InterfaceType_lf_classOrInterfaceTypeContext.class,0);
		}
		public ClassType_lf_classOrInterfaceTypeContext classType_lf_classOrInterfaceType() {
			return getRuleContext(ClassType_lf_classOrInterfaceTypeContext.class,0);
		}
		public ContinuedClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continuedClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterContinuedClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitContinuedClassOrInterfaceType(this);
		}
	}

	public final ContinuedClassOrInterfaceTypeContext continuedClassOrInterfaceType() throws RecognitionException {
		ContinuedClassOrInterfaceTypeContext _localctx = new ContinuedClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_continuedClassOrInterfaceType);
		try {
			setState(571);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(569); classType_lf_classOrInterfaceType();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(570); interfaceType_lf_classOrInterfaceType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassTypeContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public ClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitClassType(this);
		}
	}

	public final ClassTypeContext classType() throws RecognitionException {
		ClassTypeContext _localctx = new ClassTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_classType);
		int _la;
		try {
			setState(595);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(576);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(573); annotation();
					}
					}
					setState(578);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(579); match(Identifier);
				setState(581);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(580); typeArguments();
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(583); classOrInterfaceType();
				setState(584); match(DOT);
				setState(588);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(585); annotation();
					}
					}
					setState(590);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(591); match(Identifier);
				setState(593);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(592); typeArguments();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassType_lf_classOrInterfaceTypeContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public ClassType_lf_classOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType_lf_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterClassType_lf_classOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitClassType_lf_classOrInterfaceType(this);
		}
	}

	public final ClassType_lf_classOrInterfaceTypeContext classType_lf_classOrInterfaceType() throws RecognitionException {
		ClassType_lf_classOrInterfaceTypeContext _localctx = new ClassType_lf_classOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_classType_lf_classOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597); match(DOT);
			setState(601);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(598); annotation();
				}
				}
				setState(603);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(604); match(Identifier);
			setState(606);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(605); typeArguments();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassType_lfno_classOrInterfaceTypeContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public ClassType_lfno_classOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType_lfno_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterClassType_lfno_classOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitClassType_lfno_classOrInterfaceType(this);
		}
	}

	public final ClassType_lfno_classOrInterfaceTypeContext classType_lfno_classOrInterfaceType() throws RecognitionException {
		ClassType_lfno_classOrInterfaceTypeContext _localctx = new ClassType_lfno_classOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_classType_lfno_classOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(608); annotation();
				}
				}
				setState(613);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(614); match(Identifier);
			setState(616);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(615); typeArguments();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceTypeContext extends ParserRuleContext {
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public InterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitInterfaceType(this);
		}
	}

	public final InterfaceTypeContext interfaceType() throws RecognitionException {
		InterfaceTypeContext _localctx = new InterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_interfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(618); classType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceType_lf_classOrInterfaceTypeContext extends ParserRuleContext {
		public ClassType_lf_classOrInterfaceTypeContext classType_lf_classOrInterfaceType() {
			return getRuleContext(ClassType_lf_classOrInterfaceTypeContext.class,0);
		}
		public InterfaceType_lf_classOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceType_lf_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterInterfaceType_lf_classOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitInterfaceType_lf_classOrInterfaceType(this);
		}
	}

	public final InterfaceType_lf_classOrInterfaceTypeContext interfaceType_lf_classOrInterfaceType() throws RecognitionException {
		InterfaceType_lf_classOrInterfaceTypeContext _localctx = new InterfaceType_lf_classOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_interfaceType_lf_classOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620); classType_lf_classOrInterfaceType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceType_lfno_classOrInterfaceTypeContext extends ParserRuleContext {
		public ClassType_lfno_classOrInterfaceTypeContext classType_lfno_classOrInterfaceType() {
			return getRuleContext(ClassType_lfno_classOrInterfaceTypeContext.class,0);
		}
		public InterfaceType_lfno_classOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceType_lfno_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterInterfaceType_lfno_classOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitInterfaceType_lfno_classOrInterfaceType(this);
		}
	}

	public final InterfaceType_lfno_classOrInterfaceTypeContext interfaceType_lfno_classOrInterfaceType() throws RecognitionException {
		InterfaceType_lfno_classOrInterfaceTypeContext _localctx = new InterfaceType_lfno_classOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_interfaceType_lfno_classOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622); classType_lfno_classOrInterfaceType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeVariableContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterTypeVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitTypeVariable(this);
		}
	}

	public final TypeVariableContext typeVariable() throws RecognitionException {
		TypeVariableContext _localctx = new TypeVariableContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_typeVariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(624); annotation();
				}
				}
				setState(629);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(630); match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitArrayType(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_arrayType);
		try {
			setState(641);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(632); primitiveType();
				setState(633); dims();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(635); classOrInterfaceType();
				setState(636); dims();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(638); typeVariable();
				setState(639); dims();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimsContext extends ParserRuleContext {
		public AnnotatedDimContext annotatedDim(int i) {
			return getRuleContext(AnnotatedDimContext.class,i);
		}
		public List<AnnotatedDimContext> annotatedDim() {
			return getRuleContexts(AnnotatedDimContext.class);
		}
		public DimsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dims; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterDims(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitDims(this);
		}
	}

	public final DimsContext dims() throws RecognitionException {
		DimsContext _localctx = new DimsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_dims);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(643); annotatedDim();
			setState(647);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(644); annotatedDim();
					}
					} 
				}
				setState(649);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotatedDimContext extends ParserRuleContext {
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public DimContext dim() {
			return getRuleContext(DimContext.class,0);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public AnnotatedDimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotatedDim; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAnnotatedDim(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAnnotatedDim(this);
		}
	}

	public final AnnotatedDimContext annotatedDim() throws RecognitionException {
		AnnotatedDimContext _localctx = new AnnotatedDimContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_annotatedDim);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(650); annotation();
				}
				}
				setState(655);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(656); dim();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimContext extends ParserRuleContext {
		public DimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dim; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterDim(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitDim(this);
		}
	}

	public final DimContext dim() throws RecognitionException {
		DimContext _localctx = new DimContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_dim);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658); match(LBRACK);
			setState(659); match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParameterContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<TypeParameterModifierContext> typeParameterModifier() {
			return getRuleContexts(TypeParameterModifierContext.class);
		}
		public TypeParameterModifierContext typeParameterModifier(int i) {
			return getRuleContext(TypeParameterModifierContext.class,i);
		}
		public TypeBoundContext typeBound() {
			return getRuleContext(TypeBoundContext.class,0);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitTypeParameter(this);
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(664);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(661); typeParameterModifier();
				}
				}
				setState(666);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(667); match(Identifier);
			setState(669);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(668); typeBound();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParameterModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TypeParameterModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterTypeParameterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitTypeParameterModifier(this);
		}
	}

	public final TypeParameterModifierContext typeParameterModifier() throws RecognitionException {
		TypeParameterModifierContext _localctx = new TypeParameterModifierContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_typeParameterModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671); annotation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeBoundContext extends ParserRuleContext {
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public List<AdditionalBoundContext> additionalBound() {
			return getRuleContexts(AdditionalBoundContext.class);
		}
		public AdditionalBoundContext additionalBound(int i) {
			return getRuleContext(AdditionalBoundContext.class,i);
		}
		public TypeBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterTypeBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitTypeBound(this);
		}
	}

	public final TypeBoundContext typeBound() throws RecognitionException {
		TypeBoundContext _localctx = new TypeBoundContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_typeBound);
		int _la;
		try {
			setState(683);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(673); match(EXTENDS);
				setState(674); typeVariable();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(675); match(EXTENDS);
				setState(676); classOrInterfaceType();
				setState(680);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BITAND) {
					{
					{
					setState(677); additionalBound();
					}
					}
					setState(682);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditionalBoundContext extends ParserRuleContext {
		public InterfaceTypeContext interfaceType() {
			return getRuleContext(InterfaceTypeContext.class,0);
		}
		public AdditionalBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additionalBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAdditionalBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAdditionalBound(this);
		}
	}

	public final AdditionalBoundContext additionalBound() throws RecognitionException {
		AdditionalBoundContext _localctx = new AdditionalBoundContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_additionalBound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685); match(BITAND);
			setState(686); interfaceType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentsContext extends ParserRuleContext {
		public TypeArgumentListContext typeArgumentList() {
			return getRuleContext(TypeArgumentListContext.class,0);
		}
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitTypeArguments(this);
		}
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_typeArguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(688); match(LT);
			setState(689); typeArgumentList();
			setState(690); match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentListContext extends ParserRuleContext {
		public List<TypeArgumentContext> typeArgument() {
			return getRuleContexts(TypeArgumentContext.class);
		}
		public TypeArgumentContext typeArgument(int i) {
			return getRuleContext(TypeArgumentContext.class,i);
		}
		public TypeArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterTypeArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitTypeArgumentList(this);
		}
	}

	public final TypeArgumentListContext typeArgumentList() throws RecognitionException {
		TypeArgumentListContext _localctx = new TypeArgumentListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_typeArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(692); typeArgument();
			setState(697);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(693); match(COMMA);
				setState(694); typeArgument();
				}
				}
				setState(699);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentContext extends ParserRuleContext {
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public WildcardContext wildcard() {
			return getRuleContext(WildcardContext.class,0);
		}
		public TypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitTypeArgument(this);
		}
	}

	public final TypeArgumentContext typeArgument() throws RecognitionException {
		TypeArgumentContext _localctx = new TypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_typeArgument);
		try {
			setState(702);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(700); referenceType();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(701); wildcard();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WildcardContext extends ParserRuleContext {
		public WildcardBoundsContext wildcardBounds() {
			return getRuleContext(WildcardBoundsContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public WildcardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitWildcard(this);
		}
	}

	public final WildcardContext wildcard() throws RecognitionException {
		WildcardContext _localctx = new WildcardContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_wildcard);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(707);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(704); annotation();
				}
				}
				setState(709);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(710); match(QUESTION);
			setState(712);
			_la = _input.LA(1);
			if (_la==EXTENDS || _la==SUPER) {
				{
				setState(711); wildcardBounds();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WildcardBoundsContext extends ParserRuleContext {
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public WildcardExtendsContext wildcardExtends() {
			return getRuleContext(WildcardExtendsContext.class,0);
		}
		public WildcardBoundsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcardBounds; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterWildcardBounds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitWildcardBounds(this);
		}
	}

	public final WildcardBoundsContext wildcardBounds() throws RecognitionException {
		WildcardBoundsContext _localctx = new WildcardBoundsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_wildcardBounds);
		try {
			setState(717);
			switch (_input.LA(1)) {
			case EXTENDS:
				enterOuterAlt(_localctx, 1);
				{
				setState(714); wildcardExtends();
				}
				break;
			case SUPER:
				enterOuterAlt(_localctx, 2);
				{
				setState(715); match(SUPER);
				setState(716); referenceType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WildcardExtendsContext extends ParserRuleContext {
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public WildcardExtendsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcardExtends; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterWildcardExtends(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitWildcardExtends(this);
		}
	}

	public final WildcardExtendsContext wildcardExtends() throws RecognitionException {
		WildcardExtendsContext _localctx = new WildcardExtendsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_wildcardExtends);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(719); match(EXTENDS);
			setState(720); referenceType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public PackageNameContext packageName() {
			return getRuleContext(PackageNameContext.class,0);
		}
		public PackageNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPackageName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPackageName(this);
		}
	}

	public final PackageNameContext packageName() throws RecognitionException {
		return packageName(0);
	}

	private PackageNameContext packageName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PackageNameContext _localctx = new PackageNameContext(_ctx, _parentState);
		PackageNameContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_packageName, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(723); match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(730);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PackageNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_packageName);
					setState(725);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(726); match(DOT);
					setState(727); match(Identifier);
					}
					} 
				}
				setState(732);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public PackageOrTypeNameContext packageOrTypeName() {
			return getRuleContext(PackageOrTypeNameContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitTypeName(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_typeName);
		try {
			setState(738);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(733); match(Identifier);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(734); packageOrTypeName(0);
				setState(735); match(DOT);
				setState(736); match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageOrTypeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public PackageOrTypeNameContext packageOrTypeName() {
			return getRuleContext(PackageOrTypeNameContext.class,0);
		}
		public PackageOrTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageOrTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPackageOrTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPackageOrTypeName(this);
		}
	}

	public final PackageOrTypeNameContext packageOrTypeName() throws RecognitionException {
		return packageOrTypeName(0);
	}

	private PackageOrTypeNameContext packageOrTypeName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PackageOrTypeNameContext _localctx = new PackageOrTypeNameContext(_ctx, _parentState);
		PackageOrTypeNameContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_packageOrTypeName, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(741); match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(748);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PackageOrTypeNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_packageOrTypeName);
					setState(743);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(744); match(DOT);
					setState(745); match(Identifier);
					}
					} 
				}
				setState(750);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public AmbiguousNameContext ambiguousName() {
			return getRuleContext(AmbiguousNameContext.class,0);
		}
		public ExpressionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterExpressionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitExpressionName(this);
		}
	}

	public final ExpressionNameContext expressionName() throws RecognitionException {
		ExpressionNameContext _localctx = new ExpressionNameContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_expressionName);
		try {
			setState(756);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(751); match(Identifier);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(752); ambiguousName(0);
				setState(753); match(DOT);
				setState(754); match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public MethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMethodName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMethodName(this);
		}
	}

	public final MethodNameContext methodName() throws RecognitionException {
		MethodNameContext _localctx = new MethodNameContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_methodName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758); match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AmbiguousNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public AmbiguousNameContext ambiguousName() {
			return getRuleContext(AmbiguousNameContext.class,0);
		}
		public AmbiguousNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ambiguousName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAmbiguousName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAmbiguousName(this);
		}
	}

	public final AmbiguousNameContext ambiguousName() throws RecognitionException {
		return ambiguousName(0);
	}

	private AmbiguousNameContext ambiguousName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AmbiguousNameContext _localctx = new AmbiguousNameContext(_ctx, _parentState);
		AmbiguousNameContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_ambiguousName, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(761); match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(768);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AmbiguousNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_ambiguousName);
					setState(763);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(764); match(DOT);
					setState(765); match(Identifier);
					}
					} 
				}
				setState(770);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CompilationUnitContext extends ParserRuleContext {
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public TerminalNode EOF() { return getToken(Java8Parser.EOF, 0); }
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitCompilationUnit(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(772);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(771); packageDeclaration();
				}
				break;
			}
			setState(777);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(774); importDeclaration();
				}
				}
				setState(779);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(783);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << CLASS) | (1L << ENUM) | (1L << FINAL) | (1L << INTERFACE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP) | (1L << SEMI))) != 0) || _la==AT) {
				{
				{
				setState(780); typeDeclaration();
				}
				}
				setState(785);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(786); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageDeclarationContext extends ParserRuleContext {
		public List<PackageModifierContext> packageModifier() {
			return getRuleContexts(PackageModifierContext.class);
		}
		public PackageModifierContext packageModifier(int i) {
			return getRuleContext(PackageModifierContext.class,i);
		}
		public PackageNameContext packageName() {
			return getRuleContext(PackageNameContext.class,0);
		}
		public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPackageDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPackageDeclaration(this);
		}
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_packageDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(791);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(788); packageModifier();
				}
				}
				setState(793);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(794); match(PACKAGE);
			setState(795); packageName(0);
			setState(796); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public PackageModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPackageModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPackageModifier(this);
		}
	}

	public final PackageModifierContext packageModifier() throws RecognitionException {
		PackageModifierContext _localctx = new PackageModifierContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_packageModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798); annotation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportDeclarationContext extends ParserRuleContext {
		public SingleStaticImportDeclarationContext singleStaticImportDeclaration() {
			return getRuleContext(SingleStaticImportDeclarationContext.class,0);
		}
		public StaticImportOnDemandDeclarationContext staticImportOnDemandDeclaration() {
			return getRuleContext(StaticImportOnDemandDeclarationContext.class,0);
		}
		public SingleTypeImportDeclarationContext singleTypeImportDeclaration() {
			return getRuleContext(SingleTypeImportDeclarationContext.class,0);
		}
		public TypeImportOnDemandDeclarationContext typeImportOnDemandDeclaration() {
			return getRuleContext(TypeImportOnDemandDeclarationContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitImportDeclaration(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_importDeclaration);
		try {
			setState(804);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(800); singleTypeImportDeclaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(801); typeImportOnDemandDeclaration();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(802); singleStaticImportDeclaration();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(803); staticImportOnDemandDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleTypeImportDeclarationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public SingleTypeImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleTypeImportDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterSingleTypeImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitSingleTypeImportDeclaration(this);
		}
	}

	public final SingleTypeImportDeclarationContext singleTypeImportDeclaration() throws RecognitionException {
		SingleTypeImportDeclarationContext _localctx = new SingleTypeImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_singleTypeImportDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(806); match(IMPORT);
			setState(807); typeName();
			setState(808); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeImportOnDemandDeclarationContext extends ParserRuleContext {
		public PackageOrTypeNameContext packageOrTypeName() {
			return getRuleContext(PackageOrTypeNameContext.class,0);
		}
		public TypeImportOnDemandDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeImportOnDemandDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterTypeImportOnDemandDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitTypeImportOnDemandDeclaration(this);
		}
	}

	public final TypeImportOnDemandDeclarationContext typeImportOnDemandDeclaration() throws RecognitionException {
		TypeImportOnDemandDeclarationContext _localctx = new TypeImportOnDemandDeclarationContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_typeImportOnDemandDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(810); match(IMPORT);
			setState(811); packageOrTypeName(0);
			setState(812); match(DOT);
			setState(813); match(MUL);
			setState(814); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleStaticImportDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public SingleStaticImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStaticImportDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterSingleStaticImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitSingleStaticImportDeclaration(this);
		}
	}

	public final SingleStaticImportDeclarationContext singleStaticImportDeclaration() throws RecognitionException {
		SingleStaticImportDeclarationContext _localctx = new SingleStaticImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_singleStaticImportDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(816); match(IMPORT);
			setState(817); match(STATIC);
			setState(818); typeName();
			setState(819); match(DOT);
			setState(820); match(Identifier);
			setState(821); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StaticImportOnDemandDeclarationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public StaticImportOnDemandDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticImportOnDemandDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterStaticImportOnDemandDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitStaticImportOnDemandDeclaration(this);
		}
	}

	public final StaticImportOnDemandDeclarationContext staticImportOnDemandDeclaration() throws RecognitionException {
		StaticImportOnDemandDeclarationContext _localctx = new StaticImportOnDemandDeclarationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_staticImportOnDemandDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(823); match(IMPORT);
			setState(824); match(STATIC);
			setState(825); typeName();
			setState(826); match(DOT);
			setState(827); match(MUL);
			setState(828); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitTypeDeclaration(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_typeDeclaration);
		try {
			setState(833);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(830); classDeclaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(831); interfaceDeclaration();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(832); match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public NormalClassDeclarationContext normalClassDeclaration() {
			return getRuleContext(NormalClassDeclarationContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_classDeclaration);
		try {
			setState(837);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(835); normalClassDeclaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(836); enumDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NormalClassDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public List<ClassModifierContext> classModifier() {
			return getRuleContexts(ClassModifierContext.class);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ClassModifierContext classModifier(int i) {
			return getRuleContext(ClassModifierContext.class,i);
		}
		public SuperclassContext superclass() {
			return getRuleContext(SuperclassContext.class,0);
		}
		public SuperinterfacesContext superinterfaces() {
			return getRuleContext(SuperinterfacesContext.class,0);
		}
		public NormalClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalClassDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterNormalClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitNormalClassDeclaration(this);
		}
	}

	public final NormalClassDeclarationContext normalClassDeclaration() throws RecognitionException {
		NormalClassDeclarationContext _localctx = new NormalClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_normalClassDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(842);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==AT) {
				{
				{
				setState(839); classModifier();
				}
				}
				setState(844);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(845); match(CLASS);
			setState(846); match(Identifier);
			setState(848);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(847); typeParameters();
				}
			}

			setState(851);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(850); superclass();
				}
			}

			setState(854);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(853); superinterfaces();
				}
			}

			setState(856); classBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ClassModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterClassModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitClassModifier(this);
		}
	}

	public final ClassModifierContext classModifier() throws RecognitionException {
		ClassModifierContext _localctx = new ClassModifierContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_classModifier);
		try {
			setState(866);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(858); annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(859); match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(860); match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(861); match(PRIVATE);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 5);
				{
				setState(862); match(ABSTRACT);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 6);
				{
				setState(863); match(STATIC);
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 7);
				{
				setState(864); match(FINAL);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 8);
				{
				setState(865); match(STRICTFP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParametersContext extends ParserRuleContext {
		public TypeParameterListContext typeParameterList() {
			return getRuleContext(TypeParameterListContext.class,0);
		}
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitTypeParameters(this);
		}
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_typeParameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(868); match(LT);
			setState(869); typeParameterList();
			setState(870); match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParameterListContext extends ParserRuleContext {
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
		public TypeParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterTypeParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitTypeParameterList(this);
		}
	}

	public final TypeParameterListContext typeParameterList() throws RecognitionException {
		TypeParameterListContext _localctx = new TypeParameterListContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_typeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(872); typeParameter();
			setState(877);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(873); match(COMMA);
				setState(874); typeParameter();
				}
				}
				setState(879);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuperclassContext extends ParserRuleContext {
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public SuperclassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superclass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterSuperclass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitSuperclass(this);
		}
	}

	public final SuperclassContext superclass() throws RecognitionException {
		SuperclassContext _localctx = new SuperclassContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_superclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(880); match(EXTENDS);
			setState(881); classType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuperinterfacesContext extends ParserRuleContext {
		public InterfaceTypeListContext interfaceTypeList() {
			return getRuleContext(InterfaceTypeListContext.class,0);
		}
		public SuperinterfacesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superinterfaces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterSuperinterfaces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitSuperinterfaces(this);
		}
	}

	public final SuperinterfacesContext superinterfaces() throws RecognitionException {
		SuperinterfacesContext _localctx = new SuperinterfacesContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_superinterfaces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(883); match(IMPLEMENTS);
			setState(884); interfaceTypeList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceTypeListContext extends ParserRuleContext {
		public List<InterfaceTypeContext> interfaceType() {
			return getRuleContexts(InterfaceTypeContext.class);
		}
		public InterfaceTypeContext interfaceType(int i) {
			return getRuleContext(InterfaceTypeContext.class,i);
		}
		public InterfaceTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterInterfaceTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitInterfaceTypeList(this);
		}
	}

	public final InterfaceTypeListContext interfaceTypeList() throws RecognitionException {
		InterfaceTypeListContext _localctx = new InterfaceTypeListContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_interfaceTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(886); interfaceType();
			setState(891);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(887); match(COMMA);
				setState(888); interfaceType();
				}
				}
				setState(893);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyContext extends ParserRuleContext {
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitClassBody(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(894); match(LBRACE);
			setState(898);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOID) | (1L << VOLATILE) | (1L << LBRACE) | (1L << SEMI))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (Identifier - 68)) | (1L << (AT - 68)))) != 0)) {
				{
				{
				setState(895); classBodyDeclaration();
				}
				}
				setState(900);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(901); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public ClassMemberDeclarationContext classMemberDeclaration() {
			return getRuleContext(ClassMemberDeclarationContext.class,0);
		}
		public StaticInitializerContext staticInitializer() {
			return getRuleContext(StaticInitializerContext.class,0);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public InstanceInitializerContext instanceInitializer() {
			return getRuleContext(InstanceInitializerContext.class,0);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitClassBodyDeclaration(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_classBodyDeclaration);
		try {
			setState(907);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(903); classMemberDeclaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(904); instanceInitializer();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(905); staticInitializer();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(906); constructorDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassMemberDeclarationContext extends ParserRuleContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public ClassMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMemberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterClassMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitClassMemberDeclaration(this);
		}
	}

	public final ClassMemberDeclarationContext classMemberDeclaration() throws RecognitionException {
		ClassMemberDeclarationContext _localctx = new ClassMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_classMemberDeclaration);
		try {
			setState(914);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(909); fieldDeclaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(910); methodDeclaration();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(911); classDeclaration();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(912); interfaceDeclaration();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(913); match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclarationContext extends ParserRuleContext {
		public List<FieldModifierContext> fieldModifier() {
			return getRuleContexts(FieldModifierContext.class);
		}
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorListContext variableDeclaratorList() {
			return getRuleContext(VariableDeclaratorListContext.class,0);
		}
		public FieldModifierContext fieldModifier(int i) {
			return getRuleContext(FieldModifierContext.class,i);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitFieldDeclaration(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_fieldDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(919);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << TRANSIENT) | (1L << VOLATILE))) != 0) || _la==AT) {
				{
				{
				setState(916); fieldModifier();
				}
				}
				setState(921);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(922); unannType();
			setState(923); variableDeclaratorList();
			setState(924); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public FieldModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterFieldModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitFieldModifier(this);
		}
	}

	public final FieldModifierContext fieldModifier() throws RecognitionException {
		FieldModifierContext _localctx = new FieldModifierContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_fieldModifier);
		try {
			setState(934);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(926); annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(927); match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(928); match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(929); match(PRIVATE);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 5);
				{
				setState(930); match(STATIC);
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(931); match(FINAL);
				}
				break;
			case TRANSIENT:
				enterOuterAlt(_localctx, 7);
				{
				setState(932); match(TRANSIENT);
				}
				break;
			case VOLATILE:
				enterOuterAlt(_localctx, 8);
				{
				setState(933); match(VOLATILE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorListContext extends ParserRuleContext {
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public VariableDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterVariableDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitVariableDeclaratorList(this);
		}
	}

	public final VariableDeclaratorListContext variableDeclaratorList() throws RecognitionException {
		VariableDeclaratorListContext _localctx = new VariableDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_variableDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(936); variableDeclarator();
			setState(941);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(937); match(COMMA);
				setState(938); variableDeclarator();
				}
				}
				setState(943);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorContext extends ParserRuleContext {
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitVariableDeclarator(this);
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(944); variableDeclaratorId();
			setState(947);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(945); match(ASSIGN);
				setState(946); variableInitializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorIdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public VariableDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterVariableDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitVariableDeclaratorId(this);
		}
	}

	public final VariableDeclaratorIdContext variableDeclaratorId() throws RecognitionException {
		VariableDeclaratorIdContext _localctx = new VariableDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_variableDeclaratorId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(949); match(Identifier);
			setState(951);
			_la = _input.LA(1);
			if (_la==LBRACK || _la==AT) {
				{
				setState(950); dims();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableInitializerContext extends ParserRuleContext {
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterVariableInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitVariableInitializer(this);
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_variableInitializer);
		try {
			setState(955);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(953); expression();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(954); arrayInitializer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannTypeContext extends ParserRuleContext {
		public UnannReferenceTypeContext unannReferenceType() {
			return getRuleContext(UnannReferenceTypeContext.class,0);
		}
		public UnannPrimitiveTypeContext unannPrimitiveType() {
			return getRuleContext(UnannPrimitiveTypeContext.class,0);
		}
		public UnannTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnannType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnannType(this);
		}
	}

	public final UnannTypeContext unannType() throws RecognitionException {
		UnannTypeContext _localctx = new UnannTypeContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_unannType);
		try {
			setState(959);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(957); unannPrimitiveType();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(958); unannReferenceType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannPrimitiveTypeContext extends ParserRuleContext {
		public NumericTypeContext numericType() {
			return getRuleContext(NumericTypeContext.class,0);
		}
		public UnannPrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannPrimitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnannPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnannPrimitiveType(this);
		}
	}

	public final UnannPrimitiveTypeContext unannPrimitiveType() throws RecognitionException {
		UnannPrimitiveTypeContext _localctx = new UnannPrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_unannPrimitiveType);
		try {
			setState(963);
			switch (_input.LA(1)) {
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(961); numericType();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(962); match(BOOLEAN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannReferenceTypeContext extends ParserRuleContext {
		public UnannArrayTypeContext unannArrayType() {
			return getRuleContext(UnannArrayTypeContext.class,0);
		}
		public UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() {
			return getRuleContext(UnannClassOrInterfaceTypeContext.class,0);
		}
		public UnannTypeVariableContext unannTypeVariable() {
			return getRuleContext(UnannTypeVariableContext.class,0);
		}
		public UnannReferenceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannReferenceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnannReferenceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnannReferenceType(this);
		}
	}

	public final UnannReferenceTypeContext unannReferenceType() throws RecognitionException {
		UnannReferenceTypeContext _localctx = new UnannReferenceTypeContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_unannReferenceType);
		try {
			setState(968);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(965); unannClassOrInterfaceType();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(966); unannTypeVariable();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(967); unannArrayType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannClassOrInterfaceTypeContext extends ParserRuleContext {
		public List<UnannContinuedClassOrInterfaceTypeContext> unannContinuedClassOrInterfaceType() {
			return getRuleContexts(UnannContinuedClassOrInterfaceTypeContext.class);
		}
		public UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext unannInterfaceType_lfno_unannClassOrInterfaceType() {
			return getRuleContext(UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext.class,0);
		}
		public UnannContinuedClassOrInterfaceTypeContext unannContinuedClassOrInterfaceType(int i) {
			return getRuleContext(UnannContinuedClassOrInterfaceTypeContext.class,i);
		}
		public UnannClassType_lfno_unannClassOrInterfaceTypeContext unannClassType_lfno_unannClassOrInterfaceType() {
			return getRuleContext(UnannClassType_lfno_unannClassOrInterfaceTypeContext.class,0);
		}
		public UnannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnannClassOrInterfaceType(this);
		}
	}

	public final UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() throws RecognitionException {
		UnannClassOrInterfaceTypeContext _localctx = new UnannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_unannClassOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(972);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(970); unannClassType_lfno_unannClassOrInterfaceType();
				}
				break;

			case 2:
				{
				setState(971); unannInterfaceType_lfno_unannClassOrInterfaceType();
				}
				break;
			}
			setState(977);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(974); unannContinuedClassOrInterfaceType();
					}
					} 
				}
				setState(979);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannContinuedClassOrInterfaceTypeContext extends ParserRuleContext {
		public UnannInterfaceType_lf_unannClassOrInterfaceTypeContext unannInterfaceType_lf_unannClassOrInterfaceType() {
			return getRuleContext(UnannInterfaceType_lf_unannClassOrInterfaceTypeContext.class,0);
		}
		public UnannClassType_lf_unannClassOrInterfaceTypeContext unannClassType_lf_unannClassOrInterfaceType() {
			return getRuleContext(UnannClassType_lf_unannClassOrInterfaceTypeContext.class,0);
		}
		public UnannContinuedClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannContinuedClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnannContinuedClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnannContinuedClassOrInterfaceType(this);
		}
	}

	public final UnannContinuedClassOrInterfaceTypeContext unannContinuedClassOrInterfaceType() throws RecognitionException {
		UnannContinuedClassOrInterfaceTypeContext _localctx = new UnannContinuedClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_unannContinuedClassOrInterfaceType);
		try {
			setState(982);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(980); unannClassType_lf_unannClassOrInterfaceType();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(981); unannInterfaceType_lf_unannClassOrInterfaceType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannClassTypeContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() {
			return getRuleContext(UnannClassOrInterfaceTypeContext.class,0);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public UnannClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnannClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnannClassType(this);
		}
	}

	public final UnannClassTypeContext unannClassType() throws RecognitionException {
		UnannClassTypeContext _localctx = new UnannClassTypeContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_unannClassType);
		int _la;
		try {
			setState(1000);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(984); match(Identifier);
				setState(986);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(985); typeArguments();
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(988); unannClassOrInterfaceType();
				setState(989); match(DOT);
				setState(993);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(990); annotation();
					}
					}
					setState(995);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(996); match(Identifier);
				setState(998);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(997); typeArguments();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannClassType_lf_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public UnannClassType_lf_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassType_lf_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnannClassType_lf_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnannClassType_lf_unannClassOrInterfaceType(this);
		}
	}

	public final UnannClassType_lf_unannClassOrInterfaceTypeContext unannClassType_lf_unannClassOrInterfaceType() throws RecognitionException {
		UnannClassType_lf_unannClassOrInterfaceTypeContext _localctx = new UnannClassType_lf_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_unannClassType_lf_unannClassOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1002); match(DOT);
			setState(1006);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1003); annotation();
				}
				}
				setState(1008);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1009); match(Identifier);
			setState(1011);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1010); typeArguments();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannClassType_lfno_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public UnannClassType_lfno_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassType_lfno_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnannClassType_lfno_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnannClassType_lfno_unannClassOrInterfaceType(this);
		}
	}

	public final UnannClassType_lfno_unannClassOrInterfaceTypeContext unannClassType_lfno_unannClassOrInterfaceType() throws RecognitionException {
		UnannClassType_lfno_unannClassOrInterfaceTypeContext _localctx = new UnannClassType_lfno_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_unannClassType_lfno_unannClassOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1013); match(Identifier);
			setState(1015);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1014); typeArguments();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannInterfaceTypeContext extends ParserRuleContext {
		public UnannClassTypeContext unannClassType() {
			return getRuleContext(UnannClassTypeContext.class,0);
		}
		public UnannInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnannInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnannInterfaceType(this);
		}
	}

	public final UnannInterfaceTypeContext unannInterfaceType() throws RecognitionException {
		UnannInterfaceTypeContext _localctx = new UnannInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_unannInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1017); unannClassType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannInterfaceType_lf_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public UnannClassType_lf_unannClassOrInterfaceTypeContext unannClassType_lf_unannClassOrInterfaceType() {
			return getRuleContext(UnannClassType_lf_unannClassOrInterfaceTypeContext.class,0);
		}
		public UnannInterfaceType_lf_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannInterfaceType_lf_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnannInterfaceType_lf_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnannInterfaceType_lf_unannClassOrInterfaceType(this);
		}
	}

	public final UnannInterfaceType_lf_unannClassOrInterfaceTypeContext unannInterfaceType_lf_unannClassOrInterfaceType() throws RecognitionException {
		UnannInterfaceType_lf_unannClassOrInterfaceTypeContext _localctx = new UnannInterfaceType_lf_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_unannInterfaceType_lf_unannClassOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1019); unannClassType_lf_unannClassOrInterfaceType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public UnannClassType_lfno_unannClassOrInterfaceTypeContext unannClassType_lfno_unannClassOrInterfaceType() {
			return getRuleContext(UnannClassType_lfno_unannClassOrInterfaceTypeContext.class,0);
		}
		public UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannInterfaceType_lfno_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnannInterfaceType_lfno_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnannInterfaceType_lfno_unannClassOrInterfaceType(this);
		}
	}

	public final UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext unannInterfaceType_lfno_unannClassOrInterfaceType() throws RecognitionException {
		UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext _localctx = new UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_unannInterfaceType_lfno_unannClassOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1021); unannClassType_lfno_unannClassOrInterfaceType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannTypeVariableContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public UnannTypeVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannTypeVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnannTypeVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnannTypeVariable(this);
		}
	}

	public final UnannTypeVariableContext unannTypeVariable() throws RecognitionException {
		UnannTypeVariableContext _localctx = new UnannTypeVariableContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_unannTypeVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1023); match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannArrayTypeContext extends ParserRuleContext {
		public UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() {
			return getRuleContext(UnannClassOrInterfaceTypeContext.class,0);
		}
		public UnannTypeVariableContext unannTypeVariable() {
			return getRuleContext(UnannTypeVariableContext.class,0);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public UnannPrimitiveTypeContext unannPrimitiveType() {
			return getRuleContext(UnannPrimitiveTypeContext.class,0);
		}
		public UnannArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannArrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnannArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnannArrayType(this);
		}
	}

	public final UnannArrayTypeContext unannArrayType() throws RecognitionException {
		UnannArrayTypeContext _localctx = new UnannArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_unannArrayType);
		try {
			setState(1034);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1025); unannPrimitiveType();
				setState(1026); dims();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1028); unannClassOrInterfaceType();
				setState(1029); dims();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1031); unannTypeVariable();
				setState(1032); dims();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public MethodHeaderContext methodHeader() {
			return getRuleContext(MethodHeaderContext.class,0);
		}
		public List<MethodModifierContext> methodModifier() {
			return getRuleContexts(MethodModifierContext.class);
		}
		public MethodModifierContext methodModifier(int i) {
			return getRuleContext(MethodModifierContext.class,i);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1039);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED))) != 0) || _la==AT) {
				{
				{
				setState(1036); methodModifier();
				}
				}
				setState(1041);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1042); methodHeader();
			setState(1043); methodBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public MethodModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMethodModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMethodModifier(this);
		}
	}

	public final MethodModifierContext methodModifier() throws RecognitionException {
		MethodModifierContext _localctx = new MethodModifierContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_methodModifier);
		try {
			setState(1055);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1045); annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1046); match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(1047); match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1048); match(PRIVATE);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 5);
				{
				setState(1049); match(ABSTRACT);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 6);
				{
				setState(1050); match(STATIC);
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 7);
				{
				setState(1051); match(FINAL);
				}
				break;
			case SYNCHRONIZED:
				enterOuterAlt(_localctx, 8);
				{
				setState(1052); match(SYNCHRONIZED);
				}
				break;
			case NATIVE:
				enterOuterAlt(_localctx, 9);
				{
				setState(1053); match(NATIVE);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 10);
				{
				setState(1054); match(STRICTFP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodHeaderContext extends ParserRuleContext {
		public Throws_Context throws_() {
			return getRuleContext(Throws_Context.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public MethodDeclaratorContext methodDeclarator() {
			return getRuleContext(MethodDeclaratorContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public MethodHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMethodHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMethodHeader(this);
		}
	}

	public final MethodHeaderContext methodHeader() throws RecognitionException {
		MethodHeaderContext _localctx = new MethodHeaderContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_methodHeader);
		int _la;
		try {
			setState(1074);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VOID:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1057); result();
				setState(1058); methodDeclarator();
				setState(1060);
				_la = _input.LA(1);
				if (_la==THROWS) {
					{
					setState(1059); throws_();
					}
				}

				}
				break;
			case LT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1062); typeParameters();
				setState(1066);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(1063); annotation();
					}
					}
					setState(1068);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1069); result();
				setState(1070); methodDeclarator();
				setState(1072);
				_la = _input.LA(1);
				if (_la==THROWS) {
					{
					setState(1071); throws_();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResultContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitResult(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_result);
		try {
			setState(1078);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1076); unannType();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(1077); match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclaratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public MethodDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMethodDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMethodDeclarator(this);
		}
	}

	public final MethodDeclaratorContext methodDeclarator() throws RecognitionException {
		MethodDeclaratorContext _localctx = new MethodDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_methodDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1080); match(Identifier);
			setState(1081); match(LPAREN);
			setState(1083);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || _la==Identifier || _la==AT) {
				{
				setState(1082); formalParameterList();
				}
			}

			setState(1085); match(RPAREN);
			setState(1087);
			_la = _input.LA(1);
			if (_la==LBRACK || _la==AT) {
				{
				setState(1086); dims();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterListContext extends ParserRuleContext {
		public LastFormalParameterContext lastFormalParameter() {
			return getRuleContext(LastFormalParameterContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public ReceiverParameterContext receiverParameter() {
			return getRuleContext(ReceiverParameterContext.class,0);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitFormalParameterList(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_formalParameterList);
		try {
			setState(1095);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1089); receiverParameter();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1090); formalParameters();
				setState(1091); match(COMMA);
				setState(1092); lastFormalParameter();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1094); lastFormalParameter();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParametersContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public ReceiverParameterContext receiverParameter() {
			return getRuleContext(ReceiverParameterContext.class,0);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitFormalParameters(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_formalParameters);
		try {
			int _alt;
			setState(1113);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1097); formalParameter();
				setState(1102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1098); match(COMMA);
						setState(1099); formalParameter();
						}
						} 
					}
					setState(1104);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1105); receiverParameter();
				setState(1110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1106); match(COMMA);
						setState(1107); formalParameter();
						}
						} 
					}
					setState(1112);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterContext extends ParserRuleContext {
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitFormalParameter(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_formalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1115); variableModifier();
				}
				}
				setState(1120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1121); unannType();
			setState(1122); variableDeclaratorId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public VariableModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterVariableModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitVariableModifier(this);
		}
	}

	public final VariableModifierContext variableModifier() throws RecognitionException {
		VariableModifierContext _localctx = new VariableModifierContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_variableModifier);
		try {
			setState(1126);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1124); annotation();
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1125); match(FINAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LastFormalParameterContext extends ParserRuleContext {
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public FormalParameterContext formalParameter() {
			return getRuleContext(FormalParameterContext.class,0);
		}
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public LastFormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastFormalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterLastFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitLastFormalParameter(this);
		}
	}

	public final LastFormalParameterContext lastFormalParameter() throws RecognitionException {
		LastFormalParameterContext _localctx = new LastFormalParameterContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_lastFormalParameter);
		int _la;
		try {
			setState(1145);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FINAL || _la==AT) {
					{
					{
					setState(1128); variableModifier();
					}
					}
					setState(1133);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1134); unannType();
				setState(1138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(1135); annotation();
					}
					}
					setState(1140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1141); match(ELLIPSIS);
				setState(1142); variableDeclaratorId();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1144); formalParameter();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReceiverParameterContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public ReceiverParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiverParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterReceiverParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitReceiverParameter(this);
		}
	}

	public final ReceiverParameterContext receiverParameter() throws RecognitionException {
		ReceiverParameterContext _localctx = new ReceiverParameterContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_receiverParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1147); annotation();
				}
				}
				setState(1152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1153); unannType();
			setState(1156);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1154); match(Identifier);
				setState(1155); match(DOT);
				}
			}

			setState(1158); match(THIS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Throws_Context extends ParserRuleContext {
		public ExceptionTypeListContext exceptionTypeList() {
			return getRuleContext(ExceptionTypeListContext.class,0);
		}
		public Throws_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throws_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterThrows_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitThrows_(this);
		}
	}

	public final Throws_Context throws_() throws RecognitionException {
		Throws_Context _localctx = new Throws_Context(_ctx, getState());
		enterRule(_localctx, 170, RULE_throws_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1160); match(THROWS);
			setState(1161); exceptionTypeList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExceptionTypeListContext extends ParserRuleContext {
		public List<ExceptionTypeContext> exceptionType() {
			return getRuleContexts(ExceptionTypeContext.class);
		}
		public ExceptionTypeContext exceptionType(int i) {
			return getRuleContext(ExceptionTypeContext.class,i);
		}
		public ExceptionTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterExceptionTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitExceptionTypeList(this);
		}
	}

	public final ExceptionTypeListContext exceptionTypeList() throws RecognitionException {
		ExceptionTypeListContext _localctx = new ExceptionTypeListContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_exceptionTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1163); exceptionType();
			setState(1168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1164); match(COMMA);
				setState(1165); exceptionType();
				}
				}
				setState(1170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExceptionTypeContext extends ParserRuleContext {
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public ExceptionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterExceptionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitExceptionType(this);
		}
	}

	public final ExceptionTypeContext exceptionType() throws RecognitionException {
		ExceptionTypeContext _localctx = new ExceptionTypeContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_exceptionType);
		try {
			setState(1173);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1171); classType();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1172); typeVariable();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMethodBody(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_methodBody);
		try {
			setState(1177);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1175); block();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(1176); match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceInitializerContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public InstanceInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterInstanceInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitInstanceInitializer(this);
		}
	}

	public final InstanceInitializerContext instanceInitializer() throws RecognitionException {
		InstanceInitializerContext _localctx = new InstanceInitializerContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_instanceInitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1179); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StaticInitializerContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StaticInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterStaticInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitStaticInitializer(this);
		}
	}

	public final StaticInitializerContext staticInitializer() throws RecognitionException {
		StaticInitializerContext _localctx = new StaticInitializerContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_staticInitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1181); match(STATIC);
			setState(1182); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public ConstructorBodyContext constructorBody() {
			return getRuleContext(ConstructorBodyContext.class,0);
		}
		public Throws_Context throws_() {
			return getRuleContext(Throws_Context.class,0);
		}
		public ConstructorDeclaratorContext constructorDeclarator() {
			return getRuleContext(ConstructorDeclaratorContext.class,0);
		}
		public List<ConstructorModifierContext> constructorModifier() {
			return getRuleContexts(ConstructorModifierContext.class);
		}
		public ConstructorModifierContext constructorModifier(int i) {
			return getRuleContext(ConstructorModifierContext.class,i);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitConstructorDeclaration(this);
		}
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_constructorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC))) != 0) || _la==AT) {
				{
				{
				setState(1184); constructorModifier();
				}
				}
				setState(1189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1190); constructorDeclarator();
			setState(1192);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(1191); throws_();
				}
			}

			setState(1194); constructorBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ConstructorModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterConstructorModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitConstructorModifier(this);
		}
	}

	public final ConstructorModifierContext constructorModifier() throws RecognitionException {
		ConstructorModifierContext _localctx = new ConstructorModifierContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_constructorModifier);
		try {
			setState(1200);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1196); annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1197); match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(1198); match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1199); match(PRIVATE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorDeclaratorContext extends ParserRuleContext {
		public SimpleTypeNameContext simpleTypeName() {
			return getRuleContext(SimpleTypeNameContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ConstructorDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterConstructorDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitConstructorDeclarator(this);
		}
	}

	public final ConstructorDeclaratorContext constructorDeclarator() throws RecognitionException {
		ConstructorDeclaratorContext _localctx = new ConstructorDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_constructorDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1203);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1202); typeParameters();
				}
			}

			setState(1205); simpleTypeName();
			setState(1206); match(LPAREN);
			setState(1208);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || _la==Identifier || _la==AT) {
				{
				setState(1207); formalParameterList();
				}
			}

			setState(1210); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleTypeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public SimpleTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterSimpleTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitSimpleTypeName(this);
		}
	}

	public final SimpleTypeNameContext simpleTypeName() throws RecognitionException {
		SimpleTypeNameContext _localctx = new SimpleTypeNameContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_simpleTypeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1212); match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorBodyContext extends ParserRuleContext {
		public ExplicitConstructorInvocationContext explicitConstructorInvocation() {
			return getRuleContext(ExplicitConstructorInvocationContext.class,0);
		}
		public BlockStatementsContext blockStatements() {
			return getRuleContext(BlockStatementsContext.class,0);
		}
		public ConstructorBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterConstructorBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitConstructorBody(this);
		}
	}

	public final ConstructorBodyContext constructorBody() throws RecognitionException {
		ConstructorBodyContext _localctx = new ConstructorBodyContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_constructorBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1214); match(LBRACE);
			setState(1216);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				{
				setState(1215); explicitConstructorInvocation();
				}
				break;
			}
			setState(1219);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SUPER) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (INC - 79)) | (1L << (DEC - 79)) | (1L << (Identifier - 79)) | (1L << (AT - 79)))) != 0)) {
				{
				setState(1218); blockStatements();
				}
			}

			setState(1221); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplicitConstructorInvocationContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public SuperKeywordContext superKeyword() {
			return getRuleContext(SuperKeywordContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ExplicitConstructorInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitConstructorInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterExplicitConstructorInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitExplicitConstructorInvocation(this);
		}
	}

	public final ExplicitConstructorInvocationContext explicitConstructorInvocation() throws RecognitionException {
		ExplicitConstructorInvocationContext _localctx = new ExplicitConstructorInvocationContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_explicitConstructorInvocation);
		int _la;
		try {
			setState(1270);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1224);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1223); typeArguments();
					}
				}

				setState(1226); match(THIS);
				setState(1227); match(LPAREN);
				setState(1229);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(1228); argumentList();
					}
				}

				setState(1231); match(RPAREN);
				setState(1232); match(SEMI);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1234);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1233); typeArguments();
					}
				}

				setState(1236); superKeyword();
				setState(1237); match(LPAREN);
				setState(1239);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(1238); argumentList();
					}
				}

				setState(1241); match(RPAREN);
				setState(1242); match(SEMI);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1244); expressionName();
				setState(1245); match(DOT);
				setState(1247);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1246); typeArguments();
					}
				}

				setState(1249); superKeyword();
				setState(1250); match(LPAREN);
				setState(1252);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(1251); argumentList();
					}
				}

				setState(1254); match(RPAREN);
				setState(1255); match(SEMI);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1257); primary();
				setState(1258); match(DOT);
				setState(1260);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1259); typeArguments();
					}
				}

				setState(1262); superKeyword();
				setState(1263); match(LPAREN);
				setState(1265);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(1264); argumentList();
					}
				}

				setState(1267); match(RPAREN);
				setState(1268); match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public EnumBodyContext enumBody() {
			return getRuleContext(EnumBodyContext.class,0);
		}
		public List<ClassModifierContext> classModifier() {
			return getRuleContexts(ClassModifierContext.class);
		}
		public ClassModifierContext classModifier(int i) {
			return getRuleContext(ClassModifierContext.class,i);
		}
		public SuperinterfacesContext superinterfaces() {
			return getRuleContext(SuperinterfacesContext.class,0);
		}
		public EnumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterEnumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitEnumDeclaration(this);
		}
	}

	public final EnumDeclarationContext enumDeclaration() throws RecognitionException {
		EnumDeclarationContext _localctx = new EnumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_enumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==AT) {
				{
				{
				setState(1272); classModifier();
				}
				}
				setState(1277);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1278); match(ENUM);
			setState(1279); match(Identifier);
			setState(1281);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(1280); superinterfaces();
				}
			}

			setState(1283); enumBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumBodyContext extends ParserRuleContext {
		public EnumBodyDeclarationsContext enumBodyDeclarations() {
			return getRuleContext(EnumBodyDeclarationsContext.class,0);
		}
		public EnumConstantListContext enumConstantList() {
			return getRuleContext(EnumConstantListContext.class,0);
		}
		public EnumBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterEnumBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitEnumBody(this);
		}
	}

	public final EnumBodyContext enumBody() throws RecognitionException {
		EnumBodyContext _localctx = new EnumBodyContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_enumBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1285); match(LBRACE);
			setState(1287);
			_la = _input.LA(1);
			if (_la==Identifier || _la==AT) {
				{
				setState(1286); enumConstantList();
				}
			}

			setState(1290);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1289); match(COMMA);
				}
			}

			setState(1293);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(1292); enumBodyDeclarations();
				}
			}

			setState(1295); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantListContext extends ParserRuleContext {
		public List<EnumConstantContext> enumConstant() {
			return getRuleContexts(EnumConstantContext.class);
		}
		public EnumConstantContext enumConstant(int i) {
			return getRuleContext(EnumConstantContext.class,i);
		}
		public EnumConstantListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstantList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterEnumConstantList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitEnumConstantList(this);
		}
	}

	public final EnumConstantListContext enumConstantList() throws RecognitionException {
		EnumConstantListContext _localctx = new EnumConstantListContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_enumConstantList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1297); enumConstant();
			setState(1302);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,116,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1298); match(COMMA);
					setState(1299); enumConstant();
					}
					} 
				}
				setState(1304);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,116,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public List<EnumConstantModifierContext> enumConstantModifier() {
			return getRuleContexts(EnumConstantModifierContext.class);
		}
		public EnumConstantModifierContext enumConstantModifier(int i) {
			return getRuleContext(EnumConstantModifierContext.class,i);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public EnumConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterEnumConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitEnumConstant(this);
		}
	}

	public final EnumConstantContext enumConstant() throws RecognitionException {
		EnumConstantContext _localctx = new EnumConstantContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_enumConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1305); enumConstantModifier();
				}
				}
				setState(1310);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1311); match(Identifier);
			setState(1317);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(1312); match(LPAREN);
				setState(1314);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(1313); argumentList();
					}
				}

				setState(1316); match(RPAREN);
				}
			}

			setState(1320);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(1319); classBody();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public EnumConstantModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstantModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterEnumConstantModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitEnumConstantModifier(this);
		}
	}

	public final EnumConstantModifierContext enumConstantModifier() throws RecognitionException {
		EnumConstantModifierContext _localctx = new EnumConstantModifierContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_enumConstantModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1322); annotation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumBodyDeclarationsContext extends ParserRuleContext {
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public EnumBodyDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBodyDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterEnumBodyDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitEnumBodyDeclarations(this);
		}
	}

	public final EnumBodyDeclarationsContext enumBodyDeclarations() throws RecognitionException {
		EnumBodyDeclarationsContext _localctx = new EnumBodyDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_enumBodyDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1324); match(SEMI);
			setState(1328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOID) | (1L << VOLATILE) | (1L << LBRACE) | (1L << SEMI))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (Identifier - 68)) | (1L << (AT - 68)))) != 0)) {
				{
				{
				setState(1325); classBodyDeclaration();
				}
				}
				setState(1330);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceDeclarationContext extends ParserRuleContext {
		public NormalInterfaceDeclarationContext normalInterfaceDeclaration() {
			return getRuleContext(NormalInterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitInterfaceDeclaration(this);
		}
	}

	public final InterfaceDeclarationContext interfaceDeclaration() throws RecognitionException {
		InterfaceDeclarationContext _localctx = new InterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_interfaceDeclaration);
		try {
			setState(1333);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1331); normalInterfaceDeclaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1332); annotationTypeDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NormalInterfaceDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public InterfaceBodyContext interfaceBody() {
			return getRuleContext(InterfaceBodyContext.class,0);
		}
		public List<InterfaceModifierContext> interfaceModifier() {
			return getRuleContexts(InterfaceModifierContext.class);
		}
		public InterfaceModifierContext interfaceModifier(int i) {
			return getRuleContext(InterfaceModifierContext.class,i);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ExtendsInterfacesContext extendsInterfaces() {
			return getRuleContext(ExtendsInterfacesContext.class,0);
		}
		public NormalInterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalInterfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterNormalInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitNormalInterfaceDeclaration(this);
		}
	}

	public final NormalInterfaceDeclarationContext normalInterfaceDeclaration() throws RecognitionException {
		NormalInterfaceDeclarationContext _localctx = new NormalInterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_normalInterfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==AT) {
				{
				{
				setState(1335); interfaceModifier();
				}
				}
				setState(1340);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1341); match(INTERFACE);
			setState(1342); match(Identifier);
			setState(1344);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1343); typeParameters();
				}
			}

			setState(1347);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(1346); extendsInterfaces();
				}
			}

			setState(1349); interfaceBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public InterfaceModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterInterfaceModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitInterfaceModifier(this);
		}
	}

	public final InterfaceModifierContext interfaceModifier() throws RecognitionException {
		InterfaceModifierContext _localctx = new InterfaceModifierContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_interfaceModifier);
		try {
			setState(1358);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1351); annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1352); match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(1353); match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1354); match(PRIVATE);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 5);
				{
				setState(1355); match(ABSTRACT);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 6);
				{
				setState(1356); match(STATIC);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 7);
				{
				setState(1357); match(STRICTFP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtendsInterfacesContext extends ParserRuleContext {
		public InterfaceTypeListContext interfaceTypeList() {
			return getRuleContext(InterfaceTypeListContext.class,0);
		}
		public ExtendsInterfacesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extendsInterfaces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterExtendsInterfaces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitExtendsInterfaces(this);
		}
	}

	public final ExtendsInterfacesContext extendsInterfaces() throws RecognitionException {
		ExtendsInterfacesContext _localctx = new ExtendsInterfacesContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_extendsInterfaces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1360); match(EXTENDS);
			setState(1361); interfaceTypeList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceBodyContext extends ParserRuleContext {
		public InterfaceMemberDeclarationContext interfaceMemberDeclaration(int i) {
			return getRuleContext(InterfaceMemberDeclarationContext.class,i);
		}
		public List<InterfaceMemberDeclarationContext> interfaceMemberDeclaration() {
			return getRuleContexts(InterfaceMemberDeclarationContext.class);
		}
		public InterfaceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterInterfaceBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitInterfaceBody(this);
		}
	}

	public final InterfaceBodyContext interfaceBody() throws RecognitionException {
		InterfaceBodyContext _localctx = new InterfaceBodyContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_interfaceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1363); match(LBRACE);
			setState(1367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DEFAULT) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << VOID) | (1L << SEMI))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (Identifier - 68)) | (1L << (AT - 68)))) != 0)) {
				{
				{
				setState(1364); interfaceMemberDeclaration();
				}
				}
				setState(1369);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1370); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMemberDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public ConstantDeclarationContext constantDeclaration() {
			return getRuleContext(ConstantDeclarationContext.class,0);
		}
		public InterfaceMethodDeclarationContext interfaceMethodDeclaration() {
			return getRuleContext(InterfaceMethodDeclarationContext.class,0);
		}
		public InterfaceMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMemberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterInterfaceMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitInterfaceMemberDeclaration(this);
		}
	}

	public final InterfaceMemberDeclarationContext interfaceMemberDeclaration() throws RecognitionException {
		InterfaceMemberDeclarationContext _localctx = new InterfaceMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_interfaceMemberDeclaration);
		try {
			setState(1377);
			switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1372); constantDeclaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1373); interfaceMethodDeclaration();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1374); classDeclaration();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1375); interfaceDeclaration();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1376); match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantDeclarationContext extends ParserRuleContext {
		public ConstantModifierContext constantModifier(int i) {
			return getRuleContext(ConstantModifierContext.class,i);
		}
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public List<ConstantModifierContext> constantModifier() {
			return getRuleContexts(ConstantModifierContext.class);
		}
		public VariableDeclaratorListContext variableDeclaratorList() {
			return getRuleContext(VariableDeclaratorListContext.class,0);
		}
		public ConstantDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterConstantDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitConstantDeclaration(this);
		}
	}

	public final ConstantDeclarationContext constantDeclaration() throws RecognitionException {
		ConstantDeclarationContext _localctx = new ConstantDeclarationContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_constantDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PUBLIC) | (1L << STATIC))) != 0) || _la==AT) {
				{
				{
				setState(1379); constantModifier();
				}
				}
				setState(1384);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1385); unannType();
			setState(1386); variableDeclaratorList();
			setState(1387); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ConstantModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterConstantModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitConstantModifier(this);
		}
	}

	public final ConstantModifierContext constantModifier() throws RecognitionException {
		ConstantModifierContext _localctx = new ConstantModifierContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_constantModifier);
		try {
			setState(1393);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1389); annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1390); match(PUBLIC);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 3);
				{
				setState(1391); match(STATIC);
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(1392); match(FINAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMethodDeclarationContext extends ParserRuleContext {
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public List<InterfaceMethodModifierContext> interfaceMethodModifier() {
			return getRuleContexts(InterfaceMethodModifierContext.class);
		}
		public MethodHeaderContext methodHeader() {
			return getRuleContext(MethodHeaderContext.class,0);
		}
		public InterfaceMethodModifierContext interfaceMethodModifier(int i) {
			return getRuleContext(InterfaceMethodModifierContext.class,i);
		}
		public InterfaceMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterInterfaceMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitInterfaceMethodDeclaration(this);
		}
	}

	public final InterfaceMethodDeclarationContext interfaceMethodDeclaration() throws RecognitionException {
		InterfaceMethodDeclarationContext _localctx = new InterfaceMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_interfaceMethodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1398);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << DEFAULT) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==AT) {
				{
				{
				setState(1395); interfaceMethodModifier();
				}
				}
				setState(1400);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1401); methodHeader();
			setState(1402); methodBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMethodModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public InterfaceMethodModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterInterfaceMethodModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitInterfaceMethodModifier(this);
		}
	}

	public final InterfaceMethodModifierContext interfaceMethodModifier() throws RecognitionException {
		InterfaceMethodModifierContext _localctx = new InterfaceMethodModifierContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_interfaceMethodModifier);
		try {
			setState(1410);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1404); annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1405); match(PUBLIC);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1406); match(ABSTRACT);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 4);
				{
				setState(1407); match(DEFAULT);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 5);
				{
				setState(1408); match(STATIC);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 6);
				{
				setState(1409); match(STRICTFP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public AnnotationTypeBodyContext annotationTypeBody() {
			return getRuleContext(AnnotationTypeBodyContext.class,0);
		}
		public List<InterfaceModifierContext> interfaceModifier() {
			return getRuleContexts(InterfaceModifierContext.class);
		}
		public InterfaceModifierContext interfaceModifier(int i) {
			return getRuleContext(InterfaceModifierContext.class,i);
		}
		public AnnotationTypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAnnotationTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAnnotationTypeDeclaration(this);
		}
	}

	public final AnnotationTypeDeclarationContext annotationTypeDeclaration() throws RecognitionException {
		AnnotationTypeDeclarationContext _localctx = new AnnotationTypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_annotationTypeDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1415);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1412); interfaceModifier();
					}
					} 
				}
				setState(1417);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
			}
			setState(1418); match(AT);
			setState(1419); match(INTERFACE);
			setState(1420); match(Identifier);
			setState(1421); annotationTypeBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeBodyContext extends ParserRuleContext {
		public List<AnnotationTypeMemberDeclarationContext> annotationTypeMemberDeclaration() {
			return getRuleContexts(AnnotationTypeMemberDeclarationContext.class);
		}
		public AnnotationTypeMemberDeclarationContext annotationTypeMemberDeclaration(int i) {
			return getRuleContext(AnnotationTypeMemberDeclarationContext.class,i);
		}
		public AnnotationTypeBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAnnotationTypeBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAnnotationTypeBody(this);
		}
	}

	public final AnnotationTypeBodyContext annotationTypeBody() throws RecognitionException {
		AnnotationTypeBodyContext _localctx = new AnnotationTypeBodyContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_annotationTypeBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1423); match(LBRACE);
			setState(1427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SEMI))) != 0) || _la==Identifier || _la==AT) {
				{
				{
				setState(1424); annotationTypeMemberDeclaration();
				}
				}
				setState(1429);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1430); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeMemberDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration() {
			return getRuleContext(AnnotationTypeElementDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public ConstantDeclarationContext constantDeclaration() {
			return getRuleContext(ConstantDeclarationContext.class,0);
		}
		public AnnotationTypeMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeMemberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAnnotationTypeMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAnnotationTypeMemberDeclaration(this);
		}
	}

	public final AnnotationTypeMemberDeclarationContext annotationTypeMemberDeclaration() throws RecognitionException {
		AnnotationTypeMemberDeclarationContext _localctx = new AnnotationTypeMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_annotationTypeMemberDeclaration);
		try {
			setState(1437);
			switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1432); annotationTypeElementDeclaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1433); constantDeclaration();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1434); classDeclaration();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1435); interfaceDeclaration();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1436); match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeElementDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public AnnotationTypeElementModifierContext annotationTypeElementModifier(int i) {
			return getRuleContext(AnnotationTypeElementModifierContext.class,i);
		}
		public List<AnnotationTypeElementModifierContext> annotationTypeElementModifier() {
			return getRuleContexts(AnnotationTypeElementModifierContext.class);
		}
		public AnnotationTypeElementDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAnnotationTypeElementDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAnnotationTypeElementDeclaration(this);
		}
	}

	public final AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration() throws RecognitionException {
		AnnotationTypeElementDeclarationContext _localctx = new AnnotationTypeElementDeclarationContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_annotationTypeElementDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ABSTRACT || _la==PUBLIC || _la==AT) {
				{
				{
				setState(1439); annotationTypeElementModifier();
				}
				}
				setState(1444);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1445); unannType();
			setState(1446); match(Identifier);
			setState(1447); match(LPAREN);
			setState(1448); match(RPAREN);
			setState(1450);
			_la = _input.LA(1);
			if (_la==LBRACK || _la==AT) {
				{
				setState(1449); dims();
				}
			}

			setState(1453);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(1452); defaultValue();
				}
			}

			setState(1455); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeElementModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public AnnotationTypeElementModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAnnotationTypeElementModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAnnotationTypeElementModifier(this);
		}
	}

	public final AnnotationTypeElementModifierContext annotationTypeElementModifier() throws RecognitionException {
		AnnotationTypeElementModifierContext _localctx = new AnnotationTypeElementModifierContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_annotationTypeElementModifier);
		try {
			setState(1460);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1457); annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1458); match(PUBLIC);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1459); match(ABSTRACT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefaultValueContext extends ParserRuleContext {
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterDefaultValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitDefaultValue(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_defaultValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1462); match(DEFAULT);
			setState(1463); elementValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationContext extends ParserRuleContext {
		public NormalAnnotationContext normalAnnotation() {
			return getRuleContext(NormalAnnotationContext.class,0);
		}
		public MarkerAnnotationContext markerAnnotation() {
			return getRuleContext(MarkerAnnotationContext.class,0);
		}
		public SingleElementAnnotationContext singleElementAnnotation() {
			return getRuleContext(SingleElementAnnotationContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAnnotation(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_annotation);
		try {
			setState(1468);
			switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1465); normalAnnotation();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1466); markerAnnotation();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1467); singleElementAnnotation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NormalAnnotationContext extends ParserRuleContext {
		public ElementValuePairListContext elementValuePairList() {
			return getRuleContext(ElementValuePairListContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public NormalAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterNormalAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitNormalAnnotation(this);
		}
	}

	public final NormalAnnotationContext normalAnnotation() throws RecognitionException {
		NormalAnnotationContext _localctx = new NormalAnnotationContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_normalAnnotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1470); match(AT);
			setState(1471); typeName();
			setState(1472); match(LPAREN);
			setState(1474);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1473); elementValuePairList();
				}
			}

			setState(1476); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValuePairListContext extends ParserRuleContext {
		public ElementValuePairContext elementValuePair(int i) {
			return getRuleContext(ElementValuePairContext.class,i);
		}
		public List<ElementValuePairContext> elementValuePair() {
			return getRuleContexts(ElementValuePairContext.class);
		}
		public ElementValuePairListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePairList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterElementValuePairList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitElementValuePairList(this);
		}
	}

	public final ElementValuePairListContext elementValuePairList() throws RecognitionException {
		ElementValuePairListContext _localctx = new ElementValuePairListContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_elementValuePairList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1478); elementValuePair();
			setState(1483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1479); match(COMMA);
				setState(1480); elementValuePair();
				}
				}
				setState(1485);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValuePairContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public ElementValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterElementValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitElementValuePair(this);
		}
	}

	public final ElementValuePairContext elementValuePair() throws RecognitionException {
		ElementValuePairContext _localctx = new ElementValuePairContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_elementValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1486); match(Identifier);
			setState(1487); match(ASSIGN);
			setState(1488); elementValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValueContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ElementValueArrayInitializerContext elementValueArrayInitializer() {
			return getRuleContext(ElementValueArrayInitializerContext.class,0);
		}
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ElementValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterElementValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitElementValue(this);
		}
	}

	public final ElementValueContext elementValue() throws RecognitionException {
		ElementValueContext _localctx = new ElementValueContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_elementValue);
		try {
			setState(1493);
			switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1490); conditionalExpression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1491); elementValueArrayInitializer();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1492); annotation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValueArrayInitializerContext extends ParserRuleContext {
		public ElementValueListContext elementValueList() {
			return getRuleContext(ElementValueListContext.class,0);
		}
		public ElementValueArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValueArrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterElementValueArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitElementValueArrayInitializer(this);
		}
	}

	public final ElementValueArrayInitializerContext elementValueArrayInitializer() throws RecognitionException {
		ElementValueArrayInitializerContext _localctx = new ElementValueArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_elementValueArrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1495); match(LBRACE);
			setState(1497);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
				{
				setState(1496); elementValueList();
				}
			}

			setState(1500);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1499); match(COMMA);
				}
			}

			setState(1502); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValueListContext extends ParserRuleContext {
		public ElementValueContext elementValue(int i) {
			return getRuleContext(ElementValueContext.class,i);
		}
		public List<ElementValueContext> elementValue() {
			return getRuleContexts(ElementValueContext.class);
		}
		public ElementValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValueList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterElementValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitElementValueList(this);
		}
	}

	public final ElementValueListContext elementValueList() throws RecognitionException {
		ElementValueListContext _localctx = new ElementValueListContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_elementValueList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1504); elementValue();
			setState(1509);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1505); match(COMMA);
					setState(1506); elementValue();
					}
					} 
				}
				setState(1511);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MarkerAnnotationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public MarkerAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_markerAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMarkerAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMarkerAnnotation(this);
		}
	}

	public final MarkerAnnotationContext markerAnnotation() throws RecognitionException {
		MarkerAnnotationContext _localctx = new MarkerAnnotationContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_markerAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1512); match(AT);
			setState(1513); typeName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleElementAnnotationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public SingleElementAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleElementAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterSingleElementAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitSingleElementAnnotation(this);
		}
	}

	public final SingleElementAnnotationContext singleElementAnnotation() throws RecognitionException {
		SingleElementAnnotationContext _localctx = new SingleElementAnnotationContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_singleElementAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1515); match(AT);
			setState(1516); typeName();
			setState(1517); match(LPAREN);
			setState(1518); elementValue();
			setState(1519); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayInitializerContext extends ParserRuleContext {
		public VariableInitializerListContext variableInitializerList() {
			return getRuleContext(VariableInitializerListContext.class,0);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitArrayInitializer(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_arrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1521); match(LBRACE);
			setState(1523);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
				{
				setState(1522); variableInitializerList();
				}
			}

			setState(1526);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1525); match(COMMA);
				}
			}

			setState(1528); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableInitializerListContext extends ParserRuleContext {
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public VariableInitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterVariableInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitVariableInitializerList(this);
		}
	}

	public final VariableInitializerListContext variableInitializerList() throws RecognitionException {
		VariableInitializerListContext _localctx = new VariableInitializerListContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_variableInitializerList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1530); variableInitializer();
			setState(1535);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,149,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1531); match(COMMA);
					setState(1532); variableInitializer();
					}
					} 
				}
				setState(1537);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,149,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public BlockStatementsContext blockStatements() {
			return getRuleContext(BlockStatementsContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1538); match(LBRACE);
			setState(1540);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SUPER) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (INC - 79)) | (1L << (DEC - 79)) | (1L << (Identifier - 79)) | (1L << (AT - 79)))) != 0)) {
				{
				setState(1539); blockStatements();
				}
			}

			setState(1542); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementsContext extends ParserRuleContext {
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterBlockStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitBlockStatements(this);
		}
	}

	public final BlockStatementsContext blockStatements() throws RecognitionException {
		BlockStatementsContext _localctx = new BlockStatementsContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_blockStatements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1545); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1544); blockStatement();
				}
				}
				setState(1547); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SUPER) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (INC - 79)) | (1L << (DEC - 79)) | (1L << (Identifier - 79)) | (1L << (AT - 79)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitBlockStatement(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_blockStatement);
		try {
			setState(1552);
			switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1549); localVariableDeclarationStatement();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1550); classDeclaration();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1551); statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public LocalVariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterLocalVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitLocalVariableDeclarationStatement(this);
		}
	}

	public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
		LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_localVariableDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1554); localVariableDeclaration();
			setState(1555); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableDeclaratorListContext variableDeclaratorList() {
			return getRuleContext(VariableDeclaratorListContext.class,0);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitLocalVariableDeclaration(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_localVariableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1560);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1557); variableModifier();
				}
				}
				setState(1562);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1563); unannType();
			setState(1564); variableDeclaratorList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public IfThenStatementContext ifThenStatement() {
			return getRuleContext(IfThenStatementContext.class,0);
		}
		public LabeledStatementContext labeledStatement() {
			return getRuleContext(LabeledStatementContext.class,0);
		}
		public IfThenElseStatementContext ifThenElseStatement() {
			return getRuleContext(IfThenElseStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public StatementWithoutTrailingSubstatementContext statementWithoutTrailingSubstatement() {
			return getRuleContext(StatementWithoutTrailingSubstatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_statement);
		try {
			setState(1572);
			switch ( getInterpreter().adaptivePredict(_input,154,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1566); statementWithoutTrailingSubstatement();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1567); labeledStatement();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1568); ifThenStatement();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1569); ifThenElseStatement();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1570); whileStatement();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1571); forStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementNoShortIfContext extends ParserRuleContext {
		public ForStatementNoShortIfContext forStatementNoShortIf() {
			return getRuleContext(ForStatementNoShortIfContext.class,0);
		}
		public WhileStatementNoShortIfContext whileStatementNoShortIf() {
			return getRuleContext(WhileStatementNoShortIfContext.class,0);
		}
		public IfThenElseStatementNoShortIfContext ifThenElseStatementNoShortIf() {
			return getRuleContext(IfThenElseStatementNoShortIfContext.class,0);
		}
		public LabeledStatementNoShortIfContext labeledStatementNoShortIf() {
			return getRuleContext(LabeledStatementNoShortIfContext.class,0);
		}
		public StatementWithoutTrailingSubstatementContext statementWithoutTrailingSubstatement() {
			return getRuleContext(StatementWithoutTrailingSubstatementContext.class,0);
		}
		public StatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitStatementNoShortIf(this);
		}
	}

	public final StatementNoShortIfContext statementNoShortIf() throws RecognitionException {
		StatementNoShortIfContext _localctx = new StatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_statementNoShortIf);
		try {
			setState(1579);
			switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1574); statementWithoutTrailingSubstatement();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1575); labeledStatementNoShortIf();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1576); ifThenElseStatementNoShortIf();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1577); whileStatementNoShortIf();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1578); forStatementNoShortIf();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementWithoutTrailingSubstatementContext extends ParserRuleContext {
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public TryStatementContext tryStatement() {
			return getRuleContext(TryStatementContext.class,0);
		}
		public DoStatementContext doStatement() {
			return getRuleContext(DoStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public SynchronizedStatementContext synchronizedStatement() {
			return getRuleContext(SynchronizedStatementContext.class,0);
		}
		public AssertStatementContext assertStatement() {
			return getRuleContext(AssertStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public StatementWithoutTrailingSubstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementWithoutTrailingSubstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterStatementWithoutTrailingSubstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitStatementWithoutTrailingSubstatement(this);
		}
	}

	public final StatementWithoutTrailingSubstatementContext statementWithoutTrailingSubstatement() throws RecognitionException {
		StatementWithoutTrailingSubstatementContext _localctx = new StatementWithoutTrailingSubstatementContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_statementWithoutTrailingSubstatement);
		try {
			setState(1593);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1581); block();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(1582); emptyStatement();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case INC:
			case DEC:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1583); expressionStatement();
				}
				break;
			case ASSERT:
				enterOuterAlt(_localctx, 4);
				{
				setState(1584); assertStatement();
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 5);
				{
				setState(1585); switchStatement();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 6);
				{
				setState(1586); doStatement();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 7);
				{
				setState(1587); breakStatement();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 8);
				{
				setState(1588); continueStatement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 9);
				{
				setState(1589); returnStatement();
				}
				break;
			case SYNCHRONIZED:
				enterOuterAlt(_localctx, 10);
				{
				setState(1590); synchronizedStatement();
				}
				break;
			case THROW:
				enterOuterAlt(_localctx, 11);
				{
				setState(1591); throwStatement();
				}
				break;
			case TRY:
				enterOuterAlt(_localctx, 12);
				{
				setState(1592); tryStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyStatementContext extends ParserRuleContext {
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitEmptyStatement(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1595); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabeledStatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LabeledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterLabeledStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitLabeledStatement(this);
		}
	}

	public final LabeledStatementContext labeledStatement() throws RecognitionException {
		LabeledStatementContext _localctx = new LabeledStatementContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_labeledStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1597); match(Identifier);
			setState(1598); match(COLON);
			setState(1599); statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabeledStatementNoShortIfContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public LabeledStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterLabeledStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitLabeledStatementNoShortIf(this);
		}
	}

	public final LabeledStatementNoShortIfContext labeledStatementNoShortIf() throws RecognitionException {
		LabeledStatementNoShortIfContext _localctx = new LabeledStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_labeledStatementNoShortIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1601); match(Identifier);
			setState(1602); match(COLON);
			setState(1603); statementNoShortIf();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionStatementContext extends ParserRuleContext {
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitExpressionStatement(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1605); statementExpression();
			setState(1606); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementExpressionContext extends ParserRuleContext {
		public PostDecrementExpressionContext postDecrementExpression() {
			return getRuleContext(PostDecrementExpressionContext.class,0);
		}
		public PostIncrementExpressionContext postIncrementExpression() {
			return getRuleContext(PostIncrementExpressionContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public PreIncrementExpressionContext preIncrementExpression() {
			return getRuleContext(PreIncrementExpressionContext.class,0);
		}
		public PreDecrementExpressionContext preDecrementExpression() {
			return getRuleContext(PreDecrementExpressionContext.class,0);
		}
		public ClassInstanceCreationExpressionContext classInstanceCreationExpression() {
			return getRuleContext(ClassInstanceCreationExpressionContext.class,0);
		}
		public StatementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterStatementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitStatementExpression(this);
		}
	}

	public final StatementExpressionContext statementExpression() throws RecognitionException {
		StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_statementExpression);
		try {
			setState(1615);
			switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1608); assignment();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1609); preIncrementExpression();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1610); preDecrementExpression();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1611); postIncrementExpression();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1612); postDecrementExpression();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1613); methodInvocation();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1614); classInstanceCreationExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfThenStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfThenStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterIfThenStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitIfThenStatement(this);
		}
	}

	public final IfThenStatementContext ifThenStatement() throws RecognitionException {
		IfThenStatementContext _localctx = new IfThenStatementContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_ifThenStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1617); match(IF);
			setState(1618); match(LPAREN);
			setState(1619); expression();
			setState(1620); match(RPAREN);
			setState(1621); statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfThenElseStatementContext extends ParserRuleContext {
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfThenElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenElseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterIfThenElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitIfThenElseStatement(this);
		}
	}

	public final IfThenElseStatementContext ifThenElseStatement() throws RecognitionException {
		IfThenElseStatementContext _localctx = new IfThenElseStatementContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_ifThenElseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1623); match(IF);
			setState(1624); match(LPAREN);
			setState(1625); expression();
			setState(1626); match(RPAREN);
			setState(1627); statementNoShortIf();
			setState(1628); match(ELSE);
			setState(1629); statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfThenElseStatementNoShortIfContext extends ParserRuleContext {
		public List<StatementNoShortIfContext> statementNoShortIf() {
			return getRuleContexts(StatementNoShortIfContext.class);
		}
		public StatementNoShortIfContext statementNoShortIf(int i) {
			return getRuleContext(StatementNoShortIfContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfThenElseStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenElseStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterIfThenElseStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitIfThenElseStatementNoShortIf(this);
		}
	}

	public final IfThenElseStatementNoShortIfContext ifThenElseStatementNoShortIf() throws RecognitionException {
		IfThenElseStatementNoShortIfContext _localctx = new IfThenElseStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_ifThenElseStatementNoShortIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1631); match(IF);
			setState(1632); match(LPAREN);
			setState(1633); expression();
			setState(1634); match(RPAREN);
			setState(1635); statementNoShortIf();
			setState(1636); match(ELSE);
			setState(1637); statementNoShortIf();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssertStatementContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AssertStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAssertStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAssertStatement(this);
		}
	}

	public final AssertStatementContext assertStatement() throws RecognitionException {
		AssertStatementContext _localctx = new AssertStatementContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_assertStatement);
		try {
			setState(1649);
			switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1639); match(ASSERT);
				setState(1640); expression();
				setState(1641); match(SEMI);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1643); match(ASSERT);
				setState(1644); expression();
				setState(1645); match(COLON);
				setState(1646); expression();
				setState(1647); match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchStatementContext extends ParserRuleContext {
		public SwitchBlockContext switchBlock() {
			return getRuleContext(SwitchBlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitSwitchStatement(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_switchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1651); match(SWITCH);
			setState(1652); match(LPAREN);
			setState(1653); expression();
			setState(1654); match(RPAREN);
			setState(1655); switchBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchBlockContext extends ParserRuleContext {
		public SwitchBlockStatementGroupContext switchBlockStatementGroup(int i) {
			return getRuleContext(SwitchBlockStatementGroupContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public List<SwitchBlockStatementGroupContext> switchBlockStatementGroup() {
			return getRuleContexts(SwitchBlockStatementGroupContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public SwitchBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterSwitchBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitSwitchBlock(this);
		}
	}

	public final SwitchBlockContext switchBlock() throws RecognitionException {
		SwitchBlockContext _localctx = new SwitchBlockContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_switchBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1657); match(LBRACE);
			setState(1661);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,159,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1658); switchBlockStatementGroup();
					}
					} 
				}
				setState(1663);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,159,_ctx);
			}
			setState(1667);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE || _la==DEFAULT) {
				{
				{
				setState(1664); switchLabel();
				}
				}
				setState(1669);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1670); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchBlockStatementGroupContext extends ParserRuleContext {
		public SwitchLabelsContext switchLabels() {
			return getRuleContext(SwitchLabelsContext.class,0);
		}
		public BlockStatementsContext blockStatements() {
			return getRuleContext(BlockStatementsContext.class,0);
		}
		public SwitchBlockStatementGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlockStatementGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterSwitchBlockStatementGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitSwitchBlockStatementGroup(this);
		}
	}

	public final SwitchBlockStatementGroupContext switchBlockStatementGroup() throws RecognitionException {
		SwitchBlockStatementGroupContext _localctx = new SwitchBlockStatementGroupContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_switchBlockStatementGroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1672); switchLabels();
			setState(1673); blockStatements();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchLabelsContext extends ParserRuleContext {
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public SwitchLabelsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabels; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterSwitchLabels(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitSwitchLabels(this);
		}
	}

	public final SwitchLabelsContext switchLabels() throws RecognitionException {
		SwitchLabelsContext _localctx = new SwitchLabelsContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_switchLabels);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1675); switchLabel();
			setState(1679);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE || _la==DEFAULT) {
				{
				{
				setState(1676); switchLabel();
				}
				}
				setState(1681);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchLabelContext extends ParserRuleContext {
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public EnumConstantNameContext enumConstantName() {
			return getRuleContext(EnumConstantNameContext.class,0);
		}
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterSwitchLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitSwitchLabel(this);
		}
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_switchLabel);
		try {
			setState(1692);
			switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1682); match(CASE);
				setState(1683); constantExpression();
				setState(1684); match(COLON);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1686); match(CASE);
				setState(1687); enumConstantName();
				setState(1688); match(COLON);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1690); match(DEFAULT);
				setState(1691); match(COLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public EnumConstantNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstantName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterEnumConstantName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitEnumConstantName(this);
		}
	}

	public final EnumConstantNameContext enumConstantName() throws RecognitionException {
		EnumConstantNameContext _localctx = new EnumConstantNameContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_enumConstantName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1694); match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1696); match(WHILE);
			setState(1697); match(LPAREN);
			setState(1698); expression();
			setState(1699); match(RPAREN);
			setState(1700); statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementNoShortIfContext extends ParserRuleContext {
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhileStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterWhileStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitWhileStatementNoShortIf(this);
		}
	}

	public final WhileStatementNoShortIfContext whileStatementNoShortIf() throws RecognitionException {
		WhileStatementNoShortIfContext _localctx = new WhileStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_whileStatementNoShortIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1702); match(WHILE);
			setState(1703); match(LPAREN);
			setState(1704); expression();
			setState(1705); match(RPAREN);
			setState(1706); statementNoShortIf();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterDoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitDoStatement(this);
		}
	}

	public final DoStatementContext doStatement() throws RecognitionException {
		DoStatementContext _localctx = new DoStatementContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_doStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1708); match(DO);
			setState(1709); statement();
			setState(1710); match(WHILE);
			setState(1711); match(LPAREN);
			setState(1712); expression();
			setState(1713); match(RPAREN);
			setState(1714); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public BasicForStatementContext basicForStatement() {
			return getRuleContext(BasicForStatementContext.class,0);
		}
		public EnhancedForStatementContext enhancedForStatement() {
			return getRuleContext(EnhancedForStatementContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_forStatement);
		try {
			setState(1718);
			switch ( getInterpreter().adaptivePredict(_input,163,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1716); basicForStatement();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1717); enhancedForStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementNoShortIfContext extends ParserRuleContext {
		public BasicForStatementNoShortIfContext basicForStatementNoShortIf() {
			return getRuleContext(BasicForStatementNoShortIfContext.class,0);
		}
		public EnhancedForStatementNoShortIfContext enhancedForStatementNoShortIf() {
			return getRuleContext(EnhancedForStatementNoShortIfContext.class,0);
		}
		public ForStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterForStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitForStatementNoShortIf(this);
		}
	}

	public final ForStatementNoShortIfContext forStatementNoShortIf() throws RecognitionException {
		ForStatementNoShortIfContext _localctx = new ForStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_forStatementNoShortIf);
		try {
			setState(1722);
			switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1720); basicForStatementNoShortIf();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1721); enhancedForStatementNoShortIf();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicForStatementContext extends ParserRuleContext {
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BasicForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicForStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterBasicForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitBasicForStatement(this);
		}
	}

	public final BasicForStatementContext basicForStatement() throws RecognitionException {
		BasicForStatementContext _localctx = new BasicForStatementContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_basicForStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1724); match(FOR);
			setState(1725); match(LPAREN);
			setState(1727);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (INC - 79)) | (1L << (DEC - 79)) | (1L << (Identifier - 79)) | (1L << (AT - 79)))) != 0)) {
				{
				setState(1726); forInit();
				}
			}

			setState(1729); match(SEMI);
			setState(1731);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
				{
				setState(1730); expression();
				}
			}

			setState(1733); match(SEMI);
			setState(1735);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (INC - 79)) | (1L << (DEC - 79)) | (1L << (Identifier - 79)) | (1L << (AT - 79)))) != 0)) {
				{
				setState(1734); forUpdate();
				}
			}

			setState(1737); match(RPAREN);
			setState(1738); statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicForStatementNoShortIfContext extends ParserRuleContext {
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BasicForStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicForStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterBasicForStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitBasicForStatementNoShortIf(this);
		}
	}

	public final BasicForStatementNoShortIfContext basicForStatementNoShortIf() throws RecognitionException {
		BasicForStatementNoShortIfContext _localctx = new BasicForStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_basicForStatementNoShortIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1740); match(FOR);
			setState(1741); match(LPAREN);
			setState(1743);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (INC - 79)) | (1L << (DEC - 79)) | (1L << (Identifier - 79)) | (1L << (AT - 79)))) != 0)) {
				{
				setState(1742); forInit();
				}
			}

			setState(1745); match(SEMI);
			setState(1747);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
				{
				setState(1746); expression();
				}
			}

			setState(1749); match(SEMI);
			setState(1751);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (INC - 79)) | (1L << (DEC - 79)) | (1L << (Identifier - 79)) | (1L << (AT - 79)))) != 0)) {
				{
				setState(1750); forUpdate();
				}
			}

			setState(1753); match(RPAREN);
			setState(1754); statementNoShortIf();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInitContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public StatementExpressionListContext statementExpressionList() {
			return getRuleContext(StatementExpressionListContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitForInit(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_forInit);
		try {
			setState(1758);
			switch ( getInterpreter().adaptivePredict(_input,171,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1756); statementExpressionList();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1757); localVariableDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForUpdateContext extends ParserRuleContext {
		public StatementExpressionListContext statementExpressionList() {
			return getRuleContext(StatementExpressionListContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitForUpdate(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1760); statementExpressionList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementExpressionListContext extends ParserRuleContext {
		public StatementExpressionContext statementExpression(int i) {
			return getRuleContext(StatementExpressionContext.class,i);
		}
		public List<StatementExpressionContext> statementExpression() {
			return getRuleContexts(StatementExpressionContext.class);
		}
		public StatementExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterStatementExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitStatementExpressionList(this);
		}
	}

	public final StatementExpressionListContext statementExpressionList() throws RecognitionException {
		StatementExpressionListContext _localctx = new StatementExpressionListContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_statementExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1762); statementExpression();
			setState(1767);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1763); match(COMMA);
				setState(1764); statementExpression();
				}
				}
				setState(1769);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnhancedForStatementContext extends ParserRuleContext {
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EnhancedForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterEnhancedForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitEnhancedForStatement(this);
		}
	}

	public final EnhancedForStatementContext enhancedForStatement() throws RecognitionException {
		EnhancedForStatementContext _localctx = new EnhancedForStatementContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_enhancedForStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1770); match(FOR);
			setState(1771); match(LPAREN);
			setState(1775);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1772); variableModifier();
				}
				}
				setState(1777);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1778); unannType();
			setState(1779); variableDeclaratorId();
			setState(1780); match(COLON);
			setState(1781); expression();
			setState(1782); match(RPAREN);
			setState(1783); statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnhancedForStatementNoShortIfContext extends ParserRuleContext {
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EnhancedForStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterEnhancedForStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitEnhancedForStatementNoShortIf(this);
		}
	}

	public final EnhancedForStatementNoShortIfContext enhancedForStatementNoShortIf() throws RecognitionException {
		EnhancedForStatementNoShortIfContext _localctx = new EnhancedForStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_enhancedForStatementNoShortIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1785); match(FOR);
			setState(1786); match(LPAREN);
			setState(1790);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1787); variableModifier();
				}
				}
				setState(1792);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1793); unannType();
			setState(1794); variableDeclaratorId();
			setState(1795); match(COLON);
			setState(1796); expression();
			setState(1797); match(RPAREN);
			setState(1798); statementNoShortIf();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitBreakStatement(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_breakStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1800); match(BREAK);
			setState(1802);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1801); match(Identifier);
				}
			}

			setState(1804); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitContinueStatement(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_continueStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1806); match(CONTINUE);
			setState(1808);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1807); match(Identifier);
				}
			}

			setState(1810); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1812); match(RETURN);
			setState(1814);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
				{
				setState(1813); expression();
				}
			}

			setState(1816); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThrowStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterThrowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitThrowStatement(this);
		}
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1818); match(THROW);
			setState(1819); expression();
			setState(1820); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SynchronizedStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SynchronizedStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synchronizedStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterSynchronizedStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitSynchronizedStatement(this);
		}
	}

	public final SynchronizedStatementContext synchronizedStatement() throws RecognitionException {
		SynchronizedStatementContext _localctx = new SynchronizedStatementContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_synchronizedStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1822); match(SYNCHRONIZED);
			setState(1823); match(LPAREN);
			setState(1824); expression();
			setState(1825); match(RPAREN);
			setState(1826); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TryStatementContext extends ParserRuleContext {
		public CatchesContext catches() {
			return getRuleContext(CatchesContext.class,0);
		}
		public Finally_Context finally_() {
			return getRuleContext(Finally_Context.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TryWithResourcesStatementContext tryWithResourcesStatement() {
			return getRuleContext(TryWithResourcesStatementContext.class,0);
		}
		public TryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterTryStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitTryStatement(this);
		}
	}

	public final TryStatementContext tryStatement() throws RecognitionException {
		TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
		enterRule(_localctx, 340, RULE_tryStatement);
		int _la;
		try {
			setState(1840);
			switch ( getInterpreter().adaptivePredict(_input,179,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1828); match(TRY);
				setState(1829); block();
				setState(1830); catches();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1832); match(TRY);
				setState(1833); block();
				setState(1835);
				_la = _input.LA(1);
				if (_la==CATCH) {
					{
					setState(1834); catches();
					}
				}

				setState(1837); finally_();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1839); tryWithResourcesStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchesContext extends ParserRuleContext {
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catches; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterCatches(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitCatches(this);
		}
	}

	public final CatchesContext catches() throws RecognitionException {
		CatchesContext _localctx = new CatchesContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_catches);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1842); catchClause();
			setState(1846);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(1843); catchClause();
				}
				}
				setState(1848);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchClauseContext extends ParserRuleContext {
		public CatchFormalParameterContext catchFormalParameter() {
			return getRuleContext(CatchFormalParameterContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitCatchClause(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_catchClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1849); match(CATCH);
			setState(1850); match(LPAREN);
			setState(1851); catchFormalParameter();
			setState(1852); match(RPAREN);
			setState(1853); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchFormalParameterContext extends ParserRuleContext {
		public CatchTypeContext catchType() {
			return getRuleContext(CatchTypeContext.class,0);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public CatchFormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchFormalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterCatchFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitCatchFormalParameter(this);
		}
	}

	public final CatchFormalParameterContext catchFormalParameter() throws RecognitionException {
		CatchFormalParameterContext _localctx = new CatchFormalParameterContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_catchFormalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1858);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1855); variableModifier();
				}
				}
				setState(1860);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1861); catchType();
			setState(1862); variableDeclaratorId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchTypeContext extends ParserRuleContext {
		public UnannClassTypeContext unannClassType() {
			return getRuleContext(UnannClassTypeContext.class,0);
		}
		public ClassTypeContext classType(int i) {
			return getRuleContext(ClassTypeContext.class,i);
		}
		public List<ClassTypeContext> classType() {
			return getRuleContexts(ClassTypeContext.class);
		}
		public CatchTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterCatchType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitCatchType(this);
		}
	}

	public final CatchTypeContext catchType() throws RecognitionException {
		CatchTypeContext _localctx = new CatchTypeContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_catchType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1864); unannClassType();
			setState(1869);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITOR) {
				{
				{
				setState(1865); match(BITOR);
				setState(1866); classType();
				}
				}
				setState(1871);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Finally_Context extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Finally_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finally_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterFinally_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitFinally_(this);
		}
	}

	public final Finally_Context finally_() throws RecognitionException {
		Finally_Context _localctx = new Finally_Context(_ctx, getState());
		enterRule(_localctx, 350, RULE_finally_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1872); match(FINALLY);
			setState(1873); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TryWithResourcesStatementContext extends ParserRuleContext {
		public CatchesContext catches() {
			return getRuleContext(CatchesContext.class,0);
		}
		public Finally_Context finally_() {
			return getRuleContext(Finally_Context.class,0);
		}
		public ResourceSpecificationContext resourceSpecification() {
			return getRuleContext(ResourceSpecificationContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TryWithResourcesStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryWithResourcesStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterTryWithResourcesStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitTryWithResourcesStatement(this);
		}
	}

	public final TryWithResourcesStatementContext tryWithResourcesStatement() throws RecognitionException {
		TryWithResourcesStatementContext _localctx = new TryWithResourcesStatementContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_tryWithResourcesStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1875); match(TRY);
			setState(1876); resourceSpecification();
			setState(1877); block();
			setState(1879);
			_la = _input.LA(1);
			if (_la==CATCH) {
				{
				setState(1878); catches();
				}
			}

			setState(1882);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(1881); finally_();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResourceSpecificationContext extends ParserRuleContext {
		public ResourceListContext resourceList() {
			return getRuleContext(ResourceListContext.class,0);
		}
		public ResourceSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterResourceSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitResourceSpecification(this);
		}
	}

	public final ResourceSpecificationContext resourceSpecification() throws RecognitionException {
		ResourceSpecificationContext _localctx = new ResourceSpecificationContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_resourceSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1884); match(LPAREN);
			setState(1885); resourceList();
			setState(1887);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(1886); match(SEMI);
				}
			}

			setState(1889); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResourceListContext extends ParserRuleContext {
		public ResourceContext resource(int i) {
			return getRuleContext(ResourceContext.class,i);
		}
		public List<ResourceContext> resource() {
			return getRuleContexts(ResourceContext.class);
		}
		public ResourceListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterResourceList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitResourceList(this);
		}
	}

	public final ResourceListContext resourceList() throws RecognitionException {
		ResourceListContext _localctx = new ResourceListContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_resourceList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1891); resource();
			setState(1896);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1892); match(SEMI);
					setState(1893); resource();
					}
					} 
				}
				setState(1898);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResourceContext extends ParserRuleContext {
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitResource(this);
		}
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_resource);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1902);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1899); variableModifier();
				}
				}
				setState(1904);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1905); unannType();
			setState(1906); variableDeclaratorId();
			setState(1907); match(ASSIGN);
			setState(1908); expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lf_primaryContext primaryNoNewArray_lf_primary(int i) {
			return getRuleContext(PrimaryNoNewArray_lf_primaryContext.class,i);
		}
		public PrimaryNoNewArray_lfno_primaryContext primaryNoNewArray_lfno_primary() {
			return getRuleContext(PrimaryNoNewArray_lfno_primaryContext.class,0);
		}
		public ArrayCreationExpressionContext arrayCreationExpression() {
			return getRuleContext(ArrayCreationExpressionContext.class,0);
		}
		public List<PrimaryNoNewArray_lf_primaryContext> primaryNoNewArray_lf_primary() {
			return getRuleContexts(PrimaryNoNewArray_lf_primaryContext.class);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_primary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1912);
			switch ( getInterpreter().adaptivePredict(_input,188,_ctx) ) {
			case 1:
				{
				setState(1910); primaryNoNewArray_lfno_primary();
				}
				break;

			case 2:
				{
				setState(1911); arrayCreationExpression();
				}
				break;
			}
			setState(1917);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,189,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1914); primaryNoNewArray_lf_primary();
					}
					} 
				}
				setState(1919);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,189,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArrayContext extends ParserRuleContext {
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public DimContext dim(int i) {
			return getRuleContext(DimContext.class,i);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<DimContext> dim() {
			return getRuleContexts(DimContext.class);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ClassKeywordContext classKeyword() {
			return getRuleContext(ClassKeywordContext.class,0);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public MethodReferenceContext methodReference() {
			return getRuleContext(MethodReferenceContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ClassInstanceCreationExpressionContext classInstanceCreationExpression() {
			return getRuleContext(ClassInstanceCreationExpressionContext.class,0);
		}
		public PrimaryNoNewArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPrimaryNoNewArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPrimaryNoNewArray(this);
		}
	}

	public final PrimaryNoNewArrayContext primaryNoNewArray() throws RecognitionException {
		PrimaryNoNewArrayContext _localctx = new PrimaryNoNewArrayContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_primaryNoNewArray);
		int _la;
		try {
			setState(1948);
			switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1920); literal();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1921); typeName();
				setState(1925);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1922); dim();
					}
					}
					setState(1927);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1928); match(DOT);
				setState(1929); classKeyword();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1931); match(VOID);
				setState(1932); match(DOT);
				setState(1933); classKeyword();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1934); match(THIS);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1935); typeName();
				setState(1936); match(DOT);
				setState(1937); match(THIS);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1939); match(LPAREN);
				setState(1940); expression();
				setState(1941); match(RPAREN);
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1943); classInstanceCreationExpression();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1944); fieldAccess();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1945); arrayAccess();
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1946); methodInvocation();
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1947); methodReference();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassKeywordContext extends ParserRuleContext {
		public ClassKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classKeyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterClassKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitClassKeyword(this);
		}
	}

	public final ClassKeywordContext classKeyword() throws RecognitionException {
		ClassKeywordContext _localctx = new ClassKeywordContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_classKeyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1950); match(CLASS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lf_arrayAccessContext extends ParserRuleContext {
		public PrimaryNoNewArray_lf_arrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPrimaryNoNewArray_lf_arrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPrimaryNoNewArray_lf_arrayAccess(this);
		}
	}

	public final PrimaryNoNewArray_lf_arrayAccessContext primaryNoNewArray_lf_arrayAccess() throws RecognitionException {
		PrimaryNoNewArray_lf_arrayAccessContext _localctx = new PrimaryNoNewArray_lf_arrayAccessContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_primaryNoNewArray_lf_arrayAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lfno_arrayAccessContext extends ParserRuleContext {
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public DimContext dim(int i) {
			return getRuleContext(DimContext.class,i);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<DimContext> dim() {
			return getRuleContexts(DimContext.class);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ClassKeywordContext classKeyword() {
			return getRuleContext(ClassKeywordContext.class,0);
		}
		public MethodReferenceContext methodReference() {
			return getRuleContext(MethodReferenceContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ClassInstanceCreationExpressionContext classInstanceCreationExpression() {
			return getRuleContext(ClassInstanceCreationExpressionContext.class,0);
		}
		public PrimaryNoNewArray_lfno_arrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPrimaryNoNewArray_lfno_arrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPrimaryNoNewArray_lfno_arrayAccess(this);
		}
	}

	public final PrimaryNoNewArray_lfno_arrayAccessContext primaryNoNewArray_lfno_arrayAccess() throws RecognitionException {
		PrimaryNoNewArray_lfno_arrayAccessContext _localctx = new PrimaryNoNewArray_lfno_arrayAccessContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_primaryNoNewArray_lfno_arrayAccess);
		int _la;
		try {
			setState(1981);
			switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1954); literal();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1955); typeName();
				setState(1959);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1956); dim();
					}
					}
					setState(1961);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1962); match(DOT);
				setState(1963); classKeyword();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1965); match(VOID);
				setState(1966); match(DOT);
				setState(1967); classKeyword();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1968); match(THIS);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1969); typeName();
				setState(1970); match(DOT);
				setState(1971); classKeyword();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1973); match(LPAREN);
				setState(1974); expression();
				setState(1975); match(RPAREN);
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1977); classInstanceCreationExpression();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1978); fieldAccess();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1979); methodInvocation();
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1980); methodReference();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lf_primaryContext extends ParserRuleContext {
		public ClassInstanceCreationExpression_lf_primaryContext classInstanceCreationExpression_lf_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lf_primaryContext.class,0);
		}
		public ArrayAccess_lf_primaryContext arrayAccess_lf_primary() {
			return getRuleContext(ArrayAccess_lf_primaryContext.class,0);
		}
		public MethodReference_lf_primaryContext methodReference_lf_primary() {
			return getRuleContext(MethodReference_lf_primaryContext.class,0);
		}
		public MethodInvocation_lf_primaryContext methodInvocation_lf_primary() {
			return getRuleContext(MethodInvocation_lf_primaryContext.class,0);
		}
		public FieldAccess_lf_primaryContext fieldAccess_lf_primary() {
			return getRuleContext(FieldAccess_lf_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPrimaryNoNewArray_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPrimaryNoNewArray_lf_primary(this);
		}
	}

	public final PrimaryNoNewArray_lf_primaryContext primaryNoNewArray_lf_primary() throws RecognitionException {
		PrimaryNoNewArray_lf_primaryContext _localctx = new PrimaryNoNewArray_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_primaryNoNewArray_lf_primary);
		try {
			setState(1988);
			switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1983); classInstanceCreationExpression_lf_primary();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1984); fieldAccess_lf_primary();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1985); arrayAccess_lf_primary();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1986); methodInvocation_lf_primary();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1987); methodReference_lf_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(this);
		}
	}

	public final PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary() throws RecognitionException {
		PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext _localctx = new PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext extends ParserRuleContext {
		public ClassInstanceCreationExpression_lf_primaryContext classInstanceCreationExpression_lf_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lf_primaryContext.class,0);
		}
		public MethodReference_lf_primaryContext methodReference_lf_primary() {
			return getRuleContext(MethodReference_lf_primaryContext.class,0);
		}
		public MethodInvocation_lf_primaryContext methodInvocation_lf_primary() {
			return getRuleContext(MethodInvocation_lf_primaryContext.class,0);
		}
		public FieldAccess_lf_primaryContext fieldAccess_lf_primary() {
			return getRuleContext(FieldAccess_lf_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(this);
		}
	}

	public final PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary() throws RecognitionException {
		PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext _localctx = new PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary);
		try {
			setState(1996);
			switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1992); classInstanceCreationExpression_lf_primary();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1993); fieldAccess_lf_primary();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1994); methodInvocation_lf_primary();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1995); methodReference_lf_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lfno_primaryContext extends ParserRuleContext {
		public FieldAccess_lfno_primaryContext fieldAccess_lfno_primary() {
			return getRuleContext(FieldAccess_lfno_primaryContext.class,0);
		}
		public DimContext dim(int i) {
			return getRuleContext(DimContext.class,i);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<DimContext> dim() {
			return getRuleContexts(DimContext.class);
		}
		public ClassInstanceCreationExpression_lfno_primaryContext classInstanceCreationExpression_lfno_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lfno_primaryContext.class,0);
		}
		public MethodReference_lfno_primaryContext methodReference_lfno_primary() {
			return getRuleContext(MethodReference_lfno_primaryContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ArrayAccess_lfno_primaryContext arrayAccess_lfno_primary() {
			return getRuleContext(ArrayAccess_lfno_primaryContext.class,0);
		}
		public ClassKeywordContext classKeyword() {
			return getRuleContext(ClassKeywordContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnannPrimitiveTypeContext unannPrimitiveType() {
			return getRuleContext(UnannPrimitiveTypeContext.class,0);
		}
		public MethodInvocation_lfno_primaryContext methodInvocation_lfno_primary() {
			return getRuleContext(MethodInvocation_lfno_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPrimaryNoNewArray_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPrimaryNoNewArray_lfno_primary(this);
		}
	}

	public final PrimaryNoNewArray_lfno_primaryContext primaryNoNewArray_lfno_primary() throws RecognitionException {
		PrimaryNoNewArray_lfno_primaryContext _localctx = new PrimaryNoNewArray_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 376, RULE_primaryNoNewArray_lfno_primary);
		int _la;
		try {
			setState(2036);
			switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1998); literal();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1999); typeName();
				setState(2003);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(2000); dim();
					}
					}
					setState(2005);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2006); match(DOT);
				setState(2007); classKeyword();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2009); unannPrimitiveType();
				setState(2013);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(2010); dim();
					}
					}
					setState(2015);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2016); match(DOT);
				setState(2017); classKeyword();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2019); match(VOID);
				setState(2020); match(DOT);
				setState(2021); classKeyword();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2022); match(THIS);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2023); typeName();
				setState(2024); match(DOT);
				setState(2025); match(THIS);
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2027); match(LPAREN);
				setState(2028); expression();
				setState(2029); match(RPAREN);
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2031); classInstanceCreationExpression_lfno_primary();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2032); fieldAccess_lfno_primary();
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2033); arrayAccess_lfno_primary();
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2034); methodInvocation_lfno_primary();
				}
				break;

			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(2035); methodReference_lfno_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(this);
		}
	}

	public final PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary() throws RecognitionException {
		PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext _localctx = new PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext extends ParserRuleContext {
		public FieldAccess_lfno_primaryContext fieldAccess_lfno_primary() {
			return getRuleContext(FieldAccess_lfno_primaryContext.class,0);
		}
		public DimContext dim(int i) {
			return getRuleContext(DimContext.class,i);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<DimContext> dim() {
			return getRuleContexts(DimContext.class);
		}
		public ClassInstanceCreationExpression_lfno_primaryContext classInstanceCreationExpression_lfno_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lfno_primaryContext.class,0);
		}
		public MethodReference_lfno_primaryContext methodReference_lfno_primary() {
			return getRuleContext(MethodReference_lfno_primaryContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ClassKeywordContext classKeyword() {
			return getRuleContext(ClassKeywordContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnannPrimitiveTypeContext unannPrimitiveType() {
			return getRuleContext(UnannPrimitiveTypeContext.class,0);
		}
		public MethodInvocation_lfno_primaryContext methodInvocation_lfno_primary() {
			return getRuleContext(MethodInvocation_lfno_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(this);
		}
	}

	public final PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary() throws RecognitionException {
		PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext _localctx = new PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary);
		int _la;
		try {
			setState(2077);
			switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2040); literal();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2041); typeName();
				setState(2045);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(2042); dim();
					}
					}
					setState(2047);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2048); match(DOT);
				setState(2049); classKeyword();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2051); unannPrimitiveType();
				setState(2055);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(2052); dim();
					}
					}
					setState(2057);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2058); match(DOT);
				setState(2059); classKeyword();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2061); match(VOID);
				setState(2062); match(DOT);
				setState(2063); classKeyword();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2064); match(THIS);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2065); typeName();
				setState(2066); match(DOT);
				setState(2067); match(THIS);
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2069); match(LPAREN);
				setState(2070); expression();
				setState(2071); match(RPAREN);
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2073); classInstanceCreationExpression_lfno_primary();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2074); fieldAccess_lfno_primary();
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2075); methodInvocation_lfno_primary();
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2076); methodReference_lfno_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassInstanceCreationExpressionContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public List<AnnotatedQualifierElementContext> annotatedQualifierElement() {
			return getRuleContexts(AnnotatedQualifierElementContext.class);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public AnnotatedQualifierElementContext annotatedQualifierElement(int i) {
			return getRuleContext(AnnotatedQualifierElementContext.class,i);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ClassInstanceCreationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInstanceCreationExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterClassInstanceCreationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitClassInstanceCreationExpression(this);
		}
	}

	public final ClassInstanceCreationExpressionContext classInstanceCreationExpression() throws RecognitionException {
		ClassInstanceCreationExpressionContext _localctx = new ClassInstanceCreationExpressionContext(_ctx, getState());
		enterRule(_localctx, 382, RULE_classInstanceCreationExpression);
		int _la;
		try {
			setState(2138);
			switch ( getInterpreter().adaptivePredict(_input,215,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2079); match(NEW);
				setState(2081);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2080); typeArguments();
					}
				}

				setState(2083); annotatedQualifierElement();
				setState(2088);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(2084); match(DOT);
					setState(2085); annotatedQualifierElement();
					}
					}
					setState(2090);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2092);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2091); typeArgumentsOrDiamond();
					}
				}

				setState(2094); match(LPAREN);
				setState(2096);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2095); argumentList();
					}
				}

				setState(2098); match(RPAREN);
				setState(2100);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(2099); classBody();
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2102); expressionName();
				setState(2103); match(DOT);
				setState(2104); match(NEW);
				setState(2106);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2105); typeArguments();
					}
				}

				setState(2108); annotatedQualifierElement();
				setState(2110);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2109); typeArgumentsOrDiamond();
					}
				}

				setState(2112); match(LPAREN);
				setState(2114);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2113); argumentList();
					}
				}

				setState(2116); match(RPAREN);
				setState(2118);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(2117); classBody();
					}
				}

				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2120); primary();
				setState(2121); match(DOT);
				setState(2122); match(NEW);
				setState(2124);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2123); typeArguments();
					}
				}

				setState(2126); annotatedQualifierElement();
				setState(2128);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2127); typeArgumentsOrDiamond();
					}
				}

				setState(2130); match(LPAREN);
				setState(2132);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2131); argumentList();
					}
				}

				setState(2134); match(RPAREN);
				setState(2136);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(2135); classBody();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassInstanceCreationExpression_lf_primaryContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public AnnotatedQualifierElementContext annotatedQualifierElement() {
			return getRuleContext(AnnotatedQualifierElementContext.class,0);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ClassInstanceCreationExpression_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInstanceCreationExpression_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterClassInstanceCreationExpression_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitClassInstanceCreationExpression_lf_primary(this);
		}
	}

	public final ClassInstanceCreationExpression_lf_primaryContext classInstanceCreationExpression_lf_primary() throws RecognitionException {
		ClassInstanceCreationExpression_lf_primaryContext _localctx = new ClassInstanceCreationExpression_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_classInstanceCreationExpression_lf_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2140); match(DOT);
			setState(2141); match(NEW);
			setState(2143);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(2142); typeArguments();
				}
			}

			setState(2145); annotatedQualifierElement();
			setState(2147);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(2146); typeArgumentsOrDiamond();
				}
			}

			setState(2149); match(LPAREN);
			setState(2151);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
				{
				setState(2150); argumentList();
				}
			}

			setState(2153); match(RPAREN);
			setState(2155);
			switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
			case 1:
				{
				setState(2154); classBody();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassInstanceCreationExpression_lfno_primaryContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public List<AnnotatedQualifierElementContext> annotatedQualifierElement() {
			return getRuleContexts(AnnotatedQualifierElementContext.class);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public AnnotatedQualifierElementContext annotatedQualifierElement(int i) {
			return getRuleContext(AnnotatedQualifierElementContext.class,i);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ClassInstanceCreationExpression_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInstanceCreationExpression_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterClassInstanceCreationExpression_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitClassInstanceCreationExpression_lfno_primary(this);
		}
	}

	public final ClassInstanceCreationExpression_lfno_primaryContext classInstanceCreationExpression_lfno_primary() throws RecognitionException {
		ClassInstanceCreationExpression_lfno_primaryContext _localctx = new ClassInstanceCreationExpression_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 386, RULE_classInstanceCreationExpression_lfno_primary);
		int _la;
		try {
			setState(2198);
			switch (_input.LA(1)) {
			case NEW:
				enterOuterAlt(_localctx, 1);
				{
				setState(2157); match(NEW);
				setState(2159);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2158); typeArguments();
					}
				}

				setState(2161); annotatedQualifierElement();
				setState(2166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(2162); match(DOT);
					setState(2163); annotatedQualifierElement();
					}
					}
					setState(2168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2170);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2169); typeArgumentsOrDiamond();
					}
				}

				setState(2172); match(LPAREN);
				setState(2174);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2173); argumentList();
					}
				}

				setState(2176); match(RPAREN);
				setState(2178);
				switch ( getInterpreter().adaptivePredict(_input,224,_ctx) ) {
				case 1:
					{
					setState(2177); classBody();
					}
					break;
				}
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(2180); expressionName();
				setState(2181); match(DOT);
				setState(2182); match(NEW);
				setState(2184);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2183); typeArguments();
					}
				}

				setState(2186); annotatedQualifierElement();
				setState(2188);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2187); typeArgumentsOrDiamond();
					}
				}

				setState(2190); match(LPAREN);
				setState(2192);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2191); argumentList();
					}
				}

				setState(2194); match(RPAREN);
				setState(2196);
				switch ( getInterpreter().adaptivePredict(_input,228,_ctx) ) {
				case 1:
					{
					setState(2195); classBody();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotatedQualifierElementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public AnnotatedQualifierElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotatedQualifierElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAnnotatedQualifierElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAnnotatedQualifierElement(this);
		}
	}

	public final AnnotatedQualifierElementContext annotatedQualifierElement() throws RecognitionException {
		AnnotatedQualifierElementContext _localctx = new AnnotatedQualifierElementContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_annotatedQualifierElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(2200); annotation();
				}
				}
				setState(2205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2206); match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentsOrDiamondContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TypeArgumentsOrDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentsOrDiamond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterTypeArgumentsOrDiamond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitTypeArgumentsOrDiamond(this);
		}
	}

	public final TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() throws RecognitionException {
		TypeArgumentsOrDiamondContext _localctx = new TypeArgumentsOrDiamondContext(_ctx, getState());
		enterRule(_localctx, 390, RULE_typeArgumentsOrDiamond);
		try {
			setState(2211);
			switch ( getInterpreter().adaptivePredict(_input,231,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2208); typeArguments();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2209); match(LT);
				setState(2210); match(GT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldAccessContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public SuperKeywordContext superKeyword() {
			return getRuleContext(SuperKeywordContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public FieldAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterFieldAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitFieldAccess(this);
		}
	}

	public final FieldAccessContext fieldAccess() throws RecognitionException {
		FieldAccessContext _localctx = new FieldAccessContext(_ctx, getState());
		enterRule(_localctx, 392, RULE_fieldAccess);
		try {
			setState(2227);
			switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2213); primary();
				setState(2214); match(DOT);
				setState(2215); match(Identifier);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2217); superKeyword();
				setState(2218); match(DOT);
				setState(2219); match(Identifier);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2221); typeName();
				setState(2222); match(DOT);
				setState(2223); superKeyword();
				setState(2224); match(DOT);
				setState(2225); match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldAccess_lf_primaryContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public FieldAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterFieldAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitFieldAccess_lf_primary(this);
		}
	}

	public final FieldAccess_lf_primaryContext fieldAccess_lf_primary() throws RecognitionException {
		FieldAccess_lf_primaryContext _localctx = new FieldAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 394, RULE_fieldAccess_lf_primary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2229); match(DOT);
			setState(2230); match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldAccess_lfno_primaryContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public SuperKeywordContext superKeyword() {
			return getRuleContext(SuperKeywordContext.class,0);
		}
		public FieldAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterFieldAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitFieldAccess_lfno_primary(this);
		}
	}

	public final FieldAccess_lfno_primaryContext fieldAccess_lfno_primary() throws RecognitionException {
		FieldAccess_lfno_primaryContext _localctx = new FieldAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 396, RULE_fieldAccess_lfno_primary);
		try {
			setState(2242);
			switch (_input.LA(1)) {
			case SUPER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2232); superKeyword();
				setState(2233); match(DOT);
				setState(2234); match(Identifier);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(2236); typeName();
				setState(2237); match(DOT);
				setState(2238); superKeyword();
				setState(2239); match(DOT);
				setState(2240); match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayAccessContext extends ParserRuleContext {
		public PrimaryNoNewArray_lfno_arrayAccessContext primaryNoNewArray_lfno_arrayAccess() {
			return getRuleContext(PrimaryNoNewArray_lfno_arrayAccessContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PrimaryNoNewArray_lf_arrayAccessContext primaryNoNewArray_lf_arrayAccess(int i) {
			return getRuleContext(PrimaryNoNewArray_lf_arrayAccessContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public List<PrimaryNoNewArray_lf_arrayAccessContext> primaryNoNewArray_lf_arrayAccess() {
			return getRuleContexts(PrimaryNoNewArray_lf_arrayAccessContext.class);
		}
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitArrayAccess(this);
		}
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 398, RULE_arrayAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2254);
			switch ( getInterpreter().adaptivePredict(_input,234,_ctx) ) {
			case 1:
				{
				setState(2244); expressionName();
				setState(2245); match(LBRACK);
				setState(2246); expression();
				setState(2247); match(RBRACK);
				}
				break;

			case 2:
				{
				setState(2249); primaryNoNewArray_lfno_arrayAccess();
				setState(2250); match(LBRACK);
				setState(2251); expression();
				setState(2252); match(RBRACK);
				}
				break;
			}
			setState(2263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(2256); primaryNoNewArray_lf_arrayAccess();
				setState(2257); match(LBRACK);
				setState(2258); expression();
				setState(2259); match(RBRACK);
				}
				}
				setState(2265);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayAccess_lf_primaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary() {
			return getRuleContext(PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(int i) {
			return getRuleContext(PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext.class,i);
		}
		public List<PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext> primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary() {
			return getRuleContexts(PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ArrayAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterArrayAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitArrayAccess_lf_primary(this);
		}
	}

	public final ArrayAccess_lf_primaryContext arrayAccess_lf_primary() throws RecognitionException {
		ArrayAccess_lf_primaryContext _localctx = new ArrayAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 400, RULE_arrayAccess_lf_primary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2266); primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary();
			setState(2267); match(LBRACK);
			setState(2268); expression();
			setState(2269); match(RBRACK);
			}
			setState(2278);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,236,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2271); primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary();
					setState(2272); match(LBRACK);
					setState(2273); expression();
					setState(2274); match(RBRACK);
					}
					} 
				}
				setState(2280);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,236,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayAccess_lfno_primaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary() {
			return getRuleContext(PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext> primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary() {
			return getRuleContexts(PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext.class);
		}
		public PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(int i) {
			return getRuleContext(PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public ArrayAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterArrayAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitArrayAccess_lfno_primary(this);
		}
	}

	public final ArrayAccess_lfno_primaryContext arrayAccess_lfno_primary() throws RecognitionException {
		ArrayAccess_lfno_primaryContext _localctx = new ArrayAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 402, RULE_arrayAccess_lfno_primary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2291);
			switch ( getInterpreter().adaptivePredict(_input,237,_ctx) ) {
			case 1:
				{
				setState(2281); expressionName();
				setState(2282); match(LBRACK);
				setState(2283); expression();
				setState(2284); match(RBRACK);
				}
				break;

			case 2:
				{
				setState(2286); primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary();
				setState(2287); match(LBRACK);
				setState(2288); expression();
				setState(2289); match(RBRACK);
				}
				break;
			}
			setState(2300);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,238,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2293); primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary();
					setState(2294); match(LBRACK);
					setState(2295); expression();
					setState(2296); match(RBRACK);
					}
					} 
				}
				setState(2302);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,238,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodInvocationContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public SuperKeywordContext superKeyword() {
			return getRuleContext(SuperKeywordContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public MethodInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMethodInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMethodInvocation(this);
		}
	}

	public final MethodInvocationContext methodInvocation() throws RecognitionException {
		MethodInvocationContext _localctx = new MethodInvocationContext(_ctx, getState());
		enterRule(_localctx, 404, RULE_methodInvocation);
		int _la;
		try {
			setState(2372);
			switch ( getInterpreter().adaptivePredict(_input,250,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2303); methodName();
				setState(2304); match(LPAREN);
				setState(2306);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2305); argumentList();
					}
				}

				setState(2308); match(RPAREN);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2310); typeName();
				setState(2311); match(DOT);
				setState(2313);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2312); typeArguments();
					}
				}

				setState(2315); match(Identifier);
				setState(2316); match(LPAREN);
				setState(2318);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2317); argumentList();
					}
				}

				setState(2320); match(RPAREN);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2322); expressionName();
				setState(2323); match(DOT);
				setState(2325);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2324); typeArguments();
					}
				}

				setState(2327); match(Identifier);
				setState(2328); match(LPAREN);
				setState(2330);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2329); argumentList();
					}
				}

				setState(2332); match(RPAREN);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2334); primary();
				setState(2335); match(DOT);
				setState(2337);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2336); typeArguments();
					}
				}

				setState(2339); match(Identifier);
				setState(2340); match(LPAREN);
				setState(2342);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2341); argumentList();
					}
				}

				setState(2344); match(RPAREN);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2346); superKeyword();
				setState(2347); match(DOT);
				setState(2349);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2348); typeArguments();
					}
				}

				setState(2351); match(Identifier);
				setState(2352); match(LPAREN);
				setState(2354);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2353); argumentList();
					}
				}

				setState(2356); match(RPAREN);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2358); typeName();
				setState(2359); match(DOT);
				setState(2360); superKeyword();
				setState(2361); match(DOT);
				setState(2363);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2362); typeArguments();
					}
				}

				setState(2365); match(Identifier);
				setState(2366); match(LPAREN);
				setState(2368);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2367); argumentList();
					}
				}

				setState(2370); match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuperKeywordContext extends ParserRuleContext {
		public SuperKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superKeyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterSuperKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitSuperKeyword(this);
		}
	}

	public final SuperKeywordContext superKeyword() throws RecognitionException {
		SuperKeywordContext _localctx = new SuperKeywordContext(_ctx, getState());
		enterRule(_localctx, 406, RULE_superKeyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2374); match(SUPER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodInvocation_lf_primaryContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public MethodInvocation_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMethodInvocation_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMethodInvocation_lf_primary(this);
		}
	}

	public final MethodInvocation_lf_primaryContext methodInvocation_lf_primary() throws RecognitionException {
		MethodInvocation_lf_primaryContext _localctx = new MethodInvocation_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 408, RULE_methodInvocation_lf_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2376); match(DOT);
			setState(2378);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(2377); typeArguments();
				}
			}

			setState(2380); match(Identifier);
			setState(2381); match(LPAREN);
			setState(2383);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
				{
				setState(2382); argumentList();
				}
			}

			setState(2385); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodInvocation_lfno_primaryContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public MethodInvocation_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMethodInvocation_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMethodInvocation_lfno_primary(this);
		}
	}

	public final MethodInvocation_lfno_primaryContext methodInvocation_lfno_primary() throws RecognitionException {
		MethodInvocation_lfno_primaryContext _localctx = new MethodInvocation_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 410, RULE_methodInvocation_lfno_primary);
		int _la;
		try {
			setState(2443);
			switch ( getInterpreter().adaptivePredict(_input,262,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2387); methodName();
				setState(2388); match(LPAREN);
				setState(2390);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2389); argumentList();
					}
				}

				setState(2392); match(RPAREN);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2394); typeName();
				setState(2395); match(DOT);
				setState(2397);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2396); typeArguments();
					}
				}

				setState(2399); match(Identifier);
				setState(2400); match(LPAREN);
				setState(2402);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2401); argumentList();
					}
				}

				setState(2404); match(RPAREN);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2406); expressionName();
				setState(2407); match(DOT);
				setState(2409);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2408); typeArguments();
					}
				}

				setState(2411); match(Identifier);
				setState(2412); match(LPAREN);
				setState(2414);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2413); argumentList();
					}
				}

				setState(2416); match(RPAREN);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2418); match(SUPER);
				setState(2419); match(DOT);
				setState(2421);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2420); typeArguments();
					}
				}

				setState(2423); match(Identifier);
				setState(2424); match(LPAREN);
				setState(2426);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2425); argumentList();
					}
				}

				setState(2428); match(RPAREN);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2429); typeName();
				setState(2430); match(DOT);
				setState(2431); match(SUPER);
				setState(2432); match(DOT);
				setState(2434);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2433); typeArguments();
					}
				}

				setState(2436); match(Identifier);
				setState(2437); match(LPAREN);
				setState(2439);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2438); argumentList();
					}
				}

				setState(2441); match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentListContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitArgumentList(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 412, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2445); expression();
			setState(2450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2446); match(COMMA);
				setState(2447); expression();
				}
				}
				setState(2452);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodReferenceContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public MethodReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMethodReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMethodReference(this);
		}
	}

	public final MethodReferenceContext methodReference() throws RecognitionException {
		MethodReferenceContext _localctx = new MethodReferenceContext(_ctx, getState());
		enterRule(_localctx, 414, RULE_methodReference);
		int _la;
		try {
			setState(2500);
			switch ( getInterpreter().adaptivePredict(_input,270,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2453); expressionName();
				setState(2454); match(COLONCOLON);
				setState(2456);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2455); typeArguments();
					}
				}

				setState(2458); match(Identifier);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2460); referenceType();
				setState(2461); match(COLONCOLON);
				setState(2463);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2462); typeArguments();
					}
				}

				setState(2465); match(Identifier);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2467); primary();
				setState(2468); match(COLONCOLON);
				setState(2470);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2469); typeArguments();
					}
				}

				setState(2472); match(Identifier);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2474); match(SUPER);
				setState(2475); match(COLONCOLON);
				setState(2477);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2476); typeArguments();
					}
				}

				setState(2479); match(Identifier);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2480); typeName();
				setState(2481); match(DOT);
				setState(2482); match(SUPER);
				setState(2483); match(COLONCOLON);
				setState(2485);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2484); typeArguments();
					}
				}

				setState(2487); match(Identifier);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2489); classType();
				setState(2490); match(COLONCOLON);
				setState(2492);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2491); typeArguments();
					}
				}

				setState(2494); match(NEW);
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2496); arrayType();
				setState(2497); match(COLONCOLON);
				setState(2498); match(NEW);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodReference_lf_primaryContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public MethodReference_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodReference_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMethodReference_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMethodReference_lf_primary(this);
		}
	}

	public final MethodReference_lf_primaryContext methodReference_lf_primary() throws RecognitionException {
		MethodReference_lf_primaryContext _localctx = new MethodReference_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 416, RULE_methodReference_lf_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2502); match(COLONCOLON);
			setState(2504);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(2503); typeArguments();
				}
			}

			setState(2506); match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodReference_lfno_primaryContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public MethodReference_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodReference_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMethodReference_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMethodReference_lfno_primary(this);
		}
	}

	public final MethodReference_lfno_primaryContext methodReference_lfno_primary() throws RecognitionException {
		MethodReference_lfno_primaryContext _localctx = new MethodReference_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 418, RULE_methodReference_lfno_primary);
		int _la;
		try {
			setState(2548);
			switch ( getInterpreter().adaptivePredict(_input,277,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2508); expressionName();
				setState(2509); match(COLONCOLON);
				setState(2511);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2510); typeArguments();
					}
				}

				setState(2513); match(Identifier);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2515); referenceType();
				setState(2516); match(COLONCOLON);
				setState(2518);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2517); typeArguments();
					}
				}

				setState(2520); match(Identifier);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2522); match(SUPER);
				setState(2523); match(COLONCOLON);
				setState(2525);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2524); typeArguments();
					}
				}

				setState(2527); match(Identifier);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2528); typeName();
				setState(2529); match(DOT);
				setState(2530); match(SUPER);
				setState(2531); match(COLONCOLON);
				setState(2533);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2532); typeArguments();
					}
				}

				setState(2535); match(Identifier);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2537); classType();
				setState(2538); match(COLONCOLON);
				setState(2540);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2539); typeArguments();
					}
				}

				setState(2542); match(NEW);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2544); arrayType();
				setState(2545); match(COLONCOLON);
				setState(2546); match(NEW);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayCreationExpressionContext extends ParserRuleContext {
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public DimExprsContext dimExprs() {
			return getRuleContext(DimExprsContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ArrayCreationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreationExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterArrayCreationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitArrayCreationExpression(this);
		}
	}

	public final ArrayCreationExpressionContext arrayCreationExpression() throws RecognitionException {
		ArrayCreationExpressionContext _localctx = new ArrayCreationExpressionContext(_ctx, getState());
		enterRule(_localctx, 420, RULE_arrayCreationExpression);
		try {
			setState(2572);
			switch ( getInterpreter().adaptivePredict(_input,280,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2550); match(NEW);
				setState(2551); primitiveType();
				setState(2552); dimExprs();
				setState(2554);
				switch ( getInterpreter().adaptivePredict(_input,278,_ctx) ) {
				case 1:
					{
					setState(2553); dims();
					}
					break;
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2556); match(NEW);
				setState(2557); classOrInterfaceType();
				setState(2558); dimExprs();
				setState(2560);
				switch ( getInterpreter().adaptivePredict(_input,279,_ctx) ) {
				case 1:
					{
					setState(2559); dims();
					}
					break;
				}
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2562); match(NEW);
				setState(2563); primitiveType();
				setState(2564); dims();
				setState(2565); arrayInitializer();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2567); match(NEW);
				setState(2568); classOrInterfaceType();
				setState(2569); dims();
				setState(2570); arrayInitializer();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimExprsContext extends ParserRuleContext {
		public List<DimExprContext> dimExpr() {
			return getRuleContexts(DimExprContext.class);
		}
		public DimExprContext dimExpr(int i) {
			return getRuleContext(DimExprContext.class,i);
		}
		public DimExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimExprs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterDimExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitDimExprs(this);
		}
	}

	public final DimExprsContext dimExprs() throws RecognitionException {
		DimExprsContext _localctx = new DimExprsContext(_ctx, getState());
		enterRule(_localctx, 422, RULE_dimExprs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2574); dimExpr();
			setState(2578);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,281,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2575); dimExpr();
					}
					} 
				}
				setState(2580);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,281,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimExprContext extends ParserRuleContext {
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DimExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterDimExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitDimExpr(this);
		}
	}

	public final DimExprContext dimExpr() throws RecognitionException {
		DimExprContext _localctx = new DimExprContext(_ctx, getState());
		enterRule(_localctx, 424, RULE_dimExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2584);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(2581); annotation();
				}
				}
				setState(2586);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2587); match(LBRACK);
			setState(2588); expression();
			setState(2589); match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstantExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterConstantExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitConstantExpression(this);
		}
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 426, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2591); expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 428, RULE_expression);
		try {
			setState(2595);
			switch ( getInterpreter().adaptivePredict(_input,283,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2593); lambdaExpression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2594); assignmentExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaExpressionContext extends ParserRuleContext {
		public LambdaBodyContext lambdaBody() {
			return getRuleContext(LambdaBodyContext.class,0);
		}
		public LambdaParametersContext lambdaParameters() {
			return getRuleContext(LambdaParametersContext.class,0);
		}
		public LambdaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterLambdaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitLambdaExpression(this);
		}
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 430, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2597); lambdaParameters();
			setState(2598); match(ARROW);
			setState(2599); lambdaBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaParametersContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public InferredFormalParameterListContext inferredFormalParameterList() {
			return getRuleContext(InferredFormalParameterListContext.class,0);
		}
		public LambdaParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterLambdaParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitLambdaParameters(this);
		}
	}

	public final LambdaParametersContext lambdaParameters() throws RecognitionException {
		LambdaParametersContext _localctx = new LambdaParametersContext(_ctx, getState());
		enterRule(_localctx, 432, RULE_lambdaParameters);
		int _la;
		try {
			setState(2611);
			switch ( getInterpreter().adaptivePredict(_input,285,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2601); match(Identifier);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2602); match(LPAREN);
				setState(2604);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || _la==Identifier || _la==AT) {
					{
					setState(2603); formalParameterList();
					}
				}

				setState(2606); match(RPAREN);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2607); match(LPAREN);
				setState(2608); inferredFormalParameterList();
				setState(2609); match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InferredFormalParameterListContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(Java8Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(Java8Parser.Identifier, i);
		}
		public InferredFormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inferredFormalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterInferredFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitInferredFormalParameterList(this);
		}
	}

	public final InferredFormalParameterListContext inferredFormalParameterList() throws RecognitionException {
		InferredFormalParameterListContext _localctx = new InferredFormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 434, RULE_inferredFormalParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2613); match(Identifier);
			setState(2618);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2614); match(COMMA);
				setState(2615); match(Identifier);
				}
				}
				setState(2620);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaBodyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LambdaBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterLambdaBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitLambdaBody(this);
		}
	}

	public final LambdaBodyContext lambdaBody() throws RecognitionException {
		LambdaBodyContext _localctx = new LambdaBodyContext(_ctx, getState());
		enterRule(_localctx, 436, RULE_lambdaBody);
		try {
			setState(2623);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2621); expression();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2622); block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAssignmentExpression(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 438, RULE_assignmentExpression);
		try {
			setState(2627);
			switch ( getInterpreter().adaptivePredict(_input,288,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2625); conditionalExpression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2626); assignment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public LeftHandSideContext leftHandSide() {
			return getRuleContext(LeftHandSideContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 440, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2629); leftHandSide();
			setState(2630); assignmentOperator();
			setState(2631); expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LeftHandSideContext extends ParserRuleContext {
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public LeftHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftHandSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterLeftHandSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitLeftHandSide(this);
		}
	}

	public final LeftHandSideContext leftHandSide() throws RecognitionException {
		LeftHandSideContext _localctx = new LeftHandSideContext(_ctx, getState());
		enterRule(_localctx, 442, RULE_leftHandSide);
		try {
			setState(2636);
			switch ( getInterpreter().adaptivePredict(_input,289,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2633); expressionName();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2634); fieldAccess();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2635); arrayAccess();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentOperatorContext extends ParserRuleContext {
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAssignmentOperator(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 444, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2638);
			_la = _input.LA(1);
			if ( !(((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (ASSIGN - 66)) | (1L << (ADD_ASSIGN - 66)) | (1L << (SUB_ASSIGN - 66)) | (1L << (MUL_ASSIGN - 66)) | (1L << (DIV_ASSIGN - 66)) | (1L << (AND_ASSIGN - 66)) | (1L << (OR_ASSIGN - 66)) | (1L << (XOR_ASSIGN - 66)) | (1L << (MOD_ASSIGN - 66)) | (1L << (LSHIFT_ASSIGN - 66)) | (1L << (RSHIFT_ASSIGN - 66)) | (1L << (URSHIFT_ASSIGN - 66)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ConditionalOrExpressionContext conditionalOrExpression() {
			return getRuleContext(ConditionalOrExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitConditionalExpression(this);
		}
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 446, RULE_conditionalExpression);
		try {
			setState(2647);
			switch ( getInterpreter().adaptivePredict(_input,290,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2640); conditionalOrExpression(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2641); conditionalOrExpression(0);
				setState(2642); match(QUESTION);
				setState(2643); expression();
				setState(2644); match(COLON);
				setState(2645); conditionalExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalOrExpressionContext extends ParserRuleContext {
		public ConditionalOrExpressionContext conditionalOrExpression() {
			return getRuleContext(ConditionalOrExpressionContext.class,0);
		}
		public ConditionalAndExpressionContext conditionalAndExpression() {
			return getRuleContext(ConditionalAndExpressionContext.class,0);
		}
		public ConditionalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterConditionalOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitConditionalOrExpression(this);
		}
	}

	public final ConditionalOrExpressionContext conditionalOrExpression() throws RecognitionException {
		return conditionalOrExpression(0);
	}

	private ConditionalOrExpressionContext conditionalOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionalOrExpressionContext _localctx = new ConditionalOrExpressionContext(_ctx, _parentState);
		ConditionalOrExpressionContext _prevctx = _localctx;
		int _startState = 448;
		enterRecursionRule(_localctx, 448, RULE_conditionalOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2650); conditionalAndExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2657);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,291,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionalOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conditionalOrExpression);
					setState(2652);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2653); match(OR);
					setState(2654); conditionalAndExpression(0);
					}
					} 
				}
				setState(2659);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,291,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionalAndExpressionContext extends ParserRuleContext {
		public InclusiveOrExpressionContext inclusiveOrExpression() {
			return getRuleContext(InclusiveOrExpressionContext.class,0);
		}
		public ConditionalAndExpressionContext conditionalAndExpression() {
			return getRuleContext(ConditionalAndExpressionContext.class,0);
		}
		public ConditionalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalAndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterConditionalAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitConditionalAndExpression(this);
		}
	}

	public final ConditionalAndExpressionContext conditionalAndExpression() throws RecognitionException {
		return conditionalAndExpression(0);
	}

	private ConditionalAndExpressionContext conditionalAndExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionalAndExpressionContext _localctx = new ConditionalAndExpressionContext(_ctx, _parentState);
		ConditionalAndExpressionContext _prevctx = _localctx;
		int _startState = 450;
		enterRecursionRule(_localctx, 450, RULE_conditionalAndExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2661); inclusiveOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2668);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,292,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionalAndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conditionalAndExpression);
					setState(2663);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2664); match(AND);
					setState(2665); inclusiveOrExpression(0);
					}
					} 
				}
				setState(2670);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,292,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InclusiveOrExpressionContext extends ParserRuleContext {
		public InclusiveOrExpressionContext inclusiveOrExpression() {
			return getRuleContext(InclusiveOrExpressionContext.class,0);
		}
		public ExclusiveOrExpressionContext exclusiveOrExpression() {
			return getRuleContext(ExclusiveOrExpressionContext.class,0);
		}
		public InclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusiveOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterInclusiveOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitInclusiveOrExpression(this);
		}
	}

	public final InclusiveOrExpressionContext inclusiveOrExpression() throws RecognitionException {
		return inclusiveOrExpression(0);
	}

	private InclusiveOrExpressionContext inclusiveOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InclusiveOrExpressionContext _localctx = new InclusiveOrExpressionContext(_ctx, _parentState);
		InclusiveOrExpressionContext _prevctx = _localctx;
		int _startState = 452;
		enterRecursionRule(_localctx, 452, RULE_inclusiveOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2672); exclusiveOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2679);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,293,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InclusiveOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_inclusiveOrExpression);
					setState(2674);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2675); match(BITOR);
					setState(2676); exclusiveOrExpression(0);
					}
					} 
				}
				setState(2681);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,293,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExclusiveOrExpressionContext extends ParserRuleContext {
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public ExclusiveOrExpressionContext exclusiveOrExpression() {
			return getRuleContext(ExclusiveOrExpressionContext.class,0);
		}
		public ExclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusiveOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterExclusiveOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitExclusiveOrExpression(this);
		}
	}

	public final ExclusiveOrExpressionContext exclusiveOrExpression() throws RecognitionException {
		return exclusiveOrExpression(0);
	}

	private ExclusiveOrExpressionContext exclusiveOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExclusiveOrExpressionContext _localctx = new ExclusiveOrExpressionContext(_ctx, _parentState);
		ExclusiveOrExpressionContext _prevctx = _localctx;
		int _startState = 454;
		enterRecursionRule(_localctx, 454, RULE_exclusiveOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2683); andExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2690);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,294,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExclusiveOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exclusiveOrExpression);
					setState(2685);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2686); match(CARET);
					setState(2687); andExpression(0);
					}
					} 
				}
				setState(2692);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,294,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AndExpressionContext extends ParserRuleContext {
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAndExpression(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		return andExpression(0);
	}

	private AndExpressionContext andExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, _parentState);
		AndExpressionContext _prevctx = _localctx;
		int _startState = 456;
		enterRecursionRule(_localctx, 456, RULE_andExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2694); equalityExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2701);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,295,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andExpression);
					setState(2696);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2697); match(BITAND);
					setState(2698); equalityExpression(0);
					}
					} 
				}
				setState(2703);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,295,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends ParserRuleContext {
		public EqualityExpressionEqualToSymbolContext equalityExpressionEqualToSymbol() {
			return getRuleContext(EqualityExpressionEqualToSymbolContext.class,0);
		}
		public EqualityExpressionNotEqualToSymbolContext equalityExpressionNotEqualToSymbol() {
			return getRuleContext(EqualityExpressionNotEqualToSymbolContext.class,0);
		}
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitEqualityExpression(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		return equalityExpression(0);
	}

	private EqualityExpressionContext equalityExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, _parentState);
		EqualityExpressionContext _prevctx = _localctx;
		int _startState = 458;
		enterRecursionRule(_localctx, 458, RULE_equalityExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2705); relationalExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2717);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,297,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2715);
					switch ( getInterpreter().adaptivePredict(_input,296,_ctx) ) {
					case 1:
						{
						_localctx = new EqualityExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
						setState(2707);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2708); equalityExpressionEqualToSymbol();
						setState(2709); relationalExpression(0);
						}
						break;

					case 2:
						{
						_localctx = new EqualityExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
						setState(2711);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2712); equalityExpressionNotEqualToSymbol();
						setState(2713); relationalExpression(0);
						}
						break;
					}
					} 
				}
				setState(2719);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,297,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityExpressionEqualToSymbolContext extends ParserRuleContext {
		public EqualityExpressionEqualToSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpressionEqualToSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterEqualityExpressionEqualToSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitEqualityExpressionEqualToSymbol(this);
		}
	}

	public final EqualityExpressionEqualToSymbolContext equalityExpressionEqualToSymbol() throws RecognitionException {
		EqualityExpressionEqualToSymbolContext _localctx = new EqualityExpressionEqualToSymbolContext(_ctx, getState());
		enterRule(_localctx, 460, RULE_equalityExpressionEqualToSymbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2720); match(EQUAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityExpressionNotEqualToSymbolContext extends ParserRuleContext {
		public EqualityExpressionNotEqualToSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpressionNotEqualToSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterEqualityExpressionNotEqualToSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitEqualityExpressionNotEqualToSymbol(this);
		}
	}

	public final EqualityExpressionNotEqualToSymbolContext equalityExpressionNotEqualToSymbol() throws RecognitionException {
		EqualityExpressionNotEqualToSymbolContext _localctx = new EqualityExpressionNotEqualToSymbolContext(_ctx, getState());
		enterRule(_localctx, 462, RULE_equalityExpressionNotEqualToSymbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2722); match(NOTEQUAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExpressionContext extends ParserRuleContext {
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public RelationalExpressionGTContext relationalExpressionGT() {
			return getRuleContext(RelationalExpressionGTContext.class,0);
		}
		public RelationalExpressionLTEContext relationalExpressionLTE() {
			return getRuleContext(RelationalExpressionLTEContext.class,0);
		}
		public RelationalExpressionLTContext relationalExpressionLT() {
			return getRuleContext(RelationalExpressionLTContext.class,0);
		}
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public RelationalExpressionGTEContext relationalExpressionGTE() {
			return getRuleContext(RelationalExpressionGTEContext.class,0);
		}
		public RelationalExpressionIOContext relationalExpressionIO() {
			return getRuleContext(RelationalExpressionIOContext.class,0);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitRelationalExpression(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		return relationalExpression(0);
	}

	private RelationalExpressionContext relationalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, _parentState);
		RelationalExpressionContext _prevctx = _localctx;
		int _startState = 464;
		enterRecursionRule(_localctx, 464, RULE_relationalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2725); shiftExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2749);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,299,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2747);
					switch ( getInterpreter().adaptivePredict(_input,298,_ctx) ) {
					case 1:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(2727);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(2728); relationalExpressionLT();
						setState(2729); shiftExpression(0);
						}
						break;

					case 2:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(2731);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(2732); relationalExpressionGT();
						setState(2733); shiftExpression(0);
						}
						break;

					case 3:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(2735);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2736); relationalExpressionLTE();
						setState(2737); shiftExpression(0);
						}
						break;

					case 4:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(2739);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2740); relationalExpressionGTE();
						setState(2741); shiftExpression(0);
						}
						break;

					case 5:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(2743);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2744); relationalExpressionIO();
						setState(2745); referenceType();
						}
						break;
					}
					} 
				}
				setState(2751);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,299,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelationalExpressionLTContext extends ParserRuleContext {
		public RelationalExpressionLTContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpressionLT; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterRelationalExpressionLT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitRelationalExpressionLT(this);
		}
	}

	public final RelationalExpressionLTContext relationalExpressionLT() throws RecognitionException {
		RelationalExpressionLTContext _localctx = new RelationalExpressionLTContext(_ctx, getState());
		enterRule(_localctx, 466, RULE_relationalExpressionLT);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2752); match(LT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExpressionGTContext extends ParserRuleContext {
		public RelationalExpressionGTContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpressionGT; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterRelationalExpressionGT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitRelationalExpressionGT(this);
		}
	}

	public final RelationalExpressionGTContext relationalExpressionGT() throws RecognitionException {
		RelationalExpressionGTContext _localctx = new RelationalExpressionGTContext(_ctx, getState());
		enterRule(_localctx, 468, RULE_relationalExpressionGT);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2754); match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExpressionLTEContext extends ParserRuleContext {
		public RelationalExpressionLTEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpressionLTE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterRelationalExpressionLTE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitRelationalExpressionLTE(this);
		}
	}

	public final RelationalExpressionLTEContext relationalExpressionLTE() throws RecognitionException {
		RelationalExpressionLTEContext _localctx = new RelationalExpressionLTEContext(_ctx, getState());
		enterRule(_localctx, 470, RULE_relationalExpressionLTE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2756); match(LE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExpressionGTEContext extends ParserRuleContext {
		public RelationalExpressionGTEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpressionGTE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterRelationalExpressionGTE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitRelationalExpressionGTE(this);
		}
	}

	public final RelationalExpressionGTEContext relationalExpressionGTE() throws RecognitionException {
		RelationalExpressionGTEContext _localctx = new RelationalExpressionGTEContext(_ctx, getState());
		enterRule(_localctx, 472, RULE_relationalExpressionGTE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2758); match(GE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExpressionIOContext extends ParserRuleContext {
		public RelationalExpressionIOContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpressionIO; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterRelationalExpressionIO(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitRelationalExpressionIO(this);
		}
	}

	public final RelationalExpressionIOContext relationalExpressionIO() throws RecognitionException {
		RelationalExpressionIOContext _localctx = new RelationalExpressionIOContext(_ctx, getState());
		enterRule(_localctx, 474, RULE_relationalExpressionIO);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2760); match(INSTANCEOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShiftExpressionContext extends ParserRuleContext {
		public ShiftExpressionSLLContext shiftExpressionSLL() {
			return getRuleContext(ShiftExpressionSLLContext.class,0);
		}
		public ShiftExpressionSRAContext shiftExpressionSRA() {
			return getRuleContext(ShiftExpressionSRAContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public ShiftExpressionSRLContext shiftExpressionSRL() {
			return getRuleContext(ShiftExpressionSRLContext.class,0);
		}
		public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterShiftExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitShiftExpression(this);
		}
	}

	public final ShiftExpressionContext shiftExpression() throws RecognitionException {
		return shiftExpression(0);
	}

	private ShiftExpressionContext shiftExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, _parentState);
		ShiftExpressionContext _prevctx = _localctx;
		int _startState = 476;
		enterRecursionRule(_localctx, 476, RULE_shiftExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2763); additiveExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2779);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,301,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2777);
					switch ( getInterpreter().adaptivePredict(_input,300,_ctx) ) {
					case 1:
						{
						_localctx = new ShiftExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
						setState(2765);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2766); shiftExpressionSLL();
						setState(2767); additiveExpression(0);
						}
						break;

					case 2:
						{
						_localctx = new ShiftExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
						setState(2769);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2770); shiftExpressionSRL();
						setState(2771); additiveExpression(0);
						}
						break;

					case 3:
						{
						_localctx = new ShiftExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
						setState(2773);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2774); shiftExpressionSRA();
						setState(2775); additiveExpression(0);
						}
						break;
					}
					} 
				}
				setState(2781);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,301,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ShiftExpressionSLLContext extends ParserRuleContext {
		public ShiftExpressionSLLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpressionSLL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterShiftExpressionSLL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitShiftExpressionSLL(this);
		}
	}

	public final ShiftExpressionSLLContext shiftExpressionSLL() throws RecognitionException {
		ShiftExpressionSLLContext _localctx = new ShiftExpressionSLLContext(_ctx, getState());
		enterRule(_localctx, 478, RULE_shiftExpressionSLL);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2782); match(LT);
			setState(2783); match(LT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShiftExpressionSRLContext extends ParserRuleContext {
		public ShiftExpressionSRLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpressionSRL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterShiftExpressionSRL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitShiftExpressionSRL(this);
		}
	}

	public final ShiftExpressionSRLContext shiftExpressionSRL() throws RecognitionException {
		ShiftExpressionSRLContext _localctx = new ShiftExpressionSRLContext(_ctx, getState());
		enterRule(_localctx, 480, RULE_shiftExpressionSRL);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2785); match(GT);
			setState(2786); match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShiftExpressionSRAContext extends ParserRuleContext {
		public ShiftExpressionSRAContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpressionSRA; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterShiftExpressionSRA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitShiftExpressionSRA(this);
		}
	}

	public final ShiftExpressionSRAContext shiftExpressionSRA() throws RecognitionException {
		ShiftExpressionSRAContext _localctx = new ShiftExpressionSRAContext(_ctx, getState());
		enterRule(_localctx, 482, RULE_shiftExpressionSRA);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2788); match(GT);
			setState(2789); match(GT);
			setState(2790); match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public AdditiveExpressionPContext additiveExpressionP() {
			return getRuleContext(AdditiveExpressionPContext.class,0);
		}
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveExpressionMContext additiveExpressionM() {
			return getRuleContext(AdditiveExpressionMContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAdditiveExpression(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		return additiveExpression(0);
	}

	private AdditiveExpressionContext additiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, _parentState);
		AdditiveExpressionContext _prevctx = _localctx;
		int _startState = 484;
		enterRecursionRule(_localctx, 484, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2793); multiplicativeExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2805);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,303,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2803);
					switch ( getInterpreter().adaptivePredict(_input,302,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(2795);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2796); additiveExpressionP();
						setState(2797); multiplicativeExpression(0);
						}
						break;

					case 2:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(2799);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2800); additiveExpressionM();
						setState(2801); multiplicativeExpression(0);
						}
						break;
					}
					} 
				}
				setState(2807);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,303,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AdditiveExpressionPContext extends ParserRuleContext {
		public AdditiveExpressionPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpressionP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAdditiveExpressionP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAdditiveExpressionP(this);
		}
	}

	public final AdditiveExpressionPContext additiveExpressionP() throws RecognitionException {
		AdditiveExpressionPContext _localctx = new AdditiveExpressionPContext(_ctx, getState());
		enterRule(_localctx, 486, RULE_additiveExpressionP);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2808); match(ADD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExpressionMContext extends ParserRuleContext {
		public AdditiveExpressionMContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpressionM; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterAdditiveExpressionM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitAdditiveExpressionM(this);
		}
	}

	public final AdditiveExpressionMContext additiveExpressionM() throws RecognitionException {
		AdditiveExpressionMContext _localctx = new AdditiveExpressionMContext(_ctx, getState());
		enterRule(_localctx, 488, RULE_additiveExpressionM);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2810); match(SUB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public MultiplicativeExpressionDContext multiplicativeExpressionD() {
			return getRuleContext(MultiplicativeExpressionDContext.class,0);
		}
		public MultiplicativeExpressionModContext multiplicativeExpressionMod() {
			return getRuleContext(MultiplicativeExpressionModContext.class,0);
		}
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public MultiplicativeExpressionMContext multiplicativeExpressionM() {
			return getRuleContext(MultiplicativeExpressionMContext.class,0);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMultiplicativeExpression(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		return multiplicativeExpression(0);
	}

	private MultiplicativeExpressionContext multiplicativeExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, _parentState);
		MultiplicativeExpressionContext _prevctx = _localctx;
		int _startState = 490;
		enterRecursionRule(_localctx, 490, RULE_multiplicativeExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2813); unaryExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(2829);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,305,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2827);
					switch ( getInterpreter().adaptivePredict(_input,304,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(2815);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2816); multiplicativeExpressionM();
						setState(2817); unaryExpression();
						}
						break;

					case 2:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(2819);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2820); multiplicativeExpressionD();
						setState(2821); unaryExpression();
						}
						break;

					case 3:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(2823);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2824); multiplicativeExpressionMod();
						setState(2825); unaryExpression();
						}
						break;
					}
					} 
				}
				setState(2831);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,305,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionMContext extends ParserRuleContext {
		public MultiplicativeExpressionMContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpressionM; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMultiplicativeExpressionM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMultiplicativeExpressionM(this);
		}
	}

	public final MultiplicativeExpressionMContext multiplicativeExpressionM() throws RecognitionException {
		MultiplicativeExpressionMContext _localctx = new MultiplicativeExpressionMContext(_ctx, getState());
		enterRule(_localctx, 492, RULE_multiplicativeExpressionM);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2832); match(MUL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionDContext extends ParserRuleContext {
		public MultiplicativeExpressionDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpressionD; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMultiplicativeExpressionD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMultiplicativeExpressionD(this);
		}
	}

	public final MultiplicativeExpressionDContext multiplicativeExpressionD() throws RecognitionException {
		MultiplicativeExpressionDContext _localctx = new MultiplicativeExpressionDContext(_ctx, getState());
		enterRule(_localctx, 494, RULE_multiplicativeExpressionD);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2834); match(DIV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionModContext extends ParserRuleContext {
		public MultiplicativeExpressionModContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpressionMod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterMultiplicativeExpressionMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitMultiplicativeExpressionMod(this);
		}
	}

	public final MultiplicativeExpressionModContext multiplicativeExpressionMod() throws RecognitionException {
		MultiplicativeExpressionModContext _localctx = new MultiplicativeExpressionModContext(_ctx, getState());
		enterRule(_localctx, 496, RULE_multiplicativeExpressionMod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2836); match(DIV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public UnaryExpressionNotPlusMinusContext unaryExpressionNotPlusMinus() {
			return getRuleContext(UnaryExpressionNotPlusMinusContext.class,0);
		}
		public PreIncrementExpressionContext preIncrementExpression() {
			return getRuleContext(PreIncrementExpressionContext.class,0);
		}
		public UnaryExpressionPContext unaryExpressionP() {
			return getRuleContext(UnaryExpressionPContext.class,0);
		}
		public UnaryExpressionMContext unaryExpressionM() {
			return getRuleContext(UnaryExpressionMContext.class,0);
		}
		public PreDecrementExpressionContext preDecrementExpression() {
			return getRuleContext(PreDecrementExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnaryExpression(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 498, RULE_unaryExpression);
		try {
			setState(2847);
			switch (_input.LA(1)) {
			case INC:
				enterOuterAlt(_localctx, 1);
				{
				setState(2838); preIncrementExpression();
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(2839); preDecrementExpression();
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 3);
				{
				setState(2840); unaryExpressionP();
				setState(2841); unaryExpression();
				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 4);
				{
				setState(2843); unaryExpressionM();
				setState(2844); unaryExpression();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case BANG:
			case TILDE:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 5);
				{
				setState(2846); unaryExpressionNotPlusMinus();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionPContext extends ParserRuleContext {
		public UnaryExpressionPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpressionP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnaryExpressionP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnaryExpressionP(this);
		}
	}

	public final UnaryExpressionPContext unaryExpressionP() throws RecognitionException {
		UnaryExpressionPContext _localctx = new UnaryExpressionPContext(_ctx, getState());
		enterRule(_localctx, 500, RULE_unaryExpressionP);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2849); match(ADD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionMContext extends ParserRuleContext {
		public UnaryExpressionMContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpressionM; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnaryExpressionM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnaryExpressionM(this);
		}
	}

	public final UnaryExpressionMContext unaryExpressionM() throws RecognitionException {
		UnaryExpressionMContext _localctx = new UnaryExpressionMContext(_ctx, getState());
		enterRule(_localctx, 502, RULE_unaryExpressionM);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2851); match(SUB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreIncrementExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public PreIncrementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preIncrementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPreIncrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPreIncrementExpression(this);
		}
	}

	public final PreIncrementExpressionContext preIncrementExpression() throws RecognitionException {
		PreIncrementExpressionContext _localctx = new PreIncrementExpressionContext(_ctx, getState());
		enterRule(_localctx, 504, RULE_preIncrementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2853); match(INC);
			setState(2854); unaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreDecrementExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public PreDecrementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preDecrementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPreDecrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPreDecrementExpression(this);
		}
	}

	public final PreDecrementExpressionContext preDecrementExpression() throws RecognitionException {
		PreDecrementExpressionContext _localctx = new PreDecrementExpressionContext(_ctx, getState());
		enterRule(_localctx, 506, RULE_preDecrementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2856); match(DEC);
			setState(2857); unaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionNotPlusMinusContext extends ParserRuleContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public UnaryExpressionNotPlusMinusBNContext unaryExpressionNotPlusMinusBN() {
			return getRuleContext(UnaryExpressionNotPlusMinusBNContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public UnaryExpressionNotPlusMinusCNContext unaryExpressionNotPlusMinusCN() {
			return getRuleContext(UnaryExpressionNotPlusMinusCNContext.class,0);
		}
		public UnaryExpressionNotPlusMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpressionNotPlusMinus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnaryExpressionNotPlusMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnaryExpressionNotPlusMinus(this);
		}
	}

	public final UnaryExpressionNotPlusMinusContext unaryExpressionNotPlusMinus() throws RecognitionException {
		UnaryExpressionNotPlusMinusContext _localctx = new UnaryExpressionNotPlusMinusContext(_ctx, getState());
		enterRule(_localctx, 508, RULE_unaryExpressionNotPlusMinus);
		try {
			setState(2867);
			switch ( getInterpreter().adaptivePredict(_input,307,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2859); postfixExpression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2860); unaryExpressionNotPlusMinusBN();
				setState(2861); unaryExpression();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2863); unaryExpressionNotPlusMinusCN();
				setState(2864); unaryExpression();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2866); castExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionNotPlusMinusBNContext extends ParserRuleContext {
		public UnaryExpressionNotPlusMinusBNContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpressionNotPlusMinusBN; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnaryExpressionNotPlusMinusBN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnaryExpressionNotPlusMinusBN(this);
		}
	}

	public final UnaryExpressionNotPlusMinusBNContext unaryExpressionNotPlusMinusBN() throws RecognitionException {
		UnaryExpressionNotPlusMinusBNContext _localctx = new UnaryExpressionNotPlusMinusBNContext(_ctx, getState());
		enterRule(_localctx, 510, RULE_unaryExpressionNotPlusMinusBN);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2869); match(TILDE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionNotPlusMinusCNContext extends ParserRuleContext {
		public UnaryExpressionNotPlusMinusCNContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpressionNotPlusMinusCN; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterUnaryExpressionNotPlusMinusCN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitUnaryExpressionNotPlusMinusCN(this);
		}
	}

	public final UnaryExpressionNotPlusMinusCNContext unaryExpressionNotPlusMinusCN() throws RecognitionException {
		UnaryExpressionNotPlusMinusCNContext _localctx = new UnaryExpressionNotPlusMinusCNContext(_ctx, getState());
		enterRule(_localctx, 512, RULE_unaryExpressionNotPlusMinusCN);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2871); match(BANG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixExpressionContext extends ParserRuleContext {
		public List<PostfixExpressionSymbolContext> postfixExpressionSymbol() {
			return getRuleContexts(PostfixExpressionSymbolContext.class);
		}
		public PostfixExpressionSymbolContext postfixExpressionSymbol(int i) {
			return getRuleContext(PostfixExpressionSymbolContext.class,i);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPostfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPostfixExpression(this);
		}
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 514, RULE_postfixExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2875);
			switch ( getInterpreter().adaptivePredict(_input,308,_ctx) ) {
			case 1:
				{
				setState(2873); primary();
				}
				break;

			case 2:
				{
				setState(2874); expressionName();
				}
				break;
			}
			setState(2880);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,309,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2877); postfixExpressionSymbol();
					}
					} 
				}
				setState(2882);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,309,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixExpressionSymbolContext extends ParserRuleContext {
		public PostDecrementExpression_lf_postfixExpressionContext postDecrementExpression_lf_postfixExpression() {
			return getRuleContext(PostDecrementExpression_lf_postfixExpressionContext.class,0);
		}
		public PostIncrementExpression_lf_postfixExpressionContext postIncrementExpression_lf_postfixExpression() {
			return getRuleContext(PostIncrementExpression_lf_postfixExpressionContext.class,0);
		}
		public PostfixExpressionSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpressionSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPostfixExpressionSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPostfixExpressionSymbol(this);
		}
	}

	public final PostfixExpressionSymbolContext postfixExpressionSymbol() throws RecognitionException {
		PostfixExpressionSymbolContext _localctx = new PostfixExpressionSymbolContext(_ctx, getState());
		enterRule(_localctx, 516, RULE_postfixExpressionSymbol);
		try {
			setState(2885);
			switch (_input.LA(1)) {
			case INC:
				enterOuterAlt(_localctx, 1);
				{
				setState(2883); postIncrementExpression_lf_postfixExpression();
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(2884); postDecrementExpression_lf_postfixExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostIncrementExpressionContext extends ParserRuleContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public PostIncrementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postIncrementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPostIncrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPostIncrementExpression(this);
		}
	}

	public final PostIncrementExpressionContext postIncrementExpression() throws RecognitionException {
		PostIncrementExpressionContext _localctx = new PostIncrementExpressionContext(_ctx, getState());
		enterRule(_localctx, 518, RULE_postIncrementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2887); postfixExpression();
			setState(2888); match(INC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostIncrementExpression_lf_postfixExpressionContext extends ParserRuleContext {
		public PostIncrementExpression_lf_postfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postIncrementExpression_lf_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPostIncrementExpression_lf_postfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPostIncrementExpression_lf_postfixExpression(this);
		}
	}

	public final PostIncrementExpression_lf_postfixExpressionContext postIncrementExpression_lf_postfixExpression() throws RecognitionException {
		PostIncrementExpression_lf_postfixExpressionContext _localctx = new PostIncrementExpression_lf_postfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 520, RULE_postIncrementExpression_lf_postfixExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2890); match(INC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostDecrementExpressionContext extends ParserRuleContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public PostDecrementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postDecrementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPostDecrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPostDecrementExpression(this);
		}
	}

	public final PostDecrementExpressionContext postDecrementExpression() throws RecognitionException {
		PostDecrementExpressionContext _localctx = new PostDecrementExpressionContext(_ctx, getState());
		enterRule(_localctx, 522, RULE_postDecrementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2892); postfixExpression();
			setState(2893); match(DEC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostDecrementExpression_lf_postfixExpressionContext extends ParserRuleContext {
		public PostDecrementExpression_lf_postfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postDecrementExpression_lf_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterPostDecrementExpression_lf_postfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitPostDecrementExpression_lf_postfixExpression(this);
		}
	}

	public final PostDecrementExpression_lf_postfixExpressionContext postDecrementExpression_lf_postfixExpression() throws RecognitionException {
		PostDecrementExpression_lf_postfixExpressionContext _localctx = new PostDecrementExpression_lf_postfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 524, RULE_postDecrementExpression_lf_postfixExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2895); match(DEC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public UnaryExpressionNotPlusMinusContext unaryExpressionNotPlusMinus() {
			return getRuleContext(UnaryExpressionNotPlusMinusContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public List<AdditionalBoundContext> additionalBound() {
			return getRuleContexts(AdditionalBoundContext.class);
		}
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public AdditionalBoundContext additionalBound(int i) {
			return getRuleContext(AdditionalBoundContext.class,i);
		}
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8ParserListener ) ((Java8ParserListener)listener).exitCastExpression(this);
		}
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 526, RULE_castExpression);
		int _la;
		try {
			setState(2924);
			switch ( getInterpreter().adaptivePredict(_input,313,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2897); match(LPAREN);
				setState(2898); primitiveType();
				setState(2899); match(RPAREN);
				setState(2900); unaryExpression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2902); match(LPAREN);
				setState(2903); referenceType();
				setState(2907);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BITAND) {
					{
					{
					setState(2904); additionalBound();
					}
					}
					setState(2909);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2910); match(RPAREN);
				setState(2911); unaryExpressionNotPlusMinus();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2913); match(LPAREN);
				setState(2914); referenceType();
				setState(2918);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BITAND) {
					{
					{
					setState(2915); additionalBound();
					}
					}
					setState(2920);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2921); match(RPAREN);
				setState(2922); lambdaExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 29: return packageName_sempred((PackageNameContext)_localctx, predIndex);

		case 31: return packageOrTypeName_sempred((PackageOrTypeNameContext)_localctx, predIndex);

		case 34: return ambiguousName_sempred((AmbiguousNameContext)_localctx, predIndex);

		case 224: return conditionalOrExpression_sempred((ConditionalOrExpressionContext)_localctx, predIndex);

		case 225: return conditionalAndExpression_sempred((ConditionalAndExpressionContext)_localctx, predIndex);

		case 226: return inclusiveOrExpression_sempred((InclusiveOrExpressionContext)_localctx, predIndex);

		case 227: return exclusiveOrExpression_sempred((ExclusiveOrExpressionContext)_localctx, predIndex);

		case 228: return andExpression_sempred((AndExpressionContext)_localctx, predIndex);

		case 229: return equalityExpression_sempred((EqualityExpressionContext)_localctx, predIndex);

		case 232: return relationalExpression_sempred((RelationalExpressionContext)_localctx, predIndex);

		case 238: return shiftExpression_sempred((ShiftExpressionContext)_localctx, predIndex);

		case 242: return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);

		case 245: return multiplicativeExpression_sempred((MultiplicativeExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean shiftExpression_sempred(ShiftExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 16: return precpred(_ctx, 2);

		case 17: return precpred(_ctx, 1);

		case 15: return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18: return precpred(_ctx, 2);

		case 19: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean packageOrTypeName_sempred(PackageOrTypeNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean inclusiveOrExpression_sempred(InclusiveOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationalExpression_sempred(RelationalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10: return precpred(_ctx, 5);

		case 11: return precpred(_ctx, 4);

		case 12: return precpred(_ctx, 3);

		case 13: return precpred(_ctx, 2);

		case 14: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conditionalAndExpression_sempred(ConditionalAndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicativeExpression_sempred(MultiplicativeExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 20: return precpred(_ctx, 3);

		case 21: return precpred(_ctx, 2);

		case 22: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean ambiguousName_sempred(AmbiguousNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean andExpression_sempred(AndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conditionalOrExpression_sempred(ConditionalOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean exclusiveOrExpression_sempred(ExclusiveOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equalityExpression_sempred(EqualityExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8: return precpred(_ctx, 2);

		case 9: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean packageName_sempred(PackageNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}

	private static final int _serializedATNSegments = 2;
	private static final String _serializedATNSegment0 =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3m\u0b71\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"+
		"\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097"+
		"\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"+
		"\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f\4\u00a0"+
		"\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4\t\u00a4"+
		"\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7\t\u00a7\4\u00a8\t\u00a8\4\u00a9"+
		"\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\4\u00ac\t\u00ac\4\u00ad\t\u00ad"+
		"\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0\t\u00b0\4\u00b1\t\u00b1\4\u00b2"+
		"\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4\4\u00b5\t\u00b5\4\u00b6\t\u00b6"+
		"\4\u00b7\t\u00b7\4\u00b8\t\u00b8\4\u00b9\t\u00b9\4\u00ba\t\u00ba\4\u00bb"+
		"\t\u00bb\4\u00bc\t\u00bc\4\u00bd\t\u00bd\4\u00be\t\u00be\4\u00bf\t\u00bf"+
		"\4\u00c0\t\u00c0\4\u00c1\t\u00c1\4\u00c2\t\u00c2\4\u00c3\t\u00c3\4\u00c4"+
		"\t\u00c4\4\u00c5\t\u00c5\4\u00c6\t\u00c6\4\u00c7\t\u00c7\4\u00c8\t\u00c8"+
		"\4\u00c9\t\u00c9\4\u00ca\t\u00ca\4\u00cb\t\u00cb\4\u00cc\t\u00cc\4\u00cd"+
		"\t\u00cd\4\u00ce\t\u00ce\4\u00cf\t\u00cf\4\u00d0\t\u00d0\4\u00d1\t\u00d1"+
		"\4\u00d2\t\u00d2\4\u00d3\t\u00d3\4\u00d4\t\u00d4\4\u00d5\t\u00d5\4\u00d6"+
		"\t\u00d6\4\u00d7\t\u00d7\4\u00d8\t\u00d8\4\u00d9\t\u00d9\4\u00da\t\u00da"+
		"\4\u00db\t\u00db\4\u00dc\t\u00dc\4\u00dd\t\u00dd\4\u00de\t\u00de\4\u00df"+
		"\t\u00df\4\u00e0\t\u00e0\4\u00e1\t\u00e1\4\u00e2\t\u00e2\4\u00e3\t\u00e3"+
		"\4\u00e4\t\u00e4\4\u00e5\t\u00e5\4\u00e6\t\u00e6\4\u00e7\t\u00e7\4\u00e8"+
		"\t\u00e8\4\u00e9\t\u00e9\4\u00ea\t\u00ea\4\u00eb\t\u00eb\4\u00ec\t\u00ec"+
		"\4\u00ed\t\u00ed\4\u00ee\t\u00ee\4\u00ef\t\u00ef\4\u00f0\t\u00f0\4\u00f1"+
		"\t\u00f1\4\u00f2\t\u00f2\4\u00f3\t\u00f3\4\u00f4\t\u00f4\4\u00f5\t\u00f5"+
		"\4\u00f6\t\u00f6\4\u00f7\t\u00f7\4\u00f8\t\u00f8\4\u00f9\t\u00f9\4\u00fa"+
		"\t\u00fa\4\u00fb\t\u00fb\4\u00fc\t\u00fc\4\u00fd\t\u00fd\4\u00fe\t\u00fe"+
		"\4\u00ff\t\u00ff\4\u0100\t\u0100\4\u0101\t\u0101\4\u0102\t\u0102\4\u0103"+
		"\t\u0103\4\u0104\t\u0104\4\u0105\t\u0105\4\u0106\t\u0106\4\u0107\t\u0107"+
		"\4\u0108\t\u0108\4\u0109\t\u0109\3\2\3\2\3\3\7\3\u0216\n\3\f\3\16\3\u0219"+
		"\13\3\3\3\3\3\7\3\u021d\n\3\f\3\16\3\u0220\13\3\3\3\5\3\u0223\n\3\3\4"+
		"\3\4\5\4\u0227\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\5\7\u0230\n\7\3\b\3\b\5"+
		"\b\u0234\n\b\3\b\7\b\u0237\n\b\f\b\16\b\u023a\13\b\3\t\3\t\5\t\u023e\n"+
		"\t\3\n\7\n\u0241\n\n\f\n\16\n\u0244\13\n\3\n\3\n\5\n\u0248\n\n\3\n\3\n"+
		"\3\n\7\n\u024d\n\n\f\n\16\n\u0250\13\n\3\n\3\n\5\n\u0254\n\n\5\n\u0256"+
		"\n\n\3\13\3\13\7\13\u025a\n\13\f\13\16\13\u025d\13\13\3\13\3\13\5\13\u0261"+
		"\n\13\3\f\7\f\u0264\n\f\f\f\16\f\u0267\13\f\3\f\3\f\5\f\u026b\n\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\20\7\20\u0274\n\20\f\20\16\20\u0277\13\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0284\n\21"+
		"\3\22\3\22\7\22\u0288\n\22\f\22\16\22\u028b\13\22\3\23\7\23\u028e\n\23"+
		"\f\23\16\23\u0291\13\23\3\23\3\23\3\24\3\24\3\24\3\25\7\25\u0299\n\25"+
		"\f\25\16\25\u029c\13\25\3\25\3\25\5\25\u02a0\n\25\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\7\27\u02a9\n\27\f\27\16\27\u02ac\13\27\5\27\u02ae\n\27"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\7\32\u02ba\n\32\f\32"+
		"\16\32\u02bd\13\32\3\33\3\33\5\33\u02c1\n\33\3\34\7\34\u02c4\n\34\f\34"+
		"\16\34\u02c7\13\34\3\34\3\34\5\34\u02cb\n\34\3\35\3\35\3\35\5\35\u02d0"+
		"\n\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u02db\n\37\f\37"+
		"\16\37\u02de\13\37\3 \3 \3 \3 \3 \5 \u02e5\n \3!\3!\3!\3!\3!\3!\7!\u02ed"+
		"\n!\f!\16!\u02f0\13!\3\"\3\"\3\"\3\"\3\"\5\"\u02f7\n\"\3#\3#\3$\3$\3$"+
		"\3$\3$\3$\7$\u0301\n$\f$\16$\u0304\13$\3%\5%\u0307\n%\3%\7%\u030a\n%\f"+
		"%\16%\u030d\13%\3%\7%\u0310\n%\f%\16%\u0313\13%\3%\3%\3&\7&\u0318\n&\f"+
		"&\16&\u031b\13&\3&\3&\3&\3&\3\'\3\'\3(\3(\3(\3(\5(\u0327\n(\3)\3)\3)\3"+
		")\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3-\3-\3"+
		"-\5-\u0344\n-\3.\3.\5.\u0348\n.\3/\7/\u034b\n/\f/\16/\u034e\13/\3/\3/"+
		"\3/\5/\u0353\n/\3/\5/\u0356\n/\3/\5/\u0359\n/\3/\3/\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\5\60\u0365\n\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62"+
		"\7\62\u036e\n\62\f\62\16\62\u0371\13\62\3\63\3\63\3\63\3\64\3\64\3\64"+
		"\3\65\3\65\3\65\7\65\u037c\n\65\f\65\16\65\u037f\13\65\3\66\3\66\7\66"+
		"\u0383\n\66\f\66\16\66\u0386\13\66\3\66\3\66\3\67\3\67\3\67\3\67\5\67"+
		"\u038e\n\67\38\38\38\38\38\58\u0395\n8\39\79\u0398\n9\f9\169\u039b\13"+
		"9\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3:\5:\u03a9\n:\3;\3;\3;\7;\u03ae\n"+
		";\f;\16;\u03b1\13;\3<\3<\3<\5<\u03b6\n<\3=\3=\5=\u03ba\n=\3>\3>\5>\u03be"+
		"\n>\3?\3?\5?\u03c2\n?\3@\3@\5@\u03c6\n@\3A\3A\3A\5A\u03cb\nA\3B\3B\5B"+
		"\u03cf\nB\3B\7B\u03d2\nB\fB\16B\u03d5\13B\3C\3C\5C\u03d9\nC\3D\3D\5D\u03dd"+
		"\nD\3D\3D\3D\7D\u03e2\nD\fD\16D\u03e5\13D\3D\3D\5D\u03e9\nD\5D\u03eb\n"+
		"D\3E\3E\7E\u03ef\nE\fE\16E\u03f2\13E\3E\3E\5E\u03f6\nE\3F\3F\5F\u03fa"+
		"\nF\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3K\3K\3K\3K\3K\3K\3K\5K\u040d\nK\3L"+
		"\7L\u0410\nL\fL\16L\u0413\13L\3L\3L\3L\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\5"+
		"M\u0422\nM\3N\3N\3N\5N\u0427\nN\3N\3N\7N\u042b\nN\fN\16N\u042e\13N\3N"+
		"\3N\3N\5N\u0433\nN\5N\u0435\nN\3O\3O\5O\u0439\nO\3P\3P\3P\5P\u043e\nP"+
		"\3P\3P\5P\u0442\nP\3Q\3Q\3Q\3Q\3Q\3Q\5Q\u044a\nQ\3R\3R\3R\7R\u044f\nR"+
		"\fR\16R\u0452\13R\3R\3R\3R\7R\u0457\nR\fR\16R\u045a\13R\5R\u045c\nR\3"+
		"S\7S\u045f\nS\fS\16S\u0462\13S\3S\3S\3S\3T\3T\5T\u0469\nT\3U\7U\u046c"+
		"\nU\fU\16U\u046f\13U\3U\3U\7U\u0473\nU\fU\16U\u0476\13U\3U\3U\3U\3U\5"+
		"U\u047c\nU\3V\7V\u047f\nV\fV\16V\u0482\13V\3V\3V\3V\5V\u0487\nV\3V\3V"+
		"\3W\3W\3W\3X\3X\3X\7X\u0491\nX\fX\16X\u0494\13X\3Y\3Y\5Y\u0498\nY\3Z\3"+
		"Z\5Z\u049c\nZ\3[\3[\3\\\3\\\3\\\3]\7]\u04a4\n]\f]\16]\u04a7\13]\3]\3]"+
		"\5]\u04ab\n]\3]\3]\3^\3^\3^\3^\5^\u04b3\n^\3_\5_\u04b6\n_\3_\3_\3_\5_"+
		"\u04bb\n_\3_\3_\3`\3`\3a\3a\5a\u04c3\na\3a\5a\u04c6\na\3a\3a\3b\5b\u04cb"+
		"\nb\3b\3b\3b\5b\u04d0\nb\3b\3b\3b\5b\u04d5\nb\3b\3b\3b\5b\u04da\nb\3b"+
		"\3b\3b\3b\3b\3b\5b\u04e2\nb\3b\3b\3b\5b\u04e7\nb\3b\3b\3b\3b\3b\3b\5b"+
		"\u04ef\nb\3b\3b\3b\5b\u04f4\nb\3b\3b\3b\5b\u04f9\nb\3c\7c\u04fc\nc\fc"+
		"\16c\u04ff\13c\3c\3c\3c\5c\u0504\nc\3c\3c\3d\3d\5d\u050a\nd\3d\5d\u050d"+
		"\nd\3d\5d\u0510\nd\3d\3d\3e\3e\3e\7e\u0517\ne\fe\16e\u051a\13e\3f\7f\u051d"+
		"\nf\ff\16f\u0520\13f\3f\3f\3f\5f\u0525\nf\3f\5f\u0528\nf\3f\5f\u052b\n"+
		"f\3g\3g\3h\3h\7h\u0531\nh\fh\16h\u0534\13h\3i\3i\5i\u0538\ni\3j\7j\u053b"+
		"\nj\fj\16j\u053e\13j\3j\3j\3j\5j\u0543\nj\3j\5j\u0546\nj\3j\3j\3k\3k\3"+
		"k\3k\3k\3k\3k\5k\u0551\nk\3l\3l\3l\3m\3m\7m\u0558\nm\fm\16m\u055b\13m"+
		"\3m\3m\3n\3n\3n\3n\3n\5n\u0564\nn\3o\7o\u0567\no\fo\16o\u056a\13o\3o\3"+
		"o\3o\3o\3p\3p\3p\3p\5p\u0574\np\3q\7q\u0577\nq\fq\16q\u057a\13q\3q\3q"+
		"\3q\3r\3r\3r\3r\3r\3r\5r\u0585\nr\3s\7s\u0588\ns\fs\16s\u058b\13s\3s\3"+
		"s\3s\3s\3s\3t\3t\7t\u0594\nt\ft\16t\u0597\13t\3t\3t\3u\3u\3u\3u\3u\5u"+
		"\u05a0\nu\3v\7v\u05a3\nv\fv\16v\u05a6\13v\3v\3v\3v\3v\3v\5v\u05ad\nv\3"+
		"v\5v\u05b0\nv\3v\3v\3w\3w\3w\5w\u05b7\nw\3x\3x\3x\3y\3y\3y\5y\u05bf\n"+
		"y\3z\3z\3z\3z\5z\u05c5\nz\3z\3z\3{\3{\3{\7{\u05cc\n{\f{\16{\u05cf\13{"+
		"\3|\3|\3|\3|\3}\3}\3}\5}\u05d8\n}\3~\3~\5~\u05dc\n~\3~\5~\u05df\n~\3~"+
		"\3~\3\177\3\177\3\177\7\177\u05e6\n\177\f\177\16\177\u05e9\13\177\3\u0080"+
		"\3\u0080\3\u0080\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0082"+
		"\3\u0082\5\u0082\u05f6\n\u0082\3\u0082\5\u0082\u05f9\n\u0082\3\u0082\3"+
		"\u0082\3\u0083\3\u0083\3\u0083\7\u0083\u0600\n\u0083\f\u0083\16\u0083"+
		"\u0603\13\u0083\3\u0084\3\u0084\5\u0084\u0607\n\u0084\3\u0084\3\u0084"+
		"\3\u0085\6\u0085\u060c\n\u0085\r\u0085\16\u0085\u060d\3\u0086\3\u0086"+
		"\3\u0086\5\u0086\u0613\n\u0086\3\u0087\3\u0087\3\u0087\3\u0088\7\u0088"+
		"\u0619\n\u0088\f\u0088\16\u0088\u061c\13\u0088\3\u0088\3\u0088\3\u0088"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\5\u0089\u0627\n\u0089"+
		"\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\5\u008a\u062e\n\u008a\3\u008b"+
		"\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b"+
		"\3\u008b\3\u008b\5\u008b\u063c\n\u008b\3\u008c\3\u008c\3\u008d\3\u008d"+
		"\3\u008d\3\u008d\3\u008e\3\u008e\3\u008e\3\u008e\3\u008f\3\u008f\3\u008f"+
		"\3\u0090\3\u0090\3\u0090\3\u0090\3\u0090\3\u0090\3\u0090\5\u0090\u0652"+
		"\n\u0090\3\u0091\3\u0091\3\u0091\3\u0091\3\u0091\3\u0091\3\u0092\3\u0092"+
		"\3\u0092\3\u0092\3\u0092\3\u0092\3\u0092\3\u0092\3\u0093\3\u0093\3\u0093"+
		"\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093\3\u0094\3\u0094\3\u0094\3\u0094"+
		"\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\5\u0094\u0674\n\u0094"+
		"\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0096\3\u0096\7\u0096"+
		"\u067e\n\u0096\f\u0096\16\u0096\u0681\13\u0096\3\u0096\7\u0096\u0684\n"+
		"\u0096\f\u0096\16\u0096\u0687\13\u0096\3\u0096\3\u0096\3\u0097\3\u0097"+
		"\3\u0097\3\u0098\3\u0098\7\u0098\u0690\n\u0098\f\u0098\16\u0098\u0693"+
		"\13\u0098\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099"+
		"\3\u0099\3\u0099\5\u0099\u069f\n\u0099\3\u009a\3\u009a\3\u009b\3\u009b"+
		"\3\u009b\3\u009b\3\u009b\3\u009b\3\u009c\3\u009c\3\u009c\3\u009c\3\u009c"+
		"\3\u009c\3\u009d\3\u009d\3\u009d\3\u009d\3\u009d\3\u009d\3\u009d\3\u009d"+
		"\3\u009e\3\u009e\5\u009e\u06b9\n\u009e\3\u009f\3\u009f\5\u009f\u06bd\n"+
		"\u009f\3\u00a0\3\u00a0\3\u00a0\5\u00a0\u06c2\n\u00a0\3\u00a0\3\u00a0\5"+
		"\u00a0\u06c6\n\u00a0\3\u00a0\3\u00a0\5\u00a0\u06ca\n\u00a0\3\u00a0\3\u00a0"+
		"\3\u00a0\3\u00a1\3\u00a1\3\u00a1\5\u00a1\u06d2\n\u00a1\3\u00a1\3\u00a1"+
		"\5\u00a1\u06d6\n\u00a1\3\u00a1\3\u00a1\5\u00a1\u06da\n\u00a1\3\u00a1\3"+
		"\u00a1\3\u00a1\3\u00a2\3\u00a2\5\u00a2\u06e1\n\u00a2\3\u00a3\3\u00a3\3"+
		"\u00a4\3\u00a4\3\u00a4\7\u00a4\u06e8\n\u00a4\f\u00a4\16\u00a4\u06eb\13"+
		"\u00a4\3\u00a5\3\u00a5\3\u00a5\7\u00a5\u06f0\n\u00a5\f\u00a5\16\u00a5"+
		"\u06f3\13\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5"+
		"\3\u00a6\3\u00a6\3\u00a6\7\u00a6\u06ff\n\u00a6\f\u00a6\16\u00a6\u0702"+
		"\13\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a7"+
		"\3\u00a7\5\u00a7\u070d\n\u00a7\3\u00a7\3\u00a7\3\u00a8\3\u00a8\5\u00a8"+
		"\u0713\n\u00a8\3\u00a8\3\u00a8\3\u00a9\3\u00a9\5\u00a9\u0719\n\u00a9\3"+
		"\u00a9\3\u00a9\3\u00aa\3\u00aa\3\u00aa\3\u00aa\3\u00ab\3\u00ab\3\u00ab"+
		"\3\u00ab\3\u00ab\3\u00ab\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac"+
		"\3\u00ac\5\u00ac\u072e\n\u00ac\3\u00ac\3\u00ac\3\u00ac\5\u00ac\u0733\n"+
		"\u00ac\3\u00ad\3\u00ad\7\u00ad\u0737\n\u00ad\f\u00ad\16\u00ad\u073a\13"+
		"\u00ad\3\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00af\7\u00af"+
		"\u0743\n\u00af\f\u00af\16\u00af\u0746\13\u00af\3\u00af\3\u00af\3\u00af"+
		"\3\u00b0\3\u00b0\3\u00b0\7\u00b0\u074e\n\u00b0\f\u00b0\16\u00b0\u0751"+
		"\13\u00b0\3\u00b1\3\u00b1\3\u00b1\3\u00b2\3\u00b2\3\u00b2\3\u00b2\5\u00b2"+
		"\u075a\n\u00b2\3\u00b2\5\u00b2\u075d\n\u00b2\3\u00b3\3\u00b3\3\u00b3\5"+
		"\u00b3\u0762\n\u00b3\3\u00b3\3\u00b3\3\u00b4\3\u00b4\3\u00b4\7\u00b4\u0769"+
		"\n\u00b4\f\u00b4\16\u00b4\u076c\13\u00b4\3\u00b5\7\u00b5\u076f\n\u00b5"+
		"\f\u00b5\16\u00b5\u0772\13\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b5"+
		"\3\u00b6\3\u00b6\5\u00b6\u077b\n\u00b6\3\u00b6\7\u00b6\u077e\n\u00b6\f"+
		"\u00b6\16\u00b6\u0781\13\u00b6\3\u00b7\3\u00b7\3\u00b7\7\u00b7\u0786\n"+
		"\u00b7\f\u00b7\16\u00b7\u0789\13\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b7"+
		"\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b7"+
		"\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b7\5\u00b7\u079f"+
		"\n\u00b7\3\u00b8\3\u00b8\3\u00b9\3\u00b9\3\u00ba\3\u00ba\3\u00ba\7\u00ba"+
		"\u07a8\n\u00ba\f\u00ba\16\u00ba\u07ab\13\u00ba\3\u00ba\3\u00ba\3\u00ba"+
		"\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba"+
		"\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\5\u00ba\u07c0"+
		"\n\u00ba\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\5\u00bb\u07c7\n\u00bb"+
		"\3\u00bc\3\u00bc\3\u00bd\3\u00bd\3\u00bd\3\u00bd\5\u00bd\u07cf\n\u00bd"+
		"\3\u00be\3\u00be\3\u00be\7\u00be\u07d4\n\u00be\f\u00be\16\u00be\u07d7"+
		"\13\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\7\u00be\u07de\n\u00be"+
		"\f\u00be\16\u00be\u07e1\13\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be"+
		"\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be"+
		"\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\5\u00be\u07f7\n\u00be"+
		"\3\u00bf\3\u00bf\3\u00c0\3\u00c0\3\u00c0\7\u00c0\u07fe\n\u00c0\f\u00c0"+
		"\16\u00c0\u0801\13\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\7\u00c0"+
		"\u0808\n\u00c0\f\u00c0\16\u00c0\u080b\13\u00c0\3\u00c0\3\u00c0\3\u00c0"+
		"\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0"+
		"\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\5\u00c0\u0820"+
		"\n\u00c0\3\u00c1\3\u00c1\5\u00c1\u0824\n\u00c1\3\u00c1\3\u00c1\3\u00c1"+
		"\7\u00c1\u0829\n\u00c1\f\u00c1\16\u00c1\u082c\13\u00c1\3\u00c1\5\u00c1"+
		"\u082f\n\u00c1\3\u00c1\3\u00c1\5\u00c1\u0833\n\u00c1\3\u00c1\3\u00c1\5"+
		"\u00c1\u0837\n\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\5\u00c1\u083d\n\u00c1"+
		"\3\u00c1\3\u00c1\5\u00c1\u0841\n\u00c1\3\u00c1\3\u00c1\5\u00c1\u0845\n"+
		"\u00c1\3\u00c1\3\u00c1\5\u00c1\u0849\n\u00c1\3\u00c1\3\u00c1\3\u00c1\3"+
		"\u00c1\5\u00c1\u084f\n\u00c1\3\u00c1\3\u00c1\5\u00c1\u0853\n\u00c1\3\u00c1"+
		"\3\u00c1\5\u00c1\u0857\n\u00c1\3\u00c1\3\u00c1\5\u00c1\u085b\n\u00c1\5"+
		"\u00c1\u085d\n\u00c1\3\u00c2\3\u00c2\3\u00c2\5\u00c2\u0862\n\u00c2\3\u00c2"+
		"\3\u00c2\5\u00c2\u0866\n\u00c2\3\u00c2\3\u00c2\5\u00c2\u086a\n\u00c2\3"+
		"\u00c2\3\u00c2\5\u00c2\u086e\n\u00c2\3\u00c3\3\u00c3\5\u00c3\u0872\n\u00c3"+
		"\3\u00c3\3\u00c3\3\u00c3\7\u00c3\u0877\n\u00c3\f\u00c3\16\u00c3\u087a"+
		"\13\u00c3\3\u00c3\5\u00c3\u087d\n\u00c3\3\u00c3\3\u00c3\5\u00c3\u0881"+
		"\n\u00c3\3\u00c3\3\u00c3\5\u00c3\u0885\n\u00c3\3\u00c3\3\u00c3\3\u00c3"+
		"\3\u00c3\5\u00c3\u088b\n\u00c3\3\u00c3\3\u00c3\5\u00c3\u088f\n\u00c3\3"+
		"\u00c3\3\u00c3\5\u00c3\u0893\n\u00c3\3\u00c3\3\u00c3\5\u00c3\u0897\n\u00c3"+
		"\5\u00c3\u0899\n\u00c3\3\u00c4\7\u00c4\u089c\n\u00c4\f\u00c4\16\u00c4"+
		"\u089f\13\u00c4\3\u00c4\3\u00c4\3\u00c5\3\u00c5\3\u00c5\5\u00c5\u08a6"+
		"\n\u00c5\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c6"+
		"\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c6\5\u00c6\u08b6\n\u00c6"+
		"\3\u00c7\3\u00c7\3\u00c7\3\u00c8\3\u00c8\3\u00c8\3\u00c8\3\u00c8\3\u00c8"+
		"\3\u00c8\3\u00c8\3\u00c8\3\u00c8\5\u00c8\u08c5\n\u00c8\3\u00c9\3\u00c9"+
		"\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\5\u00c9"+
		"\u08d1\n\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\7\u00c9\u08d8\n"+
		"\u00c9\f\u00c9\16\u00c9\u08db\13\u00c9\3\u00ca\3\u00ca\3\u00ca\3\u00ca"+
		"\3\u00ca\3\u00ca\3\u00ca\3\u00ca\3\u00ca\3\u00ca\7\u00ca\u08e7\n\u00ca"+
		"\f\u00ca\16\u00ca\u08ea\13\u00ca\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb"+
		"\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\5\u00cb\u08f6\n\u00cb\3\u00cb"+
		"\3\u00cb\3\u00cb\3\u00cb\3\u00cb\7\u00cb\u08fd\n\u00cb\f\u00cb\16\u00cb"+
		"\u0900\13\u00cb\3\u00cc\3\u00cc\3\u00cc\5\u00cc\u0905\n\u00cc\3\u00cc"+
		"\3\u00cc\3\u00cc\3\u00cc\3\u00cc\5\u00cc\u090c\n\u00cc\3\u00cc\3\u00cc"+
		"\3\u00cc\5\u00cc\u0911\n\u00cc\3\u00cc\3\u00cc\3\u00cc\3\u00cc\3\u00cc"+
		"\5\u00cc\u0918\n\u00cc\3\u00cc\3\u00cc\3\u00cc\5\u00cc\u091d\n\u00cc\3"+
		"\u00cc\3\u00cc\3\u00cc\3\u00cc\3\u00cc\5\u00cc\u0924\n\u00cc\3\u00cc\3"+
		"\u00cc\3\u00cc\5\u00cc\u0929\n\u00cc\3\u00cc\3\u00cc\3\u00cc\3\u00cc\3"+
		"\u00cc\5\u00cc\u0930\n\u00cc\3\u00cc\3\u00cc\3\u00cc\5\u00cc\u0935\n\u00cc"+
		"\3\u00cc\3\u00cc\3\u00cc\3\u00cc\3\u00cc\3\u00cc\3\u00cc\5\u00cc\u093e"+
		"\n\u00cc\3\u00cc\3\u00cc\3\u00cc\5\u00cc\u0943\n\u00cc\3\u00cc\3\u00cc"+
		"\5\u00cc\u0947\n\u00cc\3\u00cd\3\u00cd\3\u00ce\3\u00ce\5\u00ce\u094d\n"+
		"\u00ce\3\u00ce\3\u00ce\3\u00ce\5\u00ce\u0952\n\u00ce\3\u00ce\3\u00ce\3"+
		"\u00cf\3\u00cf\3\u00cf\5\u00cf\u0959\n\u00cf\3\u00cf\3\u00cf\3\u00cf\3"+
		"\u00cf\3\u00cf\5\u00cf\u0960\n\u00cf\3\u00cf\3\u00cf\3\u00cf\5\u00cf\u0965"+
		"\n\u00cf\3\u00cf\3\u00cf\3\u00cf\3\u00cf\3\u00cf\5\u00cf\u096c\n\u00cf"+
		"\3\u00cf\3\u00cf\3\u00cf\5\u00cf\u0971\n\u00cf\3\u00cf\3\u00cf\3\u00cf"+
		"\3\u00cf\3\u00cf\5\u00cf\u0978\n\u00cf\3\u00cf\3\u00cf\3\u00cf\5\u00cf"+
		"\u097d\n\u00cf\3\u00cf\3\u00cf\3\u00cf\3\u00cf\3\u00cf\3\u00cf\5\u00cf"+
		"\u0985\n\u00cf\3\u00cf\3\u00cf\3\u00cf\5\u00cf\u098a\n\u00cf\3\u00cf\3"+
		"\u00cf\5\u00cf\u098e\n\u00cf\3\u00d0\3\u00d0\3\u00d0\7\u00d0\u0993\n\u00d0"+
		"\f\u00d0\16\u00d0\u0996\13\u00d0\3\u00d1\3\u00d1\3\u00d1\5\u00d1\u099b"+
		"\n\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d1\5\u00d1\u09a2\n\u00d1"+
		"\3\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d1\5\u00d1\u09a9\n\u00d1\3\u00d1"+
		"\3\u00d1\3\u00d1\3\u00d1\3\u00d1\5\u00d1\u09b0\n\u00d1\3\u00d1\3\u00d1"+
		"\3\u00d1\3\u00d1\3\u00d1\3\u00d1\5\u00d1\u09b8\n\u00d1\3\u00d1\3\u00d1"+
		"\3\u00d1\3\u00d1\3\u00d1\5\u00d1\u09bf\n\u00d1\3\u00d1\3\u00d1\3\u00d1"+
		"\3\u00d1\3\u00d1\3\u00d1\5\u00d1\u09c7\n\u00d1\3\u00d2\3\u00d2\5\u00d2"+
		"\u09cb\n\u00d2\3\u00d2\3\u00d2\3\u00d3\3\u00d3\3\u00d3\5\u00d3\u09d2\n"+
		"\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\5\u00d3\u09d9\n\u00d3\3"+
		"\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\5\u00d3\u09e0\n\u00d3\3\u00d3\3"+
		"\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\5\u00d3\u09e8\n\u00d3\3\u00d3\3"+
		"\u00d3\3\u00d3\3\u00d3\3\u00d3\5\u00d3\u09ef\n\u00d3\3\u00d3\3\u00d3\3"+
		"\u00d3\3\u00d3\3\u00d3\3\u00d3\5\u00d3\u09f7\n\u00d3\3\u00d4\3\u00d4\3"+
		"\u00d4\3\u00d4\5\u00d4\u09fd\n\u00d4\3\u00d4\3\u00d4\3\u00d4\3\u00d4\5"+
		"\u00d4\u0a03\n\u00d4\3\u00d4\3\u00d4\3\u00d4\3\u00d4\3\u00d4\3\u00d4\3"+
		"\u00d4\3\u00d4\3\u00d4\3\u00d4\5\u00d4\u0a0f\n\u00d4\3\u00d5\3\u00d5\7"+
		"\u00d5\u0a13\n\u00d5\f\u00d5\16\u00d5\u0a16\13\u00d5\3\u00d6\7\u00d6\u0a19"+
		"\n\u00d6\f\u00d6\16\u00d6\u0a1c\13\u00d6\3\u00d6\3\u00d6\3\u00d6\3\u00d6"+
		"\3\u00d7\3\u00d7\3\u00d8\3\u00d8\5\u00d8\u0a26\n\u00d8\3\u00d9\3\u00d9"+
		"\3\u00d9\3\u00d9\3\u00da\3\u00da\3\u00da\5\u00da\u0a2f\n\u00da\3\u00da"+
		"\3\u00da\3\u00da\3\u00da\3\u00da\5\u00da\u0a36\n\u00da\3\u00db\3\u00db"+
		"\3\u00db\7\u00db\u0a3b\n\u00db\f\u00db\16\u00db\u0a3e\13\u00db\3\u00dc"+
		"\3\u00dc\5\u00dc\u0a42\n\u00dc\3\u00dd\3\u00dd\5\u00dd\u0a46\n\u00dd\3"+
		"\u00de\3\u00de\3\u00de\3\u00de\3\u00df\3\u00df\3\u00df\5\u00df\u0a4f\n"+
		"\u00df\3\u00e0\3\u00e0\3\u00e1\3\u00e1\3\u00e1\3\u00e1\3\u00e1\3\u00e1"+
		"\3\u00e1\5\u00e1\u0a5a\n\u00e1\3\u00e2\3\u00e2\3\u00e2\3\u00e2\3\u00e2"+
		"\3\u00e2\7\u00e2\u0a62\n\u00e2\f\u00e2\16\u00e2\u0a65\13\u00e2\3\u00e3"+
		"\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e3\7\u00e3\u0a6d\n\u00e3\f\u00e3"+
		"\16\u00e3\u0a70\13\u00e3\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4"+
		"\7\u00e4\u0a78\n\u00e4\f\u00e4\16\u00e4\u0a7b\13\u00e4\3\u00e5\3\u00e5"+
		"\3\u00e5\3\u00e5\3\u00e5\3\u00e5\7\u00e5\u0a83\n\u00e5\f\u00e5\16\u00e5"+
		"\u0a86\13\u00e5\3\u00e6\3\u00e6\3\u00e6\3\u00e6\3\u00e6\3\u00e6\7\u00e6"+
		"\u0a8e\n\u00e6\f\u00e6\16\u00e6\u0a91\13\u00e6\3\u00e7\3\u00e7\3\u00e7"+
		"\3\u00e7\3\u00e7\3\u00e7\3\u00e7\3\u00e7\3\u00e7\3\u00e7\3\u00e7\7\u00e7"+
		"\u0a9e\n\u00e7\f\u00e7\16\u00e7\u0aa1\13\u00e7\3\u00e8\3\u00e8\3\u00e9"+
		"\3\u00e9\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea"+
		"\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea"+
		"\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\7\u00ea\u0abe\n\u00ea"+
		"\f\u00ea\16\u00ea\u0ac1\13\u00ea\3\u00eb\3\u00eb\3\u00ec\3\u00ec\3\u00ed"+
		"\3\u00ed\3\u00ee\3\u00ee\3\u00ef\3\u00ef\3\u00f0\3\u00f0\3\u00f0\3\u00f0"+
		"\3\u00f0\3\u00f0\3\u00f0\3\u00f0\3\u00f0\3\u00f0\3\u00f0\3\u00f0\3\u00f0"+
		"\3\u00f0\3\u00f0\7\u00f0\u0adc\n\u00f0\f\u00f0\16\u00f0\u0adf\13\u00f0"+
		"\3\u00f1\3\u00f1\3\u00f1\3\u00f2\3\u00f2\3\u00f2\3\u00f3\3\u00f3\3\u00f3"+
		"\3\u00f3\3\u00f4\3\u00f4\3\u00f4\3\u00f4\3\u00f4\3\u00f4\3\u00f4\3\u00f4"+
		"\3\u00f4\3\u00f4\3\u00f4\7\u00f4\u0af6\n\u00f4\f\u00f4\16\u00f4\u0af9"+
		"\13\u00f4\3\u00f5\3\u00f5\3\u00f6\3\u00f6\3\u00f7\3\u00f7\3\u00f7\3\u00f7"+
		"\3\u00f7\3\u00f7\3\u00f7\3\u00f7\3\u00f7\3\u00f7\3\u00f7\3\u00f7\3\u00f7"+
		"\3\u00f7\3\u00f7\7\u00f7\u0b0e\n\u00f7\f\u00f7\16\u00f7\u0b11\13\u00f7"+
		"\3\u00f8\3\u00f8\3\u00f9\3\u00f9\3\u00fa\3\u00fa\3\u00fb\3\u00fb\3\u00fb"+
		"\3\u00fb\3\u00fb\3\u00fb\3\u00fb\3\u00fb\3\u00fb\5\u00fb\u0b22\n\u00fb"+
		"\3\u00fc\3\u00fc\3\u00fd\3\u00fd\3\u00fe\3\u00fe\3\u00fe\3\u00ff\3\u00ff"+
		"\3\u00ff\3\u0100\3\u0100\3\u0100\3\u0100\3\u0100\3\u0100\3\u0100\3\u0100"+
		"\5\u0100\u0b36\n\u0100\3\u0101\3\u0101\3\u0102\3\u0102\3\u0103\3\u0103"+
		"\5\u0103\u0b3e\n\u0103\3\u0103\7\u0103\u0b41\n\u0103\f\u0103\16\u0103"+
		"\u0b44\13\u0103\3\u0104\3\u0104\5\u0104\u0b48\n\u0104\3\u0105\3\u0105"+
		"\3\u0105\3\u0106\3\u0106\3\u0107\3\u0107\3\u0107\3\u0108\3\u0108\3\u0109"+
		"\3\u0109\3\u0109\3\u0109\3\u0109\3\u0109\3\u0109\3\u0109\7\u0109\u0b5c"+
		"\n\u0109\f\u0109\16\u0109\u0b5f\13\u0109\3\u0109\3\u0109\3\u0109\3\u0109"+
		"\3\u0109\3\u0109\7\u0109\u0b67\n\u0109\f\u0109\16\u0109\u0b6a\13\u0109"+
		"\3\u0109\3\u0109\3\u0109\5\u0109\u0b6f\n\u0109\3\u0109\2\17<@F\u01c2\u01c4"+
		"\u01c6\u01c8\u01ca\u01cc\u01d2\u01de\u01e6\u01ec\u010a\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd"+
		"fhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092"+
		"\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa"+
		"\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2"+
		"\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da"+
		"\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2"+
		"\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a"+
		"\u010c\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122"+
		"\u0124\u0126\u0128\u012a\u012c\u012e\u0130\u0132\u0134\u0136\u0138\u013a"+
		"\u013c\u013e\u0140\u0142\u0144\u0146\u0148\u014a\u014c\u014e\u0150\u0152"+
		"\u0154\u0156\u0158\u015a\u015c\u015e\u0160\u0162\u0164\u0166\u0168\u016a"+
		"\u016c\u016e\u0170\u0172\u0174\u0176\u0178\u017a\u017c\u017e\u0180\u0182"+
		"\u0184\u0186\u0188\u018a\u018c\u018e\u0190\u0192\u0194\u0196\u0198\u019a"+
		"\u019c\u019e\u01a0\u01a2\u01a4\u01a6\u01a8\u01aa\u01ac\u01ae\u01b0\u01b2"+
		"\u01b4\u01b6\u01b8\u01ba\u01bc\u01be\u01c0\u01c2\u01c4\u01c6\u01c8\u01ca"+
		"\u01cc\u01ce\u01d0\u01d2\u01d4\u01d6\u01d8\u01da\u01dc\u01de\u01e0\u01e2"+
		"\u01e4\u01e6\u01e8\u01ea\u01ec\u01ee\u01f0\u01f2\u01f4\u01f6\u01f8\u01fa"+
		"\u01fc\u01fe\u0200\u0202\u0204\u0206\u0208\u020a\u020c\u020e\u0210\2\6"+
		"\3\2\65:\7\2\7\7\n\n\35\35\37\37\'\'\4\2\20\20\26\26\4\2DD]g\u0c3e\2\u0212"+
		"\3\2\2\2\4\u0222\3\2\2\2\6\u0226\3\2\2\2\b\u0228\3\2\2\2\n\u022a\3\2\2"+
		"\2\f\u022f\3\2\2\2\16\u0233\3\2\2\2\20\u023d\3\2\2\2\22\u0255\3\2\2\2"+
		"\24\u0257\3\2\2\2\26\u0265\3\2\2\2\30\u026c\3\2\2\2\32\u026e\3\2\2\2\34"+
		"\u0270\3\2\2\2\36\u0275\3\2\2\2 \u0283\3\2\2\2\"\u0285\3\2\2\2$\u028f"+
		"\3\2\2\2&\u0294\3\2\2\2(\u029a\3\2\2\2*\u02a1\3\2\2\2,\u02ad\3\2\2\2."+
		"\u02af\3\2\2\2\60\u02b2\3\2\2\2\62\u02b6\3\2\2\2\64\u02c0\3\2\2\2\66\u02c5"+
		"\3\2\2\28\u02cf\3\2\2\2:\u02d1\3\2\2\2<\u02d4\3\2\2\2>\u02e4\3\2\2\2@"+
		"\u02e6\3\2\2\2B\u02f6\3\2\2\2D\u02f8\3\2\2\2F\u02fa\3\2\2\2H\u0306\3\2"+
		"\2\2J\u0319\3\2\2\2L\u0320\3\2\2\2N\u0326\3\2\2\2P\u0328\3\2\2\2R\u032c"+
		"\3\2\2\2T\u0332\3\2\2\2V\u0339\3\2\2\2X\u0343\3\2\2\2Z\u0347\3\2\2\2\\"+
		"\u034c\3\2\2\2^\u0364\3\2\2\2`\u0366\3\2\2\2b\u036a\3\2\2\2d\u0372\3\2"+
		"\2\2f\u0375\3\2\2\2h\u0378\3\2\2\2j\u0380\3\2\2\2l\u038d\3\2\2\2n\u0394"+
		"\3\2\2\2p\u0399\3\2\2\2r\u03a8\3\2\2\2t\u03aa\3\2\2\2v\u03b2\3\2\2\2x"+
		"\u03b7\3\2\2\2z\u03bd\3\2\2\2|\u03c1\3\2\2\2~\u03c5\3\2\2\2\u0080\u03ca"+
		"\3\2\2\2\u0082\u03ce\3\2\2\2\u0084\u03d8\3\2\2\2\u0086\u03ea\3\2\2\2\u0088"+
		"\u03ec\3\2\2\2\u008a\u03f7\3\2\2\2\u008c\u03fb\3\2\2\2\u008e\u03fd\3\2"+
		"\2\2\u0090\u03ff\3\2\2\2\u0092\u0401\3\2\2\2\u0094\u040c\3\2\2\2\u0096"+
		"\u0411\3\2\2\2\u0098\u0421\3\2\2\2\u009a\u0434\3\2\2\2\u009c\u0438\3\2"+
		"\2\2\u009e\u043a\3\2\2\2\u00a0\u0449\3\2\2\2\u00a2\u045b\3\2\2\2\u00a4"+
		"\u0460\3\2\2\2\u00a6\u0468\3\2\2\2\u00a8\u047b\3\2\2\2\u00aa\u0480\3\2"+
		"\2\2\u00ac\u048a\3\2\2\2\u00ae\u048d\3\2\2\2\u00b0\u0497\3\2\2\2\u00b2"+
		"\u049b\3\2\2\2\u00b4\u049d\3\2\2\2\u00b6\u049f\3\2\2\2\u00b8\u04a5\3\2"+
		"\2\2\u00ba\u04b2\3\2\2\2\u00bc\u04b5\3\2\2\2\u00be\u04be\3\2\2\2\u00c0"+
		"\u04c0\3\2\2\2\u00c2\u04f8\3\2\2\2\u00c4\u04fd\3\2\2\2\u00c6\u0507\3\2"+
		"\2\2\u00c8\u0513\3\2\2\2\u00ca\u051e\3\2\2\2\u00cc\u052c\3\2\2\2\u00ce"+
		"\u052e\3\2\2\2\u00d0\u0537\3\2\2\2\u00d2\u053c\3\2\2\2\u00d4\u0550\3\2"+
		"\2\2\u00d6\u0552\3\2\2\2\u00d8\u0555\3\2\2\2\u00da\u0563\3\2\2\2\u00dc"+
		"\u0568\3\2\2\2\u00de\u0573\3\2\2\2\u00e0\u0578\3\2\2\2\u00e2\u0584\3\2"+
		"\2\2\u00e4\u0589\3\2\2\2\u00e6\u0591\3\2\2\2\u00e8\u059f\3\2\2\2\u00ea"+
		"\u05a4\3\2\2\2\u00ec\u05b6\3\2\2\2\u00ee\u05b8\3\2\2\2\u00f0\u05be\3\2"+
		"\2\2\u00f2\u05c0\3\2\2\2\u00f4\u05c8\3\2\2\2\u00f6\u05d0\3\2\2\2\u00f8"+
		"\u05d7\3\2\2\2\u00fa\u05d9\3\2\2\2\u00fc\u05e2\3\2\2\2\u00fe\u05ea\3\2"+
		"\2\2\u0100\u05ed\3\2\2\2\u0102\u05f3\3\2\2\2\u0104\u05fc\3\2\2\2\u0106"+
		"\u0604\3\2\2\2\u0108\u060b\3\2\2\2\u010a\u0612\3\2\2\2\u010c\u0614\3\2"+
		"\2\2\u010e\u061a\3\2\2\2\u0110\u0626\3\2\2\2\u0112\u062d\3\2\2\2\u0114"+
		"\u063b\3\2\2\2\u0116\u063d\3\2\2\2\u0118\u063f\3\2\2\2\u011a\u0643\3\2"+
		"\2\2\u011c\u0647\3\2\2\2\u011e\u0651\3\2\2\2\u0120\u0653\3\2\2\2\u0122"+
		"\u0659\3\2\2\2\u0124\u0661\3\2\2\2\u0126\u0673\3\2\2\2\u0128\u0675\3\2"+
		"\2\2\u012a\u067b\3\2\2\2\u012c\u068a\3\2\2\2\u012e\u068d\3\2\2\2\u0130"+
		"\u069e\3\2\2\2\u0132\u06a0\3\2\2\2\u0134\u06a2\3\2\2\2\u0136\u06a8\3\2"+
		"\2\2\u0138\u06ae\3\2\2\2\u013a\u06b8\3\2\2\2\u013c\u06bc\3\2\2\2\u013e"+
		"\u06be\3\2\2\2\u0140\u06ce\3\2\2\2\u0142\u06e0\3\2\2\2\u0144\u06e2\3\2"+
		"\2\2\u0146\u06e4\3\2\2\2\u0148\u06ec\3\2\2\2\u014a\u06fb\3\2\2\2\u014c"+
		"\u070a\3\2\2\2\u014e\u0710\3\2\2\2\u0150\u0716\3\2\2\2\u0152\u071c\3\2"+
		"\2\2\u0154\u0720\3\2\2\2\u0156\u0732\3\2\2\2\u0158\u0734\3\2\2\2\u015a"+
		"\u073b\3\2\2\2\u015c\u0744\3\2\2\2\u015e\u074a\3\2\2\2\u0160\u0752\3\2"+
		"\2\2\u0162\u0755\3\2\2\2\u0164\u075e\3\2\2\2\u0166\u0765\3\2\2\2\u0168"+
		"\u0770\3\2\2\2\u016a\u077a\3\2\2\2\u016c\u079e\3\2\2\2\u016e\u07a0\3\2"+
		"\2\2\u0170\u07a2\3\2\2\2\u0172\u07bf\3\2\2\2\u0174\u07c6\3\2\2\2\u0176"+
		"\u07c8\3\2\2\2\u0178\u07ce\3\2\2\2\u017a\u07f6\3\2\2\2\u017c\u07f8\3\2"+
		"\2\2\u017e\u081f\3\2\2\2\u0180\u085c\3\2\2\2\u0182\u085e\3\2\2\2\u0184"+
		"\u0898\3\2\2\2\u0186\u089d\3\2\2\2\u0188\u08a5\3\2\2\2\u018a\u08b5\3\2"+
		"\2\2\u018c\u08b7\3\2\2\2\u018e\u08c4\3\2\2\2\u0190\u08d0\3\2\2\2\u0192"+
		"\u08dc\3\2\2\2\u0194\u08f5\3\2\2\2\u0196\u0946\3\2\2\2\u0198\u0948\3\2"+
		"\2\2\u019a\u094a\3\2\2\2\u019c\u098d\3\2\2\2\u019e\u098f\3\2\2\2\u01a0"+
		"\u09c6\3\2\2\2\u01a2\u09c8\3\2\2\2\u01a4\u09f6\3\2\2\2\u01a6\u0a0e\3\2"+
		"\2\2\u01a8\u0a10\3\2\2\2\u01aa\u0a1a\3\2\2\2\u01ac\u0a21\3\2\2\2\u01ae"+
		"\u0a25\3\2\2\2\u01b0\u0a27\3\2\2\2\u01b2\u0a35\3\2\2\2\u01b4\u0a37\3\2"+
		"\2\2\u01b6\u0a41\3\2\2\2\u01b8\u0a45\3\2\2\2\u01ba\u0a47\3\2\2\2\u01bc"+
		"\u0a4e\3\2\2\2\u01be\u0a50\3\2\2\2\u01c0\u0a59\3\2\2\2\u01c2\u0a5b\3\2"+
		"\2\2\u01c4\u0a66\3\2\2\2\u01c6\u0a71\3\2\2\2\u01c8\u0a7c\3\2\2\2\u01ca"+
		"\u0a87\3\2\2\2\u01cc\u0a92\3\2\2\2\u01ce\u0aa2\3\2\2\2\u01d0\u0aa4\3\2"+
		"\2\2\u01d2\u0aa6\3\2\2\2\u01d4\u0ac2\3\2\2\2\u01d6\u0ac4\3\2\2\2\u01d8"+
		"\u0ac6\3\2\2\2\u01da\u0ac8\3\2\2\2\u01dc\u0aca\3\2\2\2\u01de\u0acc\3\2"+
		"\2\2\u01e0\u0ae0\3\2\2\2\u01e2\u0ae3\3\2\2\2\u01e4\u0ae6\3\2\2\2\u01e6"+
		"\u0aea\3\2\2\2\u01e8\u0afa\3\2\2\2\u01ea\u0afc\3\2\2\2\u01ec\u0afe\3\2"+
		"\2\2\u01ee\u0b12\3\2\2\2\u01f0\u0b14\3\2\2\2\u01f2\u0b16\3\2\2\2\u01f4"+
		"\u0b21\3\2\2\2\u01f6\u0b23\3\2\2\2\u01f8\u0b25\3\2\2\2\u01fa\u0b27\3\2"+
		"\2\2\u01fc\u0b2a\3\2\2\2\u01fe\u0b35\3\2\2\2\u0200\u0b37\3\2\2\2\u0202"+
		"\u0b39\3\2\2\2\u0204\u0b3d\3\2\2\2\u0206\u0b47\3\2\2\2\u0208\u0b49\3\2"+
		"\2\2\u020a\u0b4c\3\2\2\2\u020c\u0b4e\3\2\2\2\u020e\u0b51\3\2\2\2\u0210"+
		"\u0b6e\3\2\2\2\u0212\u0213\t\2\2\2\u0213\3\3\2\2\2\u0214\u0216\5\u00f0"+
		"y\2\u0215\u0214\3\2\2\2\u0216\u0219\3\2\2\2\u0217\u0215\3\2\2\2\u0217"+
		"\u0218\3\2\2\2\u0218\u021a\3\2\2\2\u0219\u0217\3\2\2\2\u021a\u0223\5\6"+
		"\4\2\u021b\u021d\5\u00f0y\2\u021c\u021b\3\2\2\2\u021d\u0220\3\2\2\2\u021e"+
		"\u021c\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0221\3\2\2\2\u0220\u021e\3\2"+
		"\2\2\u0221\u0223\7\5\2\2\u0222\u0217\3\2\2\2\u0222\u021e\3\2\2\2\u0223"+
		"\5\3\2\2\2\u0224\u0227\5\b\5\2\u0225\u0227\5\n\6\2\u0226\u0224\3\2\2\2"+
		"\u0226\u0225\3\2\2\2\u0227\7\3\2\2\2\u0228\u0229\t\3\2\2\u0229\t\3\2\2"+
		"\2\u022a\u022b\t\4\2\2\u022b\13\3\2\2\2\u022c\u0230\5\16\b\2\u022d\u0230"+
		"\5\36\20\2\u022e\u0230\5 \21\2\u022f\u022c\3\2\2\2\u022f\u022d\3\2\2\2"+
		"\u022f\u022e\3\2\2\2\u0230\r\3\2\2\2\u0231\u0234\5\26\f\2\u0232\u0234"+
		"\5\34\17\2\u0233\u0231\3\2\2\2\u0233\u0232\3\2\2\2\u0234\u0238\3\2\2\2"+
		"\u0235\u0237\5\20\t\2\u0236\u0235\3\2\2\2\u0237\u023a\3\2\2\2\u0238\u0236"+
		"\3\2\2\2\u0238\u0239\3\2\2\2\u0239\17\3\2\2\2\u023a\u0238\3\2\2\2\u023b"+
		"\u023e\5\24\13\2\u023c\u023e\5\32\16\2\u023d\u023b\3\2\2\2\u023d\u023c"+
		"\3\2\2\2\u023e\21\3\2\2\2\u023f\u0241\5\u00f0y\2\u0240\u023f\3\2\2\2\u0241"+
		"\u0244\3\2\2\2\u0242\u0240\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0245\3\2"+
		"\2\2\u0244\u0242\3\2\2\2\u0245\u0247\7h\2\2\u0246\u0248\5\60\31\2\u0247"+
		"\u0246\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u0256\3\2\2\2\u0249\u024a\5\16"+
		"\b\2\u024a\u024e\7C\2\2\u024b\u024d\5\u00f0y\2\u024c\u024b\3\2\2\2\u024d"+
		"\u0250\3\2\2\2\u024e\u024c\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0251\3\2"+
		"\2\2\u0250\u024e\3\2\2\2\u0251\u0253\7h\2\2\u0252\u0254\5\60\31\2\u0253"+
		"\u0252\3\2\2\2\u0253\u0254\3\2\2\2\u0254\u0256\3\2\2\2\u0255\u0242\3\2"+
		"\2\2\u0255\u0249\3\2\2\2\u0256\23\3\2\2\2\u0257\u025b\7C\2\2\u0258\u025a"+
		"\5\u00f0y\2\u0259\u0258\3\2\2\2\u025a\u025d\3\2\2\2\u025b\u0259\3\2\2"+
		"\2\u025b\u025c\3\2\2\2\u025c\u025e\3\2\2\2\u025d\u025b\3\2\2\2\u025e\u0260"+
		"\7h\2\2\u025f\u0261\5\60\31\2\u0260\u025f\3\2\2\2\u0260\u0261\3\2\2\2"+
		"\u0261\25\3\2\2\2\u0262\u0264\5\u00f0y\2\u0263\u0262\3\2\2\2\u0264\u0267"+
		"\3\2\2\2\u0265\u0263\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0268\3\2\2\2\u0267"+
		"\u0265\3\2\2\2\u0268\u026a\7h\2\2\u0269\u026b\5\60\31\2\u026a\u0269\3"+
		"\2\2\2\u026a\u026b\3\2\2\2\u026b\27\3\2\2\2\u026c\u026d\5\22\n\2\u026d"+
		"\31\3\2\2\2\u026e\u026f\5\24\13\2\u026f\33\3\2\2\2\u0270\u0271\5\26\f"+
		"\2\u0271\35\3\2\2\2\u0272\u0274\5\u00f0y\2\u0273\u0272\3\2\2\2\u0274\u0277"+
		"\3\2\2\2\u0275\u0273\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0278\3\2\2\2\u0277"+
		"\u0275\3\2\2\2\u0278\u0279\7h\2\2\u0279\37\3\2\2\2\u027a\u027b\5\4\3\2"+
		"\u027b\u027c\5\"\22\2\u027c\u0284\3\2\2\2\u027d\u027e\5\16\b\2\u027e\u027f"+
		"\5\"\22\2\u027f\u0284\3\2\2\2\u0280\u0281\5\36\20\2\u0281\u0282\5\"\22"+
		"\2\u0282\u0284\3\2\2\2\u0283\u027a\3\2\2\2\u0283\u027d\3\2\2\2\u0283\u0280"+
		"\3\2\2\2\u0284!\3\2\2\2\u0285\u0289\5$\23\2\u0286\u0288\5$\23\2\u0287"+
		"\u0286\3\2\2\2\u0288\u028b\3\2\2\2\u0289\u0287\3\2\2\2\u0289\u028a\3\2"+
		"\2\2\u028a#\3\2\2\2\u028b\u0289\3\2\2\2\u028c\u028e\5\u00f0y\2\u028d\u028c"+
		"\3\2\2\2\u028e\u0291\3\2\2\2\u028f\u028d\3\2\2\2\u028f\u0290\3\2\2\2\u0290"+
		"\u0292\3\2\2\2\u0291\u028f\3\2\2\2\u0292\u0293\5&\24\2\u0293%\3\2\2\2"+
		"\u0294\u0295\7?\2\2\u0295\u0296\7@\2\2\u0296\'\3\2\2\2\u0297\u0299\5*"+
		"\26\2\u0298\u0297\3\2\2\2\u0299\u029c\3\2\2\2\u029a\u0298\3\2\2\2\u029a"+
		"\u029b\3\2\2\2\u029b\u029d\3\2\2\2\u029c\u029a\3\2\2\2\u029d\u029f\7h"+
		"\2\2\u029e\u02a0\5,\27\2\u029f\u029e\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0"+
		")\3\2\2\2\u02a1\u02a2\5\u00f0y\2\u02a2+\3\2\2\2\u02a3\u02a4\7\23\2\2\u02a4"+
		"\u02ae\5\36\20\2\u02a5\u02a6\7\23\2\2\u02a6\u02aa\5\16\b\2\u02a7\u02a9"+
		"\5.\30\2\u02a8\u02a7\3\2\2\2\u02a9\u02ac\3\2\2\2\u02aa\u02a8\3\2\2\2\u02aa"+
		"\u02ab\3\2\2\2\u02ab\u02ae\3\2\2\2\u02ac\u02aa\3\2\2\2\u02ad\u02a3\3\2"+
		"\2\2\u02ad\u02a5\3\2\2\2\u02ae-\3\2\2\2\u02af\u02b0\7W\2\2\u02b0\u02b1"+
		"\5\30\r\2\u02b1/\3\2\2\2\u02b2\u02b3\7F\2\2\u02b3\u02b4\5\62\32\2\u02b4"+
		"\u02b5\7E\2\2\u02b5\61\3\2\2\2\u02b6\u02bb\5\64\33\2\u02b7\u02b8\7B\2"+
		"\2\u02b8\u02ba\5\64\33\2\u02b9\u02b7\3\2\2\2\u02ba\u02bd\3\2\2\2\u02bb"+
		"\u02b9\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\63\3\2\2\2\u02bd\u02bb\3\2\2"+
		"\2\u02be\u02c1\5\f\7\2\u02bf\u02c1\5\66\34\2\u02c0\u02be\3\2\2\2\u02c0"+
		"\u02bf\3\2\2\2\u02c1\65\3\2\2\2\u02c2\u02c4\5\u00f0y\2\u02c3\u02c2\3\2"+
		"\2\2\u02c4\u02c7\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c5\u02c6\3\2\2\2\u02c6"+
		"\u02c8\3\2\2\2\u02c7\u02c5\3\2\2\2\u02c8\u02ca\7I\2\2\u02c9\u02cb\58\35"+
		"\2\u02ca\u02c9\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\67\3\2\2\2\u02cc\u02d0"+
		"\5:\36\2\u02cd\u02ce\7*\2\2\u02ce\u02d0\5\f\7\2\u02cf\u02cc\3\2\2\2\u02cf"+
		"\u02cd\3\2\2\2\u02d09\3\2\2\2\u02d1\u02d2\7\23\2\2\u02d2\u02d3\5\f\7\2"+
		"\u02d3;\3\2\2\2\u02d4\u02d5\b\37\1\2\u02d5\u02d6\7h\2\2\u02d6\u02dc\3"+
		"\2\2\2\u02d7\u02d8\f\3\2\2\u02d8\u02d9\7C\2\2\u02d9\u02db\7h\2\2\u02da"+
		"\u02d7\3\2\2\2\u02db\u02de\3\2\2\2\u02dc\u02da\3\2\2\2\u02dc\u02dd\3\2"+
		"\2\2\u02dd=\3\2\2\2\u02de\u02dc\3\2\2\2\u02df\u02e5\7h\2\2\u02e0\u02e1"+
		"\5@!\2\u02e1\u02e2\7C\2\2\u02e2\u02e3\7h\2\2\u02e3\u02e5\3\2\2\2\u02e4"+
		"\u02df\3\2\2\2\u02e4\u02e0\3\2\2\2\u02e5?\3\2\2\2\u02e6\u02e7\b!\1\2\u02e7"+
		"\u02e8\7h\2\2\u02e8\u02ee\3\2\2\2\u02e9\u02ea\f\3\2\2\u02ea\u02eb\7C\2"+
		"\2\u02eb\u02ed\7h\2\2\u02ec\u02e9\3\2\2\2\u02ed\u02f0\3\2\2\2\u02ee\u02ec"+
		"\3\2\2\2\u02ee\u02ef\3\2\2\2\u02efA\3\2\2\2\u02f0\u02ee\3\2\2\2\u02f1"+
		"\u02f7\7h\2\2\u02f2\u02f3\5F$\2\u02f3\u02f4\7C\2\2\u02f4\u02f5\7h\2\2"+
		"\u02f5\u02f7\3\2\2\2\u02f6\u02f1\3\2\2\2\u02f6\u02f2\3\2\2\2\u02f7C\3"+
		"\2\2\2\u02f8\u02f9\7h\2\2\u02f9E\3\2\2\2\u02fa\u02fb\b$\1\2\u02fb\u02fc"+
		"\7h\2\2\u02fc\u0302\3\2\2\2\u02fd\u02fe\f\3\2\2\u02fe\u02ff\7C\2\2\u02ff"+
		"\u0301\7h\2\2\u0300\u02fd\3\2\2\2\u0301\u0304\3\2\2\2\u0302\u0300\3\2"+
		"\2\2\u0302\u0303\3\2\2\2\u0303G\3\2\2\2\u0304\u0302\3\2\2\2\u0305\u0307"+
		"\5J&\2\u0306\u0305\3\2\2\2\u0306\u0307\3\2\2\2\u0307\u030b\3\2\2\2\u0308"+
		"\u030a\5N(\2\u0309\u0308\3\2\2\2\u030a\u030d\3\2\2\2\u030b\u0309\3\2\2"+
		"\2\u030b\u030c\3\2\2\2\u030c\u0311\3\2\2\2\u030d\u030b\3\2\2\2\u030e\u0310"+
		"\5X-\2\u030f\u030e\3\2\2\2\u0310\u0313\3\2\2\2\u0311\u030f\3\2\2\2\u0311"+
		"\u0312\3\2\2\2\u0312\u0314\3\2\2\2\u0313\u0311\3\2\2\2\u0314\u0315\7\2"+
		"\2\3\u0315I\3\2\2\2\u0316\u0318\5L\'\2\u0317\u0316\3\2\2\2\u0318\u031b"+
		"\3\2\2\2\u0319\u0317\3\2\2\2\u0319\u031a\3\2\2\2\u031a\u031c\3\2\2\2\u031b"+
		"\u0319\3\2\2\2\u031c\u031d\7\"\2\2\u031d\u031e\5<\37\2\u031e\u031f\7A"+
		"\2\2\u031fK\3\2\2\2\u0320\u0321\5\u00f0y\2\u0321M\3\2\2\2\u0322\u0327"+
		"\5P)\2\u0323\u0327\5R*\2\u0324\u0327\5T+\2\u0325\u0327\5V,\2\u0326\u0322"+
		"\3\2\2\2\u0326\u0323\3\2\2\2\u0326\u0324\3\2\2\2\u0326\u0325\3\2\2\2\u0327"+
		"O\3\2\2\2\u0328\u0329\7\33\2\2\u0329\u032a\5> \2\u032a\u032b\7A\2\2\u032b"+
		"Q\3\2\2\2\u032c\u032d\7\33\2\2\u032d\u032e\5@!\2\u032e\u032f\7C\2\2\u032f"+
		"\u0330\7U\2\2\u0330\u0331\7A\2\2\u0331S\3\2\2\2\u0332\u0333\7\33\2\2\u0333"+
		"\u0334\7(\2\2\u0334\u0335\5> \2\u0335\u0336\7C\2\2\u0336\u0337\7h\2\2"+
		"\u0337\u0338\7A\2\2\u0338U\3\2\2\2\u0339\u033a\7\33\2\2\u033a\u033b\7"+
		"(\2\2\u033b\u033c\5> \2\u033c\u033d\7C\2\2\u033d\u033e\7U\2\2\u033e\u033f"+
		"\7A\2\2\u033fW\3\2\2\2\u0340\u0344\5Z.\2\u0341\u0344\5\u00d0i\2\u0342"+
		"\u0344\7A\2\2\u0343\u0340\3\2\2\2\u0343\u0341\3\2\2\2\u0343\u0342\3\2"+
		"\2\2\u0344Y\3\2\2\2\u0345\u0348\5\\/\2\u0346\u0348\5\u00c4c\2\u0347\u0345"+
		"\3\2\2\2\u0347\u0346\3\2\2\2\u0348[\3\2\2\2\u0349\u034b\5^\60\2\u034a"+
		"\u0349\3\2\2\2\u034b\u034e\3\2\2\2\u034c\u034a\3\2\2\2\u034c\u034d\3\2"+
		"\2\2\u034d\u034f\3\2\2\2\u034e\u034c\3\2\2\2\u034f\u0350\7\13\2\2\u0350"+
		"\u0352\7h\2\2\u0351\u0353\5`\61\2\u0352\u0351\3\2\2\2\u0352\u0353\3\2"+
		"\2\2\u0353\u0355\3\2\2\2\u0354\u0356\5d\63\2\u0355\u0354\3\2\2\2\u0355"+
		"\u0356\3\2\2\2\u0356\u0358\3\2\2\2\u0357\u0359\5f\64\2\u0358\u0357\3\2"+
		"\2\2\u0358\u0359\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u035b\5j\66\2\u035b"+
		"]\3\2\2\2\u035c\u0365\5\u00f0y\2\u035d\u0365\7%\2\2\u035e\u0365\7$\2\2"+
		"\u035f\u0365\7#\2\2\u0360\u0365\7\3\2\2\u0361\u0365\7(\2\2\u0362\u0365"+
		"\7\24\2\2\u0363\u0365\7)\2\2\u0364\u035c\3\2\2\2\u0364\u035d\3\2\2\2\u0364"+
		"\u035e\3\2\2\2\u0364\u035f\3\2\2\2\u0364\u0360\3\2\2\2\u0364\u0361\3\2"+
		"\2\2\u0364\u0362\3\2\2\2\u0364\u0363\3\2\2\2\u0365_\3\2\2\2\u0366\u0367"+
		"\7F\2\2\u0367\u0368\5b\62\2\u0368\u0369\7E\2\2\u0369a\3\2\2\2\u036a\u036f"+
		"\5(\25\2\u036b\u036c\7B\2\2\u036c\u036e\5(\25\2\u036d\u036b\3\2\2\2\u036e"+
		"\u0371\3\2\2\2\u036f\u036d\3\2\2\2\u036f\u0370\3\2\2\2\u0370c\3\2\2\2"+
		"\u0371\u036f\3\2\2\2\u0372\u0373\7\23\2\2\u0373\u0374\5\22\n\2\u0374e"+
		"\3\2\2\2\u0375\u0376\7\32\2\2\u0376\u0377\5h\65\2\u0377g\3\2\2\2\u0378"+
		"\u037d\5\30\r\2\u0379\u037a\7B\2\2\u037a\u037c\5\30\r\2\u037b\u0379\3"+
		"\2\2\2\u037c\u037f\3\2\2\2\u037d\u037b\3\2\2\2\u037d\u037e\3\2\2\2\u037e"+
		"i\3\2\2\2\u037f\u037d\3\2\2\2\u0380\u0384\7=\2\2\u0381\u0383\5l\67\2\u0382"+
		"\u0381\3\2\2\2\u0383\u0386\3\2\2\2\u0384\u0382\3\2\2\2\u0384\u0385\3\2"+
		"\2\2\u0385\u0387\3\2\2\2\u0386\u0384\3\2\2\2\u0387\u0388\7>\2\2\u0388"+
		"k\3\2\2\2\u0389\u038e\5n8\2\u038a\u038e\5\u00b4[\2\u038b\u038e\5\u00b6"+
		"\\\2\u038c\u038e\5\u00b8]\2\u038d\u0389\3\2\2\2\u038d\u038a\3\2\2\2\u038d"+
		"\u038b\3\2\2\2\u038d\u038c\3\2\2\2\u038em\3\2\2\2\u038f\u0395\5p9\2\u0390"+
		"\u0395\5\u0096L\2\u0391\u0395\5Z.\2\u0392\u0395\5\u00d0i\2\u0393\u0395"+
		"\7A\2\2\u0394\u038f\3\2\2\2\u0394\u0390\3\2\2\2\u0394\u0391\3\2\2\2\u0394"+
		"\u0392\3\2\2\2\u0394\u0393\3\2\2\2\u0395o\3\2\2\2\u0396\u0398\5r:\2\u0397"+
		"\u0396\3\2\2\2\u0398\u039b\3\2\2\2\u0399\u0397\3\2\2\2\u0399\u039a\3\2"+
		"\2\2\u039a\u039c\3\2\2\2\u039b\u0399\3\2\2\2\u039c\u039d\5|?\2\u039d\u039e"+
		"\5t;\2\u039e\u039f\7A\2\2\u039fq\3\2\2\2\u03a0\u03a9\5\u00f0y\2\u03a1"+
		"\u03a9\7%\2\2\u03a2\u03a9\7$\2\2\u03a3\u03a9\7#\2\2\u03a4\u03a9\7(\2\2"+
		"\u03a5\u03a9\7\24\2\2\u03a6\u03a9\7\60\2\2\u03a7\u03a9\7\63\2\2\u03a8"+
		"\u03a0\3\2\2\2\u03a8\u03a1\3\2\2\2\u03a8\u03a2\3\2\2\2\u03a8\u03a3\3\2"+
		"\2\2\u03a8\u03a4\3\2\2\2\u03a8\u03a5\3\2\2\2\u03a8\u03a6\3\2\2\2\u03a8"+
		"\u03a7\3\2\2\2\u03a9s\3\2\2\2\u03aa\u03af\5v<\2\u03ab\u03ac\7B\2\2\u03ac"+
		"\u03ae\5v<\2\u03ad\u03ab\3\2\2\2\u03ae\u03b1\3\2\2\2\u03af\u03ad\3\2\2"+
		"\2\u03af\u03b0\3\2\2\2\u03b0u\3\2\2\2\u03b1\u03af\3\2\2\2\u03b2\u03b5"+
		"\5x=\2\u03b3\u03b4\7D\2\2\u03b4\u03b6\5z>\2\u03b5\u03b3\3\2\2\2\u03b5"+
		"\u03b6\3\2\2\2\u03b6w\3\2\2\2\u03b7\u03b9\7h\2\2\u03b8\u03ba\5\"\22\2"+
		"\u03b9\u03b8\3\2\2\2\u03b9\u03ba\3\2\2\2\u03bay\3\2\2\2\u03bb\u03be\5"+
		"\u01ae\u00d8\2\u03bc\u03be\5\u0102\u0082\2\u03bd\u03bb\3\2\2\2\u03bd\u03bc"+
		"\3\2\2\2\u03be{\3\2\2\2\u03bf\u03c2\5~@\2\u03c0\u03c2\5\u0080A\2\u03c1"+
		"\u03bf\3\2\2\2\u03c1\u03c0\3\2\2\2\u03c2}\3\2\2\2\u03c3\u03c6\5\6\4\2"+
		"\u03c4\u03c6\7\5\2\2\u03c5\u03c3\3\2\2\2\u03c5\u03c4\3\2\2\2\u03c6\177"+
		"\3\2\2\2\u03c7\u03cb\5\u0082B\2\u03c8\u03cb\5\u0092J\2\u03c9\u03cb\5\u0094"+
		"K\2\u03ca\u03c7\3\2\2\2\u03ca\u03c8\3\2\2\2\u03ca\u03c9\3\2\2\2\u03cb"+
		"\u0081\3\2\2\2\u03cc\u03cf\5\u008aF\2\u03cd\u03cf\5\u0090I\2\u03ce\u03cc"+
		"\3\2\2\2\u03ce\u03cd\3\2\2\2\u03cf\u03d3\3\2\2\2\u03d0\u03d2\5\u0084C"+
		"\2\u03d1\u03d0\3\2\2\2\u03d2\u03d5\3\2\2\2\u03d3\u03d1\3\2\2\2\u03d3\u03d4"+
		"\3\2\2\2\u03d4\u0083\3\2\2\2\u03d5\u03d3\3\2\2\2\u03d6\u03d9\5\u0088E"+
		"\2\u03d7\u03d9\5\u008eH\2\u03d8\u03d6\3\2\2\2\u03d8\u03d7\3\2\2\2\u03d9"+
		"\u0085\3\2\2\2\u03da\u03dc\7h\2\2\u03db\u03dd\5\60\31\2\u03dc\u03db\3"+
		"\2\2\2\u03dc\u03dd\3\2\2\2\u03dd\u03eb\3\2\2\2\u03de\u03df\5\u0082B\2"+
		"\u03df\u03e3\7C\2\2\u03e0\u03e2\5\u00f0y\2\u03e1\u03e0\3\2\2\2\u03e2\u03e5"+
		"\3\2\2\2\u03e3\u03e1\3\2\2\2\u03e3\u03e4\3\2\2\2\u03e4\u03e6\3\2\2\2\u03e5"+
		"\u03e3\3\2\2\2\u03e6\u03e8\7h\2\2\u03e7\u03e9\5\60\31\2\u03e8\u03e7\3"+
		"\2\2\2\u03e8\u03e9\3\2\2\2\u03e9\u03eb\3\2\2\2\u03ea\u03da\3\2\2\2\u03ea"+
		"\u03de\3\2\2\2\u03eb\u0087\3\2\2\2\u03ec\u03f0\7C\2\2\u03ed\u03ef\5\u00f0"+
		"y\2\u03ee\u03ed\3\2\2\2\u03ef\u03f2\3\2\2\2\u03f0\u03ee\3\2\2\2\u03f0"+
		"\u03f1\3\2\2\2\u03f1\u03f3\3\2\2\2\u03f2\u03f0\3\2\2\2\u03f3\u03f5\7h"+
		"\2\2\u03f4\u03f6\5\60\31\2\u03f5\u03f4\3\2\2\2\u03f5\u03f6\3\2\2\2\u03f6"+
		"\u0089\3\2\2\2\u03f7\u03f9\7h\2\2\u03f8\u03fa\5\60\31\2\u03f9\u03f8\3"+
		"\2\2\2\u03f9\u03fa\3\2\2\2\u03fa\u008b\3\2\2\2\u03fb\u03fc\5\u0086D\2"+
		"\u03fc\u008d\3\2\2\2\u03fd\u03fe\5\u0088E\2\u03fe\u008f\3\2\2\2\u03ff"+
		"\u0400\5\u008aF\2\u0400\u0091\3\2\2\2\u0401\u0402\7h\2\2\u0402\u0093\3"+
		"\2\2\2\u0403\u0404\5~@\2\u0404\u0405\5\"\22\2\u0405\u040d\3\2\2\2\u0406"+
		"\u0407\5\u0082B\2\u0407\u0408\5\"\22\2\u0408\u040d\3\2\2\2\u0409\u040a"+
		"\5\u0092J\2\u040a\u040b\5\"\22\2\u040b\u040d\3\2\2\2\u040c\u0403\3\2\2"+
		"\2\u040c\u0406\3\2\2\2\u040c\u0409\3\2\2\2\u040d\u0095\3\2\2\2\u040e\u0410"+
		"\5\u0098M\2\u040f\u040e\3\2\2\2\u0410\u0413\3\2\2\2\u0411\u040f\3\2\2"+
		"\2\u0411\u0412\3\2\2\2\u0412\u0414\3\2\2\2\u0413\u0411\3\2\2\2\u0414\u0415"+
		"\5\u009aN\2\u0415\u0416\5\u00b2Z\2\u0416\u0097\3\2\2\2\u0417\u0422\5\u00f0"+
		"y\2\u0418\u0422\7%\2\2\u0419\u0422\7$\2\2\u041a\u0422\7#\2\2\u041b\u0422"+
		"\7\3\2\2\u041c\u0422\7(\2\2\u041d\u0422\7\24\2\2\u041e\u0422\7,\2\2\u041f"+
		"\u0422\7 \2\2\u0420\u0422\7)\2\2\u0421\u0417\3\2\2\2\u0421\u0418\3\2\2"+
		"\2\u0421\u0419\3\2\2\2\u0421\u041a\3\2\2\2\u0421\u041b\3\2\2\2\u0421\u041c"+
		"\3\2\2\2\u0421\u041d\3\2\2\2\u0421\u041e\3\2\2\2\u0421\u041f\3\2\2\2\u0421"+
		"\u0420\3\2\2\2\u0422\u0099\3\2\2\2\u0423\u0424\5\u009cO\2\u0424\u0426"+
		"\5\u009eP\2\u0425\u0427\5\u00acW\2\u0426\u0425\3\2\2\2\u0426\u0427\3\2"+
		"\2\2\u0427\u0435\3\2\2\2\u0428\u042c\5`\61\2\u0429\u042b\5\u00f0y\2\u042a"+
		"\u0429\3\2\2\2\u042b\u042e\3\2\2\2\u042c\u042a\3\2\2\2\u042c\u042d\3\2"+
		"\2\2\u042d\u042f\3\2\2\2\u042e\u042c\3\2\2\2\u042f\u0430\5\u009cO\2\u0430"+
		"\u0432\5\u009eP\2\u0431\u0433\5\u00acW\2\u0432\u0431\3\2\2\2\u0432\u0433"+
		"\3\2\2\2\u0433\u0435\3\2\2\2\u0434\u0423\3\2\2\2\u0434\u0428\3\2\2\2\u0435"+
		"\u009b\3\2\2\2\u0436\u0439\5|?\2\u0437\u0439\7\62\2\2\u0438\u0436\3\2"+
		"\2\2\u0438\u0437\3\2\2\2\u0439\u009d\3\2\2\2\u043a\u043b\7h\2\2\u043b"+
		"\u043d\7;\2\2\u043c\u043e\5\u00a0Q\2\u043d\u043c\3\2\2\2\u043d\u043e\3"+
		"\2\2\2\u043e\u043f\3\2\2\2\u043f\u0441\7<\2\2\u0440\u0442\5\"\22\2\u0441"+
		"\u0440\3\2\2\2\u0441\u0442\3\2\2\2\u0442\u009f\3\2\2\2\u0443\u044a\5\u00aa"+
		"V\2\u0444\u0445\5\u00a2R\2\u0445\u0446\7B\2\2\u0446\u0447\5\u00a8U\2\u0447"+
		"\u044a\3\2\2\2\u0448\u044a\5\u00a8U\2\u0449\u0443\3\2\2\2\u0449\u0444"+
		"\3\2\2\2\u0449\u0448\3\2\2\2\u044a\u00a1\3\2\2\2\u044b\u0450\5\u00a4S"+
		"\2\u044c\u044d\7B\2\2\u044d\u044f\5\u00a4S\2\u044e\u044c\3\2\2\2\u044f"+
		"\u0452\3\2\2\2\u0450\u044e\3\2\2\2\u0450\u0451\3\2\2\2\u0451\u045c\3\2"+
		"\2\2\u0452\u0450\3\2\2\2\u0453\u0458\5\u00aaV\2\u0454\u0455\7B\2\2\u0455"+
		"\u0457\5\u00a4S\2\u0456\u0454\3\2\2\2\u0457\u045a\3\2\2\2\u0458\u0456"+
		"\3\2\2\2\u0458\u0459\3\2\2\2\u0459\u045c\3\2\2\2\u045a\u0458\3\2\2\2\u045b"+
		"\u044b\3\2\2\2\u045b\u0453\3\2\2\2\u045c\u00a3\3\2\2\2\u045d\u045f\5\u00a6"+
		"T\2\u045e\u045d\3\2\2\2\u045f\u0462\3\2\2\2\u0460\u045e\3\2\2\2\u0460"+
		"\u0461\3\2\2\2\u0461\u0463\3\2\2\2\u0462\u0460\3\2\2\2\u0463\u0464\5|"+
		"?\2\u0464\u0465\5x=\2\u0465\u00a5\3\2\2\2\u0466\u0469\5\u00f0y\2\u0467"+
		"\u0469\7\24\2\2\u0468\u0466\3\2\2\2\u0468\u0467\3\2\2\2\u0469\u00a7\3"+
		"\2\2\2\u046a\u046c\5\u00a6T\2\u046b\u046a\3\2\2\2\u046c\u046f\3\2\2\2"+
		"\u046d\u046b\3\2\2\2\u046d\u046e\3\2\2\2\u046e\u0470\3\2\2\2\u046f\u046d"+
		"\3\2\2\2\u0470\u0474\5|?\2\u0471\u0473\5\u00f0y\2\u0472\u0471\3\2\2\2"+
		"\u0473\u0476\3\2\2\2\u0474\u0472\3\2\2\2\u0474\u0475\3\2\2\2\u0475\u0477"+
		"\3\2\2\2\u0476\u0474\3\2\2\2\u0477\u0478\7j\2\2\u0478\u0479\5x=\2\u0479"+
		"\u047c\3\2\2\2\u047a\u047c\5\u00a4S\2\u047b\u046d\3\2\2\2\u047b\u047a"+
		"\3\2\2\2\u047c\u00a9\3\2\2\2\u047d\u047f\5\u00f0y\2\u047e\u047d\3\2\2"+
		"\2\u047f\u0482\3\2\2\2\u0480\u047e\3\2\2\2\u0480\u0481\3\2\2\2\u0481\u0483"+
		"\3\2\2\2\u0482\u0480\3\2\2\2\u0483\u0486\5|?\2\u0484\u0485\7h\2\2\u0485"+
		"\u0487\7C\2\2\u0486\u0484\3\2\2\2\u0486\u0487\3\2\2\2\u0487\u0488\3\2"+
		"\2\2\u0488\u0489\7-\2\2\u0489\u00ab\3\2\2\2\u048a\u048b\7/\2\2\u048b\u048c"+
		"\5\u00aeX\2\u048c\u00ad\3\2\2\2\u048d\u0492\5\u00b0Y\2\u048e\u048f\7B"+
		"\2\2\u048f\u0491\5\u00b0Y\2\u0490\u048e\3\2\2\2\u0491\u0494\3\2\2\2\u0492"+
		"\u0490\3\2\2\2\u0492\u0493\3\2\2\2\u0493\u00af\3\2\2\2\u0494\u0492\3\2"+
		"\2\2\u0495\u0498\5\22\n\2\u0496\u0498\5\36\20\2\u0497\u0495\3\2\2\2\u0497"+
		"\u0496\3\2\2\2\u0498\u00b1\3\2\2\2\u0499\u049c\5\u0106\u0084\2\u049a\u049c"+
		"\7A\2\2\u049b\u0499\3\2\2\2\u049b\u049a\3\2\2\2\u049c\u00b3\3\2\2\2\u049d"+
		"\u049e\5\u0106\u0084\2\u049e\u00b5\3\2\2\2\u049f\u04a0\7(\2\2\u04a0\u04a1"+
		"\5\u0106\u0084\2\u04a1\u00b7\3\2\2\2\u04a2\u04a4\5\u00ba^\2\u04a3\u04a2"+
		"\3\2\2\2\u04a4\u04a7\3\2\2\2\u04a5\u04a3\3\2\2\2\u04a5\u04a6\3\2\2\2\u04a6"+
		"\u04a8\3\2\2\2\u04a7\u04a5\3\2\2\2\u04a8\u04aa\5\u00bc_\2\u04a9\u04ab"+
		"\5\u00acW\2\u04aa\u04a9\3\2\2\2\u04aa\u04ab\3\2\2\2\u04ab\u04ac\3\2\2"+
		"\2\u04ac\u04ad\5\u00c0a\2\u04ad\u00b9\3\2\2\2\u04ae\u04b3\5\u00f0y\2\u04af"+
		"\u04b3\7%\2\2\u04b0\u04b3\7$\2\2\u04b1\u04b3\7#\2\2\u04b2\u04ae\3\2\2"+
		"\2\u04b2\u04af\3\2\2\2\u04b2\u04b0\3\2\2\2\u04b2\u04b1\3\2\2\2\u04b3\u00bb"+
		"\3\2\2\2\u04b4\u04b6\5`\61\2\u04b5\u04b4\3\2\2\2\u04b5\u04b6\3\2\2\2\u04b6"+
		"\u04b7\3\2\2\2\u04b7\u04b8\5\u00be`\2\u04b8\u04ba\7;\2\2\u04b9\u04bb\5"+
		"\u00a0Q\2\u04ba\u04b9\3\2\2\2\u04ba\u04bb\3\2\2\2\u04bb\u04bc\3\2\2\2"+
		"\u04bc\u04bd\7<\2\2\u04bd\u00bd\3\2\2\2\u04be\u04bf\7h\2\2\u04bf\u00bf"+
		"\3\2\2\2\u04c0\u04c2\7=\2\2\u04c1\u04c3\5\u00c2b\2\u04c2\u04c1\3\2\2\2"+
		"\u04c2\u04c3\3\2\2\2\u04c3\u04c5\3\2\2\2\u04c4\u04c6\5\u0108\u0085\2\u04c5"+
		"\u04c4\3\2\2\2\u04c5\u04c6\3\2\2\2\u04c6\u04c7\3\2\2\2\u04c7\u04c8\7>"+
		"\2\2\u04c8\u00c1\3\2\2\2\u04c9\u04cb\5\60\31\2\u04ca\u04c9\3\2\2\2\u04ca"+
		"\u04cb\3\2\2\2\u04cb\u04cc\3\2\2\2\u04cc\u04cd\7-\2\2\u04cd\u04cf\7;\2"+
		"\2\u04ce\u04d0\5\u019e\u00d0\2\u04cf\u04ce\3\2\2\2\u04cf\u04d0\3\2\2\2"+
		"\u04d0\u04d1\3\2\2\2\u04d1\u04d2\7<\2\2\u04d2\u04f9\7A\2\2\u04d3\u04d5"+
		"\5\60\31\2\u04d4\u04d3\3\2\2\2\u04d4\u04d5\3\2\2\2\u04d5\u04d6\3\2\2\2"+
		"\u04d6\u04d7\5\u0198\u00cd\2\u04d7\u04d9\7;\2\2\u04d8\u04da\5\u019e\u00d0"+
		"\2\u04d9\u04d8\3\2\2\2\u04d9\u04da\3\2\2\2\u04da\u04db\3\2\2\2\u04db\u04dc"+
		"\7<\2\2\u04dc\u04dd\7A\2\2\u04dd\u04f9\3\2\2\2\u04de\u04df\5B\"\2\u04df"+
		"\u04e1\7C\2\2\u04e0\u04e2\5\60\31\2\u04e1\u04e0\3\2\2\2\u04e1\u04e2\3"+
		"\2\2\2\u04e2\u04e3\3\2\2\2\u04e3\u04e4\5\u0198\u00cd\2\u04e4\u04e6\7;"+
		"\2\2\u04e5\u04e7\5\u019e\u00d0\2\u04e6\u04e5\3\2\2\2\u04e6\u04e7\3\2\2"+
		"\2\u04e7\u04e8\3\2\2\2\u04e8\u04e9\7<\2\2\u04e9\u04ea\7A\2\2\u04ea\u04f9"+
		"\3\2\2\2\u04eb\u04ec\5\u016a\u00b6\2\u04ec\u04ee\7C\2\2\u04ed\u04ef\5"+
		"\60\31\2\u04ee\u04ed\3\2\2\2\u04ee\u04ef\3\2\2\2\u04ef\u04f0\3\2\2\2\u04f0"+
		"\u04f1\5\u0198\u00cd\2\u04f1\u04f3\7;\2\2\u04f2\u04f4\5\u019e\u00d0\2"+
		"\u04f3\u04f2\3\2\2\2\u04f3\u04f4\3\2\2\2\u04f4\u04f5\3\2\2\2\u04f5\u04f6"+
		"\7<\2\2\u04f6\u04f7\7A\2\2\u04f7\u04f9\3\2\2\2\u04f8\u04ca\3\2\2\2\u04f8"+
		"\u04d4\3\2\2\2\u04f8\u04de\3\2\2\2\u04f8\u04eb\3\2\2\2\u04f9\u00c3\3\2"+
		"\2\2\u04fa\u04fc\5^\60\2\u04fb\u04fa\3\2\2\2\u04fc\u04ff\3\2\2\2\u04fd"+
		"\u04fb\3\2\2\2\u04fd\u04fe\3\2\2\2\u04fe\u0500\3\2\2\2\u04ff\u04fd\3\2"+
		"\2\2\u0500\u0501\7\22\2\2\u0501\u0503\7h\2\2\u0502\u0504\5f\64\2\u0503"+
		"\u0502\3\2\2\2\u0503\u0504\3\2\2\2\u0504\u0505\3\2\2\2\u0505\u0506\5\u00c6"+
		"d\2\u0506\u00c5\3\2\2\2\u0507\u0509\7=\2\2\u0508\u050a\5\u00c8e\2\u0509"+
		"\u0508\3\2\2\2\u0509\u050a\3\2\2\2\u050a\u050c\3\2\2\2\u050b\u050d\7B"+
		"\2\2\u050c\u050b\3\2\2\2\u050c\u050d\3\2\2\2\u050d\u050f\3\2\2\2\u050e"+
		"\u0510\5\u00ceh\2\u050f\u050e\3\2\2\2\u050f\u0510\3\2\2\2\u0510\u0511"+
		"\3\2\2\2\u0511\u0512\7>\2\2\u0512\u00c7\3\2\2\2\u0513\u0518\5\u00caf\2"+
		"\u0514\u0515\7B\2\2\u0515\u0517\5\u00caf\2\u0516\u0514\3\2\2\2\u0517\u051a"+
		"\3\2\2\2\u0518\u0516\3\2\2\2\u0518\u0519\3\2\2\2\u0519\u00c9\3\2\2\2\u051a"+
		"\u0518\3\2\2\2\u051b\u051d\5\u00ccg\2\u051c\u051b\3\2\2\2\u051d\u0520"+
		"\3\2\2\2\u051e\u051c\3\2\2\2\u051e\u051f\3\2\2\2\u051f\u0521\3\2\2\2\u0520"+
		"\u051e\3\2\2\2\u0521\u0527\7h\2\2\u0522\u0524\7;\2\2\u0523\u0525\5\u019e"+
		"\u00d0\2\u0524\u0523\3\2\2\2\u0524\u0525\3\2\2\2\u0525\u0526\3\2\2\2\u0526"+
		"\u0528\7<\2\2\u0527\u0522\3\2\2\2\u0527\u0528\3\2\2\2\u0528\u052a\3\2"+
		"\2\2\u0529\u052b\5j\66\2\u052a\u0529\3\2\2\2\u052a\u052b\3\2\2\2\u052b"+
		"\u00cb\3\2\2\2\u052c\u052d\5\u00f0y\2\u052d\u00cd\3\2\2\2\u052e\u0532"+
		"\7A\2\2\u052f\u0531\5l\67\2\u0530\u052f\3\2\2\2\u0531\u0534\3\2\2\2\u0532"+
		"\u0530\3\2\2\2\u0532\u0533\3\2\2\2\u0533\u00cf\3\2\2\2\u0534\u0532\3\2"+
		"\2\2\u0535\u0538\5\u00d2j\2\u0536\u0538\5\u00e4s\2\u0537\u0535\3\2\2\2"+
		"\u0537\u0536\3\2\2\2\u0538\u00d1\3\2\2\2\u0539\u053b\5\u00d4k\2\u053a"+
		"\u0539\3\2\2\2\u053b\u053e\3\2\2\2\u053c\u053a\3\2\2\2\u053c\u053d\3\2"+
		"\2\2\u053d\u053f\3\2\2\2\u053e\u053c\3\2\2\2\u053f\u0540\7\36\2\2\u0540"+
		"\u0542\7h\2\2\u0541\u0543\5`\61\2\u0542\u0541\3\2\2\2\u0542\u0543\3\2"+
		"\2\2\u0543\u0545\3\2\2\2\u0544\u0546\5\u00d6l\2\u0545\u0544\3\2\2\2\u0545"+
		"\u0546\3\2\2\2\u0546\u0547\3\2\2\2\u0547\u0548\5\u00d8m\2\u0548\u00d3"+
		"\3\2\2\2\u0549\u0551\5\u00f0y\2\u054a\u0551\7%\2\2\u054b\u0551\7$\2\2"+
		"\u054c\u0551\7#\2\2\u054d\u0551\7\3\2\2\u054e\u0551\7(\2\2\u054f\u0551"+
		"\7)\2\2\u0550\u0549\3\2\2\2\u0550\u054a\3\2\2\2\u0550\u054b\3\2\2\2\u0550"+
		"\u054c\3\2\2\2\u0550\u054d\3\2\2\2\u0550\u054e\3\2\2\2\u0550\u054f\3\2"+
		"\2\2\u0551\u00d5\3\2\2\2\u0552\u0553\7\23\2\2\u0553\u0554\5h\65\2\u0554"+
		"\u00d7\3\2\2\2\u0555\u0559\7=\2\2\u0556\u0558\5\u00dan\2\u0557\u0556\3"+
		"\2\2\2\u0558\u055b\3\2\2\2\u0559\u0557\3\2\2\2\u0559\u055a\3\2\2\2\u055a"+
		"\u055c\3\2\2\2\u055b\u0559\3\2\2\2\u055c\u055d\7>\2\2\u055d\u00d9\3\2"+
		"\2\2\u055e\u0564\5\u00dco\2\u055f\u0564\5\u00e0q\2\u0560\u0564\5Z.\2\u0561"+
		"\u0564\5\u00d0i\2\u0562\u0564\7A\2\2\u0563\u055e\3\2\2\2\u0563\u055f\3"+
		"\2\2\2\u0563\u0560\3\2\2\2\u0563\u0561\3\2\2\2\u0563\u0562\3\2\2\2\u0564"+
		"\u00db\3\2\2\2\u0565\u0567\5\u00dep\2\u0566\u0565\3\2\2\2\u0567\u056a"+
		"\3\2\2\2\u0568\u0566\3\2\2\2\u0568\u0569\3\2\2\2\u0569\u056b\3\2\2\2\u056a"+
		"\u0568\3\2\2\2\u056b\u056c\5|?\2\u056c\u056d\5t;\2\u056d\u056e\7A\2\2"+
		"\u056e\u00dd\3\2\2\2\u056f\u0574\5\u00f0y\2\u0570\u0574\7%\2\2\u0571\u0574"+
		"\7(\2\2\u0572\u0574\7\24\2\2\u0573\u056f\3\2\2\2\u0573\u0570\3\2\2\2\u0573"+
		"\u0571\3\2\2\2\u0573\u0572\3\2\2\2\u0574\u00df\3\2\2\2\u0575\u0577\5\u00e2"+
		"r\2\u0576\u0575\3\2\2\2\u0577\u057a\3\2\2\2\u0578\u0576\3\2\2\2\u0578"+
		"\u0579\3\2\2\2\u0579\u057b\3\2\2\2\u057a\u0578\3\2\2\2\u057b\u057c\5\u009a"+
		"N\2\u057c\u057d\5\u00b2Z\2\u057d\u00e1\3\2\2\2\u057e\u0585\5\u00f0y\2"+
		"\u057f\u0585\7%\2\2\u0580\u0585\7\3\2\2\u0581\u0585\7\16\2\2\u0582\u0585"+
		"\7(\2\2\u0583\u0585\7)\2\2\u0584\u057e\3\2\2\2\u0584\u057f\3\2\2\2\u0584"+
		"\u0580\3\2\2\2\u0584\u0581\3\2\2\2\u0584\u0582\3\2\2\2\u0584\u0583\3\2"+
		"\2\2\u0585\u00e3\3\2\2\2\u0586\u0588\5\u00d4k\2\u0587\u0586\3\2\2\2\u0588"+
		"\u058b\3\2\2\2\u0589\u0587\3\2\2\2\u0589\u058a\3\2\2\2\u058a\u058c\3\2"+
		"\2\2\u058b\u0589\3\2\2\2\u058c\u058d\7i\2\2\u058d\u058e\7\36\2\2\u058e"+
		"\u058f\7h\2\2\u058f\u0590\5\u00e6t\2\u0590\u00e5\3\2\2\2\u0591\u0595\7"+
		"=\2\2\u0592\u0594\5\u00e8u\2\u0593\u0592\3\2\2\2\u0594\u0597\3\2\2\2\u0595"+
		"\u0593\3\2\2\2\u0595\u0596\3\2\2\2\u0596\u0598\3\2\2\2\u0597\u0595\3\2"+
		"\2\2\u0598\u0599\7>\2\2\u0599\u00e7\3\2\2\2\u059a\u05a0\5\u00eav\2\u059b"+
		"\u05a0\5\u00dco\2\u059c\u05a0\5Z.\2\u059d\u05a0\5\u00d0i\2\u059e\u05a0"+
		"\7A\2\2\u059f\u059a\3\2\2\2\u059f\u059b\3\2\2\2\u059f\u059c\3\2\2\2\u059f"+
		"\u059d\3\2\2\2\u059f\u059e\3\2\2\2\u05a0\u00e9\3\2\2\2\u05a1\u05a3\5\u00ec"+
		"w\2\u05a2\u05a1\3\2\2\2\u05a3\u05a6\3\2\2\2\u05a4\u05a2\3\2\2\2\u05a4"+
		"\u05a5\3\2\2\2\u05a5\u05a7\3\2\2\2\u05a6\u05a4\3\2\2\2\u05a7\u05a8\5|"+
		"?\2\u05a8\u05a9\7h\2\2\u05a9\u05aa\7;\2\2\u05aa\u05ac\7<\2\2\u05ab\u05ad"+
		"\5\"\22\2\u05ac\u05ab\3\2\2\2\u05ac\u05ad\3\2\2\2\u05ad\u05af\3\2\2\2"+
		"\u05ae\u05b0\5\u00eex\2\u05af\u05ae\3\2\2\2\u05af\u05b0\3\2\2\2\u05b0"+
		"\u05b1\3\2\2\2\u05b1\u05b2\7A\2\2\u05b2\u00eb\3\2\2\2\u05b3\u05b7\5\u00f0"+
		"y\2\u05b4\u05b7\7%\2\2\u05b5\u05b7\7\3\2\2\u05b6\u05b3\3\2\2\2\u05b6\u05b4"+
		"\3\2\2\2\u05b6\u05b5\3\2\2\2\u05b7\u00ed\3\2\2\2\u05b8\u05b9\7\16\2\2"+
		"\u05b9\u05ba\5\u00f8}\2\u05ba\u00ef\3\2\2\2\u05bb\u05bf\5\u00f2z\2\u05bc"+
		"\u05bf\5\u00fe\u0080\2\u05bd\u05bf\5\u0100\u0081\2\u05be\u05bb\3\2\2\2"+
		"\u05be\u05bc\3\2\2\2\u05be\u05bd\3\2\2\2\u05bf\u00f1\3\2\2\2\u05c0\u05c1"+
		"\7i\2\2\u05c1\u05c2\5> \2\u05c2\u05c4\7;\2\2\u05c3\u05c5\5\u00f4{\2\u05c4"+
		"\u05c3\3\2\2\2\u05c4\u05c5\3\2\2\2\u05c5\u05c6\3\2\2\2\u05c6\u05c7\7<"+
		"\2\2\u05c7\u00f3\3\2\2\2\u05c8\u05cd\5\u00f6|\2\u05c9\u05ca\7B\2\2\u05ca"+
		"\u05cc\5\u00f6|\2\u05cb\u05c9\3\2\2\2\u05cc\u05cf\3\2\2\2\u05cd\u05cb"+
		"\3\2\2\2\u05cd\u05ce\3\2\2\2\u05ce\u00f5\3\2\2\2\u05cf\u05cd\3\2\2\2\u05d0"+
		"\u05d1\7h\2\2\u05d1\u05d2\7D\2\2\u05d2\u05d3\5\u00f8}\2\u05d3\u00f7\3"+
		"\2\2\2\u05d4\u05d8\5\u01c0\u00e1\2\u05d5\u05d8\5\u00fa~\2\u05d6\u05d8"+
		"\5\u00f0y\2\u05d7\u05d4\3\2\2\2\u05d7\u05d5\3\2\2\2\u05d7\u05d6\3\2\2"+
		"\2\u05d8\u00f9\3\2\2\2\u05d9\u05db\7=\2\2\u05da\u05dc\5\u00fc\177\2\u05db"+
		"\u05da\3\2\2\2\u05db\u05dc\3\2\2\2\u05dc\u05de\3\2\2\2\u05dd\u05df\7B"+
		"\2\2\u05de\u05dd\3\2\2\2\u05de\u05df\3\2\2\2\u05df\u05e0\3\2\2\2\u05e0"+
		"\u05e1\7>\2\2\u05e1\u00fb\3\2\2\2\u05e2\u05e7\5\u00f8}\2\u05e3\u05e4\7"+
		"B\2\2\u05e4\u05e6\5\u00f8}\2\u05e5\u05e3\3\2\2\2\u05e6\u05e9\3\2\2\2\u05e7"+
		"\u05e5\3\2\2\2\u05e7\u05e8\3\2\2\2\u05e8\u00fd\3\2\2\2\u05e9\u05e7\3\2"+
		"\2\2\u05ea\u05eb\7i\2\2\u05eb\u05ec\5> \2\u05ec\u00ff\3\2\2\2\u05ed\u05ee"+
		"\7i\2\2\u05ee\u05ef\5> \2\u05ef\u05f0\7;\2\2\u05f0\u05f1\5\u00f8}\2\u05f1"+
		"\u05f2\7<\2\2\u05f2\u0101\3\2\2\2\u05f3\u05f5\7=\2\2\u05f4\u05f6\5\u0104"+
		"\u0083\2\u05f5\u05f4\3\2\2\2\u05f5\u05f6\3\2\2\2\u05f6\u05f8\3\2\2\2\u05f7"+
		"\u05f9\7B\2\2\u05f8\u05f7\3\2\2\2\u05f8\u05f9\3\2\2\2\u05f9\u05fa\3\2"+
		"\2\2\u05fa\u05fb\7>\2\2\u05fb\u0103\3\2\2\2\u05fc\u0601\5z>\2\u05fd\u05fe"+
		"\7B\2\2\u05fe\u0600\5z>\2\u05ff\u05fd\3\2\2\2\u0600\u0603\3\2\2\2\u0601"+
		"\u05ff\3\2\2\2\u0601\u0602\3\2\2\2\u0602\u0105\3\2\2\2\u0603\u0601\3\2"+
		"\2\2\u0604\u0606\7=\2\2\u0605\u0607\5\u0108\u0085\2\u0606\u0605\3\2\2"+
		"\2\u0606\u0607\3\2\2\2\u0607\u0608\3\2\2\2\u0608\u0609\7>\2\2\u0609\u0107"+
		"\3\2\2\2\u060a\u060c\5\u010a\u0086\2\u060b\u060a\3\2\2\2\u060c\u060d\3"+
		"\2\2\2\u060d\u060b\3\2\2\2\u060d\u060e\3\2\2\2\u060e\u0109\3\2\2\2\u060f"+
		"\u0613\5\u010c\u0087\2\u0610\u0613\5Z.\2\u0611\u0613\5\u0110\u0089\2\u0612"+
		"\u060f\3\2\2\2\u0612\u0610\3\2\2\2\u0612\u0611\3\2\2\2\u0613\u010b\3\2"+
		"\2\2\u0614\u0615\5\u010e\u0088\2\u0615\u0616\7A\2\2\u0616\u010d\3\2\2"+
		"\2\u0617\u0619\5\u00a6T\2\u0618\u0617\3\2\2\2\u0619\u061c\3\2\2\2\u061a"+
		"\u0618\3\2\2\2\u061a\u061b\3\2\2\2\u061b\u061d\3\2\2\2\u061c\u061a\3\2"+
		"\2\2\u061d\u061e\5|?\2\u061e\u061f\5t;\2\u061f\u010f\3\2\2\2\u0620\u0627"+
		"\5\u0114\u008b\2\u0621\u0627\5\u0118\u008d\2\u0622\u0627\5\u0120\u0091"+
		"\2\u0623\u0627\5\u0122\u0092\2\u0624\u0627\5\u0134\u009b\2\u0625\u0627"+
		"\5\u013a\u009e\2\u0626\u0620\3\2\2\2\u0626\u0621\3\2\2\2\u0626\u0622\3"+
		"\2\2\2\u0626\u0623\3\2\2\2\u0626\u0624\3\2\2\2\u0626\u0625\3\2\2\2\u0627"+
		"\u0111\3\2\2\2\u0628\u062e\5\u0114\u008b\2\u0629\u062e\5\u011a\u008e\2"+
		"\u062a\u062e\5\u0124\u0093\2\u062b\u062e\5\u0136\u009c\2\u062c\u062e\5"+
		"\u013c\u009f\2\u062d\u0628\3\2\2\2\u062d\u0629\3\2\2\2\u062d\u062a\3\2"+
		"\2\2\u062d\u062b\3\2\2\2\u062d\u062c\3\2\2\2\u062e\u0113\3\2\2\2\u062f"+
		"\u063c\5\u0106\u0084\2\u0630\u063c\5\u0116\u008c\2\u0631\u063c\5\u011c"+
		"\u008f\2\u0632\u063c\5\u0126\u0094\2\u0633\u063c\5\u0128\u0095\2\u0634"+
		"\u063c\5\u0138\u009d\2\u0635\u063c\5\u014c\u00a7\2\u0636\u063c\5\u014e"+
		"\u00a8\2\u0637\u063c\5\u0150\u00a9\2\u0638\u063c\5\u0154\u00ab\2\u0639"+
		"\u063c\5\u0152\u00aa\2\u063a\u063c\5\u0156\u00ac\2\u063b\u062f\3\2\2\2"+
		"\u063b\u0630\3\2\2\2\u063b\u0631\3\2\2\2\u063b\u0632\3\2\2\2\u063b\u0633"+
		"\3\2\2\2\u063b\u0634\3\2\2\2\u063b\u0635\3\2\2\2\u063b\u0636\3\2\2\2\u063b"+
		"\u0637\3\2\2\2\u063b\u0638\3\2\2\2\u063b\u0639\3\2\2\2\u063b\u063a\3\2"+
		"\2\2\u063c\u0115\3\2\2\2\u063d\u063e\7A\2\2\u063e\u0117\3\2\2\2\u063f"+
		"\u0640\7h\2\2\u0640\u0641\7J\2\2\u0641\u0642\5\u0110\u0089\2\u0642\u0119"+
		"\3\2\2\2\u0643\u0644\7h\2\2\u0644\u0645\7J\2\2\u0645\u0646\5\u0112\u008a"+
		"\2\u0646\u011b\3\2\2\2\u0647\u0648\5\u011e\u0090\2\u0648\u0649\7A\2\2"+
		"\u0649\u011d\3\2\2\2\u064a\u0652\5\u01ba\u00de\2\u064b\u0652\5\u01fa\u00fe"+
		"\2\u064c\u0652\5\u01fc\u00ff\2\u064d\u0652\5\u0208\u0105\2\u064e\u0652"+
		"\5\u020c\u0107\2\u064f\u0652\5\u0196\u00cc\2\u0650\u0652\5\u0180\u00c1"+
		"\2\u0651\u064a\3\2\2\2\u0651\u064b\3\2\2\2\u0651\u064c\3\2\2\2\u0651\u064d"+
		"\3\2\2\2\u0651\u064e\3\2\2\2\u0651\u064f\3\2\2\2\u0651\u0650\3\2\2\2\u0652"+
		"\u011f\3\2\2\2\u0653\u0654\7\30\2\2\u0654\u0655\7;\2\2\u0655\u0656\5\u01ae"+
		"\u00d8\2\u0656\u0657\7<\2\2\u0657\u0658\5\u0110\u0089\2\u0658\u0121\3"+
		"\2\2\2\u0659\u065a\7\30\2\2\u065a\u065b\7;\2\2\u065b\u065c\5\u01ae\u00d8"+
		"\2\u065c\u065d\7<\2\2\u065d\u065e\5\u0112\u008a\2\u065e\u065f\7\21\2\2"+
		"\u065f\u0660\5\u0110\u0089\2\u0660\u0123\3\2\2\2\u0661\u0662\7\30\2\2"+
		"\u0662\u0663\7;\2\2\u0663\u0664\5\u01ae\u00d8\2\u0664\u0665\7<\2\2\u0665"+
		"\u0666\5\u0112\u008a\2\u0666\u0667\7\21\2\2\u0667\u0668\5\u0112\u008a"+
		"\2\u0668\u0125\3\2\2\2\u0669\u066a\7\4\2\2\u066a\u066b\5\u01ae\u00d8\2"+
		"\u066b\u066c\7A\2\2\u066c\u0674\3\2\2\2\u066d\u066e\7\4\2\2\u066e\u066f"+
		"\5\u01ae\u00d8\2\u066f\u0670\7J\2\2\u0670\u0671\5\u01ae\u00d8\2\u0671"+
		"\u0672\7A\2\2\u0672\u0674\3\2\2\2\u0673\u0669\3\2\2\2\u0673\u066d\3\2"+
		"\2\2\u0674\u0127\3\2\2\2\u0675\u0676\7+\2\2\u0676\u0677\7;\2\2\u0677\u0678"+
		"\5\u01ae\u00d8\2\u0678\u0679\7<\2\2\u0679\u067a\5\u012a\u0096\2\u067a"+
		"\u0129\3\2\2\2\u067b\u067f\7=\2\2\u067c\u067e\5\u012c\u0097\2\u067d\u067c"+
		"\3\2\2\2\u067e\u0681\3\2\2\2\u067f\u067d\3\2\2\2\u067f\u0680\3\2\2\2\u0680"+
		"\u0685\3\2\2\2\u0681\u067f\3\2\2\2\u0682\u0684\5\u0130\u0099\2\u0683\u0682"+
		"\3\2\2\2\u0684\u0687\3\2\2\2\u0685\u0683\3\2\2\2\u0685\u0686\3\2\2\2\u0686"+
		"\u0688\3\2\2\2\u0687\u0685\3\2\2\2\u0688\u0689\7>\2\2\u0689\u012b\3\2"+
		"\2\2\u068a\u068b\5\u012e\u0098\2\u068b\u068c\5\u0108\u0085\2\u068c\u012d"+
		"\3\2\2\2\u068d\u0691\5\u0130\u0099\2\u068e\u0690\5\u0130\u0099\2\u068f"+
		"\u068e\3\2\2\2\u0690\u0693\3\2\2\2\u0691\u068f\3\2\2\2\u0691\u0692\3\2"+
		"\2\2\u0692\u012f\3\2\2\2\u0693\u0691\3\2\2\2\u0694\u0695\7\b\2\2\u0695"+
		"\u0696\5\u01ac\u00d7\2\u0696\u0697\7J\2\2\u0697\u069f\3\2\2\2\u0698\u0699"+
		"\7\b\2\2\u0699\u069a\5\u0132\u009a\2\u069a\u069b\7J\2\2\u069b\u069f\3"+
		"\2\2\2\u069c\u069d\7\16\2\2\u069d\u069f\7J\2\2\u069e\u0694\3\2\2\2\u069e"+
		"\u0698\3\2\2\2\u069e\u069c\3\2\2\2\u069f\u0131\3\2\2\2\u06a0\u06a1\7h"+
		"\2\2\u06a1\u0133\3\2\2\2\u06a2\u06a3\7\64\2\2\u06a3\u06a4\7;\2\2\u06a4"+
		"\u06a5\5\u01ae\u00d8\2\u06a5\u06a6\7<\2\2\u06a6\u06a7\5\u0110\u0089\2"+
		"\u06a7\u0135\3\2\2\2\u06a8\u06a9\7\64\2\2\u06a9\u06aa\7;\2\2\u06aa\u06ab"+
		"\5\u01ae\u00d8\2\u06ab\u06ac\7<\2\2\u06ac\u06ad\5\u0112\u008a\2\u06ad"+
		"\u0137\3\2\2\2\u06ae\u06af\7\17\2\2\u06af\u06b0\5\u0110\u0089\2\u06b0"+
		"\u06b1\7\64\2\2\u06b1\u06b2\7;\2\2\u06b2\u06b3\5\u01ae\u00d8\2\u06b3\u06b4"+
		"\7<\2\2\u06b4\u06b5\7A\2\2\u06b5\u0139\3\2\2\2\u06b6\u06b9\5\u013e\u00a0"+
		"\2\u06b7\u06b9\5\u0148\u00a5\2\u06b8\u06b6\3\2\2\2\u06b8\u06b7\3\2\2\2"+
		"\u06b9\u013b\3\2\2\2\u06ba\u06bd\5\u0140\u00a1\2\u06bb\u06bd\5\u014a\u00a6"+
		"\2\u06bc\u06ba\3\2\2\2\u06bc\u06bb\3\2\2\2\u06bd\u013d\3\2\2\2\u06be\u06bf"+
		"\7\27\2\2\u06bf\u06c1\7;\2\2\u06c0\u06c2\5\u0142\u00a2\2\u06c1\u06c0\3"+
		"\2\2\2\u06c1\u06c2\3\2\2\2\u06c2\u06c3\3\2\2\2\u06c3\u06c5\7A\2\2\u06c4"+
		"\u06c6\5\u01ae\u00d8\2\u06c5\u06c4\3\2\2\2\u06c5\u06c6\3\2\2\2\u06c6\u06c7"+
		"\3\2\2\2\u06c7\u06c9\7A\2\2\u06c8\u06ca\5\u0144\u00a3\2\u06c9\u06c8\3"+
		"\2\2\2\u06c9\u06ca\3\2\2\2\u06ca\u06cb\3\2\2\2\u06cb\u06cc\7<\2\2\u06cc"+
		"\u06cd\5\u0110\u0089\2\u06cd\u013f\3\2\2\2\u06ce\u06cf\7\27\2\2\u06cf"+
		"\u06d1\7;\2\2\u06d0\u06d2\5\u0142\u00a2\2\u06d1\u06d0\3\2\2\2\u06d1\u06d2"+
		"\3\2\2\2\u06d2\u06d3\3\2\2\2\u06d3\u06d5\7A\2\2\u06d4\u06d6\5\u01ae\u00d8"+
		"\2\u06d5\u06d4\3\2\2\2\u06d5\u06d6\3\2\2\2\u06d6\u06d7\3\2\2\2\u06d7\u06d9"+
		"\7A\2\2\u06d8\u06da\5\u0144\u00a3\2\u06d9\u06d8\3\2\2\2\u06d9\u06da\3"+
		"\2\2\2\u06da\u06db\3\2\2\2\u06db\u06dc\7<\2\2\u06dc\u06dd\5\u0112\u008a"+
		"\2\u06dd\u0141\3\2\2\2\u06de\u06e1\5\u0146\u00a4\2\u06df\u06e1\5\u010e"+
		"\u0088\2\u06e0\u06de\3\2\2\2\u06e0\u06df\3\2\2\2\u06e1\u0143\3\2\2\2\u06e2"+
		"\u06e3\5\u0146\u00a4\2\u06e3\u0145\3\2\2\2\u06e4\u06e9\5\u011e\u0090\2"+
		"\u06e5\u06e6\7B\2\2\u06e6\u06e8\5\u011e\u0090\2\u06e7\u06e5\3\2\2\2\u06e8"+
		"\u06eb\3\2\2\2\u06e9\u06e7\3\2\2\2\u06e9\u06ea\3\2\2\2\u06ea\u0147\3\2"+
		"\2\2\u06eb\u06e9\3\2\2\2\u06ec\u06ed\7\27\2\2\u06ed\u06f1\7;\2\2\u06ee"+
		"\u06f0\5\u00a6T\2\u06ef\u06ee\3\2\2\2\u06f0\u06f3\3\2\2\2\u06f1\u06ef"+
		"\3\2\2\2\u06f1\u06f2\3\2\2\2\u06f2\u06f4\3\2\2\2\u06f3\u06f1\3\2\2\2\u06f4"+
		"\u06f5\5|?\2\u06f5\u06f6\5x=\2\u06f6\u06f7\7J\2\2\u06f7\u06f8\5\u01ae"+
		"\u00d8\2\u06f8\u06f9\7<\2\2\u06f9\u06fa\5\u0110\u0089\2\u06fa\u0149\3"+
		"\2\2\2\u06fb\u06fc\7\27\2\2\u06fc\u0700\7;\2\2\u06fd\u06ff\5\u00a6T\2"+
		"\u06fe\u06fd\3\2\2\2\u06ff\u0702\3\2\2\2\u0700\u06fe\3\2\2\2\u0700\u0701"+
		"\3\2\2\2\u0701\u0703\3\2\2\2\u0702\u0700\3\2\2\2\u0703\u0704\5|?\2\u0704"+
		"\u0705\5x=\2\u0705\u0706\7J\2\2\u0706\u0707\5\u01ae\u00d8\2\u0707\u0708"+
		"\7<\2\2\u0708\u0709\5\u0112\u008a\2\u0709\u014b\3\2\2\2\u070a\u070c\7"+
		"\6\2\2\u070b\u070d\7h\2\2\u070c\u070b\3\2\2\2\u070c\u070d\3\2\2\2\u070d"+
		"\u070e\3\2\2\2\u070e\u070f\7A\2\2\u070f\u014d\3\2\2\2\u0710\u0712\7\r"+
		"\2\2\u0711\u0713\7h\2\2\u0712\u0711\3\2\2\2\u0712\u0713\3\2\2\2\u0713"+
		"\u0714\3\2\2\2\u0714\u0715\7A\2\2\u0715\u014f\3\2\2\2\u0716\u0718\7&\2"+
		"\2\u0717\u0719\5\u01ae\u00d8\2\u0718\u0717\3\2\2\2\u0718\u0719\3\2\2\2"+
		"\u0719\u071a\3\2\2\2\u071a\u071b\7A\2\2\u071b\u0151\3\2\2\2\u071c\u071d"+
		"\7.\2\2\u071d\u071e\5\u01ae\u00d8\2\u071e\u071f\7A\2\2\u071f\u0153\3\2"+
		"\2\2\u0720\u0721\7,\2\2\u0721\u0722\7;\2\2\u0722\u0723\5\u01ae\u00d8\2"+
		"\u0723\u0724\7<\2\2\u0724\u0725\5\u0106\u0084\2\u0725\u0155\3\2\2\2\u0726"+
		"\u0727\7\61\2\2\u0727\u0728\5\u0106\u0084\2\u0728\u0729\5\u0158\u00ad"+
		"\2\u0729\u0733\3\2\2\2\u072a\u072b\7\61\2\2\u072b\u072d\5\u0106\u0084"+
		"\2\u072c\u072e\5\u0158\u00ad\2\u072d\u072c\3\2\2\2\u072d\u072e\3\2\2\2"+
		"\u072e\u072f\3\2\2\2\u072f\u0730\5\u0160\u00b1\2\u0730\u0733\3\2\2\2\u0731"+
		"\u0733\5\u0162\u00b2\2\u0732\u0726\3\2\2\2\u0732\u072a\3\2\2\2\u0732\u0731"+
		"\3\2\2\2\u0733\u0157\3\2\2\2\u0734\u0738\5\u015a\u00ae\2\u0735\u0737\5"+
		"\u015a\u00ae\2\u0736\u0735\3\2\2\2\u0737\u073a\3\2\2\2\u0738\u0736\3\2"+
		"\2\2\u0738\u0739\3\2\2\2\u0739\u0159\3\2\2\2\u073a\u0738\3\2\2\2\u073b"+
		"\u073c\7\t\2\2\u073c\u073d\7;\2\2\u073d\u073e\5\u015c\u00af\2\u073e\u073f"+
		"\7<\2\2\u073f\u0740\5\u0106\u0084\2\u0740\u015b\3\2\2\2\u0741\u0743\5"+
		"\u00a6T\2\u0742\u0741\3\2\2\2\u0743\u0746\3\2\2\2\u0744\u0742\3\2\2\2"+
		"\u0744\u0745\3\2\2\2\u0745\u0747\3\2\2\2\u0746\u0744\3\2\2\2\u0747\u0748"+
		"\5\u015e\u00b0\2\u0748\u0749\5x=\2\u0749\u015d\3\2\2\2\u074a\u074f\5\u0086"+
		"D\2\u074b\u074c\7X\2\2\u074c\u074e\5\22\n\2\u074d\u074b\3\2\2\2\u074e"+
		"\u0751\3\2\2\2\u074f\u074d\3\2\2\2\u074f\u0750\3\2\2\2\u0750\u015f\3\2"+
		"\2\2\u0751\u074f\3\2\2\2\u0752\u0753\7\25\2\2\u0753\u0754\5\u0106\u0084"+
		"\2\u0754\u0161\3\2\2\2\u0755\u0756\7\61\2\2\u0756\u0757\5\u0164\u00b3"+
		"\2\u0757\u0759\5\u0106\u0084\2\u0758\u075a\5\u0158\u00ad\2\u0759\u0758"+
		"\3\2\2\2\u0759\u075a\3\2\2\2\u075a\u075c\3\2\2\2\u075b\u075d\5\u0160\u00b1"+
		"\2\u075c\u075b\3\2\2\2\u075c\u075d\3\2\2\2\u075d\u0163\3\2\2\2\u075e\u075f"+
		"\7;\2\2\u075f\u0761\5\u0166\u00b4\2\u0760\u0762\7A\2\2\u0761\u0760\3\2"+
		"\2\2\u0761\u0762\3\2\2\2\u0762\u0763\3\2\2\2\u0763\u0764\7<\2\2\u0764"+
		"\u0165\3\2\2\2\u0765\u076a\5\u0168\u00b5\2\u0766\u0767\7A\2\2\u0767\u0769"+
		"\5\u0168\u00b5\2\u0768\u0766\3\2\2\2\u0769\u076c\3\2\2\2\u076a\u0768\3"+
		"\2\2\2\u076a\u076b\3\2\2\2\u076b\u0167\3\2\2\2\u076c\u076a\3\2\2\2\u076d"+
		"\u076f\5\u00a6T\2\u076e\u076d\3\2\2\2\u076f\u0772\3\2\2\2\u0770\u076e"+
		"\3\2\2\2\u0770\u0771\3\2\2\2\u0771\u0773\3\2\2\2\u0772\u0770\3\2\2\2\u0773"+
		"\u0774\5|?\2\u0774\u0775\5x=\2\u0775\u0776\7D\2\2\u0776\u0777\5\u01ae"+
		"\u00d8\2\u0777\u0169\3\2\2\2\u0778\u077b\5\u017a\u00be\2\u0779\u077b\5"+
		"\u01a6\u00d4\2\u077a\u0778\3\2\2\2\u077a\u0779\3\2\2\2\u077b\u077f\3\2"+
		"\2\2\u077c\u077e\5\u0174\u00bb\2\u077d\u077c\3\2\2\2\u077e\u0781\3\2\2"+
		"\2\u077f\u077d\3\2\2\2\u077f\u0780\3\2\2\2\u0780\u016b\3\2\2\2\u0781\u077f"+
		"\3\2\2\2\u0782\u079f\5\2\2\2\u0783\u0787\5> \2\u0784\u0786\5&\24\2\u0785"+
		"\u0784\3\2\2\2\u0786\u0789\3\2\2\2\u0787\u0785\3\2\2\2\u0787\u0788\3\2"+
		"\2\2\u0788\u078a\3\2\2\2\u0789\u0787\3\2\2\2\u078a\u078b\7C\2\2\u078b"+
		"\u078c\5\u016e\u00b8\2\u078c\u079f\3\2\2\2\u078d\u078e\7\62\2\2\u078e"+
		"\u078f\7C\2\2\u078f\u079f\5\u016e\u00b8\2\u0790\u079f\7-\2\2\u0791\u0792"+
		"\5> \2\u0792\u0793\7C\2\2\u0793\u0794\7-\2\2\u0794\u079f\3\2\2\2\u0795"+
		"\u0796\7;\2\2\u0796\u0797\5\u01ae\u00d8\2\u0797\u0798\7<\2\2\u0798\u079f"+
		"\3\2\2\2\u0799\u079f\5\u0180\u00c1\2\u079a\u079f\5\u018a\u00c6\2\u079b"+
		"\u079f\5\u0190\u00c9\2\u079c\u079f\5\u0196\u00cc\2\u079d\u079f\5\u01a0"+
		"\u00d1\2\u079e\u0782\3\2\2\2\u079e\u0783\3\2\2\2\u079e\u078d\3\2\2\2\u079e"+
		"\u0790\3\2\2\2\u079e\u0791\3\2\2\2\u079e\u0795\3\2\2\2\u079e\u0799\3\2"+
		"\2\2\u079e\u079a\3\2\2\2\u079e\u079b\3\2\2\2\u079e\u079c\3\2\2\2\u079e"+
		"\u079d\3\2\2\2\u079f\u016d\3\2\2\2\u07a0\u07a1\7\13\2\2\u07a1\u016f\3"+
		"\2\2\2\u07a2\u07a3\3\2\2\2\u07a3\u0171\3\2\2\2\u07a4\u07c0\5\2\2\2\u07a5"+
		"\u07a9\5> \2\u07a6\u07a8\5&\24\2\u07a7\u07a6\3\2\2\2\u07a8\u07ab\3\2\2"+
		"\2\u07a9\u07a7\3\2\2\2\u07a9\u07aa\3\2\2\2\u07aa\u07ac\3\2\2\2\u07ab\u07a9"+
		"\3\2\2\2\u07ac\u07ad\7C\2\2\u07ad\u07ae\5\u016e\u00b8\2\u07ae\u07c0\3"+
		"\2\2\2\u07af\u07b0\7\62\2\2\u07b0\u07b1\7C\2\2\u07b1\u07c0\5\u016e\u00b8"+
		"\2\u07b2\u07c0\7-\2\2\u07b3\u07b4\5> \2\u07b4\u07b5\7C\2\2\u07b5\u07b6"+
		"\5\u016e\u00b8\2\u07b6\u07c0\3\2\2\2\u07b7\u07b8\7;\2\2\u07b8\u07b9\5"+
		"\u01ae\u00d8\2\u07b9\u07ba\7<\2\2\u07ba\u07c0\3\2\2\2\u07bb\u07c0\5\u0180"+
		"\u00c1\2\u07bc\u07c0\5\u018a\u00c6\2\u07bd\u07c0\5\u0196\u00cc\2\u07be"+
		"\u07c0\5\u01a0\u00d1\2\u07bf\u07a4\3\2\2\2\u07bf\u07a5\3\2\2\2\u07bf\u07af"+
		"\3\2\2\2\u07bf\u07b2\3\2\2\2\u07bf\u07b3\3\2\2\2\u07bf\u07b7\3\2\2\2\u07bf"+
		"\u07bb\3\2\2\2\u07bf\u07bc\3\2\2\2\u07bf\u07bd\3\2\2\2\u07bf\u07be\3\2"+
		"\2\2\u07c0\u0173\3\2\2\2\u07c1\u07c7\5\u0182\u00c2\2\u07c2\u07c7\5\u018c"+
		"\u00c7\2\u07c3\u07c7\5\u0192\u00ca\2\u07c4\u07c7\5\u019a\u00ce\2\u07c5"+
		"\u07c7\5\u01a2\u00d2\2\u07c6\u07c1\3\2\2\2\u07c6\u07c2\3\2\2\2\u07c6\u07c3"+
		"\3\2\2\2\u07c6\u07c4\3\2\2\2\u07c6\u07c5\3\2\2\2\u07c7\u0175\3\2\2\2\u07c8"+
		"\u07c9\3\2\2\2\u07c9\u0177\3\2\2\2\u07ca\u07cf\5\u0182\u00c2\2\u07cb\u07cf"+
		"\5\u018c\u00c7\2\u07cc\u07cf\5\u019a\u00ce\2\u07cd\u07cf\5\u01a2\u00d2"+
		"\2\u07ce\u07ca\3\2\2\2\u07ce\u07cb\3\2\2\2\u07ce\u07cc\3\2\2\2\u07ce\u07cd"+
		"\3\2\2\2\u07cf\u0179\3\2\2\2\u07d0\u07f7\5\2\2\2\u07d1\u07d5\5> \2\u07d2"+
		"\u07d4\5&\24\2\u07d3\u07d2\3\2\2\2\u07d4\u07d7\3\2\2\2\u07d5\u07d3\3\2"+
		"\2\2\u07d5\u07d6\3\2\2\2\u07d6\u07d8\3\2\2\2\u07d7\u07d5\3\2\2\2\u07d8"+
		"\u07d9\7C\2\2\u07d9\u07da\5\u016e\u00b8\2\u07da\u07f7\3\2\2\2\u07db\u07df"+
		"\5~@\2\u07dc\u07de\5&\24\2\u07dd\u07dc\3\2\2\2\u07de\u07e1\3\2\2\2\u07df"+
		"\u07dd\3\2\2\2\u07df\u07e0\3\2\2\2\u07e0\u07e2\3\2\2\2\u07e1\u07df\3\2"+
		"\2\2\u07e2\u07e3\7C\2\2\u07e3\u07e4\5\u016e\u00b8\2\u07e4\u07f7\3\2\2"+
		"\2\u07e5\u07e6\7\62\2\2\u07e6\u07e7\7C\2\2\u07e7\u07f7\5\u016e\u00b8\2"+
		"\u07e8\u07f7\7-\2\2\u07e9\u07ea\5> \2\u07ea\u07eb\7C\2\2\u07eb\u07ec\7"+
		"-\2\2\u07ec\u07f7\3\2\2\2\u07ed\u07ee\7;\2\2\u07ee\u07ef\5\u01ae\u00d8"+
		"\2\u07ef\u07f0\7<\2\2\u07f0\u07f7\3\2\2\2\u07f1\u07f7\5\u0184\u00c3\2"+
		"\u07f2\u07f7\5\u018e\u00c8\2\u07f3\u07f7\5\u0194\u00cb\2\u07f4\u07f7\5"+
		"\u019c\u00cf\2\u07f5\u07f7\5\u01a4\u00d3\2\u07f6\u07d0\3\2\2\2\u07f6\u07d1"+
		"\3\2\2\2\u07f6\u07db\3\2\2\2\u07f6\u07e5\3\2\2\2\u07f6\u07e8\3\2\2\2\u07f6"+
		"\u07e9\3\2\2\2\u07f6\u07ed\3\2\2\2\u07f6\u07f1\3\2\2\2\u07f6\u07f2\3\2"+
		"\2\2\u07f6\u07f3\3\2\2\2\u07f6\u07f4\3\2\2\2\u07f6\u07f5\3\2\2\2\u07f7"+
		"\u017b\3\2\2\2\u07f8\u07f9\3\2\2\2\u07f9\u017d\3\2\2\2\u07fa\u0820\5\2"+
		"\2\2\u07fb\u07ff\5> \2\u07fc\u07fe\5&\24\2\u07fd\u07fc\3\2\2\2\u07fe\u0801"+
		"\3\2\2\2\u07ff\u07fd\3\2\2\2\u07ff\u0800\3\2\2\2\u0800\u0802\3\2\2\2\u0801"+
		"\u07ff\3\2\2\2\u0802\u0803\7C\2\2\u0803\u0804\5\u016e\u00b8\2\u0804\u0820"+
		"\3\2\2\2\u0805\u0809\5~@\2\u0806\u0808\5&\24\2\u0807\u0806\3\2\2\2\u0808"+
		"\u080b\3\2\2\2\u0809\u0807\3\2\2\2\u0809\u080a\3\2\2\2\u080a\u080c\3\2"+
		"\2\2\u080b\u0809\3\2\2\2\u080c\u080d\7C\2\2\u080d\u080e\5\u016e\u00b8"+
		"\2\u080e\u0820\3\2\2\2\u080f\u0810\7\62\2\2\u0810\u0811\7C\2\2\u0811\u0820"+
		"\5\u016e\u00b8\2\u0812\u0820\7-\2\2\u0813\u0814\5> \2\u0814\u0815\7C\2"+
		"\2\u0815\u0816\7-\2\2\u0816\u0820\3\2\2\2\u0817\u0818\7;\2\2\u0818\u0819"+
		"\5\u01ae\u00d8\2\u0819\u081a\7<\2\2\u081a\u0820\3\2\2\2\u081b\u0820\5"+
		"\u0184\u00c3\2\u081c\u0820\5\u018e\u00c8\2\u081d\u0820\5\u019c\u00cf\2"+
		"\u081e\u0820\5\u01a4\u00d3\2\u081f\u07fa\3\2\2\2\u081f\u07fb\3\2\2\2\u081f"+
		"\u0805\3\2\2\2\u081f\u080f\3\2\2\2\u081f\u0812\3\2\2\2\u081f\u0813\3\2"+
		"\2\2\u081f\u0817\3\2\2\2\u081f\u081b\3\2\2\2\u081f\u081c\3\2\2\2\u081f"+
		"\u081d\3\2\2\2\u081f\u081e\3\2\2\2\u0820\u017f\3\2\2\2\u0821\u0823\7!"+
		"\2\2\u0822\u0824\5\60\31\2\u0823\u0822\3\2\2\2\u0823\u0824\3\2\2\2\u0824"+
		"\u0825\3\2\2\2\u0825\u082a\5\u0186\u00c4\2\u0826\u0827\7C\2\2\u0827\u0829"+
		"\5\u0186\u00c4\2\u0828\u0826\3\2\2\2\u0829\u082c\3\2\2\2\u082a\u0828\3"+
		"\2\2\2\u082a\u082b\3\2\2\2\u082b\u082e\3\2\2\2\u082c\u082a\3\2\2\2\u082d"+
		"\u082f\5\u0188\u00c5\2\u082e\u082d\3\2\2\2\u082e\u082f\3\2\2\2\u082f\u0830"+
		"\3\2\2\2\u0830\u0832\7;\2\2\u0831\u0833\5\u019e\u00d0\2\u0832\u0831\3"+
		"\2\2\2\u0832\u0833\3\2\2\2\u0833\u0834\3\2\2\2\u0834\u0836\7<\2\2\u0835"+
		"\u0837\5j\66\2\u0836\u0835\3\2\2\2\u0836\u0837\3\2\2\2\u0837\u085d\3\2"+
		"\2\2\u0838\u0839\5B\"\2\u0839\u083a\7C\2\2\u083a\u083c\7!\2\2\u083b\u083d"+
		"\5\60\31\2\u083c\u083b\3\2\2\2\u083c\u083d\3\2\2\2\u083d\u083e\3\2\2\2"+
		"\u083e\u0840\5\u0186\u00c4\2\u083f\u0841\5\u0188\u00c5\2\u0840\u083f\3"+
		"\2\2\2\u0840\u0841\3\2\2\2\u0841\u0842\3\2\2\2\u0842\u0844\7;\2\2\u0843"+
		"\u0845\5\u019e\u00d0\2\u0844\u0843\3\2\2\2\u0844\u0845\3\2\2\2\u0845\u0846"+
		"\3\2\2\2\u0846\u0848\7<\2\2\u0847\u0849\5j\66\2\u0848\u0847\3\2\2\2\u0848"+
		"\u0849\3\2\2\2\u0849\u085d\3\2\2\2\u084a\u084b\5\u016a\u00b6\2\u084b\u084c"+
		"\7C\2\2\u084c\u084e\7!\2\2\u084d\u084f\5\60\31\2\u084e\u084d\3\2\2\2\u084e"+
		"\u084f\3\2\2\2\u084f\u0850\3\2\2\2\u0850\u0852\5\u0186\u00c4\2\u0851\u0853"+
		"\5\u0188\u00c5\2\u0852\u0851\3\2\2\2\u0852\u0853\3\2\2\2\u0853\u0854\3"+
		"\2\2\2\u0854\u0856\7;\2\2\u0855\u0857\5\u019e\u00d0\2\u0856\u0855\3\2"+
		"\2\2\u0856\u0857\3\2\2\2\u0857\u0858\3\2\2\2\u0858\u085a\7<\2\2\u0859"+
		"\u085b\5j\66\2\u085a\u0859\3\2\2\2\u085a\u085b\3\2\2\2\u085b\u085d\3\2"+
		"\2\2\u085c\u0821\3\2\2\2\u085c\u0838\3\2\2\2\u085c\u084a\3\2\2\2\u085d"+
		"\u0181\3\2\2\2\u085e\u085f\7C\2\2\u085f\u0861\7!\2\2\u0860\u0862\5\60"+
		"\31\2\u0861\u0860\3\2\2\2\u0861\u0862\3\2\2\2\u0862\u0863\3\2\2\2\u0863"+
		"\u0865\5\u0186\u00c4\2\u0864\u0866\5\u0188\u00c5\2\u0865\u0864\3\2\2\2"+
		"\u0865\u0866\3\2\2\2\u0866\u0867\3\2\2\2\u0867\u0869\7;\2\2\u0868\u086a"+
		"\5\u019e\u00d0\2\u0869\u0868\3\2\2\2\u0869\u086a\3\2\2\2\u086a\u086b\3"+
		"\2\2\2\u086b\u086d\7<\2\2\u086c\u086e\5j\66\2\u086d\u086c\3\2\2\2\u086d"+
		"\u086e\3\2\2\2\u086e\u0183\3\2\2\2\u086f\u0871\7!\2\2\u0870\u0872\5\60"+
		"\31\2\u0871\u0870\3\2\2\2\u0871\u0872\3\2\2\2\u0872\u0873\3\2\2\2\u0873"+
		"\u0878\5\u0186\u00c4\2\u0874\u0875\7C\2\2\u0875\u0877\5\u0186\u00c4\2"+
		"\u0876\u0874\3\2\2\2\u0877\u087a\3\2\2\2\u0878\u0876\3\2\2\2\u0878\u0879"+
		"\3\2\2\2\u0879\u087c\3\2\2\2\u087a\u0878\3\2\2\2\u087b\u087d\5\u0188\u00c5"+
		"\2\u087c\u087b\3\2\2\2\u087c\u087d\3\2\2\2\u087d\u087e\3\2\2\2\u087e\u0880"+
		"\7;\2\2\u087f\u0881\5\u019e\u00d0\2\u0880\u087f\3\2\2\2\u0880\u0881\3"+
		"\2\2\2\u0881\u0882\3\2\2\2\u0882\u0884\7<\2\2\u0883\u0885\5j\66\2\u0884"+
		"\u0883\3\2\2\2\u0884\u0885\3\2\2\2\u0885\u0899\3\2\2\2\u0886\u0887\5B"+
		"\"\2\u0887\u0888\7C\2\2\u0888\u088a\7!\2\2\u0889\u088b\5\60\31\2\u088a"+
		"\u0889\3\2\2\2\u088a\u088b\3\2\2\2\u088b\u088c\3\2\2\2\u088c\u088e\5\u0186"+
		"\u00c4\2\u088d\u088f\5\u0188\u00c5\2\u088e\u088d\3\2\2\2\u088e\u088f\3"+
		"\2\2\2\u088f\u0890\3\2\2\2\u0890\u0892\7;\2\2\u0891\u0893\5\u019e\u00d0"+
		"\2\u0892\u0891\3\2\2\2\u0892\u0893\3\2\2\2\u0893\u0894\3\2\2\2\u0894\u0896"+
		"\7<\2\2\u0895\u0897\5j\66\2\u0896\u0895\3\2\2\2\u0896\u0897\3\2\2\2\u0897"+
		"\u0899\3\2\2\2\u0898\u086f\3\2\2\2\u0898\u0886\3\2\2\2\u0899\u0185\3\2"+
		"\2\2\u089a\u089c\5\u00f0y\2\u089b\u089a\3\2\2\2\u089c\u089f\3\2\2\2\u089d"+
		"\u089b\3\2\2\2\u089d\u089e\3\2\2\2\u089e\u08a0\3\2\2\2\u089f\u089d\3\2"+
		"\2\2\u08a0\u08a1\7h\2\2\u08a1\u0187\3\2\2\2\u08a2\u08a6\5\60\31\2\u08a3"+
		"\u08a4\7F\2\2\u08a4\u08a6\7E\2\2\u08a5\u08a2\3\2\2\2\u08a5\u08a3\3\2\2"+
		"\2\u08a6\u0189\3\2\2\2\u08a7\u08a8\5\u016a\u00b6\2\u08a8\u08a9\7C\2\2"+
		"\u08a9\u08aa\7h\2\2\u08aa\u08b6\3\2\2\2\u08ab\u08ac\5\u0198\u00cd\2\u08ac"+
		"\u08ad\7C\2\2\u08ad\u08ae\7h\2\2\u08ae\u08b6\3\2\2\2\u08af\u08b0\5> \2"+
		"\u08b0\u08b1\7C\2\2\u08b1\u08b2\5\u0198\u00cd\2\u08b2\u08b3\7C\2\2\u08b3"+
		"\u08b4\7h\2\2\u08b4\u08b6\3\2\2\2\u08b5\u08a7\3\2\2\2\u08b5\u08ab\3\2"+
		"\2\2\u08b5\u08af\3\2\2\2\u08b6\u018b\3\2\2\2\u08b7\u08b8\7C\2\2\u08b8"+
		"\u08b9\7h\2\2\u08b9\u018d\3\2\2\2\u08ba\u08bb\5\u0198\u00cd\2\u08bb\u08bc"+
		"\7C\2\2\u08bc\u08bd\7h\2\2\u08bd\u08c5\3\2\2\2\u08be\u08bf\5> \2\u08bf"+
		"\u08c0\7C\2\2\u08c0\u08c1\5\u0198\u00cd\2\u08c1\u08c2\7C\2\2\u08c2\u08c3"+
		"\7h\2\2\u08c3\u08c5\3\2\2\2\u08c4\u08ba\3\2\2\2\u08c4\u08be\3\2\2\2\u08c5"+
		"\u018f\3\2\2\2\u08c6\u08c7\5B\"\2\u08c7\u08c8\7?\2\2\u08c8\u08c9\5\u01ae"+
		"\u00d8\2\u08c9\u08ca\7@\2\2\u08ca\u08d1\3\2\2\2\u08cb\u08cc\5\u0172\u00ba"+
		"\2\u08cc\u08cd\7?\2\2\u08cd\u08ce\5\u01ae\u00d8\2\u08ce\u08cf\7@\2\2\u08cf"+
		"\u08d1\3\2\2\2\u08d0\u08c6\3\2\2\2\u08d0\u08cb\3\2\2\2\u08d1\u08d9\3\2"+
		"\2\2\u08d2\u08d3\5\u0170\u00b9\2\u08d3\u08d4\7?\2\2\u08d4\u08d5\5\u01ae"+
		"\u00d8\2\u08d5\u08d6\7@\2\2\u08d6\u08d8\3\2\2\2\u08d7\u08d2\3\2\2\2\u08d8"+
		"\u08db\3\2\2\2\u08d9\u08d7\3\2\2\2\u08d9\u08da\3\2\2\2\u08da\u0191\3\2"+
		"\2\2\u08db\u08d9\3\2\2\2\u08dc\u08dd\5\u0178\u00bd\2\u08dd\u08de\7?\2"+
		"\2\u08de\u08df\5\u01ae\u00d8\2\u08df\u08e0\7@\2\2\u08e0\u08e8\3\2\2\2"+
		"\u08e1\u08e2\5\u0176\u00bc\2\u08e2\u08e3\7?\2\2\u08e3\u08e4\5\u01ae\u00d8"+
		"\2\u08e4\u08e5\7@\2\2\u08e5\u08e7\3\2\2\2\u08e6\u08e1\3\2\2\2\u08e7\u08ea"+
		"\3\2\2\2\u08e8\u08e6\3\2\2\2\u08e8\u08e9\3\2\2\2\u08e9\u0193\3\2\2\2\u08ea"+
		"\u08e8\3\2\2\2\u08eb\u08ec\5B\"\2\u08ec\u08ed\7?\2\2\u08ed\u08ee\5\u01ae"+
		"\u00d8\2\u08ee\u08ef\7@\2\2\u08ef\u08f6\3\2\2\2\u08f0\u08f1\5\u017e\u00c0"+
		"\2\u08f1\u08f2\7?\2\2\u08f2\u08f3\5\u01ae\u00d8\2\u08f3\u08f4\7@\2\2\u08f4"+
		"\u08f6\3\2\2\2\u08f5\u08eb\3\2\2\2\u08f5\u08f0\3\2\2\2\u08f6\u08fe\3\2"+
		"\2\2\u08f7\u08f8\5\u017c\u00bf\2\u08f8\u08f9\7?\2\2\u08f9\u08fa\5\u01ae"+
		"\u00d8\2\u08fa\u08fb\7@\2\2\u08fb\u08fd\3\2\2\2\u08fc\u08f7\3\2\2\2\u08fd"+
		"\u0900\3\2\2\2\u08fe\u08fc\3\2\2\2\u08fe\u08ff\3\2\2\2\u08ff\u0195\3\2"+
		"\2\2\u0900\u08fe\3\2\2\2\u0901\u0902\5D#\2\u0902\u0904\7;\2\2\u0903\u0905"+
		"\5\u019e\u00d0\2\u0904\u0903\3\2\2\2\u0904\u0905\3\2\2\2\u0905\u0906\3"+
		"\2\2\2\u0906\u0907\7<\2\2\u0907\u0947\3\2\2\2\u0908\u0909\5> \2\u0909"+
		"\u090b\7C\2\2\u090a\u090c\5\60\31\2\u090b\u090a\3\2\2\2\u090b\u090c\3"+
		"\2\2\2\u090c\u090d\3\2\2\2\u090d\u090e\7h\2\2\u090e\u0910\7;\2\2\u090f"+
		"\u0911\5\u019e\u00d0\2\u0910\u090f\3\2\2\2\u0910\u0911\3\2\2\2\u0911\u0912"+
		"\3\2\2\2\u0912\u0913\7<\2\2\u0913\u0947\3\2\2\2\u0914\u0915\5B\"\2\u0915"+
		"\u0917\7C\2\2\u0916\u0918\5\60\31\2\u0917\u0916\3\2\2\2\u0917\u0918\3"+
		"\2\2\2\u0918\u0919\3\2\2\2\u0919\u091a\7h\2\2\u091a\u091c\7;\2\2\u091b"+
		"\u091d\5\u019e\u00d0\2\u091c\u091b\3\2\2\2\u091c\u091d\3\2\2\2\u091d\u091e"+
		"\3\2\2\2\u091e\u091f\7<\2\2\u091f\u0947\3\2\2\2\u0920\u0921\5\u016a\u00b6"+
		"\2\u0921\u0923\7C\2\2\u0922\u0924\5\60\31\2\u0923\u0922\3\2\2\2\u0923"+
		"\u0924\3\2\2\2\u0924\u0925\3\2\2\2\u0925\u0926\7h\2\2\u0926\u0928\7;\2"+
		"\2\u0927\u0929\5\u019e\u00d0\2\u0928\u0927\3\2\2\2\u0928\u0929\3\2\2\2"+
		"\u0929\u092a\3\2\2\2\u092a\u092b\7<\2\2\u092b\u0947\3\2\2\2\u092c\u092d"+
		"\5\u0198\u00cd\2\u092d\u092f\7C\2\2\u092e\u0930\5\60\31\2\u092f\u092e"+
		"\3\2\2\2\u092f\u0930\3\2\2\2\u0930\u0931\3\2\2\2\u0931\u0932\7h\2\2\u0932"+
		"\u0934\7;\2\2\u0933\u0935\5\u019e\u00d0\2\u0934\u0933\3\2\2\2\u0934\u0935"+
		"\3\2\2\2\u0935\u0936\3\2\2\2\u0936\u0937\7<\2\2\u0937\u0947\3\2\2\2\u0938"+
		"\u0939\5> \2\u0939\u093a\7C\2\2\u093a\u093b\5\u0198\u00cd\2\u093b\u093d"+
		"\7C\2\2\u093c\u093e\5\60\31\2\u093d\u093c\3\2\2\2\u093d\u093e\3\2\2\2"+
		"\u093e\u093f\3\2\2\2\u093f\u0940\7h\2\2\u0940\u0942\7;\2\2\u0941\u0943"+
		"\5\u019e\u00d0\2\u0942\u0941\3\2\2\2\u0942\u0943\3\2\2\2\u0943\u0944\3"+
		"\2\2\2\u0944\u0945\7<\2\2\u0945\u0947\3\2\2\2\u0946\u0901\3\2\2\2\u0946"+
		"\u0908\3\2\2\2\u0946\u0914\3\2\2\2\u0946\u0920\3\2\2\2\u0946\u092c\3\2"+
		"\2\2\u0946\u0938\3\2\2\2\u0947\u0197\3\2\2\2\u0948\u0949\7*\2\2\u0949"+
		"\u0199\3\2\2\2\u094a\u094c\7C\2\2\u094b\u094d\5\60\31\2\u094c\u094b\3"+
		"\2\2\2\u094c\u094d\3\2\2\2\u094d\u094e\3\2\2\2\u094e\u094f\7h\2\2\u094f"+
		"\u0951\7;\2\2\u0950\u0952\5\u019e\u00d0\2\u0951\u0950\3\2\2\2\u0951\u0952"+
		"\3\2\2\2\u0952\u0953\3\2\2\2\u0953\u0954\7<\2\2\u0954\u019b\3\2\2\2\u0955"+
		"\u0956\5D#\2\u0956\u0958\7;\2\2\u0957\u0959\5\u019e\u00d0\2\u0958\u0957"+
		"\3\2\2\2\u0958\u0959\3\2\2\2\u0959\u095a\3\2\2\2\u095a\u095b\7<\2\2\u095b"+
		"\u098e\3\2\2\2\u095c\u095d\5> \2\u095d\u095f\7C\2\2\u095e\u0960\5\60\31"+
		"\2\u095f\u095e\3\2\2\2\u095f\u0960\3\2\2\2\u0960\u0961\3\2\2\2\u0961\u0962"+
		"\7h\2\2\u0962\u0964\7;\2\2\u0963\u0965\5\u019e\u00d0\2\u0964\u0963\3\2"+
		"\2\2\u0964\u0965\3\2\2\2\u0965\u0966\3\2\2\2\u0966\u0967\7<\2\2\u0967"+
		"\u098e\3\2\2\2\u0968\u0969\5B\"\2\u0969\u096b\7C\2\2\u096a\u096c\5\60"+
		"\31\2\u096b\u096a\3\2\2\2\u096b\u096c\3\2\2\2\u096c\u096d\3\2\2\2\u096d"+
		"\u096e\7h\2\2\u096e\u0970\7;\2\2\u096f\u0971\5\u019e\u00d0\2\u0970\u096f"+
		"\3\2\2\2\u0970\u0971\3\2\2\2\u0971\u0972\3\2\2\2\u0972\u0973\7<\2\2\u0973"+
		"\u098e\3\2\2\2\u0974\u0975\7*\2\2\u0975\u0977\7C\2\2\u0976\u0978\5\60"+
		"\31";
	private static final String _serializedATNSegment1 =
		"\2\u0977\u0976\3\2\2\2\u0977\u0978\3\2\2\2\u0978\u0979\3\2\2\2\u0979\u097a"+
		"\7h\2\2\u097a\u097c\7;\2\2\u097b\u097d\5\u019e\u00d0\2\u097c\u097b\3\2"+
		"\2\2\u097c\u097d\3\2\2\2\u097d\u097e\3\2\2\2\u097e\u098e\7<\2\2\u097f"+
		"\u0980\5> \2\u0980\u0981\7C\2\2\u0981\u0982\7*\2\2\u0982\u0984\7C\2\2"+
		"\u0983\u0985\5\60\31\2\u0984\u0983\3\2\2\2\u0984\u0985\3\2\2\2\u0985\u0986"+
		"\3\2\2\2\u0986\u0987\7h\2\2\u0987\u0989\7;\2\2\u0988\u098a\5\u019e\u00d0"+
		"\2\u0989\u0988\3\2\2\2\u0989\u098a\3\2\2\2\u098a\u098b\3\2\2\2\u098b\u098c"+
		"\7<\2\2\u098c\u098e\3\2\2\2\u098d\u0955\3\2\2\2\u098d\u095c\3\2\2\2\u098d"+
		"\u0968\3\2\2\2\u098d\u0974\3\2\2\2\u098d\u097f\3\2\2\2\u098e\u019d\3\2"+
		"\2\2\u098f\u0994\5\u01ae\u00d8\2\u0990\u0991\7B\2\2\u0991\u0993\5\u01ae"+
		"\u00d8\2\u0992\u0990\3\2\2\2\u0993\u0996\3\2\2\2\u0994\u0992\3\2\2\2\u0994"+
		"\u0995\3\2\2\2\u0995\u019f\3\2\2\2\u0996\u0994\3\2\2\2\u0997\u0998\5B"+
		"\"\2\u0998\u099a\7\\\2\2\u0999\u099b\5\60\31\2\u099a\u0999\3\2\2\2\u099a"+
		"\u099b\3\2\2\2\u099b\u099c\3\2\2\2\u099c\u099d\7h\2\2\u099d\u09c7\3\2"+
		"\2\2\u099e\u099f\5\f\7\2\u099f\u09a1\7\\\2\2\u09a0\u09a2\5\60\31\2\u09a1"+
		"\u09a0\3\2\2\2\u09a1\u09a2\3\2\2\2\u09a2\u09a3\3\2\2\2\u09a3\u09a4\7h"+
		"\2\2\u09a4\u09c7\3\2\2\2\u09a5\u09a6\5\u016a\u00b6\2\u09a6\u09a8\7\\\2"+
		"\2\u09a7\u09a9\5\60\31\2\u09a8\u09a7\3\2\2\2\u09a8\u09a9\3\2\2\2\u09a9"+
		"\u09aa\3\2\2\2\u09aa\u09ab\7h\2\2\u09ab\u09c7\3\2\2\2\u09ac\u09ad\7*\2"+
		"\2\u09ad\u09af\7\\\2\2\u09ae\u09b0\5\60\31\2\u09af\u09ae\3\2\2\2\u09af"+
		"\u09b0\3\2\2\2\u09b0\u09b1\3\2\2\2\u09b1\u09c7\7h\2\2\u09b2\u09b3\5> "+
		"\2\u09b3\u09b4\7C\2\2\u09b4\u09b5\7*\2\2\u09b5\u09b7\7\\\2\2\u09b6\u09b8"+
		"\5\60\31\2\u09b7\u09b6\3\2\2\2\u09b7\u09b8\3\2\2\2\u09b8\u09b9\3\2\2\2"+
		"\u09b9\u09ba\7h\2\2\u09ba\u09c7\3\2\2\2\u09bb\u09bc\5\22\n\2\u09bc\u09be"+
		"\7\\\2\2\u09bd\u09bf\5\60\31\2\u09be\u09bd\3\2\2\2\u09be\u09bf\3\2\2\2"+
		"\u09bf\u09c0\3\2\2\2\u09c0\u09c1\7!\2\2\u09c1\u09c7\3\2\2\2\u09c2\u09c3"+
		"\5 \21\2\u09c3\u09c4\7\\\2\2\u09c4\u09c5\7!\2\2\u09c5\u09c7\3\2\2\2\u09c6"+
		"\u0997\3\2\2\2\u09c6\u099e\3\2\2\2\u09c6\u09a5\3\2\2\2\u09c6\u09ac\3\2"+
		"\2\2\u09c6\u09b2\3\2\2\2\u09c6\u09bb\3\2\2\2\u09c6\u09c2\3\2\2\2\u09c7"+
		"\u01a1\3\2\2\2\u09c8\u09ca\7\\\2\2\u09c9\u09cb\5\60\31\2\u09ca\u09c9\3"+
		"\2\2\2\u09ca\u09cb\3\2\2\2\u09cb\u09cc\3\2\2\2\u09cc\u09cd\7h\2\2\u09cd"+
		"\u01a3\3\2\2\2\u09ce\u09cf\5B\"\2\u09cf\u09d1\7\\\2\2\u09d0\u09d2\5\60"+
		"\31\2\u09d1\u09d0\3\2\2\2\u09d1\u09d2\3\2\2\2\u09d2\u09d3\3\2\2\2\u09d3"+
		"\u09d4\7h\2\2\u09d4\u09f7\3\2\2\2\u09d5\u09d6\5\f\7\2\u09d6\u09d8\7\\"+
		"\2\2\u09d7\u09d9\5\60\31\2\u09d8\u09d7\3\2\2\2\u09d8\u09d9\3\2\2\2\u09d9"+
		"\u09da\3\2\2\2\u09da\u09db\7h\2\2\u09db\u09f7\3\2\2\2\u09dc\u09dd\7*\2"+
		"\2\u09dd\u09df\7\\\2\2\u09de\u09e0\5\60\31\2\u09df\u09de\3\2\2\2\u09df"+
		"\u09e0\3\2\2\2\u09e0\u09e1\3\2\2\2\u09e1\u09f7\7h\2\2\u09e2\u09e3\5> "+
		"\2\u09e3\u09e4\7C\2\2\u09e4\u09e5\7*\2\2\u09e5\u09e7\7\\\2\2\u09e6\u09e8"+
		"\5\60\31\2\u09e7\u09e6\3\2\2\2\u09e7\u09e8\3\2\2\2\u09e8\u09e9\3\2\2\2"+
		"\u09e9\u09ea\7h\2\2\u09ea\u09f7\3\2\2\2\u09eb\u09ec\5\22\n\2\u09ec\u09ee"+
		"\7\\\2\2\u09ed\u09ef\5\60\31\2\u09ee\u09ed\3\2\2\2\u09ee\u09ef\3\2\2\2"+
		"\u09ef\u09f0\3\2\2\2\u09f0\u09f1\7!\2\2\u09f1\u09f7\3\2\2\2\u09f2\u09f3"+
		"\5 \21\2\u09f3\u09f4\7\\\2\2\u09f4\u09f5\7!\2\2\u09f5\u09f7\3\2\2\2\u09f6"+
		"\u09ce\3\2\2\2\u09f6\u09d5\3\2\2\2\u09f6\u09dc\3\2\2\2\u09f6\u09e2\3\2"+
		"\2\2\u09f6\u09eb\3\2\2\2\u09f6\u09f2\3\2\2\2\u09f7\u01a5\3\2\2\2\u09f8"+
		"\u09f9\7!\2\2\u09f9\u09fa\5\4\3\2\u09fa\u09fc\5\u01a8\u00d5\2\u09fb\u09fd"+
		"\5\"\22\2\u09fc\u09fb\3\2\2\2\u09fc\u09fd\3\2\2\2\u09fd\u0a0f\3\2\2\2"+
		"\u09fe\u09ff\7!\2\2\u09ff\u0a00\5\16\b\2\u0a00\u0a02\5\u01a8\u00d5\2\u0a01"+
		"\u0a03\5\"\22\2\u0a02\u0a01\3\2\2\2\u0a02\u0a03\3\2\2\2\u0a03\u0a0f\3"+
		"\2\2\2\u0a04\u0a05\7!\2\2\u0a05\u0a06\5\4\3\2\u0a06\u0a07\5\"\22\2\u0a07"+
		"\u0a08\5\u0102\u0082\2\u0a08\u0a0f\3\2\2\2\u0a09\u0a0a\7!\2\2\u0a0a\u0a0b"+
		"\5\16\b\2\u0a0b\u0a0c\5\"\22\2\u0a0c\u0a0d\5\u0102\u0082\2\u0a0d\u0a0f"+
		"\3\2\2\2\u0a0e\u09f8\3\2\2\2\u0a0e\u09fe\3\2\2\2\u0a0e\u0a04\3\2\2\2\u0a0e"+
		"\u0a09\3\2\2\2\u0a0f\u01a7\3\2\2\2\u0a10\u0a14\5\u01aa\u00d6\2\u0a11\u0a13"+
		"\5\u01aa\u00d6\2\u0a12\u0a11\3\2\2\2\u0a13\u0a16\3\2\2\2\u0a14\u0a12\3"+
		"\2\2\2\u0a14\u0a15\3\2\2\2\u0a15\u01a9\3\2\2\2\u0a16\u0a14\3\2\2\2\u0a17"+
		"\u0a19\5\u00f0y\2\u0a18\u0a17\3\2\2\2\u0a19\u0a1c\3\2\2\2\u0a1a\u0a18"+
		"\3\2\2\2\u0a1a\u0a1b\3\2\2\2\u0a1b\u0a1d\3\2\2\2\u0a1c\u0a1a\3\2\2\2\u0a1d"+
		"\u0a1e\7?\2\2\u0a1e\u0a1f\5\u01ae\u00d8\2\u0a1f\u0a20\7@\2\2\u0a20\u01ab"+
		"\3\2\2\2\u0a21\u0a22\5\u01ae\u00d8\2\u0a22\u01ad\3\2\2\2\u0a23\u0a26\5"+
		"\u01b0\u00d9\2\u0a24\u0a26\5\u01b8\u00dd\2\u0a25\u0a23\3\2\2\2\u0a25\u0a24"+
		"\3\2\2\2\u0a26\u01af\3\2\2\2\u0a27\u0a28\5\u01b2\u00da\2\u0a28\u0a29\7"+
		"[\2\2\u0a29\u0a2a\5\u01b6\u00dc\2\u0a2a\u01b1\3\2\2\2\u0a2b\u0a36\7h\2"+
		"\2\u0a2c\u0a2e\7;\2\2\u0a2d\u0a2f\5\u00a0Q\2\u0a2e\u0a2d\3\2\2\2\u0a2e"+
		"\u0a2f\3\2\2\2\u0a2f\u0a30\3\2\2\2\u0a30\u0a36\7<\2\2\u0a31\u0a32\7;\2"+
		"\2\u0a32\u0a33\5\u01b4\u00db\2\u0a33\u0a34\7<\2\2\u0a34\u0a36\3\2\2\2"+
		"\u0a35\u0a2b\3\2\2\2\u0a35\u0a2c\3\2\2\2\u0a35\u0a31\3\2\2\2\u0a36\u01b3"+
		"\3\2\2\2\u0a37\u0a3c\7h\2\2\u0a38\u0a39\7B\2\2\u0a39\u0a3b\7h\2\2\u0a3a"+
		"\u0a38\3\2\2\2\u0a3b\u0a3e\3\2\2\2\u0a3c\u0a3a\3\2\2\2\u0a3c\u0a3d\3\2"+
		"\2\2\u0a3d\u01b5\3\2\2\2\u0a3e\u0a3c\3\2\2\2\u0a3f\u0a42\5\u01ae\u00d8"+
		"\2\u0a40\u0a42\5\u0106\u0084\2\u0a41\u0a3f\3\2\2\2\u0a41\u0a40\3\2\2\2"+
		"\u0a42\u01b7\3\2\2\2\u0a43\u0a46\5\u01c0\u00e1\2\u0a44\u0a46\5\u01ba\u00de"+
		"\2\u0a45\u0a43\3\2\2\2\u0a45\u0a44\3\2\2\2\u0a46\u01b9\3\2\2\2\u0a47\u0a48"+
		"\5\u01bc\u00df\2\u0a48\u0a49\5\u01be\u00e0\2\u0a49\u0a4a\5\u01ae\u00d8"+
		"\2\u0a4a\u01bb\3\2\2\2\u0a4b\u0a4f\5B\"\2\u0a4c\u0a4f\5\u018a\u00c6\2"+
		"\u0a4d\u0a4f\5\u0190\u00c9\2\u0a4e\u0a4b\3\2\2\2\u0a4e\u0a4c\3\2\2\2\u0a4e"+
		"\u0a4d\3\2\2\2\u0a4f\u01bd\3\2\2\2\u0a50\u0a51\t\5\2\2\u0a51\u01bf\3\2"+
		"\2\2\u0a52\u0a5a\5\u01c2\u00e2\2\u0a53\u0a54\5\u01c2\u00e2\2\u0a54\u0a55"+
		"\7I\2\2\u0a55\u0a56\5\u01ae\u00d8\2\u0a56\u0a57\7J\2\2\u0a57\u0a58\5\u01c0"+
		"\u00e1\2\u0a58\u0a5a\3\2\2\2\u0a59\u0a52\3\2\2\2\u0a59\u0a53\3\2\2\2\u0a5a"+
		"\u01c1\3\2\2\2\u0a5b\u0a5c\b\u00e2\1\2\u0a5c\u0a5d\5\u01c4\u00e3\2\u0a5d"+
		"\u0a63\3\2\2\2\u0a5e\u0a5f\f\3\2\2\u0a5f\u0a60\7P\2\2\u0a60\u0a62\5\u01c4"+
		"\u00e3\2\u0a61\u0a5e\3\2\2\2\u0a62\u0a65\3\2\2\2\u0a63\u0a61\3\2\2\2\u0a63"+
		"\u0a64\3\2\2\2\u0a64\u01c3\3\2\2\2\u0a65\u0a63\3\2\2\2\u0a66\u0a67\b\u00e3"+
		"\1\2\u0a67\u0a68\5\u01c6\u00e4\2\u0a68\u0a6e\3\2\2\2\u0a69\u0a6a\f\3\2"+
		"\2\u0a6a\u0a6b\7O\2\2\u0a6b\u0a6d\5\u01c6\u00e4\2\u0a6c\u0a69\3\2\2\2"+
		"\u0a6d\u0a70\3\2\2\2\u0a6e\u0a6c\3\2\2\2\u0a6e\u0a6f\3\2\2\2\u0a6f\u01c5"+
		"\3\2\2\2\u0a70\u0a6e\3\2\2\2\u0a71\u0a72\b\u00e4\1\2\u0a72\u0a73\5\u01c8"+
		"\u00e5\2\u0a73\u0a79\3\2\2\2\u0a74\u0a75\f\3\2\2\u0a75\u0a76\7X\2\2\u0a76"+
		"\u0a78\5\u01c8\u00e5\2\u0a77\u0a74\3\2\2\2\u0a78\u0a7b\3\2\2\2\u0a79\u0a77"+
		"\3\2\2\2\u0a79\u0a7a\3\2\2\2\u0a7a\u01c7\3\2\2\2\u0a7b\u0a79\3\2\2\2\u0a7c"+
		"\u0a7d\b\u00e5\1\2\u0a7d\u0a7e\5\u01ca\u00e6\2\u0a7e\u0a84\3\2\2\2\u0a7f"+
		"\u0a80\f\3\2\2\u0a80\u0a81\7Y\2\2\u0a81\u0a83\5\u01ca\u00e6\2\u0a82\u0a7f"+
		"\3\2\2\2\u0a83\u0a86\3\2\2\2\u0a84\u0a82\3\2\2\2\u0a84\u0a85\3\2\2\2\u0a85"+
		"\u01c9\3\2\2\2\u0a86\u0a84\3\2\2\2\u0a87\u0a88\b\u00e6\1\2\u0a88\u0a89"+
		"\5\u01cc\u00e7\2\u0a89\u0a8f\3\2\2\2\u0a8a\u0a8b\f\3\2\2\u0a8b\u0a8c\7"+
		"W\2\2\u0a8c\u0a8e\5\u01cc\u00e7\2\u0a8d\u0a8a\3\2\2\2\u0a8e\u0a91\3\2"+
		"\2\2\u0a8f\u0a8d\3\2\2\2\u0a8f\u0a90\3\2\2\2\u0a90\u01cb\3\2\2\2\u0a91"+
		"\u0a8f\3\2\2\2\u0a92\u0a93\b\u00e7\1\2\u0a93\u0a94\5\u01d2\u00ea\2\u0a94"+
		"\u0a9f\3\2\2\2\u0a95\u0a96\f\4\2\2\u0a96\u0a97\5\u01ce\u00e8\2\u0a97\u0a98"+
		"\5\u01d2\u00ea\2\u0a98\u0a9e\3\2\2\2\u0a99\u0a9a\f\3\2\2\u0a9a\u0a9b\5"+
		"\u01d0\u00e9\2\u0a9b\u0a9c\5\u01d2\u00ea\2\u0a9c\u0a9e\3\2\2\2\u0a9d\u0a95"+
		"\3\2\2\2\u0a9d\u0a99\3\2\2\2\u0a9e\u0aa1\3\2\2\2\u0a9f\u0a9d\3\2\2\2\u0a9f"+
		"\u0aa0\3\2\2\2\u0aa0\u01cd\3\2\2\2\u0aa1\u0a9f\3\2\2\2\u0aa2\u0aa3\7K"+
		"\2\2\u0aa3\u01cf\3\2\2\2\u0aa4\u0aa5\7N\2\2\u0aa5\u01d1\3\2\2\2\u0aa6"+
		"\u0aa7\b\u00ea\1\2\u0aa7\u0aa8\5\u01de\u00f0\2\u0aa8\u0abf\3\2\2\2\u0aa9"+
		"\u0aaa\f\7\2\2\u0aaa\u0aab\5\u01d4\u00eb\2\u0aab\u0aac\5\u01de\u00f0\2"+
		"\u0aac\u0abe\3\2\2\2\u0aad\u0aae\f\6\2\2\u0aae\u0aaf\5\u01d6\u00ec\2\u0aaf"+
		"\u0ab0\5\u01de\u00f0\2\u0ab0\u0abe\3\2\2\2\u0ab1\u0ab2\f\5\2\2\u0ab2\u0ab3"+
		"\5\u01d8\u00ed\2\u0ab3\u0ab4\5\u01de\u00f0\2\u0ab4\u0abe\3\2\2\2\u0ab5"+
		"\u0ab6\f\4\2\2\u0ab6\u0ab7\5\u01da\u00ee\2\u0ab7\u0ab8\5\u01de\u00f0\2"+
		"\u0ab8\u0abe\3\2\2\2\u0ab9\u0aba\f\3\2\2\u0aba\u0abb\5\u01dc\u00ef\2\u0abb"+
		"\u0abc\5\f\7\2\u0abc\u0abe\3\2\2\2\u0abd\u0aa9\3\2\2\2\u0abd\u0aad\3\2"+
		"\2\2\u0abd\u0ab1\3\2\2\2\u0abd\u0ab5\3\2\2\2\u0abd\u0ab9\3\2\2\2\u0abe"+
		"\u0ac1\3\2\2\2\u0abf\u0abd\3\2\2\2\u0abf\u0ac0\3\2\2\2\u0ac0\u01d3\3\2"+
		"\2\2\u0ac1\u0abf\3\2\2\2\u0ac2\u0ac3\7F\2\2\u0ac3\u01d5\3\2\2\2\u0ac4"+
		"\u0ac5\7E\2\2\u0ac5\u01d7\3\2\2\2\u0ac6\u0ac7\7L\2\2\u0ac7\u01d9\3\2\2"+
		"\2\u0ac8\u0ac9\7M\2\2\u0ac9\u01db\3\2\2\2\u0aca\u0acb\7\34\2\2\u0acb\u01dd"+
		"\3\2\2\2\u0acc\u0acd\b\u00f0\1\2\u0acd\u0ace\5\u01e6\u00f4\2\u0ace\u0add"+
		"\3\2\2\2\u0acf\u0ad0\f\5\2\2\u0ad0\u0ad1\5\u01e0\u00f1\2\u0ad1\u0ad2\5"+
		"\u01e6\u00f4\2\u0ad2\u0adc\3\2\2\2\u0ad3\u0ad4\f\4\2\2\u0ad4\u0ad5\5\u01e2"+
		"\u00f2\2\u0ad5\u0ad6\5\u01e6\u00f4\2\u0ad6\u0adc\3\2\2\2\u0ad7\u0ad8\f"+
		"\3\2\2\u0ad8\u0ad9\5\u01e4\u00f3\2\u0ad9\u0ada\5\u01e6\u00f4\2\u0ada\u0adc"+
		"\3\2\2\2\u0adb\u0acf\3\2\2\2\u0adb\u0ad3\3\2\2\2\u0adb\u0ad7\3\2\2\2\u0adc"+
		"\u0adf\3\2\2\2\u0add\u0adb\3\2\2\2\u0add\u0ade\3\2\2\2\u0ade\u01df\3\2"+
		"\2\2\u0adf\u0add\3\2\2\2\u0ae0\u0ae1\7F\2\2\u0ae1\u0ae2\7F\2\2\u0ae2\u01e1"+
		"\3\2\2\2\u0ae3\u0ae4\7E\2\2\u0ae4\u0ae5\7E\2\2\u0ae5\u01e3\3\2\2\2\u0ae6"+
		"\u0ae7\7E\2\2\u0ae7\u0ae8\7E\2\2\u0ae8\u0ae9\7E\2\2\u0ae9\u01e5\3\2\2"+
		"\2\u0aea\u0aeb\b\u00f4\1\2\u0aeb\u0aec\5\u01ec\u00f7\2\u0aec\u0af7\3\2"+
		"\2\2\u0aed\u0aee\f\4\2\2\u0aee\u0aef\5\u01e8\u00f5\2\u0aef\u0af0\5\u01ec"+
		"\u00f7\2\u0af0\u0af6\3\2\2\2\u0af1\u0af2\f\3\2\2\u0af2\u0af3\5\u01ea\u00f6"+
		"\2\u0af3\u0af4\5\u01ec\u00f7\2\u0af4\u0af6\3\2\2\2\u0af5\u0aed\3\2\2\2"+
		"\u0af5\u0af1\3\2\2\2\u0af6\u0af9\3\2\2\2\u0af7\u0af5\3\2\2\2\u0af7\u0af8"+
		"\3\2\2\2\u0af8\u01e7\3\2\2\2\u0af9\u0af7\3\2\2\2\u0afa\u0afb\7S\2\2\u0afb"+
		"\u01e9\3\2\2\2\u0afc\u0afd\7T\2\2\u0afd\u01eb\3\2\2\2\u0afe\u0aff\b\u00f7"+
		"\1\2\u0aff\u0b00\5\u01f4\u00fb\2\u0b00\u0b0f\3\2\2\2\u0b01\u0b02\f\5\2"+
		"\2\u0b02\u0b03\5\u01ee\u00f8\2\u0b03\u0b04\5\u01f4\u00fb\2\u0b04\u0b0e"+
		"\3\2\2\2\u0b05\u0b06\f\4\2\2\u0b06\u0b07\5\u01f0\u00f9\2\u0b07\u0b08\5"+
		"\u01f4\u00fb\2\u0b08\u0b0e\3\2\2\2\u0b09\u0b0a\f\3\2\2\u0b0a\u0b0b\5\u01f2"+
		"\u00fa\2\u0b0b\u0b0c\5\u01f4\u00fb\2\u0b0c\u0b0e\3\2\2\2\u0b0d\u0b01\3"+
		"\2\2\2\u0b0d\u0b05\3\2\2\2\u0b0d\u0b09\3\2\2\2\u0b0e\u0b11\3\2\2\2\u0b0f"+
		"\u0b0d\3\2\2\2\u0b0f\u0b10\3\2\2\2\u0b10\u01ed\3\2\2\2\u0b11\u0b0f\3\2"+
		"\2\2\u0b12\u0b13\7U\2\2\u0b13\u01ef\3\2\2\2\u0b14\u0b15\7V\2\2\u0b15\u01f1"+
		"\3\2\2\2\u0b16\u0b17\7V\2\2\u0b17\u01f3\3\2\2\2\u0b18\u0b22\5\u01fa\u00fe"+
		"\2\u0b19\u0b22\5\u01fc\u00ff\2\u0b1a\u0b1b\5\u01f6\u00fc\2\u0b1b\u0b1c"+
		"\5\u01f4\u00fb\2\u0b1c\u0b22\3\2\2\2\u0b1d\u0b1e\5\u01f8\u00fd\2\u0b1e"+
		"\u0b1f\5\u01f4\u00fb\2\u0b1f\u0b22\3\2\2\2\u0b20\u0b22\5\u01fe\u0100\2"+
		"\u0b21\u0b18\3\2\2\2\u0b21\u0b19\3\2\2\2\u0b21\u0b1a\3\2\2\2\u0b21\u0b1d"+
		"\3\2\2\2\u0b21\u0b20\3\2\2\2\u0b22\u01f5\3\2\2\2\u0b23\u0b24\7S\2\2\u0b24"+
		"\u01f7\3\2\2\2\u0b25\u0b26\7T\2\2\u0b26\u01f9\3\2\2\2\u0b27\u0b28\7Q\2"+
		"\2\u0b28\u0b29\5\u01f4\u00fb\2\u0b29\u01fb\3\2\2\2\u0b2a\u0b2b\7R\2\2"+
		"\u0b2b\u0b2c\5\u01f4\u00fb\2\u0b2c\u01fd\3\2\2\2\u0b2d\u0b36\5\u0204\u0103"+
		"\2\u0b2e\u0b2f\5\u0200\u0101\2\u0b2f\u0b30\5\u01f4\u00fb\2\u0b30\u0b36"+
		"\3\2\2\2\u0b31\u0b32\5\u0202\u0102\2\u0b32\u0b33\5\u01f4\u00fb\2\u0b33"+
		"\u0b36\3\2\2\2\u0b34\u0b36\5\u0210\u0109\2\u0b35\u0b2d\3\2\2\2\u0b35\u0b2e"+
		"\3\2\2\2\u0b35\u0b31\3\2\2\2\u0b35\u0b34\3\2\2\2\u0b36\u01ff\3\2\2\2\u0b37"+
		"\u0b38\7H\2\2\u0b38\u0201\3\2\2\2\u0b39\u0b3a\7G\2\2\u0b3a\u0203\3\2\2"+
		"\2\u0b3b\u0b3e\5\u016a\u00b6\2\u0b3c\u0b3e\5B\"\2\u0b3d\u0b3b\3\2\2\2"+
		"\u0b3d\u0b3c\3\2\2\2\u0b3e\u0b42\3\2\2\2\u0b3f\u0b41\5\u0206\u0104\2\u0b40"+
		"\u0b3f\3\2\2\2\u0b41\u0b44\3\2\2\2\u0b42\u0b40\3\2\2\2\u0b42\u0b43\3\2"+
		"\2\2\u0b43\u0205\3\2\2\2\u0b44\u0b42\3\2\2\2\u0b45\u0b48\5\u020a\u0106"+
		"\2\u0b46\u0b48\5\u020e\u0108\2\u0b47\u0b45\3\2\2\2\u0b47\u0b46\3\2\2\2"+
		"\u0b48\u0207\3\2\2\2\u0b49\u0b4a\5\u0204\u0103\2\u0b4a\u0b4b\7Q\2\2\u0b4b"+
		"\u0209\3\2\2\2\u0b4c\u0b4d\7Q\2\2\u0b4d\u020b\3\2\2\2\u0b4e\u0b4f\5\u0204"+
		"\u0103\2\u0b4f\u0b50\7R\2\2\u0b50\u020d\3\2\2\2\u0b51\u0b52\7R\2\2\u0b52"+
		"\u020f\3\2\2\2\u0b53\u0b54\7;\2\2\u0b54\u0b55\5\4\3\2\u0b55\u0b56\7<\2"+
		"\2\u0b56\u0b57\5\u01f4\u00fb\2\u0b57\u0b6f\3\2\2\2\u0b58\u0b59\7;\2\2"+
		"\u0b59\u0b5d\5\f\7\2\u0b5a\u0b5c\5.\30\2\u0b5b\u0b5a\3\2\2\2\u0b5c\u0b5f"+
		"\3\2\2\2\u0b5d\u0b5b\3\2\2\2\u0b5d\u0b5e\3\2\2\2\u0b5e\u0b60\3\2\2\2\u0b5f"+
		"\u0b5d\3\2\2\2\u0b60\u0b61\7<\2\2\u0b61\u0b62\5\u01fe\u0100\2\u0b62\u0b6f"+
		"\3\2\2\2\u0b63\u0b64\7;\2\2\u0b64\u0b68\5\f\7\2\u0b65\u0b67\5.\30\2\u0b66"+
		"\u0b65\3\2\2\2\u0b67\u0b6a\3\2\2\2\u0b68\u0b66\3\2\2\2\u0b68\u0b69\3\2"+
		"\2\2\u0b69\u0b6b\3\2\2\2\u0b6a\u0b68\3\2\2\2\u0b6b\u0b6c\7<\2\2\u0b6c"+
		"\u0b6d\5\u01b0\u00d9\2\u0b6d\u0b6f\3\2\2\2\u0b6e\u0b53\3\2\2\2\u0b6e\u0b58"+
		"\3\2\2\2\u0b6e\u0b63\3\2\2\2\u0b6f\u0211\3\2\2\2\u013c\u0217\u021e\u0222"+
		"\u0226\u022f\u0233\u0238\u023d\u0242\u0247\u024e\u0253\u0255\u025b\u0260"+
		"\u0265\u026a\u0275\u0283\u0289\u028f\u029a\u029f\u02aa\u02ad\u02bb\u02c0"+
		"\u02c5\u02ca\u02cf\u02dc\u02e4\u02ee\u02f6\u0302\u0306\u030b\u0311\u0319"+
		"\u0326\u0343\u0347\u034c\u0352\u0355\u0358\u0364\u036f\u037d\u0384\u038d"+
		"\u0394\u0399\u03a8\u03af\u03b5\u03b9\u03bd\u03c1\u03c5\u03ca\u03ce\u03d3"+
		"\u03d8\u03dc\u03e3\u03e8\u03ea\u03f0\u03f5\u03f9\u040c\u0411\u0421\u0426"+
		"\u042c\u0432\u0434\u0438\u043d\u0441\u0449\u0450\u0458\u045b\u0460\u0468"+
		"\u046d\u0474\u047b\u0480\u0486\u0492\u0497\u049b\u04a5\u04aa\u04b2\u04b5"+
		"\u04ba\u04c2\u04c5\u04ca\u04cf\u04d4\u04d9\u04e1\u04e6\u04ee\u04f3\u04f8"+
		"\u04fd\u0503\u0509\u050c\u050f\u0518\u051e\u0524\u0527\u052a\u0532\u0537"+
		"\u053c\u0542\u0545\u0550\u0559\u0563\u0568\u0573\u0578\u0584\u0589\u0595"+
		"\u059f\u05a4\u05ac\u05af\u05b6\u05be\u05c4\u05cd\u05d7\u05db\u05de\u05e7"+
		"\u05f5\u05f8\u0601\u0606\u060d\u0612\u061a\u0626\u062d\u063b\u0651\u0673"+
		"\u067f\u0685\u0691\u069e\u06b8\u06bc\u06c1\u06c5\u06c9\u06d1\u06d5\u06d9"+
		"\u06e0\u06e9\u06f1\u0700\u070c\u0712\u0718\u072d\u0732\u0738\u0744\u074f"+
		"\u0759\u075c\u0761\u076a\u0770\u077a\u077f\u0787\u079e\u07a9\u07bf\u07c6"+
		"\u07ce\u07d5\u07df\u07f6\u07ff\u0809\u081f\u0823\u082a\u082e\u0832\u0836"+
		"\u083c\u0840\u0844\u0848\u084e\u0852\u0856\u085a\u085c\u0861\u0865\u0869"+
		"\u086d\u0871\u0878\u087c\u0880\u0884\u088a\u088e\u0892\u0896\u0898\u089d"+
		"\u08a5\u08b5\u08c4\u08d0\u08d9\u08e8\u08f5\u08fe\u0904\u090b\u0910\u0917"+
		"\u091c\u0923\u0928\u092f\u0934\u093d\u0942\u0946\u094c\u0951\u0958\u095f"+
		"\u0964\u096b\u0970\u0977\u097c\u0984\u0989\u098d\u0994\u099a\u09a1\u09a8"+
		"\u09af\u09b7\u09be\u09c6\u09ca\u09d1\u09d8\u09df\u09e7\u09ee\u09f6\u09fc"+
		"\u0a02\u0a0e\u0a14\u0a1a\u0a25\u0a2e\u0a35\u0a3c\u0a41\u0a45\u0a4e\u0a59"+
		"\u0a63\u0a6e\u0a79\u0a84\u0a8f\u0a9d\u0a9f\u0abd\u0abf\u0adb\u0add\u0af5"+
		"\u0af7\u0b0d\u0b0f\u0b21\u0b35\u0b3d\u0b42\u0b47\u0b5d\u0b68\u0b6e";
	public static final String _serializedATN = Utils.join(
		new String[] {
			_serializedATNSegment0,
			_serializedATNSegment1
		},
		""
	);
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}