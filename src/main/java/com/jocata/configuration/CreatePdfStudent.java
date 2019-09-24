package com.jocata.configuration;


import java.io.FileOutputStream;

import java.sql.Blob;



import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jocata.model.Department;
import com.jocata.model.Student;

 
public class CreatePdfStudent {
	
	
	public Boolean CreatePdf(Student student){
		Document document = new Document();
		try
		{	
			int sid = student.getId();
			String sname = student.getsName();
			String semail = student.getEmail();
			Department dept = student.getDeptId();
			int deptname =  dept.getId();
			Blob imageblob = student.getPhoto();
			byte[] imageBytes = imageblob.getBytes(1, (int) imageblob.length());
			Image image = Image.getInstance(imageBytes);
			int rollno  =student.getRollNo();
			
			  String fileName = "studentpdf_" + rollno + ".pdf";
		    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/sukant.singhal/Desktop/StudentPdf/"+fileName));
		    document.open();
		    //document.add(new Paragraph("Student DB Id =  "+sid));
		    document.add(new Paragraph("Student Name =  "+sname));
		    document.add(new Paragraph("Student Roll No. =  "+rollno));
		    document.add(new Paragraph("Student Department =  "+deptname));
		    document.add(new Paragraph("Student Email =  "+semail));
		    
		    //Add Image
		    Image image1 = Image.getInstance(image);
		    //Fixed Positioning
		    image1.setAbsolutePosition(300f,720f);
		    //Scale to new height and new width of image
		    image1.scaleAbsolute(100, 100);
		    //Add to document
		    document.add(image1);
		 
		    document.close();
		    writer.close();
			return true;
		} catch (Exception e)
		{
		    e.printStackTrace();
		}

		
		return false;
		
	}
	

}
