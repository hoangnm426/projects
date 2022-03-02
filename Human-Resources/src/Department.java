/*
 * Department class
 *
 * */

import java.io.Serializable;

public class Department implements Serializable {
    private int departmentId;
    private String departmentName;
    private int numberOfStaff;

    public Department() {
    }

    public Department(int departmentId, String departmentName, int numberOfStaff) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.numberOfStaff = numberOfStaff;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getNumberOfStaff() {
        return numberOfStaff;
    }

    public void setNumberOfStaff(int numberOfStaff) {
        this.numberOfStaff = numberOfStaff;
    }

    @Override
    public String toString() {
        return  "Department Id = " + departmentId +
                ", Department Name = '" + departmentName + '\'' +
                ", Number Of Staff = " + numberOfStaff;
    }
}
