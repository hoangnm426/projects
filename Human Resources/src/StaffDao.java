/*
* StaffDao class
*
* */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDao {
    private static final String STAFF_FILE_NAME = "staff.txt";

    /*
    * save list staff to file
    *
    * @param staffList: list staff to save
    *
    * */
    public void write(List<Staff> staffList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(STAFF_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(staffList);
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
    * read list staff from file
    *
    * @return list staff
    *
    * */
    public List<Staff> read() {
        List<Staff> staffList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(STAFF_FILE_NAME));
            ois = new ObjectInputStream(fis);
            staffList = (List<Staff>) ois.readObject();
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
        return staffList;
    }

    /*
    * close input stream
    *
    * @param is: input stream
    *
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
    *
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
