package Algoritmo_Varilla;

import java.io.BufferedReader;
import java.io.IOException;

/*
 * @author: Juan David Navarro Rocha ID 567682 - Fredy Yovany Peña Sánchez ID 567004
 */

public class Gestion_Corte {

    private int longitud;
    
    private int piezas;

    Gestion_Corte(){}

    Gestion_Corte(int longitud, int piezas){
        
        this.longitud = longitud;
        
        this.piezas = piezas;
        
    }

    public int getLongitud() {
        
        return longitud;
    }

    public void setLongitud(int longitud) {
        
        this.longitud = longitud;
    }

    public int getPiezas() {
        
        return piezas;
    }

    public void setPiezas(int piezas) {
        
        this.piezas += piezas ;
    }

    
    static int[] preciosCortes(BufferedReader br) throws IOException {
        
        System.out.println("Ingrese los precios separados por coma");
        
        String arrAux[] = br.readLine().split(",");
        
        int arr[] = new int[arrAux.length];
        
        for (int i = 0; i < arr.length; i++) {
            
            arr[i] = Integer.parseInt(arrAux[i]);
        }
        return arr;
    }

   
    static void numeroDeCortes (int [][] matriz){

        int[] posActual = {matriz.length-1, matriz[0].length-1};

        while ( posActual[0] >= 0 )
        {
            while ( posActual[1] >= 0 )
            {
                if(posActual[1] <= 1){
                    
                    break;
                }
                if (matriz[posActual[0]][posActual[1]] == 1) {
                    
                    contadorDeCortes(new Gestion_Corte(posActual[0], 1));
                    
                    posActual = guardaPos( posActual[0] ,posActual[1] - posActual[0]);
                    
                }else{
                    
                    posActual = guardaPos(posActual[0] - 1, posActual[1]);
                    
                }
                
            }

            posActual[0] -= 1;
            
        }
        
    }

    
    static void contadorDeCortes(Gestion_Corte corte){

        if(Main.Corte.isEmpty()){
            
            Main.Corte.add(corte);
            
        }else {
            
            boolean bandera = false;
            
            for (int i = 0; i < Main.Corte.size(); i++) {
                
                if (Main.Corte.get(i).getLongitud() == corte.getLongitud()) {
                    
                    Main.Corte.get(i).setPiezas(1);
                    
                    bandera = true;
                    
                }
                
            }

            if (bandera == false){
                
                Main.Corte.add(corte);
                
            }

        }

    }

    static void cortesNecesarios(){
        
        numeroDeCortes(Main.Decisiones);
        
        for (int i = 0; i < Main.Corte.size(); i++) {
            
            System.out.println(Main.Corte.get(i).getPiezas() + " piezas de longitud "+Main.Corte.get(i).getLongitud());
            
        }
        
    }

    static int[] guardaPos(int i, int j){
        
        int[] array = new int [2];
        
        array[0] = i;
        
        array[1] = j;
        
        return array;
    }

}
