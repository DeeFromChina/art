package com.golead.art.publication.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.publication.model.ArtPublicationAgency;
import com.golead.art.publication.dao.ArtPublicationAgencyDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtPublicationAgencyDaoImpl extends HibernateDaoImpl<ArtPublicationAgency> implements ArtPublicationAgencyDao {

	public Class getReferenceClass() {
		return ArtPublicationAgency.class;
	}

	public ArtPublicationAgency cast(Object object) {
		return (ArtPublicationAgency) object;
	}

	public ArtPublicationAgency get(Serializable id)  throws DAOException{
		return (ArtPublicationAgency) super.get(id);
	}

	public ArtPublicationAgency load(Serializable id)  throws DAOException{
		return (ArtPublicationAgency) super.load(id);
	}

	public Serializable save(ArtPublicationAgency artPublicationAgency)  throws DAOException{
		return super.save(artPublicationAgency);
	}

	public void saveOrUpdate(ArtPublicationAgency artPublicationAgency)  throws DAOException{
		super.saveOrUpdate(artPublicationAgency);
	}

	public void update(ArtPublicationAgency artPublicationAgency)  throws DAOException{
		super.update(artPublicationAgency);
	}

	public void delete(ArtPublicationAgency artPublicationAgency)  throws DAOException{
		super.delete(artPublicationAgency);
	}

	public void refresh(ArtPublicationAgency artPublicationAgency)  throws DAOException{
		super.refresh(artPublicationAgency);
	}

	public String getTableName() {
		return ArtPublicationAgency.REF_TABLE;
	}
}
