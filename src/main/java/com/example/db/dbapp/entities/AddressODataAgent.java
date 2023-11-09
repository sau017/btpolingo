package com.example.db.dbapp.entities;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.db.dbapp.processor.ODataInterface;
import com.example.db.dbapp.services.IAddressPersistance;

public class AddressODataAgent implements ODataInterface {

    @Autowired
    IAddressPersistance addressAPI;

    @Override
    public List<?> getEntitySet() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getEntitySet'");
        return addressAPI.findAll();
    }

    @Override
    public Object getEntity(Map<String, ?> keys) {
        // TODO Auto-generated method stub
        return addressAPI.findById((String)keys.get("Id"));
        //throw new UnsupportedOperationException("Unimplemented method 'getEntity'");
    }

    @Override
    public List<?> getRelatedEntity(Object source, String relatedEntityName, Map<String, Object> keys,
            Field sourceField) {
                return null;
        // TODO Auto-generated method stub
       
        //throw new UnsupportedOperationException("Unimplemented method 'getRelatedEntity'");
    }

    @Override
    public void createEntity(Object dataToCreate) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'createEntity'");
        addressAPI.save((Address)dataToCreate);
    }

    @Override
    public void deleteEntity(Map<String, ?> keys) {
        // TODO Auto-generated method stub
        addressAPI.deleteById((String)keys.get("Id"));
        //throw new UnsupportedOperationException("Unimplemented method 'deleteEntity'");
    }

    @Override
    public void updateEntity(Object dataToUpdate) {
        // TODO Auto-generated method stub
        addressAPI.save((Address)dataToUpdate);
        //throw new UnsupportedOperationException("Unimplemented method 'updateEntity'");
    }

    @Override
    public void writeRelation(EdmEntitySet sourceEntitySet, Object sourceData, EdmEntitySet targetEntitySet,
            Map<String, Object> targetKeys) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'writeRelation'");
        Vendor vendor = (Vendor)sourceData;
 		Optional<Address> existingAddr = addressAPI.findById((String) targetKeys.get("AddressId"));
		Address newAddr = existingAddr.get();
		newAddr.setVendor(vendor);
		addressAPI.save(newAddr);
    }
    
}
