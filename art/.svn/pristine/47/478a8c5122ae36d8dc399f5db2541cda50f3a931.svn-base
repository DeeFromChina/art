package com.golead.art.app.homePage.service;

import java.io.File;
import java.io.Serializable;
import java.util.Map;
import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;

import com.golead.art.app.homePage.model.ArtAppHomePage;

public interface ArtAppHomePageService {

	public ArtAppHomePage getArtAppHomePage(Serializable id) throws ServiceException;

	public void createArtAppHomePage(ArtAppHomePage artAppHomePage) throws ServiceException;
	
	public void createArtAppHomePage(ArtAppHomePage artAppHomePage,File file,String fileFileName,String path) throws ServiceException;

	public void updateArtAppHomePage(Map<String, String> artAppHomePageMap) throws ServiceException;
	
	public void updateArtAppHomePage(Map<String, String> artAppHomePageMap,File file,String fileName, String dir) throws ServiceException;

	public void deleteArtAppHomePage(Serializable id) throws ServiceException;

	public PageQuery queryArtAppHomePage(PageQuery pageQuery) throws ServiceException;

	public void deleteArtAppHomePages(Serializable[] ids) throws ServiceException; 
	
	public void deleteArtAppHomePages(Serializable[] ids,String dir) throws ServiceException; 
}

