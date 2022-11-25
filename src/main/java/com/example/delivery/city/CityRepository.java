package com.example.delivery.city;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    @Query("select new com.example.delivery.city.CityResponseDto(c.id,c.name) from City c")
    Page<CityResponseDto> getAllCities(int page,int size);
}
