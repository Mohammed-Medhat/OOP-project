package subscription_plan;

import java.util.Date;

public class InBody {
    private Date dateOfInBody;
    private double height; // in meters
    private double totalWeight; // in kilograms
    private double bodyFatMass; // in kilograms
    private double minerals; // in kilograms
    private double totalBodyWater; // in kilograms
    private double protein; // in kilograms

    // Constructor
    public InBody(Date dateOfInBody, double height, double totalWeight, double bodyFatMass,
                  double minerals, double totalBodyWater, double protein) {
        this.dateOfInBody = dateOfInBody;
        this.height = height;
        this.totalWeight = totalWeight;
        this.bodyFatMass = bodyFatMass;
        this.minerals = minerals;
        this.totalBodyWater = totalBodyWater;
        this.protein = protein;
    }

    // Getters and Setters
    public Date getDateOfInBody() {
        return dateOfInBody;
    }

    public void setDateOfInBody(Date dateOfInBody) {
        this.dateOfInBody = dateOfInBody;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public double getBodyFatMass() {
        return bodyFatMass;
    }

    public void setBodyFatMass(double bodyFatMass) {
        this.bodyFatMass = bodyFatMass;
    }

    public double getMinerals() {
        return minerals;
    }

    public void setMinerals(double minerals) {
        this.minerals = minerals;
    }

    public double getTotalBodyWater() {
        return totalBodyWater;
    }

    public void setTotalBodyWater(double totalBodyWater) {
        this.totalBodyWater = totalBodyWater;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public boolean canPerformInBodyMeasurement() {
        if (dateOfInBody == null) {
            // No previous measurement, customer is allowed
            return true;
        }

        // Calculate the time difference in milliseconds
        long timeDifference = System.currentTimeMillis() - dateOfInBody.getTime();

        // Convert milliseconds to days (1 day = 24 * 60 * 60 * 1000 milliseconds)
        long daysDifference = timeDifference / (24 * 60 * 60 * 1000);

        // Check if it's been more than a month since the last measurement
        return daysDifference >= 30;
    }

    // Record a new subscription_plan.InBody measurement
    public void recordInBodyMeasurement(Date dateOfInBody, double height, double totalWeight, double bodyFatMass,
                                        double minerals, double totalBodyWater, double protein) {
        if (canPerformInBodyMeasurement()) {
            this.dateOfInBody = dateOfInBody;
            this.height = height;
            this.totalWeight = totalWeight;
            this.bodyFatMass = bodyFatMass;
            this.minerals = minerals;
            this.totalBodyWater = totalBodyWater;
            this.protein = protein;
            System.out.println("subscription_plan.InBody measurement recorded successfully.");
        } else {
            System.out.println("Sorry, you are allowed to perform only one subscription_plan.InBody measurement every month.");
        }
    }

    @Override
    public String toString() {
        return "subscription_plan.InBody{" +
                "dateOfInBody=" + dateOfInBody +
                ", height=" + height +
                ", totalWeight=" + totalWeight +
                ", bodyFatMass=" + bodyFatMass +
                ", minerals=" + minerals +
                ", totalBodyWater=" + totalBodyWater +
                ", protein=" + protein +
            '}';}
}