package myProject.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	
	private List<Topic> topics = new ArrayList<> (Arrays.asList(
			new Topic("C++","C++ Course","C++ Course Description"),
			new Topic("Java","Core Java Course","Core Java Course Description"),
			new Topic("Python","Python Course","Python Course Description"),
			new Topic("Javascript","Javascript Course","Javascript Course Description")
			
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}

	public boolean addTopic(Topic topic) {
		boolean added = true;
		for(int i=0;i<topics.size();i++) {
			 Topic t= topics.get(i);
			 if(t.getName().equals(topic.getName())) {
				added = false;
				break;
				}
		}
		if(added==true)
			topics.add(topic);
		return added;
	
	}

	public boolean updateTopic(String id, Topic topic) {
		boolean updated = false;
		for(int i=0;i<topics.size();i++)
		{
			Topic t= topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				updated = true;
			}
		}
		return updated;
	}

	public boolean deleteTopic(String id) {
		boolean deleted = false;
		for(int i=0;i<topics.size();i++)
		{
			if(topics.removeIf(t->t.getId().equals(id)))
				deleted = true;
			
		}
		
		return deleted;
	}
}
