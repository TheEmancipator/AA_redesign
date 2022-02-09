import java.util.Date;

public class DVD extends Video {

	public static final int DVD_PENALTY = 3;

	public DVD(String title, int priceCode, Date registeredDate) {
		super(registeredDate);
		this.setTitle(title) ;
		this.setPriceCode(priceCode) ;
	}

	@Override
	public int getLateReturnPointPenalty() {
		return DVD_PENALTY;
	}

}
