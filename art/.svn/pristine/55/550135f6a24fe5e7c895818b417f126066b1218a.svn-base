package com.golead.art.activity.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.activity.model.ArtActivityAbmb;
import com.golead.art.activity.dao.ArtActivityAbmbDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtActivityAbmbDaoImpl extends HibernateDaoImpl<ArtActivityAbmb> implements ArtActivityAbmbDao {

	public Class getReferenceClass() {
		return ArtActivityAbmb.class;
	}

	public ArtActivityAbmb cast(Object object) {
		return (ArtActivityAbmb) object;
	}

	public ArtActivityAbmb get(Serializable id)  throws DAOException{
		return (ArtActivityAbmb) super.get(id);
	}

	public ArtActivityAbmb load(Serializable id)  throws DAOException{
		return (ArtActivityAbmb) super.load(id);
	}

	public Serializable save(ArtActivityAbmb artActivityAbmb)  throws DAOException{
		return super.save(artActivityAbmb);
	}

	public void saveOrUpdate(ArtActivityAbmb artActivityAbmb)  throws DAOException{
		super.saveOrUpdate(artActivityAbmb);
	}

	public void update(ArtActivityAbmb artActivityAbmb)  throws DAOException{
		super.update(artActivityAbmb);
	}

	public void delete(ArtActivityAbmb artActivityAbmb)  throws DAOException{
		super.delete(artActivityAbmb);
	}

	public void refresh(ArtActivityAbmb artActivityAbmb)  throws DAOException{
		super.refresh(artActivityAbmb);
	}

	public String getTableName() {
		return ArtActivityAbmb.REF_TABLE;
	}
}
