package org.example;

import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        cumple_repository REPO = new cumple_repository();
        Scanner SC = new Scanner(System.in);
        boolean SALIR = false;

        while (!SALIR) {

            System.out.println(constantes.AGENDA);
            System.out.println(constantes.LISTAR);
            System.out.println(constantes.DIA);
            System.out.println(constantes.NOMBRE);
            System.out.println(constantes.AÑADIR);
            System.out.println(constantes.ELIMINAR);
            System.out.println(constantes.SALR);
            System.out.print(constantes.OPCION);

            String opcion = SC.nextLine();

            switch (opcion) {

                case "1":
                    List<cumple_agenda> lista = REPO.GetLista();
                    if (lista.isEmpty()) {
                        System.out.println(constantes.VACIO);
                    } else {
                        for (cumple_agenda c : lista) {
                            System.out.println(c.GetNombre() + ": " + c.GetDia() + "/" + c.GetMes());
                        }
                    }
                    break;

                case "2":
                    System.out.print(constantes.DIAAA);
                    int DIA = Integer.parseInt(SC.nextLine());
                    List<cumple_agenda> porDia = REPO.BuscarPorDia(DIA);

                    if (porDia.isEmpty()) {
                        System.out.println(constantes.SINRESULTADOS);
                    } else {
                        for (cumple_agenda c : porDia) {
                            System.out.println(c.GetNombre() + ": " + c.GetDia() + "/" + c.GetMes());
                        }
                    }
                    break;

                case "3":
                    System.out.print(constantes.NOMBREEE);
                    String NOMBRE_BUSCAR = SC.nextLine();
                    cumple_agenda encontrado = REPO.BuscarPorNombre(NOMBRE_BUSCAR);

                    if (encontrado == null) {
                        System.out.println(constantes.NOENCONTRADO);
                    } else {
                        System.out.println(encontrado.GetNombre() + ": " +
                                encontrado.GetDia() + "/" + encontrado.GetMes());
                    }
                    break;

                case "4":
                    System.out.print(constantes.NOMBREE);
                    String NOMBRE = SC.nextLine();
                    System.out.print(constantes.DIAA);
                    int D = Integer.parseInt(SC.nextLine());
                    System.out.print(constantes.MES);
                    int M = Integer.parseInt(SC.nextLine());

                    REPO.AddCumple(new cumple_agenda(NOMBRE, D, M));
                    break;

                case "5":
                    System.out.print(constantes.NOMBREAELIMINAR);
                    String NOMBRE_ELIM = SC.nextLine();
                    REPO.EliminarPorNombre(NOMBRE_ELIM);
                    break;

                case "6":
                    SALIR = true;
                    break;
            }
        }
    }
}
