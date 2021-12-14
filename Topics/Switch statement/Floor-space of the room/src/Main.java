import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        double a = 0.0;
        double b = 0.0;
        double c = 0.0;
        double r = 0.0;
        double area = 0.0;
        double perimeter = 0.0;
        double pie = 3.14;

        Scanner scanner = new Scanner(System.in);
        // start coding here
        String format = scanner.nextLine();
        // Switch:
        switch (format) {
            case "triangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                c = scanner.nextDouble();
                perimeter = (a + b + c) / 2.0;
                // Have to use Heron's Formula here since only sides were given:
                area = Math.sqrt(perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c));
                System.out.println(area);
                break;
            case "rectangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                area = a * b;
                System.out.println(area);
                break;
            case "circle":
                r = scanner.nextDouble();
                area = pie * (Math.pow(r, 2));
                System.out.println(area);
                break;
            default:
                System.out.println("Unsuitable action, please, try again");
                break;
        }
    }
}
