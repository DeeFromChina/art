package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorks;
import com.golead.art.works.dao.ArtWorksDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksDaoImpl extends HibernateDaoImpl<ArtWorks> implements ArtWorksDao {

	public Class getReferenceClass() {
		return ArtWorks.class;
	}

	public ArtWorks cast(Object object) {
		return (ArtWorks) object;
	}

	public ArtWorks get(Serializable id)  throws DAOException{
		return (ArtWorks) super.get(id);
	}

	public ArtWorks load(Serializable id)  throws DAOException{
		return (ArtWorks) super.load(id);
	}

	public Serializable save(ArtWorks artWorks)  throws DAOException{
		return super.save(artWorks);
	}

	public void saveOrUpdate(ArtWorks artWorks)  throws DAOException{
		super.saveOrUpdate(artWorks);
	}

	public void update(ArtWorks artWorks)  throws DAOException{
		super.update(artWorks);
	}

	public void delete(ArtWorks artWorks)  throws DAOException{
		super.delete(artWorks);
	}

	public void refresh(ArtWorks artWorks)  throws DAOException{
		super.refresh(artWorks);
	}

	public String getTableName() {
		return ArtWorks.REF_TABLE;
	}
}
