import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;

	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getReport() {
		String result = "Customer Report for " + getName() + "\n";

		List<Rental> rentals = getRentals();

		double totalCharge = 0;
		int totalPoint = 0;

		for (Rental rental : rentals) {
			double charge = 0;
			int point = 0 ;
			int daysRented = 0;

			daysRented = rental.getDaysRented();

			charge = rental.getRentalCharge(charge, daysRented);

			point++;

			if ((rental.getVideo().getPriceCode() == Video.NEW_RELEASE) )
				point++;

			if ( daysRented > rental.getDaysRentedLimit(daysRented) )
				point -= Math.min(point, rental.getVideo().getLateReturnPointPenalty()) ;

			result += "\t" + rental.getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + charge
					+ "\tPoint: " + point + "\n";

			totalCharge += charge;

			totalPoint += point ;
		}

		result += "Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n";

		checkCoupon(totalPoint);
		return result ;
	}

	private void checkCoupon(int totalPoint) {
		if ( totalPoint >= 10 ) {
			System.out.println("Congrat! You earned one free coupon");
		}
		if ( totalPoint >= 30 ) {
			System.out.println("Congrat! You earned two free coupon");
		}
	}

	public void printVideo(){
		System.out.println("Name: " + getName() + "\tRentals: " + getRentals().size()) ;
		for ( Rental rental: getRentals() ) {
			rental.printVideo();
		}
	}

	void printCustomDesc() {
		System.out.println("Name: " + getName() +
				"\tRentals: " + getRentals().size()) ;
	}
}
