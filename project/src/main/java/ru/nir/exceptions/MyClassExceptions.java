package ru.nir.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.nir.exceptions.interfaceMCE.MyClassExceptionsInterface;
import ru.nir.operations.console.DisplayerToConsole;

//класс для вызова ошибки, избежание дублирования
@Component
public class MyClassExceptions implements MyClassExceptionsInterface {

    private final DisplayerToConsole displayer;

    @Autowired
    public MyClassExceptions(DisplayerToConsole displayer) {
        this.displayer = displayer;
    }

    @Override
    public void showMeThisException(String bodyException, Exception e) {
        displayer.showMeToConsoleSomeText(bodyException);
        throw new RuntimeException(bodyException,e);
    }
}
