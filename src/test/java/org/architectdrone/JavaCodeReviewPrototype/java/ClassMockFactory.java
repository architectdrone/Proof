package org.architectdrone.JavaCodeReviewPrototype.java;

import lombok.Builder;
import lombok.Singular;

import java.text.MessageFormat;
import java.util.List;

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
    public String getClassMock() {
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

