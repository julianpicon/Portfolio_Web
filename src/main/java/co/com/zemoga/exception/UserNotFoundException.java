package co.com.zemoga.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(final long id) {
        super("User could not be found with id: " + id);
    }
    public UserNotFoundException(final String userName) {
        super("User could not be found with userName: " + userName);
    }

}