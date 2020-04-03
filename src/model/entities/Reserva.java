package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numeroDoQuarto;
	private Date dataDeEntrada;
	private Date dataDeSaida;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroDoQuarto, Date dataDeEntrada, Date dataDeSaida) {
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
	
	public String atualizaData(Date dataDeEntrada, Date dataDeSaida) {
		Date agora = new Date();
		
		if (dataDeEntrada.before(agora) || dataDeSaida.before(agora)) {
			return "As datas para atualizações devem ser datas futuras.";
		}
		if (!dataDeSaida.after(dataDeEntrada)){
			return "A data de saída precisa ser posterior à data de entrada.";
		}
		
		this.dataDeEntrada = dataDeEntrada;
		this.dataDeSaida = dataDeSaida;
		
		return null;
	}
	
	@Override
	public String toString() {
		return  "Reserva: \nQuarto " +
				this.numeroDoQuarto +
				" \nData de entrada: " +
				sdf.format(dataDeEntrada) +
				" \nData de saída: " +
				sdf.format(dataDeSaida) +
				", " + 
				duracao() + 
				" noites\n";
	}
}
