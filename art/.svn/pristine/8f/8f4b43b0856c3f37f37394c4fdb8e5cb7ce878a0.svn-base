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
import com.golead.art.works.dao.ArtMediumDao;
import com.golead.art.works.model.ArtMedium;
import com.golead.art.works.service.ArtMediumService;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service;

@Service
public class ArtMediumServiceImpl extends BaseServiceImpl implements ArtMediumService {
	private static final long serialVersionUID = 1L;
	
	private List<ArtMedium> findaArtMediums = new ArrayList<ArtMedium>();

	public ArtMedium getArtMedium(Serializable id) throws ServiceException {
		try {
			return artMediumDao.get(id);
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

	public void createArtMedium(ArtMedium artMedium) throws ServiceException {
		try {
			artMediumDao.save(artMedium);
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

	public void updateArtMedium(Map<String, String> artMediumMap) throws ServiceException {
		try {
         Integer pkId = new Integer(artMediumMap.get(ArtMedium.PROP_ID));
         artMediumMap.put("mediumNameCn", artMediumMap.get("chineseName"));
         artMediumMap.put("mediumNameEn", artMediumMap.get("englishName"));
			ArtMedium tmp = artMediumDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artMediumMap, true);			
			artMediumDao.update(tmp);
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

	public void deleteArtMedium(Serializable id) throws ServiceException {
		try {
			artMediumDao.delete(id);
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

	public void deleteArtMediums(Serializable[] ids) throws ServiceException {
		try {
			artMediumDao.deleteAll(ids);
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

	public PageQuery queryArtMedium(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artMediumList", pageQuery);
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
      
      String mediumCategory = map.get("mediumCategory");
      if (mediumCategory != null && mediumCategory.trim().length() > 0) {
         paras += " AND medium.medium_category = '" + mediumCategory.trim() + "'";
      }
      
      String upId = map.get("upId");
      if (upId != null && upId.trim().length() > 0) {
         paras += " AND medium.up_medium_id =" + upId.trim();
      }else if(upId == null){
         paras += " AND medium.up_medium_id IS NULL";
      }
      
      if (paras.length() > 0) page.getParameters().put("paras", paras);
	}
	
	public List<ArtMedium> findBySide(String side) throws ServiceException{
	   try {
         return artMediumDao.findByField(ArtMedium.PROP_MEDIUM_SIDE, side);
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
	
	public ArtMedium findByTreeCode(String treeCode) throws ServiceException{
	   try {
	      List<ArtMedium> artMediums = artMediumDao.findByField(ArtMedium.PROP_TREE_CODE, treeCode);
	      if(artMediums.size() == 1){
	         return artMediums.get(0);
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
	
	public List<ArtMedium> findAll() throws ServiceException{
	   try {
	      return artMediumDao.findAll();
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
	
	public List<ArtMedium> findByCategory(String category) throws ServiceException{
	   try {
         return artMediumDao.findByField(ArtMedium.PROP_MEDIUM_CATEGORY, category);
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
	
	public List<ArtMedium> findChild(Serializable id) throws ServiceException{
	   try {
	      findaArtMediums = new ArrayList<ArtMedium>();
	      List<ArtMedium> childArtMediums = new ArrayList<ArtMedium>();
	      childArtMediums = artMediumDao.findByField(ArtMedium.PROP_UP_MEDIUM_ID, id);
	      forChild(childArtMediums);
	      return findaArtMediums;
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
	
	private void forChild(List<ArtMedium> childArtMediums){
	   try {
	      List<ArtMedium> childArtMediums2 = new ArrayList<ArtMedium>();
	      for(ArtMedium artMedium : childArtMediums){
	         findaArtMediums.add(artMedium);
            List<ArtMedium> childArtMediums3 = artMediumDao.findByField(ArtMedium.PROP_UP_MEDIUM_ID, artMedium.getId());
            for(ArtMedium childArtMedium3 : childArtMediums3){
               childArtMediums2.add(childArtMedium3);//新的子
            }
         }
	      if(childArtMediums2.size() !=0){
	         forChild(childArtMediums2);
	      }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
	}
	
    @Resource
	private ArtMediumDao	artMediumDao;

	public void setArtMediumDao(ArtMediumDao artMediumDao) {
		this.artMediumDao = artMediumDao;
	}
}

