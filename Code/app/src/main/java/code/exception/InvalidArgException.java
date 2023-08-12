package code.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class InvalidArgException extends Exception {
    @Getter
    String field;
    
    @Getter
    String issue;
    
    public InvalidArgException(String errorMessage, String field, String issue) {
        super(errorMessage);
        this.field = field;
        this.issue = issue;
    }
}
