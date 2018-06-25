package Patterns.Builder.HTML;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Creates an HTMLElement with name of the element
 * and text between the element's opening and
 * closing tags
 */
public class HtmlElement {
    public String name, text;

    // An array list to store HTML elements
    public ArrayList<HtmlElement> elements = new ArrayList<>();

    // Default indent for each level of depth
    private final int indentSize = 2;

    // Default new line separator is set to "\n"
    private final String newLine = System.lineSeparator();

    /**
     * Constructor with no arguments
     */
    public HtmlElement() {

    }

    /**
     * Creates an instance of HTMLElement
     * @param name {String} Name of the element
     * @param text {String} Text to be placed between the element's opening and closing tags
     */
    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }


    /**
     * Creates a string representation of the HTML tree structure
     * @param indent Indentation level as we traverse the tree
     * @return String
     */
    private String toStringImpl(int indent) {

        // Create a new StringBuilder instance
        StringBuilder sb = new StringBuilder();

        String i = String.join("", Collections.nCopies(indent * indentSize, " "));

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

    /**
     * This method returns a string implementation of the HTML code
     * by using the toStringImpl() method
     * @return String
     */
    @Override
    public String toString() {
        return toStringImpl(0);
    }
}
