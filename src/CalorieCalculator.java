import java.util.Scanner;

public class CalorieCalculator {

    /**
     * Take in information from user (gender, weight, height, age and goal)
     * Set user variables according to input
     * @param user
     */
    public static void takeInfo(User user) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your gender (M/F): ");
        user.gender = scan.next();

        while (!user.gender.equals("M") && !user.gender.equals("F")) {
            System.out.print("Please enter a valid choice (M/F): ");
            user.gender = scan.next();
        }

        System.out.print("Enter your age: ");
        // Ensure user enters an integer
        while(!scan.hasNextInt()) {
            System.out.print("Please enter a number: ");
            scan.next();
        }
        user.age = scan.nextInt();

        System.out.print("Enter your height (in cm): ");
        while(!scan.hasNextInt()) {
            System.out.print("Please enter a number: ");
            scan.next();
        }
        user.height = scan.nextInt();

    }

    public static void main(String[] args) {

        User currentUser = new User();
        takeInfo(currentUser);

    }
}
