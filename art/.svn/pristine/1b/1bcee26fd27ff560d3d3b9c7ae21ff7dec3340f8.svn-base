package com.golead.art.literature.service;

import java.io.Serializable;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.golead.core.exception.ServiceException;
import com.golead.core.web.form.BaseForm;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.literature.model.ArtLiteratureNetwork;

public interface ArtLiteratureNetworkService {

	public ArtLiteratureNetwork getArtLiteratureNetwork(Serializable id) throws ServiceException;

	public void createArtLiteratureNetwork(ArtLiteratureNetwork artLiteratureNetwork) throws ServiceException;

	public void updateArtLiteratureNetwork(Map<String, String> artLiteratureNetworkMap) throws ServiceException;

	public void deleteArtLiteratureNetwork(Serializable id) throws ServiceException;

	public PageQuery queryArtLiteratureNetwork(PageQuery pageQuery) throws ServiceException;

	public void deleteArtLiteratureNetworks(Serializable[] ids) throws ServiceException; 
	
	public HSSFWorkbook export(BaseForm form, PageQuery pageQuery) throws ServiceException;
}

