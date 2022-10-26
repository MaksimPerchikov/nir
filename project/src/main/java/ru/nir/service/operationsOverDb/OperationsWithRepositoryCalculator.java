package ru.nir.service.operationsOverDb;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.nir.model.calc.Calculator;
import ru.nir.repository.calcrepos.CalculatorRepository;
import ru.nir.service.operationsOverDb.interfaces.OperationByOperationWithRepositoryCalculator;
import ru.nir.service.operationsOverDb.interfaces.OperationByOperationsWithRepository;
//операции с базой данный для калькулятора
@Component
public class OperationsWithRepositoryCalculator implements OperationByOperationWithRepositoryCalculator {

    private final CalculatorRepository calculatorRepository;

    @Autowired
    public OperationsWithRepositoryCalculator(CalculatorRepository calculatorRepository){
        this.calculatorRepository = calculatorRepository;
    }

    @Override
    public Calculator outputById(Long id) {
        return calculatorRepository.getById(id);
    }

    @Override
    public List<Calculator> history() {
        return calculatorRepository.findAll();
    }

    @Override
    public Calculator addExample(Calculator calculator) {
        return calculatorRepository.save(calculator);
    }
}
