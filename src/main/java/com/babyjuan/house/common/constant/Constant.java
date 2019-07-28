package com.babyjuan.house.common.constant;

import java.math.BigDecimal;
import java.util.Date;
import org.joda.time.DateTime;

/**
 * @Author: hjg
 * @Date: Create in 2018/7/15 12:43
 * @Description:
 */
public class Constant {

    public static final Date LONG_LONG_AGO = DateTime.parse("1000-01-01").toDate();

    public static final BigDecimal TEN_THOUSAND = new BigDecimal(10_000);
}
