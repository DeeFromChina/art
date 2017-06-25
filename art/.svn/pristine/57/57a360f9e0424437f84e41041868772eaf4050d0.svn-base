package com.golead.art.artist.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
import com.golead.art.artist.dao.ArtArtistWorksPeriodDao;
import com.golead.art.artist.model.ArtArtistWorksPeriod;
import com.golead.art.artist.service.ArtArtistWorksPeriodService;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service;

@Service
public class ArtArtistWorksPeriodServiceImpl extends BaseServiceImpl implements ArtArtistWorksPeriodService {
	private static final long serialVersionUID = 1L;

	public ArtArtistWorksPeriod getArtArtistWorksPeriod(Serializable id) throws ServiceException {
		try {
			return artArtistWorksPeriodDao.get(id);
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

	public void createArtArtistWorksPeriod(ArtArtistWorksPeriod artArtistWorksPeriod) throws ServiceException {
		try {
			artArtistWorksPeriodDao.save(artArtistWorksPeriod);
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

	public void updateArtArtistWorksPeriod(Map<String, String> artArtistWorksPeriodMap) throws ServiceException {
		try {
         Integer pkId = new Integer(artArtistWorksPeriodMap.get(ArtArtistWorksPeriod.PROP_ID));
			ArtArtistWorksPeriod tmp = artArtistWorksPeriodDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artArtistWorksPeriodMap, true);
			artArtistWorksPeriodDao.update(tmp);
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

	public void deleteArtArtistWorksPeriod(Serializable id) throws ServiceException {
		try {
			artArtistWorksPeriodDao.delete(id);
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

	public void deleteArtArtistWorksPeriods(Serializable[] ids) throws ServiceException {
		try {
			artArtistWorksPeriodDao.deleteAll(ids);
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

	public PageQuery queryArtArtistWorksPeriod(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artArtistWorksPeriodList", pageQuery);
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
	
	public List<ArtArtistWorksPeriod> findByArtistId(Serializable id) throws ServiceException{
	   try {
	          return artArtistWorksPeriodDao.findByField(ArtArtistWorksPeriod.PROP_ARTIST_ID, id);
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
	
	public List<ArtArtistWorksPeriod> findByPeriodType(String periodType) throws ServiceException{
	   try {
         return artArtistWorksPeriodDao.findByField(ArtArtistWorksPeriod.PROP_PERIOD_TYPE, periodType);
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
	
	public List<ArtArtistWorksPeriod> findAllGroupPeriods() throws ServiceException{
	   try {
	      String hql = "FROM ArtArtistWorksPeriod period GROUP BY period.periodName ";
         return artArtistWorksPeriodDao.findByHql(hql);
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
	
	public ArtArtistWorksPeriod findOneArtArtistWorksPeriod(Map<String, String> artArtistWorksPeriodMap) throws ServiceException{
	   try {
	         String hql = "FROM ArtArtistWorksPeriod period ";
	         hql = hql + returnHql(artArtistWorksPeriodMap);
	          List<ArtArtistWorksPeriod> periods = artArtistWorksPeriodDao.findByHql(hql);
	          if(periods.size()>0){
	             return periods.get(0);
	          }else{
	             return null;
	          }
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
	
	private String returnHql(Map<String, String> artArtistWorksPeriodMap){
	   String hql = "WHERE 1=1 ";
	   
	   String periodType = artArtistWorksPeriodMap.get("periodType");
	   if(periodType != null){
	      hql = hql + "AND period.periodType='" + periodType.trim() + "'";
	   }
	   
	   String periodName = artArtistWorksPeriodMap.get("periodName");
      if(periodType != null){
         hql = hql + "AND period.periodName='" + periodName.trim() + "'";
      }
      
      String artistId = artArtistWorksPeriodMap.get("artistId");
      if(periodType != null){
         hql = hql + "AND period.artistId=" + artistId.trim();
      }
      
	   return hql;
	}
	
    @Resource
	private ArtArtistWorksPeriodDao	artArtistWorksPeriodDao;

	public void setArtArtistWorksPeriodDao(ArtArtistWorksPeriodDao artArtistWorksPeriodDao) {
		this.artArtistWorksPeriodDao = artArtistWorksPeriodDao;
	}
}

