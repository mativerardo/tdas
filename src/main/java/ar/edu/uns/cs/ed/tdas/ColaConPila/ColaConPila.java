package ar.edu.uns.cs.ed.tdas.ColaConPila;

import java.util.Stack;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;

public class ColaConPila<E> implements Queue<E> {
    protected Stack<E> base;
    public ColaConPila(){
        base = new Stack<>();
    }
    public int size(){
        return base.size();
    }
    public boolean isEmpty(){
        return base.isEmpty();
    }
    public void enqueue(E elem){
        base.push(elem);
    }
    public E dequeue(){
        Stack<E> aux = new Stack<>();
        E aux2;
        E ultimo = null;
        while (!base.isEmpty()){
            aux2 = base.pop();

            if(base.isEmpty()){
                ultimo = aux2;
            }
            else{
                aux.push(aux2);
            }          
        }
        while(!aux.isEmpty()){
            base.push(aux.pop());
        }
        return ultimo;
    }
    public E front(){
        Stack<E> aux = new Stack<>();
        E aux2;
        E ultimo = null;
        while (!base.isEmpty()){
            aux2 = base.pop();

            if(base.isEmpty()){
                aux.push(aux2);
                ultimo = aux2;
            }
            else{
                aux.push(aux2);
            }          
        }
        while(!aux.isEmpty()){
            base.push(aux.pop());
        }
        return ultimo;
    }
}
