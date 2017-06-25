package com.golead.common.service.login;

import com.golead.core.exception.ServiceException;
import com.golead.core.web.UserSession;

public interface LoginService {
   
   public UserSession login(String accountName, String password) throws ServiceException;
   
   public UserSession appLogin(String accountName, String password) throws ServiceException;
   
   public void changeProperty(Integer id,String key,String value) throws ServiceException;
}
