public class StudentOrderValidator //Первый алгоритм проверки данных
{
    public static void main(String[] args) {
        checkAll();
    }

    static void checkAll() {
        checkCityRegister();
        checkWeeding();
        checkChildren();
        checkStudent();
    }

    static void checkCityRegister() {
        System.out.println("CityRegister is running");
    }
    static void checkWeeding() {
        System.out.println("Weeding is running");
    }
    static void checkChildren() {
        System.out.println("Children is running");
    }
    static void checkStudent() {
        System.out.println("Студенты проверяются");
    }
}
