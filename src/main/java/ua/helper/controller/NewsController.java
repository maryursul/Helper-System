package ua.helper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.helper.domain.NewsDTO;
import ua.helper.service.NewsService;

@RestController
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody NewsDTO dto){
		newsService.save(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<NewsDTO>> findAll(){
		List<NewsDTO> dto = newsService.findAllNews();
		return new ResponseEntity<List<NewsDTO>>(dto , HttpStatus.OK);
	}
	@GetMapping("/{newsId}")
	public ResponseEntity<NewsDTO> findById(@PathVariable("newsId") Long id){
		NewsDTO dto = newsService.findByid(id);
		return new ResponseEntity<NewsDTO>(dto , HttpStatus.OK);
	}
	@PutMapping("/update/{newsId}")
	public ResponseEntity<Void> update(@PathVariable("newsId") Long id , @RequestBody NewsDTO dto){
		NewsDTO dtofromDB = newsService.findByid(id);
		if(dtofromDB != null) {
			dto.setId(id);
			newsService.update(dto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/delete/{newsId}")
	public ResponseEntity<NewsDTO> delete(@PathVariable("newsId") Long id){
		NewsDTO dto = newsService.findByid(id);
		if(dto != null) {
			newsService.delete(id);
			return new ResponseEntity<NewsDTO>(dto , HttpStatus.OK);
		}
		return new ResponseEntity<NewsDTO>(dto , HttpStatus.NOT_FOUND);
	}
	@GetMapping("/sport")
	public ResponseEntity<List<NewsDTO>> findSport(){
		List<NewsDTO> dto = newsService.findSport();
		
		return new ResponseEntity<List<NewsDTO>>(dto , HttpStatus.OK);
	}
	@GetMapping("/politics")
	public ResponseEntity<List<NewsDTO>> findPolitics(){
		List<NewsDTO> dto = newsService.findPolitics();
		
		return new ResponseEntity<List<NewsDTO>>(dto , HttpStatus.OK);
	}
	@GetMapping("/culture")
	public ResponseEntity<List<NewsDTO>> findCulture(){
		List<NewsDTO> dto = newsService.findCulture();
		
		return new ResponseEntity<List<NewsDTO>>(dto , HttpStatus.OK);
	}
}
