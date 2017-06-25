package com.golead.art.activity.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.activity.model.ArtAgency;
import com.golead.art.activity.dao.ArtAgencyDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtAgencyDaoImpl extends HibernateDaoImpl<ArtAgency> implements ArtAgencyDao {

	public Class getReferenceClass() {
		return ArtAgency.class;
	}

	public ArtAgency cast(Object object) {
		return (ArtAgency) object;
	}

	public ArtAgency get(Serializable id)  throws DAOException{
		return (ArtAgency) super.get(id);
	}

	public ArtAgency load(Serializable id)  throws DAOException{
		return (ArtAgency) super.load(id);
	}

	public Serializable save(ArtAgency artAgency)  throws DAOException{
		return super.save(artAgency);
	}

	public void saveOrUpdate(ArtAgency artAgency)  throws DAOException{
		super.saveOrUpdate(artAgency);
	}

	public void update(ArtAgency artAgency)  throws DAOException{
		super.update(artAgency);
	}

	public void delete(ArtAgency artAgency)  throws DAOException{
		super.delete(artAgency);
	}

	public void refresh(ArtAgency artAgency)  throws DAOException{
		super.refresh(artAgency);
	}

	public String getTableName() {
		return ArtAgency.REF_TABLE;
	}
}
