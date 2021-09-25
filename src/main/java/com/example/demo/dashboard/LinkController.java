package com.example.demo.dashboard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/link")
public class LinkController {
	@Autowired
	LinkService linkRepository;
	@PostMapping(value = "/save")
	public ResponseEntity<LinkModel> SaveDataLink(@RequestBody LinkModel linkmodel) throws Exception
	{
		return ResponseEntity.ok(linkRepository.linkmodel(linkmodel));
	}
	@GetMapping(value = "/find")
	public ResponseEntity<List<LinkModel>> FindAllData(@ModelAttribute LinkModel linkmodel)
	{
		return ResponseEntity.ok(linkRepository.GetAllDAta(linkmodel));
	}
	@GetMapping(value = "/find/{id}")
	public ResponseEntity<Optional<LinkModel>> FindAllData(@PathVariable int id)
	{
		return ResponseEntity.ok(linkRepository.FindById(id));
	}
//	@GetMapping(value = "/sta/{status}/{status1}")
//	public ResponseEntity<List<LinkModel>> findStatus(@PathVariable int status ,@PathVariable int status1)
//	{
//		return ResponseEntity.ok(linkRepository.findByStatus(status, status1));
//	}
}
