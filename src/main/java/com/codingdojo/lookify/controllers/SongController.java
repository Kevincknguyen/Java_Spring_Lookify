package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class SongController {

	
	@Autowired
	SongService songSer;
	
	
	
	@GetMapping("/")
	public String splash() {
		return "Home.jsp";
	}
	
	
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		
		List<Song> allSongs=songSer.allSongs();
		model.addAttribute("allSongs",allSongs);
		return "Dashboard.jsp";
	}
	
	
	@GetMapping("/search/topTen")
	public String topTen(Model model) {
		model.addAttribute("results",songSer.topten());
		return "Search.jsp";
		
		
	}
	
	@GetMapping("/search/")
	public String search(@RequestParam(value="name")String name, Model model) {
		
		System.out.println(name);
		model.addAttribute("results",songSer.search(name));
		System.out.println(songSer.search(name));
		return "Search.jsp";
		
	}
	
	@GetMapping("/songs/new")
	public String createNewPage(Model model,@ModelAttribute("song") Song song, BindingResult result) {
			return "New.jsp";
		
	}
	
	@DeleteMapping("/api/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		songSer.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/api/create")
		public String create(Model model, @Valid @ModelAttribute("song") Song song, BindingResult result) {
			if (result.hasErrors()) {
				return "New.jsp";
			}
			songSer.createSong(song);
			return "redirect:/dashboard";
		}
	
	
	
	
	}
	

