package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.ICombinedDao;
import com.ust.model.Combined;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CombinedController {
	
	@Autowired
    ICombinedDao dao;
	
	@RequestMapping(value = "/vendordetails", method = RequestMethod.GET)
	public List getVendorDetails() {
		List list;
		list = dao.getAllDetails();
		return list;
	}
    
    //insert  vendor+contact details
	@RequestMapping(value = "/insertdetails", method = RequestMethod.POST)
	public void insertDetails(@RequestBody Combined vendor)
	{
			dao.insertDetails(vendor);
	}
	
	//update details
	@RequestMapping(value = "/updatedetails/{vId}", method = RequestMethod.PUT)
	public void updateDetails(@RequestBody Combined vendor)
	{
	
			dao.updateDetails(vendor);
	}
	
	
	//disable 
	@RequestMapping(value = "/disablevendor/{vId}", method = RequestMethod.PUT)
	void disableVendor(@PathVariable("vId") int vId) {
		dao.disableVendor(vId);
	}
	
	//search
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/searchdetails/{searchString}", method = RequestMethod.GET)
	public List searchVendorDetails( @PathVariable("searchString") String searchString) {
		List list;
		if (searchString.equals("null")) {
			list = dao.getAllDetails();
		} else {
			list = dao.searchVendorDetails(searchString);
		}
		return list;
	}
	
	//get by id
	@RequestMapping(value = "/vendorbyid/{vId}", method = RequestMethod.GET)
	public Combined getById(@PathVariable("vId") int vId) {
		Combined vendor =dao.getVendorById(vId);
		return vendor;
	}
	
	@RequestMapping(value = "/duplicatecheck/{cPhone}/{cEmail}", method = RequestMethod.GET)
	public Combined check(@PathVariable(value="cPhone") String cPhone,
			@PathVariable(value="cEmail") String cEmail){
		Combined vendor =dao.duplicatecheck(cPhone,cEmail);
		return vendor;
	}

}
