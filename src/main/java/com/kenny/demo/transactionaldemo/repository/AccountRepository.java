package com.kenny.demo.transactionaldemo.repository;

import com.kenny.demo.transactionaldemo.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}
