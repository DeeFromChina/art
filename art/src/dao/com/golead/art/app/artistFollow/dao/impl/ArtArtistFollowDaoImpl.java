package com.golead.art.app.artistFollow.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.app.artistFollow.model.ArtArtistFollow;
import com.golead.art.app.artistFollow.dao.ArtArtistFollowDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistFollowDaoImpl extends HibernateDaoImpl<ArtArtistFollow> implements ArtArtistFollowDao {

	public Class getReferenceClass() {
		return ArtArtistFollow.class;
	}

	public ArtArtistFollow cast(Object object) {
		return (ArtArtistFollow) object;
	}

	public ArtArtistFollow get(Serializable id)  throws DAOException{
		return (ArtArtistFollow) super.get(id);
	}

	public ArtArtistFollow load(Serializable id)  throws DAOException{
		return (ArtArtistFollow) super.load(id);
	}

	public Serializable save(ArtArtistFollow artArtistFollow)  throws DAOException{
		return super.save(artArtistFollow);
	}

	public void saveOrUpdate(ArtArtistFollow artArtistFollow)  throws DAOException{
		super.saveOrUpdate(artArtistFollow);
	}

	public void update(ArtArtistFollow artArtistFollow)  throws DAOException{
		super.update(artArtistFollow);
	}

	public void delete(ArtArtistFollow artArtistFollow)  throws DAOException{
		super.delete(artArtistFollow);
	}

	public void refresh(ArtArtistFollow artArtistFollow)  throws DAOException{
		super.refresh(artArtistFollow);
	}

	public String getTableName() {
		return ArtArtistFollow.REF_TABLE;
	}
}
