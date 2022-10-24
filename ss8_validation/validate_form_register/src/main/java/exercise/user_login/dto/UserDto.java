package exercise.user_login.dto;

import javax.validation.constraints.*;

public class UserDto {

    private Integer id;

    @Pattern(regexp = "^[a-zA-Z]{5,45}$", message = "First Name is from 5 to 45 alphabetic characters ")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]{5,45}$", message = "Last Name is from 5 to 45 alphabetic characters ")
    private String lastName;

    @Pattern(regexp = "^[0-9]{9}$", message = "Phone number is a string of 9 digits")
    private String phoneNumber;

    @NotNull(message = "Please fill in the information")
    @Min(value = 18, message = "Age must be greater than or equal to 18")
    private Integer age;


    @NotBlank(message = "Please fill in the information")
    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "Email is not in the correct format")
    private String email;

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
