package io.priyotech;

public class StringStrip {

    public static void main(String[] args) {
        String txt1="   abc  \u2001";
        String txt2="   abc a ";
        System.out.println(txt1.strip());
        System.out.println(txt2.stripLeading());
        System.out.println(txt2.stripTrailing());
    }
}
