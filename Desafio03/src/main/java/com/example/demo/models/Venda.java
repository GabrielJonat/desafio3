package com.example.demo.models;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity

public class Venda {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private LocalDateTime data;

	    @ManyToMany
	    @JoinTable(
	      name = "venda_produto",
	      joinColumns = @JoinColumn(name = "venda_id"),
	      inverseJoinColumns = @JoinColumn(name = "produto_id"))
	    private List<Produto> produtos;
	    
	    private Double total = 0D;
	    
	    private String realizador;
	    
	    public Venda() {
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDateTime getData() {
			return data;
		}

		public void setData(LocalDateTime data) {
			this.data = data;
		}

		public List<Produto> getProdutos() {
			return produtos;
		}

		public void setProdutos(List<Produto> produtos) {
			this.produtos = produtos;
			total = produtos.stream().mapToDouble(produto -> produto.getPreco()).sum();
		}

		public Double getTotal() {
			return total;
		}

		public String getVendedor() {
			return realizador;
		}

		public void setVendedor(String realizador) {
			this.realizador = realizador;
		}
		
		
	    
	}
