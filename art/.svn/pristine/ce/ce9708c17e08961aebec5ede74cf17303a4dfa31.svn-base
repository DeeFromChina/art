package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksFollow;
import com.golead.art.works.dao.ArtWorksFollowDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksFollowDaoImpl extends HibernateDaoImpl<ArtWorksFollow> implements ArtWorksFollowDao {

	public Class getReferenceClass() {
		return ArtWorksFollow.class;
	}

	public ArtWorksFollow cast(Object object) {
		return (ArtWorksFollow) object;
	}

	public ArtWorksFollow get(Serializable id)  throws DAOException{
		return (ArtWorksFollow) super.get(id);
	}

	public ArtWorksFollow load(Serializable id)  throws DAOException{
		return (ArtWorksFollow) super.load(id);
	}

	public Serializable save(ArtWorksFollow artWorksFollow)  throws DAOException{
		return super.save(artWorksFollow);
	}

	public void saveOrUpdate(ArtWorksFollow artWorksFollow)  throws DAOException{
		super.saveOrUpdate(artWorksFollow);
	}

	public void update(ArtWorksFollow artWorksFollow)  throws DAOException{
		super.update(artWorksFollow);
	}

	public void delete(ArtWorksFollow artWorksFollow)  throws DAOException{
		super.delete(artWorksFollow);
	}

	public void refresh(ArtWorksFollow artWorksFollow)  throws DAOException{
		super.refresh(artWorksFollow);
	}

	public String getTableName() {
		return ArtWorksFollow.REF_TABLE;
	}
}
