package br.com.spring.frontrange.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

import br.com.spring.frontrange.dto.LancamentosDto;
import br.com.spring.frontrange.form.AtualizacaoLancamentoForm;
import br.com.spring.frontrange.form.LancamentoForm;
import br.com.spring.frontrange.modelo.Lancamento;
import br.com.spring.frontrange.modelo.TipoLancamento;
import br.com.spring.frontrange.repository.LancamentoRepository;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

		@Autowired
		private LancamentoRepository lancamentoRepository;
		
		
		@GetMapping
		@Cacheable(value = "listaLancamentos")
		public Page<LancamentosDto> listaLancamentos(@RequestParam(required = false) String tipoLancamento,
				@PageableDefault(sort= "data", direction = Direction.ASC, page = 0, size = 5) Pageable paginacao ){
			
			Page<Lancamento> listaDeLancamentos;
				
			if(tipoLancamento == null) {
				listaDeLancamentos = lancamentoRepository.findAll(paginacao);
			}else {

				listaDeLancamentos = lancamentoRepository.buscarPorTipoDeLancamento(TipoLancamento.valueOf(tipoLancamento.toUpperCase()), paginacao);
			}
			return LancamentosDto.converter(listaDeLancamentos);
		}
		
		@PostMapping
		@Transactional
		@CacheEvict(value = "listaLancamentos", allEntries = true )
		public ResponseEntity<LancamentosDto> cadastrarLancamentos(@RequestBody @Valid LancamentoForm form, UriComponentsBuilder uriBuider){
			Lancamento lancamento = form.converter();
			System.out.println("salvando" + form );
			lancamentoRepository.save(lancamento);

			URI uri = uriBuider.path("/lancamentos/{id}").buildAndExpand(lancamento.getId()).toUri();
			return ResponseEntity.created(uri).body(new LancamentosDto(lancamento));
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<LancamentosDto> detalhar (@PathVariable Long id) {
			Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
			if(lancamento.isPresent()) {
				return ResponseEntity.ok(new LancamentosDto(lancamento.get())) ;
				
			}
			return ResponseEntity.notFound().build();
		}
		
		@PutMapping("/{id}")
		@Transactional
		@CacheEvict(value = "listaLancamentos", allEntries = true )
		public ResponseEntity<LancamentosDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoLancamentoForm form){
			Optional<Lancamento> optional = lancamentoRepository.findById(id);
			if(optional.isPresent()) {
				Lancamento lancamento = form.atualizar(id, lancamentoRepository);
				return ResponseEntity.ok(new LancamentosDto(lancamento));
			}
			return ResponseEntity.notFound().build();
		}
		
		@DeleteMapping("/{id}")
		@Transactional
		@CacheEvict(value = "listaLancamentos", allEntries = true )
		public ResponseEntity<?> remover(@PathVariable Long id){
			Optional<Lancamento> optional = lancamentoRepository.findById(id);
			if(optional.isPresent()) {
				lancamentoRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.notFound().build();
		}
		
		
}
			
