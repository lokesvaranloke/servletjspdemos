package hibernatetests;
import org.hibernate.Session;

import com.samples.domain.message;
import com.samples.utils.hibernateutil;

public class hibernatetest {

	public static void main(String[] args) {
		
		Session session = hibernateutil.getSessionFacatory().openSession();
		session.beginTransaction();
		message message = new message("Hello world with Hibernate and Annotations");
		message message1 = new message("Hello world with Hibernate and Annotations1");
		message message2 = new message("Hello world with Hibernate and Annotations2");
		session.save(message);
		session.save(message1);
		session.save(message2);
		session.getTransaction().commit();
		session.close();
	}
}
