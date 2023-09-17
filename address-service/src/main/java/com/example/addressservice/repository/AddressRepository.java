package com.example.addressservice.repository;

import com.example.addressservice.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(
            value = "SELECT * FROM addresses a WHERE a.id = :id",
            nativeQuery = true)
    Address findAddressByEmployeeId(@Param("id") Long id);
}
