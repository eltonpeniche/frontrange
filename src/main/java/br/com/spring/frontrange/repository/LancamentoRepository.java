package br.com.spring.frontrange.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.spring.frontrange.modelo.Lancamento;
import br.com.spring.frontrange.modelo.TipoLancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

//	List<Lancamento> findByTipolancamento(TipoLancamento tipoLancamento);

//	//mesmo resultado da Query acima gerada automaticamente
	@Query("SELECT l FROM Lancamento l WHERE l.tipolancamento = :tipoLancamento")
	Page <Lancamento> buscarPorTipoDeLancamento(@Param("tipoLancamento") TipoLancamento tipoLancamento, Pageable paginacao );
	

}
