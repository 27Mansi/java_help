package com.app.dao;

import com.app.pojos.Vendor;

public interface IUserDao {
	Vendor validateUser(String email, String pass);
}
