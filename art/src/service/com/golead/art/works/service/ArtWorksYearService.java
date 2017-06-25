package com.golead.art.works.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;

import com.golead.art.works.model.ArtWorksYear;

public interface ArtWorksYearService {

	public ArtWorksYear getArtWorksYear(Serializable id) throws ServiceException;

	public void createArtWorksYear(ArtWorksYear artWorksYear) throws ServiceException;

	public void createArtWorksYear(List<ArtWorksYear> artWorksYear) throws ServiceException;

	public void updateArtWorksYear(Map<String, String> artWorksYearMap) throws ServiceException;

	public void deleteArtWorksYear(Serializable id) throws ServiceException;

	public PageQuery queryArtWorksYear(PageQuery pageQuery) throws ServiceException;

	public PageQuery queryArtYearWorks(PageQuery pageQuery) throws ServiceException;

	public void deleteArtWorksYears(Serializable[] ids) throws ServiceException;  
}

