package com.golead.art.publication.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;

import com.golead.art.publication.model.ArtPublicationAgency;

public interface ArtPublicationAgencyService {

	public ArtPublicationAgency getArtPublicationAgency(Serializable id) throws ServiceException;

	public void createArtPublicationAgency(ArtPublicationAgency artPublicationAgency) throws ServiceException;

	public void createArtPublicationAgency(List<ArtPublicationAgency> artPublicationAgencies) throws ServiceException;

	public void updateArtPublicationAgency(Map<String, String> artPublicationAgencyMap) throws ServiceException;

	public void deleteArtPublicationAgency(Serializable id) throws ServiceException;

	public PageQuery queryArtPublicationAgency(PageQuery pageQuery) throws ServiceException;

	public PageQuery queryAgency(PageQuery pageQuery) throws ServiceException;

	public void deleteArtPublicationAgencys(Serializable[] ids) throws ServiceException;  
}

