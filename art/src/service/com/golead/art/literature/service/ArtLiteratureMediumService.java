package com.golead.art.literature.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.golead.core.exception.ServiceException;
import com.golead.core.web.form.BaseForm;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.literature.model.ArtLiteratureMedium;
import com.golead.art.literature.model.ArtLiteratureMediumResearch;
import com.golead.art.works.model.ArtWorks;

public interface ArtLiteratureMediumService {

	public ArtLiteratureMedium getArtLiteratureMedium(Serializable id) throws ServiceException;

	public void createArtLiteratureMedium(ArtLiteratureMedium artLiteratureMedium) throws ServiceException;

	public void updateArtLiteratureMedium(Map<String, String> artLiteratureMediumMap) throws ServiceException;

	public void deleteArtLiteratureMedium(Serializable id) throws ServiceException;

	public PageQuery queryArtLiteratureMedium(PageQuery pageQuery) throws ServiceException;

	public void deleteArtLiteratureMediums(Serializable[] ids) throws ServiceException; 
	
	public void updateArtLiteratureMedium(ArtLiteratureMedium artLiteratureMedium) throws ServiceException;
	
	public boolean saveFile(ArtLiteratureMedium artLiteratureMedium, List<File> files, String filesFileName, String FILE_PATH) throws ServiceException;
	
	public void updateFile(ArtLiteratureMediumResearch artLiteratureMediumResearch, ArtLiteratureMedium artLiteratureMedium, List<File> files, String filesFileName, String FILE_PATH, String fileName) throws ServiceException;
	
	public HSSFWorkbook export(BaseForm form, PageQuery pageQuery) throws ServiceException;
	
}

