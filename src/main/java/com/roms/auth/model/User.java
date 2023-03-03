package com.roms.auth.model;



import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;


@Container(containerName = "usersofproducer")

public class User {



@Id
@PartitionKey
private String id;

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

public User(String id, String email, String firstname, String age) {
super();
this.id = id;
this.email = email;
this.firstname = firstname;
this.age = age;
}
public User() {

}

@Override
public String toString() {
return "User [id=" + id + ", email=" + email + ", firstname=" + firstname + ", age=" + age + "]";
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

private String email;

private String firstname;

private String age;



}

