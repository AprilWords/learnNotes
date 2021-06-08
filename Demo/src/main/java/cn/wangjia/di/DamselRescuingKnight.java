package cn.wangjia.di;

import java.sql.DatabaseMetaData;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/2
 */
//damsel 少女 姑娘
public class DamselRescuingKnight implements Knight {

    private  RecuseDamselQuest quest;
    public DamselRescuingKnight(){

        this.quest = new RecuseDamselQuest();
    }

    public void embarkOnquest() {
            quest.embark();
    }

    public static void main(String[] args) {
        DamselRescuingKnight knight = new DamselRescuingKnight();
        knight.embarkOnquest();



    }
}
