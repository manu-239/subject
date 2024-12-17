package com.sms.subject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Subject implements Serializable
{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_seq")
	@SequenceGenerator(name = "subject_seq", sequenceName = "subject_sequence", allocationSize = 1)
	private Long id;

	@Column(length = 50, unique = true)
	private String name;

	@Column(length = 250)
	private String description;
}
