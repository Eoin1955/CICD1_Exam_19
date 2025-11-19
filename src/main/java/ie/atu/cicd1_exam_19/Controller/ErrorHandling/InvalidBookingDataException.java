package ie.atu.cicd1_exam_19.Controller.ErrorHandling;

public class InvalidBookingDataException extends RuntimeException{
    private String message;
    public InvalidBookingDataException(String message){
        super(message);
    }
}
