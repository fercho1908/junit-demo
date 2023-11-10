package com.jdt.itcg.demo.repositories;

import com.jdt.itcg.demo.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
