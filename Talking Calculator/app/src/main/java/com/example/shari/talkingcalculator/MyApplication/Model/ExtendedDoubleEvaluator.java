package com.example.shari.talkingcalculator.MyApplication.Model;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Function;
import com.fathzer.soft.javaluator.Parameters;

import java.util.Iterator;

public class ExtendedDoubleEvaluator extends DoubleEvaluator{

    private static final Function SQRT = new Function("sqrt",1);
    private static final Function LN = new Function("Ln",1);
    private static final Function EXP = new Function("E",1);
    private static final Function SIN = new Function("Sin",1);
    private static final Function COS = new Function("Cos",1);
    private static final Function TAN = new Function("Tan",1);
    private static final Parameters P;
    static {
        P = DoubleEvaluator.getDefaultParameters();
        P.add(SQRT);
        P.add(LN);
        P.add(EXP);
        P.add(SIN);
        P.add(COS);
        P.add(TAN);

    }

    public ExtendedDoubleEvaluator() {
        super(P);
    }

    @Override
    public Double evaluate(Function function, Iterator<Double> arguments, Object evaluationContex) {
        if (function == SQRT) {
            return Math.sqrt(arguments.next());
        }
        else if (function == LN){
            return Math.log(arguments.next());
        }
        else if (function == EXP){
            return Math.exp(arguments.next());
        }
        else if (function == SIN){
            double a = Math.toRadians(arguments.next());
            a=Math.sin(a);
            return a;
        }
        else if (function == COS){
            double a = Math.toRadians(arguments.next());
            a=Math.cos(a);
            return a;
        }
        else if (function == TAN){
            double a = Math.toRadians(arguments.next());
            a=Math.tan(a);
            return a;
        }

        else {
            return super.evaluate(function, arguments, evaluationContex);
        }
    }
}
