/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package git.team.project1.motelProject.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Cempai
 */
@Entity

@Data /*Notación para  definir el contexto en lombok, y así no codear los getters and setters*/
@AllArgsConstructor /*Para generar el contsructor con todos los parametros*/
@NoArgsConstructor /*Para generar el constructor vacio*/
@Builder /*Para que lombok utilice este patron de diseño para construir objetos de esta clase*/

@Table (name = "roles")
public class eRoles{
    
    
    @Id /*Notación para indicar la llave primaria*/
    @GeneratedValue (strategy = GenerationType.IDENTITY)/*Definir el tipo de generación del valor de "pKey"*/
    @Column (name = "id") /*Nombre literal de la columna en la db*/
    private Long id;
    
    @Enumerated (EnumType.STRING) /*por ser enumeracion*/
    @Column (name = "name_Role")
    private EnumRoles name_Role; /* "EnumRoles" es una enumeracion donde se guardarán todos nuestros roles*/ 
}
