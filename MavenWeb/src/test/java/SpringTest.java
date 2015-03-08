import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sen.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class SpringTest extends TestCase{
    @Autowired
    ApplicationContext ctx;
    
    @Test
    public void testSpring(){
    	ProductService ps =(ProductService) ctx.getBean("ps");
        try {
			assertNotNull(ps.queryProductByID(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
 
}