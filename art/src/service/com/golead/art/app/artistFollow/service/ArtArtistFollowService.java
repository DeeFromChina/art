package com.golead.art.app.artistFollow.service;

import java.io.Serializable;
import java.util.Map;
import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;

import com.golead.art.app.artistFollow.model.ArtArtistFollow;

public interface ArtArtistFollowService {

	public ArtArtistFollow getArtArtistFollow(Serializable id) throws ServiceException;

	public void createArtArtistFollow(ArtArtistFollow artArtistFollow) throws ServiceException;

	public void updateArtArtistFollow(Map<String, String> artArtistFollowMap) throws ServiceException;

	public void deleteArtArtistFollow(Serializable id) throws ServiceException;

	public PageQuery queryArtArtistFollow(PageQuery pageQuery) throws ServiceException;

	public void deleteArtArtistFollows(Serializable[] ids) throws ServiceException;  
}

