package com.example.introSB;
// Anotación que permite definir que la clase contiene endpoint.

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/nomina") //Indicar un prefijo antes de los endpoints
public class Controlador1 {
    //Definir endPoints para este controlador
    @GetMapping("/") //Este es el endPoint predeterminado

    public String home(){
        return "What's up?";
    }

    // endPoint para about
    @GetMapping("/about")
    public String about (){
        return "Apenas estoy aprendiendo Spring Boot";
    }

    @GetMapping("/knowledge")
    public String Knowledge (){
        return "We're in the EndPoint";
    }

    @GetMapping("/find/{id}/{nombre}")
    public String find (@PathVariable String id, @PathVariable String nombre){
        return "El ID a buscar es: " + id + " y el nombre es: "+nombre;
    }
    // endpoint para capturar datos: username, password, para retornarlo en formato json
    @GetMapping("/login/{username}/{password}")
    public HashMap<String, Object> login(@PathVariable String username, @PathVariable String password) {
        //Crear un objeto de tipo HashMap
        HashMap<String, Object> objJson = new HashMap<>();
        objJson.put("username", username);
        objJson.put("Password", password);
        //objJson.put(username, password);
        return objJson;
    }

        //Metodo POST
        @PostMapping("/login")
        public User postLogin(@RequestParam String username, @RequestParam String password){
            User oUser = new User(username, password);
            return oUser;
        }


    @PostMapping("/login1")
    public User postLogin1(@RequestBody User user){
        return user;
    }


}
