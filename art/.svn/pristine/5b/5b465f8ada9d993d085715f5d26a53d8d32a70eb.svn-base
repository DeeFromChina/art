package com.golead.art.works.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
import com.golead.art.works.dao.ArtWorksExhibitDao;
import com.golead.art.works.model.ArtWorksExhibit;
import com.golead.art.works.service.ArtWorksExhibitService;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service;

@Service
public class ArtWorksExhibitServiceImpl extends BaseServiceImpl implements ArtWorksExhibitService {
	private static final long serialVersionUID = 1L;

	public ArtWorksExhibit getArtWorksExhibit(Serializable id) throws ServiceException {
		try {
			return artWorksExhibitDao.get(id);
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

	public void createArtWorksExhibit(ArtWorksExhibit artWorksExhibit) throws ServiceException {
		try {
			artWorksExhibitDao.save(artWorksExhibit);
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
	
	public void createArtWorksExhibit(int worksId, int[] exhibitId) throws ServiceException{
	   try {
         for(int i = 0; i<exhibitId.length; i++){
            ArtWorksExhibit artWorksExhibit = new ArtWorksExhibit();
            artWorksExhibit.setWorksId(worksId);
            artWorksExhibit.setExhibitId(exhibitId[i]);
            createArtWorksExhibit(artWorksExhibit);
         }
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
	}
	
	public void createArtWorksExhibit2(int exhibitId, int[] worksId) throws ServiceException{
	   try {
	      for(int i = 0; i<worksId.length; i++){
	         ArtWorksExhibit artWorksExhibit = new ArtWorksExhibit();
	         artWorksExhibit.setWorksId(worksId[i]);
	         artWorksExhibit.setExhibitId(exhibitId);
	         createArtWorksExhibit(artWorksExhibit);
	      }
	   }
	   catch (Exception e) {
	      e.printStackTrace();
	      throw new ServiceException("系统错误。");
	   }
	}

	public void updateArtWorksExhibit(Map<String, String> artWorksExhibitMap) throws ServiceException {
		try {
            Integer pkId = new Integer(artWorksExhibitMap.get(ArtWorksExhibit.PROP_ID));
			ArtWorksExhibit tmp = artWorksExhibitDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artWorksExhibitMap, true);			
			artWorksExhibitDao.update(tmp);
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

	public void deleteArtWorksExhibit(Serializable id) throws ServiceException {
		try {
			artWorksExhibitDao.delete(id);
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

	public void deleteArtWorksExhibits(Serializable[] ids) throws ServiceException {
		try {
			artWorksExhibitDao.deleteAll(ids);
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
	
	public String findArtistNameByExhibit(String id) throws ServiceException{
	   try {
         String sql = "SELECT artist.c_name as name FROM art_activity_exhibit_artist eartist "
               + " LEFT JOIN art_artist artist ON artist.id = eartist.artist_id "
               + " WHERE eartist.exhibit_id=" + id
               + " GROUP BY artist.c_name ";
         List<Map<String, Object>> list = jdbcDao.queryBySql(sql);
         if(list == null || list.size() < 1){
            return "";
         }
         String name = "";
         for(Map<String, Object> map : list){
            if(map.get("name") != null){
               if(name.length() > 0){
                  name+=",";
               }
               name+=map.get("name").toString();
            }
         }
         return name;
      }
	   catch (DAOException e) {
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

	public PageQuery queryArtWorksExhibit(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artWorksExhibitList", pageQuery);
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
         paras += " AND exhibit.works_id=" + worksId.trim();
      }
      
      String exhibitId = map.get("exhibitId");
      if (exhibitId != null && exhibitId.trim().length() > 0) {
         paras += " AND exhibit.exhibit_id=" + exhibitId.trim();
      }
      
      String exhibitName = map.get("exhibitName");
      if (exhibitName != null && exhibitName.trim().length() > 0) {
         paras += " AND activity.exhibit_name LIKE '%" + exhibitName.trim() + "%'";
      }
      
      String worksName = map.get("worksName");
      if (worksName != null && worksName.trim().length() > 0) {
         paras += " AND (works.works_c_name LIKE '%" + worksName.trim() + "%'"
               + " OR works.works_e_name LIKE '%" + worksName.trim() + "%')";
      }
      
      String artistName = map.get("artistName");
      if (artistName != null && artistName.trim().length() > 0) {
         paras += " AND (artist.c_name LIKE '%" + artistName.trim() + "%'"
               + " OR artist.e_name LIKE '%" + artistName.trim() + "%') ";
      }
      
//      String type = map.get("type");
//      if (type != null && type.trim().length() > 0) {
//         paras += " AND activity.exhib_type=" + type.trim();
//      }
      
      if (paras.length() > 0) page.getParameters().put("paras", paras);
	}
	
    @Resource
	private ArtWorksExhibitDao	artWorksExhibitDao;

	public void setArtWorksExhibitDao(ArtWorksExhibitDao artWorksExhibitDao) {
		this.artWorksExhibitDao = artWorksExhibitDao;
	}
}

