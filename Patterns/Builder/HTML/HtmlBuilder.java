package Patterns.Builder.HTML;

/**
 * Builder pattern allows us to build our object piece-by-piece
 */

// Builder class to build HTML
public class HtmlBuilder {
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
