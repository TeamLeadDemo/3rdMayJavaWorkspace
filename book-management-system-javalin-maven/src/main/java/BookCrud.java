import io.javalin.Javalin;


public class BookCrud {

	public static void main(String[] args) {
		Javalin server = Javalin.create(); // javalin creates the jetty server (the default ), we can change the internal server if we want to
		server.start(7474); // javlin starts the server at port 7474

		// our first get endpoint
		// can access this endpoint through postman
		
		// will not using this anymore
		// this is just a demo
		server.get("/hello", (ctx)->{
			System.out.println("hello endpoint called....");
			ctx.result("hello returned from the endpoint");
		});
		
		
		// let's create the other endpoints
		//CRUD
		
		// Read all books
		// we need a get endpoint
		// http://localhost:7474/books
		server.get("/books", (ctx)->{
			// here we contact service, service contacts dao 
			// dao fetches all the books and return it back here
			
			
		});
		
		// Read a book
		
		// Delete
		
		// Post
		
		// Put
	}

}
