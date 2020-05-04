package tr.com.melihhilmiuludag.student.proj.utils;

import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

import java.util.*;

/**
 * @author muludag on 3.05.2020
 */
public class MapUtil {
	public static <K, V> TreeMap<K, V> sortByKeys(Map<K, V> unsortedMap) {
		TreeMap<K, V> treeMap = Maps.newTreeMap((Comparator<K>) Ordering.natural());
		treeMap.putAll(unsortedMap);
		return treeMap;
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue());

		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}
}
