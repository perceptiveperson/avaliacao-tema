package br.com.tema.exception.details;

public class CartaInvalidaDetails {
	
	private String titulo;
	private int status;
	private String detalhes;
	private long timestamp;		
	
	private CartaInvalidaDetails(String titulo, int status, String detalhes, long timestamp) {
		super();
		this.titulo = titulo;
		this.status = status;
		this.detalhes = detalhes;
		this.timestamp = timestamp;
	}
	public String getTitulo() {
		return titulo;
	}
	public int getStatus() {
		return status;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public long getTimestamp() {
		return timestamp;
	}
	
	public static final class Builder{
		private String titulo;
		private int status;
		private String detalhes;
		private long timestamp;
	
		public static Builder newInstance() {
			return new Builder();
		}

		public Builder titulo(String titulo) {
			this.titulo = titulo;
			return this;
		}

		public Builder status(int status) {
			this.status = status;
			return this;
		}

		public Builder detalhes(String detalhes) {
			this.detalhes = detalhes;
			return this;
		}

		public Builder timestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}
		
		public CartaInvalidaDetails builder() {
			return new CartaInvalidaDetails(titulo, status, detalhes, timestamp);
		}
	}	

}
