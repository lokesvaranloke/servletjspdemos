package hibernatetests;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.message;
import com.samples.utils.hibernateutil;

public class updatetest {

	public static void main(String[] args) {

		Session session1 = hibernateutil.getSessionFacatory().openSession();

		Transaction tn = session1.getTransaction();

		tn.begin();

		message message = session1.get(message.class, 6);

		System.out.println(message);

		tn.commit();
		
		session1.close();
		
		message.setText("Object with id 6 changed text");
		
		Session session2 = hibernateutil.getSessionFacatory().openSession();
		
		session2.beginTransaction();
		
		session2.update(message);
		
		session2.getTransaction().commit();
		
		session2.close();

	}
}
