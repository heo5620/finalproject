package upload;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	//upload 폼 보여주기
	@GetMapping("/fileupload")
	String uploadForm(){
		return "upload/uploadform";
	}
	
	//file upload
	@PostMapping("/fileupload")
	ModelAndView uploadResult(@ModelAttribute("dto") UploadDTO dto) throws IOException{
		String savePath = UploadInform.uploadLocation; //파일을 저장할 곳
		//ncp서버 리눅스 /usr/mydir/upload 디렉토리 (파일 업로드 디렉토리로 설정)
		//a.txt -> a.UUID.randomUUID().txt
		
		MultipartFile file1 = dto.getFile1();
		String newFileName1 = null;
		
		if (!file1.isEmpty()) { //file1이 있다면
			String originalFileName1 = file1.getOriginalFilename(); //파일 이름
			String beforeExt1 = originalFileName1.substring(0, originalFileName1.indexOf(".")); //확장자 앞쪽. a.txt -> a
			String ext1 = originalFileName1.substring(originalFileName1.indexOf(".")); //확장자 앞쪽. a.txt -> .txt
			newFileName1 = beforeExt1 + "(" + UUID.randomUUID().toString() + ")" + ext1;
			file1.transferTo(new File(savePath + newFileName1)); //서버에 파일 저장. 서버 내부 저장 파일명
		}
		
		MultipartFile file2 = dto.getFile2();
		String newFileName2 = null;
		
		if (!file2.isEmpty()) { //file2이 있다면
			String originalFileName2 = file2.getOriginalFilename();
			String beforeExt2 = originalFileName2.substring(0, originalFileName2.indexOf(".")); //확장자 앞쪽. a.txt -> a
			String ext2 = originalFileName2.substring(originalFileName2.indexOf(".")); //확장자 뒤쪽. a.txt -> .txt
			newFileName2 = beforeExt2 + "(" + UUID.randomUUID().toString() + ")" + ext2;
			file2.transferTo(new File(savePath + newFileName2)); //서버에 파일 저장. 서버 내부 저장 파일명
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("uploadresult1", savePath + newFileName1);
		mv.addObject("uploadresult2", savePath + newFileName2);
		mv.setViewName("upload/uploadresult");
		return mv;
	}
}
