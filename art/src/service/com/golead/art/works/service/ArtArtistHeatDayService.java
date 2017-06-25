package com.golead.art.works.service;

import java.io.Serializable;
import java.util.Map;
import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;

import com.golead.art.works.model.ArtArtistHeatDay;

public interface ArtArtistHeatDayService {

	public ArtArtistHeatDay getArtArtistHeatDay(Serializable id) throws ServiceException;

	public void createArtArtistHeatDay(ArtArtistHeatDay artArtistHeatDay) throws ServiceException;

	public void updateArtArtistHeatDay(Map<String, String> artArtistHeatDayMap) throws ServiceException;

	public void deleteArtArtistHeatDay(Serializable id) throws ServiceException;

	public PageQuery queryArtArtistHeatDay(PageQuery pageQuery) throws ServiceException;

	public void deleteArtArtistHeatDays(Serializable[] ids) throws ServiceException;  
}

