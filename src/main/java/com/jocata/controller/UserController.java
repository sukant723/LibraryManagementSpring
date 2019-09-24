
package com.jocata.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.jocata.model.Department;
import com.jocata.model.Student;
import com.jocata.model.StudentPdf;
import com.jocata.model.UserMaster;
import com.jocata.configuration.CreatePdfStudent;
import com.jocata.services.LibraryServices;


@Component
@RestController
public class UserController {

	@Autowired
	private LibraryServices Services;
	public UserMaster UsLogedin;
	public int LoggedUserId ;
	public Department currentDetails ;


	@PostMapping(value = "/Login")
	public ModelAndView loginPage(HttpServletRequest request, ModelAndView model) {
		try {

			System.out.println("in login merthod.... ready to get data ");
			String email = request.getParameter("email");

			String passWord = request.getParameter("password");

			for (UserMaster ud : display()) {
				if (ud.getUserName().equals(email)&&ud.getPassWord().equals(passWord)) {
					UsLogedin = ud; 
					LoggedUserId =  ud.getId();
					System.out.println("check complete....... Login Succesfull");
					model.addObject("name", UsLogedin.getName());
					model.setViewName("/WelcomePage");
					break ;
				}

				else {
					model.setViewName("/Login");
				}
			}

			return model;




		} 


		catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("Error");
		}

	}

	@PostMapping("/AddUser")
	public ModelAndView addUser(@ModelAttribute("userMaster") UserMaster userMaster) {

		try {
			Boolean check =Services.saveuser(userMaster);

			String Update;
			if (check) {
				Update = "Record is Updated ";

			} else
				Update = "Record Not Updated";

			if(check) {
				System.out.println("saved....");
			}
			return new ModelAndView("AddUser","Ustatjsp", Update);

		} catch (Exception e) {
			e.printStackTrace();
			GetErrorPage();
		}
		return  new ModelAndView("Error");

	}


	@RequestMapping("/AddUser")
	public ModelAndView getAdduser(ModelAndView model ) {
		System.out.println("got add user request......... ading jsp.........");
		model.addObject("/AddUser");
		return model;
	}

	@RequestMapping("/Users")
	public ModelAndView getUser(ModelAndView model) {
		System.out.println("got Welcome Request ....  adding jsp.....");

		List<UserMaster> alldet =Services.Userdisplay();
		model.addObject("AllDet",alldet);
		model.addObject("Users");
		return model;
	}

	public ModelAndView GetErrorPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/Error");
		return null;

	}

	@PostMapping(value="/AddStudent")
	public ModelAndView AddStudent(ModelAndView model,HttpServletRequest request,Student student
			,@RequestParam("Name") String Name, @RequestParam("email") String email) {

		try {
			InputStream inputStream = null;
			System.out.println("in AddStudent method.... ready to get data ");
			Part Simage = request.getPart("spic");

			if (Simage != null) {
				// prints out some information for debugging
				System.out.println(Simage.getName());
				System.out.println(Simage.getContentType());

				// obtains input stream of the upload file
				inputStream = Simage.getInputStream();
			}
			byte[] bytes = IOUtils.toByteArray(inputStream);


			Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

			int Did = Integer.parseInt(request.getParameter("select"));
			int Rollno = Integer.parseInt(request.getParameter("rollno"));
			int select1 = Integer.parseInt(request.getParameter("select"));
			Department btype = new Department();
			btype.setId(select1);

			student.setPhoto(blob);
			student.setsName(Name);
			student.setEmail(email);
			student.setDeptId(btype);
			student.setRollNo(Rollno);
			CreatePdfStudent create = new CreatePdfStudent();
			Boolean check2 = create.CreatePdf(student);
			Boolean check = Services.AddStudent(student);
		
			String fileName= "studentpdf_" + student.getRollNo() + ".pdf";
			 InputStream inputStream1 = new FileInputStream("C:/Users/sukant.singhal/Desktop/StudentPdf/"+fileName);


		      
		        byte[] bytes1 = IOUtils.toByteArray(inputStream1);


				Blob blob1 = new javax.sql.rowset.serial.SerialBlob(bytes1);
		        inputStream1.close(); 
		        StudentPdf studentPdf = new StudentPdf();
		        studentPdf.setPdf(blob1);
		        Boolean Check3 = Services.SavePdf(studentPdf);
			
			String Update;
			if (check==true && check2==true) {
				Update = "Record is Updated ";
			
				

			} else
				Update = "Record Not Updated";

			if(check) {
				System.out.println("saved....");

				model.addObject("Name",Name);
				model.addObject("email",email);
				model.addObject("select",Did);
				model.addObject("rollno",Rollno);
				model = new ModelAndView("AddStudent","Ustatjsp", Update);

			}


		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("Error");
		}



		return model;


	}

	@RequestMapping("/login")
	public ModelAndView getLoginPage(ModelAndView model) {
		model.setViewName("Login");
		System.out.println("inside /login..........");
		return model;
	}

	@RequestMapping("/display")
	private List<UserMaster> display() {
		System.out.println("got request, calling service ....");
		return Services.Userdisplay();

	}

	@RequestMapping("/AddStudent")
	public ModelAndView getAddStudent(ModelAndView model) {
		System.out.println("got Add Student Request ....  adding jsp.....");
		List<Department> DList = Services.GetDepartmentById();
		model.addObject("dList",DList);
		model.addObject("AddStudent");
		return model;
	}

	@RequestMapping("/WelcomePage")
	public ModelAndView getWelcomePage(ModelAndView model) {
		System.out.println("got Welcome Request ....  adding jsp.....");
		model.addObject("WelcomePage");
		return model;
	}
	@RequestMapping("/Students")
	public ModelAndView getStudentsPage() {
		System.out.println("got Books Request ....  adding jsp.....");
		ModelAndView model = new ModelAndView("Students");
		List<Student> alldet= Services.GetStudents();
		model.addObject("AllDet",alldet);

		return model;
	}

	@RequestMapping("/UpdateStudent")
	public void  UpdateStudent(int sid,String sname,String sdepartmentn,int srollno,String semail ) {
		System.out.println("got student update Request ....... sending request .........");
		try {
			String stdepartment = sdepartmentn;
			List<Department> Studentdepartment = Services.GetDepartmentById();
			for(Department s : Studentdepartment) {
				if(s.getDName().equals(stdepartment)) {
					currentDetails =s;
				}
			}

			Student students = new Student();
			students.setId(sid);
			students.setsName(sname);
			students.setDeptId(currentDetails);
			students.setRollNo(srollno);
			students.setEmail(semail);

			Boolean check=	Services.UpdateStudent(students);

			if(check==true) {
				getStudentsPage();

			}

		} catch (Exception e) {
			e.printStackTrace();
			GetErrorPage();
		}



	}

	@RequestMapping("/DeleteStudent")
	public void DeleteStudent(int sid,String sname,String sdepartmentn,int srollno,String semail) {

		System.out.println("got student delete Request ....... sending request .........");
		try {
			String stdepartment = sdepartmentn;
			List<Department> Studentdepartment = Services.GetDepartmentById();
			for(Department s : Studentdepartment) {
				if(s.getDName().equals(stdepartment)) {
					currentDetails =s;
				}
			}

			Student students = new Student();
			students.setId(sid);
			students.setsName(sname);
			students.setDeptId(currentDetails);
			students.setRollNo(srollno);
			students.setEmail(semail);

			Boolean check=	Services.DeleteStudent(students);

			if(check==true) {
				getStudentsPage();

			}

		} catch (Exception e) {
			e.printStackTrace();
			GetErrorPage();
		}

	}



	@RequestMapping("/UpdateUser")
	public void UpdateUser(int sid,String sname,String susername,String spassword ) {

		System.out.println("got user Update Request .... passing to service........");
		try {
			UserMaster usermaster =new UserMaster();

			usermaster.setId(sid);
			usermaster.setName(sname);
			usermaster.setPassWord(spassword);
			usermaster.setUserName(susername);

			Services.UpdateUser(usermaster);

		} catch (Exception e) {
			e.printStackTrace();
			GetErrorPage();
		}

	}


	@RequestMapping("/DeleteUser")
	public void DeleteUser(int sid,String sname,String susername,String spassword) {
		System.out.println("got user Delete Request .... passing to service........");
		try {
			UserMaster usermaster =new UserMaster();

			usermaster.setId(sid);
			usermaster.setName(sname);
			usermaster.setPassWord(spassword);
			usermaster.setUserName(susername);

			Services.DeleteUser(usermaster);

		} catch (Exception e) {
			e.printStackTrace();
			GetErrorPage();
		}
	}


}
