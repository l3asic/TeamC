package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommonService {
	
	
	// 파일 업로드 처리
	public String fileupload(String category, MultipartFile file,
			HttpSession session) {
		String resources = session.getServletContext().getRealPath("resources");
	// D:\Study_Spring\Workspace\.metadata\.plugins\org.eclipse.wst.server.core
	//			\tmp0\wtpwebapps\iot\resources			
		String folder = resources + "/upload" + category + "/"
				+ new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	// /upload/notice/2022/01/07/00000000000saasf_123.png	
		
		String uuid = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		
		File dir = new File (folder);
		if (! dir.exists() ) dir.mkdirs();
			try {
				file.transferTo(new File(folder, uuid));
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return folder.substring(resources.length() + 1) + "/" + uuid;
	}
	
	
	// 접근 토근을 이용하여 프로필 API 호출하기 위하여 (access_token과 token_type 값을 파라미터로 전달)
		public String requestAPI(StringBuffer url, String property) {
			String result = "";
			try {
				// URL url = new URL(apiURL);
			    // HttpURLConnection con = (HttpURLConnection)url.openConnection();
				HttpURLConnection con = (HttpURLConnection) new URL(url.toString()).openConnection();
				// 전달받은 url을 지정
				con.setRequestMethod("GET");

				con.setRequestProperty("Authorization", property);
				int responseCode = con.getResponseCode();
				
				// 여러 가지 정보를 읽어 들이는데 버퍼를 통해 읽어 들이기 위해 BufferedReader 를 사용
				BufferedReader br;
				System.out.print("responseCode=" + responseCode);
				if (responseCode == 200) { // 정상 호출
					br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8")); // 한글 깨짐 처리
				} else { // 에러 발생
					br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
				}
				String inputLine;
				StringBuffer res = new StringBuffer();	// 실제 값이 담겨진 변수 res 값을 리턴하여 보내줌
				while ((inputLine = br.readLine()) != null) {
					res.append(inputLine);
				}
				br.close();					// BufferReader 닫기
				con.disconnect(); 			// HTTP 통신 연결 종료
				result = res.toString();	// 요청한 결과(res)를 result 에 담아 리턴 
			} catch (Exception e) {
				System.out.println(e);
			}
			return result;
		}
		
		public String requstAPI(StringBuffer url) {
			String result = "";
			try {
				// URL url = new URL(apiURL);
			    // HttpURLConnection con = (HttpURLConnection)url.openConnection();
				HttpURLConnection con = (HttpURLConnection) new URL(url.toString()).openConnection();
				// 전달받은 url을 지정
				con.setRequestMethod("GET");
				int responseCode = con.getResponseCode();
				
				// 여러 가지 정보를 읽어 들이는데 버퍼를 통해 읽어 들이기 위해 BufferedReader 를 사용
				BufferedReader br;
				System.out.print("responseCode=" + responseCode);
				if (responseCode == 200) { // 정상 호출
					br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8")); // 한글 깨짐 처리
				} else { // 에러 발생
					br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
				}
				String inputLine;
				StringBuffer res = new StringBuffer();	// 실제 값이 담겨진 변수 res 값을 리턴하여 보내줌
				while ((inputLine = br.readLine()) != null) {
					res.append(inputLine);
				}
				br.close();					// BufferReader 닫기
				con.disconnect(); 			// HTTP 통신 연결 종료
				result = res.toString();	// 요청한 결과(res)를 result 에 담아 리턴 
			} catch (Exception e) {
				System.out.println(e);
			}
			return result;
		}
	
}








