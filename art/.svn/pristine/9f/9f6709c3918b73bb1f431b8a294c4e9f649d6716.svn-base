package com.golead.art.artist.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.artist.model.ArtArtistExhibit;
import com.golead.art.artist.dao.ArtArtistExhibitDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistExhibitDaoImpl extends HibernateDaoImpl<ArtArtistExhibit> implements ArtArtistExhibitDao {

	public Class getReferenceClass() {
		return ArtArtistExhibit.class;
	}

	public ArtArtistExhibit cast(Object object) {
		return (ArtArtistExhibit) object;
	}

	public ArtArtistExhibit get(Serializable id)  throws DAOException{
		return (ArtArtistExhibit) super.get(id);
	}

	public ArtArtistExhibit load(Serializable id)  throws DAOException{
		return (ArtArtistExhibit) super.load(id);
	}

	public Serializable save(ArtArtistExhibit artArtistExhibit)  throws DAOException{
		return super.save(artArtistExhibit);
	}

	public void saveOrUpdate(ArtArtistExhibit artArtistExhibit)  throws DAOException{
		super.saveOrUpdate(artArtistExhibit);
	}

	public void update(ArtArtistExhibit artArtistExhibit)  throws DAOException{
		super.update(artArtistExhibit);
	}

	public void delete(ArtArtistExhibit artArtistExhibit)  throws DAOException{
		super.delete(artArtistExhibit);
	}

	public void refresh(ArtArtistExhibit artArtistExhibit)  throws DAOException{
		super.refresh(artArtistExhibit);
	}

	public String getTableName() {
		return ArtArtistExhibit.REF_TABLE;
	}
}
