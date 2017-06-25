package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtArtistWorksSeriesCase;
import com.golead.art.works.dao.ArtArtistWorksSeriesCaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtArtistWorksSeriesCaseDaoImpl extends HibernateDaoImpl<ArtArtistWorksSeriesCase> implements ArtArtistWorksSeriesCaseDao {

	public Class getReferenceClass() {
		return ArtArtistWorksSeriesCase.class;
	}

	public ArtArtistWorksSeriesCase cast(Object object) {
		return (ArtArtistWorksSeriesCase) object;
	}

	public ArtArtistWorksSeriesCase get(Serializable id)  throws DAOException{
		return (ArtArtistWorksSeriesCase) super.get(id);
	}

	public ArtArtistWorksSeriesCase load(Serializable id)  throws DAOException{
		return (ArtArtistWorksSeriesCase) super.load(id);
	}

	public Serializable save(ArtArtistWorksSeriesCase artArtistWorksSeriesCase)  throws DAOException{
		return super.save(artArtistWorksSeriesCase);
	}

	public void saveOrUpdate(ArtArtistWorksSeriesCase artArtistWorksSeriesCase)  throws DAOException{
		super.saveOrUpdate(artArtistWorksSeriesCase);
	}

	public void update(ArtArtistWorksSeriesCase artArtistWorksSeriesCase)  throws DAOException{
		super.update(artArtistWorksSeriesCase);
	}

	public void delete(ArtArtistWorksSeriesCase artArtistWorksSeriesCase)  throws DAOException{
		super.delete(artArtistWorksSeriesCase);
	}

	public void refresh(ArtArtistWorksSeriesCase artArtistWorksSeriesCase)  throws DAOException{
		super.refresh(artArtistWorksSeriesCase);
	}

	public String getTableName() {
		return ArtArtistWorksSeriesCase.REF_TABLE;
	}
}
