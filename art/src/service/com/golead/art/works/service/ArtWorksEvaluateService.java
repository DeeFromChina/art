package com.golead.art.works.service;

import java.io.Serializable;
import java.util.Map;

import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.works.model.ArtWorksEvaluate;

public interface ArtWorksEvaluateService {

	public ArtWorksEvaluate getArtWorksEvaluate(Serializable id) throws ServiceException;

	public void createArtWorksEvaluate(ArtWorksEvaluate artWorksEvaluate) throws ServiceException;

	public void updateArtWorksEvaluate(Map<String, String> artWorksEvaluateMap) throws ServiceException;

	public void deleteArtWorksEvaluate(Serializable id) throws ServiceException;

	public PageQuery queryArtWorksEvaluate(PageQuery pageQuery) throws ServiceException;

	public void deleteArtWorksEvaluates(Serializable[] ids) throws ServiceException;
	
	public String importArtWorksEvaluate(String path, Integer id) throws ServiceException;
}

