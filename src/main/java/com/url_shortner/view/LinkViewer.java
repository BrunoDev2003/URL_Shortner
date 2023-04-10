package com.url_shortner.view;

import java.util.List;

import com.url_shortner.persistence.linkDAO;

public class LinkViewer {
	
	
	public List<LinkBean>getLinks() {
		List<LinkBean> links = null;
		
		try {
			linkDAO linkdao = new linkDAO();
			linkdao = (linkDAO) linkdao.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return links;
	}
	
	public LinkBean getLinkByCode(String code) {
		LinkBean links = null;
		
		try {
			linkDAO linkdao = new linkDAO();
			links = linkDAO.getLinkByCode(code);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return links;
	}
	
	
}
