package com.epam.exeption;

public class ParserCustomExeption extends Exception {

    public ParserCustomExeption(){
        super();
    }

    public ParserCustomExeption(String msg){
        super(msg);
    }

    public ParserCustomExeption(String msg, Throwable cause){
        super(msg,cause);
    }

    public ParserCustomExeption(Throwable cause){
        super(cause);
    }
    
}
