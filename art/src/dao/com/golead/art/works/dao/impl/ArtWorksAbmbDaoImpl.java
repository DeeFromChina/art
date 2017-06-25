package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksAbmb;
import com.golead.art.works.dao.ArtWorksAbmbDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksAbmbDaoImpl extends HibernateDaoImpl<ArtWorksAbmb> implements ArtWorksAbmbDao {

	public Class getReferenceClass() {
		return ArtWorksAbmb.class;
	}

	public ArtWorksAbmb cast(Object object) {
		return (ArtWorksAbmb) object;
	}

	public ArtWorksAbmb get(Serializable id)  throws DAOException{
		return (ArtWorksAbmb) super.get(id);
	}

	public ArtWorksAbmb load(Serializable id)  throws DAOException{
		return (ArtWorksAbmb) super.load(id);
	}

	public Serializable save(ArtWorksAbmb artWorksAbmb)  throws DAOException{
		return super.save(artWorksAbmb);
	}

	public void saveOrUpdate(ArtWorksAbmb artWorksAbmb)  throws DAOException{
		super.saveOrUpdate(artWorksAbmb);
	}

	public void update(ArtWorksAbmb artWorksAbmb)  throws DAOException{
		super.update(artWorksAbmb);
	}

	public void delete(ArtWorksAbmb artWorksAbmb)  throws DAOException{
		super.delete(artWorksAbmb);
	}

	public void refresh(ArtWorksAbmb artWorksAbmb)  throws DAOException{
		super.refresh(artWorksAbmb);
	}

	public String getTableName() {
		return ArtWorksAbmb.REF_TABLE;
	}
}
