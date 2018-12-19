package com.pro.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;



import com.product.model.ProductService;
import com.product.model.ProductVO;
import com.productclass.model.ProductClassService;
import com.productclass.model.ProductClassVO;

import sun.misc.IOUtils;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5  * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class ProServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
 
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
if ("getOne_For_Display".equals(action)) { //來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("pro_no");

				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入員工編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/pro/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				String pro_no = null;
				pro_no = str;

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/pro/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				ProductService proSvc = new ProductService();
				ProductVO proVO = proSvc.getOneProduct(pro_no);
				if (proVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/pro/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("empVO", proVO); // 資料庫取出的empVO物件,存入req
				String url = "/pro/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/pro/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			
			try {
				/***************************1.接收請求參數****************************************/
				String pro_no = req.getParameter("pro_no");
				
				/***************************2.開始查詢資料****************************************/

				ProductService proSvc = new ProductService();
				ProductVO prodVO = proSvc.getOneProduct(pro_no);
				
								
				/***************************3查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("empVO", prodVO);         // 資料庫取出的empVO物件,存入req
				String url = "/pro/update_emp_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/pro/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
		
		
if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			System.out.println("有近來");
		    
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//解析網頁送來的圖片
				Part part = req.getPart("pro_pic");			
				InputStream in = part.getInputStream();	
				byte[] pro_pic = ProServlet.Photo(in);
				
				
				String pro_no = req.getParameter("pro_no");
				String pro_classid = req.getParameter("pro_classid");
				String pro_name = req.getParameter("ename");
				String pro_pic_ext = req.getParameter("pic_ext");
				String pro_format = req.getParameter("format");
				Integer pro_bonus = new Integer(req.getParameter("bonus").trim());
				Integer pro_stock = new Integer(req.getParameter("stock").trim());
				Integer pro_safestock = new Integer(req.getParameter("stock").trim());
				String pro_details = req.getParameter("details");
				String pro_shelve = req.getParameter("shelve");
				Integer pro_all_assess = new Integer(req.getParameter("assess").trim());
				Integer pro_all_assessman = new Integer(req.getParameter("assessman").trim());
				
				
				System.out.println("pro_no :" + pro_no);
				System.out.println("pro_no :" + pro_classid);
				System.out.println("pro_no :" + pro_name);
				System.out.println("pro_no :" + pro_pic_ext);
				System.out.println("pro_no :" + pro_format);
				System.out.println("pro_no :" + pro_bonus);
				System.out.println("pro_no :" + pro_stock);
				System.out.println("pro_no :" + pro_safestock);
				System.out.println("pro_no :" + pro_shelve);
				System.out.println("pro_no :" + pro_all_assess);
				System.out.println("pro_no :" + pro_all_assessman);
				
				
				
				
				ProductVO proVO = new ProductVO();
				proVO.setPro_no(pro_no);
				proVO.setPro_classid(pro_classid);
		        proVO.setPro_name(pro_name);
		        proVO.setPro_pic(pro_pic);//圖片給空 *注意*
		        proVO.setPro_pic_ext(pro_pic_ext);
		        proVO.setPro_format(pro_format);
		        proVO.setPro_bonus(pro_bonus);
		        proVO.setPro_stock(pro_stock);
		        proVO.setPro_safestock(pro_safestock);
		    	proVO.setPro_details(pro_details);
		    	proVO.setPro_shelve(pro_shelve);
		    	proVO.setPro_all_assess(pro_all_assess);
		    	proVO.setPro_all_assessman(pro_all_assessman);
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("empVO", proVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/pro/update_emp_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				ProductService proSvc = new ProductService();
				ProductVO prodVO = proSvc.updatePro(pro_no, pro_classid, pro_name, pro_pic, pro_pic_ext,
						pro_format, pro_bonus, pro_stock, pro_safestock, pro_details, pro_shelve,
						pro_all_assess, pro_all_assessman);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("empVO", proVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
				String url = "/pro/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/pro/update_emp_input.jsp");
				failureView.forward(req, res);
			}
		}

if ("insert".equals(action)) { //來自addEmp.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				//解析網頁送來的圖片
				Part part = req.getPart("pro_pic");			
				InputStream in = part.getInputStream();	
				byte[] pro_pic = ProServlet.Photo(in);
				//拿取網頁資料
				String pro_classid = req.getParameter("pro_classid");
				String ename = req.getParameter("ename");
				
				String pic_ext = req.getParameter("pic_ext");
				String format = req.getParameter("format");
				Integer bonus = new Integer(req.getParameter("bonus").trim());
				Integer stock = new Integer(req.getParameter("stock").trim());
				Integer safestock = new Integer(req.getParameter("stock").trim());
				String details = req.getParameter("details");
				String shelve = req.getParameter("shelve");
				Integer assess = new Integer(req.getParameter("assess").trim());
				Integer assessman = new Integer(req.getParameter("assessman").trim());

				ProductVO proVO = new ProductVO();
				proVO.setPro_classid(pro_classid);
		        proVO.setPro_name(ename);
		        proVO.setPro_pic(pro_pic);//圖片給空
		        proVO.setPro_pic_ext(pic_ext);
		        proVO.setPro_format(format);
		        proVO.setPro_bonus(bonus);
		        proVO.setPro_stock(stock);
		        proVO.setPro_safestock(safestock);
		    	proVO.setPro_details(details);
		    	proVO.setPro_shelve(shelve);
		    	proVO.setPro_all_assess(assess);
		    	proVO.setPro_all_assessman(assessman);
		    	


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("empVO", proVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/pro/addEmp.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				ProductService proSvc = new ProductService();
				proVO = proSvc.addPro(pro_classid,ename,pro_pic,pic_ext,format,bonus,stock,safestock,details,shelve,assess,assessman);
				
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/pro/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/pro/addEmp.jsp");
				failureView.forward(req, res);
			}
		}
		
		
if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
	
			try {
				/***************************1.接收請求參數***************************************/
				String pro_no = req.getParameter("pro_no");

				/***************************2.開始刪除資料***************************************/
				ProductService proSvc = new ProductService();
				proSvc.deletePro(pro_no);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/pro/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/pro/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
	}

    public static byte[] Photo (InputStream in) {  //將inputStream to byte[]
    	   
        byte[] buff = new byte[8000];
        int bytesRead = 0;
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        try {
			while((bytesRead = in.read(buff)) != -1) {
			   bao.write(buff, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        byte[] data = bao.toByteArray();
		
    	return data;
    }
}
