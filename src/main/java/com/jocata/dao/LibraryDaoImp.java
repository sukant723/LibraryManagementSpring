package com.jocata.dao;


import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jocata.model.BookIssue;
import com.jocata.model.BookMaster;
import com.jocata.model.BookType;
import com.jocata.model.Department;
import com.jocata.model.Student;
import com.jocata.model.StudentPdf;
import com.jocata.model.UserMaster;
import com.jocata.dao.LibraryDao;

@Component
@Repository
@Transactional
public class LibraryDaoImp implements LibraryDao{
	@Autowired
	SessionFactory sessionfactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<UserMaster> getUserDetails(){
		Session session = sessionfactory.getCurrentSession();
		System.out.println("session is open, about to return userlist.....");
		return session.createQuery("from UserMaster").list();
	}






	@Override
	public Boolean AddStudent(Student student) {
		try {
			Session session = sessionfactory.getCurrentSession();
			System.out.println("session is open, about to save record.....");
			session.save(student);

			String query="from Student";
			@SuppressWarnings("unchecked")
			List<Student> studsaved = session.createQuery(query).list();

			for (Student d : studsaved) {
				if (d.getEmail().equals(student.getEmail())) 
					return true;			
			}
		} catch (Exception e) {
			e.printStackTrace();


		}

		return false;
	}






	@SuppressWarnings("unchecked")
	@Override
	public List<BookMaster> GetBookMaster() {
		try {

			return sessionfactory.getCurrentSession().createQuery("from BookMaster").list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}






	@Override
	public List<BookType> GetBookTypeById() {
		try {

			Session session = sessionfactory.getCurrentSession();
			System.out.println("session is open, about to return BookTypeById record.....");
			String query = "from BookType";
			@SuppressWarnings("unchecked")
			List<BookType> bookTypeById=session.createQuery(query).list();
			return bookTypeById;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}






	@Override
	public Boolean UpdateBooks(BookMaster bookMaster) {
		Session session = sessionfactory.getCurrentSession();
		System.out.println("session is open, about to Update BookMaster record.....");
		//BookMaster detailsUpdate = session.get(BookMaster.class, bookMaster.getId());
		try {
			session.update(bookMaster);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}






	@Override
	public Boolean BookDelete(BookMaster bookMaster) {
		Session session = sessionfactory.getCurrentSession();

		try {
			BookMaster detailsdelete = session.get(BookMaster.class, bookMaster.getId() );
			if(detailsdelete != null) {
				session.delete(detailsdelete);
			}
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}






	@Override
	public Boolean AddBook(BookMaster bookMaster) {

		try {
			Session session = sessionfactory.getCurrentSession();
			System.out.println("session is open, about to save record.....");
			Integer serializable = (Integer) session.save(bookMaster);

			if(serializable > 0) return true;
		} catch (Exception e) {
			e.printStackTrace();


		}

		return false;
	}






	@SuppressWarnings("unchecked")
	@Override
	public List<Student> GetStudents() {
		try {

			return sessionfactory.getCurrentSession().createQuery("from Student").list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}






	@Override
	public List<Department> GetDepartmentById() {
		try {
			Session session = sessionfactory.getCurrentSession();
			System.out.println("session is open, about to return DepartmentById record.....");
			String query = "from Department";
			@SuppressWarnings("unchecked")
			List<Department> DepartmentById=session.createQuery(query).list();
			return DepartmentById;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}






	@Override
	public Boolean UpdateStudent(Student student) {
		Session session = sessionfactory.getCurrentSession();
		System.out.println("session is open, about to Update BookMaster record.....");
		//BookMaster detailsUpdate = session.get(BookMaster.class, bookMaster.getId());
		try {
			session.update(student);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;

	}






	@Override
	public Boolean DeleteStudent(Student students) {
		Session session = sessionfactory.getCurrentSession();

		try {
			Student detailsdelete = session.get(Student.class, students.getId() );
			if(detailsdelete != null) {
				session.delete(detailsdelete);
			}
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}


		return null;
	}






	@Override
	public Boolean saveuser(UserMaster userMaster) {

		try {
			Session session = sessionfactory.getCurrentSession();
			System.out.println("session is open, about to save record.....");
			Integer serializable = (Integer) session.save(userMaster);

			if(serializable > 0) return true;
		} catch (Exception e) {
			e.printStackTrace();


		}

		return false;
	}






	@Override
	public Boolean UpdateUser(UserMaster usermaster) {

		try {
			Session session = sessionfactory.getCurrentSession();
			System.out.println("session is open, about to save record.....");

			session.update(usermaster);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}






	@Override
	public Boolean DeleteUser(UserMaster usermaster) {
		try {
			Session session = sessionfactory.getCurrentSession();
			System.out.println("session is open, about to save record.....");

			session.delete(usermaster);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}






	@Override
	public Boolean IssueBook(BookIssue bookIssue) {
		try {
			Session session = sessionfactory.getCurrentSession();
			System.out.println("session is open, about to save record.....");
			session.saveOrUpdate(bookIssue);

			String query0="from BookIssue";
			@SuppressWarnings("unchecked")
			List<BookIssue> Issuesaved0 = session.createQuery(query0).list();
			int counter=0;
			for (@SuppressWarnings("unused") BookIssue d : Issuesaved0) {
				counter++;

			}
			String query1="from BookIssue";
			@SuppressWarnings("unchecked")
			List<BookIssue> Issuesaved1 = session.createQuery(query1).list();

			for (BookIssue d : Issuesaved1) {
				if (d.getId()>counter) 
					return true;			
			}
		} 

		catch (Exception e) {
			e.printStackTrace();


		}

		return false;

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<BookIssue> GetBookIssue() {
		Session session = sessionfactory.getCurrentSession();
		System.out.println("session is open, about to return BookIssuelist.....");
		return session.createQuery("from BookIssue").list();	
	}






	@Override
	public Boolean Savepdf(StudentPdf studentPdf) {
		Session session = sessionfactory.getCurrentSession();
			session.saveOrUpdate(studentPdf);
		return true;
	}


}
