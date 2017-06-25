package com.golead.art.works.service;

import java.io.Serializable;
import java.util.Map;
import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;

import com.golead.art.works.model.ArtWorksWords;

public interface ArtWorksWordsService {

	public ArtWorksWords getArtWorksWords(Serializable id) throws ServiceException;

	public void createArtWorksWords(ArtWorksWords artWorksWords) throws ServiceException;
	
	public void createArtWorksWords(int worksId, int[] ids) throws ServiceException;

	public void updateArtWorksWords(Map<String, String> artWorksWordsMap) throws ServiceException;

	public void deleteArtWorksWords(Serializable id) throws ServiceException;

	public PageQuery queryArtWorksWords(PageQuery pageQuery) throws ServiceException;

	public void deleteArtWorksWordss(Serializable[] ids) throws ServiceException;  
}

