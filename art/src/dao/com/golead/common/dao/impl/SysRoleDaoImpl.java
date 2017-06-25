package com.golead.common.dao.impl;

import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.common.model.SysRole;
import com.golead.common.dao.SysRoleDao;
import org.springframework.stereotype.Repository;

@Repository
public class SysRoleDaoImpl extends HibernateDaoImpl<SysRole> implements SysRoleDao {
}
