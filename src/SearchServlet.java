

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search_servlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Vector<Message> nameSearch(String name,Vector<Message> list){
    	Vector<Message> result=null;
    	
    	for(Message item:list) {
    		if(item.getName().toLowerCase().contains(name.toLowerCase())) {
    			result.addElement(item);;
    		}
    	}
    	
    	return result;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Vector<Message> messagesList = (Vector<Message>) session.getAttribute("messagesList");
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		
		String searchFilter=request.getParameterValues("search")[0];
		
		//Vector<Message> result = nameSearch(name, messagesList);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if (searchFilter.equals("Search Name")) {
			out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n"
					+ "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\r\n"
					+ "" + "<meta charset=\"ISO-8859-1\">\r\n" + "<title>Search</title>\r\n" + "</head>\r\n");
			out.print("<body>");
	out.print("<div class=\"d-flex justify-content-between p-2 bg-light mb-3 \"> <a href=\"search.html\">Back</a></div>\r\n" + 
			" <form  action=\"search_servlet\" method=\"POST\">\r\n" + 
			"   <div class=\"d-flex flex-row pt-5 justify-content-center align-items-center\" >\r\n" + 
			"     <input autofocus class=\"mr-3\" type=\"text\" name=\"name\" placeholder=\"Search name\" />\r\n" + 
			"     \r\n" + 
			"      <input   type=\"submit\" value=\"Search\" />\r\n" + 
			"   </div>");
		//	out.print("<div class=\"d-flex justify-content-between p-2 bg-light mb-3 \"><a class=\"\" href=\"search.html\">Back</a><a href=\"index.html\">Home</a></div>");

			//for(Message item:result) {
			out.print("<div class=\"d-flex flex-row p-2 justify-content-start align-items-center \">");
			for(Message item:messagesList) {
	    		if(item.getName().toLowerCase().contains(name.toLowerCase())) {
//	    			result.addElement(item);;
	    			out.print("<div class=\"card m-2 \"  style=\"max-width:18rem\">");

	    			out.print("<h5 class=\"card-header bg-info text-white\">" + item.getName() + "</h5>");
	    			out.print("<div class=\"card-body\"><p class=\"card-text\">" + "  " + item.getMessage() +  "</p>");
	    			out.print("<p class=\"card-text\"><small class=\"text-muted\">"+dateFormat.format(item.getDate())+"</small></p>\r\n"+ "</div>");
	    			out.print("</div>");

	    		}else {
	    			  out.println("<script type=\"text/javascript\">");
	    			   out.println("alert('Incorrect values');");
	    			   
	    			   out.println("</script>");
	    		}
				

	    	}
			out.print("</div>");
			//}
			
			//out.print("</div></div>");
			
			out.print("</body>");
			out.print("</html>");
			out.close();
		}else {
			out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n"
					+ "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\r\n"
					+ "" + "<meta charset=\"ISO-8859-1\">\r\n" + "<title>Search</title>\r\n" + "</head>\r\n");
			out.print("<body>");
	out.print("<div class=\"d-flex justify-content-between p-2 bg-light mb-3 \"> <a href=\"index.html\">Back</a></div>\r\n" + 
			" <form  action=\"search_servlet\" method=\"POST\">\r\n" + 
			"   <div class=\"d-flex flex-row pt-5 justify-content-center align-items-center\" >\r\n" + 
			"     <input autofocus class=\"mr-3\" type=\"text\" name=\"name\" placeholder=\"Search name\" />\r\n" + 
			"     \r\n" + 
			"      <input   type=\"submit\" value=\"Search\" />\r\n" + 
			"   </div>");
		//	out.print("<div class=\"d-flex justify-content-between p-2 bg-light mb-3 \"><a class=\"\" href=\"search.html\">Back</a><a href=\"index.html\">Home</a></div>");

			//for(Message item:result) {
			out.print("<div class=\"d-flex flex-row p-2 justify-content-start align-items-center \">");
			for(Message item:messagesList) {
	    		if(dateFormat.format(item.getDate()).toString().equals(date)) {
//	    			result.addElement(item);;
	    			out.print("<div class=\"card m-2 \"  style=\"max-width:18rem\">");

	    		//	out.print("<h5 class=\"card-header bg-info text-white\">" + item.getName() + "</h5>");
	    			out.print("<div class=\"card-body\"><p class=\"card-text\">" + "  " + item.getMessage() +  "</p>");
	    		//	out.print("<p class=\"card-text\"><small class=\"text-muted\">"+dateFormat.format(item.getDate())+"</small></p>\r\n"+ "</div>");
	    			out.print("</div>");

	    		}else {
	    			  out.println("<script type=\"text/javascript\">");
	    			   out.println("alert('Incorrect values');");
	    			   
	    			   out.println("</script>");
	    		}
				

	    	}
			out.print("</div>");
			//}
			
			//out.print("</div></div>");
			
			out.print("</body>");
			out.print("</html>");
			out.close();
		}
		
		
		
	}

}
