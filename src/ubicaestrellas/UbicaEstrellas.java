/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubicaestrellas;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author drai18
 */
public class UbicaEstrellas {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        String fl,rep ;
        int fila,col;        
       Scanner lector = new Scanner (System.in);
        System.out.print("Ingrese la primera linea : ");
        fl=lector.next();
        fila=Integer.parseInt(fl);
        fl+=' ';
        fl+=lector.next();
        col=Integer.parseInt(fl.substring(2));
        System.out.println("primera linea "+fl);
        System.out.println("fila : "+fila+" col "+col);
        int [][] MD = new int [fila][col];
        int [][] res = new int [fila][col];
        //int [][] div = new int [fila][col];
        String [][] star = new String [fila][col];
         //int [] f1= new int [fila];
        //MD[0][0]="0";
        System.out.println("Ingrese datos de la matriz ");
        System.out.println("Cada dato entero se ingresa con un enter hasta llenar la fila: ");
       // rep=lector.next();        
        for(int i=0;i<fila;i++){
            System.out.print("Ingrese la fila #: "+(i+1)+" ");
            for(int j=0;j<col;j++){      
                
                 MD[i][j]=lector.nextInt();                    
                   
            }
           
        }        
        show(MD,fila,col);
        for(int i=0;i<fila;i++){
            for(int j=0;j<col;j++){
               if(i==0 && j==0){
                  res[i][j]=MD[i][j]+MD[i+1][j]+MD[i][1+j]+MD[i+1][1+j] ;                  
               }else if(i==0 && j!=0 && j<col-1){                   
                   res[i][j]=MD[i][j]+MD[i][j+1]+MD[i][j-1]+MD[i+1][j]+MD[i+1][1+j]+MD[i+1][j-1];
               }else if(i==0 && j!=0 && j+1==col){//ultima posicion fila 1
                   res[i][j]=MD[i][j]+MD[i][j-1]+MD[i+1][j-1]+MD[i+1][j];
               }else if(i+1==fila && j==0 ){
                   res[i][j]=MD[i][j]+MD[i][j+1]+MD[i-1][1+j]+MD[i-1][j] ; 
               }else if(i+1==fila && j!=0 && j<col-1 ){//ultima fila
                   res[i][j]=MD[i][j]+MD[i][j+1]+MD[i][j-1]+MD[i-1][j]+MD[i-1][1+j]+MD[i-1][j-1];
               }else if(i+1==fila && j!=0 && j+1==col){
                   res[i][j]=MD[i][j]+MD[i][j-1]+MD[i-1][j-1]+MD[i-1][j];
               }else{
                   res[i][j]=MD[i][j]+MD[i][j+1]+MD[i][j-1]+MD[i+1][j]+MD[i+1][1+j]+MD[i+1][j-1]+
                           MD[i-1][j-1]+MD[i-1][j]+MD[i-1][1+j];
               } 
               //
            }            
        }
        for(int i=0;i<fila;i++){
            for(int j=0;j<col;j++){
                if((double)res[i][j]/5>10.0){
                    star[i][j]="*";
                }else {
                    star[i][j]=" ";
                }           
            }            
        }
        
        //show(res,fila,col); 
        show1(star,fila,col);
    }
    
    static void show(int m[][],int fila,int col){
        for(int i=0;i<fila;i++){
            for(int j=0;j<col;j++){
                System.out.print(m[i][j]);                            
            }
            System.out.println(" "); 
        } 
    }
    
    static void show1(String m[][],int fila,int col){
        for(int i=0;i<fila;i++){
            System.out.println(i+1); 
            for(int j=0;j<col;j++){
                System.out.print(m[i][j]);                            
            }
            System.out.println(" "); 
        } 
    }
    
}
