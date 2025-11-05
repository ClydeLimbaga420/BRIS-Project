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
            "WHERE LOWER(CONCAT(r.firstName, ' ', r.lastName)) LIKE LOWER(CONCAT('%', :keyword, '%'))" +
            "OR LOWER(r.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(r.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(r.sitio) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(r.sex) = LOWER(:keyword) " +
            "OR CAST(r.id AS string) LIKE CONCAT('%', :keyword, '%')")
    List<Resident> searchByKeyword(@Param("keyword") String keyword);
}
