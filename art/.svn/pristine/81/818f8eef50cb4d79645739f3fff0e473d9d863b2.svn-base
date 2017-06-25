package com.golead.art.artist.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.artist.model.ArtArtistExperience;
import com.golead.art.artist.dao.ArtArtistExperienceDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistExperienceDaoImpl extends HibernateDaoImpl<ArtArtistExperience> implements ArtArtistExperienceDao {

	public Class getReferenceClass() {
		return ArtArtistExperience.class;
	}

	public ArtArtistExperience cast(Object object) {
		return (ArtArtistExperience) object;
	}

	public ArtArtistExperience get(Serializable id)  throws DAOException{
		return (ArtArtistExperience) super.get(id);
	}

	public ArtArtistExperience load(Serializable id)  throws DAOException{
		return (ArtArtistExperience) super.load(id);
	}

	public Serializable save(ArtArtistExperience artArtistExperience)  throws DAOException{
		return super.save(artArtistExperience);
	}

	public void saveOrUpdate(ArtArtistExperience artArtistExperience)  throws DAOException{
		super.saveOrUpdate(artArtistExperience);
	}

	public void update(ArtArtistExperience artArtistExperience)  throws DAOException{
		super.update(artArtistExperience);
	}

	public void delete(ArtArtistExperience artArtistExperience)  throws DAOException{
		super.delete(artArtistExperience);
	}

	public void refresh(ArtArtistExperience artArtistExperience)  throws DAOException{
		super.refresh(artArtistExperience);
	}

	public String getTableName() {
		return ArtArtistExperience.REF_TABLE;
	}
}
