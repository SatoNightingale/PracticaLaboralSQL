package com.satoshihans.practicalaboralsql.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satoshihans.practicalaboralsql.models.Empleados;
import com.satoshihans.practicalaboralsql.models.dto.ClaseDTO;

import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/api")

public class RestController1 {

    // @RequestMapping(path="/info_rest", method=RequestMethod.GET)
    @GetMapping(path="/info_rest")

    public ClaseDTO info(){
        // Empleados empleado1 = new Empleados(
        //     "Juan", 
        //     "Rodriguez", 
        //     "Un saludo a los Juanes Rodriguez", 
        //     "Ser alguien", 
        //     1, 
        //     11223344, 
        //     001
        // );

        // Map<String, Object> respuesta = new HashMap<>();
        // respuesta.put("Empleado", empleado1);

        ClaseDTO usuario1 = new ClaseDTO();
        usuario1.setTitulo("Administrador");
        usuario1.setUsuario("Pana");

        return usuario1;
    }
}
