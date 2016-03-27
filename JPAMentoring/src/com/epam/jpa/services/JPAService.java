package com.epam.jpa.services;

import javax.persistence.EntityManager;

public class JPAService {
	private EntityManager em;

	public JPAService() {
		super();
	}

	public JPAService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void createEntity(Object entity) {
		em.persist(entity);
	}

}
