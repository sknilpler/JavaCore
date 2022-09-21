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

    /**
     * <b>Функция убрает дубликаты, отсортировывает по идентификатору, сгруппировывает по имени</b>
     *
     * @param persons массив Person[]
     * @return отформатированные данные в виде Map<String, Long>, где Key - имя, а Value - кол-во повторений
     */
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

    /**
     * <b>Метод вычисляет пару из элементов входного массива, которая в сумме получает значение входного параметра</b>
     *
     * @param arr массив элементов
     * @param s   искомая сумма
     * @return [0, 0] - если arr = null<br>
     * [] - если нет совпадений<br>
     * [int, int] - если элементы найдены
     */
    public static int[] getPairGivingSum(int[] arr, int s) {
        if (arr != null) {
            return Arrays.stream(arr).flatMap(a1 -> Arrays.stream(arr)
                            .flatMap(a2 -> a1 + a2 == s ? IntStream.of(a1, a2) : IntStream.empty())
                            .findFirst().stream())
                    .toArray();
        }
        return new int[]{0, 0};
    }

    /**
     * <b>Функция нечеткого поиска</b>
     *
     * @param s1 искомая строка
     * @param s2 строка, в которой осуществляется поиск
     * @return true - если есть совпаадения<br> false - если нет совпадений
     */
    public static boolean fuzzySearch(String s1, String s2) {
        if (!s1.equals("") && !s2.equals("")) {

            char[] expressionChars = s1.toCharArray();
            char[] textChars = s2.toCharArray();
            boolean[] matches = new boolean[s1.length()];

            int index = 0;
            for (int i = 0; i < s1.length(); i++) {
                for (int j = index; j < s2.length(); j++) {
                    if (expressionChars[i] == textChars[j]) {
                        matches[i] = true;
                        if (index < s2.length() - 1) {
                            index = j + 1;
                        }
                        break;
                    }
                }
            }

            for (Boolean b : matches) {
                if (!b) return false;
            }

            return true;

        } else return false;
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

        System.out.println("Задача №3");
        System.out.println();
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));
        System.out.println(fuzzySearch("cwhl", "cartwheel"));
        System.out.println(fuzzySearch("cwhee", "cartwheel"));
        System.out.println(fuzzySearch("cartwheel", "cartwheel"));
        System.out.println(fuzzySearch("cwheeel", "cartwheel"));
        System.out.println(fuzzySearch("lw", "cartwheel"));

    }
}
