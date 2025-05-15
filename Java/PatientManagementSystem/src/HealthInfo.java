
class HealthInfo {
    private int height, weight;
    private double BMI;

    public HealthInfo(int height, int weight) {
        this.height = height;
        this.weight = weight;
        calcBMI();
    }

    public void calcBMI() {
        this.BMI = this.weight/Math.pow(height/100.0, 2);
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public double getBMI() {
        return BMI;
    }
}
