package com.golead.art.literature.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

import com.golead.art.literature.dao.ArtLiteratureMediumResearchDao;
import com.golead.art.literature.model.ArtLiteratureMediumResearch;
import com.golead.art.literature.service.ArtLiteratureMediumResearchService;
import javax.annotation.Resource; 
import org.springframework.stereotype.Service;

@Service
public class ArtLiteratureMediumResearchServiceImpl extends BaseServiceImpl implements ArtLiteratureMediumResearchService {
	private static final long serialVersionUID = 1L;

	public ArtLiteratureMediumResearch getArtLiteratureMediumResearch(Serializable id) throws ServiceException {
		try {
			return artLiteratureMediumResearchDao.get(id);
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

	public void createArtLiteratureMediumResearch(ArtLiteratureMediumResearch artLiteratureMediumResearch) throws ServiceException {
		try {
			artLiteratureMediumResearchDao.save(artLiteratureMediumResearch);
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

	public void updateArtLiteratureMediumResearch(Map<String, String> artLiteratureMediumResearchMap) throws ServiceException {
		try {
            Integer pkId = new Integer(artLiteratureMediumResearchMap.get(ArtLiteratureMediumResearch.PROP_ID));
			ArtLiteratureMediumResearch tmp = artLiteratureMediumResearchDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artLiteratureMediumResearchMap, true);			
			artLiteratureMediumResearchDao.update(tmp);
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

	public void deleteArtLiteratureMediumResearch(Serializable id) throws ServiceException {
		try {
			artLiteratureMediumResearchDao.delete(id);
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

	public void deleteArtLiteratureMediumResearchs(Serializable[] ids) throws ServiceException {
		try {
			artLiteratureMediumResearchDao.deleteAll(ids);
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

	public PageQuery queryArtLiteratureMediumResearch(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artLiteratureMediumResearchList", pageQuery);
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
	
	public ArtLiteratureMediumResearch findByMediumId(Serializable id) throws ServiceException{
	   try {
         List<ArtLiteratureMediumResearch> artLiteratureMediumResearchs = artLiteratureMediumResearchDao.findByField(ArtLiteratureMediumResearch.PROP_MEDIUM_ID, id);
         if(artLiteratureMediumResearchs.size() == 1){
            return artLiteratureMediumResearchs.get(0);
         }
         return null;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
	}  
	
	public void updateArtLiteratureMediumResearch(ArtLiteratureMediumResearch artLiteratureMediumResearch) throws ServiceException{
	   try {
         artLiteratureMediumResearchDao.update(artLiteratureMediumResearch);
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
	}
	
	public void deleteByMediumId(Serializable id) throws ServiceException{
	   try {
         artLiteratureMediumResearchDao.deleteByField(ArtLiteratureMediumResearch.PROP_MEDIUM_ID, id);
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
	}
	
    @Resource
	private ArtLiteratureMediumResearchDao	artLiteratureMediumResearchDao;

	public void setArtLiteratureMediumResearchDao(ArtLiteratureMediumResearchDao artLiteratureMediumResearchDao) {
		this.artLiteratureMediumResearchDao = artLiteratureMediumResearchDao;
	}
}

