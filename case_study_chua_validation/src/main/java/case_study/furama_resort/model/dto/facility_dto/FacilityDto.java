package case_study.furama_resort.model.dto.facility_dto;

import case_study.furama_resort.model.facilities.FacilityType;
import case_study.furama_resort.model.facilities.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;

public class FacilityDto implements Validator {

    private int id;

    @Pattern(regexp = "^[\\p{L}|\\d]+(\\s[\\p{L}|\\d]+)*$", message = "Tên chưa đúng định dạng! (Vd: Hoàng Giang)")
    private String name;


    private Integer area;
    private Double cost;
    private Integer maxPeople;

    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;
    private String facilityFree;

    private int status = 1;
    private RentType rentType;

    private FacilityType facilityType;

    public FacilityDto() {
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;

        if (facilityDto.area == null) {
            errors.rejectValue("area", "", "Không được để trống");
        } else if (facilityDto.area <= 0) {
            errors.rejectValue("area", "", "Diện tích phải là số dương");
        }

        if (facilityDto.cost == null) {
            errors.rejectValue("cost", "", "Không được để trống");
        } else if (facilityDto.cost <= 0) {
            errors.rejectValue("cost", "", "Giá phải là số dương");
        }

        if (facilityDto.maxPeople == null) {
            errors.rejectValue("maxPeople", "", "Không được để trống");
        } else if (facilityDto.maxPeople <= 0) {
            errors.rejectValue("maxPeople", "", "Số người phải là số dương");
        }

        if (facilityDto.getFacilityType() == null) {
            errors.rejectValue("facilityType", "", "Phải chọn 1 dịch vụ");
        } else {
            switch (facilityDto.getFacilityType().getId()) {
                case 3: //room
                    if (facilityDto.facilityFree.equals("")) {
                        errors.rejectValue("facilityFree", "", "Không được để trống");
                    }
                    break;

                case 1: //villa
                    if (facilityDto.standardRoom.equals("")) {
                        errors.rejectValue("standardRoom", "", "Không được để trống");
                    }
                    if (facilityDto.descriptionOtherConvenience.equals("")) {
                        errors.rejectValue("descriptionOtherConvenience", "", "Không được để trống");
                    }

                    if (facilityDto.poolArea == null) {
                        errors.rejectValue("poolArea", "", "Không được để trống");
                    } else if (facilityDto.poolArea <= 0) {
                        errors.rejectValue("poolArea", "", "Phải là số dương");
                    }

                    if (facilityDto.numberOfFloors == null) {
                        errors.rejectValue("numberOfFloors", "", "Không được để trống");
                    } else if (facilityDto.numberOfFloors <= 0) {
                        errors.rejectValue("numberOfFloors", "", "Phải là số dương");
                    }
                    break;

                //house
                case 2:
                    if (facilityDto.standardRoom.equals("")) {
                        errors.rejectValue("standardRoom", "", "Không được để trống");
                    }
                    if (facilityDto.descriptionOtherConvenience.equals("")) {
                        errors.rejectValue("descriptionOtherConvenience", "", "Không được để trống");
                    }

                    if (facilityDto.numberOfFloors == null) {
                        errors.rejectValue("numberOfFloors", "", "Không được để trống");
                    } else if (facilityDto.numberOfFloors <= 0) {
                        errors.rejectValue("numberOfFloors", "", "Phải là số dương");
                    }
                    break;
            }
        }
    }

    public FacilityDto(int id, String name, Integer area, Double cost, Integer maxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors, String facilityFree, int status, RentType rentType, FacilityType facilityType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.status = status;
        this.rentType = rentType;
        this.facilityType = facilityType;
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
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
}
