import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	private String name, message;
	private Date date;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");

	public Message(String name, String message, Date date) {
		this.name = name;
		this.message = message;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String printInformation() {
		String result = "<div";
		result += " class=\"card m-2 \"  style=\"max-width:18rem\">";
		result += "<h5 class=\"card-header bg-info text-white\">" + name + "</h5>";
		result += "<div class=\"card-body\"><p class=\"card-text\">" + "  " + message + "</p>";
		result += "<p class=\"card-text\"><small class=\"text-muted\">" + dateFormat.format(date) + "</small></p>\r\n"
				+ "</div>";
		result += "</div>";
		return result;
	}

	public String printName(Message item) {
		String result = "<div";
		result += " class=\"card m-2 \"  style=\"max-width:18rem\">";
		result += "<h5 class=\"card-header bg-info text-white\">" + item.getName() + "</h5>";
		result += "<div class=\"card-body\"><p class=\"card-text\">" + "  " + item.getMessage() + "</p>";
		result += "<p class=\"card-text\"><small class=\"text-muted\">" + dateFormat.format(item.getDate())
				+ "</small></p>\r\n" + "</div>";
		result += "</div>";

		return result;
	}

	public String printDate(Message item) {
		String result = "<div";
		result += " class=\"card m-2 \"  style=\"width:40%\">";
		result += "<div class=\"card-body\"><p class=\"card-text\">" + "  " + item.getMessage() + "</p>";
		result += "<p class=\"card-text\"><small class=\"text-muted\">" + "by " + item.getName() + " on "
				+ dateFormat1.format(item.getDate()) + "</small></p>\r\n" + "</div>";
		result += "</div>";

		return result;
	}

	public static String printError() {
		String result = "<script ";
		result += "type=\"text/javascript\">";
		result += "alert('Incorrect values');";

		result += "</script>";

		return result;
	}
	
	public static String printHtmlLayoutOfSearching() {
		String result="<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n";
		result+= "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\r\n"
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
						"  </script>" + "</head>\r\n";
		result+="<body>";
		result+="<div class=\"d-flex justify-content-between p-2 bg-light mb-3 \"> <a href=\"search.html\">Back</a></div>\r\n" + 
		" <form  action=\"search_servlet\" method=\"POST\">\r\n" + 
		"   <div class=\"d-flex flex-row pt-5 justify-content-center align-items-center\" >\r\n" + 
		"     <input style=\"width:30%\"  class=\"mr-3\" type=\"text\" name=\"name\" placeholder=\"Search name\" />\r\n" + 
		"     \r\n" + 
		"      <input   type=\"submit\" name=\"search\" value=\"Search Name\" />\r\n" + 
		"   </div> <div class=\"d-flex flex-row pt-5 justify-content-center align-items-center\" >\r\n" + 
		"   <input style=\"width:30%\" id=\"datepicker\" class=\"mr-3\" type=\"text\" name=\"date\" placeholder=\"DD/MM/YYYY\" />\r\n" + 
		"   <input name=\"search\" type=\"submit\" value=\"Search Date\" />\r\n" + 
		"  </div>\r\n" + 
		"  </form>";
		return result;
	}
	
	public static String printHtmlLayoutOfSubmission(){
		String result="<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\r\n"
				+ "" + "<meta charset=\"ISO-8859-1\">\r\n" + "<title>Forum</title>\r\n" + "</head>\r\n";

		result+="<body>";
		result+="<div class=\"d-flex justify-content-between p-2 bg-light mb-3 \"><span class=\"text-black-50\">1800917</span><a class=\"\" href=\"search.html\">Search</a></div>";
  		

		result+="<form  action=\"submit_servlet\" method=\"POST\">\r\n" + 
				"   <div class=\"d-flex flex-column pt-5 justify-content-center align-items-center\" >\r\n" + 
				"     <input autofocus class=\"mb-2\" type=\"text\" name=\"name\" placeholder=\"Name\" />\r\n" + 
				"      <textarea class=\"mb-3\"  rows=\"5\" cols=\"22\" name=\"message\" placeholder=\"Message\"></textarea>\r\n" + 
				"      <input   type=\"submit\" value=\"Submit\" />\r\n" + 
				"   </div>\r\n" + 
				"     \r\n" + 
				"    \r\n" + 
				"   \r\n" + 
				"     \r\n" + 
				"    </form>";
		result+="<div class=\"d-flex flex-row p-2 justify-content-start align-items-center \">";
		
		return result;
	}
}
