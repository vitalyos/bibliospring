package edu.bbu.bibliospring.api.exception;

/**
 *
 * @author zsvitalyos
 */
public class ApiExeption  extends Exception {    
    public ApiExeption () {
        
    }
    
    public ApiExeption (final String message) {
        super (message);
    }
    
    public ApiExeption (Throwable cause) {
        super (cause);
    }
    
    public ApiExeption (String message, Throwable cause) {
        super (message, cause);
    }
}
