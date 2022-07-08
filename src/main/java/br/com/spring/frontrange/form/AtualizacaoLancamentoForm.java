package br.com.spring.frontrange.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.spring.frontrange.modelo.Lancamento;
import br.com.spring.frontrange.modelo.TipoLancamento;
import br.com.spring.frontrange.repository.LancamentoRepository;

public class AtualizacaoLancamentoForm {
	
	private LocalDate data;
	private String descricao;
	private BigDecimal valor;
	private TipoLancamento tipolancamento;
	
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public TipoLancamento getTipolancamento() {
		return tipolancamento;
	}
	public void setTipolancamento(TipoLancamento tipolancamento) {
		this.tipolancamento = tipolancamento;
	}
	public Lancamento atualizar(Long id, LancamentoRepository lancamentoRepository) {
		Lancamento lancamento = lancamentoRepository.getReferenceById(id);
		
		if (this.data!= null) lancamento.setData(this.data);;
		if (this.descricao!= null) lancamento.setDescricao(this.descricao);
		if (this.valor!= null) lancamento.setValor(this.valor);
		if (this.tipolancamento!= null) lancamento.setTipolancamento(this.tipolancamento);
		
		return lancamento;
	}
	
}
