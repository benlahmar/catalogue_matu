/**
 * 
 */
package com.example.demo.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Categorie;

/**
 * @author moi
 *
 */
@Aspect
@Service
public class LogAspect {

	
	@Before("execution (* *.addcat(..))")
	public void loggincat()
	{
		
		System.out.println("add categorie ");
	}
	
	@After("execution (* *.addcat(..))")
	public void logginaftercat()
	{
		System.out.println("apres l'ajout  categorie ");
	}
}
