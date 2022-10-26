/*
package ru.nir.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nir.dto.CalculatorDTO;
import ru.nir.model.calc.Calculator;
import ru.nir.service.ServiceCalc;

@RestController
@RequestMapping("/")

public class CalculatorController {

private final ServiceCalc serviceCalc;

    @Autowired
    public CalculatorController(ServiceCalc serviceCalc){
        this.serviceCalc = serviceCalc;
    }


@PostMapping(value = "/calc")
    public String inputExample(CalculatorDTO calculatorDTO){

    }

    @GetMapping(value = "/history")
    public List<String> history(){

    }

}
*/
