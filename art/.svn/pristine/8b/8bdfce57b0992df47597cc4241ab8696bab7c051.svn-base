package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.artist.model.ArtArtistCollectAgency;
import com.golead.art.works.dao.ArtArtistCollectAgencyDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistCollectAgencyDaoImpl extends HibernateDaoImpl<ArtArtistCollectAgency> implements ArtArtistCollectAgencyDao {

	public Class getReferenceClass() {
		return ArtArtistCollectAgency.class;
	}

	public ArtArtistCollectAgency cast(Object object) {
		return (ArtArtistCollectAgency) object;
	}

	public ArtArtistCollectAgency get(Serializable id)  throws DAOException{
		return (ArtArtistCollectAgency) super.get(id);
	}

	public ArtArtistCollectAgency load(Serializable id)  throws DAOException{
		return (ArtArtistCollectAgency) super.load(id);
	}

	public Serializable save(ArtArtistCollectAgency artArtistCollectAgency)  throws DAOException{
		return super.save(artArtistCollectAgency);
	}

	public void saveOrUpdate(ArtArtistCollectAgency artArtistCollectAgency)  throws DAOException{
		super.saveOrUpdate(artArtistCollectAgency);
	}

	public void update(ArtArtistCollectAgency artArtistCollectAgency)  throws DAOException{
		super.update(artArtistCollectAgency);
	}

	public void delete(ArtArtistCollectAgency artArtistCollectAgency)  throws DAOException{
		super.delete(artArtistCollectAgency);
	}

	public void refresh(ArtArtistCollectAgency artArtistCollectAgency)  throws DAOException{
		super.refresh(artArtistCollectAgency);
	}

	public String getTableName() {
		return ArtArtistCollectAgency.REF_TABLE;
	}
}
