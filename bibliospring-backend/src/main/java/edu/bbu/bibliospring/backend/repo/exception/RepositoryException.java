package edu.bbu.bibliospring.backend.repo.exception;

/**
 *
 * @author zsvitalyos
 */
public class RepositoryException extends Exception {
    RepositoryException () {
        
    }
    
    RepositoryException (final String message) {
        super(message);
    }
    
    RepositoryException(final Throwable cause) {
        super(cause);
    }
    
    RepositoryException(final Throwable cause, final String message) {
        super (message, cause);
    }
}
