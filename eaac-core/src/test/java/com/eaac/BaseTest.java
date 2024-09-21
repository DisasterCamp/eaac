package com.eaac;

import com.eaac.config.EcConfiguration;
import com.eaac.pipe.LogDataHandler;
import com.eaac.pipe.LogDataHandler2;
import com.eaac.pipe.TransformDataHandler;
import com.eaac.pipe.TransformDataHandler2;
import org.junit.Before;

public class BaseTest {
    protected EcConfiguration ecConfiguration;

    @Before
    public void setUp() throws Exception {
        this.ecConfiguration = new EcConfiguration(new String[]{"http"});
        ecConfiguration.addIn(new TransformDataHandler());
        ecConfiguration.addIn(new TransformDataHandler2());
        ecConfiguration.addOut(new LogDataHandler());
        ecConfiguration.addOut(new LogDataHandler2());
    }
}
