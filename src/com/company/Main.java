package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        Casilla casilla=new Casilla();
        boolean salir =false;
        int eleccion=0;
        float ventas=0;

        do{
            System.out.println("Dime una opción");
            System.out.println("1. Pedir golosina");
            System.out.println("2. Mostrar golosina");
            System.out.println("3. Rellenar golosinas");
            System.out.println("4. Apagar maquina");
            try {
                eleccion = scanner.nextInt();
            }catch (Exception e){
                scanner.nextLine();
                System.out.println("Opción no valida");
            }
            if (eleccion>0 && eleccion<5){
                switch (eleccion){
                    case 1:
                        ventas=pedirGolosina(casilla,ventas);
                        break;
                    case 2:
                        mostrarGolosina(casilla);
                        break;
                    case 3:
                        rellenarGolosina(casilla);
                        break;
                    case 4:
                        apagarMaquina(ventas);
                        salir=true;
                }
            }
        }while (!salir);
    }
    public static float pedirGolosina(Casilla casilla, float ventas){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Dime la posicion");
        try {
            int posisicion = scanner.nextInt();
            int fila = posisicion/10;
            int columna = posisicion%10;
            if (fila>=0 && fila<4&&columna>=0 && columna<4){
                if (casilla.getCantidad(fila, columna)>0){
                    System.out.println("Toma tu producto "+casilla.getNombresGolosinas(fila,columna));
                    casilla.disminuirCantidad(fila,columna);
                    ventas += casilla.getPrecio(fila,columna);
                }else System.out.println("No queda producto");
            }else System.out.println("Posicion no valida");
        }catch (Exception e){
            scanner.nextLine();
            System.out.println("Dato no correcto");
        }
        return ventas;
    }
    public static void mostrarGolosina(Casilla casilla){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(casilla.getCantidad(i,j)>0){
                    System.out.println("En la casilla "+i+""+j+" tienes: "+casilla.getNombresGolosinas(i,j)+" \n Y cuesta: "+casilla.getPrecio(i,j));
                }
            }
        }
    }
    public static void rellenarGolosina(Casilla casilla){
        Scanner scanner=new Scanner(System.in);
        String contrasenya="";
        System.out.println("Dime la contraseña");
        try{
            contrasenya= scanner.nextLine();
        }catch (Exception e){
            System.out.println("Dato no correcto");
        }
        if (contrasenya.equals("MaquinaExpendedora2020")){
            System.out.println("Dime la posisicion");
            try{
                int posisicion= scanner.nextInt();
                int fila = posisicion/10;
                int columna = posisicion%10;
                if (fila>=0 && fila<4&&columna>=0 && columna<4){
                    System.out.println("Dime la cantidad a rellenar");
                    int cantidad= scanner.nextInt();
                    casilla.setCantidad(cantidad,fila,columna);
                }else System.out.println("Posicion no valida");
            }catch (Exception e){
                scanner.nextLine();
                System.out.println("Dato no correcto");
            }
        }else System.out.println("Contraseña incorrecta");
    }
    public static void apagarMaquina(float ventas){
        System.out.println("El total recaudado por la maquina es: "+ventas+" €");
    }
}
