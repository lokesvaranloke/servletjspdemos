import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.guide;
import com.samples.domain.student;
import com.samples.utils.hibernateutil;

public class studenttowguideonestudent {

	public static void main(String[] args) {

		Session session = hibernateutil.getSessionFacatory().openSession();

		Transaction tn = session.getTransaction();

		try {

			tn.begin();

			guide guide1 = new guide("200ABC001","Robert Williams", 2000);
			guide guide2 = new guide("200ABC002","Ian Botham", 4000);
			student student1 = new student("SR001","John smith", guide2);
			
			
			session.persist(guide1);
			session.persist(student1);

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