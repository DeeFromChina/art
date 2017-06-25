package com.golead.art.auction.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.auction.model.ArtAuctionVideo;

public interface ArtAuctionVideoService {

	public ArtAuctionVideo getArtAuctionVideo(Serializable id) throws ServiceException;

	public void createArtAuctionVideo(ArtAuctionVideo artAuctionVideo, List<File> videoFiles, String filesFileName, String path) throws ServiceException;

	public void updateArtAuctionVideo(Map<String, String> artAuctionVideoMap, List<File> videoFiles,String fileName, String filesFileName, String path) throws ServiceException;

	public void deleteArtAuctionVideo(Serializable id) throws ServiceException;

	public PageQuery queryArtAuctionVideo(PageQuery pageQuery) throws ServiceException;

	public void deleteArtAuctionVideos(Serializable[] ids, String path) throws ServiceException;  

	public void deleteArtAuctionVideos(Serializable[] ids) throws ServiceException;  
	
	public String importVideo(String path, int auctionId) throws ServiceException;
}

