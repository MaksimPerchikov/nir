package ru.nir.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import ru.nir.exceptions.MyClassExceptions;

//Проверка слов на наличие знаков #,$, и пробела в начале слова
@Component
public class CheckWord {

    private static String MESSAGE_ERROR = "Объект, в начале полей которого присутствуют знаки _, $, # добавиться не могут!";

    //сделать через дженерики,чтобы принимал разные объекты,мб и не через дженерики
    public boolean checkWordToString(MyClassExceptions myClassExceptions, String... s) {
        List<String> stringList = Arrays.stream(s)
            .collect(Collectors.toList());

        stringList.stream()
            .filter(element -> {
                char charElement = element.charAt(0);
                switch (charElement) {
                    case ' ':
                    case '$':
                    case '#':
                        myClassExceptions.showMeThisException(MESSAGE_ERROR,
                            new RuntimeException()
                        );
                        return false;
                }
                return true;
            });
        return true;
    }

}
