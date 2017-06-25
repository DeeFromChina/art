package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksMedium;
import com.golead.art.works.dao.ArtWorksMediumDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksMediumDaoImpl extends HibernateDaoImpl<ArtWorksMedium> implements ArtWorksMediumDao {

	public Class getReferenceClass() {
		return ArtWorksMedium.class;
	}

	public ArtWorksMedium cast(Object object) {
		return (ArtWorksMedium) object;
	}

	public ArtWorksMedium get(Serializable id)  throws DAOException{
		return (ArtWorksMedium) super.get(id);
	}

	public ArtWorksMedium load(Serializable id)  throws DAOException{
		return (ArtWorksMedium) super.load(id);
	}

	public Serializable save(ArtWorksMedium artWorksMedium)  throws DAOException{
		return super.save(artWorksMedium);
	}

	public void saveOrUpdate(ArtWorksMedium artWorksMedium)  throws DAOException{
		super.saveOrUpdate(artWorksMedium);
	}

	public void update(ArtWorksMedium artWorksMedium)  throws DAOException{
		super.update(artWorksMedium);
	}

	public void delete(ArtWorksMedium artWorksMedium)  throws DAOException{
		super.delete(artWorksMedium);
	}

	public void refresh(ArtWorksMedium artWorksMedium)  throws DAOException{
		super.refresh(artWorksMedium);
	}

	public String getTableName() {
		return ArtWorksMedium.REF_TABLE;
	}
}
