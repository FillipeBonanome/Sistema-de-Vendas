package br.com.incarnia.Sistema.de.Vendas.config.exceptions;

import br.com.incarnia.Sistema.de.Vendas.core.exceptions.AddressException;
import br.com.incarnia.Sistema.de.Vendas.core.exceptions.RestaurantException;
import br.com.incarnia.Sistema.de.Vendas.core.exceptions.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponse> handleUserException(UserException exception) {
        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        "Error",
                        exception.getMessage())
        );
    }

    @ExceptionHandler(AddressException.class)
    public ResponseEntity<ErrorResponse> handleAddressException(AddressException exception) {
        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        "Error",
                        exception.getMessage()
                )
        );
    }

    @ExceptionHandler(RestaurantException.class)
    public ResponseEntity<ErrorResponse> handleRestaurantException(RestaurantException exception) {
        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        "Error",
                        exception.getMessage()
                )
        );
    }

}
