package com.angryram.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angryram.cms.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer>{
	/**
	 * To fetch Food by Range
	 * @param min
	 * @param max
	 * @return
	 */
//	@Query("SELECT food FROM FoodEntity food WHERE food.calories BETWEEN :min AND :max")
//	List<CategoryEntity> searchFoodByRange(@Param("min") int min, @Param("max") int max);

}
