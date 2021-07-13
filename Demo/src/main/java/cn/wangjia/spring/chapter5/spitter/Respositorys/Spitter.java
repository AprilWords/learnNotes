package cn.wangjia.spring.chapter5.spitter.Respositorys;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/28
 */
public class Spitter {
    @NonNull
    @Size(min = 2,max = 30)
    private String firstNmae;
    @NonNull
    @Size(min = 2,max = 30)
    private String lastName;
    @NonNull
    @Size(min = 2,max = 30)
    private String useNamme;
    @NonNull
    @Size(min = 2,max = 30)
    private String passWord;

    public String getFirstNmae() {
        return firstNmae;
    }

    public void setFirstNmae(String firstNmae) {
        this.firstNmae = firstNmae;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUseNamme() {
        return useNamme;
    }

    public void setUseNamme(String useNamme) {
        this.useNamme = useNamme;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


}
