package com.sms.subject.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sms.subject.entity.QSubject;
import com.sms.subject.entity.Subject;
import com.sms.subject.repository.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.StringTokenizer;

import static java.text.MessageFormat.format;
import static org.apache.commons.lang3.StringUtils.trim;

@Service
public class SubjectService
{
	private static final Logger log = LoggerFactory.getLogger(SubjectService.class);

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	JPAQueryFactory queryFactory;

	public Subject saveSubject(Subject subject)
	{
		return subjectRepository.save(subject);
	}

	public List<Subject> findAllSubject()
	{
		return subjectRepository.findAll();
	}

	public void deleteById(Long id)
	{
		Subject subject = subjectRepository.findById(id).orElseThrow(RuntimeException::new);
		subjectRepository.delete(subject);
	}

	public void deleteByName(String name)
	{
		Subject subject = subjectRepository.findSubjectByName(name).orElseThrow(RuntimeException::new);
		subjectRepository.delete(subject);
	}

	public Subject findSubjectByName(String name)
	{
		return subjectRepository.findSubjectByName(name).orElseThrow(RuntimeException::new);
	}

	public List<Subject> findSubject(String name, String description)
	{
		log.info(format("Name: {0} and description: {1}", name, description));
		QSubject subject = QSubject.subject;
		BooleanBuilder descriptionPredicate = new BooleanBuilder();
		BooleanBuilder namePredicate = new BooleanBuilder();
		if(name != null){
			StringTokenizer stringTokenizer = new StringTokenizer(name, ",");
			stringTokenizer.asIterator().forEachRemaining(s -> namePredicate.or(subject.name.eq(trim(s.toString()))));
		}
		if(description != null){
			StringTokenizer stringTokenizer = new StringTokenizer(description, ",");
			stringTokenizer.asIterator().forEachRemaining(s -> descriptionPredicate.or(subject.description.eq(trim(s.toString()))));
		}
		return queryFactory.selectFrom(subject).where(namePredicate.and(descriptionPredicate)).fetch();
	}
}
