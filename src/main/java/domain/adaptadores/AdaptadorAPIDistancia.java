package domain.adaptadores;

import domain.Destino;
import java.time.LocalTime;

public interface AdaptadorAPIDistancia {

  public LocalTime obtenerDemora(Destino origen, Destino destino);

}
