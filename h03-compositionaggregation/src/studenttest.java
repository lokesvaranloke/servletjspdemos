import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.guide;
import com.samples.domain.student;
import com.samples.utils.hibernateutil;

public class studenttest {

	public static void main(String[] args) {

		Session session = hibernateutil.getSessionFacatory().openSession();

		Transaction tn = session.getTransaction();

		try {

			tn.begin();

			guide guide = new guide("200ABC001","Mike Lawson", 1000);
			student student1 = new student("SR001","Max", guide);
			student student2 = new student("SR002", "Bob", guide);
			
			session.save(guide);
			session.save(student1);
			session.save(student2);

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