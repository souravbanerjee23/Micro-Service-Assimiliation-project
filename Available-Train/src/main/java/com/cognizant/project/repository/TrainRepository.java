package com.cognizant.project.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.project.model.TrainDetails;

@Repository
public interface TrainRepository extends JpaRepository<TrainDetails, Integer> {

	@Query(value = "select * from train where train_id=:id", nativeQuery = true)
	public TrainDetails findById(@Param("id") Long id);

	@Modifying
	@Transactional
	@Query(value = "delete from train  WHERE train_id = :id", nativeQuery = true)
	public void deleteById(@Param("id") Long id);

}
