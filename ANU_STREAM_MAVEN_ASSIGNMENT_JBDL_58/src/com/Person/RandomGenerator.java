package Person;
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;

public class RandomGenerator {
    public void listOfInt(){  //random number generation
        int min = 0;
        int max = 1000;
        int count = 20;
        List<Integer> randomIntegers = new Random().ints(count, min, max + 1).boxed().collect(Collectors.toList());
        randomIntegers.forEach(System.out::println);

    }
}
