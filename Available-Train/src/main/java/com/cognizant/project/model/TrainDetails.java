package com.cognizant.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@Entity
@Table(name = "train")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainDetails {

	@Id

	@Column(name = "train_id", nullable = false)
	@NotNull(message = "Train-Id can not be null")
	private Long ID;

	@Column(name = "train_name")
	@NotNull(message = "Train-Name can not be null")

	private String name;

	@Column(name = "start")
	@NotNull(message = "Starting Station can not be null")
	private String startingStation;

	@Column(name = "end")
	@NotNull(message = "Ending Station can not be null")

	private String endingStation;

}
