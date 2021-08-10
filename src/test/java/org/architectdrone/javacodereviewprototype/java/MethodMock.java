package org.architectdrone.javacodereviewprototype.java;

import lombok.Builder;

import java.text.MessageFormat;

@Builder
public class MethodMock {
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
