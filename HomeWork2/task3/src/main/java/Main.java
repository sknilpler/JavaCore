import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static final Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };


    public static Map<String, Long> getPersonFrequency(Person[] persons) {
        if (persons != null) {
            return Arrays.stream(persons)
                    .filter(e -> Objects.nonNull(e.getName()))
                    .distinct()
                    .sorted(Comparator.comparing(Person::getId))
                    .collect(groupingBy(Person::getName, counting()));
        }
        return new HashMap<>();
    }

    public static int[] getPairGivingSum(int[] arr, int s) {
        if (arr != null) {
            return Arrays.stream(arr).flatMap(a1 -> Arrays.stream(arr)
                            .flatMap(a2 -> a1 + a2 == s ? IntStream.of(a1, a2) : IntStream.empty())
                            .findFirst().stream())
                    .toArray();
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {

        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Задача №1");
        System.out.println();
        getPersonFrequency(RAW_DATA).forEach((k, v) -> System.out.println("Key: " + k + "\nValue: " + v));
        System.out.println();
        System.out.println();

        int[] arr = new int[]{3, 4, 2, 7};
        int s = 10;

        System.out.println("Задача №2");
        System.out.println();
        System.out.print("Входной массив: ");
        System.out.println(Arrays.toString(arr));
        System.out.print("Искомая сумма: ");
        System.out.println(s);
        System.out.println("Результат:");
        System.out.println(Arrays.toString(getPairGivingSum(arr, s)));
        System.out.println();
        System.out.println();

    }
}
