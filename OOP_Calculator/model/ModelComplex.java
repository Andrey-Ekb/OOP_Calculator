package model;

import data.*;

public class ModelComplex implements Model{

    @Override
    public Complex calculate (Calculator calc) {
        switch(calc.getOperation()){
            case '+' -> {
                return new CompleSum().getExecute(calc.getNumOne(), calc.getNumTwo());
            }
            case '-' -> {
                return new ComplexDiff().getExecute(calc.getNumOne(), calc.getNumTwo());
            }
            case '*' -> {
                return new CompleMulti().getExecute(calc.getNumOne(), calc.getNumTwo());
            }
            case '/' -> {
                return new CompleDiv().getExecute(calc.getNumOne(), calc.getNumTwo());
            }
        }
        return null;
    }   
}
