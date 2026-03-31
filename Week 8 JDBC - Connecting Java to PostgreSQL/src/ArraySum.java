public class ArraySum {

    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {   // for-each loop
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, 9, 5};
        int total = sumArray(numbers);
        System.out.println("Sum: " + total);  // Output: Sum: 26
    }
}
