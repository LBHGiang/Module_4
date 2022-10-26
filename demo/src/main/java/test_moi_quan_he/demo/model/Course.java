package test_moi_quan_he.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double tuition;

    @ManyToMany
    private Set<Student> students;



}
