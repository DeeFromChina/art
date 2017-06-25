package com.golead.art.artist.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.artist.model.ArtArtistCoop;
import com.golead.art.artist.dao.ArtArtistCoopDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistCoopDaoImpl extends HibernateDaoImpl<ArtArtistCoop> implements ArtArtistCoopDao {

	public Class getReferenceClass() {
		return ArtArtistCoop.class;
	}

	public ArtArtistCoop cast(Object object) {
		return (ArtArtistCoop) object;
	}

	public ArtArtistCoop get(Serializable id)  throws DAOException{
		return (ArtArtistCoop) super.get(id);
	}

	public ArtArtistCoop load(Serializable id)  throws DAOException{
		return (ArtArtistCoop) super.load(id);
	}

	public Serializable save(ArtArtistCoop artArtistCoop)  throws DAOException{
		return super.save(artArtistCoop);
	}

	public void saveOrUpdate(ArtArtistCoop artArtistCoop)  throws DAOException{
		super.saveOrUpdate(artArtistCoop);
	}

	public void update(ArtArtistCoop artArtistCoop)  throws DAOException{
		super.update(artArtistCoop);
	}

	public void delete(ArtArtistCoop artArtistCoop)  throws DAOException{
		super.delete(artArtistCoop);
	}

	public void refresh(ArtArtistCoop artArtistCoop)  throws DAOException{
		super.refresh(artArtistCoop);
	}

	public String getTableName() {
		return ArtArtistCoop.REF_TABLE;
	}
}
