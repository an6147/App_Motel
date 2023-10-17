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
import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *Defición de la entidad "Empleado"
 *
 */

@Entity /*Notación para definir el contexto en JPA de Spring Boot*/

@Data /*Notación para  definir el contexto en lombok, y así no codear los getters and setters*/
@AllArgsConstructor /*Para generar el contsructor con todos los parametros*/
@NoArgsConstructor /*Para generar el constructor vacio*/
@Builder /*Para que lombok utilice este patron de diseño para construir objetos de esta clase*/
        
@Table (name = "employees") /*Especificando cual es el nombre de la tabla en la db*/
public class eEmployee{
    
    
    @Id /*Notación para indicar la llave primaria*/
    @GeneratedValue (strategy = GenerationType.IDENTITY)/*Definir el tipo de generación del valor de "id"*/
    @Column (name = "id") /*Nombre literal de la columna en la db*/
    private Long id;
    
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
    
    @Email
    @NotEmpty
    @Column (name = "email")
    private String email;
    
    @NotNull /*Para validar que no puede ser nulo*/
    @Column (name = "salary_Per_Hours")
    private float salary_Per_Hours;
   
    @Column (name = "passW")
    private String passW;
    
    
    /*Relacion de las tablas*/
    @ManyToMany(
                    fetch = FetchType.EAGER, /*para que traiga todos los roles asociados al usuario*/
                    targetEntity = eRoles.class, /*con cual entity se va a establecer la relación*/
                    cascade = CascadeType.PERSIST /*para que no borre los roles de su tabla cuando se borre un usuario*/    
                )
    
    /*Config de las llaves foraneas*/
    /*Cuando hay una relacion de muchos a muchos, se va a generar una tabla intermedia*/
    @JoinTable ( /*Config de la tabla intermedia*/
                    name = "user_roles",/*Nombre de la tabla intermedia*/
                    joinColumns = @JoinColumn (name = "user_id"), /*confg de la clave foranea de usuario */
                    inverseJoinColumns = @JoinColumn(name = "role_id")/*confg de la clave foranea de roles*/
                )
    private Set<eRoles> roles; /*el set no nos permite tener elementos repetidos, el list si*/
    
}
