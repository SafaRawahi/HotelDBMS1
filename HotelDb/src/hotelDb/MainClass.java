package hotelDb;

import java.util.Scanner;

public class MainClass {
	static void mainMenue1() {

		System.out.println("\t \t ****************************** \t \t");
		System.out.println("\t \t ********** Welcome *********** \t \t");
		System.out.println("\t \t ****************************** \t \t");
		System.out.println("\t \t ***Please Choose One Option*** \t \t");
		System.out.println("\t \t ****************************** \t \t");
//		System.out.println("\t\t 1. Create Hotel Table  ");
//		System.out.println("\t\t 2. Create Room Type Table  ");
//		System.out.println("\t\t 3. Create Rooms Table  ");
//		System.out.println("\t\t 4. Create Guests Table  ");
//		System.out.println("\t\t 5. Create Employee Type Table  ");
//		System.out.println("\t\t 6. Create Employees Table  ");
//		
		System.out.println("\t\t 1. Insert values Hotels  ");
		System.out.println("\t\t 2. Read from Hotels Table  ");
		System.out.println("\t\t 3. Read from Hotels Table By Id ");
		System.out.println("\t\t 4. Update from Hotels Table By Id ");
		System.out.println("\t\t 5. Delete from Hotels Table By Id ");
		System.out.println("\t\t 6. Update value is active in one column ");
		
		
		System.out.println("\t\t 7. Insert 10,000 hotels ");
		System.out.println("\t\t 8. Insert 1 hotel");
		System.out.println("\t\t 9. Print 10 hotels ");
		System.out.println("\t\t 10. make Is Active False first 10 ");
		System.out.println("\t\t 11. Print hotel information by user input  ");
		System.out.println("\t\t 12. Exite ");
		
		
}
	
	
	
	public static void main(String a[]) {
		Hotel hotelTable = new Hotel();
		Roomtypetable myRoomtypetable = new Roomtypetable();
		Room roomTable = new Room();
		Guest guestTable = new Guest();
		EmployeeType myEmployeeType = new EmployeeType();
		Employee employeeTable = new Employee(); 
		
		boolean isExit = true;

		while (isExit) {

			Scanner sc = new Scanner(System.in);
			mainMenue1();
			
			int num;

			int option = sc.nextInt();

			switch (option) {

			case 1:
//				hotel table
//				hotelTable.hotelTable();
				
				hotelTable.insertIntoTable();


				break;
			case 2:
//				room type table
//				myRoomtypetable.roomTableType();
				
				hotelTable.readFromTable();

				break;
			case 3:
//				room table
//				roomTable.roomTable();
				
				hotelTable.getById();

				break;
			case 4:
//				guest table
//				guestTable.GuestsTable();

				hotelTable.updateById();
				break;
		
			case 5:
//				employee type table
//				myEmployeeType.EmployeeTableType();

				hotelTable.deleteById();
				break;
			case 6:
//				employee table
//				employeeTable.employeeTable();

				hotelTable.makeIsActiveFalseById();
				
				break;
			case 7:
				myEmployeeType.EmployeeTableType();
				System.out.println(" Enter The Numbers Of Hotal You Want ");
				num = sc.nextInt();
				hotelTable.insertMoreHotels(num);
				break;
				
			case 8:
				hotelTable.insertMoreHotels(1);

				break;
			case 9:
				hotelTable.printTenHotels(10);

				break;
			case 10:
				hotelTable.makeIsActiveFalseById();
				
				break;
			case 11:
				System.out.println(" Enter The Numbers Of Hotal You Want To Print ");
				int n = sc.nextInt();
				hotelTable.printTenHotels(n);
				break;
				
				
				
			case 12:
				System.out.println(" See You Soon ");
				System.exit(0);

				break;
		
	}
	
}
		isExit = false;

	}
}