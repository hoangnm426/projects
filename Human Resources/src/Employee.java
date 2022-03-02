/*
* Employee class
*
* */

import java.io.Serializable;

public class Employee extends Staff implements Serializable, ICalculator {
    private int overtimeHour;

    public Employee() {
    }

    public Employee(String staffId, String staffName, int staffAge, float coefficientsSalary, String startingDate,
                    String workingDepartment, int numberOfDayOff, double salary, int overtimeHour) {
        super(staffId, staffName, staffAge, coefficientsSalary, startingDate, workingDepartment, numberOfDayOff, salary);
        this.overtimeHour = overtimeHour;
    }

    public int getOvertimeHour() {
        return overtimeHour;
    }

    public void setOvertimeHour(int overtimeHour) {
        this.overtimeHour = overtimeHour;
    }

    @Override
    void displayInformation() {
        System.out.printf("%-12s%-30s%-10d%-20.2f%-20s%-20s%-20s%-15d%-10d%-20.2f\n", getStaffId(), getStaffName(),
                getStaffAge(), getCoefficientsSalary(), getStartingDate(), getWorkingDepartment(), "Employee",
                getNumberOfDayOff(), getOvertimeHour(), getSalary());
    }

    @Override
    public double calculateSalary() {
        return getCoefficientsSalary() * 3000000 + getOvertimeHour() * 200000;
    }
}
