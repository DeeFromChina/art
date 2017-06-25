package com.golead.art.auction.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.auction.model.ArtAuctionExchange;
import com.golead.art.auction.dao.ArtAuctionExchangeDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtAuctionExchangeDaoImpl extends HibernateDaoImpl<ArtAuctionExchange> implements ArtAuctionExchangeDao {

	public Class getReferenceClass() {
		return ArtAuctionExchange.class;
	}

	public ArtAuctionExchange cast(Object object) {
		return (ArtAuctionExchange) object;
	}

	public ArtAuctionExchange get(Serializable id)  throws DAOException{
		return (ArtAuctionExchange) super.get(id);
	}

	public ArtAuctionExchange load(Serializable id)  throws DAOException{
		return (ArtAuctionExchange) super.load(id);
	}

	public Serializable save(ArtAuctionExchange artAuctionExchange)  throws DAOException{
		return super.save(artAuctionExchange);
	}

	public void saveOrUpdate(ArtAuctionExchange artAuctionExchange)  throws DAOException{
		super.saveOrUpdate(artAuctionExchange);
	}

	public void update(ArtAuctionExchange artAuctionExchange)  throws DAOException{
		super.update(artAuctionExchange);
	}

	public void delete(ArtAuctionExchange artAuctionExchange)  throws DAOException{
		super.delete(artAuctionExchange);
	}

	public void refresh(ArtAuctionExchange artAuctionExchange)  throws DAOException{
		super.refresh(artAuctionExchange);
	}

	public String getTableName() {
		return ArtAuctionExchange.REF_TABLE;
	}
}
