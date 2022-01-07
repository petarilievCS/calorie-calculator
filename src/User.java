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

    /**
     * Uses Muffin-St Jeor formula to calculate user basal metabolic rate (BMR)
     */
    public void calculateBMR() {
        if (gender.equals("M")) {
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

        if (goal.equals("Cut")) {
            calorieIntake = (int) (0.8 * BMR);
        } else if (goal.equals("Maintain")) {
            calorieIntake = (int) BMR;
        } else {
            calorieIntake = (int) (1.1 * BMR);
        }

        // Rounds calorie intake to 10
        calorieIntake = Math.floorDiv(calorieIntake, 10) * 10;
    }

}
