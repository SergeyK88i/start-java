package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.StudentOrder;

public class SaveStudentorder
{                                               //сохраняем данные пользователя
    public static void main(String[] args) {

        buildStudentOrder();
//        StudentOrder so = new StudentOrder();
//        long ans = saveStudentOrder(so);
//        System.out.println(ans);
    }
    static long saveStudentOrder (StudentOrder student) {
        long answer = 199;
        System.out.println("saveStudentOrder is running ");
        return answer;
    }

    static StudentOrder buildStudentOrder () {
        StudentOrder so = new StudentOrder();
        Adult husband = new Adult();
        husband.setGivenName("Andrei");
        so.setHusband(husband);

        String ans = husband.getPersonString();
        System.out.println(ans);
        return so;
    }
}
