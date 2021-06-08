package cn.wangjia.di;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/2
 */
public class BraveKnight implements Knight {
    private Quest quest;
    public BraveKnight(Quest quest){
        this.quest = quest;
    }
    public void embarkOnquest() {
        quest.embark();
    }
}
