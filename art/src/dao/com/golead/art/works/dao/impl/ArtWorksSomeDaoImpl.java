package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksSome;
import com.golead.art.works.dao.ArtWorksSomeDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksSomeDaoImpl extends HibernateDaoImpl<ArtWorksSome> implements ArtWorksSomeDao {

	public Class getReferenceClass() {
		return ArtWorksSome.class;
	}

	public ArtWorksSome cast(Object object) {
		return (ArtWorksSome) object;
	}

	public ArtWorksSome get(Serializable id)  throws DAOException{
		return (ArtWorksSome) super.get(id);
	}

	public ArtWorksSome load(Serializable id)  throws DAOException{
		return (ArtWorksSome) super.load(id);
	}

	public Serializable save(ArtWorksSome artWorksSome)  throws DAOException{
		return super.save(artWorksSome);
	}

	public void saveOrUpdate(ArtWorksSome artWorksSome)  throws DAOException{
		super.saveOrUpdate(artWorksSome);
	}

	public void update(ArtWorksSome artWorksSome)  throws DAOException{
		super.update(artWorksSome);
	}

	public void delete(ArtWorksSome artWorksSome)  throws DAOException{
		super.delete(artWorksSome);
	}

	public void refresh(ArtWorksSome artWorksSome)  throws DAOException{
		super.refresh(artWorksSome);
	}

	public String getTableName() {
		return ArtWorksSome.REF_TABLE;
	}
}
