package com.zzy.album.entity;

public class Album {
	int id;
	String name;
	String artist;
	String releaseDate;
	String description;
	String cover;

	public Album() {
	}

	public Album(int id, String name, String cover) {
		super();
		this.id = id;
		this.name = name;
		this.cover = cover;
	}
	
	public Album(int id, String artist, String releaseDate, String description) {
		this.id = id;
		this.artist = artist;
		this.releaseDate = releaseDate;
		this.description = description;
	}

	public Album(int id, String name, String artist, String releaseDate, String description, String cover) {
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.releaseDate = releaseDate;
		this.description = description;
		this.cover = cover;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

}
