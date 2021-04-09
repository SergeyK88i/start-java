public class SaveStudentorder
{                                               //сохраняем данные пользователя
    public static void main(String[] args) {
        StudentOrder so = new StudentOrder();
        so.hFirstName = "Александр";
        so.hLastName = "Иванов";
        so.wFirstName = "Галина";
        so.wLastName = "Иванова";

        long ans = saveStudentOrder(so);
        System.out.println(ans);
    }
    static long saveStudentOrder (StudentOrder student) {
        long answer = 199;
        System.out.println("saveStudentOrder is running " + student.hLastName);
        return answer;
    }
}
