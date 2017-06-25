package com.golead.art.artist.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

import com.golead.art.artist.dao.ArtArtistExhibitDao;
import com.golead.art.artist.model.ArtArtistExhibit;
import com.golead.art.artist.service.ArtArtistExhibitService;
import javax.annotation.Resource; 
import org.springframework.stereotype.Service;

@Service
public class ArtArtistExhibitServiceImpl extends BaseServiceImpl implements ArtArtistExhibitService {
	private static final long serialVersionUID = 1L;

	public ArtArtistExhibit getArtArtistExhibit(Serializable id) throws ServiceException {
		try {
			return artArtistExhibitDao.get(id);
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

	public void createArtArtistExhibit(ArtArtistExhibit artArtistExhibit) throws ServiceException {
		try {
			artArtistExhibitDao.save(artArtistExhibit);
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

	public void updateArtArtistExhibit(Map<String, String> artArtistExhibitMap) throws ServiceException {
		try {
            Integer pkId = new Integer(artArtistExhibitMap.get(ArtArtistExhibit.PROP_ID));
			ArtArtistExhibit tmp = artArtistExhibitDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artArtistExhibitMap, true);			
			artArtistExhibitDao.update(tmp);
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

	public void deleteArtArtistExhibit(Serializable id) throws ServiceException {
		try {
			artArtistExhibitDao.delete(id);
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

	public void deleteArtArtistExhibits(Serializable[] ids) throws ServiceException {
		try {
			artArtistExhibitDao.deleteAll(ids);
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

	public PageQuery queryArtArtistExhibit(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artArtistExhibitList", pageQuery);
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
	private ArtArtistExhibitDao	artArtistExhibitDao;

	public void setArtArtistExhibitDao(ArtArtistExhibitDao artArtistExhibitDao) {
		this.artArtistExhibitDao = artArtistExhibitDao;
	}
}

