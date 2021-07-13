package Spitter;

import cn.wangjia.spring.chapter5.spitter.Respositorys.Spittle;
import cn.wangjia.spring.chapter5.spitter.Respositorys.SpittleRespository;
import cn.wangjia.spring.chapter5.spitter.controller.SpittleController;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
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
                    .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
        ResultActions resultActions = mockMvc.perform(get("/spittles"));
        Matcher<Iterable<Object>> x = hasItems(expectSpittles.toArray());
        resultActions.andExpect(model().attribute("spittleList",x));
        mockMvc.perform(get("/spittles")).andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",hasItems(expectSpittles.toArray())));

    }
    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles = new ArrayList<Spittle>();
        for(int i = 0; i < count; i++){
            spittles.add(new Spittle("Spittle",new Date() ));
        }
        return spittles;
    }
    @Test
    public void shouldShowRecentSpittlesOne() throws Exception {
        List<Spittle> expectSpittles = createSpittleList(50);
        SpittleRespository respositoryMock = mock(SpittleRespository.class);
        when(respositoryMock.findSpittles(238900,50))
                .thenReturn(expectSpittles);

        SpittleController spittleController = new SpittleController(respositoryMock);


        MockMvc mockMvc = standaloneSetup(spittleController)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
      /*  ResultActions resultActions = mockMvc.perform(get("/spittles?max=238900L&count=50"));
        Matcher<Iterable<Object>> x = hasItems(expectSpittles.toArray());
        resultActions.andExpect(model().attribute("spittleList",x));*/
        mockMvc.perform(get("/spittles?max=238900&count=50")).andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",hasItems(expectSpittles.toArray())));

    }
    @Test
    public void getOne() throws Exception {

        Spittle expectedSpittle = new Spittle("hello",new Date());
        SpittleRespository spittleRespository = mock(SpittleRespository.class);
        when(spittleRespository.findOne(12345)).thenReturn(expectedSpittle);

        SpittleController controller = new SpittleController(spittleRespository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/spittles/12345"))
                    .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle",expectedSpittle));






    }
}
