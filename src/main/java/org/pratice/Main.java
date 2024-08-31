package org.pratice;

import org.pratice.tdd.FizzBuzz;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream.range(0,101).mapToObj(
                FizzBuzz::compute
        ).forEach(System.out::println);
    }
}