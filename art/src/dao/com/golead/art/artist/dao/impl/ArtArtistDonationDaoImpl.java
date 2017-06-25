package com.golead.art.artist.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.artist.model.ArtArtistDonation;
import com.golead.art.artist.dao.ArtArtistDonationDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistDonationDaoImpl extends HibernateDaoImpl<ArtArtistDonation> implements ArtArtistDonationDao {

	public Class getReferenceClass() {
		return ArtArtistDonation.class;
	}

	public ArtArtistDonation cast(Object object) {
		return (ArtArtistDonation) object;
	}

	public ArtArtistDonation get(Serializable id)  throws DAOException{
		return (ArtArtistDonation) super.get(id);
	}

	public ArtArtistDonation load(Serializable id)  throws DAOException{
		return (ArtArtistDonation) super.load(id);
	}

	public Serializable save(ArtArtistDonation artArtistDonation)  throws DAOException{
		return super.save(artArtistDonation);
	}

	public void saveOrUpdate(ArtArtistDonation artArtistDonation)  throws DAOException{
		super.saveOrUpdate(artArtistDonation);
	}

	public void update(ArtArtistDonation artArtistDonation)  throws DAOException{
		super.update(artArtistDonation);
	}

	public void delete(ArtArtistDonation artArtistDonation)  throws DAOException{
		super.delete(artArtistDonation);
	}

	public void refresh(ArtArtistDonation artArtistDonation)  throws DAOException{
		super.refresh(artArtistDonation);
	}

	public String getTableName() {
		return ArtArtistDonation.REF_TABLE;
	}
}
