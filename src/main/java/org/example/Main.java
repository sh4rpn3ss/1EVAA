package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Cumple_repository REPO = new Cumple_repository();
        Scanner SC = new Scanner(System.in);
        boolean SALIR = false;

        while (!SALIR) {

            System.out.println("\n=== AGENDA ===");
            System.out.println("1. Listar");
            System.out.println("2. Buscar por día");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Añadir");
            System.out.println("5. Eliminar");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            String opcion = SC.nextLine();

            switch (opcion) {

                case "1":
                    List<Cumple_agenda> lista = REPO.getLista();
                    if (lista.isEmpty()) {
                        System.out.println("Vacío.");
                    } else {
                        for (Cumple_agenda c : lista) {
                            System.out.println(c.getNombre() + ": " + c.getDia() + "/" + c.getMes());
                        }
                    }
                    break;

                case "2":
                    System.out.print("Día: ");
                    int DIA = Integer.parseInt(SC.nextLine());
                    List<Cumple_agenda> porDia = REPO.buscarPorDia(DIA);

                    if (porDia.isEmpty()) {
                        System.out.println("Sin resultados.");
                    } else {
                        for (Cumple_agenda c : porDia) {
                            System.out.println(c.getNombre() + ": " + c.getDia() + "/" + c.getMes());
                        }
                    }
                    break;

                case "3":
                    System.out.print("Nombre: ");
                    String NOMBRE_BUSCAR = SC.nextLine();
                    Cumple_agenda encontrado = REPO.buscarPorNombre(NOMBRE_BUSCAR);

                    if (encontrado == null) {
                        System.out.println("No encontrado.");
                    } else {
                        System.out.println(encontrado.getNombre() + ": " +
                                encontrado.getDia() + "/" + encontrado.getMes());
                    }
                    break;

                case "4":
                    System.out.print("Nombre: ");
                    String NOMBRE = SC.nextLine();
                    System.out.print("Día: ");
                    int D = Integer.parseInt(SC.nextLine());
                    System.out.print("Mes: ");
                    int M = Integer.parseInt(SC.nextLine());

                    REPO.addCumple(new Cumple_agenda(NOMBRE, D, M));
                    break;

                case "5":
                    System.out.print("Nombre a eliminar: ");
                    String NOMBRE_ELIM = SC.nextLine();
                    REPO.eliminarPorNombre(NOMBRE_ELIM);
                    break;

                case "6":
                    SALIR = true;
                    break;
            }
        }
    }
}
