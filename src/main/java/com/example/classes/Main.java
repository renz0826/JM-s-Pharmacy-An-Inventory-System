package com.example.classes;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {        
        // Customer c = new Customer("a", "b");
        // c.login();

        //UIManager.displayLoginChoice();
        //UIManager.displayAdminMenu();
        Pharmacy pharmacy;
        Path path = Path.of("accounts/pharmacies/HealthPlusPharmacy.json");
        try {
            pharmacy = Database.getObjectMapper().readValue(path.toFile(), Pharmacy.class);
            List<Medicine> medicines = pharmacy.getMedicines();
            UIManager.displayData(medicines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
