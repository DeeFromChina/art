package com.golead.art.works.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.works.model.ArtSysLog;
import com.golead.art.works.dao.ArtSysLogDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtSysLogDaoImpl extends HibernateDaoImpl<ArtSysLog> implements ArtSysLogDao {

	public Class getReferenceClass() {
		return ArtSysLog.class;
	}

	public ArtSysLog cast(Object object) {
		return (ArtSysLog) object;
	}

	public ArtSysLog get(Serializable id)  throws DAOException{
		return (ArtSysLog) super.get(id);
	}

	public ArtSysLog load(Serializable id)  throws DAOException{
		return (ArtSysLog) super.load(id);
	}

	public Serializable save(ArtSysLog artSysLog)  throws DAOException{
		return super.save(artSysLog);
	}

	public void saveOrUpdate(ArtSysLog artSysLog)  throws DAOException{
		super.saveOrUpdate(artSysLog);
	}

	public void update(ArtSysLog artSysLog)  throws DAOException{
		super.update(artSysLog);
	}

	public void delete(ArtSysLog artSysLog)  throws DAOException{
		super.delete(artSysLog);
	}

	public void refresh(ArtSysLog artSysLog)  throws DAOException{
		super.refresh(artSysLog);
	}

	public String getTableName() {
		return ArtSysLog.REF_TABLE;
	}
}
