package com.golead.art.literature.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.literature.model.ArtLiteratureMedium;
import com.golead.art.literature.dao.ArtLiteratureMediumDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtLiteratureMediumDaoImpl extends HibernateDaoImpl<ArtLiteratureMedium> implements ArtLiteratureMediumDao {

	public Class getReferenceClass() {
		return ArtLiteratureMedium.class;
	}

	public ArtLiteratureMedium cast(Object object) {
		return (ArtLiteratureMedium) object;
	}

	public ArtLiteratureMedium get(Serializable id)  throws DAOException{
		return (ArtLiteratureMedium) super.get(id);
	}

	public ArtLiteratureMedium load(Serializable id)  throws DAOException{
		return (ArtLiteratureMedium) super.load(id);
	}

	public Serializable save(ArtLiteratureMedium artLiteratureMedium)  throws DAOException{
		return super.save(artLiteratureMedium);
	}

	public void saveOrUpdate(ArtLiteratureMedium artLiteratureMedium)  throws DAOException{
		super.saveOrUpdate(artLiteratureMedium);
	}

	public void update(ArtLiteratureMedium artLiteratureMedium)  throws DAOException{
		super.update(artLiteratureMedium);
	}

	public void delete(ArtLiteratureMedium artLiteratureMedium)  throws DAOException{
		super.delete(artLiteratureMedium);
	}

	public void refresh(ArtLiteratureMedium artLiteratureMedium)  throws DAOException{
		super.refresh(artLiteratureMedium);
	}

	public String getTableName() {
		return ArtLiteratureMedium.REF_TABLE;
	}
}
