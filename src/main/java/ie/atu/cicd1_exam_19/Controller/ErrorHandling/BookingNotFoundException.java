package ie.atu.cicd1_exam_19.Controller.ErrorHandling;

public class BookingNotFoundException extends RuntimeException{
    private String regNumber;
    private String bookingNumber;
    public BookingNotFoundException(String regNumber){
        this.regNumber = regNumber;
    }
    public BookingNotFoundException(String regNumber, String bookingNumber){
        super("The booking number " + bookingNumber + " does not exist");
        this.bookingNumber = bookingNumber;
    }

}
