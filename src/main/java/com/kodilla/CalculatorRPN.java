package com.kodilla;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by PR on 30.06.2017.
 */
public class CalculatorRPN {

    public List<String> inpToList (String input){

            String temp = "";
            String[] operators = {"+","-","/","*"} ;
            //String[] ignore = {"+","-","/","*",","} ;
            List<String> lista = new ArrayList<>();
            int howManyOps = 0;

            for(int i=0;i<input.length();i++){
                Pattern pattern =  Pattern.compile("[0-9]");
                Matcher matcher = pattern.matcher(input.substring(i,i+1));

                //if(!Arrays.asList(ignore).contains(input.substring(i,i+1))){
                if(matcher.find()){
                    temp = temp + input.substring(i,i+1);
                }else if(Arrays.asList(operators).contains(input.substring(i,i+1))){
                    if(!(temp.equals(""))){
                        lista.add(temp);}
                    lista.add(input.substring(i,i+1));
                    temp = "";
                    howManyOps++;
                }else{
                    if(!(temp.equals(""))){
                        lista.add(temp);}
                    temp = "";
                }
            }
            return lista;
    }

    public double rpnCalc(List<String> lista){
        Deque<Double> kolejka = new ArrayDeque<>();
        String[] operators = {"+","-","/","*"} ;
        double tempA=0;
        double tempB=0;

        for(String dane:lista){
            if(!Arrays.asList(operators).contains(dane)){
                kolejka.push((double)Integer.parseInt(dane));
            }else if(dane.equals("+")){
                tempB = kolejka.pop();
                tempA = kolejka.pop();
                kolejka.push(tempA + tempB);
            }else if(dane.equals("-")){
                tempB = kolejka.pop();
                tempA = kolejka.pop();
                kolejka.push(tempA - tempB);
            }else if(dane.equals("*")){
                tempB = kolejka.pop();
                tempA = kolejka.pop();
                kolejka.push(tempA * tempB);
            }else if(dane.equals("/")){
                tempB = kolejka.pop();
                tempA = kolejka.pop();
                kolejka.push(tempA / tempB);
            }
        }

        return kolejka.pop();
    }

    public static void main(String[] args){
            CalculatorRPN calcRPN = new CalculatorRPN();
            String doYouWant="y";
            Scanner keyboard = new Scanner(System.in);
            while(doYouWant.equals("y")) {
                System.out.println("enter your data to calculate in RPN mode; integer numbers only, divide numbers and operators with a comma \",\":");
                String input = keyboard.nextLine();
                System.out.println(calcRPN.rpnCalc(calcRPN.inpToList(input)));
                System.out.println("do you want to make another calculation?(y/n)");
                doYouWant = keyboard.nextLine();
            }
            System.out.println("Thank you for using our calculator");
    }
}
