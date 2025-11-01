package com.BRIS.Login.repository;

import com.BRIS.Login.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {

    @Query("SELECT r FROM Resident r " +
            "WHERE LOWER(r.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(r.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(r.sitio) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR STR(r.id) LIKE CONCAT('%', :keyword, '%')")
    List<Resident> searchByKeyword(@Param("keyword") String keyword);
}
