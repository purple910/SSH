package com.company.handler;

import com.company.entity.Student;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
* @Project springMVC-01
* @Package com.company.handler.SpringMVCHandler
* @ClassName SpringMVCHandler
* @Description TODO
* @date 2019年9月29日 下午6:24:15
* @author fate
 */
//@SessionAttributes(value = {"student4"})		//添加session的作用者
//@SessionAttributes(types = {Student.class})	//指定类型
@Controller
@RequestMapping("Handler")
public class SpringMVCHandler {

	/**
	 * value: 请求路径
	 * method: 请求方式
	 * params: 请求参数
	 * headers: 请求头信息
	 * @return
	 */
	@RequestMapping(value = "welcome", method = RequestMethod.PUT, params = {"name","name=zs","age!=18","!id"}, headers = {"Accept=text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8","Accept-Encoding=gzip, deflate"})
	public String welcome() {
		System.out.println("SpringMVCHandler.welcome:");
		return "success";
	}

	@RequestMapping(value = "welcome1")
	public String welcome1() {
		return "success";
	}

	@RequestMapping(value = "welcome2/*/aaa")
	public String welcome2() {
		return "success";
	}

	@RequestMapping(value = "welcome3/**/bbb")
	public String welcome3() {
		return "success";
	}

	@RequestMapping(value = "welcome4/a?c/ccc")
	public String welcome4() {
		return "success";
	}

	@RequestMapping(value = "welcome5/{name}")
	public String welcome5(@PathVariable("name") String name) {
		System.out.println("name = " + name);
		return "success";
	}




	@RequestMapping(value = "testPost/{id}")
	public String testPost(@PathVariable("id") Integer id) {
		System.out.println("SpringMVCHandler.testPost");
		System.out.println("id = " + id);
		return "success";
	}
	@RequestMapping(value = "testGet/{id}")
	public String testGet(@PathVariable("id") Integer id) {
		System.out.println("SpringMVCHandler.testGet");
		System.out.println("id = " + id);
		return "success";
	}
	@RequestMapping(value = "testPut/{id}")
	public String testPut(@PathVariable("id") Integer id) {
		System.out.println("SpringMVCHandler.testPut");
		System.out.println("id = " + id);
		return "redirect:/view/success.jsp";
	}
	@RequestMapping(value = "testDelete/{id}")
	public String testDelete(@PathVariable("id") Integer id) {
		System.out.println("SpringMVCHandler.testDelete");
		System.out.println("id = " + id);
		return "redirect:/view/success.jsp";
	}




	@RequestMapping(value = "testParam")
	public String testParam(@RequestParam("name") String name, @RequestParam(value = "age", required = false, defaultValue = "18") Integer age) {
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		return "success";
	}

	@RequestMapping(value = "testRequestHeader")
	public String testRequestHeader(@RequestHeader("Accept") String Accept) {
		System.out.println("Accept = " + Accept);
		return "success";
	}

	@RequestMapping(value = "testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String cookie) {
		System.out.println("cookie = " + cookie);
		return "success";
	}



	@RequestMapping(value = "testEntity")
	public String testEntity(Student student) {
		System.out.println("student = " + student);
		return "success";
	}


	@RequestMapping(value = "testServeltAPI")
	public String testServeltAPI(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println(name);
		return "success";
	}


	/**
	 * 视图解析器值解析ModelAndView
	 * @return
	 */
	@RequestMapping(value = "testModelAndView")
	public ModelAndView testModelAndView() {
		ModelAndView view = new ModelAndView("success");
		Student student = new Student();
		student.setId(1);
		student.setName("ls");
		student.setAge(18);
		view.addObject("student1",student);
		return view;
	}

	@RequestMapping(value = "testModelMap")
	public String  testModelMap(ModelMap modelMap) {
		Student student = new Student();
		student.setId(1);
		student.setName("ls");
		student.setAge(18);
		modelMap.put("student2",student);
		return "success";
	}

	@RequestMapping(value = "testMap")
	public String testMap(Map<String,Object> map) {
		Student student = new Student();
		student.setId(1);
		student.setName("ls");
		student.setAge(18);
		map.put("student3",student);
		return "success";
	}

	@RequestMapping(value = "testModel")
	public String testModel(Model model) {
		Student student = new Student();
		student.setId(1);
		student.setName("ls");
		student.setAge(18);
		model.addAttribute("student4",student);
		return "success";
	}


	/**
	 * 更新
	 * @param map
	 */
	//查询	在每次请求都会执行
	@ModelAttribute()
	public void queryStudentById(Map<String,Object> map,Student stu){
//		System.out.println(stu.getId());
		Student student = new Student();
		student.setId(1);
		student.setName("ls");
		student.setAge(18);
		map.put("student",student);		//key=student 	Student的首字母小写 (如果不一致可以用@ModelAttribute("student"))
	}
	//修改
	@RequestMapping(value = "testModelAttribute")
	public String testModelAttribute( Student student) {
		System.out.println(student);
		return "success";
	}

    @RequestMapping(value = "testI18n")
    public String testI18n( ) {
        return "success";
    }


    @RequestMapping(value = "testConverter")
    public String testConverter(@RequestParam("studentInfo") Student student) {
        System.out.println("student = " + student);
        return "success";
    }

	/**
	 * 无法实现错误
	 * @param student
	 * @param result
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "testFormatting")
	public String testFormatting(@Validated Student student , Errors  result, Map<String,Object> map) {
		System.out.println("student = " + student);
		System.out.println("result = " + result);
		//类似捕获异常
		if(result.getErrorCount()>0){
			for (FieldError error : result.getFieldErrors()){
				System.out.println("error = " + error.getDefaultMessage());
				map.put("error",error.getDefaultMessage());
			}
		}
		return "success";
	}


	@ResponseBody
	@RequestMapping(value = "testJson")
	public List<Student> testJson() {
		List<Student> list = new ArrayList<Student>();
		Student student = new Student();
		student.setId(1);
		student.setName("Salary");
		student.setAge(33);

		Student student1 = new Student();
		student1.setId(2);
		student1.setName("Tom");
		student1.setAge(18);

		list.add(student);
		list.add(student1);
		return list;
	}

	@RequestMapping(value = "testFileUpload")
	public String testFileUpload(@RequestParam("desc") String desc , @RequestParam("file") MultipartFile file) {
		System.out.println("desc = " + desc);
		try {
			InputStream inputStream = file.getInputStream();
			String filename = file.getOriginalFilename();
			FileOutputStream outputStream = new FileOutputStream("E:\\idea\\springMVC-02\\"+filename);
			byte[] bytes = new byte[1024];
			int len = -1;
			while ((len=inputStream.read(bytes))!=-1){
				outputStream.write(bytes,0,len);
			}
			outputStream.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}
}
