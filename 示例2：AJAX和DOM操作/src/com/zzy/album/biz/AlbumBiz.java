package com.zzy.album.biz;

import java.util.List;

import com.zzy.album.entity.Album;

public interface AlbumBiz {
	List<Album> getAllAlbum();
	Album getAlbumById(int id);
}
