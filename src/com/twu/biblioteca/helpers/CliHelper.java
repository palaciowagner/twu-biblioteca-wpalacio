package com.twu.biblioteca.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CliHelper {
    public static final String SPACED_LINE = "%-20.30s  %-20.30s  %-20.30s%n";

    public static String getUserInput(String prompt){
        String inputLine = null;
        System.out.print(prompt + " ");
        try{
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0 ) return null;
        }
        catch (IOException e){
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }

    public static void buildFormattedLine(String first, String second, String third) {
        System.out.printf(SPACED_LINE, first, second, third);
    }


}
