package com.golead.art.artist.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.artist.model.ArtArtistHonors;
import com.golead.art.artist.dao.ArtArtistHonorsDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistHonorsDaoImpl extends HibernateDaoImpl<ArtArtistHonors> implements ArtArtistHonorsDao {

	public Class getReferenceClass() {
		return ArtArtistHonors.class;
	}

	public ArtArtistHonors cast(Object object) {
		return (ArtArtistHonors) object;
	}

	public ArtArtistHonors get(Serializable id)  throws DAOException{
		return (ArtArtistHonors) super.get(id);
	}

	public ArtArtistHonors load(Serializable id)  throws DAOException{
		return (ArtArtistHonors) super.load(id);
	}

	public Serializable save(ArtArtistHonors artArtistHonors)  throws DAOException{
		return super.save(artArtistHonors);
	}

	public void saveOrUpdate(ArtArtistHonors artArtistHonors)  throws DAOException{
		super.saveOrUpdate(artArtistHonors);
	}

	public void update(ArtArtistHonors artArtistHonors)  throws DAOException{
		super.update(artArtistHonors);
	}

	public void delete(ArtArtistHonors artArtistHonors)  throws DAOException{
		super.delete(artArtistHonors);
	}

	public void refresh(ArtArtistHonors artArtistHonors)  throws DAOException{
		super.refresh(artArtistHonors);
	}

	public String getTableName() {
		return ArtArtistHonors.REF_TABLE;
	}
}
