public class StudentOrderValidator //Первый алгоритм проверки данных
{
    public static void main(String[] args) {
        checkAll();
    }

    static void checkAll() {
                                        // а. смотрим новые студенческие заявки
        StudentOrder so1 = readStudentOrder();

                                                        // 2. обработали студенческую заявку
        while (so1 != null) {


                                        // б. читаем студенческую заявку и пытаемся ее проверить
            AnswerWedding wedAnswer = checkWeeding(so1);
            AnswerCityRegister cityAnswer = checkCityRegister(so1);
            AnswerChildren childAnswer = checkChildren(so1);
            AnswerStudent studentAnswer = checkStudent(so1);
            sendMail (so1);

            so1 = readStudentOrder(); // в. проверяем если новая студенческая заявка


        }
    }
                                                        // 1. вычетали студенческую заявку
    static StudentOrder readStudentOrder() {
        StudentOrder so2 = new StudentOrder();
        return  so2;
    }
    static AnswerCityRegister checkCityRegister(StudentOrder so) {
        System.out.println("CityRegister is running");
        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
    static  AnswerWedding checkWeeding(StudentOrder so) {
        System.out.println("Weeding is running");
        AnswerWedding ans = new AnswerWedding();
        return ans;
    }
    static AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("Children is running");
        AnswerChildren ans = new AnswerChildren();
        return ans;
    }
    static AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Студенты проверяются");
        return new AnswerStudent();
    }
    static void  sendMail(StudentOrder so) {

    }
}
