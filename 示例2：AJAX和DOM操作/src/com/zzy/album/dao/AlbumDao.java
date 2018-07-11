package com.zzy.album.dao;

import java.util.List;

import com.zzy.album.entity.Album;

public interface AlbumDao {
	List<Album> getAllAlbumBrief();
	Album getAlbumDetailById(int id);
}
