package com.jocata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jocata.dao.LibraryDao;
import com.jocata.model.BookIssue;
import com.jocata.model.BookMaster;
import com.jocata.model.BookType;
import com.jocata.model.Department;
import com.jocata.model.Student;
import com.jocata.model.StudentPdf;
import com.jocata.model.UserMaster;

@Component
@Service
public class LibraryServicesImp implements LibraryServices{
	@Autowired
	private LibraryDao getmsg ;

	@Override
	public List<UserMaster> Userdisplay() {
		System.out.println("reached service, calling dao to return list...");
		return getmsg.getUserDetails();
	}

	@Override
	public Boolean AddStudent(Student student) {
		System.out.println("reached service, calling dao.......");
		return getmsg.AddStudent(student);
	}

	@Override
	public List<BookMaster> GetBookMaster() {
		System.out.println("Reached Service....about to return bookmaster list.....");
		return getmsg.GetBookMaster();
	}

	@Override
	public List<BookType> GetBookTypeById() {
		// TODO Auto-generated method stub
		return getmsg.GetBookTypeById();
	}

	@Override
	public Boolean UpdateBooks(BookMaster bookMaster) {
		System.out.println("Reached Service....about to call dao.........................");
		return getmsg.UpdateBooks(bookMaster);
	}

	@Override
	public Boolean BookDelete(BookMaster bookMaster) {
		System.out.println("Reached Service....about to call dao.........................");
		return getmsg.BookDelete(bookMaster);
	}

	@Override
	public Boolean AddBook(BookMaster bookMaster) {
		System.out.println("Reached Service....about to call dao.........................");
		return getmsg.AddBook(bookMaster);
	}

	@Override
	public List<Student> GetStudents() {
		
		return getmsg.GetStudents();
	}

	@Override
	public List<Department> GetDepartmentById() {
		
		return getmsg.GetDepartmentById();
	}

	@Override
	public Boolean UpdateStudent(Student student) {
		System.out.println("Reached Service....about to send update data.....");
		return getmsg.UpdateStudent(student);
	}

	@Override
	public Boolean DeleteStudent(Student students) {
		System.out.println("Reached Service....about to send student delete data.....");
		return getmsg.DeleteStudent(students);
	}

	@Override
	public Boolean saveuser(UserMaster userMaster) {
		System.out.println("Reached Service....about to send user data.....");
		return getmsg.saveuser(userMaster);
	}

	@Override
	public Boolean UpdateUser(UserMaster usermaster) {
		System.out.println("Reached service ...... about to send data to dao................");
		return getmsg.UpdateUser(usermaster);
	}

	@Override
	public Boolean DeleteUser(UserMaster usermaster) {
		System.out.println("Reached service ...... about to send Delete data to dao................");
		return getmsg.DeleteUser(usermaster);
	}

	@Override
	public Boolean IssueBook(BookIssue bookIssue) {
		System.out.println("reached service, calling dao to Save Data...");
		return getmsg.IssueBook(bookIssue);
	}

	@Override
	public List<BookIssue> GetBookIssue() {
		System.out.println("reached service, calling dao to Get Data...");
		return getmsg.GetBookIssue();
	
	}

	@Override
	public Boolean SavePdf(StudentPdf studentPdf) {
	
		return getmsg.Savepdf(studentPdf);
	}

	

	

}
