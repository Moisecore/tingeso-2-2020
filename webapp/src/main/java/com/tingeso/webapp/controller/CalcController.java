package com.tingeso.webapp.controller;

import com.tingeso.webapp.model.Calc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalcController {

    @GetMapping("/")
    public String index(Model model){
        Calc calc = new Calc();
        model.addAttribute("calc", calc);
        return "index";
    }

    @PostMapping("/")
    public String calcular(@ModelAttribute("calc") Calc calc){
        double res = 0;
        double n1 = calc.getNum1();
        double n2 = calc.getNum2();
        switch(calc.getOper()){
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
            case "*":
                res = n1 * n2;
                break;
            case "/":
                if(n2 != 0){
                    res = n1 / n2;
                    break;
                }
                else{
                    calc.setRes("Infinito(?)");
                    return "result";
                }
        }
        calc.setRes(Double.toString(res));
        return "result";
    }

}
