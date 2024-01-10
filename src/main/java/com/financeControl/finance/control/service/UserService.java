package com.financeControl.finance.control.service;

import com.financeControl.finance.control.dto.ContaDTO;
import com.financeControl.finance.control.dto.UserDTO;
import com.financeControl.finance.control.entity.Conta;
import com.financeControl.finance.control.entity.User;
import com.financeControl.finance.control.repository.ContaRepository;
import com.financeControl.finance.control.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ContaRepository contaRepository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> data = userRepository.findAll();
        return (List<UserDTO>) data.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return new UserDTO(user.get());
    }
    @Transactional
    public UserDTO insert(UserDTO user) {
        User entity = new User();
        updateData(user, entity);
        entity = userRepository.save(entity);
        UserDTO userDTO = new UserDTO(entity);

        Conta entityConta = createConta(userDTO);
        contaRepository.save(entityConta);
        return userDTO;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public UserDTO update(UserDTO user, Long id) {
        User entity = userRepository.getReferenceById(id);
        updateData(user, entity);
        entity = userRepository.save(entity);
        return new UserDTO(entity);
    }

    private void updateData(UserDTO user, User entity) {
        entity.setName(user.getName());
        entity.setIdade(user.getIdade());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
        entity.setPassword(user.getPassword());
    }

    private Conta createConta(UserDTO user) {
        Conta conta = new Conta();
        User entityUser = userRepository.getReferenceById(user.getId());
        conta.setSaque(0.0);
        conta.setDeposito(0.0);
        conta.setSaldo(0.0);
        conta.setUser(entityUser);

        return conta;
    }
}
