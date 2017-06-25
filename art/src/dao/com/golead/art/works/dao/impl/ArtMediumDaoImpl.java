package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtMedium;
import com.golead.art.works.dao.ArtMediumDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtMediumDaoImpl extends HibernateDaoImpl<ArtMedium> implements ArtMediumDao {

	public Class getReferenceClass() {
		return ArtMedium.class;
	}

	public ArtMedium cast(Object object) {
		return (ArtMedium) object;
	}

	public ArtMedium get(Serializable id)  throws DAOException{
		return (ArtMedium) super.get(id);
	}

	public ArtMedium load(Serializable id)  throws DAOException{
		return (ArtMedium) super.load(id);
	}

	public Serializable save(ArtMedium artMedium)  throws DAOException{
		return super.save(artMedium);
	}

	public void saveOrUpdate(ArtMedium artMedium)  throws DAOException{
		super.saveOrUpdate(artMedium);
	}

	public void update(ArtMedium artMedium)  throws DAOException{
		super.update(artMedium);
	}

	public void delete(ArtMedium artMedium)  throws DAOException{
		super.delete(artMedium);
	}

	public void refresh(ArtMedium artMedium)  throws DAOException{
		super.refresh(artMedium);
	}

	public String getTableName() {
		return ArtMedium.REF_TABLE;
	}
}
