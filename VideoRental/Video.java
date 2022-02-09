import java.util.Date;

public abstract class Video {
    private int priceCode ;
    public static final int REGULAR = 1 ;
    public static final int NEW_RELEASE =2 ;

    public static final int VHS = 1 ;
    public static final int CD = 2 ;
    public static final int DVD = 3 ;

    protected Date registeredDate;
    private String title;
    private boolean rented;

    public Video(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public abstract int getLateReturnPointPenalty();

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
