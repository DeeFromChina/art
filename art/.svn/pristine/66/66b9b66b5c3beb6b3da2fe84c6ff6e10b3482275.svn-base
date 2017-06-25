package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksExhibit;
import com.golead.art.works.dao.ArtWorksExhibitDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksExhibitDaoImpl extends HibernateDaoImpl<ArtWorksExhibit> implements ArtWorksExhibitDao {

	public Class getReferenceClass() {
		return ArtWorksExhibit.class;
	}

	public ArtWorksExhibit cast(Object object) {
		return (ArtWorksExhibit) object;
	}

	public ArtWorksExhibit get(Serializable id)  throws DAOException{
		return (ArtWorksExhibit) super.get(id);
	}

	public ArtWorksExhibit load(Serializable id)  throws DAOException{
		return (ArtWorksExhibit) super.load(id);
	}

	public Serializable save(ArtWorksExhibit artWorksExhibit)  throws DAOException{
		return super.save(artWorksExhibit);
	}

	public void saveOrUpdate(ArtWorksExhibit artWorksExhibit)  throws DAOException{
		super.saveOrUpdate(artWorksExhibit);
	}

	public void update(ArtWorksExhibit artWorksExhibit)  throws DAOException{
		super.update(artWorksExhibit);
	}

	public void delete(ArtWorksExhibit artWorksExhibit)  throws DAOException{
		super.delete(artWorksExhibit);
	}

	public void refresh(ArtWorksExhibit artWorksExhibit)  throws DAOException{
		super.refresh(artWorksExhibit);
	}

	public String getTableName() {
		return ArtWorksExhibit.REF_TABLE;
	}
}
