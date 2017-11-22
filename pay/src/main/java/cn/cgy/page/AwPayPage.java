package cn.cgy.page;

import cn.cgy.pojo.AwPay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allenwish on 2017-11-21.
 */
public class AwPayPage {
    private List<AwPay> awPayList = new ArrayList<>();;

    public List<AwPay> getAwPayList() {
        return awPayList;
    }

    public void setAwPayList(List<AwPay> awPayList) {
        this.awPayList = awPayList;
    }
}
