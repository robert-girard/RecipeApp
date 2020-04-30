package Parsers.Exceptions;

public class ParserFailedException extends Exception {
    public ParserFailedException(String errMsg) {
        super(errMsg);
    }
}
