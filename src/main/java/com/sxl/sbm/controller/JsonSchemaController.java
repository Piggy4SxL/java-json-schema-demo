package com.sxl.sbm.controller;

import org.everit.json.schema.ReadWriteContext;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.Validator;
import org.everit.json.schema.loader.SchemaLoader;
import org.everit.json.schema.regexp.RE2JRegexpFactory;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SxL
 * Created on 6/20/2018 12:51 PM.
 */
@Controller
public class JsonSchemaController {

    /**
     * json-schema测试
     * 获取前端传过来的json串并在验证后返回结果
     * @param json json串
     * @return 验证结果
     */
    @PostMapping("/jsonschematest")
    @ResponseBody
    private Map<String, Object> jsonSchemaTest(@RequestBody String json){
        Map<String, Object> modelMap = new HashMap<>(16);
        //json格式错误存储容器
        List<String> errorList = new ArrayList<>();

        //获取resources目录下的schema.json文件
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("schema.json")) {
            JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
            //默认级别
///           Schema schema = SchemaLoader.load(rawSchema);
            //开启default、regex
            Schema schema = SchemaLoader.builder()
                    .useDefaults(true)
                    .regexpFactory(new RE2JRegexpFactory())
                    .schemaJson(rawSchema)
///                    .addFormatValidator("evenLength", new EvenCharNumValidation())
                    .build()
                    .load().build();
            //默认检测完全部json
///            schema.validate(new JSONObject(json));

            //failEarly() 当发现一次格式错误时停止检测
            //readWriteContext() id属性是否为ReadOnly (schema.json文件中id的readOnly是否为true)
            Validator validator = Validator.builder()
//                    .failEarly()
                    .readWriteContext(ReadWriteContext.READ)
                    .build();
            validator.performValidation(schema, new JSONObject(json));

            modelMap.put("success", true);
        } catch (ValidationException e) {
            //如果产生多个异常将遍历causingException并将每个ValidationException的message信息存储起来
            e.getCausingExceptions().stream()
                    .map(ValidationException::getMessage)
                    .forEach(errorList::add);

            modelMap.put("success", false);

            if (errorList.size() > 0) {
                modelMap.put("error", errorList.toString());
            } else {
                modelMap.put("error", e.getMessage());
            }
        } catch (IOException e) {
            modelMap.put("success", false);
            modelMap.put("error", e.getMessage());
        }

        return modelMap;
    }
}
