package io.relayr;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class RelayrSdk_InMockMode_Test {

    @Before public void initInMockMode() {
        RelayrSdk.initInMockMode(Robolectric.application);
    }

    @Test public void getRelayrBleSdk_testStaticInjection() {
        Assert.assertNotNull(RelayrSdk.getRelayrBleSdk());
    }

    @Test public void getRelayrApi_testStaticInjection() {
        Assert.assertNotNull(RelayrSdk.getRelayrApi());
    }

    @Test public void getWebSocketClient_testStaticInjection() {
        Assert.assertNotNull(RelayrSdk.getWebSocketClient());
    }

    @Test public void isBleSupported_shouldBeTrue() {
        Assert.assertTrue(RelayrSdk.isBleSupported());
    }

    @After public void resetRelayrSdk() {
        RelayrSdk.reset();
    }

}
