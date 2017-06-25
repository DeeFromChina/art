package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtWorksAttachment;
import com.golead.art.works.dao.ArtWorksAttachmentDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtWorksAttachmentDaoImpl extends HibernateDaoImpl<ArtWorksAttachment> implements ArtWorksAttachmentDao {

	public Class getReferenceClass() {
		return ArtWorksAttachment.class;
	}

	public ArtWorksAttachment cast(Object object) {
		return (ArtWorksAttachment) object;
	}

	public ArtWorksAttachment get(Serializable id)  throws DAOException{
		return (ArtWorksAttachment) super.get(id);
	}

	public ArtWorksAttachment load(Serializable id)  throws DAOException{
		return (ArtWorksAttachment) super.load(id);
	}

	public Serializable save(ArtWorksAttachment artWorksAttachment)  throws DAOException{
		return super.save(artWorksAttachment);
	}

	public void saveOrUpdate(ArtWorksAttachment artWorksAttachment)  throws DAOException{
		super.saveOrUpdate(artWorksAttachment);
	}

	public void update(ArtWorksAttachment artWorksAttachment)  throws DAOException{
		super.update(artWorksAttachment);
	}

	public void delete(ArtWorksAttachment artWorksAttachment)  throws DAOException{
		super.delete(artWorksAttachment);
	}

	public void refresh(ArtWorksAttachment artWorksAttachment)  throws DAOException{
		super.refresh(artWorksAttachment);
	}

	public String getTableName() {
		return ArtWorksAttachment.REF_TABLE;
	}
}
