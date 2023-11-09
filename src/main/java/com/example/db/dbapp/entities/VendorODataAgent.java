package com.example.db.dbapp.entities;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.db.dbapp.processor.ODataInterface;
import com.example.db.dbapp.services.IVendorPersistance;

public class VendorODataAgent implements ODataInterface {

    @Autowired
    IVendorPersistance vendorAPI;

    @Override
    public List<?> getEntitySet() {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getEntitySet'");
       return vendorAPI.findAll();
    }

    @Override
    public Object getEntity(Map<String, ?> keys) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getEntity'");
        return vendorAPI.findById((String) keys.get("Id"));
    }

    @Override
    public List<?> getRelatedEntity(Object source, String relatedEntityName, Map<String, Object> keys,
            Field sourceField) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getRelatedEntity'");
        Vendor p;
		try {
			p = (Vendor)source;
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> targetKey = (Map<String, String>) source;
			String vendorId = targetKey.get("Id");
			p = vendorAPI.findById(vendorId).get();
		}
		
		if(relatedEntityName.equalsIgnoreCase("AddressSet")) {
			return p.getAddressList();
		}
		
		return new ArrayList<>();
    }

    @Override
    public void createEntity(Object dataToCreate) {
        // TODO Auto-generated method stub
        vendorAPI.save((Vendor)dataToCreate);
       // throw new UnsupportedOperationException("Unimplemented method 'createEntity'");
    }

    @Override
    public void deleteEntity(Map<String, ?> keys) {
        // TODO Auto-generated method stub
        //vendorAPI.deleteById(String Id);
        vendorAPI.deleteById((String)keys.get("Id"));
        //throw new UnsupportedOperationException("Unimplemented method 'deleteEntity'");
    }

    @Override
    public void updateEntity(Object dataToUpdate) {
        // TODO Auto-generated method stub
        vendorAPI.save((Vendor)dataToUpdate);
       // throw new UnsupportedOperationException("Unimplemented method 'updateEntity'");

    }

    @Override
    public void writeRelation(EdmEntitySet sourceEntitySet, Object sourceData, EdmEntitySet targetEntitySet,
            Map<String, Object> targetKeys) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeRelation'");
    }
    
}
