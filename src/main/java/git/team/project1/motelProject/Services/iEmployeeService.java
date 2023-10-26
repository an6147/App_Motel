package git.team.project1.motelProject.Services;

import git.team.project1.motelProject.DTO.employeeDTO;
import git.team.project1.motelProject.Domain.eEmployee;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Cempai
 */
public interface iEmployeeService extends UserDetailsService{
    public eEmployee save(employeeDTO registerDTO);
    
    public List<eEmployee> listarEmployee();
}
