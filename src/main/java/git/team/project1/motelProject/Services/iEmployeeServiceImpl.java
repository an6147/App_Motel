package git.team.project1.motelProject.Services;

import git.team.project1.motelProject.DAO.iEmployeeRepository;
import git.team.project1.motelProject.DTO.employeeDTO;
import git.team.project1.motelProject.Domain.eEmployee;
import git.team.project1.motelProject.Domain.eRoles;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cempai
 */
@Service
public class iEmployeeServiceImpl implements iEmployeeService {

    @Autowired
    private iEmployeeRepository employeeRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public eEmployee save(employeeDTO registerDTO) {
        eEmployee employee = new eEmployee
        (
                registerDTO.getName_Complete(),
                registerDTO.getDNI(),
                registerDTO.getDirecc(),
                registerDTO.getTlf(),
                registerDTO.getSalary_Per_Hours(),
                registerDTO.getEmail(),
                passwordEncoder.encode(registerDTO.getPassW()),
                Arrays.asList(new eRoles ("ROLE_USER"))
        );
        return employeeRepository.save(employee);
        
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        eEmployee employee = employeeRepository.findByEmail(username);
        if(employee == null){
            throw new UsernameNotFoundException ("Usuario o password invalidos");
        }
        return new User(employee.getEmail(), employee.getPassW(), rolesAuthoritysMapping(employee.getRoles()));
    }

    private Collection<? extends GrantedAuthority> rolesAuthoritysMapping (Collection<eRoles> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName_Role())).collect(Collectors.toList());
    }

    @Override
    public List<eEmployee> listarEmployee() {
        return employeeRepository.findAll();
    }

}
