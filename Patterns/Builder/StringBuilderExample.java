package Patterns.Builder;

/**
 * Demonstrates how StringBuilder uses Builder Pattern
 */
class DemoStringBuilder {
    /**
     * This is the main method which demonstrates HTMLBuilder example.
     * @param args Unused
     */
    public static void main(String[] args) {
        String hello = "hello";

        System.out.println("<p>" + hello + "</p>");

        String[] words = {"hello", "world"};

        StringBuilder sb = new StringBuilder();

        sb.append("<ul>\n");

        for (String word : words) {
            sb.append(String.format("  <li>%s</li>\n", word));
        }

        sb.append("</ul>");

        System.out.println(sb);
    }
}

/**
 *  OUTPUT of string builder example:
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