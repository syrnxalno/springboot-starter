package com.syrnxalno.demo.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import java.util.Map;


@Controller
public class DemoController {
   @RequestMapping(value="/index.html", method=RequestMethod.GET)
   @ResponseBody
   public String index() {
       return "First Return CheckPoint";
   }

   @RequestMapping(value="/home", method=RequestMethod.GET)
   public String home() {
       return "home";
   }
    
   @RequestMapping(value="/api/data", method=RequestMethod.GET)
   @ResponseBody
   public Map<String,String> getData() {
    Map<String, String> data = new HashMap<>();
    data.put("message", "Hello User!");
    data.put("status", "success");
       return data;
   }

   @RequestMapping(value="/api/post", method=RequestMethod.POST)
   @ResponseBody
   public Map<String,String> postData(@RequestBody Map<String, String> request) {
    String receivedParam = request.get("param").toString();
    Map<String, String> response = new HashMap<>();
    response.put("status", "success");
    response.put("message", "Received: " + receivedParam);

    return response; 
   }
   
   @RequestMapping(value="/api/system-info", method=RequestMethod.GET)
   @ResponseBody
   public ResponseEntity<Map<String,Object>> systemInfo() {
    Runtime rt = Runtime.getRuntime();
    Map<String, Object> info = new HashMap<>();
        info.put("Available Processors", rt.availableProcessors());
        info.put("Free Memory (in bytes)", rt.freeMemory());
        info.put("Total Memory (in bytes)", rt.totalMemory());
        info.put("Maximum Memory (in bytes)", rt.maxMemory()); 
        info.put("OS architecture", System.getProperty("os.arch"));
        info.put("Username",System.getProperty("user.name"));
        info.put("Java Version", System.getProperty("java.version"));
       return ResponseEntity.ok(info);
   }
   
   
}
