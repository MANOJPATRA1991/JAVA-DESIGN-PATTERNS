package Patterns.Builder;
import Patterns.Builder.HTML.HtmlFluentBuilder;

import java.util.ArrayList;
import java.util.Collections;

class DemoFluentBuilder {
    public static void main(String[] args) {
//        FLUENT INTERFACE
        StringBuilder sb = new StringBuilder();
        sb.append("foo").append("bar");

        HtmlFluentBuilder builder = new HtmlFluentBuilder("ul");
        builder.addChild("li", "hello")
                .addChild("li", "world");
//        builder.clear();
        System.out.println(builder);
    }
}