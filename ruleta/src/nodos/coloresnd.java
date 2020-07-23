/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

/**
 *
 * @author eduard
 */
public class coloresnd {
    private int rojo;
    private int verde;
    private int azul;
    private coloresnd refDer,refIzq;
    public coloresnd(int rojo,int verde, int azul){
        this.rojo=rojo;
        this.verde=verde;
        this.azul=azul;
        this.refDer=null;
        this.refIzq=null;
    }

    public int getRojo() {
        return rojo;
    }

    public void setRojo(int rojo) {
        this.rojo = rojo;
    }

    public int getVerde() {
        return verde;
    }

    public void setVerde(int verde) {
        this.verde = verde;
    }

    public int getAzul() {
        return azul;
    }

    public void setAzul(int azul) {
        this.azul = azul;
    }

    public coloresnd getRefDer() {
        return refDer;
    }

    public void setRefDer(coloresnd refDer) {
        this.refDer = refDer;
    }

    public coloresnd getRefIzq() {
        return refIzq;
    }

    public void setRefIzq(coloresnd refIzq) {
        this.refIzq = refIzq;
    }
    
}