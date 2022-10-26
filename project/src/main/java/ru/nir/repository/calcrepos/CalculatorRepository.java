package ru.nir.repository.calcrepos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nir.model.calc.Calculator;

@Repository
public interface CalculatorRepository extends JpaRepository<Calculator,Long> {

}
