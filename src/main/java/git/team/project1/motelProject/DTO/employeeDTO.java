/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package git.team.project1.motelProject.DTO;

import lombok.Data;

/**
 *
 * @author Cempai
 */
@Data
public class employeeDTO {

    private Long emp_id;
    private String name_Complete;
    private String DNI;
    private String direcc;
    private String tlf;
    private float salary_Per_Hours;
    private String email;
    private String passW;

    public employeeDTO() {
    }

    public employeeDTO(Long emp_id, String name_Complete, String DNI, String direcc, String tlf, float salary_Per_Hours, String email, String passW) {
        this.emp_id = emp_id;
        this.name_Complete = name_Complete;
        this.DNI = DNI;
        this.direcc = direcc;
        this.tlf = tlf;
        this.salary_Per_Hours = salary_Per_Hours;
        this.email = email;
        this.passW = passW;
    }

    public employeeDTO(String name_Complete, String DNI, String direcc, String tlf, float salary_Per_Hours, String email, String passW) {
        this.name_Complete = name_Complete;
        this.DNI = DNI;
        this.direcc = direcc;
        this.tlf = tlf;
        this.salary_Per_Hours = salary_Per_Hours;
        this.email = email;
        this.passW = passW;
    }

    public employeeDTO(String email) {
        this.email = email;
    }

}
