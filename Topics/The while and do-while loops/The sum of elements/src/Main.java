import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int givenNumber = 1;
        int sum = 0;

        while (givenNumber != 0) {
            givenNumber = scanner.nextInt();
            sum += givenNumber;
        }
        System.out.println(sum);
    }
}
