package com.anvimol.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anvimol.ecommerce.model.Producto;
import com.anvimol.ecommerce.service.IOrdenService;
import com.anvimol.ecommerce.service.IUsuarioService;
import com.anvimol.ecommerce.service.ProductoService;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private IUsuarioService usaurioService;

    @Autowired
	private IOrdenService ordenService;

    @GetMapping("")
    public String home(Model model) {

        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "administrador/home";
    }

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usaurioService.findAll());
        return "administrador/usuarios";
    }

    @GetMapping("/ordenes")
	public String ordenes(Model model) {
		model.addAttribute("ordenes", ordenService.findAll());
		return "administrador/ordenes";
	}
    
}
