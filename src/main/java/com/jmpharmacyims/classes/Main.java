package com.jmpharmacyims.classes;

public class Main {
    public static void main(String[] args) {        
        startInventoryMedicineSystem();
    }

    private static void startInventoryMedicineSystem() {
        Database.validateInitialDataFiles();
        UIManager.chooseAccountMenu();
    }
}
