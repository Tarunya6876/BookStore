package com.bookstoreapi.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
	@Table(name = "wallet")
	public class Wallet {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long walletId;

	    private long userId;
	    private double walletAmount;

	    @CreationTimestamp
	    private Date createdAt;

	    @UpdateTimestamp
	    private Date updatedAt;

	    public long getWalletId() {
	        return walletId;
	    }

	    public void setWalletId(long walletId) {
	        this.walletId = walletId;
	    }

	    public long getUserId() {
	        return userId;
	    }

	    public void setUserId(long userId) {
	        this.userId = userId;
	    }

	    public double getWalletAmount() {
	        return walletAmount;
	    }

	    public void setWalletAmount(double walletAmount) {
	        this.walletAmount = walletAmount;
	    }
	}
