/**
 * 
 */
package com.asanka.jdbc.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Asanka Siriwardena
 *
 */
@Entity
@Table(name="OFFICES")
public class Office implements Serializable {

	private static final long serialVersionUID = -4329954162519735354L;
	
	@Id
	private Integer officeCode;
	private String city;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private String country;
	private String postalCode;
	
	public Integer getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(Integer officeCode) {
		this.officeCode = officeCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@Override
	public String toString(){
		return "Office {id=" + getOfficeCode() + ", city=" + getCity() + ", country=" + getCountry() + "}";
	}
}
