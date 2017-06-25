package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksStyle;
import com.golead.art.works.dao.ArtWorksStyleDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksStyleDaoImpl extends HibernateDaoImpl<ArtWorksStyle> implements ArtWorksStyleDao {

	public Class getReferenceClass() {
		return ArtWorksStyle.class;
	}

	public ArtWorksStyle cast(Object object) {
		return (ArtWorksStyle) object;
	}

	public ArtWorksStyle get(Serializable id)  throws DAOException{
		return (ArtWorksStyle) super.get(id);
	}

	public ArtWorksStyle load(Serializable id)  throws DAOException{
		return (ArtWorksStyle) super.load(id);
	}

	public Serializable save(ArtWorksStyle artWorksStyle)  throws DAOException{
		return super.save(artWorksStyle);
	}

	public void saveOrUpdate(ArtWorksStyle artWorksStyle)  throws DAOException{
		super.saveOrUpdate(artWorksStyle);
	}

	public void update(ArtWorksStyle artWorksStyle)  throws DAOException{
		super.update(artWorksStyle);
	}

	public void delete(ArtWorksStyle artWorksStyle)  throws DAOException{
		super.delete(artWorksStyle);
	}

	public void refresh(ArtWorksStyle artWorksStyle)  throws DAOException{
		super.refresh(artWorksStyle);
	}

	public String getTableName() {
		return ArtWorksStyle.REF_TABLE;
	}
}
