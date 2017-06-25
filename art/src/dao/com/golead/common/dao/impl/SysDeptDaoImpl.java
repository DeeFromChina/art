package com.golead.common.dao.impl;

import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.common.model.SysDept;
import com.golead.common.dao.SysDeptDao;
import org.springframework.stereotype.Repository;

@Repository
public class SysDeptDaoImpl extends HibernateDaoImpl<SysDept> implements SysDeptDao {
}
