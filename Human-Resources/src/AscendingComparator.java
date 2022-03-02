/*
 * AscendingComparator class
 *
 * */

import java.util.Comparator;

public class AscendingComparator implements Comparator<Staff> {
    @Override
    public int compare(Staff o1, Staff o2) {
        if (o1.getSalary() == o2.getSalary()) {
            return 0;
        } else if (o1.getSalary() > o2.getSalary()) {
            return 1;
        } else {
            return -1;
        }
    }
}
