package com.example.db.dbapp.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.db.dbapp.entities.Vendor;
import java.util.List;


public interface IVendorPersistance extends JpaRepository<Vendor ,String> {

    List <Vendor>findByCompanyName(String companyName);

    List<Vendor> findByFirstName(String firstName);

    @Query(nativeQuery=true, value = "SELECT * FROM public.vendor where email like %?1%")
    List<Vendor>lookupVendorByemail(String email);
    
}
