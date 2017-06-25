package com.golead.art.works.service;

import java.io.Serializable;
import java.util.Map;
import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;

import com.golead.art.works.model.ArtSysLog;

public interface ArtSysLogService {

	public ArtSysLog getArtSysLog(Serializable id) throws ServiceException;

	public void createArtSysLog(ArtSysLog artSysLog) throws ServiceException;

	public void updateArtSysLog(Map<String, String> artSysLogMap) throws ServiceException;

	public void deleteArtSysLog(Serializable id) throws ServiceException;

	public PageQuery queryArtSysLog(PageQuery pageQuery) throws ServiceException;

	public void deleteArtSysLogs(Serializable[] ids) throws ServiceException;

	public void deleteArtSysLogs(String beginTime,String endTime) throws ServiceException;

	public void createArtSysLog(String operator,String operModule,String operFunction,String operResult) throws ServiceException;
}

