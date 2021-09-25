package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.User;
import com.example.demo.request.SignupRequest;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);
	//public void save(User user, MultipartFile file);
	Boolean existsByEmail(String email);
	@Query("SELECT u FROM User u WHERE u.status = ?1")
	List<User> findBystatus(@Param("status") Integer status );
	//	Page<User> findBystatus(@Param("status") Integer status ,Pageable pageable);
	//Page<User> FindAll(Long id,org.springframework.data.domain.Pageable pageble);
	@Query("SELECT u FROM User u WHERE u.username = ?1")
	public User findByUser(@Param("username") String username );

}
