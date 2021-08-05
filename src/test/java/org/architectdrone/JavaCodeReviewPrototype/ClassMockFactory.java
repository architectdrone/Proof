package org.architectdrone.JavaCodeReviewPrototype;

import lombok.Builder;
import lombok.Singular;

import java.text.MessageFormat;
import java.util.List;

/*

 */
@Builder
public class ClassMockFactory {

    private final String privateMemberVariable;
    private final String publicMemberVariable;
    private @Builder.Default
    final String className = "MyClass";
    private @Singular
    final List<String> includes;
    private @Builder.Default
    final String classPackage = "org.my.class.package";
    private @Singular
    final List<MethodMock> methods;
    String getClassMock() {
        StringBuilder toReturn = new StringBuilder();
        //toReturn.append(MessageFormat.format("package {0};\n", classPackage));

        for (String include : includes) {
            toReturn.append(MessageFormat.format("import {0};\n", include));
        }

        toReturn.append(MessageFormat.format("public class {0}", className)).append("{\n");

        if (privateMemberVariable != null) {
            toReturn.append(MessageFormat.format("\tprivate int {0};", privateMemberVariable)).append("{\n");
        }

        if (publicMemberVariable != null) {
            toReturn.append(MessageFormat.format("\tpublic int {0};", publicMemberVariable)).append("{\n");
        }

        for (MethodMock method : methods) {
            toReturn.append(method.getStringRepresentation());
        }

        toReturn.append("}");
        return toReturn.toString();
    }

}

@Builder
class MethodMock {
    @Builder.Default
    private final boolean inlineComments = false;
    @Builder.Default
    private final boolean javaDocComment = false;
    @Builder.Default
    private final boolean extraWhitespace = false;
    @Builder.Default
    private final boolean bodyA = true;
    @Builder.Default
    private final boolean isPublic = true;
    @Builder.Default
    String methodName = "MyMethod";

    public String getStringRepresentation() {
        StringBuilder toReturn = new StringBuilder();
        if (javaDocComment) {
            toReturn.append("\t/*\n");
            toReturn.append("\tComment\n");
            toReturn.append("\t*/\n");
        }
        toReturn.append(MessageFormat.format("\t{0} int {1}() ", isPublic ? "public" : "private", methodName)).append("{\n");
        if (inlineComments) {
            toReturn.append("\t\t//This is a leading test comment\n");
        }
        if (bodyA) {
            toReturn.append("\t\tint a = 0;\n");
            toReturn.append("\t\tfor (int i = 0; i < 10; i++) {\n");
            if (extraWhitespace) {
                toReturn.append("\t\t\t\n");
            }
            toReturn.append("\t\t\ta = a + i;\n");
            toReturn.append("\t\t}\n");
            toReturn.append("\t\treturn a;\n");
        } else {
            toReturn.append("\t\tint a = 0;\n");
            toReturn.append("\t\tfor (int i = 0; i < 10; i++) {\n");
            if (extraWhitespace) {
                toReturn.append("\t\t\t\n");
            }
            toReturn.append("\t\t\ta = a * i;\n");
            toReturn.append("\t\t}\n");
            toReturn.append("\t\treturn a;\n");
        }

        if (inlineComments) {
            toReturn.append("\t\t//This is another comment, at the end of the method\n");
        }

        toReturn.append("\t}\n");

        return toReturn.toString();
    }
}