package smart_university_library;


public class Main {
	public static void  main(String[] args) throws Exception  {
		CentralizedCatalog center = CentralizedCatalog.getInstance();
		
		User student = UserFactory.createUser("student", "Harshita");
		User faculty = UserFactory.createUser("faculty", "Dr. Vanshika");
		
		center.addObserver(faculty);
		center.addObserver(student);
		
		Book book1 = new Book.BookBuilder("2States")
				.author("GoF")
				.edition("2nd")
				.build();
		
		center.addBook(book1);
	}
}