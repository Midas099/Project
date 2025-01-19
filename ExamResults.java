package atl.academy.coursemanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exam_results")
public class ExamResults {

    @Id
    @Column(name = "exam_id", length = 11)
    private int examid;

    @Column(name = "student_id", length = 45)
    private int studentid;

    @Column(name = "exam_results", length = 60)
    private double examresults;

    public ExamResults() {
    }

    public ExamResults(int examid, int studentid, double examresults) {
        this.examid = examid;
        this.studentid = studentid;
        this.examresults = examresults;
    }

    public ExamResults(int studentid, double examresults) {
        this.studentid = studentid;
        this.examresults = examresults;
    }

    public int getExamid() {
        return examid;
    }

    public void setExamid(int examid) {
        this.examid = examid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public double getExamresults() {
        return examresults;
    }

    public void setExamresults(double examresults) {
        this.examresults = examresults;
    }

    @Override
    public String toString() {
        return "ExamResults{" +
                "examid=" + examid +
                ", studentid=" + studentid +
                ", examresults=" + examresults +
                '}';
    }
}
