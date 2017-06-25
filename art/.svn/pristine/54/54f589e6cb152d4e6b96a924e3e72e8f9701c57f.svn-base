package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksWords;
import com.golead.art.works.dao.ArtWorksWordsDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksWordsDaoImpl extends HibernateDaoImpl<ArtWorksWords> implements ArtWorksWordsDao {

	public Class getReferenceClass() {
		return ArtWorksWords.class;
	}

	public ArtWorksWords cast(Object object) {
		return (ArtWorksWords) object;
	}

	public ArtWorksWords get(Serializable id)  throws DAOException{
		return (ArtWorksWords) super.get(id);
	}

	public ArtWorksWords load(Serializable id)  throws DAOException{
		return (ArtWorksWords) super.load(id);
	}

	public Serializable save(ArtWorksWords artWorksWords)  throws DAOException{
		return super.save(artWorksWords);
	}

	public void saveOrUpdate(ArtWorksWords artWorksWords)  throws DAOException{
		super.saveOrUpdate(artWorksWords);
	}

	public void update(ArtWorksWords artWorksWords)  throws DAOException{
		super.update(artWorksWords);
	}

	public void delete(ArtWorksWords artWorksWords)  throws DAOException{
		super.delete(artWorksWords);
	}

	public void refresh(ArtWorksWords artWorksWords)  throws DAOException{
		super.refresh(artWorksWords);
	}

	public String getTableName() {
		return ArtWorksWords.REF_TABLE;
	}
}
