
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

	int flag = 0;

	public SearchServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//String searchFilter = request.getParameterValues("search")!=null?request.getParameterValues("search")[0]:"";
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String searchFilter = request.getParameterValues("search")[0];

		out.print(Message.printHtmlLayoutOfSearching());
		System.out.println(searchFilter);

		if (searchFilter.equals("Search Name")) {

			String name = request.getParameter("name");
			
			out.print("<div class=\"d-flex flex-row p-2 justify-content-start align-items-center \">");
			
			for (Message item : Db.getMessageDatabase()) {

				if ((item.getName().toLowerCase().equals(name.toLowerCase()))) {

					out.print(item.printName(item));
					
					flag = 1;
					
					break;
				}

				else if ((item.getName().toLowerCase().contains(name.toLowerCase()))) {

					out.print(item.printName(item));
					
					flag = 1;
				}

				else {
					flag = 0;
				}

			}

			if (flag == 0) {
				out.print(Message.printError());
			}
			
			out.print("</div>");
			
		} else {
			String date = request.getParameter("date");

			out.print("<div class=\"d-flex flex-column p-5 justify-content-center align-items-center \">");

			for (Message item : Db.getMessageDatabase()) {

				if (dateFormat.format(item.getDate()).toString().equals(date)) {

					out.print(item.printDate(item));

				} else {

					out.println(Message.printError());
					break;
				}
			}
			out.print("</div>");
		}

		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}