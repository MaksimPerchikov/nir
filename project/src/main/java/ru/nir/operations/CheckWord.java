package ru.nir.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.nir.dto.CustomerDTO;
import ru.nir.dto.CustomerTaskDTO;
import ru.nir.exceptions.MyClassExceptions;

//Проверка слов на наличие знаков #,$, и пробела в начале слова
@Component
public class CheckWord <T>{

    private final MyClassExceptions myClassExceptions;

    private T type;
    //private S customerTaskDTO;

    @Autowired
    public CheckWord(MyClassExceptions myClassExceptions) {
        this.myClassExceptions = myClassExceptions;
    }

    //сделать через дженерики,чтобы принимал разные объекты
    public void chekWordToString(T type) {


        /*if (type.getSecondName() != null
            && customerDTO.getFirstName() != null) {
            String firstName = customerDTO.getFirstName();
            String secondName = customerDTO.getSecondName();
            if (firstName.contains("$") &&
                firstName.contains("#") &&
                firstName.contains(" ") &&
                secondName.contains("$") &&
                secondName.contains("#") &&
                secondName.contains(" ")
            )
*/
    }

}
