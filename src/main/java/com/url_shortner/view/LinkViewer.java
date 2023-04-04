package com.url_shortner.view;

import java.util.List;

public class LinkViewer {
	
	
	public List<LinkBean>getLinks() {
		
		try {
			LinkDAO linkdao = new LinkDAO();
			linkdao = linkdao.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return linkdao;
	}
}
