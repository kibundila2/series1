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


    public String SeriesId;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisodes;
    
 
    public SeriesModel() {
        
    }

    public SeriesModel(String id, String name, String age, String episodes) {
        this.SeriesId = id;
        this.SeriesName = name;
        this.SeriesAge = age;
        this.SeriesNumberOfEpisodes = episodes;
    }
}

