package com.golead.art.works.service;

import java.io.Serializable;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.golead.core.exception.ServiceException;
import com.golead.core.web.form.BaseForm;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.works.model.ArtWorksAbmb;

public interface ArtWorksAbmbService {

	public ArtWorksAbmb getArtWorksAbmb(Serializable id) throws ServiceException;

	public void createArtWorksAbmb(ArtWorksAbmb artWorksAbmb) throws ServiceException;
	
	public void createArtWorksAbmb(int worksId, int[] ids) throws ServiceException;
	
	public void createArtWorksAbmb2(int abmbId, int[] ids) throws ServiceException;

	public void updateArtWorksAbmb(Map<String, String> artWorksAbmbMap) throws ServiceException;

	public void deleteArtWorksAbmb(Serializable id) throws ServiceException;

	public PageQuery queryArtWorksAbmb(PageQuery pageQuery) throws ServiceException;

	public void deleteArtWorksAbmbs(Serializable[] ids) throws ServiceException;  
	
	public String findArtistNameByAbmbId(String id) throws ServiceException;
	
}

