package com.golead.art.activity.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.golead.core.exception.ServiceException;
import com.golead.core.web.form.BaseForm;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.activity.model.ArtActivityAbmb;

public interface ArtActivityAbmbService {

	public ArtActivityAbmb getArtActivityAbmb(Serializable id) throws ServiceException;

	public void createArtActivityAbmb(ArtActivityAbmb artActivityAbmb) throws ServiceException;

	public void updateArtActivityAbmb(Map<String, String> artActivityAbmbMap) throws ServiceException;

	public void deleteArtActivityAbmb(Serializable id) throws ServiceException;

	public PageQuery queryArtActivityAbmb(PageQuery pageQuery) throws ServiceException;

	public void deleteArtActivityAbmbs(Serializable[] ids) throws ServiceException;
	
	public int findByCountry(String ids) throws ServiceException;
	
	public HSSFWorkbook export(BaseForm form, PageQuery pageQuery) throws ServiceException;
}

