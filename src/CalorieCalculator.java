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

        System.out.print("Enter your weight (in kg): ");
        while(!scan.hasNextDouble()) {
            System.out.print("Please enter a number: ");
            scan.next();
        }
        user.weight = scan.nextDouble();

        System.out.print("Choose your goal: \n * Cut\n * Maintain\n * Bulk\n");
        user.goal = scan.next();
        while (!user.goal.equals("Cut") && !user.goal.equals("Maintain")
                && !user.goal.equals("Bulk")) {
            System.out.print("Please enter a valid choice: ");
            user.goal = scan.next();
        }

        System.out.print("Choose your activity level: \n * Sedentary (no activity)" +
                "\n * Low (1-3 days per week)" +
                "\n * Moderate (3-5 days per week)" +
                "\n * High (6-7 days per week)" +
                "\n * Very High (athlete or physical job)\n");
        user.activityLevel = scan.next();
        while (!user.activityLevel.equals("Low") && !user.activityLevel.equals("Moderate")
                && !user.activityLevel.equals("High") &&
                !user.activityLevel.equals("Sedentary") &&
                !user.activityLevel.equals("Very High")) {
            System.out.print("Please enter a valid choice: ");
            user.activityLevel = scan.next();
        }

    }

    public static void main(String[] args) {

        User currentUser = new User();
        takeInfo(currentUser);
        currentUser.calculateBMR();
        currentUser.calculateActivity();
        currentUser.calculateIntake();

        System.out.println("Calories: " + currentUser.calorieIntake + " kcal");
        System.out.println("Protein: " + currentUser.proteinIntake + " grams of protein");

    }
}
