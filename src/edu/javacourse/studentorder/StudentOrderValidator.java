package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeddingValidator;

public class StudentOrderValidator //Первый алгоритм проверки данных
{
    public static void main(String[] args) {
        checkAll();
    }

    static void checkAll() {
                                        // а. смотрим новые студенческие заявки
        while (true) {
        StudentOrder so1 = readStudentOrder();
            System.out.println("Старт");

            if (so1 == null) {
                break;
            }


                                        // б. читаем студенческую заявку и пытаемся ее проверить
            AnswerWedding wedAnswer = checkWeeding(so1);
            AnswerCityRegister cityAnswer = checkCityRegister(so1);
            if ( cityAnswer.success == false) {
                //continue;
                break;
            }
            AnswerChildren childAnswer = checkChildren(so1);
            AnswerStudent studentAnswer = checkStudent(so1);
            sendMail (so1);

        }
        System.out.println("Финиш2");
    }
                                                        // 1. вычетали студенческую заявку
    static StudentOrder readStudentOrder() {
        StudentOrder so2 = new StudentOrder();
        return  so2;
    }
    static AnswerCityRegister checkCityRegister(StudentOrder so) {
        CityRegisterValidator crv1 = new CityRegisterValidator();
        crv1.hostName = "Host1";
        crv1.login = "Login1";


        CityRegisterValidator crv2 = new CityRegisterValidator();
        crv2.hostName = "Host2";
        crv2.login = "Login2";

        AnswerCityRegister ans1 = crv1.checkCityRegister(so);
        AnswerCityRegister ans2 = crv1.checkCityRegister(so);
        return ans1;


    }
    static AnswerWedding checkWeeding(StudentOrder so) {
        WeddingValidator wd = new WeddingValidator();
        return wd.checkWeeding(so);
    }
    static AnswerChildren checkChildren(StudentOrder so) {
        ChildrenValidator cv = new ChildrenValidator();
        return cv.checkChildren(so);
    }
    static AnswerStudent checkStudent(StudentOrder so) {
        return new StudentValidator().checkStudent(so);
    }
    static void  sendMail(StudentOrder so) {
        new MailSender().sendMail(so);
    }
}
