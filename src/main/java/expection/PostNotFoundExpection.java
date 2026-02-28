package expection;

public class PostNotFoundExpection extends RuntimeException {
    public PostNotFoundExpection(String message) {
        super(message);
    }
}
