package com.example.demo.machine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Machine.MachineModel;

@Repository
public interface MachineRepository extends JpaRepository<MachineModel, Long>{

		@Query("select m from MachineModel m where m.status = false")
		public List<MachineModel> findByStatusdeactive();
		@Query("select m from MachineModel m where m.status = true")
		public List<MachineModel> findByStatusactive();


}
