package com.one.to.one.mapping.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "userProfile")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String mobileNumber;
	
	private String address;
	
	private String gender;
	 @JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfBrith;
	/*
	 * @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy =
	 * "userProfile") private User user;
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBrith() {
		return dateOfBrith;
	}

	public void setDateOfBrith(LocalDate dateOfBrith) {
		this.dateOfBrith = dateOfBrith;
	}

	public UserProfile(String mobileNumber, String address, String gender, LocalDate dateOfBrith) {
		super();
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.gender = gender;
		this.dateOfBrith = dateOfBrith;
	}

	public UserProfile() {
		super();
	}

	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */
}
