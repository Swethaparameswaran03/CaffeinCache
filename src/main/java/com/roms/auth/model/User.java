package com.roms.auth.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="users")

public class User {
	
	
	@Id
	private String id;
	@Field
	private String email;
	@Field
	private String firstname;
	@Field
	private String age;

	
	
}