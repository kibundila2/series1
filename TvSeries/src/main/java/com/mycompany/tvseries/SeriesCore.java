/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseries;

/**
 *
 * @author lab_services_student
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class SeriesCore {




    private final List<SeriesModel> db = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

   
    public boolean isValidAge(String input) {
        try {
            int age = Integer.parseInt(input.trim());
            return age >= 2 && age <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

  
    public void CaptureSeries() {
        SeriesModel m = new SeriesModel();
        System.out.print("Enter Series ID: ");
        m.SeriesId = sc.nextLine().trim();

        System.out.print("Enter Series Name: ");
        m.SeriesName = sc.nextLine().trim();

        String age;
        while (true) {
            System.out.print("Enter Age Restriction (2–18): ");
            age = sc.nextLine().trim();
            if (isValidAge(age)) break;
            System.out.println("Invalid age. Try again.");
        }
        m.SeriesAge = age;

        System.out.print("Enter Number of Episodes: ");
        m.SeriesNumberOfEpisodes = sc.nextLine().trim();

        db.add(m);
        System.out.println("Series details have been successfully saved.");
    }

   
    public SeriesModel SearchSeries(String id) {
        return db.stream()
                 .filter(x -> x.SeriesId.equalsIgnoreCase(id))
                 .findFirst()
                 .orElse(null);
    }

   
    public boolean UpdateSeries(String id) {
        SeriesModel m = SearchSeries(id);
        if (m == null) return false;

        System.out.print("New Name (enter to keep '" + m.SeriesName + "'): ");
        String name = sc.nextLine();
        if (!name.isBlank()) m.SeriesName = name.trim();

        while (true) {
            System.out.print("New Age (2–18, enter to keep '" + m.SeriesAge + "'): ");
            String a = sc.nextLine();
            if (a.isBlank() || isValidAge(a)) {
                if (!a.isBlank()) m.SeriesAge = a.trim();
                break;
            }
            System.out.println("Invalid age.");
        }

        System.out.print("New Number of Episodes (enter to keep '" + m.SeriesNumberOfEpisodes + "'): ");
        String ep = sc.nextLine();
        if (!ep.isBlank()) m.SeriesNumberOfEpisodes = ep.trim();

        System.out.println("Series updated.");
        return true;
    }

    
    public boolean DeleteSeries(String id) {
        SeriesModel m = SearchSeries(id);
        if (m == null) return false;

        System.out.print("Are you sure you want to delete '" + m.SeriesName + "'? (Y/N): ");
        String ans = sc.nextLine().trim();
        if (ans.equalsIgnoreCase("Y")) {
            db.remove(m);
            System.out.println("Series deleted.");
            return true;
        }
        System.out.println("Delete cancelled.");
        return false;
    }

   
    public void SeriesReport() {
        System.out.println("\n=== SERIES REPORT ===");
        if (db.isEmpty()) {
            System.out.println("No series captured.");
            return;
        }
        for (var m : db) {
            System.out.printf("ID: %-8s | Name: %-20s | Age: %-2s | Episodes: %s%n",
                    m.SeriesId, m.SeriesName, m.SeriesAge, m.SeriesNumberOfEpisodes);
        }
    }

  
    public void ExitSeriesApplication() {
        System.out.println("Exiting...");
        System.exit(0);
    }

  
    public void testAdd(SeriesModel m) { db.add(m); }

    public boolean testDeleteBypassConfirm(String id) {
        SeriesModel m = SearchSeries(id);
        if (m == null) return false;
        db.remove(m);
        return true;
    }
}
