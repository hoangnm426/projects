/*
* main class
* */

import java.util.*;

public class HumanResources {
    private static Scanner sc = new Scanner(System.in);
    private static DepartmentManager departmentManager = new DepartmentManager();
    private static DepartmentDao departmentDao = new DepartmentDao();
    private static List<Staff> staffList = new ArrayList<>();
    private static StaffDao staffDao = new StaffDao();

    public static void main(String[] args) {
        String choose = null;
        boolean check = true;
        staffList = staffDao.read();

        showMenu();
        do {
            choose = sc.next();
            switch (choose) {
                case "1":
                    showListStaff();
                    break;
                case "2":
                    System.out.println("Cac bo phan trong cong ty: ");
                    showListDepartment();
                    break;
                case "3":
                    showListStaffBaseOnWorkingDepartment();
                    break;
                case "4":
                    addNewStaff();
                    break;
                case "5":
                    search();
                    break;
                case "6":
                    sortSalaryDescending();
                    break;
                case "7":
                    sortSalaryAscending();
                    break;
                case "0":
                    System.out.println("Chuong trinh ket thuc.");
                    check = false;
                    break;
                default:
                    System.out.println("Xin moi chon tu 1 - 7 hoac chon 0 de ket thuc chuong trinh.");
                    break;
            }
            System.out.println();
            System.out.println();
            showMenu();
        } while (check);
    }

    /*
    * create menu
    *
    * */
    private static void showMenu() {
        System.out.println("-------------------------- Menu --------------------------");
        System.out.println("1. Hien thi danh sach nhan vien hien co trong cong ty.");
        System.out.println("2. Hien thi cac bo phan trong cong ty.");
        System.out.println("3. Hien thi cac nhan vien theo tung bo phan.");
        System.out.println("4. Them nhan vien moi vao cong ty.");
        System.out.println("5. Tim kiem thong tin nhan vien theo ten hoac ma nhan vien.");
        System.out.println("6. Hien thi bang luong cua nhan vien toan cong ty.");
        System.out.println("7. Hien thi bang luong cua nhan vien theo thu tu tang dan.");
        System.out.println("0. Ket thuc chuong trinh.");
        System.out.println("----------------------------------------------------------");
        System.out.print("Xin moi chon: ");
    }

    /*
    * show list staff to screen
    *
    * */
    private static void showListStaff() {
        staffList = staffDao.read();
        System.out.printf("%-12s%-30s%-10s%-20s%-20s%-20s%-20s%-15s%-10s%-20s\n", "Id", "Ten nhan vien", "Tuoi",
                "He so luong", "Ngay vao lam", "Bo phan", "Chuc danh", "So ngay nghi","Them gio", "Luong");
        for (Staff staff: staffList) {
            staff.displayInformation();
        }
    }

    /*
    * show list department to screen
    *
    * */
    private static void showListDepartment() {
        int empTotal = 0;
        int manTotal = 0;
        List<Department> departmentList = departmentManager.getDepartmentList();
        staffList = staffDao.read();
        for(Staff staff: staffList) {
            if (staff.getWorkingDepartment().equalsIgnoreCase(departmentList.get(0).getDepartmentName())) {
                empTotal++;
            } else if (staff.getWorkingDepartment().equalsIgnoreCase(departmentList.get(1).getDepartmentName())) {
                manTotal++;
            }
        }
        departmentList.get(0).setNumberOfStaff(empTotal);
        departmentList.get(1).setNumberOfStaff(manTotal);
        departmentDao.write(departmentList);
        for(Department list: departmentList) {
            System.out.println(list.toString());
        }
    }

    /*
    * show list staff base on working department to screen
    *
    * */
    private static void showListStaffBaseOnWorkingDepartment() {
        System.out.println("------------------------------------------");
        System.out.println("1. Danh sach nhan vien Frontend");
        System.out.println("2. Danh sach nhan vien Backend");
        System.out.println("------------------------------------------");
        System.out.print("Xin moi chon: ");
        String chooseList = sc.next();
        switch (chooseList) {
            case "1":
                showListFrontend();
                break;
            case "2":
                showListBackend();
                break;
            default:
                break;
        }
    }

    /*
    * show list frontend to screen
    *
    * */
    private static void showListFrontend() {
        String search = departmentManager.getDepartmentList().get(0).getDepartmentName();
        staffList = staffDao.read();
        System.out.printf("%-12s%-30s%-10s%-20s%-20s%-20s%-20s%-15s%-10s%-20s\n", "Id", "Ten nhan vien", "Tuoi",
                "He so luong", "Ngay vao lam", "Bo phan", "Chuc danh", "So ngay nghi","Them gio", "Luong");
        for (Staff staff: staffList) {
            if(staff.getWorkingDepartment().equals(search)) {
                staff.displayInformation();
            }
        }
    }

    /*
    * show list backend to screen
    *
    * */
    private static void showListBackend() {
        String search = departmentManager.getDepartmentList().get(1).getDepartmentName();
        staffList = staffDao.read();
        System.out.printf("%-12s%-30s%-10s%-20s%-20s%-20s%-20s%-15s%-10s%-20s\n", "Id", "Ten nhan vien", "Tuoi",
                "He so luong", "Ngay vao lam", "Bo phan", "Chuc danh", "So ngay nghi","Them gio", "Luong");
        for (Staff staff: staffList) {
            if(staff.getWorkingDepartment().equals(search)) {
                staff.displayInformation();
            }
        }
    }

    /*
    * add new staff
    *
    * */
    private static void addNewStaff() {
        System.out.println("---------------- Add Menu ----------------");
        System.out.println("1. Them nhan vien thong thuong.");
        System.out.println("2. Them nhan vien cap quan ly.");
        System.out.println("------------------------------------------");
        System.out.print("Xin moi chon: ");
        String chooseStaff = sc.next();
        switch (chooseStaff) {
            case "1":
                addNewEmployee();
                break;
            case "2":
                addNewManager();
                break;
            default:
                break;
        }
    }

    /*
    * add new employee
    *
    * */
    private static void addNewEmployee() {
        sc.nextLine();
        System.out.print("Xin moi nhap id nhan vien: ");
        String empId = sc.nextLine();
        System.out.print("Xin moi nhap ten nhan vien: ");
        String empName = sc.nextLine();
        System.out.print("Xin moi nhap tuoi nhan vien: ");
        int empAge = sc.nextInt();
        System.out.print("Xin moi nhap he so luong: ");
        float empCoefficientsSalary = sc.nextFloat();
        System.out.print("Xin moi nhap ngay vao lam viec (dd/mm/yyyy): ");
        String empStartingDate = sc.next();
        System.out.print("Xin moi chon bo phan lam viec(1. Frontend, 2. Backend): ");
        int empWorkingDepartmentChoose = sc.nextInt();
        String empWorkingDepartment = "";
        if (empWorkingDepartmentChoose == 1) {
            empWorkingDepartment = departmentManager.getDepartmentList().get(0).getDepartmentName();
        } else if (empWorkingDepartmentChoose == 2) {
            empWorkingDepartment = departmentManager.getDepartmentList().get(1).getDepartmentName();
        }
        System.out.print("Xin moi nhap so ngay nghi phep: ");
        int empNumberOfDayOff = sc. nextInt();
        System.out.print("Xin moi nhap so gio lam them: ");
        int empOvertimeHour = sc.nextInt();
        Employee newEmp = new Employee();
        newEmp.setStaffId(empId);
        newEmp.setStaffName(empName);
        newEmp.setStaffAge(empAge);
        newEmp.setCoefficientsSalary(empCoefficientsSalary);
        newEmp.setStartingDate(empStartingDate);
        newEmp.setWorkingDepartment(empWorkingDepartment);
        newEmp.setNumberOfDayOff(empNumberOfDayOff);
        newEmp.setOvertimeHour(empOvertimeHour);
        newEmp.setSalary(newEmp.calculateSalary());
        staffList.add(newEmp);
        staffDao.write(staffList);
    }

    /*
    * add new manager
    *
    * */
    private static void addNewManager() {
        sc.nextLine();
        System.out.print("Xin moi nhap id quan ly: ");
        String manId = sc.nextLine();
        System.out.print("Xin moi nhap ten quan ly: ");
        String manName = sc.nextLine();
        System.out.print("Xin moi nhap tuoi quan ly: ");
        int manAge = sc.nextInt();
        System.out.print("Xin moi nhap he so luong: ");
        float manCoefficientsSalary = sc.nextFloat();
        System.out.print("Xin moi nhap ngay vao lam viec (dd/mm/yyyy): ");
        String manStartingDate = sc.next();
        System.out.print("Xin moi chon bo phan lam viec(1. Frontend, 2. Backend): ");
        int manWorkingDepartmentChoose = sc.nextInt();
        String manWorkingDepartment = "";
        if (manWorkingDepartmentChoose == 1) {
            manWorkingDepartment = departmentManager.getDepartmentList().get(0).getDepartmentName();
        } else if (manWorkingDepartmentChoose == 2) {
            manWorkingDepartment = departmentManager.getDepartmentList().get(1).getDepartmentName();
        }
        System.out.print("Xin moi chon chuc danh (1. Business Leader, 2. Project Leader, 3. Technical Leader): " );
        int idTitle = sc.nextInt();
        String manTitle = "";
        switch (idTitle) {
            case 1:
                manTitle = "Business Leader";
                break;
            case 2:
                manTitle = "Project Leader";
                break;
            case 3:
                manTitle = "Technical Leader";
                break;
        }
        System.out.print("Xin moi nhap so ngay nghi phep: ");
        int manNumberOfDayOff = sc.nextInt();
        Manager newMan = new Manager();
        newMan.setStaffId(manId);
        newMan.setStaffName(manName);
        newMan.setStaffAge(manAge);
        newMan.setCoefficientsSalary(manCoefficientsSalary);
        newMan.setStartingDate(manStartingDate);
        newMan.setWorkingDepartment(manWorkingDepartment);
        newMan.setTitle(manTitle);
        newMan.setSalary(newMan.calculateSalary());
        newMan.setNumberOfDayOff(manNumberOfDayOff);
        staffList.add(newMan);
        staffDao.write(staffList);
    }

    /*
    * show list staff base on search
    *
    * */
    private static void search() {
        System.out.println("------------------------------------------");
        System.out.println("1. Tim kiem theo ten nhan vien.");
        System.out.println("2. Tim kiem theo ma nhan vien.");
        System.out.println("------------------------------------------");
        System.out.print("Xin moi chon: ");
        int chooseSearch = sc. nextInt();
        switch (chooseSearch) {
            case 1:
                searchName();
                break;
            case 2:
                searchId();
                break;
            default:
                break;
        }
    }

    /*
    * search base on name
    *
    * */
    private static void searchName(){
        boolean check = false;
        sc.nextLine();
        System.out.print("Xin moi nhap ten nhan vien can tim: ");
        String sName = sc.nextLine();
        staffList = staffDao.read();
        System.out.printf("%-12s%-30s%-10s%-20s%-20s%-20s%-20s%-15s%-10s%-20s\n", "Id", "Ten nhan vien", "Tuoi",
                "He so luong", "Ngay vao lam", "Bo phan", "Chuc danh", "So ngay nghi","Them gio", "Luong");
        for(Staff staff: staffList) {
            if (staff.getStaffName().equalsIgnoreCase(sName)) {
                staff.displayInformation();
                check = true;
            }
        }
        if(!check) {
            System.out.println("Khong tim thay nhan vien co ten giong trong tim kiem.");
        }
    }

    /*
    * search base on id
    *
    * */
    private static void searchId() {
        boolean check = false;
        sc.nextLine();
        System.out.print("Xin moi nhap id nhan vien can tim: ");
        String sId = sc.nextLine();
        staffList = staffDao.read();
        System.out.printf("%-12s%-30s%-10s%-20s%-20s%-20s%-20s%-15s%-10s%-20s\n", "Id", "Ten nhan vien", "Tuoi",
                "He so luong", "Ngay vao lam", "Bo phan", "Chuc danh", "So ngay nghi","Them gio", "Luong");
        for(Staff staff:staffList) {
            if(staff.getStaffId().equalsIgnoreCase(sId)) {
                staff.displayInformation();
                check = true;
            }
        }
        if (!check) {
            System.out.println("Khong tim thay nhan vien co id giong trong tim kiem.");
        }
    }

    /*
    * descending order in salary
    *
    * */
    private static void sortSalaryDescending() {
        staffList.sort(new DescendingComparator());
        System.out.printf("%-12s%-30s%-10s%-20s%-20s%-20s%-20s%-15s%-10s%-20s\n", "Id", "Ten nhan vien", "Tuoi",
                "He so luong", "Ngay vao lam", "Bo phan", "Chuc danh", "So ngay nghi","Them gio", "Luong");
        for(Staff staff: staffList) {
            staff.displayInformation();
        }
    }

    /*
     * ascending order in salary
     *
     * */
    private static void sortSalaryAscending() {
        staffList.sort(new AscendingComparator());
        System.out.printf("%-12s%-30s%-10s%-20s%-20s%-20s%-20s%-15s%-10s%-20s\n", "Id", "Ten nhan vien", "Tuoi",
                "He so luong", "Ngay vao lam", "Bo phan", "Chuc danh", "So ngay nghi","Them gio", "Luong");
        for(Staff staff: staffList) {
            staff.displayInformation();
        }
    }

}

