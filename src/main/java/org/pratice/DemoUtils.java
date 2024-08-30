package org.pratice;

import org.pratice.DTO.Human;

import java.util.List;

public class DemoUtils {
    public int add(int a, int b){
        return a+b;
    }

    public boolean isNull(String str){
        str = str.strip();
        str = str.stripTrailing();
        return str.isEmpty();
    }
    public String returnInputString(String str){
        return str;
    }

    String junit = "junit";
    String junitDuplicate = "junit";

    String junitDuplicateNew = new String("junit");
    public String getJunit(){
        return junit;
    }
    public String getJunitDuplicate(){
        return junitDuplicate;
    }
    public String getJunitDuplicateNew(){
        return junitDuplicateNew;
    }

    public String[] firstThreeLettersOfAlphabets = {"A", "B", "C"};
    public List<String> stringList = List.of("Junit", "jupiter", "assertions");

//    getter for firstThreeLettersOfAlphabets
    public String[] getFirstThreeLettersOfAlphabets(){
        return firstThreeLettersOfAlphabets;
    }
//    getter for StringList
    public List<String> getStringList(){
        return stringList;
    }
    public String validateNegativeValues(int number) throws Exception{
        if (number<0){
            throw new Exception("Number is less than Zero !");
        }
        return "Number is valid as it's greater-than zero";
    }

    public void checkTimeout() throws InterruptedException {
        System.out.println("Method invoked!");
        Thread.sleep(3000);
        System.out.println("Method Executed after 3 seconds!");
    }
//    switch case in java 17 with Pattern Matching
//static record Human (String name, int age, String profession) {}
static record Circle (int radius) {}
static record Shape (String name) {}

public String checkObject(Object obj) {
    System.out.println(obj.getClass());
    return switch (obj) {
        case Human h -> "Name: %s, age: %s and profession: %s".formatted(h.name(), h.age(), h.profession());
        case Circle c -> "This is a circle";
        case Shape s -> "It is just a shape";
        case null -> "It is null";
        default -> "It is an object";
    };
}

}
