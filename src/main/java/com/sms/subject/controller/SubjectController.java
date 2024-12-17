package com.sms.subject.controller;

import com.sms.subject.entity.Subject;
import com.sms.subject.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SubjectController
{

	private static final Logger log = LoggerFactory.getLogger(SubjectController.class);

	@Autowired
	SubjectService subjectService;

	@PostMapping("/subject")
	public ResponseEntity<?> saveSubject(@RequestBody Subject subject)
	{
		Subject res = subjectService.saveSubject(subject);
		return ResponseEntity.ok(res);
	}

	@GetMapping("/subject")
	public ResponseEntity<?> findSubject(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "description", required = false) String description)
	{
		List<Subject> res = subjectService.findSubject(name,description);
		log.info("Subjects ->" + res.stream().map(Subject::getName).collect(Collectors.joining(",")));
		return ResponseEntity.ok(res);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id)
	{
		subjectService.deleteById(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@DeleteMapping("/{name}")
	public ResponseEntity<?> deleteByName(@PathVariable("name") String name)
	{
		subjectService.deleteByName(name);
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
