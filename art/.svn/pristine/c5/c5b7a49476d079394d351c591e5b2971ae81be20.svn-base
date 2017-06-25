package com.golead.art.artist.service;

import java.io.Serializable;
import java.util.Map;

import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.artist.model.ArtArtistCoop;

public interface ArtArtistCoopService {

	public ArtArtistCoop getArtArtistCoop(Serializable id) throws ServiceException;

	public void createArtArtistCoop(ArtArtistCoop artArtistCoop) throws ServiceException;

	public void updateArtArtistCoop(Map<String, String> artArtistCoopMap) throws ServiceException;

	public void deleteArtArtistCoop(Serializable id) throws ServiceException;

	public PageQuery queryArtArtistCoop(PageQuery pageQuery) throws ServiceException;

	public void deleteArtArtistCoops(Serializable[] ids) throws ServiceException;  
	
	public void deleteArtArtistWithCoops(Serializable[] ids) throws ServiceException;
	
	public String importCoops(String path, int artistId) throws ServiceException;
}

