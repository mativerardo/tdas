package ar.edu.uns.cs.ed.tdas.tdapila;

import ar.edu.uns.cs.ed.tdas.excepciones.*;

public class TDAPila<E> implements Stack<E>{
    protected int cant;
    protected static int max = 1000;
    protected E[] arr;
    public TDAPila(){
        arr = (E []) new Object[max];
        cant=0;
    }
    public int size(){
        return cant;
    }
    public E top() throws EmptyStackException{
        if(cant!=0){
            E elem = arr[cant-1];
            return elem;
        }
        else{
            throw new EmptyStackException("esta vacia");
        }
    }
    public void push(E elem){
        if(arr.length == cant){
            E[] arr2 = (E[]) new Object[arr.length*2];
            for(int i = 0;i< arr.length;i++){
                arr2[i] = arr[i];
            }
            arr = arr2;
            arr[cant] = elem;
            cant++;
        }
        else{
            arr[cant]= elem;
            cant++;
        }
        
    }
    public E pop() throws EmptyStackException{
        if(cant==0){
            throw new EmptyStackException("Esta vacia");
        }
        else{
            E retorno = arr[cant-1];
            cant--;
            return retorno;
        }
    }
    public boolean isEmpty(){
        return cant ==0;
    }

}
