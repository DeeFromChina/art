package com.golead.art.artist.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
import com.golead.art.artist.dao.ArtCountryDao;
import com.golead.art.artist.model.ArtCountry;
import com.golead.art.artist.service.ArtCountryService;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service;

@Service
public class ArtCountryServiceImpl extends BaseServiceImpl implements ArtCountryService {
	private static final long serialVersionUID = 1L;

	public ArtCountry getArtCountry(Serializable id) throws ServiceException {
		try {
			return artCountryDao.get(id);
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

	public void createArtCountry(ArtCountry artCountry) throws ServiceException {
		try {
			artCountryDao.save(artCountry);
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

	public void updateArtCountry(Map<String, String> artCountryMap) throws ServiceException {
		try {
            Integer pkId = new Integer(artCountryMap.get(ArtCountry.PROP_ID));
			ArtCountry tmp = artCountryDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artCountryMap, true);			
			artCountryDao.update(tmp);
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

	public void deleteArtCountry(Serializable id) throws ServiceException {
		try {
			artCountryDao.delete(id);
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

	public void deleteArtCountrys(Serializable[] ids) throws ServiceException {
		try {
			artCountryDao.deleteAll(ids);
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

	public PageQuery queryArtCountry(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artCountryList", pageQuery);
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

      String countryName = map.get("countryName");
      if (countryName != null && countryName.trim().length() > 0) {
         paras += " AND country.country_name like '%" + countryName.trim() + "%'";
      }
      
      if (paras.length() > 0) page.getParameters().put("paras", paras);
	}
	
	public List<ArtCountry> findAll() throws ServiceException{
	   try {
         return artCountryDao.findAll();
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
	}
	
    @Resource
	private ArtCountryDao	artCountryDao;

	public void setArtCountryDao(ArtCountryDao artCountryDao) {
		this.artCountryDao = artCountryDao;
	}
}

