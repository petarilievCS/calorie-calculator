import java.util.Locale;
import java.util.Scanner;

public class CalorieCalculator {

    // TODO: Fix newline issue

    /**
     * Take in information from user (gender, weight, height, age and goal)
     * Set user variables according to input
     *
     * @param user
     */
    public static void takeInfo(User user) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your measurement system (Metric/Imperial): ");
        user.unit = scan.nextLine().trim().toLowerCase();

        while (!user.unit.equals("metric") && !user.unit.equals("imperial")) {
            System.out.print("Please enter a valid choice: ");
            user.unit = scan.nextLine().trim().toLowerCase();
        }

        System.out.print("\nEnter your gender (M/F): ");
        user.gender = scan.nextLine().trim().toLowerCase();

        while (!user.gender.equals("m") && !user.gender.equals("f")) {
            System.out.print("Please enter a valid choice (M/F): ");
            user.gender = scan.nextLine().trim().toLowerCase();
        }

        System.out.print("\nEnter your age: ");
        // Ensure user enters an integer
        while (!scan.hasNextInt()) {
            System.out.print("Please enter a number: ");
            scan.nextLine();
        }
        user.age = scan.nextInt();

        if (user.unit.equals("metric")) {

            System.out.print("\nEnter your height (in cm): ");
            scan.nextLine();
            while (!scan.hasNextInt()) {
                System.out.print("Please enter a number: ");
                scan.nextLine();
            }
            user.height = scan.nextInt();

            System.out.print("\nEnter your weight (in kg): ");
            scan.nextLine();
            while (!scan.hasNextDouble()) {
                System.out.print("Please enter a number: ");
                scan.nextLine();
            }
            user.weight = scan.nextDouble();

        } else {

            System.out.println("\nEnter your height ");
            System.out.print("Feet: ");
            scan.nextLine();
            while (!scan.hasNextInt()) {
                System.out.print("Please enter a number: ");
                scan.nextLine();
            }
            user.height = (int) (scan.nextInt() * 30.48);

            System.out.print("Inches: ");
            scan.nextLine();
            while (!scan.hasNextInt()) {
                System.out.print("Please enter a number: ");
                scan.nextLine();
            }
            user.height += (int) (scan.nextInt() * 2.54);

            System.out.print("\nPlease enter your weight (in lbs): ");
            scan.nextLine();
            while (!scan.hasNextDouble()) {
                System.out.print("Please enter a number: ");
                scan.nextLine();
            }
            user.weight = scan.nextDouble() / User.KG_TO_LBS;

        }

        System.out.print("\nChoose your goal: \n * Cut\n * Maintain\n * Bulk\n");
        // reset System.in
        scan.nextLine();
        user.goal = scan.nextLine().trim().toLowerCase();
        while (!user.goal.equals("cut") && !user.goal.equals("maintain")
                && !user.goal.equals("bulk")) {
            System.out.print("Please enter a valid choice: ");
            user.goal = scan.nextLine().trim().toLowerCase();
        }

        System.out.print("\nChoose your activity level: \n * Sedentary (no activity)" +
                "\n * Low (1-3 days per week)" +
                "\n * Moderate (3-5 days per week)" +
                "\n * High (6-7 days per week)" +
                "\n * Very High (athlete or physical job\n");
        user.activityLevel = scan.nextLine().trim().toLowerCase();
        while (!user.activityLevel.equals("low") && !user.activityLevel.equals("moderate")
                && !user.activityLevel.equals("high") &&
                !user.activityLevel.equals("sedentary") &&
                !user.activityLevel.equals("very high")) {
            System.out.print("Please enter a valid choice: ");
            user.activityLevel = scan.nextLine().trim().toLowerCase();
        }

    }

    public static void main(String[] args) {

        User currentUser = new User();
        boolean run = true;
        String answer;
        Scanner scan = new Scanner(System.in);

        while (run) {
            takeInfo(currentUser);
            currentUser.calculateBMR();
            currentUser.calculateActivity();
            currentUser.calculateIntake();

            System.out.println("\nCalories: " + currentUser.calorieIntake + " kcal");
            System.out.println("Protein: " + currentUser.proteinIntake + " grams");

            System.out.print("\nDo you want to calculate again? (Y/N): ");
            answer = scan.nextLine().trim().toLowerCase();

            while (!answer.equals("y") && !answer.equals("yes") && !answer.equals("n")
                    && !answer.equals("no")) {
                System.out.println("Please enter a valid choice (Y/N): ");
                answer = scan.nextLine().trim().toLowerCase();
            }

            if (answer.equals("no") || answer.equals("n")) {
                run = false;
            }
            System.out.println();

        }

    }
}
