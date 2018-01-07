package edu.jyu.stumgmTest.EntityTest;

import edu.jyu.stumgm.entity.*;

import junit.framework.TestCase;

public class testCourse extends TestCase {
	
    

    
    public void testgetCourseId()
    {
    	Course c = new Course();
    	c.setCourseId("112233");
    	
    	assertEquals(c.getCourseId(), "112233");
    }
    
    public void testgetCourseName() {
    	Course c = new Course();
    	c.setCourseName("php");
    	assertEquals(c.getCourseName(), "php");
    }
}
