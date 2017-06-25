package com.golead.art.publication.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.publication.model.ArtPublicationLiterature;
import com.golead.art.publication.dao.ArtPublicationLiteratureDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtPublicationLiteratureDaoImpl extends HibernateDaoImpl<ArtPublicationLiterature> implements ArtPublicationLiteratureDao {

	public Class getReferenceClass() {
		return ArtPublicationLiterature.class;
	}

	public ArtPublicationLiterature cast(Object object) {
		return (ArtPublicationLiterature) object;
	}

	public ArtPublicationLiterature get(Serializable id)  throws DAOException{
		return (ArtPublicationLiterature) super.get(id);
	}

	public ArtPublicationLiterature load(Serializable id)  throws DAOException{
		return (ArtPublicationLiterature) super.load(id);
	}

	public Serializable save(ArtPublicationLiterature artPublicationLiterature)  throws DAOException{
		return super.save(artPublicationLiterature);
	}

	public void saveOrUpdate(ArtPublicationLiterature artPublicationLiterature)  throws DAOException{
		super.saveOrUpdate(artPublicationLiterature);
	}

	public void update(ArtPublicationLiterature artPublicationLiterature)  throws DAOException{
		super.update(artPublicationLiterature);
	}

	public void delete(ArtPublicationLiterature artPublicationLiterature)  throws DAOException{
		super.delete(artPublicationLiterature);
	}

	public void refresh(ArtPublicationLiterature artPublicationLiterature)  throws DAOException{
		super.refresh(artPublicationLiterature);
	}

	public String getTableName() {
		return ArtPublicationLiterature.REF_TABLE;
	}
}
