package com.example.calculator.controllers;
import com.example.calculator.models.Result;

//Decoradores

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.http.MediaType;

@CrossOrigin(origins = "*")
@RestController
public class CalculatorController {

    @RequestMapping(value="/suma" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result suma(@RequestParam(name="num1", required=false, defaultValue = "0") String num1,
                        @RequestParam(name="num2", required=false, defaultValue = "0") String num2)
    {
        Result exported = new Result();
        try{
            float castOp1= Float.parseFloat(num1);
            float castOp2= Float.parseFloat(num2);

            float internalResult = 0;
            internalResult= castOp1 + castOp2;
            System.out.println(internalResult);
            exported.setResult(internalResult);
            exported.setStatus("OK");
        }
        catch(NumberFormatException ex){
            exported.setStatus("Error: Uno de los operadores no es un numero");
        }
        catch (Exception Exgen){
            exported.setStatus("Error inesperado");
        }

        return exported;
    }

    //Resta
    @RequestMapping(value="/resta" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result resta(@RequestParam(name="num1", required=false, defaultValue = "0") String num1,
                        @RequestParam(name="num2", required=false, defaultValue = "0") String num2)
    {
        Result exported = new Result();
        try{
            float castOp1= Float.parseFloat(num1);
            float castOp2= Float.parseFloat(num2);

            float internalResult= castOp1 -castOp2;
            exported.setResult(internalResult);
            exported.setStatus("OK");
        }
        catch(NumberFormatException ex){
            exported.setStatus("Error: Uno de los operadores no es un numero");
        }
        catch (Exception Exgen){
            exported.setStatus("Error inesperado");
        }

        return exported;
    }

    ///multiplicacion

    @RequestMapping(value="/multi" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result mult(@RequestParam(name="num1", required=false, defaultValue = "0") String num1,
                       @RequestParam(name="num2", required=false, defaultValue = "0") String num2)
    {
        Result exported = new Result();
        try{
            float castOp1= Float.parseFloat(num1);
            float castOp2= Float.parseFloat(num2);

            float internalResult= castOp1*castOp2;
            exported.setResult(internalResult);
            exported.setStatus("OK");
        }
        catch(NumberFormatException ex){
            exported.setStatus("Error: Uno de los operadores no es un numero");
        }
        catch (Exception Exgen){
            exported.setStatus("Error inesperado");
        }

        return exported;
    }

    //Division
    @RequestMapping(value="/divi" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result divs(@RequestParam(name="num1", required=false, defaultValue = "0") String num1,
                       @RequestParam(name="num2", required=false, defaultValue = "0") String num2)
    {
        Result exported = new Result();
        try{
            float castOp1= Float.parseFloat(num1);
            float castOp2= Float.parseFloat(num2);
            if (castOp2==0){
                throw new ArithmeticException();
            }

            float internalResult= castOp1/castOp2;
            exported.setResult(internalResult);
            exported.setStatus("OK");
        }
        catch(NumberFormatException ex){
            exported.setStatus("Error: Uno de los operadores no es un numero");
        }
        catch (ArithmeticException ZeroEx){

            exported.setStatus("Error: no es posible la división entre cero");
        }

        catch (Exception Exgen){
            exported.setStatus("Error inesperado");
        }

        return exported;
    }

}
