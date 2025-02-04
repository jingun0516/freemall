package com.estsoft.freemall.repository;

import com.estsoft.freemall.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    Categories findByName(String name);
}
