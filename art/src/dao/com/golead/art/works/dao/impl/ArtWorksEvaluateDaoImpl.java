package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksEvaluate;
import com.golead.art.works.dao.ArtWorksEvaluateDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksEvaluateDaoImpl extends HibernateDaoImpl<ArtWorksEvaluate> implements ArtWorksEvaluateDao {

	public Class getReferenceClass() {
		return ArtWorksEvaluate.class;
	}

	public ArtWorksEvaluate cast(Object object) {
		return (ArtWorksEvaluate) object;
	}

	public ArtWorksEvaluate get(Serializable id)  throws DAOException{
		return (ArtWorksEvaluate) super.get(id);
	}

	public ArtWorksEvaluate load(Serializable id)  throws DAOException{
		return (ArtWorksEvaluate) super.load(id);
	}

	public Serializable save(ArtWorksEvaluate artWorksEvaluate)  throws DAOException{
		return super.save(artWorksEvaluate);
	}

	public void saveOrUpdate(ArtWorksEvaluate artWorksEvaluate)  throws DAOException{
		super.saveOrUpdate(artWorksEvaluate);
	}

	public void update(ArtWorksEvaluate artWorksEvaluate)  throws DAOException{
		super.update(artWorksEvaluate);
	}

	public void delete(ArtWorksEvaluate artWorksEvaluate)  throws DAOException{
		super.delete(artWorksEvaluate);
	}

	public void refresh(ArtWorksEvaluate artWorksEvaluate)  throws DAOException{
		super.refresh(artWorksEvaluate);
	}

	public String getTableName() {
		return ArtWorksEvaluate.REF_TABLE;
	}
}
