package com.golead.art.auction.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.auction.model.ArtAuctionVideo;
import com.golead.art.auction.dao.ArtAuctionVideoDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtAuctionVideoDaoImpl extends HibernateDaoImpl<ArtAuctionVideo> implements ArtAuctionVideoDao {

	public Class getReferenceClass() {
		return ArtAuctionVideo.class;
	}

	public ArtAuctionVideo cast(Object object) {
		return (ArtAuctionVideo) object;
	}

	public ArtAuctionVideo get(Serializable id)  throws DAOException{
		return (ArtAuctionVideo) super.get(id);
	}

	public ArtAuctionVideo load(Serializable id)  throws DAOException{
		return (ArtAuctionVideo) super.load(id);
	}

	public Serializable save(ArtAuctionVideo artAuctionVideo)  throws DAOException{
		return super.save(artAuctionVideo);
	}

	public void saveOrUpdate(ArtAuctionVideo artAuctionVideo)  throws DAOException{
		super.saveOrUpdate(artAuctionVideo);
	}

	public void update(ArtAuctionVideo artAuctionVideo)  throws DAOException{
		super.update(artAuctionVideo);
	}

	public void delete(ArtAuctionVideo artAuctionVideo)  throws DAOException{
		super.delete(artAuctionVideo);
	}

	public void refresh(ArtAuctionVideo artAuctionVideo)  throws DAOException{
		super.refresh(artAuctionVideo);
	}

	public String getTableName() {
		return ArtAuctionVideo.REF_TABLE;
	}
}
