package com.golead.art.artist.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.artist.model.ArtArtistWorksPeriod;

public interface ArtArtistWorksPeriodService {

	public ArtArtistWorksPeriod getArtArtistWorksPeriod(Serializable id) throws ServiceException;

	public void createArtArtistWorksPeriod(ArtArtistWorksPeriod artArtistWorksPeriod) throws ServiceException;

	public void updateArtArtistWorksPeriod(Map<String, String> artArtistWorksPeriodMap) throws ServiceException;

	public void deleteArtArtistWorksPeriod(Serializable id) throws ServiceException;

	public PageQuery queryArtArtistWorksPeriod(PageQuery pageQuery) throws ServiceException;

	public void deleteArtArtistWorksPeriods(Serializable[] ids) throws ServiceException;  
	
	public List<ArtArtistWorksPeriod> findByArtistId(Serializable id) throws ServiceException; 
	
	public List<ArtArtistWorksPeriod> findByPeriodType(String periodType) throws ServiceException;
	
	public List<ArtArtistWorksPeriod> findAllGroupPeriods() throws ServiceException;
	
	public ArtArtistWorksPeriod findOneArtArtistWorksPeriod(Map<String, String> artArtistWorksPeriodMap) throws ServiceException;
	
}

