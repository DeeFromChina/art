package com.golead.art.literature.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.golead.art.literature.model.ArtLiteratureWords;
import com.golead.art.literature.model.ArtLiteratureWordsResearch;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.web.form.BaseForm;

public interface ArtLiteratureWordsService {

	public ArtLiteratureWords getArtLiteratureWords(Serializable id) throws ServiceException;

	public void createArtLiteratureWords(ArtLiteratureWords artLiteratureWords) throws ServiceException;
	
	public void createArtLiteratureWords(Map<String, String> map, List<File> files, String filesFileName, String path, String pathIndex, Map<String, Object> request) throws ServiceException;

	public void updateArtLiteratureWords(Map<String, String> artLiteratureWordsMap) throws ServiceException;

	public void deleteArtLiteratureWords(Serializable id) throws ServiceException;

	public PageQuery queryArtLiteratureWords(PageQuery pageQuery) throws ServiceException;

	public void deleteArtLiteratureWordss(Serializable[] ids) throws ServiceException;  
	
	public void updateArtLiteratureWords(ArtLiteratureWords artLiteratureWords) throws ServiceException;
	
	public void updateFile(ArtLiteratureWordsResearch artLiteratureWordsResearch, ArtLiteratureWords artLiteratureWords, List<File> files, String filesFileName, String FILE_PATH, String fileName, String pathIndex, Map<String, Object> request) throws ServiceException;
	
	public HSSFWorkbook export(BaseForm form, PageQuery pageQuery) throws ServiceException;
	
	public void changepath(ArtLiteratureWords artLiteratureWords, String FILE_PATH, String ArtistId);
}

