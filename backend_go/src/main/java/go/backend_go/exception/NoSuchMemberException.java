package go.backend_go.exception;

public class NoSuchMemberException extends RuntimeException{
    public NoSuchMemberException() {
        super("그런 회원은 없습니다.");
    }
}
