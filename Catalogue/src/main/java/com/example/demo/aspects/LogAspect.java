/**
 * 
 */
package com.example.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
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
	public void loggincat(JoinPoint jp)
	{
		
		System.out.println("add categorie ");
	}
	
	@After("execution (* com.example.demo.mities.IMetier.addcat(..))")
	public void logginaftercat2()
	{
		System.out.println("apres l'ajout  categorie ");
	}
	
	@AfterReturning(pointcut = "execution (* *.addcat(..))",returning = "res")
	public void logginaftercat3(JoinPoint jp, Object res)
	{
		System.out.println(jp.getSignature().getName());
		System.out.println(res.toString());
	}
}
