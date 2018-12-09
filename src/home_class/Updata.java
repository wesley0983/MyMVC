package home_class;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Updata.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5  * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class Updata extends HttpServlet{
	String saveDirectory = "/images_updata"; //�ŧi�W���ɮ� �ؿ���Ƨ�
	String DeletePath = null;
	StringBuffer fileNameone = new StringBuffer();
	ArrayList<String> al = new ArrayList();

	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException {
		//HttpServletRequest req , HttpServletResponse res
		req.setCharacterEncoding("Big5");
		res.setContentType("text/html; charset=Big5");
		PrintWriter out = res.getWriter();
		
		String realPath = getServletContext().getRealPath(saveDirectory);  //���o�W���ɮ� �ؿ���Ƨ�
		DeletePath = realPath;  //�R�� �ɮץؿ���Ƨ�
		File file = new File(realPath);// �۰ʥͦ��W�Ǹ�Ƨ�
		if(!file.exists()) {
			file.mkdirs();
		}
		int count = 0;
		Collection<Part> parts = req.getParts();
//		out.write("<h2>parts:" + parts.size() + "</h2>");
		if(parts != null) {
			for(Part part : parts) {	
				if (getFileNameFromPart(part) != null && part.getContentType()!=null) {
					out.println("<form action=\"Updata.do\" method = post enctype=\"multipart/form-data\">");
					
					out.println("<PRE>");
					String name = part.getName();  //�u�OHTML���Ҫ�name
					String filename = getFileNameFromPart(part);  //API�èS���]�p���o�ɮצW�١A�ҥH�����ۭq��k
					File f = new File(file, filename);   //�إ�file����b��51��i�H�B��
	//				fileNameone.append(filename);
					al.add(filename);
	                
					// �Q��File����,�g�J�ئa�ؿ�,�W�Ǧ��\
	//				System.out.println("f:" + f.toString());
					part.write(f.toString());
					System.out.println("��"+count);
					System.out.println("filename:"+filename);
					 System.out.println("����"+getServletContext().getResource("/"+filename));
					// �B�~���ըq��
					out.println("<br><img width=200 heigth=200 src=\""+req.getContextPath()+saveDirectory+"/"+filename+"\">");
	                
					out.println("<input type=\"submit\" name= "+ count +" value=\"�R��\"><br>");
					out.println();
					out.println("</PRE>");
					out.println("</form>");
					count++;
				}
			}
		} 
			System.out.println("123");
			Enumeration enum1 = req.getParameterNames();
			while(enum1.hasMoreElements()) {
				String name = (String)enum1.nextElement();
				String values[] = req.getParameterValues(name);
				if(values != null) {
					for(int i = 0 ; i < values.length ; i++) {
						out.println(name + "[" + i + "]:" + values[i]); 
						System.out.println(name + "[" + i + "]:" + values[i]);
						String test = al.get(Integer.parseInt(name));
						System.out.println(DeletePath + "\\" + test );
						File fileDeletePath = new File(DeletePath + "\\" + test);
			            fileDeletePath.delete();
					}
				}
			}
			
		
	}
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		req.setCharacterEncoding("Big5");
		res.setContentType("text/html; charset=Big5");
		PrintWriter out = res.getWriter();
		

//		File file = new File("fileDeletePath");
//		if(file.exists()) {
//			file.delete();
//			out.println("<h1>�R�����\<h1>");
//		} 
/*		System.out.println(fileNameone );
		System.out.println("DeletePath: "+DeletePath);
		System.out.println(DeletePath + "\\" + fileNameone );*/
		Enumeration enum1 = req.getParameterNames();
		while(enum1.hasMoreElements()) {
			String name = (String)enum1.nextElement();
			String values[] = req.getParameterValues(name);
			if(values != null) {
				for(int i = 0 ; i < values.length ; i++) {
					out.println(name + "[" + i + "]:" + values[i]); 
					System.out.println(name + "[" + i + "]:" + values[i]);
					String test = al.get(Integer.parseInt(name));
					System.out.println(DeletePath + "\\" + test );
					File fileDeletePath = new File(DeletePath + "\\" + test);
		            fileDeletePath.delete();
				}
			}
		}
		
		
		/*
		File fileDeletePath = new File(DeletePath);
		for(File file : fileDeletePath.listFiles()) {
			if(!file.isDirectory()) {
				file.delete();
//				System.out.println(file.getName()+ " is deleted!" );
			}
		}
		*/
		/*
		File fileDeletePath = new File(DeletePath);
		for(File file : fileDeletePath.listFiles()) {
			if(!file.isDirectory()) {
				file.delete();
				System.out.println(file.getName()+ " is deleted!" );
			}
		}
		*/
//		String[] path = null;
//		path = fileDeletePath.list();
//		for(int i = 0 ; i < path.length ; i++) {
//			System.out.println(path[i]);
//			
//		}
//		if(fileDeletePath.delete()){
//			System.out.println(fileDeletePath.getName() + " is deleted!");
//		}else{
//			System.out.println("Delete operation is failed.");
//		}
	   
		
	}
	
	// ���X�W�Ǫ��ɮצW�� (�]��API������method,�ҥH�����ۦ漶�g)
		public String getFileNameFromPart(Part part) {
			String header = part.getHeader("content-disposition");
//1			System.out.println("header=" + header); // ���ե�
			//��substring���o�r��q��  �����k�i�H�����নfile����]�i�H�A�u�O�୼file����������h���k
			String filename = new File(header.substring(header.lastIndexOf("=") + 2, header.length() - 1)).getName();
//1			System.out.println("filename=" + filename); // ���ե�
			if (filename.length() == 0) {
				return null;
			}
			return filename;
	}

}
