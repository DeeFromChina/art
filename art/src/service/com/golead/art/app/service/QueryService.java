package com.golead.art.app.service;

import java.util.Map;

import com.golead.core.exception.ServiceException;

public interface QueryService {

   public String sreachData(Map<String, String> parameters) throws ServiceException;

}
