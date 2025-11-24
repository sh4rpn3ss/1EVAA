package org.example;
/**
 * cumplereopsitory
 *
 * @author sh4rpn3ss
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;

public class Cumple_repository {

    private List<Cumple_agenda> lista = new ArrayList<>();

    public List<Cumple_agenda> getLista() {
        return lista;
    }

    public void addCumple(Cumple_agenda cumple) {
        lista.add(cumple);
    }

    public Cumple_agenda buscarPorNombre(String nombre) {
        for (Cumple_agenda c : lista) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public List<Cumple_agenda> buscarPorDia(int dia) {
        List<Cumple_agenda> resultado = new ArrayList<>();
        for (Cumple_agenda c : lista) {
            if (c.getDia() == dia) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public boolean eliminarPorNombre(String nombre) {
        Cumple_agenda encontrado = buscarPorNombre(nombre);
        if (encontrado != null) {
            lista.remove(encontrado);
            return true;
        }
        return false;
    }
}
