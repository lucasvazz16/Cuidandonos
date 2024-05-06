package domain;


import domain.usuario.Cuidador;
import java.util.List;

public class Destino {

  private Integer latitud;
  private Integer longitud;
  private Integer ordenDeRecorrido;
  private Long tiempoDeParada; //En minutos
  private Boolean notificarSalud;

  public Long tiempoDeParada() {
    return tiempoDeParada;
  }

  public Integer latitud() {
    return latitud;
  }

  public Integer longitud() {
    return longitud;
  }

  public void notificarLlegadaAPunto(Viaje viaje){

    viaje.cuidadores().forEach(cuidador ->
    {viaje.transeunte().notificaciones.enviarNotificacion("Estoy bien",cuidador);});

  }
}
