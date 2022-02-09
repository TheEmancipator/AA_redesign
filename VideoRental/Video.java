import java.util.Date;

public abstract class Video {
    private final int priceCode ;
    public static final int REGULAR = 1 ;
    public static final int NEW_RELEASE =2 ;

    public static final int VHS = 1 ;
    public static final int CD = 2 ;
    public static final int DVD = 3 ;

    protected Date registeredDate;
    private final String title;
    private boolean rented;

    public Video(String title, int priceCode, Date registeredDate) {
        this.title = title;
        this.priceCode = priceCode;
        this.registeredDate = registeredDate;
    }

    public abstract int getLateReturnPointPenalty();

    public abstract int getRentLimit();

    public int getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    void printVideo() {
        System.out.print("\tTitle: " + getTitle() + " ") ;
        System.out.print("\tPrice Code: " + getPriceCode()) ;
    }

    public boolean isReturning(String videoTitle) {
        return getTitle().equals(videoTitle) && isRented();
    }

    public boolean isAvailableToRent(String videoTitle) {
        return getTitle().equals(videoTitle) && !isRented();
    }

    void printVideoDesc() {
        System.out.print("\tTitle: " + getTitle() + " ") ;
        System.out.print("\tPrice Code: " + getPriceCode()) ;
    }
}
