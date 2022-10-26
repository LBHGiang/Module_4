package test_moi_quan_he.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    private Integer id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_name", referencedColumnName = "accountName" )
    private Account account;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private ClassRoom classRoom;


    @ManyToMany
    private Set<Course> courses;



}
