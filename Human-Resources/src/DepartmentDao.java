/*
* DepartmentDao class
*
* */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    private static final String DEPARTMENT_FILE_NAME = "department.txt";

    /*
    * save list student to file
    *
    * @param departmentList: list department to save
    * */
    public void write(List<Department> departmentList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(DEPARTMENT_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(departmentList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    /*
    * read list student from file
    *
    * @return list department
    * */
    public List<Department> read() {
        List<Department> departmentList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(DEPARTMENT_FILE_NAME));
            ois = new ObjectInputStream(fis);
            departmentList = (List<Department>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return departmentList;
    }

    /*
    * close input stream
    *
    * @param is: input stream
    * */
    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    * close output stream
    *
    * @param os: output stream
    * */
    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
