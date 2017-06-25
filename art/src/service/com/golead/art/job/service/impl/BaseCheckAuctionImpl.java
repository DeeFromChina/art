package com.golead.art.job.service.impl;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.golead.art.artist.dao.ArtArtistDao;
import com.golead.art.artist.dao.ArtCollectArtistDao;
import com.golead.art.auction.dao.ArtAuctionHousesDao;
import com.golead.art.auction.service.ArtAuctionService;

public class BaseCheckAuctionImpl implements ApplicationContextAware {

   private ApplicationContext applicationContext;

   public ApplicationContext getApplicationContext() {
      return applicationContext;
   }

   public void setApplicationContext(ApplicationContext applicationContext) {
      this.applicationContext = applicationContext;
   }

   @Resource
   protected ArtCollectArtistDao artCollectArtistDao;

   @Resource
   protected ArtArtistDao        artArtistDao;

   @Resource
   protected ArtAuctionService   artAuctiosService;

   @Resource
   protected ArtAuctionHousesDao artAuctionHousesDao;

}
