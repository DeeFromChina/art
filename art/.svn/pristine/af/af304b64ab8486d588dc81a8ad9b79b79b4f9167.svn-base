package com.golead.art.app.artistPage.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.app.artistPage.model.ArtArtistTemplate;
import com.golead.art.app.artistPage.dao.ArtArtistTemplateDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistTemplateDaoImpl extends HibernateDaoImpl<ArtArtistTemplate> implements ArtArtistTemplateDao {

	public Class getReferenceClass() {
		return ArtArtistTemplate.class;
	}

	public ArtArtistTemplate cast(Object object) {
		return (ArtArtistTemplate) object;
	}

	public ArtArtistTemplate get(Serializable id)  throws DAOException{
		return (ArtArtistTemplate) super.get(id);
	}

	public ArtArtistTemplate load(Serializable id)  throws DAOException{
		return (ArtArtistTemplate) super.load(id);
	}

	public Serializable save(ArtArtistTemplate artArtistTemplate)  throws DAOException{
		return super.save(artArtistTemplate);
	}

	public void saveOrUpdate(ArtArtistTemplate artArtistTemplate)  throws DAOException{
		super.saveOrUpdate(artArtistTemplate);
	}

	public void update(ArtArtistTemplate artArtistTemplate)  throws DAOException{
		super.update(artArtistTemplate);
	}

	public void delete(ArtArtistTemplate artArtistTemplate)  throws DAOException{
		super.delete(artArtistTemplate);
	}

	public void refresh(ArtArtistTemplate artArtistTemplate)  throws DAOException{
		super.refresh(artArtistTemplate);
	}

	public String getTableName() {
		return ArtArtistTemplate.REF_TABLE;
	}
}
