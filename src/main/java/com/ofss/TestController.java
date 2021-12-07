package com.ofss;

import com.ofss.model.pojo;
import com.ofss.service.droolservice;
import com.ofss.model.Rules;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;



@RestController
public class TestController {

    @Resource
    @Autowired
    droolservice rules;
   
    @PostMapping("/detail")
	public String orderNow() {
    	pojo p1=new pojo();
    	p1.setDevice("5678");
    	KieSession kieSession = droolservice.kieContainer.newKieSession();
		kieSession.insert(p1);
		kieSession.fireAllRules();
		System.out.println(p1.getMsg());
		return p1.getMsg();
    }
   
    @ResponseBody
    @RequestMapping("/reload")
    public String reload() throws IOException {
        rules.reload();
        return "ok";
    }
    @ResponseBody
    @RequestMapping(value="/rules", method=RequestMethod.GET)
	public List<Rules> m2()
	{
		return rules.getAllRules();
	}

    @RequestMapping(value="/addrule", method=RequestMethod.POST)
	public String m1(@RequestBody Rules rule)
	{
		return rules.addrule(rule);
	}
    
    @RequestMapping(value="/updaterule/{id}", method=RequestMethod.PUT)
	public String m3(@RequestBody Rules rule,@PathVariable("id") Long id )
	{
		return rules.updateCustomer(id,rule);
	}
    @RequestMapping(value="/deleterule/{id}", method=RequestMethod.DELETE)
	public String m4(@PathVariable("id") Long id )
	{
		return rules.deleterule(id);
	}

}

