public class User {

    public static final double KG_TO_LBS = 2.2;

    protected String gender;
    protected int age;
    protected int height;
    protected double weight;
    protected String goal;
    protected double BMR;
    protected int proteinIntake;
    protected int calorieIntake;
    protected String activityLevel;
    protected String unit;

    /**
     * Uses Muffin-St Jeor formula to calculate user basal metabolic rate (BMR)
     */
    public void calculateBMR() {
        if (gender.equals("m")) {
            BMR = 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            BMR = 10 * weight + 6.25 * height - 5 * age - 161;
        }
    }

    /**
     * Calculates user protein and calorie intake based on goal
     */
    public void calculateIntake() {
        proteinIntake = (int) (0.85 * KG_TO_LBS * weight);

        if (goal.equals("cut")) {
            calorieIntake = (int) (0.8 * calorieIntake);
        } else if (goal.equals("maintain")) {
            calorieIntake = (int) calorieIntake;
        } else {
            calorieIntake = (int) (1.1 * calorieIntake);
        }

        // Rounds calorie intake to 10
        calorieIntake = Math.floorDiv(calorieIntake, 10) * 10;

    }

    /**
     * Adjust calorie intake according to activity level
     */
    public void calculateActivity() {
        if (activityLevel.equals("sedentary")) {
            calorieIntake = (int) (BMR * 1.2);
        }
        else if (activityLevel.equals("low")) {
            calorieIntake = (int) (BMR * 1.375);
        } else if (activityLevel.equals("moderate")) {
            calorieIntake = (int) (BMR * 1.55);
        } else if (activityLevel.equals("high")) {
            calorieIntake = (int) (BMR * 1.725);
        } else if (activityLevel.equals("very high")) {
            calorieIntake = (int) (BMR * 1.9);
        }
    }

}
