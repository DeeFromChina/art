package com.golead.art.auction.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.auction.model.ArtAuctionHouses;
import com.golead.art.auction.dao.ArtAuctionHousesDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtAuctionHousesDaoImpl extends HibernateDaoImpl<ArtAuctionHouses> implements ArtAuctionHousesDao {

	public Class getReferenceClass() {
		return ArtAuctionHouses.class;
	}

	public ArtAuctionHouses cast(Object object) {
		return (ArtAuctionHouses) object;
	}

	public ArtAuctionHouses get(Serializable id)  throws DAOException{
		return (ArtAuctionHouses) super.get(id);
	}

	public ArtAuctionHouses load(Serializable id)  throws DAOException{
		return (ArtAuctionHouses) super.load(id);
	}

	public Serializable save(ArtAuctionHouses artAuctionHouses)  throws DAOException{
		return super.save(artAuctionHouses);
	}

	public void saveOrUpdate(ArtAuctionHouses artAuctionHouses)  throws DAOException{
		super.saveOrUpdate(artAuctionHouses);
	}

	public void update(ArtAuctionHouses artAuctionHouses)  throws DAOException{
		super.update(artAuctionHouses);
	}

	public void delete(ArtAuctionHouses artAuctionHouses)  throws DAOException{
		super.delete(artAuctionHouses);
	}

	public void refresh(ArtAuctionHouses artAuctionHouses)  throws DAOException{
		super.refresh(artAuctionHouses);
	}

	public String getTableName() {
		return ArtAuctionHouses.REF_TABLE;
	}
}
