package br.com.bruno.controller;

import br.com.bruno.model.Material;
import br.com.bruno.repository.MaterialRepository;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MaterialController {

    @Autowired
    private MaterialRepository materialRepository;

    @GetMapping("/materiais")
    public String listar(Model model) {
        model.addAttribute("listaMateriais", materialRepository.findAll());
        return "gerenciar_materiais";
    }

    @GetMapping("/materiais/novo")
    public String novo(Model model) {
        model.addAttribute("material", new Material());
        return "editar_material";
    }

    @GetMapping("/materiais/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Material> material = materialRepository.findById(id);
        model.addAttribute("material", material.get());
        return "editar_material";
    }

    @PostMapping("/materiais")
    public String salvar(@Valid Material material, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_material";
        }
        materialRepository.save(material);
        return "redirect:/materiais";
    }

    @DeleteMapping("/materiais/{id}")
    public String excluir(@PathVariable("id") long id) {
        materialRepository.deleteById(id);
        return "redirect:/materiais";
    }
}


