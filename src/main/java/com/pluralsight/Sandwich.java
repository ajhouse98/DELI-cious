package com.pluralsight;

import java.util.List;

public class Sandwich {
    private int sandwichLength;
    private double price;
    private boolean isToasted;
    private List<String> meats;
    private List<String> cheeses;
    private List<String> toppings;
    private List<String> sauces;

    public Sandwich(int sandwichLength, boolean isToasted, List<String> meats, List<String> cheeses, List<String> toppings, List<String> sauces) {
        this.sandwichLength = sandwichLength;
        this.isToasted = isToasted;
        this.meats = meats;
        this.cheeses = cheeses;
        this.toppings = toppings;
        this.sauces = sauces;
        calculatePrice();
    }

    private void calculatePrice() {
        switch (sandwichLength) {
            case 4 -> price = 5.50;
            case 8 -> price = 7.50;
            case 12 -> price = 8.50;
        }

        double meatPrice = meats.size() * (1.00 + (0.50 * (sandwichLength / 4 - 1)));
        double cheesePrice = cheeses.size() * (0.75 * sandwichLength / 4);
        price += meatPrice + cheesePrice;
    }

    public double getTotalPrice() {
        return price;
    }

    public String getSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Sandwich length: ").append(sandwichLength).append("\"").append("\n");
        summary.append("Toasted: ").append(isToasted ? "Yes" : "No").append("\n");
        summary.append("*** Meats ***\n");
        for (String meat : meats) {
            summary.append(meat).append("\n");
        }
        summary.append("*** Cheeses ***\n");
        for (String cheese : cheeses) {
            summary.append(cheese).append("\n");
        }
        summary.append("*** Toppings ***\n");
        for (String topping : toppings) {
            summary.append(topping).append("\n");
        }
        summary.append("*** Sauces ***\n");
        for (String sauce : sauces) {
            summary.append(sauce).append("\n");
        }
        summary.append("Total Price: $").append(price).append("\n");
        return summary.toString();
    }
}
