import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class CalorieCalculator {

    private static final ArrayList<Character> INTEGERS_LIST = new ArrayList(Arrays.asList('1', '2',
            '3', '4', '5', '6', '7', '8', '9', '0'));

    /**
     * Check whether a string can be converted into an integer.
     * @param s input string
     * @return true if s can be converted to integer, false otherwise
     */
    public static boolean isInteger(String s) {
        // remove whitespace
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            if (!(INTEGERS_LIST.contains(s.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check whether a string can be converted into a double
     * @param s input string
     * @return ture if s can be converted to double, false otherwise
     */
    public static boolean isDouble(String s) {
        s = s.trim();
        int dotCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                if (dotCount == 0) {
                    dotCount++;
                } else {
                    return false;
                }
            } else {
                if (!(INTEGERS_LIST.contains(s.charAt(i)))) {
                    return false;
                }
            }
        }
        return true;
    }

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
        String ageStr = scan.nextLine();
        // Ensure user enters an integer
        while (ageStr.trim().length() == 0 || !isInteger(ageStr)) {
            System.out.print("Please enter a number: ");
            ageStr = scan.nextLine();
        }
        user.age = Integer.parseInt(ageStr.trim());

        if (user.unit.equals("metric")) {

            System.out.print("\nEnter your height (in cm): ");
            String cmStr = scan.nextLine();
            while (cmStr.trim().length() == 0 || !isInteger(cmStr)) {
                System.out.print("Please enter a number: ");
                cmStr = scan.nextLine();
            }
            user.height = Integer.parseInt(cmStr.trim());

            System.out.print("\nEnter your weight (in kg): ");
            String kgStr = scan.nextLine();
            while (kgStr.trim().length() == 0 || kgStr.trim().equals(".") || !isDouble(kgStr)) {
                System.out.print("Please enter a number: ");
                kgStr = scan.nextLine();
            }
            user.weight = Double.parseDouble(kgStr);

        } else {

            System.out.println("\nEnter your height ");
            System.out.print("Feet: ");
            String ftStr = scan.nextLine();
            while (ftStr.trim().length() == 0 || !isInteger(ftStr)) {
                System.out.print("Please enter a number: ");
                ftStr = scan.nextLine();
            }
            user.height = (int) (Integer.parseInt(ftStr.trim()) * 30.48);

            System.out.print("Inches: ");
            String inStr = scan.nextLine();
            while (inStr.trim().length() == 0 || !isInteger(inStr)) {
                System.out.print("Please enter a number: ");
                inStr = scan.nextLine();
            }
            user.height += (int) (Integer.parseInt(inStr.trim()) * 2.54);

            System.out.print("\nPlease enter your weight (in lbs): ");
            String lbStr = scan.nextLine();
            while (lbStr.trim().length() == 0 || lbStr.trim().equals(".") || !isDouble(lbStr)) {
                System.out.print("Please enter a number: ");
                lbStr = scan.nextLine();
            }
            user.weight = Double.parseDouble(lbStr) / User.KG_TO_LBS;

        }

        System.out.print("\nChoose your goal: \n * Cut\n * Maintain\n * Bulk\n");
        // reset System.in
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
