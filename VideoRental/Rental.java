import java.util.Date;

public class Rental {
	private Video video;
	private boolean isReturned;
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video;
		isReturned = false ;
		rentDate = new Date() ;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public boolean isReturned() {
		return isReturned;
	}

	public void returnVideo() {
		this.isReturned = true;
		returnDate = new Date();
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
		int daysRented = getDaysRented();
		if ( daysRented <= 2) return limit ;

		switch ( video.getVideoType() ) {
			case VHS.VHS: limit = 5 ; break ;
			case VHS.CD: limit = 3 ; break ;
			case VHS.DVD: limit = 2 ; break ;
		}
		return limit ;
	}

	int getDaysRented() {
		int daysRented;
		long diff;
		if (isReturned()) {
			diff = getReturnDate().getTime() - getRentDate().getTime();
		} else {
			diff = new Date().getTime() - getRentDate().getTime();
		}
		daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;

		return daysRented;
	}

	double getRentalCharge(double charge, int daysRented) {
		switch (getVideo().getPriceCode()) {
		case 1:
			charge += 2;
			if (daysRented > 2)
				charge += (daysRented - 2) * 1.5;
			break;
		case 2:
			charge = daysRented * 3;
			break;
		}
		return charge;
	}
}
