package atl.academy.coursemanagementsystem.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exam_id", length = 11)
    private int examid;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "semester_id", nullable = false)
    private Semester semester;

    @Column(name = "exam_date", length = 12)
    private String examdate;

    public Exam() {
    }

    public Exam(int examid, Student student, Semester semester, String examdate) {
        this.examid = examid;
        this.student = student;
        this.semester = semester;
        this.examdate = examdate;
    }

    public Exam(Student student, Semester semester, String examdate) {
        this.student = student;
        this.semester = semester;
        this.examdate = examdate;
    }

    public int getExamid() {
        return examid;
    }

    public void setExamid(int examid) {
        this.examid = examid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public String getExamdate() {
        return examdate;
    }

    public void setExamdate(String examdate) {
        this.examdate = examdate;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examid=" + examid +
                ", student=" + student +
                ", semester=" + semester +
                ", examdate='" + examdate + '\'' +
                '}';
    }
}
