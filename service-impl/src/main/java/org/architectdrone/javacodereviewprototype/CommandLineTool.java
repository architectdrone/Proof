package org.architectdrone.javacodereviewprototype;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.architectdrone.javacodereviewprototype.context.language.JavaContext;
import org.architectdrone.javacodereviewprototype.dependencyinjection.DefaultModule;

public class CommandLineTool {
    public static String fileALocation = "C:\\dev\\proof\\service-impl\\src\\main\\resources\\fileA.java";
    public static String fileBLocation = "C:\\dev\\proof\\service-impl\\src\\main\\resources\\fileB.java";
    public static void main(String[] args) throws IOException {
        Injector injector = Guice.createInjector(new DefaultModule());
        JavaContext myJavaContext = injector.getInstance(JavaContext.class);
        String fileA = new String(Files.readAllBytes(Paths.get(fileALocation)));
        String fileB = new String(Files.readAllBytes(Paths.get(fileBLocation)));
        myJavaContext.printDiffTree(fileA, fileB);
    }
}
