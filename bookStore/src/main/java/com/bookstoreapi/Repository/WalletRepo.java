package com.bookstoreapi.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.bookstoreapi.Model.Book;
import com.bookstoreapi.Model.Wallet;

public interface WalletRepo extends JpaRepository<Wallet,Long>{
	Optional<Wallet> findByUserIdEquals(long userId);

}
