package git.team.project1.motelProject.Web;

/*IMPORTS*/
import git.team.project1.motelProject.Services.iEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * Definición de URL´s
 */
@Controller
/*Notacion para definir el contexto de la clase*/
@Slf4j
/*notacion de lombok para enviar mensajes a consola*/

public class ControllerApp {
    
    @Autowired
    private iEmployeeService employeeService;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/")
    public String pageStart(Model model) {
        model.addAttribute("employees", employeeService.listarEmployee());
        return "index";
    }

}
