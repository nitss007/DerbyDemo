package io.javabrains.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	/*private List<Course> courses= new ArrayList<>(Arrays.asList(
			new Course("spring","SpringFramework","Its an awesome huge framework"),
			new Course("springBoot","Ultimate SpringFramework","Makes life easy"),
			new Course("angular","GoodFramework","Two way binding is good")
			));*/
	
	public List<Course> getAllCourses(String topicid){
		//return Courses;
		List<Course>courses=new ArrayList<>();
		courseRepository.findByTopicId(topicid).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id){
		//return Courses.stream().filter(t->t.getId().equals(id)).findFirst().get();
		return courseRepository.findOne(id);
	}
	public void addCourse( Course course){
		//Courses.add(Course);
		courseRepository.save(course);
		
	}
	
	public void updateCourse(Course course){
		/*for(int i=0;i<Courses.size();i++){
			Course t=Courses.get(i);
			if(t.getId().equals(id)){
				Courses.set(i, Course);
				return;
			}
		}*/
		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		//Courses.removeIf(t->t.getId().equals(id));
		courseRepository.delete(id);
	}
	
}
