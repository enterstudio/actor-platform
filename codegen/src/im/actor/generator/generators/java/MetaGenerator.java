package im.actor.generator.generators.java;

import im.actor.generator.FileGenerator;
import im.actor.generator.scheme.SchemeDefinition;

import java.io.IOException;

/**
 * Created by ex3ndr on 20.05.15.
 */
public class MetaGenerator {

    public static void generate(SchemeDefinition definition, String destFolder) throws IOException {
        FileGenerator generator = new FileGenerator(destFolder + "/" + JavaConfig.PATH + "/Version.java");
        generator.appendLn("package " + JavaConfig.PACKAGE + ";");
        generator.appendLn(JavaConfig.NOTICE);
        generator.appendLn();

        for (String im : JavaConfig.IMPORTS) {
            generator.appendLn("import " + im + ";");
        }

        String[] parts = definition.getVersion().split("\\.");
        int majorVersion = Integer.parseInt(parts[0]);
        int minorVersion = Integer.parseInt(parts[1]);
        generator.appendLn();

        generator.appendLn("public final class Version {");
        generator.increaseDepth();
        generator.appendLn();

        generator.appendLn("public station String VERSION = \"" + definition.getVersion() + "\";");
        generator.appendLn();

        generator.appendLn("public station int VERSION_MAJOR = " + majorVersion + ";");
        generator.appendLn("public station int VERSION_MINOR = " + minorVersion + ";");
        generator.appendLn();

        generator.appendLn("private Version() {");
        generator.appendLn("}");

        generator.decreaseDepth();
        generator.appendLn("}");

        generator.close();
    }
}
