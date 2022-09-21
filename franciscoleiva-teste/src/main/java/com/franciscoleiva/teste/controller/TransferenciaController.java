package com.franciscoleiva.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.franciscoleiva.teste.model.Transferencia;
import com.franciscoleiva.teste.repository.TransferenciaRepository;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	@GetMapping
	public List<Transferencia> listarTransferencias() {
		return transferenciaRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Transferencia adicionarTransferencia(@RequestBody Transferencia transferencia) throws Exception {

		if ((transferencia.getDataAgendamento().isEqual(transferencia.getDataTransferencia()))
				|| (transferencia.getValorTransferencia() <= 1000)) {

			transferencia.setTaxa(3 + (transferencia.getValorTransferencia() * 0.03));

		} else if (((transferencia.getDataAgendamento().isBefore(transferencia.getDataTransferencia().plusDays(10))
				&& (transferencia.getDataAgendamento().isAfter(transferencia.getDataTransferencia())))
				|| ((transferencia.getValorTransferencia() > 1000)
						&& (transferencia.getValorTransferencia() <= 2000)))) {

			transferencia.setTaxa(12);

		} else if ((transferencia.getDataTransferencia().isAfter(transferencia.getDataAgendamento().plusDays(10)))
				&& (transferencia.getDataTransferencia().isBefore(transferencia.getDataAgendamento().plusDays(20)))) {

			transferencia.setTaxa(transferencia.getValorTransferencia() * 0.82);

		} else if ((transferencia.getDataTransferencia().isAfter(transferencia.getDataAgendamento().plusDays(20)))
				&& (transferencia.getDataTransferencia().isBefore(transferencia.getDataAgendamento().plusDays(30)))) {

			transferencia.setTaxa(transferencia.getValorTransferencia() * 0.69);

		} else if ((transferencia.getDataTransferencia().isAfter(transferencia.getDataAgendamento().plusDays(30)))
				&& (transferencia.getDataTransferencia().isBefore(transferencia.getDataAgendamento().plusDays(420)))) {

			transferencia.setTaxa(transferencia.getValorTransferencia() * 0.47);

		} else if (transferencia.getDataTransferencia().isAfter(transferencia.getDataAgendamento().plusDays(40))) {

			transferencia.setTaxa(transferencia.getValorTransferencia() * 0.17);
		} else {
			throw new Exception("TAXA NÃO APLICAVEL");
		}

		return transferenciaRepository.save(transferencia);
	}

}
