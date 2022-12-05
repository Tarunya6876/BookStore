package com.bookstoreapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreapi.Model.User;
import com.bookstoreapi.Model.Wallet;
import com.bookstoreapi.Repository.WalletRepo;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class WalletService {
    @Autowired
    private WalletRepo walletRepo;

    @Autowired
    private TransactionService transactionService;
    public Wallet getWalletByUserId(long userId){
        Optional<Wallet> walletObj = this.walletRepo.findByUserIdEquals(userId);
        if(walletObj.isPresent()){
                return walletObj.get();
        }else {
            throw new NullPointerException();
        }
    }
 

    public void addWallet(long userId){
        Wallet w = new Wallet();
        w.setUserId(userId);
        w.setWalletAmount(0);
        Wallet savedWallet = this.walletRepo.save(w);
        this.transactionService.addFirstTransaction(savedWallet.getWalletId(),userId,"Opened Account");
    }
    public Wallet updateWallet(Wallet wallet){
        Wallet updateWallet = getWalletByUserId(wallet.getUserId());
        updateWallet.setUserId(wallet.getUserId());
        updateWallet.setWalletId(wallet.getWalletId());
        updateWallet.setWalletAmount(wallet.getWalletAmount());
        return this.walletRepo.save(updateWallet);
    }

    public Wallet addMoneyInWallet(long userId, double amount){
        Wallet wallet = getWalletByUserId(userId);
        wallet.setWalletAmount(wallet.getWalletAmount()+amount);
        return updateWallet(wallet);
    }

    public Wallet addMoneyInWalletByAPi(long userId, double amount){
        Wallet wallet = getWalletByUserId(userId);
        wallet.setWalletAmount(wallet.getWalletAmount()+amount);
        Wallet wallUpd = updateWallet(wallet);
        this.transactionService.addFirstTransaction(wallUpd.getWalletId(),userId,"Recharge");
        return wallUpd;
    }
    public Wallet deductMoneyInWallet(long userId, double amount){
        Wallet wallet = getWalletByUserId(userId);
        wallet.setWalletAmount(wallet.getWalletAmount()-amount);
        return updateWallet(wallet);
    }

    public double checkBalance(long userId){
        return getWalletByUserId(userId).getWalletAmount();
    }
	public Wallet createWal(Wallet wal) {
		// TODO Auto-generated method stub
		return walletRepo.save(wal);
		//return null;
	}
}