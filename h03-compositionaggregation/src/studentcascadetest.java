import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.guide;
import com.samples.domain.student;
import com.samples.utils.hibernateutil;

public class studentcascadetest {

	public static void main(String[] args) {

		Session session = hibernateutil.getSessionFacatory().openSession();

		Transaction tn = session.getTransaction();

		try {

			tn.begin();

			guide guide = new guide("200ABC002","John Doe", 1500);
			student student4 = new student("SR004","Jill", guide);
			
			
			session.persist(student4);

			tn.commit();

		} catch (Exception ex) {
			if (tn != null) {
				tn.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}