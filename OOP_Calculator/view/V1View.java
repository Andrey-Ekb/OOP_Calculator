package view;

import controllers.Controller;
import controllers.V1Controller;
import data.CalculatorComplex;
import data.Complex;
import data.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class V1View implements View{
    private final Controller controller;
    private Status status = Status.FIRST;

    private final List<Log> logging = new ArrayList<>();

    public V1View (){
        this.controller = new V1Controller();
    }

    public void start(){
        Scanner in = new Scanner(System.in).useDelimiter("\r?\n");
        System.out.println("""
                ИНСТРУКЦИЯ: виды действий: +, -, *, /. Вводим в формате < переменная:действие:переменная>,
                "c" - для получения реультата. """);
        String key = in.next().toLowerCase();
        CalculatorComplex calculator;
        Complex result = null;
        while (!key.equals("c")) {
            if (status == Status.FIRST) {
                calculator = new CalculatorComplex(key);
                status = Status.NEXT;
            } else calculator = new CalculatorComplex(result, key);
            result = controller.sendComplex(calculator);
            logging.add(new Log(calculator, result));
            System.out.println(result);
            key= in.next().toLowerCase();
        }
        in.nextLine();
        loggingGame(in, logging);   
    }

    private static void loggingGame(Scanner scanner, List<Log> logging){
        System.out.println("Хотите посмотреть логи, Y/N: ");
        String input = scanner.next();
        if(input.toUpperCase().equals("Y")) {
            for(Log log: logging){
                System.out.println(log);
            }
        }
    }    
}
