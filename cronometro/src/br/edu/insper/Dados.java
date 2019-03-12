package br.edu.insper;

import java.sql.Date;

public class Dados {
	
	private Integer id;
	private Integer hora;
	private Integer minuto;
	private Integer segundo;
	private Date data;
	
	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	
	public Integer getHora() {return this.hora;}
	public void setHora(Integer hora) {this.hora = hora;}
	
	public Integer getMinuto() {return this.minuto;}
	public void setMinuto(Integer minuto) {this.minuto = minuto;}
	
	public Integer getSegundo() {return this.segundo;}
	public void setSegundo(Integer segundo) {this.segundo = segundo;}
	
	public Date getData() {return this.data;}
	public void setData(Date data) {this.data = data;}
}
