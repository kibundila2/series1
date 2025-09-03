/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseries;

/**
 *
 * @author lab_services_student
 */
public class SeriesModel {
    // model/SeriesModel.java

    private String SeriesId;
    private String SeriesName;
    private String SeriesAge;
    private String SeriesNumberOfEpisodes;


    //Constructor
    public SeriesModel(){}
    public SeriesModel(String SeriesId, String SeriesName, String SeriesAge, String SeriesNumberOfEpisodes){
        this.SeriesId = SeriesId;
        this.SeriesName = SeriesName;
        this.SeriesAge = SeriesAge;
        this.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
    }
    //getters
    public String getSeriesId(){
        return this.SeriesId;
    }

    public String getSeriesName(){
        return this.SeriesName;
    }

    public String getSeriesAge(){
        return this.SeriesAge;
    }

    public String getSeriesNumberOfEpisodes(){
        return this.SeriesNumberOfEpisodes;
    }

    //Setters
    public void setSeriesId(String SeriesId){
        this.SeriesId = SeriesId;
    }

    public void setSeriesName(String SeriesName){
        this.SeriesName = SeriesName;
    }

    public void setSeriesAge(String SeriesAge){
        this.SeriesAge = SeriesAge;
    }


    public void setSeriesNumberOfEpisodes(String SeriesNumberOfEpisodes){
        this.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
    }
}

