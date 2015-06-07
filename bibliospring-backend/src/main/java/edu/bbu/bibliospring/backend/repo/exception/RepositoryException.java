package edu.bbu.bibliospring.backend.repo.exception;

/**
 *
 * @author zsvitalyos
 */
public class RepositoryException extends Exception {
    public RepositoryException () {
        
    }
    
    public RepositoryException (final String message) {
        super(message);
    }
    
    public RepositoryException(final Throwable cause) {
        super(cause);
    }
    
    public RepositoryException(final Throwable cause, final String message) {
        super (message, cause);
    }
}