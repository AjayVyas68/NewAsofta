package com.example.demo.dashboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashBoardRepository extends JpaRepository<DashBoardModel,Integer> {

	

}
