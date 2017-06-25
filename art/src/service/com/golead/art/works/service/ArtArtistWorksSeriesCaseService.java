package com.golead.art.works.service;

import java.io.Serializable;
import java.util.Map;
import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;

import com.golead.art.works.model.ArtArtistWorksSeriesCase;

public interface ArtArtistWorksSeriesCaseService {

	public ArtArtistWorksSeriesCase getArtArtistWorksSeriesCase(Serializable id) throws ServiceException;

	public void createArtArtistWorksSeriesCase(ArtArtistWorksSeriesCase artArtistWorksSeriesCase) throws ServiceException;

	public void updateArtArtistWorksSeriesCase(Map<String, String> artArtistWorksSeriesCaseMap) throws ServiceException;

	public void deleteArtArtistWorksSeriesCase(Serializable id) throws ServiceException;

	public PageQuery queryArtArtistWorksSeriesCase(PageQuery pageQuery) throws ServiceException;

	public void deleteArtArtistWorksSeriesCases(Serializable[] ids) throws ServiceException;  
}

