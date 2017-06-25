package com.golead.art.activity.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.activity.model.ArtActivityExhibitArtist;
import com.golead.art.activity.dao.ArtActivityExhibitArtistDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtActivityExhibitArtistDaoImpl extends HibernateDaoImpl<ArtActivityExhibitArtist> implements ArtActivityExhibitArtistDao {

	public Class getReferenceClass() {
		return ArtActivityExhibitArtist.class;
	}

	public ArtActivityExhibitArtist cast(Object object) {
		return (ArtActivityExhibitArtist) object;
	}

	public ArtActivityExhibitArtist get(Serializable id)  throws DAOException{
		return (ArtActivityExhibitArtist) super.get(id);
	}

	public ArtActivityExhibitArtist load(Serializable id)  throws DAOException{
		return (ArtActivityExhibitArtist) super.load(id);
	}

	public Serializable save(ArtActivityExhibitArtist artActivityExhibitArtist)  throws DAOException{
		return super.save(artActivityExhibitArtist);
	}

	public void saveOrUpdate(ArtActivityExhibitArtist artActivityExhibitArtist)  throws DAOException{
		super.saveOrUpdate(artActivityExhibitArtist);
	}

	public void update(ArtActivityExhibitArtist artActivityExhibitArtist)  throws DAOException{
		super.update(artActivityExhibitArtist);
	}

	public void delete(ArtActivityExhibitArtist artActivityExhibitArtist)  throws DAOException{
		super.delete(artActivityExhibitArtist);
	}

	public void refresh(ArtActivityExhibitArtist artActivityExhibitArtist)  throws DAOException{
		super.refresh(artActivityExhibitArtist);
	}

	public String getTableName() {
		return ArtActivityExhibitArtist.REF_TABLE;
	}
}
