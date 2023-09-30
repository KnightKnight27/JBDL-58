package Person;

public class People {
    private String name;
    private Integer age;
    private String gender;
    private String countryTheyLive;

    public People(String name, int age, String gender, String countryTheyLive) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.countryTheyLive = countryTheyLive;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getCountryTheyLive() {
        return countryTheyLive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountryTheyLive(String countryTheyLive) {
        this.countryTheyLive = countryTheyLive;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", countryTheyLive='" + countryTheyLive + '\'' +
                '}';
    }
}
