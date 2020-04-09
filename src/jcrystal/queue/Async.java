package jcrystal.queue;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.servlet.http.HttpServletRequest;

import jcrystal.utils.InternalException;

public class Async {

	public static void queue(FunctionThrowable task) {
		queue(0, task);
	}
	public static void queue(int waitTimeMillis, FunctionThrowable task) {
		com.google.appengine.api.taskqueue.Queue queue = com.google.appengine.api.taskqueue.QueueFactory.getQueue("jcrystal");
		com.google.appengine.api.taskqueue.TaskOptions $task = com.google.appengine.api.taskqueue.TaskOptions.Builder.withUrl("/jcrystal/async").method(com.google.appengine.api.taskqueue.TaskOptions.Method.POST);
		if(waitTimeMillis>0)
			$task=$task.countdownMillis(waitTimeMillis);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try(ObjectOutputStream oos = new ObjectOutputStream(baos)){
			oos.writeObject(task);
		}catch (Exception e) {
			throw new InternalException(500, "Can't add task to jCrystal Queue.", e);
		}
		$task=$task.payload(baos.toByteArray());
		queue.add(null, $task);
	}
	public static void dequeue(HttpServletRequest req) throws Exception{
		FunctionThrowable task;
		try(ObjectInputStream ois = new ObjectInputStream(req.getInputStream())){
			task = (FunctionThrowable)ois.readObject();
		}
		task.run();
	}
}
