package com.pop.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	public static String uploadFile(String uploadPath,
									String originalName,
									byte[] fileData) throws Exception {
		UUID uid=UUID.randomUUID();
		String savedName=uid.toString()+"_"+originalName;
		// uploadPath : C:\\upload
		String savedPath=calcPath(uploadPath);
		File target = new File(uploadPath +savedPath,savedName);
		// FileCopyUtils.copy(in, out);
		FileCopyUtils.copy(fileData, target);
		
		System.out.println("uploadPath="+uploadPath);
		System.out.println("originalName="+originalName);
		System.out.println("target="+target);
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		System.out.println("formatName="+formatName);
		String uploadedFileName=null;
		if(MimeMediaUtil.getMediaType(formatName)!=null) {
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
		} else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		return uploadedFileName;
	}// uploadFile
	private static String calcPath(String uploadPath) {	// uploadPath : D:\\upload
		Calendar cal = Calendar.getInstance();
		System.out.println("cal="+cal);
		// /2020(yearPath)
		String yearPath=File.separator+cal.get(Calendar.YEAR);	
		// /2020/01(yearPath)
		String monthPath=yearPath+File.separator+new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		// /2020/01/07(datePath)
		String datePath=monthPath+File.separator+new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath,yearPath,monthPath,datePath);
		System.out.println(datePath);
		return datePath;
	}// calcPath
	private static void makeDir(String uploadPath, String...paths) {
		if(new File(paths[paths.length-1]).exists()) {
			return;
		}
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			
			if(! dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}// makeDir
	private static String makeThumbnail(String uploadPath,
										String path,
										String fileName) throws Exception {
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath+path,fileName));
		
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100);
		
		String thumbnailName = uploadPath + path + File.separator+"s_"+fileName;
		
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		ImageIO.write(destImg, formatName.toUpperCase(),newFile);
		return thumbnailName.substring(uploadPath.length()).replace(File.separator, "/");
	}
	private static String makeIcon(String uploadPath,
									String path,
									String fileName) throws Exception {
		String iconName = uploadPath + path + File.separator+fileName;
		return iconName.substring(uploadPath.length()).replace(File.separator, "/");
	}
}
