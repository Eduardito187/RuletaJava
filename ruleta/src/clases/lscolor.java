/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import nodos.coloresnd;
/**
 *
 * @author eduard
 */
public class lscolor {
    private coloresnd index;
    public lscolor(){
        this.index=null;
    }

    public void insertarDer(int rojo,int verde, int azul){
        coloresnd nn = new coloresnd(rojo,verde,azul);
        if(this.index == null){
            this.index = nn;
        }else{
            if(this.index.getRefDer() == null){
                nn.setRefIzq(this.index);
                this.index.setRefDer(nn);
            }else{
                (this.index.getRefDer()).setRefIzq(nn);
                nn.setRefDer(this.index.getRefDer());
                nn.setRefIzq(this.index);
                this.index.setRefDer(nn);
            }
        }
    }
    
    public boolean moverIzq(){
        if(this.index.getRefIzq() != null){
            this.index = this.index.getRefIzq();
            return true;
        }else{
            return false;
        }
    }
    
    public void irPrimero(){
        while(moverIzq()){
            ;
        }
    }

    public coloresnd getIndex() {
        return index;
    }

    public void setIndex(coloresnd index) {
        this.index = index;
    }
    
    
}