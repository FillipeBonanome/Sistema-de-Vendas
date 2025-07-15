package br.com.incarnia.Sistema.de.Vendas.core.exceptions;

public class MenuItemException extends RuntimeException {
    public MenuItemException(String message) {
        super(message);
    }
    public MenuItemException(String message, Throwable cause) { super(message, cause); }
}
