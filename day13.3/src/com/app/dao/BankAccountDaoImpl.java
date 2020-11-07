package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Vendor;

@Repository
@Transactional
public class BankAccountDaoImpl implements IBankAccountDao {

	@Autowired
	private SessionFactory sf;
	@Override
	public String createAccount(Vendor v) {
		sf.getCurrentSession().update(v);//detached ---->persistent
		return "A/C created for Vendor "+v.getName();
	}

}
