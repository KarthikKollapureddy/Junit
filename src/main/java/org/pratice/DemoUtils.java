package org.pratice;

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

}
