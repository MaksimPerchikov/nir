package ru.nir.service;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nir.service.operationsOverDb.OperationsWithRepositoryCalculator;

//Сервис,калькулятор,принимающий строку
@Service
public class ServiceCalc {

    private final OperationsWithRepositoryCalculator operations;

    @Autowired
    public ServiceCalc(OperationsWithRepositoryCalculator operations){
        this.operations = operations;
    }

    public void startCalc(){
        Scanner scanner = new Scanner(System.in);
        String lineInput = scanner.nextLine();
        if(lineInput.equals("111")){
            return;
        }
        calc(lineInput);
        startCalc();
    }

    public void  calc(String s){
        int firstNumber = 0;
        int secondNumber = 0;
        char [] chars = s.toCharArray();
        int size = chars.length;
        int count = 0;
        int countTwo = 0;
        char s2 = '0';
        for (int i = 0; i < size; i++) {
            String result = searchNumber(String.valueOf(chars[i]));
            if(result == null) {
                String signSearch = searchSign(String.valueOf(chars[i]));
                if(signSearch == null) {
                    output("Такого знака нет, смените знак!");
                }else{
                    s2 = signSearch.charAt(0);
                }
            }

            if (count == 0 && result != null) {
                firstNumber = Integer.parseInt(result);
                count++;

            }else if (count != 0 && result != null) {
                secondNumber = Integer.parseInt(result);
                countTwo++;
            }

        }
        answer(firstNumber,secondNumber,String.valueOf(s2));
    }

    public String searchNumber(String number){
        String result = null;
        switch(number){
            case "1":
                return result = "1";
            case "2":
                return result = "2";
            case "3":
                return result = "3";
            case "4":
                return result = "4";
            case "5":
                return result = "5";
            case "6":
                return result = "6";
            case "7":
                return result = "7";
            case "8":
                return result = "8";
            case "9":
                return result = "9";
            case "0":
                return result = "0";
        }
        return result;
    }

    public String searchSign(String sign){
        String signResult = null;
        switch(sign){
            case "+":
                return signResult = "+";
            case "-":
                return signResult = "-";
            case "*":
                return signResult = "*";
            case "/":
                return signResult = "/";
        }
        return signResult;
    }
    public void output(String message){
        System.out.println(message);
    }
    public void answer(int f,int s,String sign){
        int ans;
        switch(sign){
            case "+":
                ans = f+s;
                output(String.valueOf(ans));
                break;
            case "-":
                ans = f-s;
                output(String.valueOf(ans));
                break;
            case "*":
                ans = f*s;
                output(String.valueOf(ans));
                break;
            case "/":
                ans = f/s;
                output(String.valueOf(ans));
                break;
        }
    }

}
