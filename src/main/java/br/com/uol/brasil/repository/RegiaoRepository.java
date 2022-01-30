package br.com.uol.brasil.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.uol.brasil.modelo.Regiao;
import br.com.uol.brasil.modelo.Regional;

@Repository
public interface RegiaoRepository extends JpaRepository<Regional, Long> {

	

	Page<Regional> findByPopulacao(String populacao, Pageable paginacao);

	Page<Regional> findBynomeRegiao(@RequestParam("regiao")Regiao regiao,Pageable paginacao);

	Page<Regional> findByArea(Double area,Pageable paginacao);

	
	
	
	
	

}
