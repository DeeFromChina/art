package com.golead.art.wx.service;

import java.io.Serializable;
import java.util.Map;
import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;

import com.golead.art.wx.model.WxMenuButton;

public interface WxMenuButtonService {

	public WxMenuButton getWxMenuButton(Serializable id) throws ServiceException;

	public void createWxMenuButton(WxMenuButton wxMenuButton) throws ServiceException;

	public void updateWxMenuButton(Map<String, String> wxMenuButtonMap) throws ServiceException;

	public void deleteWxMenuButton(Serializable id) throws ServiceException;

	public PageQuery queryWxMenuButton(PageQuery pageQuery) throws ServiceException;

	public void deleteWxMenuButtons(Serializable[] ids) throws ServiceException;  
}

