package com.golead.art.works.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;

import com.golead.art.works.model.ArtArtistWorksSeriesResearch;

public interface ArtArtistWorksSeriesResearchService {

	public ArtArtistWorksSeriesResearch getArtArtistWorksSeriesResearch(Serializable id) throws ServiceException;

	public void createArtArtistWorksSeriesResearch(ArtArtistWorksSeriesResearch artArtistWorksSeriesResearch) throws ServiceException;

	public void createArtArtistWorksSeriesResearch(List<ArtArtistWorksSeriesResearch> artArtistWorksSeriesResearch) throws ServiceException;

	public void updateArtArtistWorksSeriesResearch(Map<String, String> artArtistWorksSeriesResearchMap) throws ServiceException;

	public void deleteArtArtistWorksSeriesResearch(Serializable id) throws ServiceException;

	public PageQuery queryArtArtistWorksSeriesResearch(PageQuery pageQuery) throws ServiceException;

	public void deleteArtArtistWorksSeriesResearchs(Serializable[] ids) throws ServiceException;  
}

