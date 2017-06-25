package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtArtistHeat;
import com.golead.art.works.dao.ArtArtistHeatDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistHeatDaoImpl extends HibernateDaoImpl<ArtArtistHeat> implements ArtArtistHeatDao {

	public Class getReferenceClass() {
		return ArtArtistHeat.class;
	}

	public ArtArtistHeat cast(Object object) {
		return (ArtArtistHeat) object;
	}

	public ArtArtistHeat get(Serializable id)  throws DAOException{
		return (ArtArtistHeat) super.get(id);
	}

	public ArtArtistHeat load(Serializable id)  throws DAOException{
		return (ArtArtistHeat) super.load(id);
	}

	public Serializable save(ArtArtistHeat artArtistHeat)  throws DAOException{
		return super.save(artArtistHeat);
	}

	public void saveOrUpdate(ArtArtistHeat artArtistHeat)  throws DAOException{
		super.saveOrUpdate(artArtistHeat);
	}

	public void update(ArtArtistHeat artArtistHeat)  throws DAOException{
		super.update(artArtistHeat);
	}

	public void delete(ArtArtistHeat artArtistHeat)  throws DAOException{
		super.delete(artArtistHeat);
	}

	public void refresh(ArtArtistHeat artArtistHeat)  throws DAOException{
		super.refresh(artArtistHeat);
	}

	public String getTableName() {
		return ArtArtistHeat.REF_TABLE;
	}
}
