/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package git.team.project1.motelProject.Web;

import git.team.project1.motelProject.DTO.employeeDTO;
import git.team.project1.motelProject.Services.iEmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Cempai
 */

@Controller
@RequestMapping("/register")
public class employeeRegisterController {
    
    @Autowired
    private iEmployeeServiceImpl employeeService;

    public employeeRegisterController(iEmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    
    @ModelAttribute("employee")
    public employeeDTO returnNewEmployeeRegisterDTO(){
        return new employeeDTO();
    }
    
    @GetMapping
    public String showFormRegister(){
        return "register";
                
    }
    
    @PostMapping
    public String registerEmployee(@ModelAttribute("employee") employeeDTO registerDTO){
        employeeService.save(registerDTO);
        return "redirect:/registro?exito";
    }
    
}
