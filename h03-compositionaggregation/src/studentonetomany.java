import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.guide;
import com.samples.domain.student;
import com.samples.utils.hibernateutil;

public class studentonetomany {

	public static void main(String[] args) {

		Session session = hibernateutil.getSessionFacatory().openSession();

		Transaction tn = session.getTransaction();

		try {

			tn.begin();

			guide guide = new guide("200ABC005","Robert Williams", 2000);
			student student1 = new student("SR001","John smith", guide);
			student student2 = new student("SR002","Amy jackson", guide);
			
			
			guide.getStudents().add(student1);
			guide.getStudents().add(student2);
			
			session.persist(guide);

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