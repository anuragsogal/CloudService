package com.anurag.videosvc;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/anurag")
public class VideoController {
	@RequestMapping(method=RequestMethod.GET, value="/videoService",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String testMethod(){
		System.out.println("{\"description\":\"Hello\"}");
		return "{\"description\":\"Hello\"}";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/postData",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity postData(@RequestHeader("Accept-Encoding") String encoding,@RequestBody Credentials cred){
		System.out.println("The encoding is "+encoding);
		System.out.println("The username is "+cred.getUsername());
		System.out.println("The password is "+cred.getPassword());
		//HttpHeaders headers = new HttpHeaders();
        //headers.add("Access-Control-Allow-Origin", "*");
        //headers.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        ResponseEntity entity = new ResponseEntity(HttpStatus.CREATED);
        return entity;
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/videoServiceUpload")
	public boolean upLoadVideo(@RequestParam("file") MultipartFile fileToUpload){
		System.out.println(fileToUpload.getContentType());
		System.out.println("Inside the upLoadVideo");
		return false;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/videoServiceDownload")
	@ResponseBody
	public  byte[]  getVideo(){
		File fileIs=null;
		System.out.println("Inside the downloadVideo");
		fileIs = new File("/Users/anuragsogal/Desktop/Rome Videos/DSC_0322.JPG");
		InputStream fileip=null;
		byte[] filebyte=null;
		try {
			filebyte = FileUtils.readFileToByteArray(fileIs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filebyte;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/videoServiceDownloadEntity")
	public  ResponseEntity<byte[]>  getVideoEntity(){
		File fileIs=null;
		System.out.println("Inside the downloadVideo");
		//fileIs = new File("/Users/anuragsogal/Desktop/Rome Videos/DSC_0322.JPG");
		fileIs= new File("/Users/anuragsogal/Desktop/DSC_0341.mp4.mp4");
		InputStream fileip=null;
		byte[] filebyte=null;
		try {
			filebyte = FileUtils.readFileToByteArray(fileIs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("content-type","video/x-mpeg");
		
		return new ResponseEntity<byte[]>(filebyte,responseHeaders,HttpStatus.OK);
	}

}
