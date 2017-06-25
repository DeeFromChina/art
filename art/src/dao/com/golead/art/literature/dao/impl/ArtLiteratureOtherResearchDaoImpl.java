package com.golead.art.literature.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.literature.model.ArtLiteratureOtherResearch;
import com.golead.art.literature.dao.ArtLiteratureOtherResearchDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtLiteratureOtherResearchDaoImpl extends HibernateDaoImpl<ArtLiteratureOtherResearch> implements ArtLiteratureOtherResearchDao {

	public Class getReferenceClass() {
		return ArtLiteratureOtherResearch.class;
	}

	public ArtLiteratureOtherResearch cast(Object object) {
		return (ArtLiteratureOtherResearch) object;
	}

	public ArtLiteratureOtherResearch get(Serializable id)  throws DAOException{
		return (ArtLiteratureOtherResearch) super.get(id);
	}

	public ArtLiteratureOtherResearch load(Serializable id)  throws DAOException{
		return (ArtLiteratureOtherResearch) super.load(id);
	}

	public Serializable save(ArtLiteratureOtherResearch artLiteratureOtherResearch)  throws DAOException{
		return super.save(artLiteratureOtherResearch);
	}

	public void saveOrUpdate(ArtLiteratureOtherResearch artLiteratureOtherResearch)  throws DAOException{
		super.saveOrUpdate(artLiteratureOtherResearch);
	}

	public void update(ArtLiteratureOtherResearch artLiteratureOtherResearch)  throws DAOException{
		super.update(artLiteratureOtherResearch);
	}

	public void delete(ArtLiteratureOtherResearch artLiteratureOtherResearch)  throws DAOException{
		super.delete(artLiteratureOtherResearch);
	}

	public void refresh(ArtLiteratureOtherResearch artLiteratureOtherResearch)  throws DAOException{
		super.refresh(artLiteratureOtherResearch);
	}

	public String getTableName() {
		return ArtLiteratureOtherResearch.REF_TABLE;
	}
}
