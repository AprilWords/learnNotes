package Spitter;

import cn.wangjia.spring.chapter5.spitter.Respositorys.Spittle;
import cn.wangjia.spring.chapter5.spitter.Respositorys.SpittleRespository;
import cn.wangjia.spring.chapter5.spitter.controller.SpittleController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/24
 */
public class SpittleControllerTest {


    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectSpittles = createSpittleList(20);
        SpittleRespository respositoryMock = mock(SpittleRespository.class);
        when(respositoryMock.findSpittles(Long.MAX_VALUE,20))
                        .thenReturn(expectSpittles);

        SpittleController spittleController = new SpittleController(respositoryMock);


        MockMvc mockMvc = standaloneSetup(spittleController)
                    .setSingleView(new InternalResourceView("/WEB-INF/views/home.jsp")).build();

        mockMvc.perform(get("/spittles")).andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",hasItems(expectSpittles.toArray()));

    }
    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles = new ArrayList<Spittle>();
        for(int i = 0; i < count; i++){
            spittles.add(new Spittle("Spittle",new Date() ));
        }
        return spittles;
    }
}
