package br.com.spring.frontrange.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lancamento {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate data;
	private String descricao;
	private BigDecimal valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario autor;
	
	@Enumerated(EnumType.STRING) 
	private TipoLancamento tipolancamento;
	
	public Lancamento() {

	}
	public Lancamento(LocalDate data, String descricao, BigDecimal valor, TipoLancamento tipoLancamento ) {
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
		this.tipolancamento = tipoLancamento;
	}
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
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
}
