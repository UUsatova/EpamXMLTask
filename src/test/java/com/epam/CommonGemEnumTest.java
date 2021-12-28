package com.epam;

import static org.junit.Assert.assertEquals;

import com.epam.init.CommonGemEnum;

import org.junit.Test;

public class CommonGemEnumTest {

    @Test
    public void getValueTestShouldCompareStringAndValueOfEnumElement(){
        assertEquals(CommonGemEnum.GEM.getValue(),"Gem");
        
    }

  
}
