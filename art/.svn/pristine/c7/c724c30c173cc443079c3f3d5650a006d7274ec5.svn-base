package com.golead.art.literature.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.literature.model.ArtLiteratureWords;
import com.golead.art.literature.dao.ArtLiteratureWordsDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtLiteratureWordsDaoImpl extends HibernateDaoImpl<ArtLiteratureWords> implements ArtLiteratureWordsDao {

	public Class getReferenceClass() {
		return ArtLiteratureWords.class;
	}

	public ArtLiteratureWords cast(Object object) {
		return (ArtLiteratureWords) object;
	}

	public ArtLiteratureWords get(Serializable id)  throws DAOException{
		return (ArtLiteratureWords) super.get(id);
	}

	public ArtLiteratureWords load(Serializable id)  throws DAOException{
		return (ArtLiteratureWords) super.load(id);
	}

	public Serializable save(ArtLiteratureWords artLiteratureWords)  throws DAOException{
		return super.save(artLiteratureWords);
	}

	public void saveOrUpdate(ArtLiteratureWords artLiteratureWords)  throws DAOException{
		super.saveOrUpdate(artLiteratureWords);
	}

	public void update(ArtLiteratureWords artLiteratureWords)  throws DAOException{
		super.update(artLiteratureWords);
	}

	public void delete(ArtLiteratureWords artLiteratureWords)  throws DAOException{
		super.delete(artLiteratureWords);
	}

	public void refresh(ArtLiteratureWords artLiteratureWords)  throws DAOException{
		super.refresh(artLiteratureWords);
	}

	public String getTableName() {
		return ArtLiteratureWords.REF_TABLE;
	}
}
