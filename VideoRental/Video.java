import java.util.Date;

public abstract class Video {
    public static final int VHS = 1;
    public static final int DVD = 2;
    public static final int CD = 3;
    public static final int REGULAR = 1;
    public static final int NEW_RELEASE = 2;

    protected Date registeredDate;
    private String title;
    private int priceCode;
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

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

}
