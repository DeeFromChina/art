package com.golead.art.literature.service;

import java.io.Serializable;
import java.util.Map;

import com.golead.art.literature.analyzer.FullIndexPagination;
import com.golead.core.dao.model.PageQuery;

public interface SearchEngineService extends Serializable{

	public  FullIndexPagination searchTalent(Map<String, String> queryStrs,int pageNo,int pageSize);
	
	public  FullIndexPagination searchTalent(PageQuery pq,int pageNo,int pageSize);
}
