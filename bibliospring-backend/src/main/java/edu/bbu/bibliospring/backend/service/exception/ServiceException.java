package edu.bbu.bibliospring.backend.service.exception;

/**
 *
 * @author zsvitalyos
 */
public class ServiceException extends Exception {
    public ServiceException () {
        
    }
    
    public ServiceException (final String message) {
        super(message);
    }
    
    public ServiceException (final Throwable cause) {
        super(cause);
    }
    
    public ServiceException (final String message, final Throwable cause) {
        super (message, cause);
    }
}