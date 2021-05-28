package com.koreait.board7.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyFileUtils;
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
		String uploadPath = request.getServletContext().getRealPath("/res/img");
		int maxFileSize = 10_485_860; // 10 * 1024 * 1024(10MB)
		System.out.println("uploadPath : " + uploadPath);
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath + "/temp", maxFileSize,
					"UTF-8", new DefaultFileRenamePolicy()); // 중복된 파일명에 대한 처리 기능(파일명에 1을 덧붙임)
			// 업로드가 완료된 파일명
			String fileNm = multi.getFilesystemName("profileImg");
			System.out.println("fileNm" + fileNm);
			if(fileNm == null) {
				doGet(request,response); // doGet은 1번 이상 실행되면 에러난다
				return;
			}
			
			UserEntity loginUser = MyUtils.getLoginUser(request);
			int loginUserPk = loginUser.getIuser();
			
			String targetFolder = uploadPath + "/user/" + loginUserPk;
			MyFileUtils.delFolder(targetFolder); // 이미지를 변경 후 기존 이미지를 삭제 후, 폴더까지 삭제하는 메소드
			
			File folder = new File(targetFolder);
			//		folder.delete(); // 만약 폴더 안에 파일이 있으면 지워지지 않음.
			
			folder.mkdirs();
			
			
			int lastDotIdx = fileNm.lastIndexOf("."); 
			// 파일의 맨 오른쪽부터 .을 찾고 .을 기준으로 확장자를 찾는 기능
			String ext = fileNm.substring(lastDotIdx); 
			// +1 을 주지 않으면 .jpg의 .까지 포함되어 버린다. 
			
			String newFileNm = UUID.randomUUID().toString() + ext; 
			// 원래 return타입은 UUID
			
			File imgFile = new File(uploadPath + "/temp/" + fileNm);
			imgFile.renameTo(new File(targetFolder + "/" + newFileNm));
			
			UserEntity param = new UserEntity();
			param.setIuser(loginUserPk);
			param.setProfileImg(newFileNm);
			
			UserDAO.updUser(param);
			
			loginUser.setProfileImg(newFileNm); // 세션에도 값 넣기
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request,response);
	}
}