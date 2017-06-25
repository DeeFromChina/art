package com.golead.art.artist.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.artist.model.ArtArtistEdu;
import com.golead.art.artist.dao.ArtArtistEduDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistEduDaoImpl extends HibernateDaoImpl<ArtArtistEdu> implements ArtArtistEduDao {

	public Class getReferenceClass() {
		return ArtArtistEdu.class;
	}

	public ArtArtistEdu cast(Object object) {
		return (ArtArtistEdu) object;
	}

	public ArtArtistEdu get(Serializable id)  throws DAOException{
		return (ArtArtistEdu) super.get(id);
	}

	public ArtArtistEdu load(Serializable id)  throws DAOException{
		return (ArtArtistEdu) super.load(id);
	}

	public Serializable save(ArtArtistEdu artArtistEdu)  throws DAOException{
		return super.save(artArtistEdu);
	}

	public void saveOrUpdate(ArtArtistEdu artArtistEdu)  throws DAOException{
		super.saveOrUpdate(artArtistEdu);
	}

	public void update(ArtArtistEdu artArtistEdu)  throws DAOException{
		super.update(artArtistEdu);
	}

	public void delete(ArtArtistEdu artArtistEdu)  throws DAOException{
		super.delete(artArtistEdu);
	}

	public void refresh(ArtArtistEdu artArtistEdu)  throws DAOException{
		super.refresh(artArtistEdu);
	}

	public String getTableName() {
		return ArtArtistEdu.REF_TABLE;
	}
}
