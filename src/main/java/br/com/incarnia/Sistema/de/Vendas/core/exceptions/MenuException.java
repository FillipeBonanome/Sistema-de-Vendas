package br.com.incarnia.Sistema.de.Vendas.core.exceptions;

public class MenuException extends RuntimeException {
    public MenuException(String message) {
        super(message);
    }
    public MenuException(String message, Throwable cause) { super(message); }
}
