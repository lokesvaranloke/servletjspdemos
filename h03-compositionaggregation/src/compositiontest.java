import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.address;
import com.samples.domain.user;
import com.samples.utils.hibernateutil;

public class compositiontest {

	public static void main(String[] args) {
		
		Session session = hibernateutil.getSessionFacatory().openSession();
		
		Transaction tn = session.getTransaction();
		
		try {

			tn.begin();

			address billaddress = new address("12", "Main Street", "Chennai", "612345");
			address shipaddress = new address("65/12", "Busy Street", "Trichy", "412385");
			user user = new user("Ajay", billaddress, shipaddress);
			session.save(user);

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
