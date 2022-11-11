package com.davidedalsanto;

import com.davidedalsanto.models.ControlCenter;
import com.davidedalsanto.models.SmokeDetector;

import static org.junit.Assert.*;

public class TestSMokeDetectorTest {

    @org.junit.Test
    public void testSubscription() {
        ControlCenter cc = new ControlCenter();
        SmokeDetector sm1 = new SmokeDetector(1L, 22.7, 18.4, 0);
        sm1.addObserver(cc);

        //contains must return true
        assertTrue(sm1.getObservers().contains(cc));
    }

    @org.junit.Test
    public void testUnsubscription() {
        ControlCenter cc = new ControlCenter();

        SmokeDetector sm1 = new SmokeDetector(1L, 22.7, 18.4, 0);
        sm1.addObserver(cc);
        sm1.removeObserver(cc);

        //contains must return false
        assertFalse(sm1.getObservers().contains(cc));
    }

    @org.junit.Test
    public void fireDetectionLowSmoke() {
        ControlCenter cc = new ControlCenter();
        SmokeDetector sm1 = new SmokeDetector(1L, 22.7, 18.4, 0);
        sm1.addObserver(cc);
        sm1.setSmokeLevel(4);

        //expected detectFire() to return false
        assertFalse(sm1.detectFire());
    }

    @org.junit.Test
    public void fireDetectionHighSmoke() {
        ControlCenter cc = new ControlCenter();
        SmokeDetector sm1 = new SmokeDetector(1L, 22.7, 18.4, 0);
        sm1.addObserver(cc);
        sm1.setSmokeLevel(6);

        //expected detectFire() to return true
        assertTrue(sm1.detectFire());
    }
}