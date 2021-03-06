package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	
	private Integer numeroDoQuarto;
	private Date dataDeEntrada;
	private Date dataDeSaida;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroDoQuarto, Date dataDeEntrada, Date dataDeSaida){
		if (!dataDeSaida.after(dataDeEntrada)){
			throw new DomainException("A data de sa�da precisa ser posterior � data de entrada.");
		}
		
		this.numeroDoQuarto = numeroDoQuarto;
		this.dataDeEntrada = dataDeEntrada;
		this.dataDeSaida = dataDeSaida;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getDataDeEntrada() {
		return dataDeEntrada;
	}
	
	public Date getDataDeSaida() {
		return dataDeSaida;
	}

	public long duracao() {
		long dif = dataDeSaida.getTime() - dataDeEntrada.getTime(); // transmorma as datas de entrada e saida em milisegundos
		
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS); //converte os milisegundos em data
	}
	
	public void atualizaData(Date dataDeEntrada, Date dataDeSaida){
		Date agora = new Date();
		
		if (dataDeEntrada.before(agora) || dataDeSaida.before(agora)) {
			throw new DomainException("As datas para atualiza��es devem ser datas futuras.");
		}
		if (!dataDeSaida.after(dataDeEntrada)){
			throw new DomainException("A data de sa�da precisa ser posterior � data de entrada.");
		}
		
		this.dataDeEntrada = dataDeEntrada;
		this.dataDeSaida = dataDeSaida;
	}
	
	@Override
	public String toString() {
		return  "Quarto " +
				this.numeroDoQuarto +
				" \nData de entrada: " +
				sdf.format(dataDeEntrada) +
				" \nData de sa�da: " +
				sdf.format(dataDeSaida) +
				", " + 
				duracao() + 
				" noites\n";
	}
}
