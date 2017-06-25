package com.golead.art.photo.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.photo.model.ArtPhoto;
import com.golead.art.photo.dao.ArtPhotoDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtPhotoDaoImpl extends HibernateDaoImpl<ArtPhoto> implements ArtPhotoDao {

	public Class getReferenceClass() {
		return ArtPhoto.class;
	}

	public ArtPhoto cast(Object object) {
		return (ArtPhoto) object;
	}

	public ArtPhoto get(Serializable id)  throws DAOException{
		return (ArtPhoto) super.get(id);
	}

	public ArtPhoto load(Serializable id)  throws DAOException{
		return (ArtPhoto) super.load(id);
	}

	public Serializable save(ArtPhoto artPhoto)  throws DAOException{
		return super.save(artPhoto);
	}

	public void saveOrUpdate(ArtPhoto artPhoto)  throws DAOException{
		super.saveOrUpdate(artPhoto);
	}

	public void update(ArtPhoto artPhoto)  throws DAOException{
		super.update(artPhoto);
	}

	public void delete(ArtPhoto artPhoto)  throws DAOException{
		super.delete(artPhoto);
	}

	public void refresh(ArtPhoto artPhoto)  throws DAOException{
		super.refresh(artPhoto);
	}

	public String getTableName() {
		return ArtPhoto.REF_TABLE;
	}
}
