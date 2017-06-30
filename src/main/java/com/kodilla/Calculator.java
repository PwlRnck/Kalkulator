package com.kodilla;

/**
 * Created by PR on 30.06.2017.
 */
public class Calculator {
    public int add(int a, int b){
        return a+b;
    }

    public int sub(int a, int b){
        return a-b;
    }

    public static void main(String[] args){
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(5,3));
        System.out.println(calculator.sub(5,3));
    }
}
