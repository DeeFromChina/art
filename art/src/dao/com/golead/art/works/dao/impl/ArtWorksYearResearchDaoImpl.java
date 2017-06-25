package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksYearResearch;
import com.golead.art.works.dao.ArtWorksYearResearchDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksYearResearchDaoImpl extends HibernateDaoImpl<ArtWorksYearResearch> implements ArtWorksYearResearchDao {

	public Class getReferenceClass() {
		return ArtWorksYearResearch.class;
	}

	public ArtWorksYearResearch cast(Object object) {
		return (ArtWorksYearResearch) object;
	}

	public ArtWorksYearResearch get(Serializable id)  throws DAOException{
		return (ArtWorksYearResearch) super.get(id);
	}

	public ArtWorksYearResearch load(Serializable id)  throws DAOException{
		return (ArtWorksYearResearch) super.load(id);
	}

	public Serializable save(ArtWorksYearResearch artWorksYearResearch)  throws DAOException{
		return super.save(artWorksYearResearch);
	}

	public void saveOrUpdate(ArtWorksYearResearch artWorksYearResearch)  throws DAOException{
		super.saveOrUpdate(artWorksYearResearch);
	}

	public void update(ArtWorksYearResearch artWorksYearResearch)  throws DAOException{
		super.update(artWorksYearResearch);
	}

	public void delete(ArtWorksYearResearch artWorksYearResearch)  throws DAOException{
		super.delete(artWorksYearResearch);
	}

	public void refresh(ArtWorksYearResearch artWorksYearResearch)  throws DAOException{
		super.refresh(artWorksYearResearch);
	}

	public String getTableName() {
		return ArtWorksYearResearch.REF_TABLE;
	}
}
