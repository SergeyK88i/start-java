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
    public StudentOrder readStudentOrder() {
        StudentOrder so2 = new StudentOrder();
        return  so2;
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
