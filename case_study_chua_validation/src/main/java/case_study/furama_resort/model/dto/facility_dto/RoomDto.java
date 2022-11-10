package case_study.furama_resort.model.dto.facility_dto;

import case_study.furama_resort.model.facilities.FacilityType;
import case_study.furama_resort.model.facilities.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class RoomDto implements Validator {
    private int id;

    @Pattern(regexp = "^[\\p{L}|\\d]+(\\s[\\p{L}|\\d]+)*$", message = "Tên chưa đúng định dạng! (Vd: Hoàng Giang)")
    private String name;

    @Pattern(regexp = "^\\d+$", message = "Diện tích phải là số nguyên dương")
    private String area;

    @Pattern(regexp = "^(\\d+\\.{0,1}\\d+)|\\d+$", message = "Giá phải lớn hơn 0")
    private String cost;

    @Pattern(regexp = "^\\d+$", message = "Diện tích phải là số nguyên dương")
    private String maxPeople;



    private String facilityFree;

    private int status = 1;
    private RentType rentType;

    private FacilityType facilityType;

    public RoomDto() {
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
