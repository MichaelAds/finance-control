package com.financeControl.finance.control.service;

import com.financeControl.finance.control.dto.ContaDTO;
import com.financeControl.finance.control.entity.Conta;
import com.financeControl.finance.control.entity.User;
import com.financeControl.finance.control.repository.ContaRepository;
import com.financeControl.finance.control.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContaService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ContaRepository contaRepository;


    @Transactional
    public ContaDTO insert(ContaDTO dto) {
        Conta entity = new Conta();
        updateData(dto, entity);
        entity = contaRepository.save(entity);
        return new ContaDTO(entity);
    }
    @Transactional(readOnly = true)
    public Page<ContaDTO> findAll(Pageable pageable) {
        Page<Conta> result = contaRepository.findAll(pageable);
        return result.map(x -> new ContaDTO(x));
    }

    private void updateData(ContaDTO dto, Conta entity) {
        entity.setSaldo(dto.getSaldo());
        entity.setDeposito(dto.getDeposito());
        entity.setSaque(dto.getSaque());
        User user = userRepository.getReferenceById(dto.getUserDTO().getId());
        entity.setUser(user);

    }
}
