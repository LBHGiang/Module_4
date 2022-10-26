package test_moi_quan_he.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Account {

    @Id
    private String accountName;
    private String password;
    private Date createdDate;

    @OneToOne(mappedBy = "account")
    private Student student;

    public Account() {
    }

    public Account(String accountName, String password, Date createdDate, Student student) {
        this.accountName = accountName;
        this.password = password;
        this.createdDate = createdDate;
        this.student = student;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
