package br.com.uol.brasil.controller;

import java.net.URI;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.uol.brasil.dto.RegionalDto;
import br.com.uol.brasil.form.Regionalform;
import br.com.uol.brasil.modelo.Regiao;
import br.com.uol.brasil.modelo.Regional;
import br.com.uol.brasil.repository.RegiaoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "apiRestBrasilRegionalização")
@RestController
@RequestMapping("/regioes")
public class RegiaoController {

	@Autowired
	private RegiaoRepository regiaoRepository;

	@ApiOperation(value = "Cadastrar dados Regionais ")
	@PostMapping
	public ResponseEntity<RegionalDto> cadastrar(@RequestBody @Validated Regionalform form,
			UriComponentsBuilder uriBuilder) {
		Regional regional = form.converter();
		regiaoRepository.save(regional);

		URI uri = uriBuilder.path("/regioes/{id}").buildAndExpand(regional.getId()).toUri();
		return ResponseEntity.created(uri).body(new RegionalDto(regional));

	}

	@ApiOperation(value="Listar Área  por ordem crescente ")
	@GetMapping("/area")
	public Page<RegionalDto> listaArea(@RequestParam(required = false) Double area,
			@PageableDefault(sort = "area", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		if (area == null) {
			Page<Regional> regional = regiaoRepository.findAll(paginacao);
			return RegionalDto.converter(regional);
		} else {
			Page<Regional> regional = regiaoRepository.findByArea(area, paginacao);
			return RegionalDto.converter(regional);
		}
	}

	@ApiOperation(value="Filtrar por Região ")
	@GetMapping ("/regiao")
	public Page<RegionalDto> listaRegiao(@RequestParam(required = false) Regiao regiao,
			@PageableDefault(sort = "regiao", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		if (regiao == null) {
			Page<Regional> regional = regiaoRepository.findAll(paginacao);
			return RegionalDto.converter(regional);
		} else {
			Page<Regional> regional = regiaoRepository.findBynomeRegiao(regiao, paginacao);
			return RegionalDto.converter(regional);
		}
	}

	@ApiOperation(value="Listar População ordem crescente ")
	@GetMapping("/populacao")
	public Page<RegionalDto> listaPopulacao(@RequestParam(required = false) String populacao,
			@PageableDefault(sort = "populacao", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		if (populacao == null) {
			Page<Regional> regional = regiaoRepository.findAll(paginacao);
			return RegionalDto.converter(regional);
		} else {
			Page<Regional> regional = regiaoRepository.findByPopulacao(populacao, paginacao);
			return RegionalDto.converter(regional);
		}
	}
	@ApiOperation(value="Detalhar Regional por id")
	@GetMapping("/{id}")
	public ResponseEntity<RegionalDto> detalhar(@PathVariable Long id) {
		Optional<Regional> regional = regiaoRepository.findById(id);
		if (regional.isPresent()) {
			return ResponseEntity.ok(new RegionalDto(regional.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value="Atualizar por id")
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<RegionalDto> atualizar(@PathVariable Long id, @RequestBody @Valid Regionalform form) {
		Optional<Regional> regional = regiaoRepository.findById(id);
		if (regional.isPresent()) {
			Regional opcional = form.atualizar(id, regiaoRepository);
			return ResponseEntity.ok(new RegionalDto(opcional));
		}

		return ResponseEntity.notFound().build();
	}
	@ApiOperation(value="Remover por id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Regional> optional = regiaoRepository.findById(id);
		if (optional.isPresent()) {
			regiaoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}
