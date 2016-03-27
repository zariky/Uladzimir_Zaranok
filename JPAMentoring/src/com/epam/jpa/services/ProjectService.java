package com.epam.jpa.services;

import javax.persistence.EntityManager;

import com.epam.jpa.beans.Project;

public class ProjectService {
	private EntityManager em;

	public ProjectService() {
		super();
	}

	public ProjectService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void createProject(Project project) {
		em.persist(project);
	}
	
	public Project findProject(int projectId) {
		return em.find(Project.class, projectId);
	}
	
	public void deleteProject(int id) {
		Project project = findProject(id);
	    if (project != null) {
	    	em.remove(project);
	    }
	}
	
	public Project updateProject (Project project) {
	    return em.merge(project);
	}
	
}
