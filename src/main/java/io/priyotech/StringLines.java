package io.priyotech;

import java.util.stream.Collectors;

public class StringLines {
    public static void main(String[] args) {
        String multiLineString="a\nb\nc";
        System.out.println(multiLineString.lines().collect(Collectors.toList()));
    }
}
