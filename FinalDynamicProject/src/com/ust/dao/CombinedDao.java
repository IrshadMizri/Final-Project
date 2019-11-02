package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.Combined;

public class CombinedDao implements ICombinedDao {
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
	this.template = template;
	}
	
	private Integer getMaxvId() {
		
		String sql = "SELECT MAX(vId) FROM Vendor";
		Integer seq = template.queryForObject(sql, new Object[] {}, Integer.class);
		return seq;
	}

	@Override
	public int insertDetails(Combined vendor) {
		//insert into vendor table 
		String sqlOne="INSERT INTO Vendor(vName,vAddress,vLocation,vService, "
				+ "vPincode) VALUES('"+
				vendor.getvName()+"','"+
				vendor.getvAddress()+"','"+
				vendor.getvLocation()+"','"+
				vendor.getvService()+"',"+
				vendor.getvPincode()+") ";
		template.update(sqlOne);
		
		//get latest vID produced by insertion just happened
		Integer latestvId=getMaxvId();
		System.out.println(latestvId);
		
		//insert into contact table
		String sqlTwo="INSERT INTO Contact(cName,cDepartment,cEmail,cPhone,cvId) "
				+ "VALUES('"+vendor.getcName()+"','"+
				vendor.getcDepartment()+"','"+
				vendor.getcEmail()+"','"+
				vendor.getcPhone()+"',? )";
		return template.update(sqlTwo,new Object[] {latestvId});	
	}
	
	// Get all details

	@Override
	public List<Combined> getAllDetails() {
		return template.query("SELECT v.vId,v.vName,v.vLocation,v.vService,c.cName,"
    			+ "c.cdepartment,c.cphone,v.vaddress,c.cemail,v.isactive,v.vpincode FROM Vendor v JOIN Contact c"
    			+ " ON(v.vId=c.cvId) WHERE v.isActive='Y' ORDER BY v.vId DESC",
						new RowMapper<Combined>() {
							public Combined mapRow(ResultSet rs, int row)
									throws SQLException {
								Combined vendor = new Combined();
								vendor.setvId(rs.getInt(1));
								vendor.setvName(rs.getString(2));
								vendor.setvLocation(rs.getString(3));
								vendor.setvService(rs.getString(4));
								vendor.setcName(rs.getString(5));
								vendor.setcDepartment(rs.getString(6));
								vendor.setcPhone(rs.getLong(7));
								vendor.setvAddress(rs.getString(8));
								vendor.setcEmail(rs.getString(9));
								vendor.setIsActive(rs.getString(10));
								vendor.setvPincode(rs.getDouble(11));
								return vendor;
							}
						});
	}

	@Override
	public int disableVendor(int vId) {
		String sql = "UPDATE Vendor SET isActive='N' WHERE vId=?";
		return template.update(sql,new Object[] { vId });
	}

	@Override
	public int updateDetails(Combined vendor) {
		//update vendor table
    	String sqlOne="UPDATE Vendor SET vName='"+vendor.getvName()
    			      +"',vAddress='"+vendor.getvAddress()+"',vLocation='"
    			      +vendor.getvLocation()+"',vService='"
    			      +vendor.getvService()+"',vpincode="+
    			      vendor.getvPincode()+" where vId=?";
    	template.update(sqlOne,new Object[] {vendor.getvId()});
    	
    	//update contact table
    	String sqlTwo="UPDATE Contact SET cName='"+vendor.getcName()
    			      +"',cDepartment='"+vendor.getcDepartment()
    			      +"',cEmail='"+vendor.getcEmail()+"',cPhone='"
    			      +vendor.getcPhone()+"' WHERE cvId=?";
    	
    	return template.update(sqlTwo,new Object[] {vendor.getvId()});
	}

	@Override
	public List<Combined> searchVendorDetails(String searchString) {
		return template.query("SELECT v.vId,v.vName,v.vLocation,v.vService,c.cName,"
    			+ "c.cdepartment,c.cphone,v.vaddress,c.cemail,v.isactive,v.vpincode FROM Vendor v JOIN Contact c"
    			+ " ON(v.vId=c.cvId) WHERE v.isActive='Y' and v.vName LIKE '%"+searchString
    			+"%' or v.vLocation LIKE '%"+searchString+"%' or v.vService LIKE '%"+searchString+"%'",
						new RowMapper<Combined>() {
							public Combined mapRow(ResultSet rs, int row)
									throws SQLException {
								Combined vendor = new Combined();
								vendor.setvId(rs.getInt(1));
								vendor.setvName(rs.getString(2));
								vendor.setvLocation(rs.getString(3));
								vendor.setvService(rs.getString(4));
								vendor.setcName(rs.getString(5));
								vendor.setcDepartment(rs.getString(6));
								vendor.setcPhone(rs.getLong(7));
								vendor.setvAddress(rs.getString(8));
								vendor.setcEmail(rs.getString(9));
								vendor.setIsActive(rs.getString(10));
								vendor.setvPincode(rs.getDouble(11));
								return vendor;
							}
						});
	}

	@Override
	public Combined getVendorById(int vId) {
		String sql = "SELECT v.vId,v.vName,v.vLocation,v.vService,v.vAddress,v.vpincode,c.cName,"
    			+ "c.cdepartment,c.cphone,c.cemail FROM Vendor v JOIN Contact c"
    			+ " ON(v.vId=c.cvId) WHERE v.isActive='Y' AND v.vId=?";
		return template.queryForObject(sql, new Object[] {vId},
				new BeanPropertyRowMapper<Combined>(Combined.class));
	}

	@Override
	public Combined duplicatecheck(String cPhone, String cEmail) {
		String sql = "SELECT c.cemail,c.cphone FROM vendor v JOIN contact c ON(v.vid=c.cvid) WHERE (c.cphone=? OR c.cemail=?) AND v.isactive='Y'";
		return template.queryForObject(sql, new Object[] {cPhone,cEmail},
				new BeanPropertyRowMapper<Combined>(Combined.class));
	}

}
