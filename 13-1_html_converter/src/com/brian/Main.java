package com.brian;

public class Main {

    public static void main(String[] args) {
        System.out.println("HTML Converter\n");

        String html = "<h1>Grocery List</h1>\n" +
                "<ul>\n" +
                "    <li>Eggs</li>\n" +
                "    <li>Milk</li>\n" +
                "    <li>Butter</li>\n" +
                "</ul>";
        System.out.println("INPUT\n" + html);

        // Method to convert HTML to plain text and make list readable
        convertHTML(html);

    }

    public static void convertHTML(String html) {
        html = html.replaceAll("<ul>\n", "");
        html = html.replaceAll("<li>", "*");
        html = html.replaceAll(" +", "");
        html = html.replaceAll("<.*?>", "");
        System.out.println("\nOUTPUT\n" + html.trim());
    }
}