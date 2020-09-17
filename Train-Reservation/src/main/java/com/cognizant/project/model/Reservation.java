package com.cognizant.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@Entity
@IdClass(UserId.class)
@Table(name = "reserve")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Reservation {

	@Column(name = "user_id")
	@Id
	@NotNull(message = "user-id can not be null")
	private Long userId;

	@Id
	@Column(name = "train_id")
	@NotNull(message = "train-id can not be null")
	private Long trainId;

}
