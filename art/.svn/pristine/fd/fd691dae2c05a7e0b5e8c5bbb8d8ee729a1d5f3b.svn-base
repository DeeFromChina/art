package com.golead.art.works.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

import com.golead.art.works.dao.ArtWorksYearResearchDao;
import com.golead.art.works.model.ArtWorksYearResearch;
import com.golead.art.works.service.ArtWorksYearResearchService;
import javax.annotation.Resource; 
import org.springframework.stereotype.Service;

@Service
public class ArtWorksYearResearchServiceImpl extends BaseServiceImpl implements ArtWorksYearResearchService {
	private static final long serialVersionUID = 1L;

	public ArtWorksYearResearch getArtWorksYearResearch(Serializable id) throws ServiceException {
		try {
			return artWorksYearResearchDao.get(id);
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

	public void createArtWorksYearResearch(ArtWorksYearResearch artWorksYearResearch) throws ServiceException {
		try {
			artWorksYearResearchDao.save(artWorksYearResearch);
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
    public void createArtWorksYearResearch(List<ArtWorksYearResearch> artWorksYearResearch) throws ServiceException {
        try {
            artWorksYearResearchDao.saveOrUpdateAll(artWorksYearResearch);
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

    public void updateArtWorksYearResearch(Map<String, String> artWorksYearResearchMap) throws ServiceException {
		try {
            Integer pkId = new Integer(artWorksYearResearchMap.get(ArtWorksYearResearch.PROP_ID));
			ArtWorksYearResearch tmp = artWorksYearResearchDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artWorksYearResearchMap, true);			
			artWorksYearResearchDao.update(tmp);
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

	public void deleteArtWorksYearResearch(Serializable id) throws ServiceException {
		try {
			artWorksYearResearchDao.delete(id);
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

	public void deleteArtWorksYearResearchs(Serializable[] ids) throws ServiceException {
		try {
			artWorksYearResearchDao.deleteAll(ids);
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

	public PageQuery queryArtWorksYearResearch(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artWorksYearResearchList", pageQuery);
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

        String artistId = parameters.get("artistId");

        if (artistId != null && !"".equals(artistId)) {
            if (tmp.length() > 0) tmp.append(" AND ");
            tmp.append(" aa.id = ").append(artistId);
        }

        String yearId = parameters.get("yearId");

        if (yearId != null && !"".equals(yearId)) {
            if (tmp.length() > 0) tmp.append(" AND ");
            tmp.append(" awyr.year_id = ").append(yearId);
        }

        if (tmp.length() > 0) parameters.put("paras", tmp.toString());
	}
	
    @Resource
	private ArtWorksYearResearchDao	artWorksYearResearchDao;

	public void setArtWorksYearResearchDao(ArtWorksYearResearchDao artWorksYearResearchDao) {
		this.artWorksYearResearchDao = artWorksYearResearchDao;
	}
}

