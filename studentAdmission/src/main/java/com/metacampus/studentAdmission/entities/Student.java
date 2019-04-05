package com.metacampus.studentAdmission.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;



@Entity
@Inheritance
public class Student extends User{

	
	
	@Column
	public String mobilenumber;
	@Column
	public String aadharnumber;
	@Column
	public String jsondata;
	@NotNull
	@Column
	public String fathername;
	@NotNull
	@Column
	public String mothername;
	@NotNull
	@Column
	public int admissionyear;
	@NotNull
	@Column
	public LocalDate admissiondate;
	
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getAadharnumber() {
		return aadharnumber;
	}
	public void setAadharnumber(String aadharnumber) {
		this.aadharnumber = aadharnumber;
	}
	public String getJsondata() {
		return jsondata;
	}
	public void setJsondata(String jsondata) {
		this.jsondata = jsondata;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public int getAdmissionyear() {
		return admissionyear;
	}
	public void setAdmissionyear(int admissionyear) {
		this.admissionyear = admissionyear;
	}
	public LocalDate getAdmissiondate() {
		return admissiondate;
	}
	public void setAdmissiondate(LocalDate admissiondate) {
		this.admissiondate = admissiondate;
	}
	
	
	
	
}
