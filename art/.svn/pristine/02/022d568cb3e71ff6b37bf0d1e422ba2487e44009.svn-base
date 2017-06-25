package com.golead.art.app.artistPage.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.art.app.artistPage.model.ArtArtistPage;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;

public interface ArtArtistPageService {

   public ArtArtistPage getArtArtistPage(Serializable id) throws ServiceException;

   public void createArtArtistPage(ArtArtistPage artArtistPage) throws ServiceException;
   
   public void updateArtArtistPage(Map<String, String> artArtistPageMap) throws ServiceException;

   public void deleteArtArtistPage(Serializable id) throws ServiceException;

   public PageQuery queryArtArtistPage(PageQuery pageQuery) throws ServiceException;
   
   public List<Map<String, Object>> queryArtArtistPage(Integer tempId) throws ServiceException;

   public void deleteArtArtistPages(Serializable[] ids) throws ServiceException;
   
   public void createArtArtistPage(ArtArtistPage artArtistPage,File file,String fileFileName,String path) throws ServiceException;
   
   public void updateArtArtistPage(Map<String, String> artArtistPageMap,File file,String fileName, String dir) throws ServiceException;
   
   public void deleteArtArtistPages(Serializable[] ids,String dir) throws ServiceException;
}
