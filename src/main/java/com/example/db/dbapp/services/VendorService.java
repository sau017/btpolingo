package com.example.db.dbapp.services;


import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.db.dbapp.entities.Vendor;

@Component
public class VendorService {
  
   @Autowired
    IVendorPersistance vendorDB;

   

   

 public List<Vendor> getAllVendors(){
   
    return vendorDB.findAll();
 }
 
 public Optional<Vendor> getVendorById(String vendorid){
    return vendorDB.findById(vendorid);
 }

 public Vendor addVendor(Vendor newVendor){
   
   return vendorDB.save(newVendor);
 }

 public Vendor updateVendorbyID(String vendorId, Vendor vendorData){
    // Optional<Vendor> vendorfound = vendorDB.findById(vendorId);
   return vendorDB.save(vendorData);
 }
 public String  deleteVendor(String vendorid) {
   vendorDB.deleteById(vendorid);
   return "Object Was deleted";
 }
 public List<Vendor>getVendorbyCompanyName(String companyName){
   return vendorDB.findByCompanyName(companyName);

}
public List<Vendor>getVendorbyFirstName(String firstName){
   return vendorDB.findByFirstName(firstName);

     
}
public List<Vendor>getVendorbyEmail(String email){
    return vendorDB.lookupVendorByemail(email);
}

}