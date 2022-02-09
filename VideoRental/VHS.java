import java.util.Date;

public class VHS extends Video {

	public static final int VHS_PENALTY = 1;
	public static final int VHS_LIMIT = 1;

	public VHS(String title, int priceCode, Date registeredDate) {
		super(title, priceCode, registeredDate);
	}

	@Override
	public int getLateReturnPointPenalty() { return VHS_PENALTY; }

	@Override
	public int getRentLimit() { return VHS_LIMIT; }
}
