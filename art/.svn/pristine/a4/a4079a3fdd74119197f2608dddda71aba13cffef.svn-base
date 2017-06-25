package com.golead.art.activity.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.activity.model.ArtActivityExhibit;
import com.golead.art.activity.dao.ArtActivityExhibitDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtActivityExhibitDaoImpl extends HibernateDaoImpl<ArtActivityExhibit> implements ArtActivityExhibitDao {

	public Class getReferenceClass() {
		return ArtActivityExhibit.class;
	}

	public ArtActivityExhibit cast(Object object) {
		return (ArtActivityExhibit) object;
	}

	public ArtActivityExhibit get(Serializable id)  throws DAOException{
		return (ArtActivityExhibit) super.get(id);
	}

	public ArtActivityExhibit load(Serializable id)  throws DAOException{
		return (ArtActivityExhibit) super.load(id);
	}

	public Serializable save(ArtActivityExhibit artActivityExhibit)  throws DAOException{
		return super.save(artActivityExhibit);
	}

	public void saveOrUpdate(ArtActivityExhibit artActivityExhibit)  throws DAOException{
		super.saveOrUpdate(artActivityExhibit);
	}

	public void update(ArtActivityExhibit artActivityExhibit)  throws DAOException{
		super.update(artActivityExhibit);
	}

	public void delete(ArtActivityExhibit artActivityExhibit)  throws DAOException{
		super.delete(artActivityExhibit);
	}

	public void refresh(ArtActivityExhibit artActivityExhibit)  throws DAOException{
		super.refresh(artActivityExhibit);
	}

	public String getTableName() {
		return ArtActivityExhibit.REF_TABLE;
	}
}
