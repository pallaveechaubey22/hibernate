package CRUDOperation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Student;

public class operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Object of class------->entry 1
		Student s1 = new Student();
		s1.setRollno(1);
		s1.setName("pallavee");
		s1.setAge(12);
		
		//---->entry 2
		Student s2 = new Student();
		s2.setRollno(2);
		s2.setName("raj");
		s2.setAge(25);
		
		//------------>emtry 3
		Student s3 = new Student();
		s3.setRollno(3);
		s3.setName("abhinav");
		s3.setAge(12);
		
		//---------------->entry 4
		Student s4 = new Student();
		s4.setRollno(4);
		s4.setName("shivangi");
		s4.setAge(5);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("product");
		EntityManager em = emf.createEntityManager();
		
		//create operation --> for create opertaion we need transaction/
		
		EntityTransaction et = em.getTransaction();
		et.begin();
//		em.persist(s1);
//		em.persist(s2);
//		em.persist(s3);
//		em.persist(s4);
		et.commit();
		
		//Read operation------------------>
		
		Student s =em.find(Student.class, 1);
		
		if(s!=null)
		System.out.println(s.getRollno()+" "+ s.getName()+" "+s.getAge());
		else
			System.out.println("not found");
		
		// update operation ---------------> 1. find,set  and 2 update
		
		Student u =em.find(Student.class, 2);
		if(u!=null) {
		u.setAge(28);
		et.begin();
		em.persist(u);
		et.commit();
		}
		else
			System.out.println("record not found");
		
		//delete operation-----------> find and then delete
		
		Student d = em.find(Student.class, 3);
		if(d!=null) {
			et.begin();
			em.remove(d);
			et.commit();
		}
		else
			System.out.println("record not found");

			
		
		
			
		

	}

}
