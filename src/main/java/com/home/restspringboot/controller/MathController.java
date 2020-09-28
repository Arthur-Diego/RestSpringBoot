package com.home.restspringboot.controller;

import com.home.restspringboot.exception.UnsuportedMathOperationException;
import com.home.restspringboot.math.SimpleMath;
import com.home.restspringboot.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private SimpleMath math = new SimpleMath();

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Não é número");
        }

        return math.sum(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));
    }

     @GetMapping(value="/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return math.subtraction(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));
    }

     @GetMapping(value="/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return math.multiplication(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));
    }

     @GetMapping(value="/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return math.division(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));
    }


     @GetMapping(value="/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return math.mean(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));
    }

     @GetMapping(value="/squareRoot/{number}")
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        if (!NumberConverter.isNumeric(number)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return math.squareRoot(NumberConverter.covertToDouble(number));
    }

}
