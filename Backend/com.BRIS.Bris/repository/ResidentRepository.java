package com.BRIS.Login.repository;

import com.BRIS.Login.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {

    // These names refer to your entity fields (firstName and lastName)
    List<Resident> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrSitioContainingIgnoreCase(String firstName, String lastName, String sitio);
}
