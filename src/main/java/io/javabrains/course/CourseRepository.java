package io.javabrains.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//First Entity Class and secong type of ID
public interface CourseRepository extends CrudRepository<Course,String>{
	public List<Course> findByTopicId(String topicid);

}
