import java.util.*;

public class Db {
//	String name,message;
	//Date date;
 private static	Vector<Message> messageDatabase=new Vector();
	
	//Message messageObject;
	
	
	
	/*
	 * public Db(String name,String message, Date date) { this.name=name;
	 * this.date=date; this.message=message; messageDatabase.addElement(new
	 * Message(name,message,date)); }
	 */




public static Vector<Message> getMessageDatabase() {
	
	return messageDatabase;
}



public void setMessageDatabase(Message messageObject) {
	
messageDatabase.addElement(messageObject);
	//this.messageDatabase = database;
}




	

}
