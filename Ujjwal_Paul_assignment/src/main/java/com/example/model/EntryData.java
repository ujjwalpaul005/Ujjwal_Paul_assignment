package com.example.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryData implements Serializable{

	private String API;
	
	private String Description;
	private String Auth;
	private boolean HTTPS;
	private String Cors;
	
	@Id
	private String Link;
	
	private String Category;
	
}
