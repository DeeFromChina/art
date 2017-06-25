package com.golead.art.publication.service;

import java.io.Serializable;
import java.util.Map;
import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;

import com.golead.art.publication.model.ArtPublicationLiterature;

public interface ArtPublicationLiteratureService {

	public ArtPublicationLiterature getArtPublicationLiterature(Serializable id) throws ServiceException;

	public void createArtPublicationLiterature(ArtPublicationLiterature artPublicationLiterature) throws ServiceException;

	public void updateArtPublicationLiterature(Map<String, String> artPublicationLiteratureMap) throws ServiceException;

	public void deleteArtPublicationLiterature(Serializable id) throws ServiceException;

	public PageQuery queryArtPublicationLiterature(PageQuery pageQuery) throws ServiceException;

	public void deleteArtPublicationLiteratures(Serializable[] ids) throws ServiceException;  
}

