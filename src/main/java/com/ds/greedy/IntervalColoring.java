package com.ds.greedy;

import java.util.*;

public class IntervalColoring {
    private List<Map.Entry<Integer, Integer>> intervals;
    private Map<Integer, List<Map.Entry<Integer, Integer>>> roomAllocation;

    private IntervalColoring() {
        intervals = new ArrayList<>();
        roomAllocation = new HashMap<>();
    }

    private void run() {
        // sort intervals by end time
        intervals.sort((o1, o2) -> o1.getValue() - o2.getValue());
        System.out.println(" Sorted Intervals : " + intervals);
        int roomCount = 1, idx = 0;
        allocateRoom(roomCount, intervals.remove(idx));
        while (!intervals.isEmpty()) {
            if(idx == intervals.size()) {
                roomCount++;
                idx = 0;
            }
            List<Map.Entry<Integer,Integer>> currentRoom = roomAllocation.get(roomCount);
            if(currentRoom == null || intervals.get(idx).getKey() >= currentRoom.get(currentRoom.size()-1).getValue()){
                // empty room OR next interval start time is greater than equal to current interval end time
                allocateRoom(roomCount,intervals.remove(idx));
            }else{
                // can not be allocated move to next interval
                idx++;
            }
        }
    }

    private void allocateRoom(int index, Map.Entry<Integer, Integer> interval) {
        List<Map.Entry<Integer, Integer>> allocationList = roomAllocation.getOrDefault(index, new ArrayList<>());
        allocationList.add(interval);
        roomAllocation.put(index,allocationList);
    }


    public static void main(String[] args) {
        IntervalColoring intervalColoring = new IntervalColoring();
        intervalColoring.intervals.add(new AbstractMap.SimpleEntry<>(1, 7));
        intervalColoring.intervals.add(new AbstractMap.SimpleEntry<>(1, 2));
        intervalColoring.intervals.add(new AbstractMap.SimpleEntry<>(2, 3));
        intervalColoring.intervals.add(new AbstractMap.SimpleEntry<>(4, 7));
        intervalColoring.intervals.add(new AbstractMap.SimpleEntry<>(1, 4));
        intervalColoring.intervals.add(new AbstractMap.SimpleEntry<>(5, 6));
        intervalColoring.intervals.add(new AbstractMap.SimpleEntry<>(6, 7));

        intervalColoring.run();

        System.out.println(intervalColoring.roomAllocation);
    }
}
