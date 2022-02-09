import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;

	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
			double eachCharge = 0;
			int eachPoint = 0 ;
			int daysRented = 0;

			daysRented = rental.getDaysRented();

			eachCharge = rental.getRentalCharge(eachCharge, daysRented);

			eachPoint++;

			if ((rental.getVideo().getPriceCode() == VHS.NEW_RELEASE) )
				eachPoint++;

			if ( daysRented > rental.getDaysRentedLimit(daysRented) )
				eachPoint -= Math.min(eachPoint, rental.getVideo().getLateReturnPointPenalty()) ;

			result += "\t" + rental.getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + eachCharge
					+ "\tPoint: " + eachPoint + "\n";

			totalCharge += eachCharge;

			totalPoint += eachPoint ;
		}

		result += "Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n";


		if ( totalPoint >= 10 ) {
			System.out.println("Congrat! You earned one free coupon");
		}
		if ( totalPoint >= 30 ) {
			System.out.println("Congrat! You earned two free coupon");
		}
		return result ;
	}

	void printCustomDesc() {
		System.out.println("Name: " + getName() +
				"\tRentals: " + getRentals().size()) ;
	}
}
