package org.launchcode.techjobs_oo;

import java.lang.reflect.Field;


public class  Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        return id == job.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String toString(Job job) {

        if (id > 0 && name.isEmpty() && employer.toString().isEmpty() && location.toString().isEmpty()
                && positionType.toString().isEmpty() && coreCompetency.toString().isEmpty()) {
            return "OOPS! This job does not seem to exist.";
        }

        for (Field f : job.getClass().getDeclaredFields()) {
            if (f.getName() == "name" && name.isEmpty()) {
                job.setName("Data not available");
            } else if (f.getName() == "employer" && employer.toString().isEmpty()) {
                job.setEmployer(new Employer("Data not available"));
            } else if (f.getName() == "location" && location.toString().isEmpty()) {
                job.setLocation(new Location("Data not available"));
            } else if (f.getName() == "positionType" && positionType.toString().isEmpty()) {
                job.setPositionType(new PositionType("Data not available"));
            } else if (f.getName() == "coreCompetency" && coreCompetency.toString().isEmpty()) {
                job.setCoreCompetency(new CoreCompetency("Data not available"));
            }
        }

        return "ID:  " + job.getId() + " \n" +
                "Name:  " + job.getName() + " \n" +
                "Employer:  " + job.getEmployer() + " \n" +
                "Location:  " + job.getLocation() + " \n" +
                "Position Type:  " + job.getPositionType() + " \n" +
                "Core Competency:  " + job.getCoreCompetency() + " ";
        }
}

