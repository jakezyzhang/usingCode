package com.zzy.album.biz.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.zzy.album.biz.AlbumBiz;
import com.zzy.album.biz.util.BizUtil;
import com.zzy.album.dao.AlbumDao;
import com.zzy.album.entity.Album;
import com.zzy.dao.base.BaseDao;

public class AlbumBizImpl implements AlbumBiz{
	
	static final int MAX_DESCRIPTION_LENGTH = 80; 

	@Override
	public List<Album> getAllAlbum() {
		AlbumDao albumDao = null;
		try {
			albumDao = (AlbumDao) BizUtil.getDialectedDao(AlbumDao.class);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(albumDao != null) {
			List<Album> allAlbumBrief = albumDao.getAllAlbumBrief();
			return allAlbumBrief;
		}
		
		return null;
	}

	@Override
	public Album getAlbumById(int id) {
		AlbumDao albumDao = null;
		try {
			albumDao = (AlbumDao) BizUtil.getDialectedDao(AlbumDao.class);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(albumDao != null) {
			Album album = albumDao.getAlbumDetailById(id);
			
			String description = album.getDescription();
			
			if(description.length() > MAX_DESCRIPTION_LENGTH) {
				album.setDescription(description.substring(0, MAX_DESCRIPTION_LENGTH - 3) + "...");
			}
			
			return album;
		}
		return null;
	}

}
