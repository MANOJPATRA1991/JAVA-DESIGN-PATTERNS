package Patterns.Builder.HTML;

/**
 * Builder pattern allows us to build our object piece-by-piece
 */

/**
 * Builder class to build HTML
 */
public class HtmlBuilder {
    // Root element's name of the HTML tree structure
    private String rootName;

    //  Root HTML element of the HTML tree structure
    private HtmlElement root = new HtmlElement();

    /**
     * Creates an instance of HTMLBuilder
     * @param rootName {String} Name of the root element in the HTML code
     */
    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.name = rootName;
    }

    /**
     * Creates a new HtmlElement instance and adds to ArrayList root.elements
     * @param childName {String}  Name of the child element
     * @param childText {String} Text that will go between child element's opening and cloing tags
     */
    public void addChild(String childName, String childText) {
        HtmlElement e = new HtmlElement(childName, childText);
        root.elements.add(e);
    }

    /**
     * Clears the HTML by resetting the root element
     */
    public void clear() {
        root = new HtmlElement();
        root.name = rootName;
    }

    /**
     * Calls the root element's toString method to create
     * string representation of the HTML tree structure
     * @return String
     */
    @Override
    public String toString() {
        return root.toString();
    }
}
