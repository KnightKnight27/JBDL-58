package com.company;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // SUPPLIER
        // Get some random int
        // CONSUMER
//        Supplier<Integer> supplier = ()-> new Random().nextInt();
//        System.out.println(supplier.get());
//        // Predicate
//        Predicate<String> predicate = (a)-> a.length()>5;
//        System.out.println(predicate.test("DEATH NOTE"));
//        // Function
//        Function<Integer,Integer> function = (a) -> a*2;
//        System.out.println(function.apply(3));
//        // bI FUNCTION
//        BiFunction<Integer,Integer,Double> biFunction = (a,b)->(new Double((a*b)/100.0));
//        System.out.println(biFunction.apply(20,3));
        /** GIVEN A LIST OF INTEGERS
         *  1. FIND OUT OF THE EVEN NUMBERS OF IT
         *  2. DO SQUARE OF THEM
         *  3. SUM THEM UP AND RETURN THE RESULT
         *  [4, 5, 9,6, 12] ->  [4,6,12] -> [16 + 36 + 144] ->196
         */
        // streams in java
        List<Integer> arr = Arrays.asList(4, 5, 9,6, 12);
        System.out.print(arr.stream().parallel().filter(x -> {
            System.out.println("FILTERING EVEN");
            return x %2 == 0;
        }).map((a)-> {
            System.out.println("SQUARING");
            return a*a;}).collect(Collectors.toList()).get(0));


        // HOW TO IMPLEMENT HERE USING FOR LOOPS
//        for(int i=0;i<N;i++){
//            if(arr[i]%2){
//                even.add(arr[i]);
//            }
//        }
//        for(i = 0;i<N;i++){
//            sq.add(even[i]*even[i]);
//        }
//        int sum= 0;
//        for(int it:sq){
//            sum += it;
//        }


    }
}
