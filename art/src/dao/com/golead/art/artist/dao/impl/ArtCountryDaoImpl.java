package com.golead.art.artist.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.artist.model.ArtCountry;
import com.golead.art.artist.dao.ArtCountryDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtCountryDaoImpl extends HibernateDaoImpl<ArtCountry> implements ArtCountryDao {

	public Class getReferenceClass() {
		return ArtCountry.class;
	}

	public ArtCountry cast(Object object) {
		return (ArtCountry) object;
	}

	public ArtCountry get(Serializable id)  throws DAOException{
		return (ArtCountry) super.get(id);
	}

	public ArtCountry load(Serializable id)  throws DAOException{
		return (ArtCountry) super.load(id);
	}

	public Serializable save(ArtCountry artCountry)  throws DAOException{
		return super.save(artCountry);
	}

	public void saveOrUpdate(ArtCountry artCountry)  throws DAOException{
		super.saveOrUpdate(artCountry);
	}

	public void update(ArtCountry artCountry)  throws DAOException{
		super.update(artCountry);
	}

	public void delete(ArtCountry artCountry)  throws DAOException{
		super.delete(artCountry);
	}

	public void refresh(ArtCountry artCountry)  throws DAOException{
		super.refresh(artCountry);
	}

	public String getTableName() {
		return ArtCountry.REF_TABLE;
	}
}
