package com.myspring.pro30.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Buffer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FiledownloadController {
	private static final String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
	
	@RequestMapping("/download.do")
	protected void download(@RequestParam("imageFileName") String imageFileName,
							@RequestParam("articleNO") String articleNO, HttpServletResponse response) throws Exception{
		OutputStream out = response.getOutputStream();
		String downFile = ARTICLE_IMAGE_REPO + "//"+articleNO +"//"+ imageFileName;
		File file = new File(downFile);
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName="+imageFileName);
		FileInputStream in = new FileInputStream(file);
		
		while(true) {
			byte[] buffer = new byte[8*1024];
			int i = in.read(buffer);
			if(i == -1) break;
			out.write(buffer, 0, i);
		}
		
		in.close();
		out.close();
	}
}
