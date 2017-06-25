package com.golead.common.dao.impl;

import org.springframework.stereotype.Repository;

import com.golead.common.dao.SysCodeDao;
import com.golead.common.model.SysCode;
import com.golead.core.dao.impl.HibernateDaoImpl;

@Repository
public class SysCodeDaoImpl extends HibernateDaoImpl<SysCode> implements SysCodeDao {
}
