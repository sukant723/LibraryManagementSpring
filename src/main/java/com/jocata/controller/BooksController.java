package com.jocata.controller;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jocata.model.BookMaster;
import com.jocata.model.BookType;
import com.jocata.model.Student;
import com.jocata.model.UserMaster;
import com.jocata.model.BookIssue;
import com.jocata.services.LibraryServices;


@Component
@RestController
public class BooksController {

	@Autowired
	private LibraryServices Services;
	@Autowired
	public UserController UserController;


	public int UserId =0;

	@Autowired
	public BookMaster bookMaster;
	public BookType currentDetails ;	
	public BookIssue bookissue;
	BookMaster currentB;
	Student currentS;
	UserMaster currentU;
	BookIssue currentBI;


	@PostMapping(value="/AddBook")
	public ModelAndView AddBook(ModelAndView model,HttpServletRequest request,BookMaster bookMaster,
			String title,String description,String select,String publication,String yearofpublication,String ebookurl) {
		try
		{


			title=request.getParameter("title");
			description=request.getParameter("description");
			int bTypeId= Integer.parseInt(request.getParameter("select"));
			publication=request.getParameter("publication");
			yearofpublication=request.getParameter("yearofpublication");
			ebookurl= request.getParameter("ebookurl");
			BookType btype = new BookType();
			btype.setId(bTypeId);


			bookMaster.setTitle(title);
			bookMaster.setDescription(description);
			bookMaster.setBookType(btype);
			bookMaster.setPublication(publication);
			bookMaster.setYearOfPublication(yearofpublication);
			bookMaster.setEbookUrl(ebookurl);

			Boolean check = Services.AddBook(bookMaster);
			String Update;
			if (check) {
				Update = "Record is Updated ";

			} else
				Update = "Record Not Updated";

			if(check) {
				System.out.println("saved....");


				model = new ModelAndView("AddBook","Ustatjsp", Update);

			}


		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("Error");
		}

		return model;
	}


	@RequestMapping("/Books")
	public ModelAndView getWelcomePage() {
		System.out.println("got Books Request ....  adding jsp.....");
		ModelAndView model = new ModelAndView("Books");
		List<BookMaster> alldet= Services.GetBookMaster();
		model.addObject("AllDet",alldet);
		//model.addObject("Books");
		return model;
	}



	@RequestMapping("/UpdateBooks")
	public void UpdateBooks(int sid, String stitle, String sbooktypeid, String sdescription,
			String spublication, String syearofpublication, String sebookurl){
		try {
			String btcategory=sbooktypeid;
			List<BookType> booktypebyid =Services.GetBookTypeById();
			for(BookType d : booktypebyid) {

				if(d.getBookCategory().equals(btcategory)) {
					currentDetails = d;
				}
			}
			bookMaster.setId(sid);
			bookMaster.setBookType(currentDetails);
			bookMaster.setTitle(stitle);
			bookMaster.setDescription(sdescription);					
			bookMaster.setPublication(spublication);
			bookMaster.setYearOfPublication(syearofpublication);
			bookMaster.setEbookUrl(sebookurl);
			System.out.println("got Books Request ....  adding jsp.....");

			Services.UpdateBooks(bookMaster);

			getWelcomePage();

		}
		catch(Exception e) {
			e.printStackTrace();
			GetErrorPage();

		}

	}

	@PostMapping("/IssueBook")
	public ModelAndView IssueBook(ModelAndView model,HttpServletRequest request,BookIssue bookIssue,String BookId,String StRollNo,String date,String Nodays,String UserId,String status) {
		try {

			StRollNo= request.getParameter("SelectStudent");
			BookId= request.getParameter("BookId");

			date=request.getParameter("Date");
			Nodays= request.getParameter("Days");
			UserId= request.getParameter("UserId");
			status=request.getParameter("SelectStatus");
			SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");  
			Date issuedate1= formatter1.parse(date);
			System.out.println(issuedate1);


			List<Student> StudentD =Services.GetStudents();
			for(Student b : StudentD) {

				if(b.getId()==Integer.parseInt(StRollNo)) {
					currentS = b;
					break;
				}
			}
			bookIssue.setStudid(currentS);

			List<BookMaster> booktypebyid =Services.GetBookMaster();
			for(BookMaster b : booktypebyid) {

				if(b.getId()==Integer.parseInt(BookId)) {
					currentB = b;
					break;
				}
			}
			bookIssue.setBookid(currentB);

			bookIssue.setIssueDate( issuedate1);

			bookIssue.setNoDfDays(Integer.parseInt(Nodays));

			List<UserMaster> UserD =Services.Userdisplay();
			for(UserMaster b : UserD) {

				if(b.getId()==Integer.parseInt(UserId)) {
					currentU = b;
					break;
				}
			}
			bookIssue.setIssuedBy(currentU);


			bookIssue.setReturned(Integer.parseInt(status));

			Boolean check = Services.IssueBook(bookIssue);
			String Update;
			if (check) {
				Update = "Book Issued ";

			} else
				Update = "Error(Not Issued)";

			if(check) {
				System.out.println("saved....");


				model = new ModelAndView("Issue","Ustatjsp", Update);

			}

		} catch (Exception e) {
			e.printStackTrace();
			GetErrorPage();
		}
		return model;
	}


	@PostMapping("/SendBookId")
	public ModelAndView IssuePage(HttpServletRequest request) {
		UserId= UserController.LoggedUserId;
		try {

			String bookId = request.getParameter("bookid");

			if(UserId!=0){		
				System.out.println("got Issue Form Request ....  adding jsp.....");
				ModelAndView model = new ModelAndView("Issue");

				model.addObject("BookId",bookId);
				model.addObject("IssuedBy", UserId);
				List<Student> alldet= Services.GetStudents();
				model.addObject("AllDataStudent",alldet);
				return model;

			}
		}
		catch(Exception e) {
			e.printStackTrace();
			GetErrorPage();

		}
		ModelAndView model1 = new ModelAndView("Error");
		return model1;
	}


	@RequestMapping("/DeleteBook")
	public void DeleteBook(int sid, String stitle, String sbooktypeid, String sdescription,
			String spublication, String syearofpublication, String sebookurl) {
		try {
			String btcategory=sbooktypeid;
			List<BookType> booktypebyid =Services.GetBookTypeById();
			for(BookType d : booktypebyid) {

				if(d.getBookCategory().equals(btcategory)) {
					currentDetails = d;
				}
			}
			bookMaster.setId(sid);
			bookMaster.setBookType(currentDetails);
			bookMaster.setTitle(stitle);
			bookMaster.setDescription(sdescription);					
			bookMaster.setPublication(spublication);
			bookMaster.setYearOfPublication(syearofpublication);
			bookMaster.setEbookUrl(sebookurl);
			System.out.println("got Delete Book Request ....  Sending request.....");

			Boolean a=Services.BookDelete(bookMaster);
			if(a==true)
				getWelcomePage();

		}
		catch(Exception e) {
			e.printStackTrace();
			GetErrorPage();

		}

	}
	@RequestMapping("/AddBook")
	public ModelAndView getAddBook(ModelAndView model) {
		List<BookType> bTypeList = Services.GetBookTypeById();
		model.addObject("bTypeList",bTypeList);
		model.setViewName("/AddBook");
		return model;

	}

	public ModelAndView GetErrorPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/Error");
		return model;

	}


	@RequestMapping("/BookIssue")
	public ModelAndView getIssuePage() {
		System.out.println("got BooksIssue Request ....  adding jsp.....");
		ModelAndView model = new ModelAndView("BooksIssue");
		List<BookMaster> alldet= Services.GetBookMaster();
		model.addObject("AllDet",alldet);
		return model;
	}
	@RequestMapping("/Issue")
	public ModelAndView getIssueform(ModelAndView model) {

		model.setViewName("Issue");
		return model;
	}

	@RequestMapping("/IssueList")
	public ModelAndView getIssueList() {
		ModelAndView model = new ModelAndView();
		System.out.println("got BooksIssue Request ....  adding jsp.....");
		model.setViewName("IssuedList");
		List<BookIssue> alldet= Services.GetBookIssue();
		model.addObject("AllDet",alldet);
		return model;

	}
	@RequestMapping("/UpdateReturn")
	public void UpdateReturn(int sid){
		try {

			List<BookIssue> booktypebyid =Services.GetBookIssue();
			for(BookIssue d : booktypebyid) {

				if(d.getId()==sid) {
					currentBI = d;
				}
			}
			BookIssue bookissue = new BookIssue();
			bookissue.setId(sid);
			currentB=currentBI.getBookid();
			bookissue.setBookid(currentB);
			bookissue.setIssueDate(currentBI.getIssueDate());
			bookissue.setNoDfDays(currentBI.getNoDfDays());
			bookissue.setReturned(1);
			currentS=currentBI.getStudid();
			bookissue.setStudid(currentS);
			currentU=currentBI.getIssuedBy();
			bookissue.setIssuedBy(currentU);
			System.out.println("got Return Request ....  adding jsp.....");

			Boolean check = Services.IssueBook(bookissue);
			if(check==true) {
				getIssueList();}

		}
		catch(Exception e) {
			e.printStackTrace();
			GetErrorPage();

		}

	}

}
