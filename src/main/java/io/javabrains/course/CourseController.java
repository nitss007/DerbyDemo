package io.javabrains.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.topic.Topic;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;

	@RequestMapping("/topic/{id}/course")
	protected List<Course> getAllTopic(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}

	@RequestMapping("/topic/{id}/course/{cid}")
	protected Course getTopic(@PathVariable String cid) {
		return courseService.getCourse(cid);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topic/{id}/course")
	protected void addTopic(@PathVariable String id,@RequestBody Course course) {
		course.setTopic(new Topic(id, "", ""));
		courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topic/{topicid}/course/{id}")
	protected void updateTopic(@RequestBody Course course, @PathVariable String id, @PathVariable String topicid) {
		course.setTopic(new Topic(topicid, "", ""));
		courseService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE,value="/topic/{topicid}/course/{id}")
	protected void deleteTopic(@PathVariable String id) {
		courseService.deleteCourse(id);

	}
}
