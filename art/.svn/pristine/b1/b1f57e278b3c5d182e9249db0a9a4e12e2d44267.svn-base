package com.golead.art.artist.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.artist.model.ArtCollectArtist;
import com.golead.art.artist.dao.ArtCollectArtistDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtCollectArtistDaoImpl extends HibernateDaoImpl<ArtCollectArtist> implements ArtCollectArtistDao {

	public Class getReferenceClass() {
		return ArtCollectArtist.class;
	}

	public ArtCollectArtist cast(Object object) {
		return (ArtCollectArtist) object;
	}

	public ArtCollectArtist get(Serializable id)  throws DAOException{
		return (ArtCollectArtist) super.get(id);
	}

	public ArtCollectArtist load(Serializable id)  throws DAOException{
		return (ArtCollectArtist) super.load(id);
	}

	public Serializable save(ArtCollectArtist artCollectArtist)  throws DAOException{
		return super.save(artCollectArtist);
	}

	public void saveOrUpdate(ArtCollectArtist artCollectArtist)  throws DAOException{
		super.saveOrUpdate(artCollectArtist);
	}

	public void update(ArtCollectArtist artCollectArtist)  throws DAOException{
		super.update(artCollectArtist);
	}

	public void delete(ArtCollectArtist artCollectArtist)  throws DAOException{
		super.delete(artCollectArtist);
	}

	public void refresh(ArtCollectArtist artCollectArtist)  throws DAOException{
		super.refresh(artCollectArtist);
	}

	public String getTableName() {
		return ArtCollectArtist.REF_TABLE;
	}
}
