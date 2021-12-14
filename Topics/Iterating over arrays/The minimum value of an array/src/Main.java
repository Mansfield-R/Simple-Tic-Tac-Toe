import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sizeOfArray = scanner.nextInt(); // First Variable
        int[] numberArray = new int[sizeOfArray];

        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = scanner.nextInt();
        }

        // Order the Array:
        Arrays.sort(numberArray);

        System.out.println(numberArray[0]); // End Result
    }
}
