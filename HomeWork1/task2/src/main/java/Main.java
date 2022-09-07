
public class Main {

    private static void swapping(int[] arr, int ind1, int ind2) {
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }

    /**
     * Сортировка методом пузырька
     *
     * @param arr   int[] массив
     * @param order направление сортировки. true - по возрастанию, false - по убыванию.
     * @return int[] отсортированный массив
     */
    public static int[] sortedArr(int[] arr, boolean order) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            if (order) {
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] < arr[i - 1]) {
                        swapping(arr, i, i - 1);
                        needIteration = true;
                    }
                }
            } else {
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] > arr[i - 1]) {
                        swapping(arr, i - 1, i);
                        needIteration = true;
                    }
                }
            }
        }
        return arr;
    }

    public static void print(int[] arr) {
        for (int temp : arr) {
            System.out.printf("%2d", temp);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 2, 5, 1, 4, 9};
        System.out.println("Исходный массив:");
        print(arr);
        System.out.println("Отсортированный по возрастанию:");
        print(sortedArr(arr, true));
        System.out.println("Отсортированный по убыванию:");
        print(sortedArr(arr, false));
    }
}
