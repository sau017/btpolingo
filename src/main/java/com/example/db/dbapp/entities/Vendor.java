package com.example.db.dbapp.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.olingo.odata2.api.annotation.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.annotation.edm.EdmEntityType;
import org.apache.olingo.odata2.api.annotation.edm.EdmKey;
import org.apache.olingo.odata2.api.annotation.edm.EdmNavigationProperty;
import org.apache.olingo.odata2.api.annotation.edm.EdmProperty;
import org.apache.olingo.odata2.api.annotation.edm.EdmType;
import org.apache.olingo.odata2.api.annotation.edm.EdmNavigationProperty.Multiplicity;
import org.hibernate.annotations.GenericGenerator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="VENDOR")
@EdmEntitySet
@EdmEntityType
public class Vendor {
    @Id
    @Column(nullable = false , name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2" , strategy = "org.hibernate.id.UUIDGenerator")
    @EdmKey
	@EdmProperty
  private String code;
  @Column(nullable = false , name = "CompanyName")
  @EdmProperty
  private String companyName;
  @Column(nullable = false , name = "ContactPerson")
  @EdmProperty
  private String contactPerson;
  @Column(nullable = false , name = "FirstName")
  @EdmProperty
  private String firstName;
  @Column(nullable = false , name = "LastName")
  @EdmProperty
  private String lastName;
  @Column(nullable = false , name = "website")
  @EdmProperty
  private String website;
  @Column(nullable = false , name = "emailadd")
  @EdmProperty
  private String email;
  @Column(nullable = false , name = "status")
  @EdmProperty
  private String status;
  @Column(nullable = false , name = "RegistrationDate")
  @EdmProperty(type = EdmType.DATE_TIME)
  @Temporal(TemporalType.DATE)
  private Date regDate;

  @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
  @JoinColumn(name = "vendor",referencedColumnName = "ID")
  @EdmNavigationProperty(toType=Address.class, toMultiplicity=Multiplicity.MANY)
  private List<Address> addressList = new ArrayList<Address>();


public List<Address> getAddressList() {
    return addressList;
}
public void setAddressList(List<Address> addressList) {
    this.addressList = addressList;
}
public Vendor() {
    this.code = "VEND1";
    this.companyName = "Delloite";
    this.contactPerson = "Suman Singh";
    this.firstName = "Suman";
    this.lastName = "Singh";
    this.website = "www.Delloite.com";
    this.email = "anubhav@gmail.com";
    this.status = "A";
    this.regDate = new Date();
}
@Override
public String toString() {
    return "Vendor [code=" + code + ", companyName=" + companyName + ", contactPerson=" + contactPerson + ", firstName="
            + firstName + ", lastName=" + lastName + ", website=" + website + ", email=" + email + ", status=" + status
            + ", regDate=" + regDate + "]";
}
public String getCode() {
    return code;
}
public void setCode(String code) {
    this.code = code;
}
public String getCompanyName() {
    return companyName;
}
public void setCompanyName(String companyName) {
    this.companyName = companyName;
}
public String getContactPerson() {
    return contactPerson;
}
public void setContactPerson(String contactPerson) {
    this.contactPerson = contactPerson;
}
public String getFirstName() {
    return firstName;
}
public void setFirstName(String firstName) {
    this.firstName = firstName;
}
public String getLastName() {
    return lastName;
}
public void setLastName(String lastName) {
    this.lastName = lastName;
}
public String getWebsite() {
    return website;
}
public void setWebsite(String website) {
    this.website = website;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getStatus() {
    return status;
}
public void setStatus(String status) {
    this.status = status;
}
public Date getRegDate() {
    return regDate;
}
public void setRegDate(Date regDate) {
    this.regDate = regDate;
}

}