/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.concurrent.ThreadLocalRandom;
import nodos.nodoLD;
/**
 *
 * @author eduard
 */
public class clsListaCircular {
    private nodoLD ListaC;
    private nodoLD refsuerte;
    private nodoLD siguiente;
    public int longi;
    public String cadganador;
    public clsListaCircular(){
        this.ListaC=null;
        this.refsuerte=null;
        this.siguiente=null;
        this.longi=0;
        this.cadganador="";
    }
    
     public void setListaC(nodoLD ListaC){
        this.ListaC = ListaC;
    }
    
    public nodoLD getListaC(){
        return this.ListaC;
    }
    
    public void insertarDer(int dato,String detalle){
        nodoLD nn = new nodoLD(dato,detalle);
        if(this.ListaC == null){
            this.ListaC = nn;
            this.ListaC.setRefDer(nn);
            this.ListaC.setRefIzq(nn);
        }else{
            if(this.ListaC.getRefDer() == null){
                nn.setRefIzq(this.ListaC);
                this.ListaC.setRefDer(nn);
                this.ListaC.setRefIzq(nn);
                nn.getRefDer().setRefDer(this.ListaC);
            }else{
                (this.ListaC.getRefDer()).setRefIzq(nn);
                nn.setRefDer(this.ListaC.getRefDer());
                nn.setRefIzq(this.ListaC);
                this.ListaC.setRefDer(nn);
            }
        }
        longituddecircular();
    }
    
    public boolean moverDer(){
        if(this.ListaC.getRefDer() != null){
            this.ListaC = this.ListaC.getRefDer();
            return true;
        }else{
            return false;
        }
    }
    
    public boolean moverIzq(){
        if(this.ListaC.getRefIzq() != null){
            this.ListaC = this.ListaC.getRefIzq();
            return true;
        }else{
            return false;
        }
    }
    
    public void longituddecircular(){
        nodoLD aux=this.ListaC;
        nodoLD aux1=this.ListaC;
        this.longi=1;
        while(aux!=null){
            if (aux.getRefDer()==aux1) {
                aux=null;
            }else{
                aux=aux.getRefDer();
                this.longi++;
            }
        }
    }

    public int getLongi() {
        return longi;
    }

    public void setLongi(int longi) {
        this.longi = longi;
    }
    

    public String getCadganador() {
        return cadganador;
    }

    public void setCadganador(String cadganador) {
        this.cadganador = cadganador;
    }
    
    public void funcionganadores(int idganador){
        nodoLD aux=this.ListaC;
        nodoLD aux1=this.ListaC;
        int auxz=0;
        while(aux!=null){
            if (idganador==auxz) {
                this.cadganador=aux.getDetalle();
            }
            auxz++;
            if (aux.getRefDer()==aux1) {
                aux=null;
            }else{
                aux=aux.getRefDer();
            }
        }
    }
}

