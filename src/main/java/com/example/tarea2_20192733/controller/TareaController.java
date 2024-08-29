package com.example.tarea2_20192733.controller;

import com.example.tarea2_20192733.model.Estudiante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TareaController {
    private List<Estudiante> estudiantes = new ArrayList<>();

    // Por el método formulario podremos obtener la ruta para ver la vista del formulario
    // En este caso utilizaremos Data Binding para el uso del trafico de los datos a la vista
    // En data binding el formato nos perimite preparan los datos que se tomaran en cuenta a la vista con respecto a un objeto que en este caso es el Estudiante
    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "formulario";
    }
    // En este caso procesamos la información utilizando @ModelAttribute en vez de @RequestParameter
    // @ModelAtribute nos ayuda a poder utilizar defrente los atributos del objeto a elegir en este caso de estudiante
    @PostMapping("/guardar")
    public String guardarEstudiante(
            @ModelAttribute Estudiante estudiante,
            Model model) {

        // Se guardan los estudiantes ingresados ingresados a un formulario
        estudiantes.add(estudiante);

        // Añadimos la lista de estudiantes al modelo para poder utilizarlo en las vistas
        model.addAttribute("estudiantes", estudiantes);

        return "listaEstudiantes";
    }
}
