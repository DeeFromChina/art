package com.golead.art.works.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

import com.golead.art.works.dao.ArtArtistWorksSeriesCaseDao;
import com.golead.art.works.model.ArtArtistWorksSeriesCase;
import com.golead.art.works.service.ArtArtistWorksSeriesCaseService;
import javax.annotation.Resource; 
import org.springframework.stereotype.Service;

@Service
public class ArtArtistWorksSeriesCaseServiceImpl extends BaseServiceImpl implements ArtArtistWorksSeriesCaseService {
	private static final long serialVersionUID = 1L;

	public ArtArtistWorksSeriesCase getArtArtistWorksSeriesCase(Serializable id) throws ServiceException {
		try {
			return artArtistWorksSeriesCaseDao.get(id);
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

	public void createArtArtistWorksSeriesCase(ArtArtistWorksSeriesCase artArtistWorksSeriesCase) throws ServiceException {
		try {
			artArtistWorksSeriesCaseDao.save(artArtistWorksSeriesCase);
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

	public void updateArtArtistWorksSeriesCase(Map<String, String> artArtistWorksSeriesCaseMap) throws ServiceException {
		try {
            Integer pkId = new Integer(artArtistWorksSeriesCaseMap.get(ArtArtistWorksSeriesCase.PROP_ID));
			ArtArtistWorksSeriesCase tmp = artArtistWorksSeriesCaseDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artArtistWorksSeriesCaseMap, true);			
			artArtistWorksSeriesCaseDao.update(tmp);
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

	public void deleteArtArtistWorksSeriesCase(Serializable id) throws ServiceException {
		try {
			artArtistWorksSeriesCaseDao.delete(id);
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

	public void deleteArtArtistWorksSeriesCases(Serializable[] ids) throws ServiceException {
		try {
			artArtistWorksSeriesCaseDao.deleteAll(ids);
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

	public PageQuery queryArtArtistWorksSeriesCase(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artArtistWorksSeriesCaseList", pageQuery);
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
        StringBuffer tmp = new StringBuffer();

        Map<String, String> parameters = page.getParameters();

        String seriesId = parameters.get("seriesId");

        if (seriesId != null && !seriesId.isEmpty()) {
            if (tmp.length() > 0) tmp.append(" AND ");
            tmp.append(" aawsc.series_id = ").append(seriesId);
        }

        if (tmp.length() > 0) parameters.put("paras", tmp.toString());
	}
	
    @Resource
	private ArtArtistWorksSeriesCaseDao	artArtistWorksSeriesCaseDao;

	public void setArtArtistWorksSeriesCaseDao(ArtArtistWorksSeriesCaseDao artArtistWorksSeriesCaseDao) {
		this.artArtistWorksSeriesCaseDao = artArtistWorksSeriesCaseDao;
	}
}

