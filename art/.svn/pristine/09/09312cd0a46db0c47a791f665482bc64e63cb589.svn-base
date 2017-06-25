package com.golead.art.publication.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.publication.model.ArtPublication;
import com.golead.art.publication.dao.ArtPublicationDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtPublicationDaoImpl extends HibernateDaoImpl<ArtPublication> implements ArtPublicationDao {

	public Class getReferenceClass() {
		return ArtPublication.class;
	}

	public ArtPublication cast(Object object) {
		return (ArtPublication) object;
	}

	public ArtPublication get(Serializable id)  throws DAOException{
		return (ArtPublication) super.get(id);
	}

	public ArtPublication load(Serializable id)  throws DAOException{
		return (ArtPublication) super.load(id);
	}

	public Serializable save(ArtPublication artPublication)  throws DAOException{
		return super.save(artPublication);
	}

	public void saveOrUpdate(ArtPublication artPublication)  throws DAOException{
		super.saveOrUpdate(artPublication);
	}

	public void update(ArtPublication artPublication)  throws DAOException{
		super.update(artPublication);
	}

	public void delete(ArtPublication artPublication)  throws DAOException{
		super.delete(artPublication);
	}

	public void refresh(ArtPublication artPublication)  throws DAOException{
		super.refresh(artPublication);
	}

	public String getTableName() {
		return ArtPublication.REF_TABLE;
	}
}
