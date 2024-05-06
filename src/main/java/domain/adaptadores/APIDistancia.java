package domain.adaptadores;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.TravelMode;

import domain.Destino;
import java.time.LocalTime;


public class APIDistancia implements AdaptadorAPIDistancia {

  private GeoApiContext contexto;

  public APIDistancia(String apiKey) {
    this.contexto = new GeoApiContext.Builder()
        .apiKey(apiKey)
        .build();
  }
@Override
  public LocalTime obtenerDemora(Destino origen, Destino destino) {
    try {
      DistanceMatrix result = DistanceMatrixApi.newRequest(contexto)
          .origins(origen.latitud() + "," + origen.longitud())
          .destinations(destino.latitud() + "," + destino.longitud())
          .mode(TravelMode.WALKING)
          .await();

      DistanceMatrixRow[] rows = result.rows;
      if (rows.length > 0 && rows[0].elements.length > 0) {
        long tiempoEnMinutos = rows[0].elements[0].duration.inSeconds / 60;
        // Creamos un objeto LocalTime con el tiempo de demora
        return LocalTime.of((int) tiempoEnMinutos / 60, (int) tiempoEnMinutos % 60);
      } else {
        System.out.println("No se pudo obtener la demora");
        return null;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}

