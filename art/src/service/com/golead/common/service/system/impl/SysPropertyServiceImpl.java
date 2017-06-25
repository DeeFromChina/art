package com.golead.common.service.system.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.golead.common.dao.SysPropertyDao;
import com.golead.common.model.SysProperty;
import com.golead.common.service.system.SysPropertyService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.DAOException;
import com.golead.core.exception.ServiceException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
@Service
public class SysPropertyServiceImpl extends BaseServiceImpl implements SysPropertyService {
	private static final long serialVersionUID = 1L;

	
	@Override
   public SysProperty getSysProperty(Serializable id) throws ServiceException {
		try {
			return sysPropertyDao.get(id);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}

	
	@Override
   public void createSysProperty(SysProperty sysProperty) throws ServiceException {
		try {
			sysPropertyDao.save(sysProperty);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}

	
	@Override
   public void updateSysProperty(Map<String, String> sysPropertyMap) throws ServiceException {
		try {
            Integer pkId = new Integer(sysPropertyMap.get(SysProperty.PROP_ID));
			SysProperty tmp = sysPropertyDao.get(pkId);
			ConvertUtil.mapToObject(tmp, sysPropertyMap, true);			
			sysPropertyDao.update(tmp);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}

	
	@Override
   public void deleteSysProperty(Serializable id) throws ServiceException {
		try {
			sysPropertyDao.delete(id);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}

	
	@Override
   public void deleteSysPropertys(Serializable[] ids) throws ServiceException {
		try {
			sysPropertyDao.deleteAll(ids);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}

	
	@Override
   public PageQuery querySysProperty(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("sysPropertyList", pageQuery);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}
	
	@Override
   public List<SysProperty> findSysProperty(int userId,String key) throws ServiceException {
		try {
			 List<SysProperty> list=sysPropertyDao.findByFields(new String[]{SysProperty.PROP_USER_ID,SysProperty.PROP_PROPERTY_KEY}, new Object[]{userId,key});
			 return list;
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	
	@Override
   public void saveProperties(Integer id, String key,String value) throws ServiceException {
	      String tmp = ";" + value + ";";
	      try {
//	         SysRole sysRole = sysRoleDao.get(id);
//	         if (sysRole == null)
//	            throw new ServiceException("该角色不存在");
	    	  SysProperty pro =sysPropertyDao.findByFields(new String[]{SysProperty.PROP_USER_ID,SysProperty.PROP_PROPERTY_KEY}, new Object[]{id,key}).get(0);
	            if (tmp.indexOf(";" + pro.getPropertyValue() + ";") < 0) {
	               sysPropertyDao.delete(pro);
	            } else {
	               tmp = tmp.replace(";" + pro.getPropertyValue() + ";", ";");// 放弃没有变化的属性
	            }
	            if(tmp!=null){
	            	
	            }
	            SysProperty property = new SysProperty();// 增加权限
	            property.setUserId(new Integer(id));
	            property.setPropertyKey(key);
	            property.setPropertyValue(tmp);
		         sysPropertyDao.save(property);
//	         }
	      } catch (DAOException e) {
	         e.printStackTrace();
	         throw new ServiceException("数据库操作错误。");
	      } catch (ServiceException se) {
	         se.printStackTrace();
	         throw se;
	      } catch (Exception e) {
	         e.printStackTrace();
	         throw new ServiceException("系统错误。");
	      }
	}
	private void createSqlFilter(PageQuery page) {
	}
	


   @Resource
	private SysPropertyDao	sysPropertyDao;
	
	

	public void setSysPropertyDao(SysPropertyDao sysPropertyDao) {
		this.sysPropertyDao = sysPropertyDao;
	}

}

