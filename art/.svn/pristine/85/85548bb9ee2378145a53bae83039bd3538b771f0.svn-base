package com.golead.art.app.commentary.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.app.commentary.model.ArtCommentary;
import com.golead.art.app.commentary.dao.ArtCommentaryDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtCommentaryDaoImpl extends HibernateDaoImpl<ArtCommentary> implements ArtCommentaryDao {

	public Class getReferenceClass() {
		return ArtCommentary.class;
	}

	public ArtCommentary cast(Object object) {
		return (ArtCommentary) object;
	}

	public ArtCommentary get(Serializable id)  throws DAOException{
		return (ArtCommentary) super.get(id);
	}

	public ArtCommentary load(Serializable id)  throws DAOException{
		return (ArtCommentary) super.load(id);
	}

	public Serializable save(ArtCommentary artCommentary)  throws DAOException{
		return super.save(artCommentary);
	}

	public void saveOrUpdate(ArtCommentary artCommentary)  throws DAOException{
		super.saveOrUpdate(artCommentary);
	}

	public void update(ArtCommentary artCommentary)  throws DAOException{
		super.update(artCommentary);
	}

	public void delete(ArtCommentary artCommentary)  throws DAOException{
		super.delete(artCommentary);
	}

	public void refresh(ArtCommentary artCommentary)  throws DAOException{
		super.refresh(artCommentary);
	}

	public String getTableName() {
		return ArtCommentary.REF_TABLE;
	}
}
