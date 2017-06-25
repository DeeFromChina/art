package com.golead.art.works.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.works.model.ArtWorksPeriod;

public interface ArtWorksPeriodService {

	public ArtWorksPeriod getArtWorksPeriod(Serializable id) throws ServiceException;

	public void createArtWorksPeriod(ArtWorksPeriod artWorksPeriod) throws ServiceException;

	public void updateArtWorksPeriod(Map<String, String> artWorksPeriodMap) throws ServiceException;

	public void deleteArtWorksPeriod(Serializable id) throws ServiceException;

	public PageQuery queryArtWorksPeriod(PageQuery pageQuery) throws ServiceException;

	public void deleteArtWorksPeriods(Serializable[] ids) throws ServiceException;  
	
	public void createArtWorksPeriodAndArtArtistWorksPeriod(Map<String, String> map) throws ServiceException;
	
	public String importArtWorksPeriod(String path, Integer id) throws ServiceException;
	
}

