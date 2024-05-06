package domain;


import domain.adaptadores.APIDistancia;
import domain.adaptadores.AdaptadorAPIDistancia;
import domain.usuario.Cuidador;
import domain.usuario.Transeunte;

import java.time.LocalTime;
import java.util.List;

public class Viaje {

 private List<Destino> recorrido;
 private List<Cuidador> cuidadores;
 private Transeunte transeunte;
 private AdaptadorAPIDistancia adaptador;
 private List<LocalTime> demoras; //guardamos las demoras por seccion y en caso de que no deternse en cada parada
                                      //solo se agrega la demora total

  public List<Cuidador> cuidadores() {
    return cuidadores;
  }

  public Transeunte transeunte() {
    return transeunte;
  }

  public void llegadaAPunto(Destino punto){
  punto.notificarLlegadaAPunto(this);
 }

public void terminarViaje(){

 }

 public void CalcularTiempoDeDemora(){

  for(Integer i = 0; i<recorrido.size()-1; i++){
     Destino origen = recorrido.get(i);
     Destino destino = recorrido.get(i+1);
     LocalTime tiempoDeRecorrido = adaptador.obtenerDemora(origen,destino);
     demoras.add(tiempoDeRecorrido.plusMinutes(destino.tiempoDeParada()));
  }
 }
}
