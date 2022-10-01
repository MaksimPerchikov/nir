package ru.nir.operations.console;

import org.springframework.context.annotation.Configuration;
import ru.nir.operations.console.interfaceop.ConsoleInterface;
//вывод в консоль сообщения об ошибке для избежания дублирования System.out.println();

@Configuration
public class DisplayerToConsole implements ConsoleInterface {

    @Override
    public void showMeToConsoleSomeText(String s) {
        System.out.println(s);
    }
}
