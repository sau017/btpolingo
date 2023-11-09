package com.example.db.dbapp.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.db.dbapp.entities.Vendor;
import com.example.db.dbapp.services.VendorService;

@RestController
public class VendorController {
    

@Autowired
private VendorService myVendorSrv;

@RequestMapping ("/vendors")
public List<Vendor> getAll(){
    return myVendorSrv.getAllVendors();
}

@RequestMapping("/vendors/{vendorcode}")
    public Optional<Vendor> getVendorById (@PathVariable("vendorcode") String code){
      return myVendorSrv.getVendorById(code);
    }

    @PostMapping("/vendors")
    public Vendor CreateVendor(@RequestBody Vendor postbody) {

      return myVendorSrv.addVendor(postbody);
       
        
      }

      @RequestMapping(method= RequestMethod.PUT,value ="/changevendor")

      public Vendor updateVendor(@RequestBody Vendor VendorData,String vendorId){
          return myVendorSrv.updateVendorbyID(vendorId, VendorData);
      }

      @DeleteMapping("/vendor/{code}")

      public  String RemoveVendor(@PathVariable("code") String code){
          return myVendorSrv.deleteVendor(code);
      }
      
      @RequestMapping("/vendor/search")
      public List<Vendor> searchbyCompanyName(@RequestParam String company){
         return myVendorSrv.getVendorbyCompanyName(company);
      }
      
      @RequestMapping("/vendor/lookupf/{firstname}")
      public List<Vendor> searchByFirstName(@PathVariable("firstname") String firstname ) {
           return myVendorSrv.getVendorbyFirstName(firstname);
      }

      @RequestMapping("/vendor/lookupe/{emailid}")
      public List<Vendor> searchByEmailId(@PathVariable("emailid") String emailid ) {
           return myVendorSrv.getVendorbyEmail(emailid);
      }

}


