package br.com.mrzoom.restwithspringbootandjava;

import br.com.mrzoom.restwithspringbootandjava.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please send a numeric value!");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(
                @PathVariable(value = "numberOne") String numberOne,
                @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception{
            if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationException("Please send a numeric value!");
            }
            return convertToDouble(numberOne) - convertToDouble(numberTwo);
        }

    @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiply(
                @PathVariable(value = "numberOne") String numberOne,
                @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception{
            if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationException("Please send a numeric value!");
            }
            return convertToDouble(numberOne) * convertToDouble(numberTwo);
        }

    @RequestMapping(value = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double divide(
                @PathVariable(value = "numberOne") String numberOne,
                @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception{
            if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationException("Please send a numeric value!");
            }
            return convertToDouble(numberOne) / convertToDouble(numberTwo);
        }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return null;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }


    private boolean isNumeric(String strNumber){
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9+]");
    }

}
