package case_study.furama_resort.model.employee;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(columnDefinition = "int default 1")
    private int status = 1;

    @OneToMany(mappedBy = "division")
    private Set<Employee> employees;

    public Division() {
    }

    public Division(int id, String name, int status, Set<Employee> employees) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
