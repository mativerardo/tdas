package ar.edu.uns.cs.ed.tdas.tdacola;

import ar.edu.uns.cs.ed.tdas.excepciones.*;

public class TDACola<E> implements Queue<E>{
    protected int cola;
    protected int cabeza;
    protected int cantidad;
    protected int capacidad;
    protected E[] arr;

    public TDACola(){
        cabeza =0;
        cola =0;
        cantidad=0;
        capacidad=1000;
        arr = (E[]) new Object[capacidad];
    }
    public int size(){
        return cantidad;
    }
    public boolean isEmpty(){
        return cantidad==0;
    }
    public void enqueue(E elem){
        if(cantidad< capacidad){
            arr[cola] = elem;
            cantidad++;
            cola = (cola+1) % capacidad;
        }
        else{
            capacidad=capacidad*2;
            E[] aux = (E[]) new Object[capacidad];
            for(int i =0;i< arr.length;i++){
                aux[i]=arr[i];
            }
            arr=aux;
            arr[cola]=elem;
            cola = (cola+1) % capacidad;
        }
    }
    public E dequeue() throws EmptyQueueException{
        if(this.isEmpty()){
            throw new EmptyQueueException("Esta vacia");
        }
        else{
            E ret = arr[cabeza];
            arr[cabeza]=null;
            cabeza= (cabeza+1) % capacidad;
            cantidad--;
            return ret;
        }
    }
    public E front() throws EmptyQueueException{
        if(this.isEmpty()){
            throw new EmptyQueueException("Esta vacia");
        }
        else{
            return arr[cabeza];
        }
    }
}
