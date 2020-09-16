import java.util.*;

public class Db {

	private static Vector<Message> messageDatabase = new Vector();

	public static Vector<Message> getMessageDatabase() {
		return messageDatabase;
	}

	public void setMessageDatabase(Message messageObject) {
		messageDatabase.addElement(messageObject);
	}
}
