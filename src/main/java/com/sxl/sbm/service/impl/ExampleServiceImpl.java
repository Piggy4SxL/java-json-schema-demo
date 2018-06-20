package com.sxl.sbm.service.impl;

import com.sxl.sbm.dto.ExampleExection;
import com.sxl.sbm.entity.Example;
import com.sxl.sbm.exception.ExampleOperatorException;
import com.sxl.sbm.service.ExampleService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author SxL
 * Created on 6/6/2018 18:55.
 */
public class ExampleServiceImpl implements ExampleService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ExampleExection saveExample(Example example) throws ExampleOperatorException {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ExampleExection updateExample(Example example) throws ExampleOperatorException {
        return null;
    }

    @Override
    public Example getExampleById(int exampleId) {
        return null;
    }


    @Override
    public List<Example> listExample(Example exampleCondition) {
        return null;
    }
}
