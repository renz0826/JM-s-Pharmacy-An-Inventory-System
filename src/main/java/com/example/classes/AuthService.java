package com.example.classes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AuthService {
    private static List<Path> clientFiles;

    public static Admin logInAdmin(String username, String password) {
        Admin admin = Database.load(Database.getAdminFilePath(), Admin.class);
        
        if (admin == null) {
            System.out.println("Error occured");
            return null;
        }

        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            System.out.println("Admin authorized");
            return admin;
        } else {
            System.out.println("Unauthorized");
            return null;
        }
    }

    public static Pharmacy logInPharmacy(String username, String password) {
        clientFiles = Database.getJsonFilePaths(Database.getPharmaciesDatabasePath());

        for (Path path : clientFiles) {
            if (Files.isRegularFile(path)) {
                Pharmacy pharmacy = Database.load(path, Pharmacy.class);
                if (pharmacy == null) continue;

                if (pharmacy.getUsername().equals(username) && pharmacy.getPassword().equals(password)) {
                    System.out.println("Pharmacy authorized");
                    return pharmacy;
                }
            }
        }
        
        // No credentials matched after traversing through pharmacies
        System.out.println("Unauthorized");
        return null;
    }

    public static Customer logInCustomer(String username, String password) {
        clientFiles = Database.getJsonFilePaths(Database.getCustomersDatabasePath());
        Customer customer;
        for (Path path : clientFiles) {
            if (Files.isRegularFile(path)) {
                customer = Database.load(path, Customer.class);
                if (customer == null) {
                    System.out.println("Error occured");
                    return null;
                }

                if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                    System.out.println("Customer authorized");
                    return customer;
                }
            }
        }
        
        return null;
    }
}
