package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksCase;
import com.golead.art.works.dao.ArtWorksCaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksCaseDaoImpl extends HibernateDaoImpl<ArtWorksCase> implements ArtWorksCaseDao {

	public Class getReferenceClass() {
		return ArtWorksCase.class;
	}

	public ArtWorksCase cast(Object object) {
		return (ArtWorksCase) object;
	}

	public ArtWorksCase get(Serializable id)  throws DAOException{
		return (ArtWorksCase) super.get(id);
	}

	public ArtWorksCase load(Serializable id)  throws DAOException{
		return (ArtWorksCase) super.load(id);
	}

	public Serializable save(ArtWorksCase artWorksCase)  throws DAOException{
		return super.save(artWorksCase);
	}

	public void saveOrUpdate(ArtWorksCase artWorksCase)  throws DAOException{
		super.saveOrUpdate(artWorksCase);
	}

	public void update(ArtWorksCase artWorksCase)  throws DAOException{
		super.update(artWorksCase);
	}

	public void delete(ArtWorksCase artWorksCase)  throws DAOException{
		super.delete(artWorksCase);
	}

	public void refresh(ArtWorksCase artWorksCase)  throws DAOException{
		super.refresh(artWorksCase);
	}

	public String getTableName() {
		return ArtWorksCase.REF_TABLE;
	}
}
