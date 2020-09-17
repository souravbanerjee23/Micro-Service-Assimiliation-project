package com.cognizant.project.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.project.model.TrainDetails;

@FeignClient(name = "available-train-service")
public interface TrainFeignClient {

	@GetMapping("trains")
	public List<TrainDetails> getAllTrains();

	@GetMapping("trains/{id}")
	public TrainDetails findByTrainId(@PathVariable Long id);

	@PostMapping("trains/add")
	public TrainDetails createTrain(@RequestBody TrainDetails train);

	@PutMapping("trains/{id}")
	public TrainDetails updateTrainModel(@RequestBody TrainDetails newTrain, @PathVariable Long id);

	@DeleteMapping(path = "trains/{id}")
	public String deleteTrain(@PathVariable Long id);
}
