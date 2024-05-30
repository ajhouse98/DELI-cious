package com.pluralsight;

import java.util.List;

public class Sandwich {
    private int sandwichLength; // Length of the sandwich in inches
    private boolean isToasted; // Whether the sandwich is toasted or not
    private List<String> meats; // List of meats in the sandwich
    private List<String> cheeses; // List of cheeses in the sandwich
    private List<String> toppings; // List of additional toppings in the sandwich
    private List<String> sauces; // List of sauces in the sandwich
    protected double price; // Total price of the sandwich

    // Constructor to initialize a Sandwich object with the specified attributes
    public Sandwich(int sandwichLength, boolean isToasted, List<String> meats, List<String> cheeses, List<String> toppings, List<String> sauces) {
        this.sandwichLength = sandwichLength; // Set the sandwich length
        this.isToasted = isToasted; // Set whether the sandwich is toasted or not
        this.meats = meats; // Set the meats in the sandwich
        this.cheeses = cheeses; // Set the cheeses in the sandwich
        this.toppings = toppings; // Set the additional toppings in the sandwich
        this.sauces = sauces; // Set the sauces in the sandwich
        calculatePrice(); // Calculate the total price of the sandwich
    }

    // Private method to calculate the total price of the sandwich
    private void calculatePrice() {
        // Set the base price based on the sandwich length
        switch (sandwichLength) {
            case 4 -> price = 5.50;
            case 8 -> price = 7.50;
            case 12 -> price = 8.50;
        }

        // Calculate additional price based on the number of meats and their portion size
        double meatPrice = meats.size() * (1.00 + (0.50 * (sandwichLength / 4 - 1)));
        // Calculate additional price based on the number of cheeses and their portion size
        double cheesePrice = cheeses.size() * (0.75 * sandwichLength / 4);
        // Add meat and cheese prices to the base price
        price += meatPrice + cheesePrice;
    }

    // Public method to get the total price of the sandwich
    public double getTotalPrice() {
        return price;
    }

    // Public method to get a summary of the sandwich details
    public String getSummary() {
        StringBuilder summary = new StringBuilder(); // StringBuilder to build the summary string
        summary.append("Sandwich length: ").append(sandwichLength).append("\"").append("\n"); // Add sandwich length
        summary.append("Toasted: ").append(isToasted ? "Yes" : "No").append("\n"); // Add whether the sandwich is toasted

        // Add meats
        summary.append("*** Meats ***\n");
        for (String meat : meats) {
            summary.append(meat).append("\n");
        }

        // Add cheeses
        summary.append("*** Cheeses ***\n");
        for (String cheese : cheeses) {
            summary.append(cheese).append("\n");
        }

        // Add additional toppings
        summary.append("*** Toppings ***\n");
        for (String topping : toppings) {
            summary.append(topping).append("\n");
        }

        // Add sauces
        summary.append("*** Sauces ***\n");
        for (String sauce : sauces) {
            summary.append(sauce).append("\n");
        }

        // Add total price
        summary.append("Total Price: $").append(price).append("\n");

        return summary.toString(); // Return the summary string
    }
}