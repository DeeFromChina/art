package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksTheme;
import com.golead.art.works.dao.ArtWorksThemeDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksThemeDaoImpl extends HibernateDaoImpl<ArtWorksTheme> implements ArtWorksThemeDao {

	public Class getReferenceClass() {
		return ArtWorksTheme.class;
	}

	public ArtWorksTheme cast(Object object) {
		return (ArtWorksTheme) object;
	}

	public ArtWorksTheme get(Serializable id)  throws DAOException{
		return (ArtWorksTheme) super.get(id);
	}

	public ArtWorksTheme load(Serializable id)  throws DAOException{
		return (ArtWorksTheme) super.load(id);
	}

	public Serializable save(ArtWorksTheme artWorksTheme)  throws DAOException{
		return super.save(artWorksTheme);
	}

	public void saveOrUpdate(ArtWorksTheme artWorksTheme)  throws DAOException{
		super.saveOrUpdate(artWorksTheme);
	}

	public void update(ArtWorksTheme artWorksTheme)  throws DAOException{
		super.update(artWorksTheme);
	}

	public void delete(ArtWorksTheme artWorksTheme)  throws DAOException{
		super.delete(artWorksTheme);
	}

	public void refresh(ArtWorksTheme artWorksTheme)  throws DAOException{
		super.refresh(artWorksTheme);
	}

	public String getTableName() {
		return ArtWorksTheme.REF_TABLE;
	}
}
