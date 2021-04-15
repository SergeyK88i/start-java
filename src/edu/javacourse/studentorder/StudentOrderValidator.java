package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeddingValidator;

public class StudentOrderValidator //Первый алгоритм проверки данных
{
    private CityRegisterValidator cityRegisterVali;
    private  WeddingValidator  weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSender mailSender;

    public StudentOrderValidator () {
        cityRegisterVali = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        mailSender = new MailSender();
    }
    //Создаем объект StudentOrderValidator и у этого объекта используем метод
    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();

    }

    public void checkAll() {
        StudentOrder[] soArray = readStudentOrders(); //2.читаем студенческие заявки
        for (int c = 0; c < soArray.length; c++) {
            System.out.println();
            checkOneOrder(soArray[c]);
        }
    }

    public StudentOrder[] readStudentOrders() {     //1.создали студенческие заявки
        StudentOrder[] soArray = new StudentOrder[1];
        for ( int c = 0; c < soArray.length; c++) {
            soArray[c] = SaveStudentorder.buildStudentOrder(c); //buildStudentOrder строить студенческую заявку
        }
        return soArray;
    }

    public void checkOneOrder (StudentOrder so1) { // 3.проверяем студенческие заявки

        AnswerCityRegister cityAnswer = checkCityRegister(so1);
        AnswerWedding wedAnswer = checkWeeding(so1);
        AnswerChildren childAnswer = checkChildren(so1);
        AnswerStudent studentAnswer = checkStudent(so1);
        sendMail (so1);
    }


    public AnswerCityRegister checkCityRegister(StudentOrder so) {
       return cityRegisterVali.checkCityRegister(so);


    }
    public AnswerWedding checkWeeding(StudentOrder so) {
        return weddingVal.checkWeeding(so);
    }
    public AnswerChildren checkChildren(StudentOrder so) {
        return childrenVal.checkChildren(so);
    }
    public AnswerStudent checkStudent(StudentOrder so) {
        return studentVal.checkStudent(so);
    }
    public void  sendMail(StudentOrder so) {
        mailSender.sendMail(so);
    }
}
