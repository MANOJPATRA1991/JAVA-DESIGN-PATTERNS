package Patterns.Builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

class Property {
    public String name, type;

    public Property(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

class CodeBuilder
{
    private String className;
    private ArrayList<Property> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public CodeBuilder(String className)
    {
        // todo
        this.className = className;
    }

    public CodeBuilder addField(String name, String type)
    {
        // todo
        Property e = new Property(name, type);
        this.elements.add(e);

        return this;
    }

    @Override
    public String toString()
    {
        // todo
        StringBuilder sb = new StringBuilder();

        sb.append("public class " + className + newLine);
        sb.append('{' + newLine);

        for (Property p : elements) {
            sb.append(String.join("", Collections.nCopies(indentSize * indentSize, " ")));
            sb.append("public " + p.type + " " + p.name + ';' + newLine);
        }

        sb.append('}');

        return sb.toString();
    }
}

class DemoExerciseBuilder {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");

        System.out.println(cb);
    }
}