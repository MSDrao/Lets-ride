package com.nxtwave.assignment.repository;

import com.nxtwave.assignment.entity.Ride;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Integer>,
        PagingAndSortingRepository<Ride, Integer> {
    @Query(value = "SELECT * FROM RIDE_TBL n WHERE n.from_location = ?1 AND n.to_location = ?2 AND n.start_date = ?3 AND n.status = ?4", nativeQuery = true)
    List<Ride> findMatchingRidersInfo(
            String fromLocation,
            String toLocation,
            Date startDate,
            String status);

//    @Query(value = "SELECT * FROM RIDE_TBL n WHERE n.from_location = ?1 AND n.to_location = ?2 AND n.start_date = ?3 AND n.status = ?4",
//            countQuery = "SELECT count(*) FROM RIDE_TBL n WHERE n.from_location = ?1 AND n.to_location = ?2 AND n.start_date = ?3 AND n.status = ?4"
//            ,nativeQuery = true)
//    Page<Ride> findMatchingRidersPage(
//            String fromLocation,
//            String toLocation,
//            Date startDate,getMatchingTransportationRequests
//            String status,
//            Pageable pageable);

    Page<Ride> findByFromLocationAndToLocationAndStartDateAndStatus(String fromLocation,
                                                                    String toLocation,
                                                                    Date startDate,
                                                                    String status,
                                                                    Pageable pageable);
}
