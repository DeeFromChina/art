package com.golead.art.activity.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
import com.golead.art.activity.dao.ArtActivityExhibitArtistDao;
import com.golead.art.activity.model.ArtActivityExhibitArtist;
import com.golead.art.activity.service.ArtActivityExhibitArtistService;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service;

@Service
public class ArtActivityExhibitArtistServiceImpl extends BaseServiceImpl implements ArtActivityExhibitArtistService {
	private static final long serialVersionUID = 1L;

	public ArtActivityExhibitArtist getArtActivityExhibitArtist(Serializable id) throws ServiceException {
		try {
			return artActivityExhibitArtistDao.get(id);
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

	public void createArtActivityExhibitArtist(Integer id, int[] ids) throws ServiceException {
		try {
		   for(int i = 0; i<ids.length; i++){
		      ArtActivityExhibitArtist artActivityExhibitArtist = new ArtActivityExhibitArtist();
		      artActivityExhibitArtist.setExhibitId(id);
		      artActivityExhibitArtist.setArtistId(ids[i]);
		      artActivityExhibitArtistDao.save(artActivityExhibitArtist);
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

	public void updateArtActivityExhibitArtist(Map<String, String> artActivityExhibitArtistMap) throws ServiceException {
		try {
            Integer pkId = new Integer(artActivityExhibitArtistMap.get(ArtActivityExhibitArtist.PROP_ID));
			ArtActivityExhibitArtist tmp = artActivityExhibitArtistDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artActivityExhibitArtistMap, true);			
			artActivityExhibitArtistDao.update(tmp);
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

	public void deleteArtActivityExhibitArtist(Serializable id) throws ServiceException {
		try {
			artActivityExhibitArtistDao.delete(id);
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

	public void deleteArtActivityExhibitArtists(Serializable[] ids) throws ServiceException {
		try {
			artActivityExhibitArtistDao.deleteAll(ids);
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

	public PageQuery queryArtActivityExhibitArtist(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artActivityExhibitArtistList", pageQuery);
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

      String exhibitId = map.get("exhibitId");
      if (exhibitId != null && exhibitId.trim().length() > 0) {
         paras += " AND exhibit_artist.exhibit_id=" + exhibitId.trim();
      }
      
      String name = map.get("name");
      if (name != null && name.trim().length() > 0) {
         paras += " AND (artist.c_name like '%" + name.trim() + "%'" + " OR artist.e_name like '%" + name.trim() + "%')";
      }
      
      if (paras.length() > 0) page.getParameters().put("paras", paras);
	}
	
	public ArtActivityExhibitArtist findByExhibitId(Serializable id) throws ServiceException{
	   try {
         List<ArtActivityExhibitArtist> artActivityExhibitArtists = artActivityExhibitArtistDao.findByField(ArtActivityExhibitArtist.PROP_EXHIBIT_ID, id);
         if(artActivityExhibitArtists != null && artActivityExhibitArtists.size() > 0){
            return artActivityExhibitArtists.get(0);
         }
         return null;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
	}
	
    @Resource
	private ArtActivityExhibitArtistDao	artActivityExhibitArtistDao;

	public void setArtActivityExhibitArtistDao(ArtActivityExhibitArtistDao artActivityExhibitArtistDao) {
		this.artActivityExhibitArtistDao = artActivityExhibitArtistDao;
	}
}

