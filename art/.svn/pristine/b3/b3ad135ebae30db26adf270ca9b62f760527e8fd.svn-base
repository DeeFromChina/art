package com.golead.art.artist.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.artist.model.ArtCountry;

public interface ArtCountryService {

	public ArtCountry getArtCountry(Serializable id) throws ServiceException;

	public void createArtCountry(ArtCountry artCountry) throws ServiceException;

	public void updateArtCountry(Map<String, String> artCountryMap) throws ServiceException;

	public void deleteArtCountry(Serializable id) throws ServiceException;

	public PageQuery queryArtCountry(PageQuery pageQuery) throws ServiceException;

	public void deleteArtCountrys(Serializable[] ids) throws ServiceException;  
	
	public List<ArtCountry> findAll() throws ServiceException;  
}

