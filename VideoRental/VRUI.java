import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRUI {
	private static Scanner scanner = new Scanner(System.in) ;

	private List<Customer> customers = new ArrayList<Customer>() ;

	private List<Video> videoList = new ArrayList<>() ;

	public static void main(String[] args) {
		VRUI ui = new VRUI() ;

		boolean quit = false ;
		while ( ! quit ) {
			int command = ui.showCommand() ;
			switch ( command ) {
				case 0: quit = true ; break ;
				case 1: ui.listCustomers() ; break ;
				case 2: ui.listVideos() ; break ;
				case 3: ui.register("customer") ; break ;
				case 4: ui.register("video") ; break ;
				case 5: ui.rentVideo() ; break ;
				case 6: ui.returnVideo() ; break ;
				case 7: ui.getCustomerReport() ; break;
				case 8: ui.clearRentals() ; break ;
				case -1: ui.init() ; break ;
				default: break ;
			}
		}
		System.out.println("Bye");
	}

	public void clearRentals() {
		String customerName = scanCustomerName();

		Customer foundCustomer = findCustomer(customerName);

		if ( foundCustomer == null ) {
			System.out.println("No customer found") ;
		} else {
			System.out.println("Name: " + foundCustomer.getName() +
					"\tRentals: " + foundCustomer.getRentals().size()) ;
			for ( Rental rental: foundCustomer.getRentals() ) {
				System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ") ;
				System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode()) ;
			}
		}
	}

	private Customer findCustomer(String customerName) {
		Customer foundCustomer = null;
		for ( Customer customer: customers ) {
			if ( customer.getName().equals(customerName)) {
				foundCustomer = customer ;
				break ;
			}
		}
		return foundCustomer;
	}

	public void returnVideo() {
		String customerName = scanCustomerName();

		Customer foundCustomer = findCustomer(customerName);
		if ( foundCustomer == null ) return ;

		String videoTitle = scanVideoName();

		List<Rental> customerRentals = foundCustomer.getRentals() ;
		for ( Rental rental: customerRentals ) {
			if ( rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented() ) {
				rental.returnVideo();
				rental.getVideo().setRented(false);
				break ;
			}
		}
	}

	private void init() {
		Customer james = new Customer("James") ;
		Customer brown = new Customer("Brown") ;
		customers.add(james) ;
		customers.add(brown) ;

		Video v1 = createVideo("v1", Video.VHS, Video.REGULAR);
		Video v2 = createVideo("v2", Video.DVD, Video.NEW_RELEASE);

		videoList.add(v1) ;
		videoList.add(v2) ;

		Rental r1 = new Rental(v1) ;
		Rental r2 = new Rental(v2) ;

		james.addRental(r1) ;
		james.addRental(r2) ;
	}

	public Video createVideo(String title, int videoType, int priceCode) {
		switch (videoType) {
			case Video.VHS:
				return new VHS(title, priceCode, new Date()) ;
			case Video.CD:
				return new CD(title, priceCode, new Date()) ;
			case Video.DVD:
				return new DVD(title, priceCode, new Date()) ;
			default:
				return null;
		}
	}

	public void listVideos() {
		System.out.println("List of videos");

		for ( Video video : this.videoList) {
			System.out.println("Price code: " + video.getPriceCode() +"\tTitle: " + video.getTitle()) ;
		}
		System.out.println("End of list");
	}

	public void listCustomers() {
		System.out.println("List of customers");
		for ( Customer customer: customers ) {
			System.out.println("Name: " + customer.getName() +
					"\tRentals: " + customer.getRentals().size()) ;
			for ( Rental rental: customer.getRentals() ) {
				System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ") ;
				System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode()) ;
			}
		}
		System.out.println("End of list");
	}

	public void getCustomerReport() {
		String customerName = scanCustomerName();

		Customer foundCustomer = findCustomer(customerName);

		if ( foundCustomer == null ) {
			System.out.println("No customer found") ;
		} else {
			String result = foundCustomer.getReport() ;
			System.out.println(result);
		}
	}

	public void rentVideo() {
		String customerName = scanCustomerName();

		Customer foundCustomer = findCustomer(customerName);

		if ( foundCustomer == null ) return ;

		String videoTitle = scanVideoName();

		Video foundVideo = null ;
		for ( Video video : this.videoList) {
			if ( video.getTitle().equals(videoTitle) && !video.isRented()) {
				foundVideo = video;
				break ;
			}
		}

		if ( foundVideo == null ) return ;

		Rental rental = new Rental(foundVideo);
		foundVideo.setRented(true);
		foundCustomer.addRental(rental);
	}

	public void register(String object) {
		if ( object.equals("customer") ) {
			String name = scanCustomerName();
			Customer customer = new Customer(name) ;
			customers.add(customer) ;
		}
		else {
			String title = scanVideoName();
			int videoType = scanVideoType();
			int priceCode = scanPriceCode();

			Video video = createVideo(title, videoType, priceCode) ;
			this.videoList.add(video) ;
		}
	}

	public int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");

		int command = scanner.nextInt() ;

		return command ;

	}
	
	private String scanCustomerName() {
		System.out.println("Enter customer name: ");
		return scanner.next();
	}
	
	private String scanVideoName() {
		System.out.println("Enter video title: ") ;
		return scanner.next();
	}
	
	private Integer scanVideoType() {
		System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):") ;
		return scanner.nextInt();
	}
	
	private Integer scanPriceCode() {
		System.out.println("Enter price code( 1 for Regular, 2 for New Release ):") ;
		return scanner.nextInt();		
	}		
}
