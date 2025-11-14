package com.example.classes;

import java.util.Scanner;

public class Input {
    private static final Scanner SCAN = new Scanner(System.in);

    public static String readString() {
        return SCAN.nextLine();
    }

    public static int readInteger() {
        return SCAN.nextInt();
    }
}
