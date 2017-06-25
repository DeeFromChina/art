package com.golead.art.app.service;

import java.util.List;
import java.util.Map;

import com.golead.core.exception.ServiceException;

public interface PictureFristService {

   public List<Map<String, Object>> pictureShow(Map<String, String> parameters) throws ServiceException;
}
