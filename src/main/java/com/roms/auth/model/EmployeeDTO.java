package com.roms.auth.model;


public class EmployeeDTO {
private String id;
public EmployeeDTO(String id, String companyname, String designation, double salary) {
super();
this.id = id;
this.companyname = companyname;
this.designation = designation;
this.salary = salary;
}
public EmployeeDTO() {

}
public String getId() {
return id;
}
public void setId(String id) {
this.id = id;
}
public String getCompanyname() {
return companyname;
}
public void setCompanyname(String companyname) {
this.companyname = companyname;
}
public String getDesignation() {
return designation;
}
public void setDesignation(String designation) {
this.designation = designation;
}
public double getSalary() {
return salary;
}
public void setSalary(double salary) {
this.salary = salary;
}
private String companyname;
private String designation;
private double salary;



}
