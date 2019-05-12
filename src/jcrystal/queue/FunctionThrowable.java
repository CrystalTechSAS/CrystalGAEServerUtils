package jcrystal.queue;

import java.io.Serializable;

public interface FunctionThrowable extends Serializable{
	void run() throws Exception;
}
