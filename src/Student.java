/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 03 03
 * Time:15:00
 */
public class Student {
    private String name;
    private String classroom;
    private double grade;

    public Student(String name, String classroom, double grade) {
        this.name = name;
        this.classroom = classroom;
        this.grade = grade;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classroom='" + classroom + '\'' +
                ", grade=" + grade +
                '}';
    }
}
