package com.golead.art.artist.service;

import java.io.Serializable;
import java.util.Map;
import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;

import com.golead.art.artist.model.ArtCollectArtist;

public interface ArtCollectArtistService {

	public ArtCollectArtist getArtCollectArtist(Serializable id) throws ServiceException;

	public void createArtCollectArtist(ArtCollectArtist artCollectArtist) throws ServiceException;

	public void updateArtCollectArtist(Map<String, String> artCollectArtistMap) throws ServiceException;

	public void deleteArtCollectArtist(Serializable id) throws ServiceException;

	public PageQuery queryArtCollectArtist(PageQuery pageQuery) throws ServiceException;

	public void deleteArtCollectArtists(Serializable[] ids) throws ServiceException;  
}

