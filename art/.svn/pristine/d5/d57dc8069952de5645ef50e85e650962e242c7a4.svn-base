package com.golead.art.artist.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.artist.model.ArtArtistWorksSeries;
import com.golead.art.artist.dao.ArtArtistWorksSeriesDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistWorksSeriesDaoImpl extends HibernateDaoImpl<ArtArtistWorksSeries> implements ArtArtistWorksSeriesDao {

	public Class getReferenceClass() {
		return ArtArtistWorksSeries.class;
	}

	public ArtArtistWorksSeries cast(Object object) {
		return (ArtArtistWorksSeries) object;
	}

	public ArtArtistWorksSeries get(Serializable id)  throws DAOException{
		return (ArtArtistWorksSeries) super.get(id);
	}

	public ArtArtistWorksSeries load(Serializable id)  throws DAOException{
		return (ArtArtistWorksSeries) super.load(id);
	}

	public Serializable save(ArtArtistWorksSeries artArtistWorksSeries)  throws DAOException{
		return super.save(artArtistWorksSeries);
	}

	public void saveOrUpdate(ArtArtistWorksSeries artArtistWorksSeries)  throws DAOException{
		super.saveOrUpdate(artArtistWorksSeries);
	}

	public void update(ArtArtistWorksSeries artArtistWorksSeries)  throws DAOException{
		super.update(artArtistWorksSeries);
	}

	public void delete(ArtArtistWorksSeries artArtistWorksSeries)  throws DAOException{
		super.delete(artArtistWorksSeries);
	}

	public void refresh(ArtArtistWorksSeries artArtistWorksSeries)  throws DAOException{
		super.refresh(artArtistWorksSeries);
	}

	public String getTableName() {
		return ArtArtistWorksSeries.REF_TABLE;
	}
}
