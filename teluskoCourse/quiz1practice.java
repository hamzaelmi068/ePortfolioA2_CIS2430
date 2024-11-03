import java.util.Scanner;

class quiz1practice {
    public static void main(String[] args) {
        // Write a Java method named "average", which takes an array of integers as a
        // parameter, computes the average of these elements, and returns it to the
        // calling method.
        // int nums[] = { 1, 2, 3, 4, 5 };
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.nextInt();
        }
        double avg = average(arr);
        System.out.println("The avg result is: " + avg);

        int sumResult = sum(arr);
        System.out.println("The sum of array is: " + sumResult);

        /*
         * int[] nums = { 1, 2, 3, 4, 5 };
         * double avg = average(nums);
         * int sum = sum(nums);
         * System.out.println("Average: " + avg);
         * System.out.println("Sum:" + sum);
         */

    }

    public static double average(int[] nums) {
        // sum accumilator
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum = sum + nums[j];
        }
        double average = (double) sum / nums.length;
        return average;
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum = sum + nums[j];
        }
        return sum;
    }
}