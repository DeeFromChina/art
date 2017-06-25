package com.golead.art.wx.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

import com.golead.art.wx.dao.WxMenuButtonDao;
import com.golead.art.wx.model.WxMenuButton;
import com.golead.art.wx.service.WxMenuButtonService;
import javax.annotation.Resource; 
import org.springframework.stereotype.Service;

@Service
public class WxMenuButtonServiceImpl extends BaseServiceImpl implements WxMenuButtonService {
	private static final long serialVersionUID = 1L;

	public WxMenuButton getWxMenuButton(Serializable id) throws ServiceException {
		try {
			return wxMenuButtonDao.get(id);
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

	public void createWxMenuButton(WxMenuButton wxMenuButton) throws ServiceException {
		try {
			wxMenuButtonDao.save(wxMenuButton);
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

	public void updateWxMenuButton(Map<String, String> wxMenuButtonMap) throws ServiceException {
		try {
            Integer pkId = new Integer(wxMenuButtonMap.get(WxMenuButton.PROP_ID));
			WxMenuButton tmp = wxMenuButtonDao.get(pkId);
			ConvertUtil.mapToObject(tmp, wxMenuButtonMap, true);			
			wxMenuButtonDao.update(tmp);
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

	public void deleteWxMenuButton(Serializable id) throws ServiceException {
		try {
			wxMenuButtonDao.delete(id);
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

	public void deleteWxMenuButtons(Serializable[] ids) throws ServiceException {
		try {
			wxMenuButtonDao.deleteAll(ids);
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

	public PageQuery queryWxMenuButton(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("wxMenuButtonList", pageQuery);
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
	
    @Resource
	private WxMenuButtonDao	wxMenuButtonDao;

	public void setWxMenuButtonDao(WxMenuButtonDao wxMenuButtonDao) {
		this.wxMenuButtonDao = wxMenuButtonDao;
	}
}

