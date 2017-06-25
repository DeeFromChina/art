package com.golead.art.auction.dao.impl;

import java.io.Serializable;
import com.golead.core.exception.DAOException;
import com.golead.core.dao.impl.HibernateDaoImpl;
import com.golead.art.auction.model.ArtAuctionWords;
import com.golead.art.auction.dao.ArtAuctionWordsDao;
import org.springframework.stereotype.Repository;

@Repository
public class ArtAuctionWordsDaoImpl extends HibernateDaoImpl<ArtAuctionWords> implements ArtAuctionWordsDao {

	public Class getReferenceClass() {
		return ArtAuctionWords.class;
	}

	public ArtAuctionWords cast(Object object) {
		return (ArtAuctionWords) object;
	}

	public ArtAuctionWords get(Serializable id)  throws DAOException{
		return (ArtAuctionWords) super.get(id);
	}

	public ArtAuctionWords load(Serializable id)  throws DAOException{
		return (ArtAuctionWords) super.load(id);
	}

	public Serializable save(ArtAuctionWords artAuctionWords)  throws DAOException{
		return super.save(artAuctionWords);
	}

	public void saveOrUpdate(ArtAuctionWords artAuctionWords)  throws DAOException{
		super.saveOrUpdate(artAuctionWords);
	}

	public void update(ArtAuctionWords artAuctionWords)  throws DAOException{
		super.update(artAuctionWords);
	}

	public void delete(ArtAuctionWords artAuctionWords)  throws DAOException{
		super.delete(artAuctionWords);
	}

	public void refresh(ArtAuctionWords artAuctionWords)  throws DAOException{
		super.refresh(artAuctionWords);
	}

	public String getTableName() {
		return ArtAuctionWords.REF_TABLE;
	}
}
