package Patterns.Builder;
import Patterns.Builder.HTML.HtmlFluentBuilder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Demonstrates HTMLFluentBuilder example
 */
class DemoFluentBuilder {
    /**
     * This is the main method which demonstrates HTMLBuilder example.
     * @param args Unused
     */
    public static void main(String[] args) {
        // FLUENT INTERFACE
        StringBuilder sb = new StringBuilder();
        sb.append("foo").append("bar");

        HtmlFluentBuilder builder = new HtmlFluentBuilder("ul");

        // Now we are building fluently
        builder.addChild("li", "hello")
                .addChild("li", "world");

        System.out.println(builder);
    }
}