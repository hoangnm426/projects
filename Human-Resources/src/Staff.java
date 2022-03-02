/*
* Staff class
* */

import java.io.Serializable;

public abstract class Staff implements Serializable {
    private String staffId;
    private String staffName;
    private int staffAge;
    private float coefficientsSalary;
    private String startingDate;
    private String workingDepartment;
    private int numberOfDayOff;
    private double salary;

    abstract void displayInformation();

    public Staff() {
    }

    public Staff(String staffId, String staffName, int staffAge, float coefficientsSalary, String startingDate,
                 String workingDepartment, int numberOfDayOff, double salary) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffAge = staffAge;
        this.coefficientsSalary = coefficientsSalary;
        this.startingDate = startingDate;
        this.workingDepartment = workingDepartment;
        this.numberOfDayOff = numberOfDayOff;
        this.salary = salary;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(int staffAge) {
        this.staffAge = staffAge;
    }

    public float getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(float coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getWorkingDepartment() {
        return workingDepartment;
    }

    public void setWorkingDepartment(String workingDepartment) {
        this.workingDepartment = workingDepartment;
    }

    public int getNumberOfDayOff() {
        return numberOfDayOff;
    }

    public void setNumberOfDayOff(int numberOfDayOff) {
        this.numberOfDayOff = numberOfDayOff;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
