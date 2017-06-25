package com.golead.art.artist.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.artist.model.ArtArtistWorksSeries;

public interface ArtArtistWorksSeriesService {

	public ArtArtistWorksSeries getArtArtistWorksSeries(Serializable id) throws ServiceException;

	public void createArtArtistWorksSeries(ArtArtistWorksSeries artArtistWorksSeries) throws ServiceException;

	public void updateArtArtistWorksSeries(Map<String, String> artArtistWorksSeriesMap) throws ServiceException;

	public void deleteArtArtistWorksSeries(Serializable id) throws ServiceException;

	/**
	 * 作品系列列表
	 * */
	public PageQuery queryArtArtistWorksSeries(PageQuery pageQuery) throws ServiceException;

	/**
	 * 在系列中但不是代表作的作品
	 * */
	public PageQuery queryArtArtistSeriesWorks(PageQuery pageQuery) throws ServiceException;

	public void deleteArtArtistWorksSeriess(Serializable[] ids) throws ServiceException;
	
	public List<ArtArtistWorksSeries> findByArtArtistId(Serializable id) throws ServiceException;
	
	public List<ArtArtistWorksSeries> findAll() throws ServiceException;
	
	public String importFile(String path,int artistId) throws ServiceException;
}

