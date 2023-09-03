package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

//@FunctionalInterface
//interface MathsSolver {
//    int multiply(int a,int b);
//    int hashCode();
//
//    default int subtract(int a, int b) {
//        return a - b;
//    }
//}
//@FunctionalInterface
//interface X{
//    int hashCode();
//    void fly();
//}
//@FunctionalInterface
//interface A extends Comparator<Integer>{
//    default int compare(int var1, int var2){
//
//    }
//
//}
//interface HashCodeGenerator{
//    void seedGenerator();
//    void printSeed();
//
//}
//class POLYNOMIALHASH implements HashCodeGenerator{
//    @Override
//    public void seedGenerator() {
//
//    }
//
//    @Override
//    public void printSeed() {
//
//    }
//    @Override
//    public int hashCode{
//
//    }
//}
//class RANDOMHASH implements HashCodeGenerator{
//    @Override
//    public void seedGenerator() {
//
//    }
//
//    @Override
//    public void printSeed() {
//
//    }
//    @Override
//    public int hashCode{
//
//    }
//}
public class Main {

    public static void main(String[] args) {
//        lightbehavior lightbehavior = new lightbehavior() {
//            @Override
//            public void light() {
//
//            }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
        maxHeap.add(12);
        maxHeap.add(8);
        maxHeap.add(4);
        System.out.println(maxHeap.peek());
        // ANONYMOUS CLASSES

        // better way implement functional interfaces rather than using ananonymous classes is
        // by using LAMBDAS
        // LAMBDA IS JUST A NEW WAY TO WRITE FUNCTIONS
        // RETURN TYPE IS NOT THEIR
        // DONT SPECIFY ARGUEMENT EASY

//        MathsSolver maths/*Solver = (x,y) ->x*y;
//        System.out.print(mathsSolver.multiply(2,4));*/

        // write your code here
        // FUNCTIONAL INTERFACE
        // AN INTERFACE WHiCH HAS EXACTLY ONE NON OVER RIDING ABSTRACT METHOD



    }
}
