import java.util.ArrayList;
import java.util.List;

// Base class for Person
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Student class inherits from Person
class Student extends Person {
    private int studentId;
    private String grade;

    public Student(String name, int age, int studentId, String grade) {
        super(name, age);
        this.studentId = studentId;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId + ", Grade: " + grade);
    }
}

// Teacher class inherits from Person
class Teacher extends Person {
    private String subject;
    private int teacherId;

    public Teacher(String name, int age, int teacherId, String subject) {
        super(name, age);
        this.teacherId = teacherId;
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public int getTeacherId() {
        return teacherId;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Teacher ID: " + teacherId + ", Subject: " + subject);
    }
}

// Class to represent a School Class
class SchoolClass {
    private String className;
    private Teacher teacher;
    private List<Student> students;

    public SchoolClass(String className, Teacher teacher) {
        this.className = className;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayClassInfo() {
        System.out.println("Class Name: " + className);
        System.out.println("Teacher: " + teacher.getName());
        System.out.println("Students enrolled:");
        for (Student student : students) {
            student.displayInfo();
        }
    }
}

// Class to represent an Exam
class Exam {
    private String examName;
    private SchoolClass schoolClass;
    private List<Double> grades;

    public Exam(String examName, SchoolClass schoolClass) {
        this.examName = examName;
        this.schoolClass = schoolClass;
        this.grades = new ArrayList<>();
    }

    public void conductExam() {
        System.out.println("Conducting " + examName + " for class " + schoolClass.getClassName());
        for (Student student : schoolClass.getStudents()) {
            double grade = Math.random() * 100; // Random grade for simulation
            grades.add(grade);
            System.out.println("Grade for " + student.getName() + ": " + grade);
        }
    }

    public void displayExamResults() {
        System.out.println("Exam Results for " + examName + " in class " + schoolClass.getClassName());
        for (int i = 0; i < schoolClass.getStudents().size(); i++) {
            System.out.println(schoolClass.getStudents().get(i).getName() + ": " + grades.get(i));
        }
    }
}

// School class to manage students, teachers, classes, and exams
class School {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<SchoolClass> classes;
    private List<Exam> exams;

    public School() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        classes = new ArrayList<>();
        exams = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addClass(SchoolClass schoolClass) {
        classes.add(schoolClass);
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }

    public void displayAllStudents() {
        System.out.println("Students in the school:");
        for (Student student : students) {
            student.displayInfo();
        }
    }

    public void displayAllTeachers() {
        System.out.println("Teachers in the school:");
        for (Teacher teacher : teachers) {
            teacher.displayInfo();
        }
    }

    public void displayAllClasses() {
        System.out.println("Classes in the school:");
        for (SchoolClass schoolClass : classes) {
            schoolClass.displayClassInfo();
        }
    }

    public void conductAllExams() {
        System.out.println("Conducting all exams:");
        for (Exam exam : exams) {
            exam.conductExam();
        }
    }

    public void displayAllExamResults() {
        System.out.println("Exam Results:");
        for (Exam exam : exams) {
            exam.displayExamResults();
        }
    }
}

// Main class to run the program
public class SchoolManagementSystem {
    public static void main(String[] args) {
        // Create a school
        School school = new School();

        // Add students
        Student student1 = new Student("Alice", 15, 101, "10th Grade");
        Student student2 = new Student("Bob", 14, 102, "9th Grade");
        school.addStudent(student1);
        school.addStudent(student2);

        // Add teachers
        Teacher teacher1 = new Teacher("Mr. Smith", 40, 201, "Mathematics");
        Teacher teacher2 = new Teacher("Ms. Johnson", 35, 202, "Science");
        school.addTeacher(teacher1);
        school.addTeacher(teacher2);

        // Create classes and assign students
        SchoolClass mathClass = new SchoolClass("Mathematics Class", teacher1);
        mathClass.addStudent(student1);
        mathClass.addStudent(student2);
        school.addClass(mathClass);

        SchoolClass scienceClass = new SchoolClass("Science Class", teacher2);
        scienceClass.addStudent(student1);
        school.addClass(scienceClass);

        // Create exams
        Exam mathExam = new Exam("Midterm Math Exam", mathClass);
        Exam scienceExam = new Exam("Final Science Exam", scienceClass);
        school.addExam(mathExam);
        school.addExam(scienceExam);

        // Display all students, teachers, and classes
        school.displayAllStudents();
        school.displayAllTeachers();
        school.displayAllClasses();

        // Conduct exams and display results
        school.conductAllExams();
        school.displayAllExamResults();
    }
}