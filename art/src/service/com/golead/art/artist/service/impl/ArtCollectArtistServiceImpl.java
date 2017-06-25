package com.golead.art.artist.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

import com.golead.art.artist.dao.ArtCollectArtistDao;
import com.golead.art.artist.model.ArtCollectArtist;
import com.golead.art.artist.service.ArtCollectArtistService;
import javax.annotation.Resource; 
import org.springframework.stereotype.Service;

@Service
public class ArtCollectArtistServiceImpl extends BaseServiceImpl implements ArtCollectArtistService {
	private static final long serialVersionUID = 1L;

	public ArtCollectArtist getArtCollectArtist(Serializable id) throws ServiceException {
		try {
			return artCollectArtistDao.get(id);
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

	public void createArtCollectArtist(ArtCollectArtist artCollectArtist) throws ServiceException {
		try {
			artCollectArtistDao.save(artCollectArtist);
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

	public void updateArtCollectArtist(Map<String, String> artCollectArtistMap) throws ServiceException {
		try {
            Integer pkId = new Integer(artCollectArtistMap.get(ArtCollectArtist.PROP_ID));
			ArtCollectArtist tmp = artCollectArtistDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artCollectArtistMap, true);			
			artCollectArtistDao.update(tmp);
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

	public void deleteArtCollectArtist(Serializable id) throws ServiceException {
		try {
			artCollectArtistDao.delete(id);
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

	public void deleteArtCollectArtists(Serializable[] ids) throws ServiceException {
		try {
			artCollectArtistDao.deleteAll(ids);
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

	public PageQuery queryArtCollectArtist(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artCollectArtistList", pageQuery);
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
	private ArtCollectArtistDao	artCollectArtistDao;

	public void setArtCollectArtistDao(ArtCollectArtistDao artCollectArtistDao) {
		this.artCollectArtistDao = artCollectArtistDao;
	}
}

