package br.com.mrzoom.restwithspringbootandjava;

import br.com.mrzoom.restwithspringbootandjava.converters.NumberConverter;
import br.com.mrzoom.restwithspringbootandjava.exceptions.UnsupportedMathOperationException;
import br.com.mrzoom.restwithspringbootandjava.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please send a numeric value!");
        }
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(
                @PathVariable(value = "numberOne") String numberOne,
                @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception{
            if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationException("Please send a numeric value!");
            }
            return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        }

    @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiply(
                @PathVariable(value = "numberOne") String numberOne,
                @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception{
            if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationException("Please send a numeric value!");
            }
            return math.multiply(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        }

    @RequestMapping(value = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double divide(
                @PathVariable(value = "numberOne") String numberOne,
                @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception{
            if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationException("Please send a numeric value!");
            }
            return math.divide(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        }
    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
        public Double mean(
                    @PathVariable(value = "numberOne") String numberOne,
                    @PathVariable(value = "numberTwo") String numberTwo
            ) throws Exception{
                if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
                    throw new UnsupportedMathOperationException("Please send a numeric value!");
                }
                return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
            }

    @RequestMapping(value = "/square/{number}", method = RequestMethod.GET)
        public Double square(
                    @PathVariable(value = "number") String number
            ) throws Exception{
                if(!NumberConverter.isNumeric(number)) {
                    throw new UnsupportedMathOperationException("Please send a numeric value!");
                }
                return math.square(NumberConverter.convertToDouble(number));
            }

}
