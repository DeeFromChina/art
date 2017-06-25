package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksAgency;
import com.golead.art.works.dao.ArtWorksAgencyDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksAgencyDaoImpl extends HibernateDaoImpl<ArtWorksAgency> implements ArtWorksAgencyDao {

	public Class getReferenceClass() {
		return ArtWorksAgency.class;
	}

	public ArtWorksAgency cast(Object object) {
		return (ArtWorksAgency) object;
	}

	public ArtWorksAgency get(Serializable id)  throws DAOException{
		return (ArtWorksAgency) super.get(id);
	}

	public ArtWorksAgency load(Serializable id)  throws DAOException{
		return (ArtWorksAgency) super.load(id);
	}

	public Serializable save(ArtWorksAgency artWorksAgency)  throws DAOException{
		return super.save(artWorksAgency);
	}

	public void saveOrUpdate(ArtWorksAgency artWorksAgency)  throws DAOException{
		super.saveOrUpdate(artWorksAgency);
	}

	public void update(ArtWorksAgency artWorksAgency)  throws DAOException{
		super.update(artWorksAgency);
	}

	public void delete(ArtWorksAgency artWorksAgency)  throws DAOException{
		super.delete(artWorksAgency);
	}

	public void refresh(ArtWorksAgency artWorksAgency)  throws DAOException{
		super.refresh(artWorksAgency);
	}

	public String getTableName() {
		return ArtWorksAgency.REF_TABLE;
	}
}
