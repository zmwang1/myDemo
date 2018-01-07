package edu.jyu.stumgmTest.EntityTest;

import edu.jyu.stumgm.entity.*;

import junit.framework.TestCase;

public class testStudent extends TestCase {
	public void setUp() throws Exception {
    }

    public void tearDown() throws Exception {
    }
    
    public void testgetGrade()
    {
    	Student s = new Student();
    	Grade g = new Grade(s, 0, 0, 0, 0, 0, 0, 0, 0);
    	s.getGrade();
    	assertEquals(s.getGrade().getId(), g.getId());
    	assertEquals(s.getGrade().getId(), g.getId());
    }
    
    public void testgetIdentityId()
    {
    	Student s = new Student();
    	s.setStuNumber("77262");
    	
    	assertEquals(s.getStuNumber(), "77262");
    }
}
