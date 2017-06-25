package com.golead.art.artist.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.artist.model.ArtArtist;
import com.golead.art.artist.dao.ArtArtistDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistDaoImpl extends HibernateDaoImpl<ArtArtist> implements ArtArtistDao {

	public Class getReferenceClass() {
		return ArtArtist.class;
	}

	public ArtArtist cast(Object object) {
		return (ArtArtist) object;
	}

	public ArtArtist get(Serializable id)  throws DAOException{
		return (ArtArtist) super.get(id);
	}

	public ArtArtist load(Serializable id)  throws DAOException{
		return (ArtArtist) super.load(id);
	}

	public Serializable save(ArtArtist artArtist)  throws DAOException{
		return super.save(artArtist);
	}

	public void saveOrUpdate(ArtArtist artArtist)  throws DAOException{
		super.saveOrUpdate(artArtist);
	}

	public void update(ArtArtist artArtist)  throws DAOException{
		super.update(artArtist);
	}

	public void delete(ArtArtist artArtist)  throws DAOException{
		super.delete(artArtist);
	}

	public void refresh(ArtArtist artArtist)  throws DAOException{
		super.refresh(artArtist);
	}

	public String getTableName() {
		return ArtArtist.REF_TABLE;
	}
}
