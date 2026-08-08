package com.anvimol.ecommerce.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anvimol.ecommerce.model.Producto;
import com.anvimol.ecommerce.model.Usuario;
import com.anvimol.ecommerce.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
    @Autowired
	private ProductoService productoService;

    @GetMapping("")
	public String show() {
		// model.addAttribute("productos", productoService.findAll());
		return "productos/show";
	}

    @GetMapping("/create")
    public String create() {
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto) {
        LOGGER.info("Guardando producto: {}", producto);
        Usuario user = new Usuario(1, null, null, null, null, null, null, null);

        producto.setUsuario(user);

        productoService.save(producto);
        return "redirect:/productos";
    }
    
}
