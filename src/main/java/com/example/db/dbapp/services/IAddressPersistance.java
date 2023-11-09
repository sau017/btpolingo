package com.example.db.dbapp.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.db.dbapp.entities.Address;

public interface IAddressPersistance extends JpaRepository<Address ,String>{
    
}
