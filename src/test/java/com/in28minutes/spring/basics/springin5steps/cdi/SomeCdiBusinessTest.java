package com.in28minutes.spring.basics.springin5steps.cdi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * The main advantages of using Mocking is very easy to create multiple scenario
 */

@RunWith(MockitoJUnitRunner.class)
public class SomeCdiBusinessTest {

    @InjectMocks
    SomeCdiBusiness business;

    @Mock
    SomeCdiDao someCdiDao;

    @Test
    public void testBasicScenario(){
        when(someCdiDao.getData()).thenReturn(new int[] {2,4,8});
        assertEquals(8, business.findTheGreatestData());
    }

    @Test
    public void testBasicScenario_wintNoElements(){
        when(someCdiDao.getData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, business.findTheGreatestData());
    }

}