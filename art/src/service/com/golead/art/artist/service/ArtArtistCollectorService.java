package com.golead.art.artist.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.artist.model.ArtArtistCollector;
import com.golead.art.works.model.ArtWorks;

public interface ArtArtistCollectorService {

	public ArtArtistCollector getArtArtistCollector(Serializable id) throws ServiceException;

	public void createArtArtistCollector(ArtArtistCollector artArtistCollector) throws ServiceException;

	public void updateArtArtistCollector(Map<String, String> artArtistCollectorMap) throws ServiceException;

	public void deleteArtArtistCollector(Serializable id) throws ServiceException;

	public PageQuery queryArtArtistCollector(PageQuery pageQuery) throws ServiceException;

	public void deleteArtArtistCollectors(Serializable[] ids) throws ServiceException;  
	
	public String importCollects(String path, int artistId) throws ServiceException;
	
	public String findByWorksId(String ids) throws ServiceException;
	
	public List<ArtWorks> findWorksByWorksId(String ids) throws ServiceException;
	
}

