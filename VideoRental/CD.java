import java.util.Date;

public class CD extends Video {

	public static final int CD_PENALTY = 2;

	public CD(String title, int priceCode, Date registeredDate) {
		super(registeredDate);
		this.setTitle(title) ;
		this.setPriceCode(priceCode) ;
	}

	@Override
	public int getLateReturnPointPenalty() {
		return CD_PENALTY;
	}

}
