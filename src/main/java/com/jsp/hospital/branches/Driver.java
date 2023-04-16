package com.jsp.hospital.branches;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Driver {
public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("neha");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Hospital h2=new Hospital();
	h2.setName("Apollo");
	h2.setGst_no("asdfgh12345");
	
	Branches b1=new Branches();
	b1.setName("Apollo-1");
	b1.setLocation("vashi");
	
	Branches b2=new Branches();
	b2.setName("Apollo-2");
	b2.setLocation("Thane");
	
	Branches b3=new Branches();
	b3.setName("Apollo-3");
	b3.setLocation("panvel");
	
	List<Branches> branches=new ArrayList<Branches>();
	branches.add(b1);
	branches.add(b2);
	branches.add(b3);
	
	//uni-direction
	h2.setBranches(branches);
	
	et.begin();
	em.persist(b1);
	em.persist(b2);
	em.persist(b3);
	em.persist(h2);
	et.commit();
}
}