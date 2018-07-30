package com.seed;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.seed.bean.User;

@Controller
public class HelloWorldController {
	//@RequestMapping("/hello")
	private static final String UPLOAD_DIRECTORY ="/images";
	

	public ModelAndView helloworld(User user ) {
		// System.out.println(user.getUsername());
	//	System.out.println("inside controller");
		//String message = "Hello jayendra welcome to spring";
		String msg=null;
		String uname=user.getUsername();
		String pass=user.getPassword();
		User u = null;
		System.out.println(uname+" "+pass);
		SessionFactory factory=null;
		Session session=null;
		
		factory=new Configuration().configure().buildSessionFactory();
		session=factory.openSession();
		
		Query query=session.createQuery("from User where username=:u and password=:pd");
		query.setParameter("u", uname);
		query.setParameter("pd",pass);
          
		List list=query.list();
		
        Iterator iterator=list.iterator();
		
		while (iterator.hasNext()) {
			 u=(User) iterator.next();
			 System.out.println(u.toString());
			 
		}
        String usr=u.getUsername();
        String pas=u.getPassword();
        System.out.println(usr+" "+pas);
		
		
		if(u.getUsername().equals(uname)&&(u.getPassword().equals(pass))){
			msg="valid user";
		}
		else {
			msg="not a valid user";
		}
		return new ModelAndView("hellopage", "msg", msg);

	}
	
	@RequestMapping(value="savefile",method=RequestMethod.POST)  
    public ModelAndView saveimage( @RequestParam CommonsMultipartFile file,  
           HttpSession session) throws Exception{  
   
    ServletContext context = session.getServletContext();  
    String path = context.getRealPath(UPLOAD_DIRECTORY);  
    String filename = file.getOriginalFilename();  
  
    System.out.println(path+" "+filename);        
  
    byte[] bytes = file.getBytes();   
    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
         new File(path + File.separator + filename)));  
    stream.write(bytes);  
    stream.flush();  
    stream.close();  
            
    return new ModelAndView("uploadform","filesuccess","File successfully saved!");  
    }  
	 
	 

}
