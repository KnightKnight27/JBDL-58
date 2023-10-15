package company;

import java.util.Arrays;
import java.util.List;

class IntegerSum{
    public static int sum(int a,int b){
        return a + b;
    }
}
public class Main {
    public static void main(String[] args) {
        /**
         * Given a List of Strings , find out all the strings in it which have even frequency of 'a' or 0 freq and concatenate them together
         *
         * ["vansh","deathnote","cricket","abra","kadabra","hi"]
         * ans -> cricketabrahi
         *
         *  Given a list of integers add odd numbers of it
         */
        List<String> arr = Arrays.asList("vansh", "deathnote", "cricket", "abra", "kadabra", "hi");
        // IT IS BREAKING YOUR CODE INTO A PIPELINED VERSION
        String concat = arr.stream().filter((a) -> (a.chars().filter(ch -> ch == 'a').count()) % 2 == 0) .reduce("", (a, b) -> a + b);

        List<Integer> A = Arrays.asList(1,5,6,7,8,9);
        // this is called method referencing
        Integer sum = A.stream().filter(a -> a%2!=0).reduce(0, IntegerSum::sum);
        System.out.println(sum);
    }
}
