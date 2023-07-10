package com.qr.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "first")
public class Complaint {
	
	@Id
	private String id;
	private  String empName;
	private String  empId;
	private String  compName;
	private String issue;
	private String desc;
	

}
