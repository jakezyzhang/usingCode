package com.zzy.album.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzy.album.dao.AlbumDao;
import com.zzy.album.entity.Album;
import com.zzy.dao.base.BaseDao;
import com.zzy.dao.base.RSProcessor;

public class AlbumDaoImpl extends BaseDao implements AlbumDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> getAllAlbumBrief() {
		String sql = "select id, name, cover from album";
		
		RSProcessor albumRS = new RSProcessor() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				List<Album> albumList = new ArrayList<Album>();
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String cover = rs.getString("cover");
					
					Album album = new Album(id, name, cover);
					albumList.add(album);
				}
				
				return albumList;
			}
		};
		
		return (List<Album>) executeQuery(albumRS, sql);
	}

	@Override
	public Album getAlbumDetailById(int id) {
		String sql = "select artist, releaseDate, description from album where id = ?";

		RSProcessor albumRS = new RSProcessor() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				Album album = null;
				if(rs.next()) {
					String artist = rs.getString("artist");
					String releaseDate = rs.getString("releaseDate");
					String description = rs.getString("description");
					
					album = new Album(id, artist, releaseDate, description);
				}
				
				return album;
			}

		};
		
		return (Album)executeQuery(albumRS, sql, id);
	}

}
