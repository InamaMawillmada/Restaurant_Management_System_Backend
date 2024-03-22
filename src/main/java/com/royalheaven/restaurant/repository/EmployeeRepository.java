package com.royalheaven.restaurant.repository;

import com.royalheaven.restaurant.dao.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Long> {

}
