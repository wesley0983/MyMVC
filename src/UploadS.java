import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

@WebServlet("/uploadServlet3.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5  * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
// 當數據量大於fileSizeThreshold值時，內容將被寫入磁碟
// 上傳過程中無論是單個文件超過maxFileSize值，或者上傳的總量大於maxRequestSize 值都會拋出IllegalStateException 異常
public class UploadS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String saveDirectory = "/images_uploaded"; // 上傳檔案的目地目錄;
											   // 將由底下的第26~30行用 java.io.File 於 ContextPath 之下, 自動建立目地目錄

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("Big5"); // 處理中文檔名
		res.setContentType("text/html; charset=Big5");
		PrintWriter out = res.getWriter();
		System.out.println("ContentType="+req.getContentType()); // 測試用

		String realPath = getServletContext().getRealPath(saveDirectory);
		System.out.println("realPath="+realPath); // 測試用
		File fsaveDirectory = new File(realPath);
		if (!fsaveDirectory.exists())
			 fsaveDirectory.mkdirs(); // 於 ContextPath 之下,自動建立目地目錄

		Collection<Part> parts = req.getParts(); // Servlet3.0新增了Part介面，讓我們方便的進行檔案上傳處理
		out.write("<h2> Total parts : " + parts.size() + "</h2>");

		for (Part part : parts) {
//			out.println("part.getSubmittedFileName():"+part.getSubmittedFileName()); 3.1 API
			if (getFileNameFromPart(part) != null && part.getContentType()!=null) {
				out.println("<PRE>");
				String name = part.getName();  //只是HTML標籤的name
				String filename = getFileNameFromPart(part);  //API並沒有設計取得檔案名稱，所以必須自訂方法
				String ContentType = part.getContentType();  //取得副檔名，但是不同瀏覽器會有沒辦法取得真實副檔名的問題
				long size = part.getSize();
				File f = new File(fsaveDirectory, filename);   //建立file物件在第51行可以運用

				out.println("name: " + name);
				out.println("filename: " + filename);
				out.println("ContentType: " + ContentType);
				out.println("size: " + size);
				out.println("File: " + f);

				// 利用File物件,寫入目地目錄,上傳成功
//				System.out.println("f:" + f.toString());
				part.write(f.toString());

				// 額外測試 InputStream 與 byte[] (幫將來model的VO預作準備)
				InputStream in = part.getInputStream();
				byte[] buf = new byte[in.available()];
				in.read(buf);
				in.close();
				out.println("buffer length: " + buf.length);
				
				// 額外測試秀圖
				out.println("<br><img src=\""+req.getContextPath()+saveDirectory+"/"+filename+"\">");

				out.println();
				out.println("</PRE>");
			}
		}
	}

	// 取出上傳的檔案名稱 (因為API未提供method,所以必須自行撰寫)
	public String getFileNameFromPart(Part part) {
		String header = part.getHeader("content-disposition");
		System.out.println("header=" + header); // 測試用
		//用substring取得字串段落  此做法可以不用轉成file物件也可以，只是轉乘file物件能夠有更多做法
		String filename = new File(header.substring(header.lastIndexOf("=") + 2, header.length() - 1)).getName();
		System.out.println("filename=" + filename); // 測試用
		if (filename.length() == 0) {
			return null;
		}
		return filename;
	}
}