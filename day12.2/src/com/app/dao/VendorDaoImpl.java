package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.app.pojos.Role;
import com.app.pojos.Vendor;

@Repository
@Transactional
public class VendorDaoImpl implements IVendorDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public List<Vendor> listVendors() {
		String jqpl = "select v from Vendor v where v.userRole=:rl";
		return sf.getCurrentSession().createQuery(jqpl, Vendor.class).setParameter("rl", Role.VENDOR).getResultList();
	}

	@Override
	public String registerNewVendor(Vendor v) {
		sf.getCurrentSession().persist(v);
		return "Vendor reged successfully with ID " + v.getId();
	}

	@Override
	public String deleteVendor(int vid) {
		Session hs = sf.getCurrentSession();
		Vendor v = hs.get(Vendor.class, vid);
		if (v != null)
			hs.delete(v);
		return "Vendor details deleted for ID " + vid;
	}

	@Override
	public Vendor getCompleteDetails(int vid) {
		// return vendor with vendor + acct dtls
		String jpql = "select v from Vendor v left outer join fetch v.accounts where v.id=:v_id";

		return sf.getCurrentSession().createQuery(jpql, Vendor.class).
				setParameter("v_id", vid).getSingleResult();
	}

}
