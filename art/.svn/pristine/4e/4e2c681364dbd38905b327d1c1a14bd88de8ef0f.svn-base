package com.golead.art.artist.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.artist.model.ArtArtistCollector;
import com.golead.art.artist.dao.ArtArtistCollectorDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistCollectorDaoImpl extends HibernateDaoImpl<ArtArtistCollector> implements ArtArtistCollectorDao {

	public Class getReferenceClass() {
		return ArtArtistCollector.class;
	}

	public ArtArtistCollector cast(Object object) {
		return (ArtArtistCollector) object;
	}

	public ArtArtistCollector get(Serializable id)  throws DAOException{
		return (ArtArtistCollector) super.get(id);
	}

	public ArtArtistCollector load(Serializable id)  throws DAOException{
		return (ArtArtistCollector) super.load(id);
	}

	public Serializable save(ArtArtistCollector artArtistCollector)  throws DAOException{
		return super.save(artArtistCollector);
	}

	public void saveOrUpdate(ArtArtistCollector artArtistCollector)  throws DAOException{
		super.saveOrUpdate(artArtistCollector);
	}

	public void update(ArtArtistCollector artArtistCollector)  throws DAOException{
		super.update(artArtistCollector);
	}

	public void delete(ArtArtistCollector artArtistCollector)  throws DAOException{
		super.delete(artArtistCollector);
	}

	public void refresh(ArtArtistCollector artArtistCollector)  throws DAOException{
		super.refresh(artArtistCollector);
	}

	public String getTableName() {
		return ArtArtistCollector.REF_TABLE;
	}
}
