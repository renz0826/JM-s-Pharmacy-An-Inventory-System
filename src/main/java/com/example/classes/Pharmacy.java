package com.example.classes;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Pharmacy extends Account {
    // Necessary initializations
    private static ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT); // Pretty print json in file
    private List<Medicine> medicines = new ArrayList<>();
    // TODO: these are just test files, make them more adaptable later
    private Path permanentFile = Path.of(Account.ROOT_DIRECTORY, "pharmacies", "tempMed.json");
    private Path temporaryFile = Path.of(permanentFile.toString() + ".tmp"); // temporary filepath

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

        // Overwrite json file
        // XXX: This nested try-catch was created for fun, idk if its a good idea
        try {
            OutputStream output = Files.newOutputStream(temporaryFile); 
            objectMapper.writeValue(output, medicines); // write changes to temporary file
            Files.move(temporaryFile, permanentFile, StandardCopyOption.REPLACE_EXISTING); // replace temporary file name to permanent file name

            System.out.println("Data successfully written to " + permanentFile.toAbsolutePath().toString());
        } catch (NoSuchFileException e) {
            System.err.println("[ERROR]: " + permanentFile + " does not exist");
            System.out.println("[SYSTEM]: Attempting to recreate " + permanentFile);
            try {
                Files.createDirectories(permanentFile);
                System.out.println("[SYSTEM]: " + permanentFile + " created. Please enter the information again.");
            } catch (IOException innerE) {
                System.err.println("[ERROR]: File cannot be created:\n" + e);
            }
        } catch (IOException e) {
            System.err.println("[ERROR]: A file operation error has occured:\n" + e);
        }
    }

    public void searchMedicine() {}
    public void updateMedicineAmount() {}
    public void updateMedicinePrice() {}
    public void deleteMedicine() {}
}