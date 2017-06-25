package com.golead.art.literature.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.literature.model.ArtLiteratureMediumResearch;
import com.golead.art.literature.dao.ArtLiteratureMediumResearchDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtLiteratureMediumResearchDaoImpl extends HibernateDaoImpl<ArtLiteratureMediumResearch> implements ArtLiteratureMediumResearchDao {

	public Class getReferenceClass() {
		return ArtLiteratureMediumResearch.class;
	}

	public ArtLiteratureMediumResearch cast(Object object) {
		return (ArtLiteratureMediumResearch) object;
	}

	public ArtLiteratureMediumResearch get(Serializable id)  throws DAOException{
		return (ArtLiteratureMediumResearch) super.get(id);
	}

	public ArtLiteratureMediumResearch load(Serializable id)  throws DAOException{
		return (ArtLiteratureMediumResearch) super.load(id);
	}

	public Serializable save(ArtLiteratureMediumResearch artLiteratureMediumResearch)  throws DAOException{
		return super.save(artLiteratureMediumResearch);
	}

	public void saveOrUpdate(ArtLiteratureMediumResearch artLiteratureMediumResearch)  throws DAOException{
		super.saveOrUpdate(artLiteratureMediumResearch);
	}

	public void update(ArtLiteratureMediumResearch artLiteratureMediumResearch)  throws DAOException{
		super.update(artLiteratureMediumResearch);
	}

	public void delete(ArtLiteratureMediumResearch artLiteratureMediumResearch)  throws DAOException{
		super.delete(artLiteratureMediumResearch);
	}

	public void refresh(ArtLiteratureMediumResearch artLiteratureMediumResearch)  throws DAOException{
		super.refresh(artLiteratureMediumResearch);
	}

	public String getTableName() {
		return ArtLiteratureMediumResearch.REF_TABLE;
	}
}
