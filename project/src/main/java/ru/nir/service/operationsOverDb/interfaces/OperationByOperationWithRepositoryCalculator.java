package ru.nir.service.operationsOverDb.interfaces;

import java.util.List;
import ru.nir.model.calc.Calculator;

public interface OperationByOperationWithRepositoryCalculator {

    Calculator outputById(Long id);
    List<Calculator> history();
    Calculator addExample(Calculator calculator);
}
