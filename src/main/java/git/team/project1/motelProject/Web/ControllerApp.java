package git.team.project1.motelProject.Web;

/*IMPORTS*/
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * Definición de URL´s
 */
@Controller/*Notacion para definir el contexto de la clase*/
@Slf4j
/*notacion de lombok para enviar cosas a consola*/
public class ControllerApp {


    @GetMapping("/manager")
    public String manager(Model model) {
        return "manager_board";
    }

    @GetMapping("/reception")
    public String reception(Model model) {
        return "reception_board";
    }

    @GetMapping("/rooms")
    public String rooms(Model model) {
        return "rooms_board";
    }

    @GetMapping("/login")
    public String login (Model model) {
        return "login";
    }

}
