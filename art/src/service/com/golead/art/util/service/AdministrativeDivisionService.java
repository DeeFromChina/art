package com.golead.art.util.service;

import java.util.List;
import java.util.Map;

import com.golead.core.exception.ServiceException;

/**
 * 行政区划
 * @author 尹湘
 * @version 1.0
 * @since  2016年7月15日 下午3:51:36
 */
public interface AdministrativeDivisionService {
   
   /**
    * 查询所有省份
    * @return
    * @throws ServiceException
    */
   public List<Map<String, Object>> findAllProvince() throws ServiceException;
   
   
   /**
    * 查询所有城市
    * @return
    * @throws ServiceException
    */
   public List<Map<String, Object>> findAllCity() throws ServiceException;
   
   /**
    * 查询所有区县 
    * @return
    * @throws ServiceException
    */
   public List<Map<String, Object>> findAllCounty() throws ServiceException;
   
   /**
    * 根据省份编码查询该省份所有城市
    * @return
    * @throws ServiceException
    */
   public List<Map<String, Object>> findCityByParentCode(String parentCode) throws ServiceException;
   
   /**
    * 根据城市编码查询该城市所有区县 
    * @return
    * @throws ServiceException
    */
   public List<Map<String, Object>> findCountyByParentCode(String parentCode) throws ServiceException;
   
   
   public List<Map<String, Object>> findNameByCode(String code) throws ServiceException;
   
   
   public List<Map<String, Object>> findMunicipalityOrAreaOrCounty(String code) throws ServiceException;
   
   public List<Map<String, Object>> findMunicipalityOrAreaOrCountyByParentCode(String code) throws ServiceException;
   
   public List<Map<String, Object>> findCodeByName(String name) throws ServiceException;
   
   
}
