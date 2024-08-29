package org.pratice;

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
}
