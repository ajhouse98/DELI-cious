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
    private Scanner userInput = new Scanner(System.in); // Scanner object for user input
    private List<Sandwich> sandwiches = new ArrayList<>(); // List to store sandwiches
    private double totalDrinkPrice; // Total price for drinks
    private double totalChipPrice; // Total price for chips

    public static void main(String[] args) {
        new ProgramRun(); // Start the program
    }

    public ProgramRun() { // Constructor for ProgramRun
        while (true) { // Infinite loop to keep the program running
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
            int option = userInput.nextInt(); // Get user's selection
            userInput.nextLine(); // Consume the newline

            switch (option) { // Switch based on user's selection
                case 1 -> sandwichOrder(); // Start a new sandwich order
                case 0 -> System.exit(0); // Exit the program
            }
        }
    }

    private void sandwichOrder() { // Method to handle sandwich orders
        while (true) { // Infinite loop for sandwich ordering process
            System.out.print("""
                                        
                    ***** Order Menu *****
                                
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    0) Cancel Order
                                        
                    Please make a selection: """);
            int option = userInput.nextInt(); // Get user's selection
            userInput.nextLine(); // Consume the newline

            switch (option) { // Switch based on user's selection
                case 1 -> addSandwich(); // Add a sandwich
                case 2 -> addDrink(); // Add a drink
                case 3 -> addChips(); // Add chips
                case 4 -> { // Checkout
                    checkout();
                    return;
                }
                case 0 -> { // Cancel order
                    System.out.println("Cancelling order... Returning to Home Screen");
                    return;
                }
            }
        }
    }

    private void addSandwich() { // Method to add a sandwich
        boolean addMore; // Flag to determine if the user wants to add more sandwiches
        do {
            int sizeOption = 0; // Variable to store sandwich size option
            while (sizeOption < 1 || sizeOption > 3) { // Loop until a valid size is chosen
                System.out.print("""
                        *** Sandwich Size ***
                        1) 4"
                        2) 8"
                        3) 12"
                                        
                        What size would you like?: """);
                try {
                    sizeOption = Integer.parseInt(userInput.nextLine()); // Get sandwich size from user
                    if (sizeOption < 1 || sizeOption > 3) { // Validate input
                        System.out.println("Invalid input. Please select a valid size (1-3).");
                    }
                } catch (NumberFormatException e) { // Handle invalid input
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                }
            }

            int sandwichLength = switch (sizeOption) { // Determine sandwich length based on user's choice
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
            String breadType = userInput.nextLine(); // Get bread type from user

            boolean isToasted = getBooleanInput("Do you want it toasted? (yes/no): "); // Get toasted option from user

            List<String> meats = new ArrayList<>(); // List to store meats
            System.out.println("\n*** Meats ***\n");
            if (getBooleanInput("Do you want steak? (yes/no): ")) meats.add("Steak");
            if (getBooleanInput("Do you want ham? (yes/no): ")) meats.add("Ham");
            if (getBooleanInput("Do you want salami? (yes/no): ")) meats.add("Salami");
            if (getBooleanInput("Do you want roast beef? (yes/no): ")) meats.add("Roast Beef");
            if (getBooleanInput("Do you want chicken? (yes/no): ")) meats.add("Chicken");
            if (getBooleanInput("Do you want bacon? (yes/no): ")) meats.add("Bacon");

            List<String> cheeses = new ArrayList<>(); // List to store cheeses
            System.out.println("\n*** Cheeses ***\n");
            if (getBooleanInput("Do you want American cheese? (yes/no): ")) cheeses.add("American");
            if (getBooleanInput("Do you want provolone cheese? (yes/no): ")) cheeses.add("Provolone");
            if (getBooleanInput("Do you want cheddar cheese? (yes/no): ")) cheeses.add("Cheddar");
            if (getBooleanInput("Do you want swiss cheese? (yes/no): ")) cheeses.add("Swiss");

            List<String> toppings = new ArrayList<>(); // List to store toppings
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

            List<String> sauces = new ArrayList<>(); // List to store sauces
            System.out.println("\n*** Sauces ***\n");
            if (getBooleanInput("Do you want mayo? (yes/no): ")) sauces.add("Mayo");
            if (getBooleanInput("Do you want mustard? (yes/no): ")) sauces.add("Mustard");
            if (getBooleanInput("Do you want ketchup? (yes/no): ")) sauces.add("Ketchup");
            if (getBooleanInput("Do you want ranch? (yes/no): ")) sauces.add("Ranch");
            if (getBooleanInput("Do you want Thousand Islands? (yes/no): ")) sauces.add("Thousand Islands");
            if (getBooleanInput("Do you want vinaigrette? (yes/no): ")) sauces.add("Vinaigrette");

            // Create a new Sandwich object and add it to the order
            Sandwich newSandwich = new Sandwich(sandwichLength, isToasted, meats, cheeses, toppings, sauces);
            sandwiches.add(newSandwich); // Add the sandwich to the list of sandwiches
            System.out.println("Sandwich added to your order!");

            addMore = getBooleanInput("Would you like to add another sandwich? (yes/no): "); // Ask if the user wants to add more sandwiches
        } while (addMore); // Repeat if the user wants to add more sandwiches
    }

    private void addDrink() { // Method to add a drink
        System.out.print("""
                *** Drinks ***
                                
                1) Sprite
                2) Coca Cola
                3) Fanta
                4) Root Beer
                5) Pepsi
                6) Dr. Pepper
                                
                Please select a drink: """);
        int drinkOption = userInput.nextInt(); // Get user's drink selection
        userInput.nextLine(); // Consume the newline

        if (drinkOption >= 1 && drinkOption <= 6) { // If a valid drink option is selected
            System.out.print("""                    
                    
                    1) Small ($2.00)
                    2) Medium ($2.50)
                    3) Large ($3.00)
                                        
                    Please select a size: """);
            int sizeOption = userInput.nextInt(); // Get drink size from user
            userInput.nextLine(); // Consume the newline

            switch (sizeOption) { // Add the drink price based on size
                case 1 -> totalDrinkPrice += 2.00;
                case 2 -> totalDrinkPrice += 2.50;
                case 3 -> totalDrinkPrice += 3.00;
            }
        }
    }

    private void addChips() { // Method to add chips
        System.out.println("""
                *** Chips ***
                                
                1) Lays
                2) Ruffles
                3) Pringles
                4) Doritos
                5) Fritos
                6) Cheetos
                                
                Please select a chip: """);

        int chipOption = userInput.nextInt(); // Get user's chip selection
        userInput.nextLine(); // Consume the newline

        if (chipOption >= 1 && chipOption <= 6) { // If a valid chip option is selected
            totalChipPrice += 1.50; // Assuming all chips are priced at $1.50 each
        }
    }

    private void checkout() { // Method to handle the checkout process
        if (!sandwiches.isEmpty()) { // Check if there are sandwiches in the order
            System.out.println("\n*** Order Summary ***");
            for (Sandwich sandwich : sandwiches) { // Loop through each sandwich and print its summary
                String summary = sandwich.getSummary();
                System.out.println(summary);
            }
            System.out.println("Total Drink Price: $" + totalDrinkPrice); // Print the total prices for drinks
            System.out.println("Total Chip Price: $" + totalChipPrice); // Print the total prices for chips
            double totalPrice = sandwiches.stream().mapToDouble(Sandwich::getTotalPrice).sum() + totalDrinkPrice + totalChipPrice; // Calculate and print the total order price
            System.out.println("Total Order Price: $" + totalPrice);
            saveOrderToFile("Total Drink Price: $" + totalDrinkPrice + "\nTotal Chip Price: $" + totalChipPrice + "\nTotal Order Price: $" + totalPrice); // Save the order summary to a file
        } else {
            System.out.println("No sandwich added."); // If no sandwich was added
        }
    }

    private void saveOrderToFile(String orderSummary) { // Method to save the order summary to a file
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss"); // Format the current date and time
        Date date = new Date();
        String fileName = "Receipts/" + formatter.format(date) + ".txt";

        try {
            File directory = new File("Receipts"); // Ensure the Receipts directory exists
            if (!directory.exists()) {
                directory.mkdirs();
            }

            FileWriter writer = new FileWriter(fileName); // Write the order summary to the file
            writer.write(orderSummary);
            writer.close();
            System.out.println("Order has been saved to " + fileName); // Confirm the save

        } catch (IOException e) {
            System.out.println("An error occurred while saving the order."); // Handle errors during file writing
            e.printStackTrace();
        }
    }

    private boolean getBooleanInput(String message) { // Method to get a yes/no input from the user
        System.out.print(message); // Print the prompt message
        String input = userInput.next().toLowerCase(); // Read the user's input and convert to lowercase

        while (!input.equals("yes") && !input.equals("no")) { // Loop until the user enters 'yes' or 'no'
            System.out.println("Please enter 'yes' or 'no'.");
            System.out.print(message); // Print the prompt message again
            input = userInput.next().toLowerCase(); // Read the user's input and convert to lowercase
        }
        return input.equals("yes"); // Return true if the input is 'yes', otherwise return false
    }
}
