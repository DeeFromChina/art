package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksOther;
import com.golead.art.works.dao.ArtWorksOtherDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksOtherDaoImpl extends HibernateDaoImpl<ArtWorksOther> implements ArtWorksOtherDao {

	public Class getReferenceClass() {
		return ArtWorksOther.class;
	}

	public ArtWorksOther cast(Object object) {
		return (ArtWorksOther) object;
	}

	public ArtWorksOther get(Serializable id)  throws DAOException{
		return (ArtWorksOther) super.get(id);
	}

	public ArtWorksOther load(Serializable id)  throws DAOException{
		return (ArtWorksOther) super.load(id);
	}

	public Serializable save(ArtWorksOther artWorksOther)  throws DAOException{
		return super.save(artWorksOther);
	}

	public void saveOrUpdate(ArtWorksOther artWorksOther)  throws DAOException{
		super.saveOrUpdate(artWorksOther);
	}

	public void update(ArtWorksOther artWorksOther)  throws DAOException{
		super.update(artWorksOther);
	}

	public void delete(ArtWorksOther artWorksOther)  throws DAOException{
		super.delete(artWorksOther);
	}

	public void refresh(ArtWorksOther artWorksOther)  throws DAOException{
		super.refresh(artWorksOther);
	}

	public String getTableName() {
		return ArtWorksOther.REF_TABLE;
	}
}
