package com.mydemo.demoproject.Repository;

import com.mydemo.demoproject.Entity.CategoryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepo extends JpaRepository<CategoryInfo,Long> {


 Optional<CategoryInfo> findBycategoryname(String category);

//    List<CategoryInfo> findByUsernameNot(String username);

    @Query(value = "SELECT * FROM category_info WHERE category_name LIKE %:keyword%", nativeQuery = true)
    List<CategoryInfo> findByCategoryKeyword (@Param("keyword") String keyword);

    void deleteById(Long id);

    Optional<CategoryInfo> findById(Long id);
}
