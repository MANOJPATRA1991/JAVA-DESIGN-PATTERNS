package Patterns.Builder;

import Patterns.Builder.HTML.HtmlBuilder;

/**
 * Demonstrates HTMLBuilder example
 */
class DemoBuilder {
    /**
     * This is the main method which demonstrates HTMLBuilder example.
     * @param args Unused
     */
    public static void main(String[] args) {
        // FLUENT INTERFACE
        StringBuilder sb = new StringBuilder();
        sb.append("foo").append("bar");

        // HTML Builder example
        HtmlBuilder builder = new HtmlBuilder("ul");
        builder.addChild("li", "hello");
        builder.addChild("li", "world");

        System.out.println(builder);
    }
}