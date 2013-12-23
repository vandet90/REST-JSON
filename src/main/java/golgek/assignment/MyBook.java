package golgek.assignment;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;


import golgek.assignment.common.RequestURI;
import golgek.assignment.model.BookSummary;
import golgek.assignment.service.BookService;
import golgek.assignment.service.BookServiceImp;

@Path("items")
public class MyBook {

	private BookService bookService;
	
	public MyBook(){
		bookService = new BookServiceImp();
	}
	
	@GET	
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
	public Response onGetItems(@QueryParam(value="offset") String offset, @QueryParam(value="count") String count, @Context UriInfo uriInfo){
	
		try {
			//update Request URI
			URI uri = new URI(uriInfo.getBaseUri().toString());
			RequestURI.HOST_NAME = uri.getHost();
			RequestURI.PATH = uri.getPath() + "items/";
			RequestURI.PORT = uri.getPort();
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		int myOffset = 0, myCount = 0; 
		
		String strError = "<html><head> " + 
				"<meta http-equiv='content-type' content='text/html;charset=utf-8'>" + 
				"<title>500 Server Error</title>" + 
				"</head>" +
				"<body text=#000000 bgcolor=#ffffff>" + 
				"<h1>Error: Server Error</h1>" + 
				"<h2>The server encountered an error and could not complete your request.<p>If the problem persists, please report your problem and mention this error message and the query that caused it.</h2>" + 
				"<h2></h2>" + 
				"</body></html>";
		
		try{
			
			myOffset = Integer.parseInt((offset==null)?"0":offset);
			myCount = Integer.parseInt((count==null)?"0":count);
			
		}catch(NumberFormatException ex){
			
			System.out.println("wrong argument exception");			
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(strError).build();
			
		}catch(Exception ex){
			
			System.out.println("exception ");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(strError).build();
			
		}		
		
		return Response.ok().entity(new GenericEntity<List<BookSummary>>(bookService.getItems(myOffset, myCount)){}).build();
		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
	@Path("{id}")
	public Response onGetItem(@PathParam("id") String id, @Context UriInfo uriInfo){
		
		try {
			//update Request URI
			URI uri = new URI(uriInfo.getBaseUri().toString());
			RequestURI.HOST_NAME = uri.getHost();			
			RequestURI.PORT = uri.getPort();
			
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		int myId = 0;
		
		String strError = "<html><head> " + 
				"<meta http-equiv='content-type' content='text/html;charset=utf-8'>" + 
				"<title>500 Server Error</title>" + 
				"</head>" +
				"<body text=#000000 bgcolor=#ffffff>" + 
				"<h1>Error: Server Error</h1>" + 
				"<h2>The server encountered an error and could not complete your request.<p>If the problem persists, please report your problem and mention this error message and the query that caused it.</h2>" + 
				"<h2></h2>" + 
				"</body></html>";
		
		try{
						
			myId = Integer.parseInt((id==null)?"0":id);
			
		}catch(NumberFormatException ex){
			
			System.out.println("wrong argument exception");			
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(strError).build();
			
		}catch(Exception ex){
			
			System.out.println("exception ");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(strError).build();
			
		}
		
		return Response.ok(bookService.getItem(myId)).build();
				
	}
	
}
