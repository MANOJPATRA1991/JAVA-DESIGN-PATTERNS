package Patterns.Builder;

import Patterns.Builder.HTML.HtmlBuilder;

class DemoBuilder {
    public static void main(String[] args) {
//        FLUENT INTERFACE
        StringBuilder sb = new StringBuilder();
        sb.append("foo").append("bar");

        HtmlBuilder builder = new HtmlBuilder("ul");
        builder.addChild("li", "hello");
        builder.addChild("li", "world");
//        builder.clear();
        System.out.println(builder);
    }
}