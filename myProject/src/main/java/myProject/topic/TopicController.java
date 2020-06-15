package myProject.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAlltopics()
	{
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopics(@PathVariable String id){
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/topics" )
	@ResponseBody
	public ResponseEntity <String> addTopic(@RequestBody Topic topic) {
		boolean retVal = topicService.addTopic(topic);
		String responseBody = null;
		if(retVal) {
			responseBody = topic.getName() + " is added";
			return ResponseEntity.status(HttpStatus.OK).body(responseBody);
		}else {
			responseBody = topic.getName() + " already added";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
		}
		
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/topics/{id}" )
	@ResponseBody
	public ResponseEntity<String>  updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		boolean retVal = topicService.updateTopic(id, topic);
		String responseBody = null;
		if(retVal) {
			responseBody = id + ": Course is updated";
			return ResponseEntity.status(HttpStatus.OK).body(responseBody);
		}else {
			responseBody = id + ": no such Course";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
		}
			
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/topics/{id}")
	public ResponseEntity<String> deteteTopics(@PathVariable String id){
		 boolean retVal = topicService.deleteTopic(id);
		 String responseBody = null;
		 if(retVal) {
			 responseBody = id + ": Course is deleted";
		     return ResponseEntity.status(HttpStatus.OK).body(responseBody);
		 }else {
			 responseBody = id + ": no such Course";
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
		 }    
		 
		
	}
}
