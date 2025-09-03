/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tvseries;

/**
 *
 * @author lab_services_student
 */

import java.util.Scanner;
/*
public class TvSeries {

    public static void main(String[] args) {
     
        
System.out.println("latest series- 2025");
System.out.println(" Enter (1) to launch menu or any other key 6 to exit");
    

        SeriesCore s = new SeriesCore();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1) Capture Series");
            System.out.println("2) Search Series");
            System.out.println("3) Update Series");
            System.out.println("4) Delete Series");
            System.out.println("5) Series Report");
            System.out.println("6) Exit");
            System.out.print("Select option: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> s.CaptureSeries();
                case "2" -> {
                    System.out.print("Enter Series ID: ");
                    var r = s.SearchSeries(sc.nextLine().trim());
                    System.out.println(r == null ? "No data found." : format(r));
                }
                case "3" -> {
                    System.out.print("Enter Series ID to update: ");
                    System.out.println(s.UpdateSeries(sc.nextLine().trim()) ? "Updated." : "Series not found.");
                }
                case "4" -> {
                    System.out.print("Enter Series ID to delete: ");
                    System.out.println(s.DeleteSeries(sc.nextLine().trim()) ? "Deleted." : "Series not found.");
                }
                case "5" -> s.SeriesReport();
                case "6" -> {
                    s.ExitSeriesApplication();
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    static String format(SeriesModel m) {
        return "ID: " + m.SeriesId + " | Name: " + m.SeriesName +
               " | Age: " + m.SeriesAge + " | Episodes: " + m.SeriesNumberOfEpisodes;
    }
}


*/

    

