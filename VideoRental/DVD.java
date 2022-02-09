import java.util.Date;

public class DVD extends Video {

	public static final int DVD_PENALTY = 3;
	public static final int DVD_LIMIT = 3;

	public DVD(String title, int priceCode, Date registeredDate) {
		super(title, priceCode, registeredDate);
	}

	@Override
	public int getLateReturnPointPenalty() {
		return DVD_PENALTY;
	}

	@Override
	public int getRentLimit() { return DVD_LIMIT; }
}
