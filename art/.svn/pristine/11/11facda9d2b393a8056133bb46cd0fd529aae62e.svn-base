package com.golead.art.auction.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.golead.art.artist.model.ArtCollectArtist;
import com.golead.art.auction.model.ArtAuction;
import com.golead.art.auction.model.ArtAuctionHouses;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.web.form.BaseForm;

public interface ArtAuctionService {

   public ArtAuction getArtAuction(Serializable id) throws ServiceException;

   public void createArtAuction(ArtAuction artAuction) throws ServiceException;

   public void updateArtAuction(Map<String, String> artAuctionMap) throws ServiceException;

   public void deleteArtAuction(Serializable id) throws ServiceException;

   public PageQuery queryArtAuction(PageQuery pageQuery) throws ServiceException;

   public void deleteArtAuctions(Serializable[] ids) throws ServiceException;

   public void createArtAuction(Map<String, Object> map, List<ArtCollectArtist> artists, List<ArtAuctionHouses> houses) throws ServiceException;
   
   public String importArtAuction(String path) throws ServiceException;
   
   public HSSFWorkbook export(BaseForm form, PageQuery pageQuery) throws ServiceException;
}
