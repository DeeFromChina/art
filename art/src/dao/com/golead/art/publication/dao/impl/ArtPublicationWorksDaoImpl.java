package com.golead.art.publication.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.publication.model.ArtPublicationWorks;
import com.golead.art.publication.dao.ArtPublicationWorksDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtPublicationWorksDaoImpl extends HibernateDaoImpl<ArtPublicationWorks> implements ArtPublicationWorksDao {

	public Class getReferenceClass() {
		return ArtPublicationWorks.class;
	}

	public ArtPublicationWorks cast(Object object) {
		return (ArtPublicationWorks) object;
	}

	public ArtPublicationWorks get(Serializable id)  throws DAOException{
		return (ArtPublicationWorks) super.get(id);
	}

	public ArtPublicationWorks load(Serializable id)  throws DAOException{
		return (ArtPublicationWorks) super.load(id);
	}

	public Serializable save(ArtPublicationWorks artPublicationWorks)  throws DAOException{
		return super.save(artPublicationWorks);
	}

	public void saveOrUpdate(ArtPublicationWorks artPublicationWorks)  throws DAOException{
		super.saveOrUpdate(artPublicationWorks);
	}

	public void update(ArtPublicationWorks artPublicationWorks)  throws DAOException{
		super.update(artPublicationWorks);
	}

	public void delete(ArtPublicationWorks artPublicationWorks)  throws DAOException{
		super.delete(artPublicationWorks);
	}

	public void refresh(ArtPublicationWorks artPublicationWorks)  throws DAOException{
		super.refresh(artPublicationWorks);
	}

	public String getTableName() {
		return ArtPublicationWorks.REF_TABLE;
	}
}
