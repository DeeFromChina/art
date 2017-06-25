package com.golead.art.works.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

import com.golead.art.works.dao.ArtArtistHeatDayDao;
import com.golead.art.works.model.ArtArtistHeatDay;
import com.golead.art.works.service.ArtArtistHeatDayService;
import javax.annotation.Resource; 
import org.springframework.stereotype.Service;

@Service
public class ArtArtistHeatDayServiceImpl extends BaseServiceImpl implements ArtArtistHeatDayService {
	private static final long serialVersionUID = 1L;

	public ArtArtistHeatDay getArtArtistHeatDay(Serializable id) throws ServiceException {
		try {
			return artArtistHeatDayDao.get(id);
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

	public void createArtArtistHeatDay(ArtArtistHeatDay artArtistHeatDay) throws ServiceException {
		try {
			artArtistHeatDayDao.save(artArtistHeatDay);
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

	public void updateArtArtistHeatDay(Map<String, String> artArtistHeatDayMap) throws ServiceException {
		try {
            Integer pkId = new Integer(artArtistHeatDayMap.get(ArtArtistHeatDay.PROP_ID));
			ArtArtistHeatDay tmp = artArtistHeatDayDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artArtistHeatDayMap, true);			
			artArtistHeatDayDao.update(tmp);
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

	public void deleteArtArtistHeatDay(Serializable id) throws ServiceException {
		try {
			artArtistHeatDayDao.delete(id);
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

	public void deleteArtArtistHeatDays(Serializable[] ids) throws ServiceException {
		try {
			artArtistHeatDayDao.deleteAll(ids);
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

	public PageQuery queryArtArtistHeatDay(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artArtistHeatDayList", pageQuery);
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
	private ArtArtistHeatDayDao	artArtistHeatDayDao;

	public void setArtArtistHeatDayDao(ArtArtistHeatDayDao artArtistHeatDayDao) {
		this.artArtistHeatDayDao = artArtistHeatDayDao;
	}
}

