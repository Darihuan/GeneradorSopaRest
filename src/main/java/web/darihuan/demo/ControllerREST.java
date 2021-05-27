package web.darihuan.demo;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(path = "api/generar/")

public class ControllerREST {
@GetMapping("/{dimension}")	
public GenerarSopa metodo(@PathVariable("dimension") String size) {
		int tamano=Integer.parseInt(size);
		GenerarSopa ejemplo=new GenerarSopa(tamano);
	return ejemplo;
}
@GetMapping("palabras/{dimension}")	
public GenerarSopa metodopalabras(@PathVariable("dimension") String size,@RequestBody List<String> lista) {
		int tamano=Integer.parseInt(size);
		GenerarSopa ejemplo=new GenerarSopa(tamano,lista);
	return ejemplo;
}

}
