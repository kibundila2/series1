package com.mycompany.tvseries;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello word");
        Scanner scanner = new Scanner(System.in);
        SeriesCore  series = new SeriesCore(scanner);
        series.StartSeriesApplication();
    }
}
