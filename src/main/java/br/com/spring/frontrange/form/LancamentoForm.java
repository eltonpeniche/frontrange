package br.com.spring.frontrange.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.spring.frontrange.modelo.Lancamento;
import br.com.spring.frontrange.modelo.TipoLancamento;

public class LancamentoForm {
	
	@NotNull
	private LocalDate data;
	private String descricao;
	@NotNull
	private BigDecimal valor;
	@NotNull
	private TipoLancamento tipolancamento;
	
	public LancamentoForm() {
	
	}
	
	public LancamentoForm(LocalDate data, String descricao, BigDecimal valor, TipoLancamento tipolancamento) {
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
		this.tipolancamento = tipolancamento;
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

	@Override
	public String toString() {
		return "LancamentoForm [data=" + data + ", descricao=" + descricao + ", valor=" + valor + ", tipolancamento="
				+ tipolancamento + "]";
	}

	public Lancamento converter() {
		
		return (new Lancamento(this.getData(), this.getDescricao(), this.getValor(), this.getTipolancamento()));
	
	}

	

}
