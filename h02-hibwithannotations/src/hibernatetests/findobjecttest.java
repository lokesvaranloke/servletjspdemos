package hibernatetests;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.message;
import com.samples.utils.hibernateutil;

public class findobjecttest {

	public static void main(String[] args) {

		Session session = hibernateutil.getSessionFacatory().openSession();

		Transaction tn = session.getTransaction();

		try {
			tn.begin();

			message message = session.get(message.class, 2);

			System.out.println(message);

			tn.commit();

		} catch (Exception e) {
			if (tn != null) {
				tn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
