package com.financeControl.finance.control.controller;

import com.financeControl.finance.control.dto.ContaDTO;
import com.financeControl.finance.control.service.ContaService;
import jakarta.persistence.JoinColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {
    @Autowired
    ContaService contaService;

    @PostMapping
    public ResponseEntity<ContaDTO> insert(@RequestBody ContaDTO dto) {
        dto = contaService.insert(dto);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ContaDTO>> findAll(Pageable pageable) {
        Page<ContaDTO> contas = contaService.findAll(pageable);
        return ResponseEntity.ok(contas);
    }
}
