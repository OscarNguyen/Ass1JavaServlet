
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
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

	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	//Db database = new Db();
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Vector<Message> messagesList=new Vector();
	
	
//	public Vector<Message> getMessagesList() {
//		return messagesList;
//	}
//	public void setMessagesList(Vector<Message> messagesList) {
//		this.messagesList = messagesList;
//	}
	//Vector<Message> messagesList=database.getMessageDatabase();
    public SearchServlet() {
        super();
 
        // TODO Auto-generated constructor stub
    }
    public Vector<Message> nameSearch(String name,Vector<Message> list){
    	Vector<Message> result=null;
    	for(Message item:list) {
    		if(item.getName().toLowerCase().contains(name.toLowerCase())) {
    			result.addElement(item);
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
		//Vector<Message> messagesList = (Vector<Message>) session.getAttribute("messagesList");
		
		
		
		//String searchFilter=request.getParameter(arg0)
		//String searchFilter=request.getParameterValues("search")[0];
		
		
		 // System.out.println(searchOptions.length);
		 // String searchFilter=""; 
		/*  if(item.equals("Search Name")) { 
			  searchFilter=item; }
		  else if(item.equals("Search Date")) { searchFilter=item; } } 
		  for(String item:searchOptions) { System.out.println("ahihi "+item); }
		  System.out.println(searchFilter);*/
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\r\n"
				+ "" + "<meta charset=\"ISO-8859-1\">\r\n" + "<title>Search</title>\r\n"+" <link href=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n" + 
						"  <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\r\n" + 
						"  <script src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js\"></script>\r\n" + 
						"  <script>\r\n" + 
						"    $(document).ready(function() {\r\n" + 
						"     $(\"#datepicker\").datepicker({\r\n" + 
						"       changeMonth: true, \r\n" + 
						"       changeYear: true\r\n" + 
						"       });\r\n" + 
						"    });\r\n" + 
						"  </script>" + "</head>\r\n");
		out.print("<body>");
out.print("<div class=\"d-flex justify-content-between p-2 bg-light mb-3 \"> <a href=\"search.html\">Back</a></div>\r\n" + 
		" <form  action=\"search_servlet\" method=\"POST\">\r\n" + 
		"   <div class=\"d-flex flex-row pt-5 justify-content-center align-items-center\" >\r\n" + 
		"     <input style=\"width:30%\"  class=\"mr-3\" type=\"text\" name=\"name\" placeholder=\"Search name\" />\r\n" + 
		"     \r\n" + 
		"      <input   type=\"submit\" name=\"search\" value=\"Search Name\" />\r\n" + 
		"   </div> <div class=\"d-flex flex-row pt-5 justify-content-center align-items-center\" >\r\n" + 
		"   <input style=\"width:30%\" id=\"datepicker\" class=\"mr-3\" type=\"text\" name=\"date\" placeholder=\"DD/MM/YYYY\" />\r\n" + 
		"   <input name=\"search\" type=\"submit\" value=\"Search Date\" />\r\n" + 
		"  </div>\r\n" + 
		"  </form>");

String[] searchOptions=request.getParameterValues("search"); 
List<String> nameResult=null;
for(String searchFilter:searchOptions) {
	System.out.println(searchOptions[0]+" ");
		if (searchFilter.equals("Search Name")) {
			System.out.println("message list "+messagesList);
			String name = request.getParameter("name");
			out.print("<div class=\"d-flex flex-row p-2 justify-content-start align-items-center \">");
			for(Message item:/*messagesList*/Db.getMessageDatabase()) {
				System.out.println("ori name " + item.getName().toLowerCase());
				System.out.println(name.toLowerCase());
//				||(item.getName().toLowerCase().equalsIgnoreCase(name.toLowerCase())
				if((item.getName().toLowerCase().equals(name.toLowerCase()))) {
				//	nameResult.add(item.getName());
					out.print("<div class=\"card m-2 \"  style=\"max-width:18rem\">");
	    			out.print("<h5 class=\"card-header bg-info text-white\">" + item.getName() + "</h5>");
	    			out.print("<div class=\"card-body\"><p class=\"card-text\">" + "  " + item.getMessage() +  "</p>");
	    			out.print("<p class=\"card-text\"><small class=\"text-muted\">"+dateFormat.format(item.getDate())+"</small></p>\r\n"+ "</div>");
	    			out.print("</div>");
	    			break;
				} 
				else if((item.getName().toLowerCase().contains(name.toLowerCase()))) {
					//nameResult.add(item.getName());
	    			
	    			out.print("<div class=\"card m-2 \"  style=\"max-width:18rem\">");
	    			out.print("<h5 class=\"card-header bg-info text-white\">" + item.getName() + "</h5>");
	    			out.print("<div class=\"card-body\"><p class=\"card-text\">" + "  " + item.getMessage() +  "</p>");
	    			out.print("<p class=\"card-text\"><small class=\"text-muted\">"+dateFormat.format(item.getDate())+"</small></p>\r\n"+ "</div>");
	    			out.print("</div>");
	    				
	    			
				}     
					 
	    			  
	    		
	    	}
			
			/*
			 * if (!nameResult.contains(name)) {
			 * out.println("<script type=\"text/javascript\">");
			 * out.println("alert('Incorrect values');"); out.println("</script>"); }
			 */
			
			
			
		
			
			
			
			out.print("</div>");
			
			/*
			 * out.print("</body>"); out.print("</html>"); out.close();
			 */
		}else {
			String date = request.getParameter("date");
			/*
			 * out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" +
			 * "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\r\n"
			 * + "" + "<meta charset=\"ISO-8859-1\">\r\n" +
			 * "<title>Search</title>\r\n"+" <link href=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n"
			 * +
			 * "  <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\r\n"
			 * +
			 * "  <script src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js\"></script>\r\n"
			 * + "  <script>\r\n" + "    $(document).ready(function() {\r\n" +
			 * "     $(\"#datepicker\").datepicker({\r\n" + "       changeMonth: true, \r\n"
			 * + "       changeYear: true\r\n" + "       });\r\n" + "    });\r\n" +
			 * "  </script>" + "</head>\r\n"); out.print("<body>"); out.
			 * print("<div class=\"d-flex justify-content-between p-2 bg-light mb-3 \"> <a href=\"index.html\">Homepage</a></div>\r\n"
			 * + " <form action=\"search_servlet\" method=\"POST\">\r\n" +
			 * "  <div class=\"d-flex flex-row pt-5 justify-content-center align-items-center\" >\r\n"
			 * +
			 * "   <input style=\"width:30%\" class=\"mr-3\" type=\"text\" name=\"name\" placeholder=\"Search Name\" />\r\n"
			 * + "   <input name=\"search\"  type=\"submit\" value=\"Search Name\" />\r\n" +
			 * "  </div>\r\n" +
			 * "  <div class=\"d-flex flex-row pt-5 justify-content-center align-items-center\" >\r\n"
			 * +
			 * "   <input style=\"width:30%\" id=\"datepicker\" class=\"mr-3\" type=\"text\" name=\"date\" placeholder=\"DD/MM/YYYY\" />\r\n"
			 * + "   <input name=\"search\" type=\"submit\" value=\"Search Date\" />\r\n" +
			 * "  </div>\r\n" + "  </form>");
			 */
		
			out.print("<div class=\"d-flex flex-column p-5 justify-content-center align-items-center \">");
			for(Message item:/*messagesList*/Db.getMessageDatabase()) {
				System.out.println(dateFormat.format(item.getDate()).toString());
	    		if(dateFormat.format(item.getDate()).toString().equals(date)) {
	    			out.print("<div class=\"card m-2 \"  style=\"width:40%\">");
	    			out.print("<div class=\"card-body\"><p class=\"card-text\">" + "  " + item.getMessage() +  "</p>");
	    			out.print("<p class=\"card-text\"><small class=\"text-muted\">"+"by "+item.getName()+" on "+dateFormat.format(item.getDate())+"</small></p>\r\n"+ "</div>");
	    			out.print("</div>");
	    		}else {
	    			  out.println("<script type=\"text/javascript\">");
	    			   out.println("alert('Incorrect values');");
	    			   out.println("</script>");
	    			   break;
	    		}
	    	}
			out.print("</div>");
		}
			/*
			 * out.print("</body>"); out.print("</html>"); out.close();
			 */
		}
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}