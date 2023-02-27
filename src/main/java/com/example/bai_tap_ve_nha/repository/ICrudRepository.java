package com.example.bai_tap_ve_nha.repository;

import com.example.bai_tap_ve_nha.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ICrudRepository extends JpaRepository<Product, Long> {
}
