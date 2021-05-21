package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import static org.junit.Assert.*;
import org.launchcode.techjobs_oo.*;

public class JobTest {

    @Test
    public void testSettingJobId(){
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertEquals(testJob1.getId(),testJob2.getId()-1);
        assertEquals(testJob2.getId(), testJob1.getId()+1);
    }

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

    @Test
    public void testJobsForEquality() {
        Job testJob4 =  new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality control"), new CoreCompetency("Persistence"));
        Job testJob5 =  new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality control"), new CoreCompetency("Persistence"));

        assertFalse(testJob4.equals(testJob5));
    }
}
