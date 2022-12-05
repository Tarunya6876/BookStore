package com.bookstoreapi.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookstoreapi.Model.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findByBookIdEquals(long bookId);
    Optional<Inventory> findByBookNameEquals(String bookName);
    @Query(value="Select * from Inventory i order by book_likes desc",nativeQuery = true)
	List<Inventory> sortByLikes();
	//List<Inventory> sortByLikes();
}