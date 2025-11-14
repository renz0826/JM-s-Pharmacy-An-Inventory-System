package com.example.classes;

import java.util.Set;

class Validation {

    // Method for retrieving and validating inputs
    public static int getValidChoice(Set<Integer> validChoices){
        int choice;

            while (true) { 
                System.out.print("\nEnter Choice >> ");
                String input = Input.readString();

                // Validate inputs
                try {
                    choice = Integer.parseInt(input); // Convert strings to int

                    // Checks if integer is one of the allowed choices
                    if (validChoices.contains(choice)){
                        // Input is valid
                        return choice;
                    } else {
                        // Input is numeric but not allowed
                        System.out.println("\nInvalid choice. \nAllowed: " + validChoices + "\n");
                    }
                } catch (NumberFormatException e) {
                    // If input is not numeric
                    System.out.println("\nInvalid input. \nPlease enter an integer.\n");
                }
            }
    }
}
