package com.roms.auth.model;



public class ResponseDTO {
    private EmployeeDTO emp;
    public EmployeeDTO getEmp() {
return emp;
}
public void setEmp(EmployeeDTO emp) {
this.emp = emp;
}
public UserDTO getUser() {
return user;
}
public void setUser(UserDTO user) {
this.user = user;
}
@Override
public String toString() {
return "ResponseDTO [emp=" + emp + ", user=" + user + "]";
}
public ResponseDTO(EmployeeDTO emp, UserDTO user) {
super();
this.emp = emp;
this.user = user;
}
public ResponseDTO() {

}
private UserDTO user;


}
