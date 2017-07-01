package com.kodilla;

import java.util.*;
import java.lang.*;
import java.io.*;


/**
 * Created by PR on 30.06.2017.
 */
public class CalculatorRPN {

    public List<String> inpToList (String input){

            String temp = "";
            String[] operators = {"+","-","/","*"} ;
            String[] ignore = {"+","-","/","*",","} ;
            List<String> lista = new ArrayList<>();

            for(int i=0;i<input.length();i++){

                if(!Arrays.asList(ignore).contains(input.substring(i,i+1))){
                    temp = temp + input.substring(i,i+1);
                }else if(Arrays.asList(operators).contains(input.substring(i,i+1))){
                    if(!(temp=="")){
                        lista.add(temp);}
                    lista.add(input.substring(i,i+1));
                    temp = "";
                }else{
                    if(!(temp=="")){
                        lista.add(temp);}
                    temp = "";
                }
            }

            return lista;
    }

    public double rpnCalc(List<String> lista){
        Deque<Double> kolejka = new ArrayDeque<>();
        String[] operators = {"+","-","/","*"} ;
        Iterator<String> iter = lista.iterator();

        while(iter.hasNext()){
        //for(String dane:lista){
            String dane = iter.next();
            if(!Arrays.asList(operators).contains(dane)){
                kolejka.push((double)Integer.parseInt(dane));
            }else if(dane == "+"){
                kolejka.push(kolejka.pop()+kolejka.pop());
            }else if(dane == "-"){
                kolejka.push(kolejka.pop()-kolejka.pop());
            }else if(dane == "*"){
                kolejka.push(kolejka.pop()*kolejka.pop());
            }else if(dane == "/"){
                kolejka.push(kolejka.pop()/kolejka.pop());
            }
        }

        return kolejka.pop();
    }

    public static void main(String[] args){
        CalculatorRPN calcRPN = new CalculatorRPN();
        String input="12,2,3,4,*,10,5,/,+,*,+";
        System.out.println(calcRPN.rpnCalc(calcRPN.inpToList(input)));
    }
}
