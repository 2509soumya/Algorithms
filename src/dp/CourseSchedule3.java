package dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseSchedule3 {

    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int lstart=0;
        int coursecount=0;

        for(int i=0;i<courses.length;i++){
           if(courses[i][1]-courses[i][0]>=lstart){
               coursecount++;
               lstart=lstart+courses[i][0];
               pq.add(courses[i][0]);
           }else{
               int topdurcourse=pq.peek();
               if(topdurcourse>courses[i][0]){
                   pq.poll();
                   pq.add(courses[i][0]);
               }
           }
        }
        return coursecount;
    }

    public static void main(String[] args) {
        CourseSchedule3 courseSchedule3=new CourseSchedule3();
        int totcourses=courseSchedule3.scheduleCourse(new int[][]{{3,2},{4,3}});
        System.out.println("Totalcourses : "+totcourses);
    }
}
