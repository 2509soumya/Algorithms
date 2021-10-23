package jupyter;

import java.util.*;

public class TaskSequence {

    static class Task{
        String name;
        List<String> dependencies;
        Task(String name,List<String> dependencies){
            this.name=name;
            this.dependencies=dependencies;
        }
    }

    Stack<String> dependencystack=new Stack<>();
    Map<String,List<String>> adjacencymap;
    Set<String> visitedset;

    public List<String> tasksequence(List<Task> dependencylist){
        visitedset=new HashSet<>();
        adjacencymap=new HashMap<>();

        for(Task currTask : dependencylist){
            List<String> dependencies=new ArrayList<>();
            for(String dependency : currTask.dependencies){
                dependencies.add(dependency);
            }
            adjacencymap.put(currTask.name,dependencies);
        }

        for(Task currTask : dependencylist){
            if(!visitedset.contains(currTask.name)){
                dfs(currTask.name);
            }
        }

        List<String> ans=new ArrayList<>();
        while(!dependencystack.isEmpty()){
            ans.add(dependencystack.pop());
        }
        Collections.reverse(ans);
        return ans;
    }

    public void dfs(String taskName){
        if(visitedset.contains(taskName)){
            return;
        }
        visitedset.add(taskName);
        for(String dependencies : adjacencymap.get(taskName)){
            dfs(dependencies);
        }
        dependencystack.push(taskName);
    }

    public static void main(String[] args) {
        TaskSequence taskSequence=new TaskSequence();
        List<String> ans=taskSequence.tasksequence(Arrays.asList(new Task("taskA",Arrays.asList("taskB","taskC")),new Task("taskB",Arrays.asList("taskD","taskC")),new Task("taskC",Arrays.asList("taskD","taskF")),new Task("taskD",Arrays.asList()),new Task("taskE",Arrays.asList()),new Task("taskF",Arrays.asList("taskE"))));
        System.out.println(ans.toString());
    }
}
