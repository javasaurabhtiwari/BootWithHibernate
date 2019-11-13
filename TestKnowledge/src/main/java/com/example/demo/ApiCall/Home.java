package com.example.demo.ApiCall;

import java.util.List;

import javax.ws.rs.Produces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;

@RestController
@Produces("application/json")
public class Home {
	
	SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
	
	@RequestMapping("/find/{id}")
	public void findById(@PathVariable("id") Integer id)
	{
			Session session=sessionfactory.openSession();
			Student student=new Student();
			student=(Student)session.get(Student.class,id);
			session.beginTransaction().commit();
		    session.close();
		    sessionfactory.close();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") Integer id)
	{
			Session session=sessionfactory.openSession();
			Student student=new Student();
			student=(Student)session.get(Student.class,id);
			session.delete(student);
			session.beginTransaction().commit();
		    session.close();
		    sessionfactory.close();
	}
	
	@GetMapping("/findAll")
	public List<Student> findAll()
	{
		    Session session=sessionfactory.openSession();
			Student student=new Student();
			List<Student> list=session.createQuery("from Student").list();
			session.beginTransaction().commit();
		    session.close();
		    sessionfactory.close();
		    return list;
		} 
		
	@GetMapping("/total")
	public Integer totalCount()
	{
		Session session=sessionfactory.openSession();
		List<Student> list=session.createQuery("from Student").list();
		return list.size();
	}
	
	@PostMapping("/save/{id}/{name}")
	public void saveStudent(@PathVariable("id") Integer id,@PathVariable("name") String name)
	{
			Session session=sessionfactory.openSession();
			Student student=new Student();
			student.setId(id);
			student.setName(name);
			session.save(student);
			session.beginTransaction().commit();
		    session.close();
		    sessionfactory.close();
	}
	
	@PutMapping("/update/{id}/{name}")
	public void update(@PathVariable("id") Integer id,@PathVariable("name") String name)
	{
		Session session=sessionfactory.openSession();
		Student student=new Student();
		student=(Student)session.get(Student.class,id);
		student.setName(name);
		student.setId(id);
		student.setName(name);
		session.save(student);
		session.beginTransaction().commit();
	}
}
