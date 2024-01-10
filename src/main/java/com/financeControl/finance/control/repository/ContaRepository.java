package com.financeControl.finance.control.repository;

import com.financeControl.finance.control.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
