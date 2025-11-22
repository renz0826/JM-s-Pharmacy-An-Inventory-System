package com.example.classes;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pharmacy extends Account {
    // Necessary initializations
    private List<Medicine> medicines;

    @JsonCreator
    Pharmacy(
        @JsonProperty("name") String name, 
        @JsonProperty("username") String username, 
        @JsonProperty("password") String password,
        @JsonProperty("medicines") List<Medicine> medicines
    ) {
        super(name, username, password);
        this.medicines = medicines;
    }

    // CRUD Methods
    public void addMedicine() {
        // Prompt line and Input validation
        System.out.println("Enter medicine details.");
        String name = InputHandler.readNonEmptyLine("Name: ");
        double price = InputHandler.readDouble("Price (PHP): ");
        int amount = InputHandler.readInt("Initial amount: ");
        String expirationDate = InputHandler.readDate("Expiration Date (d/m/yyyy): ");
        String brand = InputHandler.readNonEmptyLine("Brand: ");
        String purpose = InputHandler.readNonEmptyLine("Purpose: ");

        // Save sanitized inputs to database
        Medicine newMedicine = new Medicine(name, brand, purpose, expirationDate, amount, price);
        medicines.add(newMedicine);
        Database.save(this);
    }

    public void searchMedicine() {}
    public void updateMedicineAmount() {}
    public void updateMedicinePrice() {}
    public void deleteMedicine() {}

    // Getters
    public List<Medicine> getMedicines() {
        return medicines;
    }

    // Test methods
    @Override
    public void details() {
        super.details();
        for (Medicine medicine : medicines) {
            medicine.details();
        }
    }
}