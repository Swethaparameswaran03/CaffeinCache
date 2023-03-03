package com.roms.auth.model;


public class UserDTO {


private String id;
private String email;
private String firstname;
private String age;
public String getId() {
return id;
}
public void setId(String id) {
this.id = id;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public String getFirstname() {
return firstname;
}
public void setFirstname(String firstname) {
this.firstname = firstname;
}
public String getAge() {
return age;
}
public void setAge(String age) {
this.age = age;
}
public UserDTO(String id, String email, String firstname, String age) {
super();
this.id = id;
this.email = email;
this.firstname = firstname;
this.age = age;
}
public UserDTO() {

}



}
