package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksYear;
import com.golead.art.works.dao.ArtWorksYearDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksYearDaoImpl extends HibernateDaoImpl<ArtWorksYear> implements ArtWorksYearDao {

	public Class getReferenceClass() {
		return ArtWorksYear.class;
	}

	public ArtWorksYear cast(Object object) {
		return (ArtWorksYear) object;
	}

	public ArtWorksYear get(Serializable id)  throws DAOException{
		return (ArtWorksYear) super.get(id);
	}

	public ArtWorksYear load(Serializable id)  throws DAOException{
		return (ArtWorksYear) super.load(id);
	}

	public Serializable save(ArtWorksYear artWorksYear)  throws DAOException{
		return super.save(artWorksYear);
	}

	public void saveOrUpdate(ArtWorksYear artWorksYear)  throws DAOException{
		super.saveOrUpdate(artWorksYear);
	}

	public void update(ArtWorksYear artWorksYear)  throws DAOException{
		super.update(artWorksYear);
	}

	public void delete(ArtWorksYear artWorksYear)  throws DAOException{
		super.delete(artWorksYear);
	}

	public void refresh(ArtWorksYear artWorksYear)  throws DAOException{
		super.refresh(artWorksYear);
	}

	public String getTableName() {
		return ArtWorksYear.REF_TABLE;
	}
}
