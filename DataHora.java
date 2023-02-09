import static java.lang.Double.*;

public class DataHora{
  protected int dia;
  protected int mes;
  protected int ano;
  protected int hora;
  protected int minuto;

  
  public DataHora(){}

  
  // Geral
  public DataHora(int dia, int mes, int ano, int hora, int minuto){
    setDia(dia);
    setMes(mes);
    this.ano = ano;
    setHora(hora);
    setMinuto(minuto);
  }

  // Data
  public DataHora(int d, int m, int a){
    setDia(d);
    setMes(m);
    ano = a;   
  }

  // Hora
  public DataHora(int h, int m){
    setHora(h);
    setMinuto(m);
  }

  public DataHora(int time){
    setTime(time);
  }

  // ============== DATA ================
  public String getDia(){
    if (dia < 10) {
      return "0" + dia;
    }
    return "" + dia;
  }

  public void setDia(int d){
    if (d < 1) {
      dia = 1;
    } else if (d > 31) {
      dia = 31;
    } else {
      dia = d;
    }
  }

  public String getMes(){
    if (mes < 10) {
      return "0" + mes;
    }
    return "" + mes;
  }

  public void setMes(int m){
    if (m < 1) {
      mes = 1;
    } else if (m > 12) {
      mes = 12;
    } else {
      mes = m;
    }
  }

  public int getAno(){
    return ano;
  }

  public void setAno(int a){
    ano = a;
  }

  // =========== HORA =============

  public String getHora(){
    if (hora < 10) {
      return "0" + hora;
    }
    return "" + hora;
  }

  public void setHora(int h){
    hora = h;
  }

  public String getMinuto(){
    if (minuto < 10) {
      return "0" + minuto;
    }
    return "" + minuto;
  }

  public void setMinuto(int m){
    minuto = m;
  }

  // =============== TO STRING ================

  public String DataStr(){
    return getDia() + "/" + getMes() + "/" + ano;
  }

  public String HoraStr(){
    return getHora() + ":" + getMinuto(); 
  }

  public String AllString(){
    return "Data: " + getDia() + "/" + getMes() + "/" + ano + "\nHora: " + getHora() + ":" + getMinuto(); 
  }

  public double formatoYmdHM(){
    return Double.parseDouble(ano + "" + getMes() + "" + getDia() + "" + getHora() + "" + getMinuto()); 
  }

  public int toTime(){
    return (((((ano * 12) + mes) * 30 + dia) * 24 + hora) * 60 + minuto); 
  }

  public void setTime(int time){
    this.ano = time / (60 * 24 * 30 * 12);
    time -= time / (60 * 24 * 30 * 12);
    this.mes = time / (60 * 24 * 30);
    time -= time / (60 * 24 * 30);
    this.dia = time / (60 * 24);
    time -= time / (60 * 24);
    this.hora = time / 60;
    time -= time / 60;
    this.minuto = time; 
  }

}