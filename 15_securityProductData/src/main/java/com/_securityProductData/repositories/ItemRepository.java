package com._securityProductData.repositories;


/**
 * - JpaRepository является обобщеным интерфейсом
 * - ItemRepository работает с базой данных
 */
//@Repository
//public interface ItemRepository extends JpaRepository<Item, Long> {
//	/**
//	 * формирование запроса Spring Data, аналогичного SQL:
//	 * SELECT i FROM Item i WHERE i.title = 1?
//	 */
//	Item findByTitle(String title);
//
//	List<Item> findByCostBetween(int min, int max);
//
//	List<Item> findByTitleAndCostBetween(String s, int min, int max);
//	найти все товары по стоимость и отсортировать по названию
//	List<Item> findByActiveCostOrOrderByTitleDesc(String name, String surname);
//	/**
//	 * возможно поменять на свой метод созданным зпросом SqL*/
////	@Query(value = "", nativeQuery = true)
////	List<Item> myMethodName();
//	/**
//	 * Найти все Item-ы, у которых название заканчивается на какую то подстроку*/
//	@Query(value = "SELECT i FROM Item i WHERE i.title LIKE ?1%")
//	List<Item> findByTitleWith(String substr);
//}

/**
 *
 */

import com._securityProductData.entities.*;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Long>, JpaSpecificationExecutor<Item> {
	List<ItemProjection> getProjection();
}
