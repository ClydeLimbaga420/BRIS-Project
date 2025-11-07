package com.BRIS.Login.repository;

import com.BRIS.Login.entity.NewBlotter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewBlotterRepository extends JpaRepository<NewBlotter, Long> {
}
