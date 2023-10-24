package git.team.project1.motelProject.Domain;

/*Imports*/
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Collection;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *Defición de la entidad "Empleado"
 *
 */

@Entity /*Notación para definir el contexto en JPA de Spring Boot*/

@Data /*Notación para  definir el contexto en lombok, y así no codear los getters and setters*/
@AllArgsConstructor /*Para generar el constructor con todos los parametros*/
@NoArgsConstructor /*Para generar el constructor vacio*/
  
@Table (name = "employees", uniqueConstraints = @UniqueConstraint(columnNames = "email")) /*Especificando cual es el nombre de la tabla en la db*/
public class eEmployee{
    
    
    @Id /*Notación para indicar la llave primaria*/
    @GeneratedValue (strategy = GenerationType.IDENTITY)/*Definir el tipo de generación del valor de "id"*/
    @Column (name = "emp_id") /*Nombre literal de la columna en la db*/
    private Long emp_id;
    
    @NotEmpty /*Para validar que no puede estar vacio*/
    @Column (name = "name_Complete")
    private String name_Complete;
    
    @NotEmpty
    @Column (name = "DNI")
    private String DNI;
    
    @NotEmpty
    @Column (name = "direcc")
    private String direcc;
    
    @NotEmpty
    @Column (name = "tlf")
    private String tlf;
    
    @NotNull /*Para validar que no puede ser nulo*/
    @Column (name = "salary_Per_Hours")
    private float salary_Per_Hours;
    
    @Email
    @NotEmpty
    @Column (name = "email")
    private String email;
    
    
    @Column (name = "passW")
    private String passW;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)/*tipo de relacion entre tablas*/
    @JoinTable(/*unir columnas*/
            name = "employees_roles", /*se indica que se creará una tabla con este nombre*/
            joinColumns = @JoinColumn (name = "employe_id", referencedColumnName = "emp_id"),/*Definición de columna local a unir*/
            inverseJoinColumns = @JoinColumn (name = "rol_id", referencedColumnName = "r_id")/*Definición de columna foranea a unir*/
    )
    private Collection<eRoles> roles; 

    /*Constructor personalizado*/
    public eEmployee(String name_Complete, String DNI, String direcc, String tlf, float salary_Per_Hours, String email, String passW, Collection<eRoles> roles) {
        this.name_Complete = name_Complete;
        this.DNI = DNI;
        this.direcc = direcc;
        this.tlf = tlf;
        this.salary_Per_Hours = salary_Per_Hours;
        this.email = email;
        this.passW = passW;
        this.roles = roles;
    }
    
    
}
