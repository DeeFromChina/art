package com.golead.art.auction.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.auction.model.ArtAuctionWords;

public interface ArtAuctionWordsService {

	public ArtAuctionWords getArtAuctionWords(Serializable id) throws ServiceException;

	public void createArtAuctionWords(ArtAuctionWords artAuctionWords, List<File> files, String filesFileName, String path) throws ServiceException;

	public void updateArtAuctionWords(Map<String, String> artAuctionWordsMap, List<File> files, String fileName, String filesFileName, String path) throws ServiceException;

	public void deleteArtAuctionWords(Serializable id) throws ServiceException;

	public PageQuery queryArtAuctionWords(PageQuery pageQuery) throws ServiceException;

	public void deleteArtAuctionWordss(Serializable[] ids) throws ServiceException;  
	
	public void deleteArtAuctionWordss(Serializable[] ids, String path) throws ServiceException;
	
	public String importWords(String path, int auctionId) throws ServiceException;
}

