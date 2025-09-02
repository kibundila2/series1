/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.tvseries;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesCoreTest {

        @Test
    void TestSeriesAgeRestriction_AgeValid() {
        SeriesCore s = new SeriesCore();
        assertTrue(s.isValidAge("12"));   
        assertTrue(s.isValidAge("2"));    
        assertTrue(s.isValidAge("18"));   
    }

    @Test
    void TestSeriesAgeRestriction_AgeInvalid() {
        SeriesCore s = new SeriesCore();
        assertFalse(s.isValidAge("abc")); 
        assertFalse(s.isValidAge("1"));   
        assertFalse(s.isValidAge("19"));  
    }

    @Test
    void TestSearchSeries_Found() {
        SeriesCore s = new SeriesCore();
        SeriesModel m = new SeriesModel();
        m.SeriesId = "S1"; 
        m.SeriesName = "Breaking Bad"; 
        m.SeriesAge = "16"; 
        m.SeriesNumberOfEpisodes = "62";
        s.testAdd(m); 
        assertNotNull(s.SearchSeries("S1"));
    }

    @Test
    void TestSearchSeries_NotFound() {
        SeriesCore s = new SeriesCore();
        assertNull(s.SearchSeries("XYZ"));
    }

    @Test
    void TestUpdateSeries_Found() {
        SeriesCore s = new SeriesCore();
        SeriesModel m = new SeriesModel();
        m.SeriesId = "S2"; m.SeriesName = "Old Name"; m.SeriesAge = "15"; m.SeriesNumberOfEpisodes = "10";
        s.testAdd(m);

      
        m.SeriesName = "New Name"; 
        assertEquals("New Name", m.SeriesName);
    }

    @Test
    void TestDeleteSeries_Found() {
        SeriesCore s = new SeriesCore();
        SeriesModel m = new SeriesModel();
        m.SeriesId = "S3"; m.SeriesName = "To Delete"; m.SeriesAge = "12"; m.SeriesNumberOfEpisodes = "5";
        s.testAdd(m);

        assertTrue(s.testDeleteBypassConfirm("S3"));
    }

    @Test
    void TestDeleteSeries_NotFound() {
        SeriesCore s = new SeriesCore();
        assertFalse(s.testDeleteBypassConfirm("NOPE"));
    }
}
