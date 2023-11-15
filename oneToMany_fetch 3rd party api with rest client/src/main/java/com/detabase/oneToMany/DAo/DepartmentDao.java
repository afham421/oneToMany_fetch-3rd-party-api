package com.detabase.oneToMany.DAo;

import com.detabase.oneToMany.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department,Integer> {

    public String findDepartmentByTitle(String name);


}
