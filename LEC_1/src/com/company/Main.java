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


        import java.util.Objects;

        interface flyingBird{
            void fly();
        }
        interface eatingBird{
            void eat();
        }
        abstract class Bird {
            String name;
            String type;
            String peak;
            String feather;

            abstract void getType();
        }
        class Sparrow extends Bird implements flyingBird,eatingBird{

            @Override
            void getType(){
                System.out.print("sparrow");
            }

            @Override
            public void fly() {
                System.out.print("fly");
            }

            @Override
            public void eat() {
                System.out.print("eating sparrow");
            }
        }
        class Penguin extends  Bird{
            @Override
            void getType(){
                System.out.print("penguin");
            }
        }
        class Peacock extends  Bird implements flyingBird{

            @Override
            void getType(){
                System.out.print("peacock");
            }

            @Override
            public void fly() {
                System.out.print("peacock is flying");
            }
        }
        class Person{
            String name;
            int age;
            new String();
        }
        ACSESS MODIFIERS
        private attributes/methods cannot be used outside the class

        class Person{
            String name;
            int age;
            Person(String n,int p){
                name = n;
                age = p;
            }
            @Override
            public boolean equals(Object b){
                Person other = (Person) b;
                return (this.name.equals(other.name) && this.age == other.age);
            }
            @Override
            public int hashCode(){
                // this name age
                String hash = name;
                return hash.hashCode();
            }
        }
         hashcode
         is basically getting the adress of your object and based on that prints a random number
         final
        class Student{
            final String school = "hdjkgdsjh" ;
            String DOB;
            int mathsMarks;
            int scienceMarks;
            Student(int roll_no,String DOB,int mathsMarks,int scienceMarks){
                this.roll_no = roll_no;
                this.mathsMarks = mathsMarks;
                this.scienceMarks = scienceMarks;
            }
        }
        class BackBencher extends Student{

            BackBencher(int roll_no, String DOB, int mathsMarks, int scienceMarks) {
                super(roll_no, DOB, mathsMarks, scienceMarks);
            }
        }
        class Car{
            String carType;
            String buyer;
            Car(String carType,String buyer){
                // 6487436348 - car
                this.buyer = buyer;
                this.carType = carType;
            }
            @Override
            public int hashCode(){
                return Objects.hash(buyer);
            }
        }
        class CarFactory{
            static int count = 0;
            String name = "MITSUBHI";
            public static void printAttributes(){
                // inside a static contest you can only access static variables
                System.out.print(count);
                System.out.print(name);
            }
        }
        Car car = new Car("SUV","Ambani");
        Car car1 = new Car("SUV","Ambani");
        System.out.print(car.hashCode());
        CarFactory.printAttributes();
          Student student = new Student(56,"27/09/1999",99,30);
        Student student = new Student(100,"27/09/1999",99,30);
          student.scienceMarks = 12;
        String aa = new String("kartik");
        String bb = new String("kartik");
        Person a = new Person(aa,22);
        Person b = new Person(bb,22);
        System.out.print(a.hashCode());
        System.out.print(b.hashCode());
        Map<Person,Boolean> hashMap= new HashMap<Person,Boolean>();
        hashMap.put(a,true);
        hashMap.put(b,true);

        for(Map.Entry<Person,Boolean> entry: hashMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        1 2 3 3 4 2 1 1
        [1 -> 3,
        2  -> 2,
        3  -> 2,
        4  -> 1
        */
    }
}
