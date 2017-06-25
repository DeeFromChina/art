package com.golead.art.activity.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.activity.model.ArtAgency;

public interface ArtAgencyService {

	public ArtAgency getArtAgency(Serializable id) throws ServiceException;

	public void createArtAgency(ArtAgency artAgency) throws ServiceException;

	public void updateArtAgency(Map<String, String> artAgencyMap) throws ServiceException;

	public void deleteArtAgency(Serializable id) throws ServiceException;

	public PageQuery queryArtAgency(PageQuery pageQuery) throws ServiceException;

	public void deleteArtAgencys(Serializable[] ids) throws ServiceException;
	
	public List<ArtAgency> findAll() throws ServiceException; 
	
	public int findByCountry(String ids) throws ServiceException;
}

