package Algoritmo_Varilla;


public class Operaciones {


    static int Varilla(int[] precio, int longitud){

        int[][] capturarDatos = Llenar_Matriz(precio, longitud);
        
        Main.Decisiones = Llenar_Matriz(precio, longitud);

        int maximoBeneficio = Integer.MIN_VALUE;

        for (int i = 1; i < capturarDatos.length; i++) {
            
            for (int j = 2; j < capturarDatos[i].length; j++) {
                
                if (i == 1) {
                    
                    capturarDatos[i][j] = capturarDatos[i - 1][j] * capturarDatos[i][0];
                    
                    if (maximoBeneficio < capturarDatos[i][j]) { maximoBeneficio = capturarDatos[i][j]; }
                    
                    Main.Decisiones[i][j] = capturarDatos[i][j];
                    
                } else if (capturarDatos[0][j] < i) {
                    
                    capturarDatos[i][j] = capturarDatos[i - 1][j];
                    
                } else {
                    
                    maximoBeneficio = capturarDatos[i][j] = Math.max(capturarDatos[i][j - i] + capturarDatos[i][0], capturarDatos[i - 1][j]);
                   
                    if(i >= capturarDatos[0][i+1]){
                        
                        if(capturarDatos[i][j] == capturarDatos[i-1][j]) {
                            
                            Main.Decisiones[i][j] = 0;
                            
                        }else{
                            
                            Main.Decisiones[i][j] = 1;
                            
                        }
                        
                    }
                    
                }
                
            }
            
        }
        
        Main.Dinamica = capturarDatos.clone();
        
        return maximoBeneficio;
 
    }


    static void Imprimir_Matriz(int[][] matriz){

        for (int i = 0; i < matriz.length; i++) {
            
            for (int j = 0; j < matriz[i].length; j++) {
                
                if(j == 0){
                    
                    System.out.print(i+"- ");
                    
                }
                
                if(matriz[i][j] < 10 && matriz[i][j] >= 0){System.out.print(" |"+matriz[i][j]+"| ");}else{
                    
                    System.out.print(" |"+matriz[i][j]+"| ");}

            }
            
            System.out.println();
            
        }

    }

    static int[][] Llenar_Matriz(int[] precio, int longitud){
        
        int[][] capturarDatos = new int[longitud + 1][longitud + 2];

        int incrementadorFilas = 1;

 
        for (int i = 0; i < capturarDatos.length; i++) {
            
            for (int j = 0; j < capturarDatos[i].length; j++) {
                
                if(i == 0 && j > 1){capturarDatos[i][j] = incrementadorFilas; incrementadorFilas++;}
                
                if(i > 0 && j == 0){capturarDatos[i][j] = precio[i-1];}
                
            }
            
        }
        
        return capturarDatos;
        
    }

}
