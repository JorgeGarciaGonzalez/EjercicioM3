package com.company;

public class Casilla {
    private final String[][] nombresGolosinas = { {"KitKat", "Chicles de fresa", "Lacasitos", "Palotes"},
            {"Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix"},
            {"Kinder Choco", "M&M'S", "Papa Delta", "Chicles de menta"},
            {"Chicles Menta", "Crunch", "Milkybar", "KitKat Blanco"}};
    private final double[][] precio = { {1.1, 0.8, 1.5, 0.9},
            {1.8, 1, 1.2, 1},
            {1.8, 1.3, 1.2, 0.8},
            {1.5, 1.1, 1.1, 1.1}};
    private int cantidad[][]=new  int[4][4];

    public Casilla(){
        for (int i = 0; i < cantidad.length; i++) {
            for (int j = 0; j < cantidad[i].length; j++) {
                cantidad[i][j]= 5;
            }
        }
    }
    public int getCantidad(int fila,int columna) {
        return cantidad[fila][columna];
    }
    public void setCantidad(int cantidad, int fila, int columna) {
        this.cantidad[fila][columna] = cantidad;
    }
    public double getPrecio(int fila,int columna) {
        return precio[fila][columna];
    }
    public String getNombresGolosinas(int fila,int columna) {
        return nombresGolosinas[fila][columna];
    }
    public void disminuirCantidad(int fila, int columna){
        cantidad[fila][columna]--;
    }
}
