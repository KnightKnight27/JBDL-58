package com.company;


interface Vehicle {
    void start();  // Abstract method

    void stop();   // Abstract method

    default void honk() {
        System.out.println("Honking the horn");
    }

    default void accelerate() {
        System.out.println("Accelerating the vehicle");
    }
}

public class Main {
    public static void main(String[] args) {
         /*
         JAVA COMPLETELY OBJECT ORIENTED//
         OOPS
         SPARROW CROW PEACOCK

          which is real life entity
         OOPS PRINCIPLE 1
         INHERITANCE
         ABSTRACTION
         ENCAPSULATION
         POLYMORPHISM -> name is one but forms are many
         compile time runtime polymorphism
         static     dynamic
         TWO FUNCTIONS OF THE SAME NAME? DOES IT WORK
         TWO FUNCTIONS WITH DIFFERENT SIGNATURE AND SAME NAME
         TWO  OR MORE FUNCTIONS WITH SAME NAME AND DIFFERENT SIGNATURE THEY COULD
         PERFORM FUNCTION OVERLOADING

        1 2 3 3 4 2 1 1
        [1 -> 3,
        2  -> 2,
        3  -> 2,
        4  -> 1
        */
    }
}
