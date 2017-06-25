package com.golead.art.works.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
import com.golead.art.works.dao.ArtWorksWordsDao;
import com.golead.art.works.model.ArtWorksWords;
import com.golead.art.works.service.ArtWorksWordsService;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service;

@Service
public class ArtWorksWordsServiceImpl extends BaseServiceImpl implements ArtWorksWordsService {
	private static final long serialVersionUID = 1L;

	public ArtWorksWords getArtWorksWords(Serializable id) throws ServiceException {
		try {
			return artWorksWordsDao.get(id);
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

	public void createArtWorksWords(ArtWorksWords artWorksWords) throws ServiceException {
		try {
			artWorksWordsDao.save(artWorksWords);
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
	
	public void createArtWorksWords(int worksId, int[] ids) throws ServiceException{
	   try {
         for(int i = 0; i<ids.length; i++){
            ArtWorksWords artWorksWords = new ArtWorksWords();
            artWorksWords.setWordsId(ids[i]);
            artWorksWords.setWorksId(worksId);
            createArtWorksWords(artWorksWords);
         }
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
	}

	public void updateArtWorksWords(Map<String, String> artWorksWordsMap) throws ServiceException {
		try {
            Integer pkId = new Integer(artWorksWordsMap.get(ArtWorksWords.PROP_ID));
			ArtWorksWords tmp = artWorksWordsDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artWorksWordsMap, true);			
			artWorksWordsDao.update(tmp);
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

	public void deleteArtWorksWords(Serializable id) throws ServiceException {
		try {
			artWorksWordsDao.delete(id);
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

	public void deleteArtWorksWordss(Serializable[] ids) throws ServiceException {
		try {
			artWorksWordsDao.deleteAll(ids);
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

	public PageQuery queryArtWorksWords(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artWorksWordsList", pageQuery);
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
      String paras = " 1=1 ";
      Map<String, String> map = page.getParameters();

      String worksId = map.get("worksId");
      if (worksId != null && worksId.trim().length() > 0) {
         paras += " AND words.works_id=" + worksId.trim();
      }
      
      String publicationName = map.get("publicationName");
      if (publicationName != null && publicationName.trim().length() > 0) {
         paras += " AND literature.publication_name like '%" + publicationName.trim() + "%'";
      }
      
      String literatureAuther = map.get("literatureAuther");
      if (literatureAuther != null && literatureAuther.trim().length() > 0) {
         paras += " AND literature.literature_auther like '%" + literatureAuther.trim() + "%'";
      }
      
      String literatureTitle = map.get("literatureTitle");
      if (literatureTitle != null && literatureTitle.trim().length() > 0) {
         paras += " AND literature.literature_title like '%" + literatureTitle.trim() + "%'";
      }

      String literatureWorks = map.get("literatureWorks");
      if (literatureWorks != null && literatureWorks.trim().length() > 0) {
         paras += " AND literature.literature_works like '%" + literatureWorks.trim() + "%'";
      }
      
      String quoteLiterature = map.get("quoteLiterature");
      if (quoteLiterature != null && quoteLiterature.trim().length() > 0) {
         paras += " AND literature.quote_literature like '%" + quoteLiterature.trim() + "%'";
      }
      
      String personInvolved = map.get("personInvolved");
      if (personInvolved != null && personInvolved.trim().length() > 0) {
         paras += " AND literature.person_involved like '%" + personInvolved.trim() + "%'";
      }
      
      String relatedExhib = map.get("relatedExhib");
      if (relatedExhib != null && relatedExhib.trim().length() > 0) {
         paras += " AND literature.related_exhib like '%" + relatedExhib.trim() + "%'";
      }
      
      String relatedEvent = map.get("relatedEvent");
      if (relatedExhib != null && relatedExhib.trim().length() > 0) {
         paras += " AND literature.related_event like '%" + relatedEvent.trim() + "%'";
      }
      
      if (paras.length() > 0) page.getParameters().put("paras", paras);
   }
	
    @Resource
	private ArtWorksWordsDao	artWorksWordsDao;

	public void setArtWorksWordsDao(ArtWorksWordsDao artWorksWordsDao) {
		this.artWorksWordsDao = artWorksWordsDao;
	}
}

