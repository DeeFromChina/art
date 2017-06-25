package com.golead.art.auction.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.auction.model.ArtAuction;
import com.golead.art.auction.dao.ArtAuctionDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtAuctionDaoImpl extends HibernateDaoImpl<ArtAuction> implements ArtAuctionDao {

	public Class getReferenceClass() {
		return ArtAuction.class;
	}

	public ArtAuction cast(Object object) {
		return (ArtAuction) object;
	}

	public ArtAuction get(Serializable id)  throws DAOException{
		return (ArtAuction) super.get(id);
	}

	public ArtAuction load(Serializable id)  throws DAOException{
		return (ArtAuction) super.load(id);
	}

	public Serializable save(ArtAuction artAuction)  throws DAOException{
		return super.save(artAuction);
	}

	public void saveOrUpdate(ArtAuction artAuction)  throws DAOException{
		super.saveOrUpdate(artAuction);
	}

	public void update(ArtAuction artAuction)  throws DAOException{
		super.update(artAuction);
	}

	public void delete(ArtAuction artAuction)  throws DAOException{
		super.delete(artAuction);
	}

	public void refresh(ArtAuction artAuction)  throws DAOException{
		super.refresh(artAuction);
	}

	public String getTableName() {
		return ArtAuction.REF_TABLE;
	}
}
