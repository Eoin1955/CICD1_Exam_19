package ie.atu.cicd1_exam_19.Controller.ErrorHandling;

public class DuplicateRegNumberException extends RuntimeException{
    public DuplicateRegNumberException(String message){
        super(message);
    }
}
