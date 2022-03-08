package com.kenny.demo.transactionaldemo.repository;

import com.kenny.demo.transactionaldemo.domain.TransactionLog;
import com.kenny.demo.transactionaldemo.domain.TransactionLogPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionLogRepository extends JpaRepository<TransactionLog, TransactionLogPK> {
}
