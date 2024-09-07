import java.util.*;
class Course{
    private String coursename;
    private String coursecode;
    private int credits;
    Course(String coursename,String coursecode,int credits){
        this.coursename=coursename;
        this.coursecode=coursecode;
        this.credits=credits;
    }
    public String getCourseName(){
        return coursename;
    }
    public String getCourseCode(){
        return coursecode;
    }
    public int getCourseCredits(){
        return credits;
    }
}
class Grade{
    private Course course;
    private double grade;
    Grade(Course course,double grade){
        this.course=course;
        this.grade=grade;
    }
    public Course getCourse(){
        return course;
    }
    public double getGrade(){
        return grade;
    }
}
abstract class Student{
    private String name;
    private String student_id;
    private List<Course>coursesList=new ArrayList<>();
    private List<Grade>grades=new ArrayList<>();
    Student(String name, String student_id) {
        this.name = name;
        this.student_id = student_id;
    }
    public void addCourse(Course course){
        coursesList.add(course);
    }
    public void addGrade(Grade grade){
        grades.add(grade);
    }
    public String getName(){
        return name;
    }
    public String getStudentId(){
        return student_id;
    }
    public List<Course>getCourses(){
        return coursesList;
    }
    public List<Grade>getGrades(){
        return grades;
    }
    public abstract double FinalGrade();
}
class UnderGraduate extends Student{
    public UnderGraduate(String name,String student_id){
        super(name,student_id);
    }
    @Override
    public double FinalGrade(){
        double marks=0;
        for(Grade g:getGrades()){
            marks+=g.getGrade();
        }
        return marks/getGrades().size();
    }
}
class Graduate extends Student{
    public Graduate(String name,String student_id){
        super(name,student_id);
    }
    @Override
    public double FinalGrade(){
        double marks=0;
        for(Grade g:getGrades()){
            marks+=g.getGrade();
        }
        return marks/ getGrades().size();
    }
}
class Project{
    public static void main(String[] args){
        UnderGraduate st1=new UnderGraduate("abc","1");
        Graduate st2=new Graduate("efg","2");
        Course c1=new Course("maths","123",3);
        Course c2=new Course("social","12",4);
        st1.addCourse(c1);
        st1.addCourse(c2);
        st1.addGrade(new Grade(c1,7.999));
        st1.addGrade(new Grade(c2,8.953));
        st2.addCourse(c1);
        st2.addCourse(c2);
        st2.addGrade(new Grade(c1,8.0454));
        st2.addGrade(new Grade(c2,8.8877));
        System.out.println(st1.FinalGrade());
        System.out.println(st2.FinalGrade());
    }
}