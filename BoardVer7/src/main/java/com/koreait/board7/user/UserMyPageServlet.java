package com.koreait.board7.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/user/myPage")
public class UserMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJsp("MYPAGE", "user/userMyPage", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath = request.getRealPath("/res/img");
		int maxFileSize = 10_485_860; // 10 * 1024 * 1024(10MB)
		System.out.println("uploadPath : " + uploadPath);
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath + "/temp", maxFileSize,
				"UTF-8", new DefaultFileRenamePolicy()); // 중복된 파일명에 대한 처리 기능(파일명에 1을 덧붙임)
		int loginUserPk = MyUtils.getLoginUserPk(request);
		String targetFolder = uploadPath + "/user/" + loginUserPk;
		
		File folder = new File(targetFolder);

		folder.mkdirs();
		
		// 업로드가 완료된 파일명
		String fileNm = multi.getFilesystemName("profileImg");
		System.out.println("fileNm" + fileNm);
		
		int lastDotIdx = fileNm.lastIndexOf("."); 
		// 파일의 맨 오른쪽부터 .을 찾고 .을 기준으로 확장자를 찾는 기술
		String ext = fileNm.substring(lastDotIdx); 
		// +1 을 주지 않으면 .jpg의 .까지 포함되어 버린다. 
		
		String newFileNm = UUID.randomUUID().toString() + ext; 
		// 원래 return타입은 UUID
		
		File imgFile = new File(uploadPath + "/user/" + "/" + fileNm);
		imgFile.renameTo(new File(targetFolder + "/" + newFileNm));
	}
}