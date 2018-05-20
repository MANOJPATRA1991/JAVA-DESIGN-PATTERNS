package Patterns.Builder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Builder pattern allows us to build our object piece-by-piece
 */

// Builder class to build HTML
class HtmlBuilder {
    private String rootName;

//    Root HTML element
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.name = rootName;
    }

//    Creates a new HtmlElement instance and adds to ArrayList root.elements
    public void addChild(String childName, String childText) {
        HtmlElement e = new HtmlElement(childName, childText);
        root.elements.add(e);
    }

//    Clears the Html
    public void clear() {
        root = new HtmlElement();
        root.name = rootName;
    }

//    Calls root element's toString() method
    @Override
    public String toString() {
        return root.toString();
    }
}

class HtmlElement {
    public String name, text;
    public ArrayList<HtmlElement> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {

    }

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    private String toStringImpl(int indent) {
        StringBuilder sb = new StringBuilder();

        String i = String.join("", Collections.nCopies(indent * indentSize, " "));
        System.out.println(i);

        sb.append(String.format("%s<%s>%s", i, name, newLine));
        if (text != null && !text.isEmpty()) {
            sb.append(String.join("", Collections.nCopies(indentSize*(indent+1), " ")))
                    .append(text)
                    .append(newLine);
        }

        for (HtmlElement e : elements) {
            sb.append(e.toStringImpl(indent + 1));
        }

        sb.append(String.format("%s</%s>%s", i, name, newLine));

        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }
}

class DemoBuilder {

    public static void main(String[] args) {
//        String hello = "hello";
//
//        System.out.println("<p>" + hello + "</p>");
//
//        String[] words = {"hello", "world"};
//
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("<ul>\n");
//        for (String word : words) {
//            sb.append(String.format("  <li>%s</li>\n", word));
//        }
//        sb.append("</ul>");
//
//        System.out.println(sb);

        HtmlBuilder builder = new HtmlBuilder("ul");
        builder.addChild("li", "hello");
        builder.addChild("li", "world");
        System.out.println(builder);
    }
}

/**
 *  OUTPUT:
 *
 *  <ul>
 *   <li>
 *     hello
 *   </li>
 *   <li>
 *     world
 *   </li>
 *  </ul>
 */