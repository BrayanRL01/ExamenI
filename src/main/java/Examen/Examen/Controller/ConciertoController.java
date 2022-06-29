package Examen.Examen.Controller;


import Examen.Examen.Entity.Concierto;
import Examen.Examen.Service.IConciertoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConciertoController {

    @Autowired
    private IConciertoService conciertoService;

    @GetMapping("/Consulta")
    public String Index(Model model) {
        List<Concierto> listaConcierto = conciertoService.getAllConcierto();
        model.addAttribute("titulo", "Conciertos disponibles");
        model.addAttribute("concierto", listaConcierto);
        return "Consulta";
    }

    @GetMapping("/AgregarC")
    public String CrearConcierto(Model model) {
        model.addAttribute("concierto", new Concierto());
        return "Agregar";
    }

    @PostMapping("/save")
    public String GuardarConcierto(@ModelAttribute Concierto concierto) {
        conciertoService.saveConcierto(concierto);
        return "redirect:/Consulta";
    }

    @GetMapping("/EditarConcierto/{id}")
    public String EditarConcierto(@PathVariable("id") Long idConcierto, Model model) {
        Concierto concierto = conciertoService.getConciertoById(idConcierto);
        model.addAttribute("concierto", concierto);
        return "Agregar";
    }

    @GetMapping("/delete/{id}")
    public String EliminarConcierto(Concierto concierto) {
        conciertoService.delete(concierto.getId());
        return "redirect:/Consulta";
    }
}
