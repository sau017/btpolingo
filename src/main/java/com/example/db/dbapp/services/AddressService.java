package com.example.db.dbapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.db.dbapp.entities.Address;

@Component
public class AddressService {

    @Autowired
    IAddressPersistance addressdb;

    public List<Address> getAllAddress(){
   
        return addressdb.findAll();
     }
     
     public Optional<Address> getVendorById(String addressid){
        return addressdb.findById(addressid);
     }
    
     public Address addAddress(Address newAddress){
        if(newAddress.getCity()=="RANCHI"){
           throw new Error ("Ranchi as a city now allowed");
        }
       
       return addressdb.save(newAddress);
     }
    
    
}
