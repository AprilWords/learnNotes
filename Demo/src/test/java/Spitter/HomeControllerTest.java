package Spitter;

import cn.wangjia.spring.chapter5.spitter.controller.HomeController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/22
 */
public class HomeControllerTest {
    private WebApplicationContext webApplicationContext;
    @Test
    public void testHomePage() throws Exception {

           HomeController controller = new HomeController();

            //MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
            // setSingleView(new InternalResourceView("/WEB-INF/views/home.jsp"))
            MockMvc mocKMvc = standaloneSetup(controller).build();
            mocKMvc.perform(get("/")).andExpect(view().name("home"));

            assertEquals("home",controller.home());
    }
}
