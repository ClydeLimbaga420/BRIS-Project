package com.BRIS.Login.repository;

import com.BRIS.Login.entity.NewResident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewResidentRepository extends JpaRepository<NewResident, Long> {
}
