package com.golead.art.artist.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.artist.model.ArtArtistWorksPeriod;
import com.golead.art.artist.dao.ArtArtistWorksPeriodDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistWorksPeriodDaoImpl extends HibernateDaoImpl<ArtArtistWorksPeriod> implements ArtArtistWorksPeriodDao {

	public Class getReferenceClass() {
		return ArtArtistWorksPeriod.class;
	}

	public ArtArtistWorksPeriod cast(Object object) {
		return (ArtArtistWorksPeriod) object;
	}

	public ArtArtistWorksPeriod get(Serializable id)  throws DAOException{
		return (ArtArtistWorksPeriod) super.get(id);
	}

	public ArtArtistWorksPeriod load(Serializable id)  throws DAOException{
		return (ArtArtistWorksPeriod) super.load(id);
	}

	public Serializable save(ArtArtistWorksPeriod artArtistWorksPeriod)  throws DAOException{
		return super.save(artArtistWorksPeriod);
	}

	public void saveOrUpdate(ArtArtistWorksPeriod artArtistWorksPeriod)  throws DAOException{
		super.saveOrUpdate(artArtistWorksPeriod);
	}

	public void update(ArtArtistWorksPeriod artArtistWorksPeriod)  throws DAOException{
		super.update(artArtistWorksPeriod);
	}

	public void delete(ArtArtistWorksPeriod artArtistWorksPeriod)  throws DAOException{
		super.delete(artArtistWorksPeriod);
	}

	public void refresh(ArtArtistWorksPeriod artArtistWorksPeriod)  throws DAOException{
		super.refresh(artArtistWorksPeriod);
	}

	public String getTableName() {
		return ArtArtistWorksPeriod.REF_TABLE;
	}
}
