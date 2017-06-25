package com.golead.art.artist.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.artist.model.ArtArtistCollectAgency;
import com.golead.art.works.model.ArtWorks;

public interface ArtArtistCollectAgencyService {

	public ArtArtistCollectAgency getArtArtistCollectAgency(Serializable id) throws ServiceException;

	public void createArtArtistCollectAgency(ArtArtistCollectAgency artArtistCollectAgency) throws ServiceException;

	public void updateArtArtistCollectAgency(Map<String, String> artArtistCollectAgencyMap) throws ServiceException;

	public void deleteArtArtistCollectAgency(Serializable id) throws ServiceException;

	public PageQuery queryArtArtistCollectAgency(PageQuery pageQuery) throws ServiceException;

	public void deleteArtArtistCollectAgencys(Serializable[] ids) throws ServiceException;  
	
	public int findByAgency(String ids) throws ServiceException;
	
	public String importFile(String path,int artistId) throws ServiceException;
	
	public String findByWorksId(String ids) throws ServiceException;
	
	public List<ArtWorks> findWorksByWorksId(String ids) throws ServiceException;
	
}

