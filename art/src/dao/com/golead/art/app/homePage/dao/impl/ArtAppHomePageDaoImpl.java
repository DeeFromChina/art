package com.golead.art.app.homePage.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.app.homePage.model.ArtAppHomePage;
import com.golead.art.app.homePage.dao.ArtAppHomePageDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtAppHomePageDaoImpl extends HibernateDaoImpl<ArtAppHomePage> implements ArtAppHomePageDao {

	public Class getReferenceClass() {
		return ArtAppHomePage.class;
	}

	public ArtAppHomePage cast(Object object) {
		return (ArtAppHomePage) object;
	}

	public ArtAppHomePage get(Serializable id)  throws DAOException{
		return (ArtAppHomePage) super.get(id);
	}

	public ArtAppHomePage load(Serializable id)  throws DAOException{
		return (ArtAppHomePage) super.load(id);
	}

	public Serializable save(ArtAppHomePage artAppHomePage)  throws DAOException{
		return super.save(artAppHomePage);
	}

	public void saveOrUpdate(ArtAppHomePage artAppHomePage)  throws DAOException{
		super.saveOrUpdate(artAppHomePage);
	}

	public void update(ArtAppHomePage artAppHomePage)  throws DAOException{
		super.update(artAppHomePage);
	}

	public void delete(ArtAppHomePage artAppHomePage)  throws DAOException{
		super.delete(artAppHomePage);
	}

	public void refresh(ArtAppHomePage artAppHomePage)  throws DAOException{
		super.refresh(artAppHomePage);
	}

	public String getTableName() {
		return ArtAppHomePage.REF_TABLE;
	}
}
