import cn.wangjia.di.BraveKnight;
import cn.wangjia.di.Quest;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;


/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/2
 */
public class KnightTest {
    @Test
    public void knightShouldEmbarOnquest(){
        Quest mockQuest = mock(Quest.class);
        BraveKnight braveKnight = new BraveKnight(mockQuest);
        braveKnight.embarkOnquest();
        verify(mockQuest,times(1)).embark();



    }





}
