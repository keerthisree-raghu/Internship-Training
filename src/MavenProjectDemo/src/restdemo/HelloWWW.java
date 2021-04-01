package restdemo;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

@Path("test")
public class HelloWWW {

	@GET
	public void testMethod() {
		System.out.println("Test method called.");
	}

	@GET
	@Path("test2")
	public void testMethod2() {
		System.out.println("Test2 method called.");
	}

	@GET
	@Path("sayHello")
	public Response sayHelloResponse() {
		return Response.status(200).entity("Welcome to REST ").build();
	}

	@GET
	@Path("sayHello2/{username}")
	public Response sayHelloResponse2(@PathParam("username") String name) {
		return Response.status(200).entity("Welcome to REST " + name).build();
	}

	@GET
	@Path("sayHello3/{username}/{myname}")
	public Response sayHelloResponse3(@PathParam("username") String name, @PathParam("myname") String myname) {
		return Response.status(200).entity("Welcome to REST " + name + ": " + myname).build();
	}

	@GET
	@Path("sayHello4")
	public Response sayHelloResponse4(@QueryParam("username") String name, @QueryParam("myname") String myname) {
		return Response.status(200).entity("Welcome to REST " + name + ": " + myname).build();
	}

	@GET
	@Path("sayHello5")
	public Response sayHelloResponse5(@Context UriInfo uriInfo) {
		String name = uriInfo.getQueryParameters().getFirst("username");
		String myname = uriInfo.getQueryParameters().getFirst("myname");
		return Response.status(200).entity("Welcome to REST " + name + ": " + myname).build();
	}

	@GET
	@Path("sayHello6")
	public Response sayHelloResponse6(@MatrixParam("jsessionid") String id) {
		return Response.status(200).entity("Session id is " + id).build();
	}

	@POST
	@Path("sayHello7")
	public Response sayHelloResponse7(@FormParam("username") String name, @FormParam("myname") String myname) {
		return Response.status(200).entity("Welcome To REST " + name + ": " + myname).build();
	}

	@GET
	@Path("/getFile")
	public Response getFileFromServer(@Context ServletContext application, @Context HttpServletRequest request) {
		String filepath = application.getRealPath("/WEB-INF/data.properties");
		File file = new File(filepath);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment;filename=\"datacopy.properties\"");
		return response.build();
	}

	@GET
	@Path("/getImage")
	@Produces("image/png")
	public Response getImageFromServer(@Context ServletContext application) {
		String filepath = application.getRealPath("/WEB-INF/test.png");
		File file = new File(filepath);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment;filename=\"imgcopy.png\"");
		return response.build();
	}

	@GET
	@Path("/getPdf")
	@Produces("application/pdf")
	public Response getPdfFromServer(@Context ServletContext application) {
		String filepath = application.getRealPath("/WEB-INF/Test.pdf");
		File file = new File(filepath);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment;filename=\"pdfcopy.pdf\"");
		return response.build();
	}
}
