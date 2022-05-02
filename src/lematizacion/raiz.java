/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lematizacion;

import java.util.ArrayList;

/**
 *
 * @author avalo
 */
public class raiz {
    
    public ArrayList<String> obtenerRaiz(ArrayList<String> palabras){
        ArrayList<String> raices=new ArrayList<String>();
        ArrayList<String> conjunto=new ArrayList<String>();
        String word,sub;
        int j,c=0;
        for(int i=0;i<palabras.size();i++){//vamos recorriendo palabra por palabra
            i=0;
            word=palabras.get(i);//obtenemos la palabra
            sub=obtenSubString(word);//sacamos una subcadena de al menos 3 caracteres de la palabra
            
            conjunto.clear();
            for(j=i;j<palabras.size();j++){//ahora revisamos cuales palabras contienen esa subcadena
                //System.out.println("A comparar= "+palabras.get(j));
                if(palabras.get(j).startsWith(sub)){//si cierta palabra contiene esa subcadena
                    conjunto.add(palabras.get(j));//entonces la guarda en un conjunto que será revisado para obtener raiz
                    palabras.remove(j);//elimina las palabras para evitar volver a obtener la raiz
                    j--;
                }
                
            }
            
            raices.add(obtenRaizConjunto(conjunto));//del conjunto generado antes se guarda la raiz
            
        }
        return raices;
    }
    
    public String obtenSubString(String a){//obtiene una subcadena
        int numC=1;//checar
        String sub="";
        
        for(int i=0;i<numC;i++)
            sub+=a.charAt(i);
        
        return sub;
    }
    
    public String obtenRaizConjunto(ArrayList<String> set){//busca la subcadena con mas letras que esta contenida en cada palabra del conjunto
        ArrayList<String> sep=new ArrayList<String>();
        int i,j=0,cont=0;
        for(i=set.get(0).length();i>=0;i--){//empieza con toda la cadena hasta que quede con el unico y primer caracter
            sep.add(set.get(0).substring(0,i));//se va obteniendo los fijos de la cadena
            j++;
        }
        
        if(!(set.size()==1)){
            for(j=0;j<sep.size();j++){//compara cada fijo obtenido con cada cadena
                cont=0;
                for(i=0;i<set.size();i++){
                    if(set.get(i).startsWith(sep.get(j))){//si este fijo esta contenido en la cadena a comparar entonces contador aumenta
                        cont++;
                    }
                }
            
                if(cont==set.size()){//si se encontro que todas las cadenas lo contienen entonces esa es la raiz
                    return sep.get(j);
                }
                    
            }
        }
        return obtenSubString(set.get(0));//si no encontro ninguna raiz entonces la subcadena que formo el conjunto es la raiz
    }

    
}
