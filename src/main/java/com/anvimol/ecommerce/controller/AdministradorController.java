package com.anvimol.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anvimol.ecommerce.model.Orden;
import com.anvimol.ecommerce.model.Producto;
import com.anvimol.ecommerce.service.IOrdenService;
import com.anvimol.ecommerce.service.IUsuarioService;
import com.anvimol.ecommerce.service.ProductoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private IUsuarioService usaurioService;

    @Autowired
	private IOrdenService ordenService;

    private Logger logg= LoggerFactory.getLogger(AdministradorController.class);

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

    @GetMapping("/detalle/{id}")
	public String detalle(Model model, @PathVariable Integer id) {
		logg.info("Id de la orden {}",id);
		Orden orden = ordenService.findByIdWithDetalles(id)
				.orElseThrow(() -> new IllegalArgumentException("Orden no encontrada"));
		
		model.addAttribute("detalles", orden.getDetalles()); 
		
		return "administrador/detalleorden";
	}
    
}
