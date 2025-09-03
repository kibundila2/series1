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
    Scanner scanner;
    List<SeriesModel> seriesList;

    public SeriesCore(Scanner scanner){
        this.scanner = scanner;
        seriesList = new ArrayList<>();
    }

    public void StartSeriesApplication(){
        System.out.println("LATEST SERIES - 2025");
        System.out.println("***************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");

        if(ReadUserInput(this.scanner).equals("1")){
            displayMenu();
        }else{
            ExitSeriesApplication();
        }

    }

    public void displayMenu(){
        System.out.println("***************************************");
        System.out.println("please select one of the following menu items : ");
        System.out.println("(1) Capture a new series.");
        System.out.println("(2) Search for a new series.");
        System.out.println("(3) Update series age restriction.");
        System.out.println("(4) Delete a series.");
        System.out.println("(5) Print series report - 2025");
        System.out.println("(6) Exit Application.");

        switch(ReadUserInput(this.scanner)){
            case "1" : {
                System.out.println("CAPTURE A NEW SERIES");
                System.out.println("*****************************");

                String seriesId = "";
                do {
                    System.out.println("Enter the series id : ");
                    seriesId = ReadUserInput(this.scanner);
                } while(seriesId.isEmpty());

                String seriesName = "";
                do {
                    System.out.println("Enter the series name : ");
                    seriesName = ReadUserInput(this.scanner);
                } while(seriesName.isEmpty());

                System.out.println("Enter the series age restriction : ");
                String seriesAge = ReadUserInput(this.scanner);
                while(isValidAge(seriesAge)==false){
                    System.out.println("You have entered an incorrect series age!!!");
                    System.out.println("Please re-enter the series age");
                    seriesAge = ReadUserInput(this.scanner);
                }

                System.out.println("Enter the number of episodes for "+seriesName+" : ");
                String seriesNumberOfEpisodes = ReadUserInput(this.scanner);

                if(CaptureSeries(seriesId, seriesName, seriesAge, seriesNumberOfEpisodes)!=null){
                    System.out.println("Series processed successfully!!!");

                    System.out.println("Enter (1)  to launch menu or any other key to exit");
                    Back();
                    break;
                }else{
                    System.out.println("Series registration failed!");
                    System.out.println("Enter (1)  to launch menu or any other key to exit");
                    Back();
                    break;
                }

            }
            case "2" : {
                System.out.println("Enter the series id to search : ");
                System.out.println("*****************************");
                String seriesId = ReadUserInput(this.scanner);
                SeriesModel seriesModel = SearchSeries(seriesId);
                if(seriesModel != null){
                    System.out.println("SERIES ID : "+seriesModel.getSeriesId());
                    System.out.println("SERIES NAME : "+seriesModel.getSeriesName());
                    System.out.println("SERIES AGE RESTRICTION : "+seriesModel.getSeriesAge());
                    System.out.println("SERIES NUMBER OF EPISODES : "+seriesModel.getSeriesNumberOfEpisodes());
                } else {
                    System.out.println("*****************************");
                    System.out.println("Series with Series Id : "+seriesId+" was not found!");
                }
                System.out.println("*****************************");
                System.out.println("Enter (1)  to launch menu or any other key to exit");
                Back();
                break;
            }
            case "3": {
                System.out.println("*****************************");
                System.out.println("Enter the series id to update");
                String updateId = ReadUserInput(this.scanner);

                System.out.println("Enter the new series name : ");
                String newName = ReadUserInput(this.scanner);

                System.out.println("Enter the new age restriction : ");
                String newAge = ReadUserInput(this.scanner);

                while (isValidAge(newAge)==false) {
                    System.out.println("Invalid age. Please enter a value between 2 and 18:");
                    newAge = ReadUserInput(this.scanner);
                }

                System.out.println("Enter the new number of episodes : ");
                String newEpisodes = ReadUserInput(this.scanner);
                while(isValideNumber(newEpisodes)==false){
                    System.out.println("Invalid number. Please enter a valid number");
                    newEpisodes = ReadUserInput(this.scanner);
                }

                boolean updated = UpdateSeries(updateId, newName, newAge, newEpisodes);

                if (updated) {
                    System.out.println("Series with ID " + updateId + " updated successfully!");
                } else {
                    System.out.println("Series with ID " + updateId + " was not found.");
                }

                System.out.println("*****************************");
                System.out.println("Enter (1)  to launch menu or any other key to exit");
                Back();
                break;
            }
            case "4": {
                System.out.println("*****************************");
                System.out.println("Enter the series id to delete : ");
                String seriesId = ReadUserInput(this.scanner);
                SeriesModel _series = SearchSeries(seriesId);
                if(_series!=null){
                    System.out.print("Are you sure you want to delete '" + _series.getSeriesName() + "'? (Y/N): ");
                    if (ReadUserInput(this.scanner).equals("Y")){
                        boolean deleted = DeleteSeries(seriesId);
                        if (deleted) {
                            System.out.println("Series " + _series.getSeriesName() + " has been deleted successfully!");
                        }
                    }
                }
                System.out.println("*****************************");
                System.out.println("Enter (1)  to launch menu or any other key to exit");
                Back();
                break;
            }
            case "5" :
                SeriesReport();
                break;
            case "6" :
                ExitSeriesApplication();
                break;
            default :
                Back();
                break;
        }

    }

    public SeriesModel CaptureSeries(String seriesId, String seriesName, String seriesAge, String seriesNumberOfEpisodes){
        try{
            SeriesModel seriesModel = new SeriesModel();
            seriesModel.setSeriesId(seriesId);
            seriesModel.setSeriesName(seriesName);
            seriesModel.setSeriesAge(seriesAge);
            seriesModel.setSeriesNumberOfEpisodes(seriesNumberOfEpisodes);
            this.seriesList.add(seriesModel);
            return seriesModel;
        }catch (Exception e){
            return null;
        }
    }

    public SeriesModel SearchSeries(String seriesId){
        for(SeriesModel _seriesModel : seriesList){
            if(_seriesModel.getSeriesId().equals(seriesId)){
                return _seriesModel;
            }
        }
        return null;
    }

    public boolean UpdateSeries(String seriesId, String newName, String newAge, String newEpisodeCount) {
        for (SeriesModel _seriesModel : seriesList) {
            if (_seriesModel.getSeriesId().equals(seriesId)) {
                _seriesModel.setSeriesName(newName);
                _seriesModel.setSeriesAge(newAge);
                _seriesModel.setSeriesNumberOfEpisodes(newEpisodeCount);
                return true;
            }
        }
        return false;
    }

    public boolean DeleteSeries(String seriesId) {
        return this.seriesList.removeIf(seriesModel -> seriesModel.getSeriesId().equals(seriesId));
    }

    public void SeriesReport(){
        int counter = 0;
        for(SeriesModel _seriesModel : seriesList){
            counter++;
            System.out.println("SERIES "+counter);
            System.out.println("*****************************");
            System.out.println("SERIES ID : "+_seriesModel.getSeriesId());
            System.out.println("SERIES NAME : "+_seriesModel.getSeriesName());
            System.out.println("SERIES AGE RESTRICTION : "+_seriesModel.getSeriesAge());
            System.out.println("SERIES NUMBER OF EPISODES : "+_seriesModel.getSeriesNumberOfEpisodes());
            System.out.println("*****************************");
        }
        System.out.println("*****************************");
        System.out.println("Enter (1)  to launch menu or any other key to exit");
        Back();
    }

    public String ReadUserInput(Scanner scanner){
        return scanner.nextLine().trim();
    }

    public boolean isValidAge(String input) {
        try {
            int age = Integer.parseInt(input.trim());
            return age >= 2 && age <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isValideNumber(String input){
        try{
            int number = Integer.parseInt(input.trim());
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    public void Back(){
        if(ReadUserInput(this.scanner)=="1"){
            displayMenu();
        }else{
            ExitSeriesApplication();
        }
    }
    public void ExitSeriesApplication(){
        System.out.println("Exiting...");
        this.scanner.close();
        System.exit(0);
    }
}
