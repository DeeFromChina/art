package com.golead.common.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.common.model.SysRoleDept;
import com.golead.common.dao.SysRoleDeptDao;
import org.springframework.stereotype.Repository;

@Repository
public class SysRoleDeptDaoImpl extends HibernateDaoImpl<SysRoleDept> implements SysRoleDeptDao {

	public Class getReferenceClass() {
		return SysRoleDept.class;
	}

	public SysRoleDept cast(Object object) {
		return (SysRoleDept) object;
	}

	@Override
   public SysRoleDept get(Serializable id)  throws DAOException{
		return super.get(id);
	}

	@Override
   public SysRoleDept load(Serializable id)  throws DAOException{
		return super.load(id);
	}

	@Override
   public Serializable save(SysRoleDept sysRoleDept)  throws DAOException{
		return super.save(sysRoleDept);
	}

	@Override
   public void saveOrUpdate(SysRoleDept sysRoleDept)  throws DAOException{
		super.saveOrUpdate(sysRoleDept);
	}

	@Override
   public void update(SysRoleDept sysRoleDept)  throws DAOException{
		super.update(sysRoleDept);
	}

	@Override
   public void delete(SysRoleDept sysRoleDept)  throws DAOException{
		super.delete(sysRoleDept);
	}

	@Override
   public void refresh(SysRoleDept sysRoleDept)  throws DAOException{
		super.refresh(sysRoleDept);
	}

	public String getTableName() {
		return SysRoleDept.REF_TABLE;
	}
}
