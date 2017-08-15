/**
 * 
 */
package edu.scu.dreamTour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Admin
 *
 */
@RestController
public class HelloController {

	@Autowired
	private GirlProperties girlProperties;
	
	@Value("${boy}")
	private String boy;
	
	@RequestMapping(value = {"/hello", "/hi"},method = RequestMethod.GET)
	public String say() {
		return "Hello Spring boot" + girlProperties.getAge() + boy;
	}
}
