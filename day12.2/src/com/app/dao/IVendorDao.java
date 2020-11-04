package com.app.dao;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorDao {
	List<Vendor> listVendors();
	String registerNewVendor(Vendor v);//v-- transient
	String deleteVendor(int vid);
	Vendor getCompleteDetails(int vid);

}
