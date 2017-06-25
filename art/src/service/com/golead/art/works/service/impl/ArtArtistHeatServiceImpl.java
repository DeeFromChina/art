package com.golead.art.works.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

import com.golead.art.works.dao.ArtArtistHeatDao;
import com.golead.art.works.model.ArtArtistHeat;
import com.golead.art.works.service.ArtArtistHeatService;
import javax.annotation.Resource; 
import org.springframework.stereotype.Service;

@Service
public class ArtArtistHeatServiceImpl extends BaseServiceImpl implements ArtArtistHeatService {
	private static final long serialVersionUID = 1L;

	public ArtArtistHeat getArtArtistHeat(Serializable id) throws ServiceException {
		try {
			return artArtistHeatDao.get(id);
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

	public void createArtArtistHeat(ArtArtistHeat artArtistHeat) throws ServiceException {
		try {
			artArtistHeatDao.save(artArtistHeat);
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

	public void updateArtArtistHeat(Map<String, String> artArtistHeatMap) throws ServiceException {
		try {
            Integer pkId = new Integer(artArtistHeatMap.get(ArtArtistHeat.PROP_ID));
			ArtArtistHeat tmp = artArtistHeatDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artArtistHeatMap, true);			
			artArtistHeatDao.update(tmp);
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

	public void deleteArtArtistHeat(Serializable id) throws ServiceException {
		try {
			artArtistHeatDao.delete(id);
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

	public void deleteArtArtistHeats(Serializable[] ids) throws ServiceException {
		try {
			artArtistHeatDao.deleteAll(ids);
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

	public PageQuery queryArtArtistHeat(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artArtistHeatList", pageQuery);
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
	private ArtArtistHeatDao	artArtistHeatDao;

	public void setArtArtistHeatDao(ArtArtistHeatDao artArtistHeatDao) {
		this.artArtistHeatDao = artArtistHeatDao;
	}
}

