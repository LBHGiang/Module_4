package practice.student_management_login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StudentManagementLoginApplication {

    public static void main(String[] args) {

        SpringApplication.run(StudentManagementLoginApplication.class, args);

//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        System.out.println(passwordEncoder.encode("123"));
    }


}
