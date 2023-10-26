/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package git.team.project1.motelProject.DTO;

/**
 *
 * @author Cempai
 */
public class employeeDTO {

    private Long emp_id;
    private String name_Complete;
    private String DNI;
    private String direcc;
    private String tlf;
    private float salary_Per_Hours;
    private String email;
    private String passW;

    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public String getName_Complete() {
        return name_Complete;
    }

    public void setName_Complete(String name_Complete) {
        this.name_Complete = name_Complete;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDirecc() {
        return direcc;
    }

    public void setDirecc(String direcc) {
        this.direcc = direcc;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public float getSalary_Per_Hours() {
        return salary_Per_Hours;
    }

    public void setSalary_Per_Hours(float salary_Per_Hours) {
        this.salary_Per_Hours = salary_Per_Hours;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassW() {
        return passW;
    }

    public void setPassW(String passW) {
        this.passW = passW;
    }

    
    
    
    
    
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
