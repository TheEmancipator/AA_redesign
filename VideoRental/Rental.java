import java.util.Date;

public class Rental {
	private VHS VHS;
	private int status ; // 0 for Rented, 1 for Returned
	private Date rentDate ;
	private Date returnDate ;

	public Rental(VHS VHS) {
		this.VHS = VHS;
		status = 0 ;
		rentDate = new Date() ;
	}

	public VHS getVideo() {
		return VHS;
	}

	public void setVideo(VHS VHS) {
		this.VHS = VHS;
	}

	public int getStatus() {
		return status;
	}

	public void returnVideo() {
		if ( status == 1 ) {
			this.status = 1;
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getDaysRentedLimit() {
		int limit = 0 ;
		int daysRented ;
		if (getStatus() == 1) { // returned Video
			long diff = returnDate.getTime() - rentDate.getTime();
			daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
		} else { // not yet returned
			long diff = new Date().getTime() - rentDate.getTime();
			daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
		}
		if ( daysRented <= 2) return limit ;

		switch ( VHS.getVideoType() ) {
			case VHS.VHS: limit = 5 ; break ;
			case VHS.CD: limit = 3 ; break ;
			case VHS.DVD: limit = 2 ; break ;
		}
		return limit ;
	}
}
