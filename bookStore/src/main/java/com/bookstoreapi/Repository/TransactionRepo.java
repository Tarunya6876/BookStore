package com.bookstoreapi.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstoreapi.Model.Transactions;

public interface TransactionRepo extends JpaRepository<Transactions,Long> {
    Optional<List<Transactions>> findByUserIdEquals(long userId);

    List<Transactions> findAllByUserIdEquals(long userId);

	

}