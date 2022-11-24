package com.example.delivery.courier;

import com.example.delivery.city.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Integer> {

    //find free couriers in city
    @Query("select c from Courier c inner join Address a on c.location = a  " +
            " where a.city = :city and c.busy=false ")
    List<Courier> findCourierByLocation(City city);
}
