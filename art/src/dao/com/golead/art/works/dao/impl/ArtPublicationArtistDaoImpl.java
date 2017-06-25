package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtPublicationArtist;
import com.golead.art.works.dao.ArtPublicationArtistDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtPublicationArtistDaoImpl extends HibernateDaoImpl<ArtPublicationArtist> implements ArtPublicationArtistDao {

	public Class getReferenceClass() {
		return ArtPublicationArtist.class;
	}

	public ArtPublicationArtist cast(Object object) {
		return (ArtPublicationArtist) object;
	}

	public ArtPublicationArtist get(Serializable id)  throws DAOException{
		return (ArtPublicationArtist) super.get(id);
	}

	public ArtPublicationArtist load(Serializable id)  throws DAOException{
		return (ArtPublicationArtist) super.load(id);
	}

	public Serializable save(ArtPublicationArtist artPublicationArtist)  throws DAOException{
		return super.save(artPublicationArtist);
	}

	public void saveOrUpdate(ArtPublicationArtist artPublicationArtist)  throws DAOException{
		super.saveOrUpdate(artPublicationArtist);
	}

	public void update(ArtPublicationArtist artPublicationArtist)  throws DAOException{
		super.update(artPublicationArtist);
	}

	public void delete(ArtPublicationArtist artPublicationArtist)  throws DAOException{
		super.delete(artPublicationArtist);
	}

	public void refresh(ArtPublicationArtist artPublicationArtist)  throws DAOException{
		super.refresh(artPublicationArtist);
	}

	public String getTableName() {
		return ArtPublicationArtist.REF_TABLE;
	}
}
