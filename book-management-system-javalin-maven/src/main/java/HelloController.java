import io.javalin.Javalin;


public class HelloController {

	public static void main(String[] args) {
		Javalin server = Javalin.create(); // javalin creates the jetty server
		server.start(7474); // we tell javlin to start the server at port 7474

		// our first get endpoint
		// can access this endpoint through postman
		server.get("/hello", (ctx)->{
			System.out.println("hello endpoint called....");
			ctx.result("hello returned from the endpoint");
		});
		
	}

}
