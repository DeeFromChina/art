package com.golead.art.app.appUser.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.app.appUser.model.ArtAppUser;
import com.golead.art.app.appUser.dao.ArtAppUserDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtAppUserDaoImpl extends HibernateDaoImpl<ArtAppUser> implements ArtAppUserDao {

	public Class getReferenceClass() {
		return ArtAppUser.class;
	}

	public ArtAppUser cast(Object object) {
		return (ArtAppUser) object;
	}

	public ArtAppUser get(Serializable id)  throws DAOException{
		return (ArtAppUser) super.get(id);
	}

	public ArtAppUser load(Serializable id)  throws DAOException{
		return (ArtAppUser) super.load(id);
	}

	public Serializable save(ArtAppUser artAppUser)  throws DAOException{
		return super.save(artAppUser);
	}

	public void saveOrUpdate(ArtAppUser artAppUser)  throws DAOException{
		super.saveOrUpdate(artAppUser);
	}

	public void update(ArtAppUser artAppUser)  throws DAOException{
		super.update(artAppUser);
	}

	public void delete(ArtAppUser artAppUser)  throws DAOException{
		super.delete(artAppUser);
	}

	public void refresh(ArtAppUser artAppUser)  throws DAOException{
		super.refresh(artAppUser);
	}

	public String getTableName() {
		return ArtAppUser.REF_TABLE;
	}
}
