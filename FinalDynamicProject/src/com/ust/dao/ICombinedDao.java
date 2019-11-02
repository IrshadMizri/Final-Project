package com.ust.dao;

import java.util.List;

import com.ust.model.Combined;

public interface ICombinedDao {
	
	public abstract int insertDetails(Combined vendor);

	public abstract List<Combined> getAllDetails();

	public abstract int disableVendor(int vId);

	public abstract int updateDetails(Combined vendor);

	public abstract List<Combined> searchVendorDetails(String searchString);

	public abstract Combined getVendorById(int vId);
	
	public abstract Combined duplicatecheck(String cPhone,String cEmail);

}
