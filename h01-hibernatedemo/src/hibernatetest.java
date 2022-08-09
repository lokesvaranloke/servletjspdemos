import org.hibernate.Session;

import com.samples.domain.message;
import com.samples.utils.hibernateutil;

public class hibernatetest {

	public static void main(String[] args) {
		
		Session session = hibernateutil.getSessionFacatory().openSession();
		session.beginTransaction();
		message message = new message("Hello world with Hibernate");
		session.save(message);
		session.getTransaction().commit();
		session.close();
	}
}
