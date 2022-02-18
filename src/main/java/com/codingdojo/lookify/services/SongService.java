package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	private final SongRepository songRep;
	
	public SongService(SongRepository songRep) {
		this.songRep=songRep;
	}

	
	public List<Song> allSongs(){
		return songRep.findAll();
	}
	
	
	public Song createSong(Song s) {
		return songRep.save(s);
	}
	
	
	public List<Song> topten(){
		return songRep.findTop10ByOrderByRatingDesc();
	}
	
	
	public List<Song> search(String search){
		List<Song> results=songRep.findByArtistContaining(search);
		results.addAll(songRep.findByNameContaining(search));
//		List<Song> results=songRep.findByNameContaining(search);
//		List<Song> results=songRep.findAll();
		return results;
		
	}
	
	public String deleteSong(Long id) {
		Optional<Song> isSong=songRep.findById(id);
		if(isSong.isPresent()) {
			songRep.deleteById(id);
			return "Completed delete";
		}
		else return "Nothing to delete";
	}
}
