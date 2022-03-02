/*
* DepartmentManager class
*
*/

import java.util.List;
import java.util.Scanner;

public class DepartmentManager {
    public static Scanner sc = new Scanner(System.in);
    private List<Department> departmentList;
    private DepartmentDao departmentDao;

    /*
    * init DepartmentDao object and read list department when init DepartmentManager object
    *
    * */
    public DepartmentManager() {
        departmentDao = new DepartmentDao();
        departmentList = departmentDao.read();
    }

    /*
    * add department to departmentList
    *
    * @param department
    * */
    public void add() {
        int departmentId = (departmentList.size() > 0) ? (departmentList.size() + 1) : 1;
        System.out.println("Department id: " + departmentId);
        System.out.print("Department name: ");
        String departmentName = sc.next();
        int numberOfStaff = 0;
        Department newDepartment = new Department(departmentId, departmentName, numberOfStaff);
        departmentList.add(newDepartment);
        departmentDao.write(departmentList);
    }

    // getter && setter
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}
