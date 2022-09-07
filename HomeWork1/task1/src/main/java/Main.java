public class Main {

    private static long next = System.currentTimeMillis();

    /**
     * Создание нового двумерного массива с заданными параметрами и случайными элементами
     * <br>
     * Параметры массива:
     *
     * @param n строки
     * @param m столбцы
     *          <br>
     *          Параметры генерации случайных элементов (диапазон):
     * @param a левая граница диапазона
     * @param b правай граница диапазона
     * @return int[n][m] двумерный массив состоящий из случайных элементов
     */
    public static int[][] newMatrix(int n, int m, int a, int b) {
        int[][] matrix = new int[n][m];
        for (int[] temp : matrix) {
            for (int i = 0; i < temp.length; i++) {
                temp[i] = getRandomInt(a, b);
            }
        }
        return matrix;
    }

    public static void print(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int temp : arr) {
                System.out.printf("%4d", temp);
            }
            System.out.println();
        }
    }

    public static int getMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] arr : matrix) {
            for (int temp : arr) {
                if (max < temp) {
                    max = temp;
                }
            }
        }
        return max;
    }

    public static int getMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] arr : matrix) {
            for (int temp : arr) {
                if (min > temp) {
                    min = temp;
                }
            }
        }
        return min;
    }

    public static int getAverage(int[][] matrix) {
        int numElements = matrix.length * matrix[0].length;
        int sum = 0;
        for (int[] arr : matrix) {
            for (int temp : arr) {
                sum = sum + temp;
            }
        }
        return sum / numElements;
    }

    public static int getRandomInt(int a, int b) {
        next = (next * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1);
        String s = String.valueOf(next / 3).substring(0, 6);
        return a + (int) (Double.parseDouble("0." + s) * (double) (b - a));
    }

    public static void main(String[] args) {

        int[][] matrix = newMatrix(10, 5, 1, 20);
        print(matrix);
        System.out.println("max element: " + getMax(matrix));
        System.out.println("min element: " + getMin(matrix));
        System.out.println("average : " + getAverage(matrix));
    }
}
