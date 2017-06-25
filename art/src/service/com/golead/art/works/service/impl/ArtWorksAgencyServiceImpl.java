package com.golead.art.works.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
import com.golead.art.works.dao.ArtWorksAgencyDao;
import com.golead.art.works.model.ArtWorksAgency;
import com.golead.art.works.service.ArtWorksAgencyService;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service;

@Service
public class ArtWorksAgencyServiceImpl extends BaseServiceImpl implements ArtWorksAgencyService {
	private static final long serialVersionUID = 1L;

	public ArtWorksAgency getArtWorksAgency(Serializable id) throws ServiceException {
		try {
			return artWorksAgencyDao.get(id);
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

	public void createArtWorksAgency(ArtWorksAgency artWorksAgency) throws ServiceException {
		try {
			artWorksAgencyDao.save(artWorksAgency);
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

	public void updateArtWorksAgency(Map<String, String> artWorksAgencyMap) throws ServiceException {
		try {
            Integer pkId = new Integer(artWorksAgencyMap.get(ArtWorksAgency.PROP_ID));
			ArtWorksAgency tmp = artWorksAgencyDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artWorksAgencyMap, true);			
			artWorksAgencyDao.update(tmp);
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

	public void deleteArtWorksAgency(Serializable id) throws ServiceException {
		try {
			artWorksAgencyDao.delete(id);
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

	public void deleteArtWorksAgencys(Serializable[] ids) throws ServiceException {
		try {
			artWorksAgencyDao.deleteAll(ids);
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

   public int findByAgency(String ids) throws ServiceException {
      try {
         String str = "SELECT COUNT(*) FROM art_works_agency agency WHERE agency.agency_id IN (" + ids + ")";
         return jdbcDao.queryIntBySql(str);
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }
   
   public String findNameByIds(String ids) throws ServiceException{
      try {
         String sql = "SELECT artagency.agency_c_name AS name FROM art_works_agency agency "
               + " LEFT JOIN art_agency artagency ON artagency.id=agency.agency_id "
               + " WHERE agency.id IN (" + ids + ")";
         List<Map<String, Object>> list = jdbcDao.queryBySql(sql);
         String name = "";
         for(Map<String, Object> map : list){
            if(!"".equals(name)){
               name+=",";
            }
            name+=map.get("name") == null ? "" : map.get("name").toString();
         }
         return name;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

	public PageQuery queryArtWorksAgency(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artWorksAgencyList", pageQuery);
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
	   Map<String, String> map = page.getParameters();
	   if(map == null){
	      return;
	   }
	   
	   String paras = " 1=1 ";
	   
	   String worksId = map.get("worksId");
	   if(worksId != null && worksId.trim().length() > 0){
	      paras += "AND worksAgency.works_id = " + worksId;
	   }
	   
	   if (paras.length() > 0) page.getParameters().put("paras", paras);
	}
	
    @Resource
	private ArtWorksAgencyDao	artWorksAgencyDao;

	public void setArtWorksAgencyDao(ArtWorksAgencyDao artWorksAgencyDao) {
		this.artWorksAgencyDao = artWorksAgencyDao;
	}
}

