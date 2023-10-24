package git.team.project1.motelProject.Services;

import git.team.project1.motelProject.DAO.iEmployeeRepository;
import git.team.project1.motelProject.DTO.employeeDTO;
import git.team.project1.motelProject.Domain.eEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cempai
 */
@Service
public class iEmployeeServiceImpl implements iEmployeeService{
    
    @Autowired
    private iEmployeeRepository employeeRepository;
    
    @Override
    public eEmployee save(employeeDTO registerDTO) {
        eEmployee employee = new eEmployee(name_Complete, DNI, direcc, tlf, 0, email, passW, roles);
    }
    
}
