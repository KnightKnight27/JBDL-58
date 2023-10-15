package com.jbdl58.homework.assi1;

import java.util.*;
import java.util.stream.Collectors;

class People {
    private String name;
    private Integer age;
    private String gender;

    private String countryTheyLive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountryTheyLive() {
        return countryTheyLive;
    }

    public void setCountryTheyLive(String countryTheyLive) {
        this.countryTheyLive = countryTheyLive;
    }



    public People(String name, int age, String gender, String countryTheyLive) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.countryTheyLive = countryTheyLive;
    }

    public static void main(String[] args){
        List<People> lp= new ArrayList<>();
        lp.add(new People("Kriti", 20, "Female", "India"));
        lp.add(new People("Ritu", 23, "Female", "India"));
        lp.add(new People("Shyam", 28, "Male", "India"));
        lp.add(new People("Alex", 10, "Male", "USA"));
        lp.add(new People("Carie", 25, "Male", "USA"));
        lp.add(new People("Xyzbak", 22, "Female", "China"));
        lp.add(new People("Nobi", 22, "Female", "China"));

        //first task
        double average= lp.stream().mapToDouble(People::getAge).average().getAsDouble();
        System.out.println("Average age of all people is " + average);

        //second task
        System.out.println("List of all the people who are either greater than 20 or contain any vowel in their name (uppercase or lowercase)");
        List<People> filteredLp= lp.stream().filter(x-> x.getAge() >20).filter(x->{
            long f= x.getName().chars().filter(ch -> (ch == 'a' || ch == 'e' ||
                    ch == 'i' || ch == 'o' || ch == 'u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')).count();
            return f>0;
        }).toList();
        filteredLp.forEach(x-> System.out.print(x.getName() + " "));
        System.out.println(" ");

        //third task
        System.out.println("List of people, sorted in ascending order on the basis of age, if age is the same then sort in descending order of name");
        List<People> sortedLp= lp.stream().sorted((a,b)-> {
            if(a.getAge() > b.getAge()) return 1;
            else if(Objects.equals(a.getAge(), b.getAge())){
                if(a.getName().charAt(0) < b.getName().charAt(0)) return 1;
                return -1;
            }
            return -1;
        }).toList();
        sortedLp.forEach(x-> System.out.print(x.getName() + " "));

        //fourth task
        System.out.println("Create a map from this people list where the key is country name and value is count");
        Map<String, Integer> peopleCountByCountry= new HashMap<>();
        lp.forEach(x->{
            peopleCountByCountry.put(x.getCountryTheyLive(), peopleCountByCountry.getOrDefault(x.getCountryTheyLive(),0 )+1);
        });
        System.out.println(peopleCountByCountry);

        //fifth task
        System.out.println("Create a map which stores avg age of people per country");
        Map<String, Double> countryAvgAgeMap = lp.stream()
                .collect(Collectors.groupingBy(People::getCountryTheyLive, Collectors.averagingDouble(People::getAge)));
        System.out.println(countryAvgAgeMap);

        //sixth task
        System.out.println("Print the oldest person in every country");
        Map<String, List<Integer>> countryAndAges= new HashMap<>();
        lp.forEach(x->{
            countryAndAges.putIfAbsent(x.getCountryTheyLive(), new ArrayList<>());
            countryAndAges.get(x.getCountryTheyLive()).add(x.getAge());
        });
        countryAndAges.forEach((k,v)-> System.out.println(k + " " + Collections.max(v)));

        //seventh task
        System.out.println("Print the country with most people");
        int maxi=Integer.MIN_VALUE;
        String mostPopulusCountry="";
        for (Map.Entry<String, Integer> entry : peopleCountByCountry.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            if (maxi < v) {
                maxi = v;
                mostPopulusCountry = k;
            }
        }
        System.out.println(mostPopulusCountry + " = " + maxi);

        //eighth task
        System.out.println("Create a list of 20 random integers in the range 0-1000 using Java 8 streams");
        List<Object> listOfRandoms =  new Random().ints(0,1000).limit(20).boxed().collect(Collectors.toList());
        System.out.println(listOfRandoms);
    }
}
