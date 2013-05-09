package framework.core.util;
import java.util.HashMap;
import java.util.Iterator;

public class HashMapExtensions
{

	public void prinHashTable(HashMap hashMap)
	{

		Iterator iterator = hashMap.keySet().iterator();// Iterate on keys
		// We can also Iterate on values how? i.e. your homework
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			String value = (String) hashMap.get(key);
			System.out.println(key + "\t\t: \t" + value);
		}
	}

}
