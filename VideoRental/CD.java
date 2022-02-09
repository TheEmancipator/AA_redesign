import java.util.Date;

public class CD extends Video {

	public static final int CD_PENALTY = 2;
	public static final int CD_LIMIT = 2;

	public CD(String title, int priceCode, Date registeredDate) {
		super(title, priceCode, registeredDate);
	}

	@Override
	public int getLateReturnPointPenalty() {
		return CD_PENALTY;
	}

	@Override
	public int getRentLimit() {
		return CD_LIMIT;
	}

}
