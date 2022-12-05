package com.bookstoreapi.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreapi.Model.Transactions;
import com.bookstoreapi.Repository.TransactionRepo;



@Service
@Transactional
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    public List<Transactions> getAllTransactions(){
        return this.transactionRepo.findAll();
    }

    public List<Transactions> getAllTransactionsOfUser(long userId){
        Optional<List<Transactions>> transactions = this.transactionRepo.findByUserIdEquals(userId);
        if(transactions.isPresent()){
            return transactions.get();
        }else{
            throw new NullPointerException();
        }
    }
    public Transactions addTransactionByDetail(long userId, long walletId, int bookId, double amount, String status){
        Transactions tr = new Transactions();
        tr.setUserId(userId);
        tr.setWalletId(walletId);
        tr.setBookId(bookId);
        tr.setAmount(amount);
        return this.transactionRepo.save(tr);
    }

    public Transactions addFirstTransaction(long wallet_id, long user_id, String status){
        Transactions t = new Transactions();
        t.setUserId(user_id);
        t.setBookId(0);
        t.setWalletId(wallet_id);
        t.setAmount(0);
        return this.transactionRepo.save(t);
    }

	public Transactions createTransaction(Transactions tran) {
		// TODO Auto-generated method stub
		//return null;
		return transactionRepo.save(tran);
	}
}
    
