package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import static org.junit.Assert.*;
import org.launchcode.techjobs_oo.*;

public class JobTest {

    //Test each new Job object has a unique ID number
    @Test
    public void testSettingJobId(){
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertEquals(testJob1.getId(),testJob2.getId()-1);
        assertEquals(testJob2.getId(), testJob1.getId()+1);
    }

    //Test that the Job class constructor properly sets all fields
    @Test
    public void testJobConstructorSetsAllFields(){
       Job testJob3 =  new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
               "Quality control"), new CoreCompetency("Persistence"));

        assertEquals(testJob3.getName(), "Product tester");
        assertEquals(testJob3.getEmployer().toString(), "ACME");
        assertEquals(testJob3.getLocation().toString(), "Desert");
        assertEquals(testJob3.getPositionType().toString(), "Quality control");
        assertEquals(testJob3.getCoreCompetency().toString(), "Persistence");
    }

    //Test that the @override equals method considers two Job objects equals if their ID field is equal
    @Test
    public void testJobsForEquality() {
        Job testJob4 =  new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality control"), new CoreCompetency("Persistence"));
        Job testJob5 =  new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality control"), new CoreCompetency("Persistence"));

        assertFalse(testJob4.equals(testJob5));
    }

    //Test that the @override toString method returns a Job object in the correct format
    @Test
    public void toStringTest(){

        Job testJob6 =  new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob6.toString(testJob6).contentEquals("ID: "+testJob6.getId()+" \n"+
                        "Name: "+testJob6.getName()+" \n" +
                        "Employer: "+testJob6.getEmployer()+" \n" +
                        "Location: "+testJob6.getLocation()+" \n" +
                        "Position Type: "+testJob6.getPositionType()+" \n" +
                        "Core Competency: "+testJob6.getCoreCompetency()+" \n"));

        Job testJob7 =  new Job("Product tester", new Employer(""), new Location(""), new PositionType(
                ""), new CoreCompetency(""));

        assertTrue(testJob7.toString(testJob7).contentEquals("ID: "+testJob7.getId()+" \n"+
                "Name: "+testJob7.getName()+" \n" +
                "Employer: Data not available \n" +
                "Location: Data not available \n" +
                "Position Type: Data not available \n" +
                "Core Competency: Data not available \n"));

        Job testJob8 =  new Job("", new Employer(""), new Location(""), new PositionType(
                ""), new CoreCompetency(""));

        assertTrue(testJob8.toString(testJob8).contentEquals("OOPS! This job does not seem to exist."));
    }
}
