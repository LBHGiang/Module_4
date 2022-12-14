package case_study.furama_resort.model.dto.contract;

import case_study.furama_resort.model.contract.ContractDetail;
import case_study.furama_resort.model.customer.Customer;
import case_study.furama_resort.model.employee.Employee;
import case_study.furama_resort.model.facilities.Facility;

import java.util.LinkedList;
import java.util.Set;

public class ContractDto {

    private int id;
    private String startDate;
    private String endDate;
    private double deposit;
    private int status = 1;
    private Set<ContractDetail> contractDetails;
    private Employee employee;
    private Customer customer;
    private Facility facility;
    private LinkedList<Integer> quantities;


    public ContractDto() {
    }

    public ContractDto(int id, String startDate, String endDate, double deposit, int status, Set<ContractDetail> contractDetails, Employee employee, Customer customer, Facility facility) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.status = status;
        this.contractDetails = contractDetails;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
        this.total = facility.getCost();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LinkedList<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(LinkedList<Integer> quantities) {
        this.quantities = quantities;
    }

    private double total;

    public void getTotalCost() {
        this.total = this.facility == null ? 0 : this.facility.getCost();
        if (this.contractDetails != null) {
            for (ContractDetail contractDetail : this.contractDetails) {
                this.total += contractDetail == null ? 0 : contractDetail.getQuantity() * contractDetail.getAttachFacility().getCost();
            }
        }
    }
}
