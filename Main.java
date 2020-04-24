package Algoritmo_Varilla;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @author: Juan David Navarro Rocha ID 567682 - Fredy Yovany Peña Sánchez ID 567004
 */

public class Main {

    static int[][] Dinamica;
    
    static int[][] Decisiones;
    
    static ArrayList<Gestion_Corte> Corte = new ArrayList<Gestion_Corte>();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int[] arr = {1,5,8,9,10,17,17,20,24,30}; 
        
        System.out.println("******************************************************************");
        
        System.out.println("*****************Aplicación Programación Dinámica*****************");
        
        System.out.println("Realizado por:"+"\n"+"Juan David Navarro Rocha ID 567682"+"\n"+"Fredy Yovany Peña Sánchez ID 567004"+"\n");
        
        System.out.println("******************************************************************");
        
        System.out.println("Los precios del producto, según el planteamiento del problema son: \n"+Arrays.toString(arr));

        System.out.println("Por favor, establezca el tamaño de la varilla");
        
        int tamaño = Integer.parseInt(br.readLine());

        int logro = Operaciones.Varilla(arr, tamaño);

        System.out.println("\n**********La tabla dinamica**********\n");
        
        Operaciones.Imprimir_Matriz(Dinamica);

        System.out.println("\n**********La tabla de decisiones********** \n");
        
       Operaciones.Imprimir_Matriz(Decisiones);

        System.out.println("\nLos cortes requeridos son: ");
        
        Gestion_Corte.cortesNecesarios();

    }

}
