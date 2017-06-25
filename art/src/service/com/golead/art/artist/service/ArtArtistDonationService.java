package com.golead.art.artist.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;
import com.golead.art.artist.model.ArtArtistDonation;
import com.golead.art.works.model.ArtWorks;

public interface ArtArtistDonationService {

	public ArtArtistDonation getArtArtistDonation(Serializable id) throws ServiceException;

	public void createArtArtistDonation(ArtArtistDonation artArtistDonation) throws ServiceException;

	public void updateArtArtistDonation(Map<String, String> artArtistDonationMap) throws ServiceException;

	public void deleteArtArtistDonation(Serializable id) throws ServiceException;

	public PageQuery queryArtArtistDonation(PageQuery pageQuery) throws ServiceException;

	public void deleteArtArtistDonations(Serializable[] ids) throws ServiceException;  
	
	public void deleteArtArtistWithDonations(Serializable[] ids) throws ServiceException;
	
	public String importDonations(String path, int artistId) throws ServiceException;
	
	public String findByWorksId(String ids) throws ServiceException;
   
   public List<ArtWorks> findWorksByWorksId(String ids) throws ServiceException;
}

