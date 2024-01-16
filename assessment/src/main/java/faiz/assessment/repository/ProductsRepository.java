package faiz.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import faiz.assessment.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>{

}