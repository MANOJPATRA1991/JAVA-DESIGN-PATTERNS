package Patterns.Builder.HTML;

/**
 * Builder pattern allows us to build our object piece-by-piece
 */

// Builder class to build HTML
public class HtmlFluentBuilder {
    private String rootName;

    //    Root HTML element
    private HtmlElement root = new HtmlElement();

    public HtmlFluentBuilder(String rootName) {
        this.rootName = rootName;
        root.name = rootName;
    }

    //    Creates a new HtmlElement instance and adds to ArrayList root.elements
    public HtmlFluentBuilder addChild(String childName, String childText) {
        HtmlElement e = new HtmlElement(childName, childText);
        root.elements.add(e);
        return this;
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
