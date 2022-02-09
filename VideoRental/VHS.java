import java.util.Date;

public class VHS extends Video {

	public static final int VHS_PENALTY = 1;

	public VHS(String title, int priceCode, Date registeredDate) {
		super(registeredDate);
		this.setTitle(title) ;
		this.setPriceCode(priceCode) ;
	}

	@Override
	public int getLateReturnPointPenalty() {
		return VHS_PENALTY;
	}

}
