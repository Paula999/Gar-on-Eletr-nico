package projeto.pi.lanchonete.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		@NotBlank
		private String nome;
		@NotBlank
		private String preco;
		@NotNull
		private String descricao;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getPreco() {
			return preco;
		}
		public void setPreco(String preco) {
			this.preco = preco;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		@Override
		public String toString() {
			return "Cliente [id=" + id + ", nome=" + nome + ", preco=" + preco + ", descricao=" + descricao + "]";
		}
		
		
		
}
