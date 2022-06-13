package com.backend.rentcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.rentcar.domain.FileDB;

@Repository
@Transactional
public interface FileDBRepository extends JpaRepository<FileDB, String> {
	

}
