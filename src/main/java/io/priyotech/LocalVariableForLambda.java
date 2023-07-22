package io.priyotech;

import java.util.function.Function;

public class LocalVariableForLambda {
    public static void main(String[] args) {
        Function<Integer,String> functionOne=(var s) -> {
            System.out.println(s.getClass());
            return s.toString().substring(0,s.toString().length()-4);
        };
        System.out.println(functionOne.apply(5789023));
    }
}
