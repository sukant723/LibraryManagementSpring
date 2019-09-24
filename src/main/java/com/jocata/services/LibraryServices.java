package com.jocata.services;

import java.util.List;

import com.jocata.model.BookIssue;
import com.jocata.model.BookMaster;
import com.jocata.model.BookType;
import com.jocata.model.Department;
import com.jocata.model.Student;
import com.jocata.model.StudentPdf;
import com.jocata.model.UserMaster;

public interface LibraryServices {

	public List<UserMaster> Userdisplay();
	
	public Boolean AddStudent(Student student);

	public List<BookMaster> GetBookMaster();
	
    public List<BookType> GetBookTypeById();
    
    public Boolean UpdateBooks(BookMaster bookMaster);

	public Boolean BookDelete(BookMaster bookMaster);

	public Boolean AddBook(BookMaster bookMaster);

	public List<Student> GetStudents();

	public List<Department> GetDepartmentById();

	public Boolean UpdateStudent(Student student);

	public Boolean DeleteStudent(Student students);

	public Boolean saveuser(UserMaster userMaster);

	public Boolean UpdateUser(UserMaster usermaster);

	public Boolean DeleteUser(UserMaster usermaster);

	public Boolean IssueBook(BookIssue bookIssue);

	public List<BookIssue> GetBookIssue();

	public Boolean SavePdf(StudentPdf studentPdf);



	
}