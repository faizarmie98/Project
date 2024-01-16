package faiz.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import faiz.assessment.model.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Long>{

}