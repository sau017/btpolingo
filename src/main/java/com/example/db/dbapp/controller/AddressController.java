package com.example.db.dbapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.db.dbapp.entities.Address;
import com.example.db.dbapp.services.AddressService;

@RestController
public class AddressController {
    
    @Autowired
    AddressService myAddresssrv;

    @RequestMapping("/address")
    public List<Address> getAddresses(){
        return myAddresssrv.getAllAddress();
    }

   @PostMapping("/address")

   public Address createAddress(@RequestBody Address newAddress) {
    return myAddresssrv.addAddress(newAddress);
   }
}
