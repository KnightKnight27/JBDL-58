package Person;

import java.util.*;
import java.util.stream.Collectors;

public class AgeCalculator {
    public double averageAge(List<People> list){
        return (list.stream().mapToDouble(x->x.getAge()).average().getAsDouble());//Average age
    }
    public void ageGreaterThanTwentyOrNameContainsAnyVowel(List<People> list){
        List<People> list1 = list.stream().filter(x ->x.getAge() > 20 || containsVowel(x.getName())).collect(Collectors.toList());
        list1.forEach(x->System.out.println(x.toString())); //age>20 or name contain any vowel
    }

    private boolean containsVowel(String name) { // method for containsVowel
        {
            String vowels = "AEIOUaeiou";
            for (char c : name.toCharArray()) {
                if (vowels.indexOf(c) != -1) {
                    return true;
                }
            }
            return false;
        }
    }
    public void peopleSortedOnBasisOfAge(List<People> list){
        List<People> list2 = list.stream().sorted(Comparator.comparingInt(People::getAge)
                        .thenComparing(Comparator.comparing(People::getName).reversed())).collect(Collectors.toList());
        //List of people on the basis of age sorted or if same age then on the basis of their name in dec order
        list2.forEach(System.out::println);
      //list.stream().map(People::getAge).sorted().collect(Collectors.toList()).forEach(x-> System.out.println(x.toString()));

    }
   public void mapPeople(List<People> list){
       Map<String, Long> countryCountMap = list.stream().collect(Collectors.groupingBy(People::getCountryTheyLive, Collectors.counting()));
       System.out.println(countryCountMap);//Map of people key as country and value number of people in the particular country
   }
   public void mapAvgAge(List<People> list){
       Map<String, Double> countryAvgAgeMap = list.stream()
               .collect(Collectors.groupingBy(People::getCountryTheyLive, Collectors.averagingDouble(People::getAge)));
       System.out.println(countryAvgAgeMap);//map which contains the avg age of people per country
   }
   public void oldestPeople(List<People> list){
       // Create a map to group people by country
       Map<String, List<People>> peopleByCountry = new HashMap<>();
       for (People x : list) {
           String country = x.getCountryTheyLive();
           peopleByCountry.putIfAbsent(country, new ArrayList<>());
           peopleByCountry.get(country).add(x);
       }
       // Create a map to store the oldest person by country
       Map<String, People> oldestByCountry = new HashMap<>();

       for (Map.Entry<String, List<People>> entry : peopleByCountry.entrySet()) {
           String country = entry.getKey();
           List<People> countryPeople = entry.getValue();

           // Find the oldest person within the country's list
           People oldestPerson = countryPeople.stream()
                   .max((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                   .orElse(null);

           if (oldestPerson != null) {
               oldestByCountry.put(country, oldestPerson);
           }
       }

       // Print the oldest person from each country
       for (Map.Entry<String, People> entry : oldestByCountry.entrySet()) {
           String country = entry.getKey();
           People oldestPerson = entry.getValue();
           System.out.println("Oldest person in " + country + ": " + oldestPerson);
       }
   }
   public void mostPeople(List<People> list){
       Map<String, Integer> countryCount = new HashMap<>();
       for (People x : list) {
           String country = x.getCountryTheyLive();
           countryCount.put(country, countryCount.getOrDefault(country, 0) + 1);
       }
       // Find the country with the most people
       String mostPopulatedCountry = "";
       int maxPopulation = 0;

       for (Map.Entry<String, Integer> entry : countryCount.entrySet()) {
           String country = entry.getKey();
           int population = entry.getValue();

           if (population > maxPopulation) {
               maxPopulation = population;
               mostPopulatedCountry = country;
           }
       }
       // Print the most populated country
       System.out.println("The country with the most people is: " + mostPopulatedCountry);
   }

   }


