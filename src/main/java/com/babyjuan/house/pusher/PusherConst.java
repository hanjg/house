package com.babyjuan.house.pusher;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: hjg
 * @Date: Create in 2018/12/12 15:34
 * @Description:
 */
@Component
public class PusherConst {

    @Value("#{'${pusher.communities}'.split(',')}")
    private List<String> pushedCommunities;

    public List<String> getPushedCommunities() {
        return pushedCommunities;
    }

    public void setPushedCommunities(List<String> pushedCommunities) {
        this.pushedCommunities = pushedCommunities;
    }
}
