package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProgramRun {
    private Scanner userInput = new Scanner(System.in);
    private List<Sandwich> sandwiches = new ArrayList<>();
    private double totalDrinkPrice;
    private double totalChipPrice;

    public ProgramRun() {
        while (true) {
            System.out.println("""
                    
                    ***** Welcome to DELI-cious, *****
                     "Where everything is nutritious!"

                    Make your custom sandwich here!
                                        
                    """);
            System.out.print("""
                    
                    ***** Home Screen *****
                                        
                    1) New Order
                    0) Exit 
                    
                    Please make a selection: """);
            int option = userInput.nextInt();
            userInput.nextLine();

            switch (option) {
                case 1 -> sandwichOrder();
                case 0 -> System.exit(0);
            }
        }
    }

    private void sandwichOrder() {
        while (true) {
            System.out.print("""
                    
                    ***** Order Menu *****
                                
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    0) Cancel Order
                    
                    Please make a selection: """);
            int option = userInput.nextInt();

            switch (option) {
                case 1 -> addSandwich();
                case 2 -> addDrink();
                case 3 -> addChips();
                case 4 -> {
                    checkout();
                    return;
                }
                case 0 -> {
                    System.out.println("Cancelling order... Returning to Home Screen");
                    return;
                }
            }
        }
    }

    private void addSandwich() {
        boolean addMore;
        do {
            int sizeOption = 0;
            while (sizeOption < 1 || sizeOption > 3) {
                System.out.print("""
                
                *** Sandwich Size ***
                1) 4"
                2) 8"
                3) 12"
                
                What size would you like?: """);
                try {
                    sizeOption = Integer.parseInt(userInput.nextLine());
                    if (sizeOption < 1 || sizeOption > 3) {
                        System.out.println("Invalid input. Please select a valid size (1-3).");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                }
            }

            int sandwichLength = switch (sizeOption) {
                case 1 -> 4;
                case 2 -> 8;
                case 3 -> 12;
                default -> 0; // This should never happen due to input validation
            };

            System.out.print("""
                *** Breads *** 
                White
                Wheat
                Rye
                Wrap
                
                Please select your bread of choice: """);
            String breadType = userInput.nextLine();

            boolean isToasted = getBooleanInput("Do you want it toasted? (yes/no): ");

            List<String> meats = new ArrayList<>();
            System.out.println("\n*** Meats ***\n");
            if (getBooleanInput("Do you want steak? (yes/no): ")) meats.add("Steak");
            if (getBooleanInput("Do you want ham? (yes/no): ")) meats.add("Ham");
            if (getBooleanInput("Do you want salami? (yes/no): ")) meats.add("Salami");
            if (getBooleanInput("Do you want roast beef? (yes/no): ")) meats.add("Roast Beef");
            if (getBooleanInput("Do you want chicken? (yes/no): ")) meats.add("Chicken");
            if (getBooleanInput("Do you want bacon? (yes/no): ")) meats.add("Bacon");

            List<String> cheeses = new ArrayList<>();
            System.out.println("\n*** Cheeses ***\n");
            if (getBooleanInput("Do you want American cheese? (yes/no): ")) cheeses.add("American");
            if (getBooleanInput("Do you want provolone cheese? (yes/no): ")) cheeses.add("Provolone");
            if (getBooleanInput("Do you want cheddar cheese? (yes/no): ")) cheeses.add("Cheddar");
            if (getBooleanInput("Do you want Swiss cheese? (yes/no): ")) cheeses.add("Swiss");

            List<String> toppings = new ArrayList<>();
            if (getBooleanInput("Would you like additional toppings? (yes/no): ")) {
                System.out.println("\n*** Toppings ***\n");
                if (getBooleanInput("Do you want lettuce? (yes/no): ")) toppings.add("Lettuce");
                if (getBooleanInput("Do you want peppers? (yes/no): ")) toppings.add("Peppers");
                if (getBooleanInput("Do you want onions? (yes/no): ")) toppings.add("Onions");
                if (getBooleanInput("Do you want tomatoes? (yes/no): ")) toppings.add("Tomatoes");
                if (getBooleanInput("Do you want jalapenos? (yes/no): ")) toppings.add("Jalapenos");
                if (getBooleanInput("Do you want cucumbers? (yes/no): ")) toppings.add("Cucumbers");
                if (getBooleanInput("Do you want pickles? (yes/no): ")) toppings.add("Pickles");
                if (getBooleanInput("Do you want guacamole? (yes/no): ")) toppings.add("Guacamole");
                if (getBooleanInput("Do you want mushrooms? (yes/no): ")) toppings.add("Mushrooms");
            }

            List<String> sauces = new ArrayList<>();
            System.out.println("\n*** Sauces ***\n");
            if (getBooleanInput("Do you want mayo? (yes/no): ")) sauces.add("Mayo");
            if (getBooleanInput("Do you want mustard? (yes/no): ")) sauces.add("Mustard");
            if (getBooleanInput("Do you want ketchup? (yes/no): ")) sauces.add("Ketchup");
            if (getBooleanInput("Do you want ranch? (yes/no): ")) sauces.add("Ranch");
            if (getBooleanInput("Do you want Thousand Islands? (yes/no): ")) sauces.add("Thousand Islands");
            if (getBooleanInput("Do you want vinaigrette? (yes/no): ")) sauces.add("Vinaigrette");

            Sandwich newSandwich = new Sandwich(sandwichLength, isToasted, meats, cheeses, toppings, sauces);
            sandwiches.add(newSandwich);
            System.out.println("\nSandwich added to your order!\n");

            addMore = getBooleanInput("Would you like to add another sandwich? (yes/no): ");
        } while (addMore);
    }

    private void addDrink() {
        System.out.print("""
                
                *** Drinks ***
                                
                1) Sprite
                2) Coca Cola
                3) Fanta
                4) Root Beer
                5) Pepsi
                6) Dr. Pepper
                
                Please select a drink: """);
        int drinkOption = userInput.nextInt();
        userInput.nextLine(); // Consume the newline

        if (drinkOption >= 1 && drinkOption <= 6) {
            System.out.print("""
                    
                    1) Small ($2.00)
                    2) Medium ($2.50)
                    3) Large ($3.00)
                    
                    Please select a size: """);
            int sizeOption = userInput.nextInt();
            userInput.nextLine(); // Consume the newline

            switch (sizeOption) {
                case 1 -> totalDrinkPrice += 2.00;
                case 2 -> totalDrinkPrice += 2.50;
                case 3 -> totalDrinkPrice += 3.00;
            }
        }
    }

    private void addChips() {
        System.out.println("""
                
                *** Chips ***
                                
                1) Lays
                2) Ruffles
                3) Pringles
                4) Doritos
                5) Fritos
                6) Cheetos
                
                Please select a chip: """);

        int chipOption = userInput.nextInt();
        userInput.nextLine(); // Consume the newline

        if (chipOption >= 1 && chipOption <= 6) {
            totalChipPrice += 1.50; // Assuming all chips are priced at $1.50 each
        }
    }

    private void checkout() {
        if (!sandwiches.isEmpty()) {
            System.out.println("\n*** Order Summary ***");
            StringBuilder summary = new StringBuilder();
            double totalPrice = 0;
            for (Sandwich sandwich : sandwiches) {
                String sandwichSummary = sandwich.getSummary();
                summary.append(sandwichSummary).append("\n");
                totalPrice += sandwich.getTotalPrice();
            }
            System.out.println(summary.toString());
            System.out.println("Drink Price: $" + totalDrinkPrice);
            System.out.println("Chip Price: $" + totalChipPrice);
            totalPrice += totalDrinkPrice + totalChipPrice;
            System.out.println("Total Order Price: $" + totalPrice);
            saveOrderToFile(summary + "Drink Price: $" + totalDrinkPrice + "\nChip Price: $" +
                    totalChipPrice + "\nTotal Order Price: $" + totalPrice);
        } else {
            System.out.println("No sandwich added.");
        }
    }

    private void saveOrderToFile(String orderSummary) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
        Date date = new Date();
        String fileName = "Receipts/" + formatter.format(date) + ".txt";

        try {
            File directory = new File("Receipts");

            FileWriter writer = new FileWriter(fileName);
            writer.write(orderSummary);
            writer.close();
            System.out.println("\nOrder has been saved");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the order.");
            e.printStackTrace();
        }
    }

    private boolean getBooleanInput(String message) {
        System.out.print(message);
        String input = userInput.next().toLowerCase();
        while (!input.equals("yes") && !input.equals("no")) {
            System.out.println("Please enter 'yes' or 'no'.");
            System.out.print(message);
            input = userInput.next().toLowerCase();
        }
        return input.equals("yes");
    }
}