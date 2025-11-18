package com.example.classes;

public class Main {
    public static void main(String[] args) {        
        // Customer c = new Customer("a", "b");
        // c.login();

        //UIManager.displayLoginChoice();
        //UIManager.displayAdminMenu();
        Pharmacy admin = AuthService.logInPharmacy("jmpharmacy", "jm123");
    }
}
