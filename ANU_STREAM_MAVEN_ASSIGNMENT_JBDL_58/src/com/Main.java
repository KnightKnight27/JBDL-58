import Person.AgeCalculator;
import Person.People;
import Person.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<People> list = new ArrayList<>();
        list.add(new People("Anu",23,"Female","India"));
        list.add(new People("Jenny",18,"Female","USA"));
        list.add(new People("xyz",18,"Male","China"));
        list.add(new People("NYC",25,"Female","China"));
        list.add(new People("Terry",30,"Male","China"));
        list.add(new People("Gautam",10,"Male","India"));
        list.add(new People("hnk",12,"Male","USA"));

        //Printed the avg age of all the people
        AgeCalculator age = new AgeCalculator();
        System.out.println("Average age of all people:");
        System.out.println(age.averageAge(list));
        System.out.println();

        //Created a list of all the people who are either greater than 20 or contain any vowel in their name
        System.out.println("List of people whose age is either greater than twenty or name contains any vowel:");
        AgeCalculator ageVowel = new AgeCalculator();
        ageVowel.ageGreaterThanTwentyOrNameContainsAnyVowel(list);
        System.out.println();

        //Created a list of people, sorted in ascending order on the basis of age,
        // if age is the same then sort in descending order of name
        System.out.println("List of people age in dec order:");
        AgeCalculator ageSort = new AgeCalculator();
        ageSort.peopleSortedOnBasisOfAge(list);
        System.out.println();

        //Created a map from this people list where the key is country name and
        // value is count which means map will tell how many people live in a particular country
        System.out.println("Created a map of people key as countryTheylive and value as number of people:");
        AgeCalculator map = new AgeCalculator();
        map.mapPeople(list);
        System.out.println();

        //Create a map which stores avg age of people per country
        System.out.println("Created a map the stores avg age of people per country:");
        AgeCalculator map1 = new AgeCalculator();
        map1.mapAvgAge(list);
        System.out.println();

        //Printed the oldest person in every country
        System.out.println("Oldest person in every country:");
        AgeCalculator old = new AgeCalculator();
        old.oldestPeople(list);
        System.out.println();

        //Printed the country with most people
        System.out.println("Country with most people:");
        AgeCalculator most = new AgeCalculator();
        most.mostPeople(list);
        System.out.println();

        System.out.println("Random Numbers:");
        //Created a list of 20 random integers in the range 0-1000
        RandomGenerator r = new RandomGenerator();
        r.listOfInt();
        System.out.println();
    }
}
