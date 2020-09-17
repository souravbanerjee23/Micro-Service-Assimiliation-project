package com.cognizant.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.project.model.Reservation;

@Transactional
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	@Modifying
	@Query(value = "insert into reserve(train_id,user_id) values(?1,?2)", nativeQuery = true)
	public int reserveTickets(@Param("trainid") Long trainId, @Param("userid") Long userId);

	@Query(value = "select * from reserve r where r.user_id=:userId", nativeQuery = true)
	public Reservation findById(@Param("userId") Long userid);

	@Modifying
	@Query(value = "delete from reserve  WHERE user_id = :userId", nativeQuery = true)
	public void deleteById(@Param("userId") Long userId);

}
