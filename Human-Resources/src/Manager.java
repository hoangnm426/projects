/*
 * Manager class
 *
 * */

import java.io.Serializable;

public class Manager extends Staff implements Serializable, ICalculator {
    private String title;

    public Manager() {
    }

    public Manager(String staffId, String staffName, int staffAge, float coefficientsSalary, String startingDate,
                   String workingDepartment, int numberOfDayOff, double salary, String title) {
        super(staffId, staffName, staffAge, coefficientsSalary, startingDate, workingDepartment, numberOfDayOff, salary);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    void displayInformation() {
        System.out.printf("%-12s%-30s%-10d%-20.2f%-20s%-20s%-20s%-15d%-10s%-20.2f\n", getStaffId(), getStaffName(),
                getStaffAge(), getCoefficientsSalary(), getStartingDate(), getWorkingDepartment(), getTitle(),
                getNumberOfDayOff(), "", getSalary());
    }

    @Override
    public double calculateSalary() {
        double responsibleWage = 0.0;
        switch (this.title) {
            case "Business Leader":
                responsibleWage = 8000000;
                break;
            case "Project Leader":
                responsibleWage = 5000000;
                break;
            case "Technical Leader":
                responsibleWage = 6000000;
                break;
        }

        return getCoefficientsSalary() * 5000000 + responsibleWage;
    }
}
