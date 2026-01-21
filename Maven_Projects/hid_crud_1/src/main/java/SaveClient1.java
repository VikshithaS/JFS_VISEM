import org.hibernate.Session;
import org.hibernate.Transaction;

public class SaveClient1 {

	public static void main(String[] args) {
		
		Session session=HSFactory.getSession();
		Transaction t=session.beginTransaction();
		try {
			Course c1=new Course(1,"Core Java","OOPs",60);
			Course c2=new Course(2,"Adv Java","JDBC,SERVELETS,JSP",60);
			Course c3=new Course(3,"Hibernate","IS-A,HAS-A",60);
			Course c4=new Course(4,"Spring","AOP",60);
			Course c5=new Course(5,"Spring boot","MICROSERVICE WITH JPA",60);
			session.save(c1);
			session.save(c2);
			session.save(c3);
			session.save(c4);
			session.save(c5);
			session.flush();
			t.commit();
			System.out.println("TX Success");
		}catch(Exception e) {
			t.rollback();
			System.out.println("TX Failed");
			e.printStackTrace();
			
		}
		

	}

}
