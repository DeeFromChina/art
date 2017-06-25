package com.golead.art.app.artistPage.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.app.artistPage.model.ArtArtistPage;
import com.golead.art.app.artistPage.dao.ArtArtistPageDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistPageDaoImpl extends HibernateDaoImpl<ArtArtistPage> implements ArtArtistPageDao {

	public Class getReferenceClass() {
		return ArtArtistPage.class;
	}

	public ArtArtistPage cast(Object object) {
		return (ArtArtistPage) object;
	}

	public ArtArtistPage get(Serializable id)  throws DAOException{
		return (ArtArtistPage) super.get(id);
	}

	public ArtArtistPage load(Serializable id)  throws DAOException{
		return (ArtArtistPage) super.load(id);
	}

	public Serializable save(ArtArtistPage artArtistPage)  throws DAOException{
		return super.save(artArtistPage);
	}

	public void saveOrUpdate(ArtArtistPage artArtistPage)  throws DAOException{
		super.saveOrUpdate(artArtistPage);
	}

	public void update(ArtArtistPage artArtistPage)  throws DAOException{
		super.update(artArtistPage);
	}

	public void delete(ArtArtistPage artArtistPage)  throws DAOException{
		super.delete(artArtistPage);
	}

	public void refresh(ArtArtistPage artArtistPage)  throws DAOException{
		super.refresh(artArtistPage);
	}

	public String getTableName() {
		return ArtArtistPage.REF_TABLE;
	}
}
