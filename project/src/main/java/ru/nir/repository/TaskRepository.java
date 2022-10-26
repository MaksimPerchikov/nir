package ru.nir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nir.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}