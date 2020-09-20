
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SubmitServlet
 */
@WebServlet("/submit_servlet")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Db messagesList = new Db();

	public SubmitServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String message = request.getParameter("message");

		Message messageObject = new Message(name, message, new Date());

		messagesList.setMessageDatabase(messageObject);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print(Message.printHtmlLayoutOfSubmission());
		
		for (Message item : Db.getMessageDatabase()) {

			out.print(item.printInformation());

		}
		out.print("</div>");

		out.println("</body>");
		out.print("</html>");
		out.close();

	}

}
