package git.team.project1.motelProject.Services;

import git.team.project1.motelProject.DTO.employeeDTO;
import git.team.project1.motelProject.Domain.eEmployee;

/**
 *
 * @author Cempai
 */
public interface iEmployeeService {
    public eEmployee save(employeeDTO registerDTO);
}
