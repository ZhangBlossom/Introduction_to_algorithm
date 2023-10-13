package datastructure.binary_search;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author: 张锦标
 * @date: 2023/10/13 10:03
 * _1146SnapShotArray类
 */
public class _1146SnapShotArray {
    class SnapshotArray {
        List<TreeMap<Integer, Integer>> arr = new ArrayList<>();
        int snap = 0;
        public SnapshotArray(int length) {
            for (int i=0; i<length; i++) {
                arr.add(new TreeMap<>());
            }
        }

        public void set(int index, int val) {
            TreeMap<Integer, Integer> tm = arr.get(index);
            tm.put(snap, val);
        }

        public int snap() {
            return snap++;
        }

        public int get(int index, int snap_id) {
            TreeMap<Integer, Integer> tm = arr.get(index);
            Integer key = tm.floorKey(snap_id);
            return key == null ? 0 : tm.get(key);
        }
    }

}
