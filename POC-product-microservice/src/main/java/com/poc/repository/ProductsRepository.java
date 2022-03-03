package com.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
}
