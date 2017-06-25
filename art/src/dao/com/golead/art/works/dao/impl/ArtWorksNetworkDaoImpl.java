package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksNetwork;
import com.golead.art.works.dao.ArtWorksNetworkDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksNetworkDaoImpl extends HibernateDaoImpl<ArtWorksNetwork> implements ArtWorksNetworkDao {

	public Class getReferenceClass() {
		return ArtWorksNetwork.class;
	}

	public ArtWorksNetwork cast(Object object) {
		return (ArtWorksNetwork) object;
	}

	public ArtWorksNetwork get(Serializable id)  throws DAOException{
		return (ArtWorksNetwork) super.get(id);
	}

	public ArtWorksNetwork load(Serializable id)  throws DAOException{
		return (ArtWorksNetwork) super.load(id);
	}

	public Serializable save(ArtWorksNetwork artWorksNetwork)  throws DAOException{
		return super.save(artWorksNetwork);
	}

	public void saveOrUpdate(ArtWorksNetwork artWorksNetwork)  throws DAOException{
		super.saveOrUpdate(artWorksNetwork);
	}

	public void update(ArtWorksNetwork artWorksNetwork)  throws DAOException{
		super.update(artWorksNetwork);
	}

	public void delete(ArtWorksNetwork artWorksNetwork)  throws DAOException{
		super.delete(artWorksNetwork);
	}

	public void refresh(ArtWorksNetwork artWorksNetwork)  throws DAOException{
		super.refresh(artWorksNetwork);
	}

	public String getTableName() {
		return ArtWorksNetwork.REF_TABLE;
	}
}
