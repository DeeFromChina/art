package com.golead.art.literature.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.literature.model.ArtLiteratureOther;
import com.golead.art.literature.dao.ArtLiteratureOtherDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtLiteratureOtherDaoImpl extends HibernateDaoImpl<ArtLiteratureOther> implements ArtLiteratureOtherDao {

	public Class getReferenceClass() {
		return ArtLiteratureOther.class;
	}

	public ArtLiteratureOther cast(Object object) {
		return (ArtLiteratureOther) object;
	}

	public ArtLiteratureOther get(Serializable id)  throws DAOException{
		return (ArtLiteratureOther) super.get(id);
	}

	public ArtLiteratureOther load(Serializable id)  throws DAOException{
		return (ArtLiteratureOther) super.load(id);
	}

	public Serializable save(ArtLiteratureOther artLiteratureOther)  throws DAOException{
		return super.save(artLiteratureOther);
	}

	public void saveOrUpdate(ArtLiteratureOther artLiteratureOther)  throws DAOException{
		super.saveOrUpdate(artLiteratureOther);
	}

	public void update(ArtLiteratureOther artLiteratureOther)  throws DAOException{
		super.update(artLiteratureOther);
	}

	public void delete(ArtLiteratureOther artLiteratureOther)  throws DAOException{
		super.delete(artLiteratureOther);
	}

	public void refresh(ArtLiteratureOther artLiteratureOther)  throws DAOException{
		super.refresh(artLiteratureOther);
	}

	public String getTableName() {
		return ArtLiteratureOther.REF_TABLE;
	}
}
