package com.detabase.oneToMany.DAo;

import com.detabase.oneToMany.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer> {
//    @Query("Select d from Employee d where d.name = :name")
Employee findEmployeeByName(String name);

}
