package com.mycompany.tvseries;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SeriesCore  series = new SeriesCore(scanner);
        series.StartSeriesApplication();
    }
}
