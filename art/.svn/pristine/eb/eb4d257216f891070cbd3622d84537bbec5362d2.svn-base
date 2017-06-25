package com.golead.art.literature.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.literature.model.ArtLiteratureNetwork;
import com.golead.art.literature.dao.ArtLiteratureNetworkDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtLiteratureNetworkDaoImpl extends HibernateDaoImpl<ArtLiteratureNetwork> implements ArtLiteratureNetworkDao {

	public Class getReferenceClass() {
		return ArtLiteratureNetwork.class;
	}

	public ArtLiteratureNetwork cast(Object object) {
		return (ArtLiteratureNetwork) object;
	}

	public ArtLiteratureNetwork get(Serializable id)  throws DAOException{
		return (ArtLiteratureNetwork) super.get(id);
	}

	public ArtLiteratureNetwork load(Serializable id)  throws DAOException{
		return (ArtLiteratureNetwork) super.load(id);
	}

	public Serializable save(ArtLiteratureNetwork artLiteratureNetwork)  throws DAOException{
		return super.save(artLiteratureNetwork);
	}

	public void saveOrUpdate(ArtLiteratureNetwork artLiteratureNetwork)  throws DAOException{
		super.saveOrUpdate(artLiteratureNetwork);
	}

	public void update(ArtLiteratureNetwork artLiteratureNetwork)  throws DAOException{
		super.update(artLiteratureNetwork);
	}

	public void delete(ArtLiteratureNetwork artLiteratureNetwork)  throws DAOException{
		super.delete(artLiteratureNetwork);
	}

	public void refresh(ArtLiteratureNetwork artLiteratureNetwork)  throws DAOException{
		super.refresh(artLiteratureNetwork);
	}

	public String getTableName() {
		return ArtLiteratureNetwork.REF_TABLE;
	}
}
