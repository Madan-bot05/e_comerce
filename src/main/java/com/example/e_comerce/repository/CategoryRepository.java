package com.example.e_comerce.repository;

import com.example.e_comerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    public Category findByName(String name);
    @Query("SELECT c from Category c where c.name=:name AND c.parentCategory.name=:parentCategoryName")
    public Category findByNameAndParent(@Param("name") String name ,@Param("parentCategoryName")String parentCategoryName);

}
