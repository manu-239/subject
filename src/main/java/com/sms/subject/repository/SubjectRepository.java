package com.sms.subject.repository;

import com.sms.subject.entity.Subject;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>
{

	Optional<Subject> findSubjectByName(String name);
}
