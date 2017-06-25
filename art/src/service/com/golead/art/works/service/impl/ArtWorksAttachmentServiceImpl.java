package com.golead.art.works.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
import com.golead.art.works.dao.ArtWorksAttachmentDao;
import com.golead.art.works.model.ArtWorksAttachment;
import com.golead.art.works.service.ArtWorksAttachmentService;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service;

@Service
public class ArtWorksAttachmentServiceImpl extends BaseServiceImpl implements ArtWorksAttachmentService {
	private static final long serialVersionUID = 1L;

	public ArtWorksAttachment getArtWorksAttachment(Serializable id) throws ServiceException {
		try {
			return artWorksAttachmentDao.get(id);
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

	public void createArtWorksAttachment(ArtWorksAttachment artWorksAttachment) throws ServiceException {
		try {
			artWorksAttachmentDao.save(artWorksAttachment);
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

	public void updateArtWorksAttachment(Map<String, String> artWorksAttachmentMap) throws ServiceException {
		try {
            Integer pkId = new Integer(artWorksAttachmentMap.get(ArtWorksAttachment.PROP_ID));
			ArtWorksAttachment tmp = artWorksAttachmentDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artWorksAttachmentMap, true);			
			artWorksAttachmentDao.update(tmp);
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

	public void deleteArtWorksAttachment(Serializable id) throws ServiceException {
		try {
			artWorksAttachmentDao.delete(id);
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

	public void deleteArtWorksAttachments(Serializable[] ids) throws ServiceException {
		try {
			artWorksAttachmentDao.deleteAll(ids);
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

	public PageQuery queryArtWorksAttachment(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artWorksAttachmentList", pageQuery);
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
      
      String artist = map.get("artist");
      if (artist != null && artist.trim().length() > 0) {
         paras += " AND artist.c_name like '%" + artist.trim() + "%'" 
               + " OR artist.e_name like '%" + artist.trim() + "%'";
      }
      
      String name = map.get("name");
      if (name != null && name.trim().length() > 0) {
         paras += " AND (works.works_c_name like '%" + name.trim() + "%'" 
               + " OR works.works_e_name like '%" + name.trim() + "%')";
      }

      String artType = map.get("artType");
      if (artType != null && artType.trim().length() > 0) {
         paras += " AND works.works_category = '" + artType.trim() + "'";
      }
      
      if (paras.length() > 0) page.getParameters().put("paras", paras);
   }
	
	public ArtWorksAttachment findByWorksId(Serializable id) throws ServiceException{
	   try {
	      List<ArtWorksAttachment> artWorksAttachments = artWorksAttachmentDao.findByField(ArtWorksAttachment.PROP_WORKS_ID, id);
	      if(artWorksAttachments.size() == 1){
	         return artWorksAttachments.get(0);
	      }
	      return null;
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
	
	public void deleteByWorksId(Serializable id) throws ServiceException{
	   try {
	      artWorksAttachmentDao.deleteByField(ArtWorksAttachment.PROP_WORKS_ID, id);
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
	
    @Resource
	private ArtWorksAttachmentDao	artWorksAttachmentDao;

	public void setArtWorksAttachmentDao(ArtWorksAttachmentDao artWorksAttachmentDao) {
		this.artWorksAttachmentDao = artWorksAttachmentDao;
	}
}

