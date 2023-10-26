/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package git.team.project1.motelProject.DAO;

import git.team.project1.motelProject.Domain.eEmployee;import org.springframework.data.jpa.repository.JpaRepository;
;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cempai
 */

@Repository
public interface iEmployeeRepository extends JpaRepository<eEmployee, Long>{
    
    public eEmployee findByEmail(String email);
    
}
