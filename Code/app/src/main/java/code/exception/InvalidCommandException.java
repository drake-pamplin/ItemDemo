package code.exception;

import lombok.Getter;

public class InvalidCommandException extends Exception {
    @Getter
    private String command;

    public InvalidCommandException(String errorMessage, String command) {
        super(errorMessage);
        this.command = command;
    }
}
