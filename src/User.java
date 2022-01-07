public class User {

    protected String gender;
    protected int age;
    protected int height;
    protected double weight;
    protected String goal;
    protected double BMR;

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

}
