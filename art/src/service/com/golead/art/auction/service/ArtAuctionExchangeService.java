package com.golead.art.auction.service;

import java.io.Serializable;
import java.util.Map;
import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;

import com.golead.art.auction.model.ArtAuctionExchange;

public interface ArtAuctionExchangeService {

	public ArtAuctionExchange getArtAuctionExchange(Serializable id) throws ServiceException;

	public void createArtAuctionExchange(ArtAuctionExchange artAuctionExchange) throws ServiceException;

	public void updateArtAuctionExchange(Map<String, String> artAuctionExchangeMap) throws ServiceException;

	public void deleteArtAuctionExchange(Serializable id) throws ServiceException;

	public PageQuery queryArtAuctionExchange(PageQuery pageQuery) throws ServiceException;

	public void deleteArtAuctionExchanges(Serializable[] ids) throws ServiceException;  
}

