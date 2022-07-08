package br.com.spring.frontrange.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.data.domain.Page;

import br.com.spring.frontrange.modelo.Lancamento;
import br.com.spring.frontrange.modelo.TipoLancamento;

public class LancamentosDto {
	
	private Long id;
	private LocalDate data;
	private String descricao;
	private BigDecimal valor;
	private TipoLancamento tipolancamento;
	

	public LancamentosDto(Lancamento l ) {
		this.id = l.getId();
		this.data = l.getData();
		this.descricao = l.getDescricao();
		this.valor = l.getValor();
		this.tipolancamento = l.getTipolancamento();
	}

	
	public String getData() {
		return this.data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		//return data;
	}
	public String getDescricao() {
		return descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public Long getId() {
		return id;
	}


	public TipoLancamento getTipolancamento() {
		return tipolancamento;
	}
	
	public static Page<LancamentosDto> converter(Page<Lancamento> lancamentos) {
		
		return lancamentos.map(LancamentosDto::new);
	}
}
