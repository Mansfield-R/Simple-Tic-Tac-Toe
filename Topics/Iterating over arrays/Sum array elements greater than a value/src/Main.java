import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int counter = 0; // To display at the end

        int sizeOfArray = scanner.nextInt(); // First Variable
        int[] numberArray = new int[sizeOfArray];

        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = scanner.nextInt();
        }

        int n = scanner.nextInt(); // 3rd Variable

        // Check if elements greater:
        for (int j = 0; j < numberArray.length; j++) {
            if (numberArray[j] > n) {
                counter += numberArray[j];
            }
        }

        System.out.println(counter); // End Result
    }
}
