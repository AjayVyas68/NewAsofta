package com.example.demo.machine.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.machine.model.MachineModel;
import com.example.demo.user.Repository.UserRepository;
import com.example.demo.machine.repository.MachineRepository;
import com.example.demo.machine.service.MachineService;
import com.example.demo.user.model.User;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/machine")
public class MachineController {

	@Autowired
	MachineService machineService;
	@Autowired
	MachineRepository machinerepository;
	@Autowired
	UserRepository userrepository;

	@PostMapping(value = "/create")
	public ResponseEntity<MachineModel> SaveMAchine(@RequestBody MachineModel machinemodel) throws Exception {
		return ResponseEntity.ok(machineService.MachineSave(machinemodel));
	}

	@GetMapping(value = "/{id}")
	public Optional<MachineModel> GetIdData(@PathVariable Long id) {
		return machineService.FindById(id);
	}

	@PutMapping("/update/{id}")
	public MachineModel UpdateData(@PathVariable Long id, @RequestBody MachineModel machinemodel) {
		return this.machineService.UpdateMachine(id, machinemodel);
	}
	@PutMapping(value = "updatemachine/{id}")
	public MachineModel MachineAllocation(@PathVariable Long id, @RequestBody MachineModel machinemodel) {
		return this.machineService.UpdateMachineAllocation(id, machinemodel);
	}

	@DeleteMapping("/delete/{id}")
	public void deletedata(@PathVariable Long id) {
		machineService.machinemodeldelete(id);
	}

	@GetMapping(value = "/findall")
	public List<MachineModel> GetIdData() {
		List<MachineModel> machine= machineService.findAllData();
		return  machine;
	}

	@GetMapping(value = "/find")
	public ResponseEntity<?> FindByStatus() {
		return ResponseEntity.ok(machineService.findBystatusdeactive());

	}

	@PostMapping(value = "/findget")
	public ResponseEntity<?> FindByStatusw() {
		return ResponseEntity.ok(machineService.findBystatusactive());

	}

	@GetMapping(value = "/superfindbyid/{id}")
	public ResponseEntity<?> findBySuperUser(@PathVariable long id) throws Exception {
		return ResponseEntity.ok(machineService.findBysuperuser(id));
	}
	@PutMapping("{suid}/Addsuperusermachine/{msuid}")
	User superuser(@PathVariable long suid,@PathVariable long msuid)
	{
		User user= userrepository.findById(suid).get();
		MachineModel machinemodel=machinerepository.findById(msuid).get();
		user.assignmachine(machinemodel);
		return userrepository.save(user);
	}
	@PutMapping ("/{mid}/Customermachine//{suid}")
	MachineModel AssignCustomerToMachine (@PathVariable long mid, @PathVariable long 	suid)

	{
		User user= userrepository.findById(suid).get();
		MachineModel model=machinerepository.findById(mid).get();
		model.assignCustomer(user);
		return machinerepository.save(model);

	}
	@DeleteMapping("{suid}/deletesuperusermachine/{msuid}")
	public User deleteuser(@PathVariable long suid, @PathVariable long msuid)
	{
		User user= userrepository.findById(suid).get();
		MachineModel machinemodel=machinerepository.findById(msuid).get();
		user.Deletemachine(machinemodel);
		return userrepository.save(user);
	}
}
