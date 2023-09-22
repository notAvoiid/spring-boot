package br.com.mrzoom.restwithspringbootandjava.math;

public class SimpleMath {


    public Double sum (Double numberOne, Double numberTwo) {

        return numberOne + numberTwo;
    }

    public Double sub(Double numberOne, Double numberTwo) {

        return numberOne - numberTwo;
    }

    public Double multiply(Double numberOne, Double numberTwo) {

        return numberOne * numberTwo;
    }

    public Double divide(Double numberOne, Double numberTwo) {

        return numberOne / numberTwo;
    }

    public Double mean(Double numberOne, Double numberTwo) {

        return (numberOne +  numberTwo) / 2;
    }

    public Double square(Double number) {

        return Math.sqrt(number);
    }
}
