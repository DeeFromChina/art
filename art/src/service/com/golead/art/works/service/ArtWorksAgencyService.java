package com.golead.art.works.service;

import java.io.Serializable;
import java.util.Map;

import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.works.model.ArtWorksAgency;

public interface ArtWorksAgencyService {

	public ArtWorksAgency getArtWorksAgency(Serializable id) throws ServiceException;

	public void createArtWorksAgency(ArtWorksAgency artWorksAgency) throws ServiceException;

	public void updateArtWorksAgency(Map<String, String> artWorksAgencyMap) throws ServiceException;

	public void deleteArtWorksAgency(Serializable id) throws ServiceException;

	public PageQuery queryArtWorksAgency(PageQuery pageQuery) throws ServiceException;

	public void deleteArtWorksAgencys(Serializable[] ids) throws ServiceException;
	
	public int findByAgency(String ids) throws ServiceException;  
	
	public String findNameByIds(String ids) throws ServiceException;  
}

