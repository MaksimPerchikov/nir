package ru.nir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nir.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
